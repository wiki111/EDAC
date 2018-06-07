package simulation;

import algorithms.*;
import generators.BitDisruptionGenerator;
import generators.SignalGenerator;
import generators.Simple7BitSignalGenerator;

public class GuiSimulationRunner {

    private EDACAlgorithm algorithm;
    private SignalGenerator signalGenerator;
    private BitDisruptionGenerator disruptionGenerator;

    private String original;
    private String encoded;
    private String disrupted;
    private String decoded;
    private String previousAlgorithm;

    private boolean decodedContainsErrorLog = false;

    private int overallNumberOfErrors = 0;

    public GuiSimulationRunner(){
        this.algorithm = null;
        this.signalGenerator = null;
        this.disruptionGenerator = null;
    }

    public String getOriginal() {
        return addSpaces(original);
    }

    public String getEncoded() {
        return addSpaces(encoded);
    }

    public String getDisrupted() {
        return addSpaces(disrupted);
    }

    public String getDecoded() {
        if(!decodedContainsErrorLog){
            return addSpaces(decoded);
        }else{
            return decoded;
        }
    }

    public String getNumberOfEncodedBits(){
        return String.valueOf(encoded.length());
    }

    public String getNumberOfDetectedErrors(){
        return String.valueOf(algorithm.getErrorsCount());
    }

    public String getNumberOfUndetectedErrors(){
        if(overallNumberOfErrors == 0){
            return "?";
        }else{
            if((overallNumberOfErrors - algorithm.getErrorsCount()) >= 0){
                return String.valueOf((overallNumberOfErrors - algorithm.getErrorsCount()));
            }else{
                return "?";
            }
        }
    }

    public String getRedundantBitsNumber(){
        return String.valueOf(getNumberOfRedundantBits());
    }

    public String getNumberOfCorrectedErrors(){
        return String.valueOf(algorithm.getCorrectedErrorsCount());
    }

    private int getNumberOfRedundantBits(){
        return encoded.length() - original.length();
    }

    public void setAlgorithm(String algorithm) {

        previousAlgorithm = algorithm;

        switch (algorithm){
            case "crc16" :
                this.algorithm = new CyclicRedundancyCheck16Bit("crc16");
                break;
            case "sdlc" :
                this.algorithm = new CyclicRedundancyCheck16Bit("sdlc");
                break;
            case "sdlc reverse" :
                this.algorithm = new CyclicRedundancyCheck16Bit("sdlc reverse");
                break;
            case "crc32" :
                this.algorithm = new CyclicRedundancyCheck32Bit("crc32");
                break;
            case "parity" :
                this.algorithm = new EvenParityBitControl();
                break;
            case "hamming" :
                this.algorithm = new HammingCode();
                break;
        }

    }

    public void encode(String byteString){
        this.original = removeSpaces(byteString);
        byte[] bytes = parseStringToBytes(byteString);
        this.encoded = bytesToString(algorithm.encode(bytes));
    }

    public String generate(int amount){
        String generatedBytesString = "";

        signalGenerator = new Simple7BitSignalGenerator();
        signalGenerator.setSignalLength(amount);

        byte[] generatedBytesArray = signalGenerator.generateSignal();

        for(byte b : generatedBytesArray){
            generatedBytesString += Integer.toBinaryString(b & 255 | 256).substring(1) + " ";
        }

        return generatedBytesString;
    }

    public void decode(String bytesString){
        this.disrupted = removeSpaces(bytesString);
        byte[] decodedBytesArray = this.algorithm.decode(parseStringToBytes(bytesString));
        if(decodedBytesArray != null){
            decoded = bytesToString(decodedBytesArray);
        }else{
            decodedContainsErrorLog = true;
            decoded = "[ERROR] Decoding unsuccessful";
        }
    }

    public void disrupt(String bytesString, int amount){
        if(amount != 0){
            disruptionGenerator = new BitDisruptionGenerator();
            disruptionGenerator.setNumberOfBitsToDisrupt(amount);
            byte[] bytesArray = disruptionGenerator.disrupt(parseStringToBytes(bytesString));
            overallNumberOfErrors = disruptionGenerator.getNumberOfCreatedErrors();
            this.disrupted = bytesToString(bytesArray);
        }else{
            this.disrupted = removeSpaces(bytesString);
        }
    }

    public void resetRunner(){
        this.encoded = "";
        this.decoded = "";
        this.disrupted = "";
        this.original = "";
        overallNumberOfErrors = 0;
        this.setAlgorithm(previousAlgorithm);
        this.signalGenerator = null;
        this.disruptionGenerator = null;
        decodedContainsErrorLog = false;
    }

    private byte[] parseStringToBytes(String byteString){

        byteString = removeSpaces(byteString);

        int arrayLength = 0;

        if((byteString.length()%8) == 0){
            arrayLength = byteString.length()/8;
        }else {
            arrayLength = byteString.length()/8 + 1;
        }

        byte[] bytes = new byte[arrayLength];
        char[] symbols = byteString.toCharArray();

        int bitCounter = 0;
        int byteCounter = 0;
        bytes[byteCounter] = 0;

        for(int i = 0; i < symbols.length ; i++){

            if(bitCounter == 8){
                byteCounter++;
                bitCounter = 0;
                bytes[byteCounter] = 0;
            }

            if(Integer.parseInt(String.valueOf(symbols[i])) == 1){
                bytes[byteCounter] = (byte)(bytes[byteCounter] | (1 << (7 - bitCounter) ));
            }

            bitCounter++;
        }

        String test = bytesToString(bytes);

        return bytes;
    }

    private String bytesToString(byte[] bytes){
        String generatedBits = "";

        for(int i = 0; i < bytes.length; i++){
            generatedBits += Integer.toBinaryString(bytes[i] & 255 | 256).substring(1);
        }

        return generatedBits;
    }

    private String addSpaces(String bytesString){
        String stringWithSpaces = "";

        char[] bytesCharArray = bytesString.toCharArray();

        int toEightCounter = 0;

        for(int i = 0; i < bytesCharArray.length; i++){

            if(toEightCounter == 8){
                toEightCounter = 0;
                stringWithSpaces += " ";
            }

            stringWithSpaces += String.valueOf(bytesCharArray[i]);

            toEightCounter++;
        }

        return stringWithSpaces;

    }

    private String removeSpaces(String text){
        return text.replaceAll("\\s+","");
    }

}
