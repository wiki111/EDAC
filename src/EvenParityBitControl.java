import generators.SimpleDisruptionGenerator;
import utilities.ByteArrayIterable;
import utilities.ByteIterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EvenParityBitControl {

    private Byte[] encodedData;
    private byte[] inputData;
    private byte[] disruptedData;
    private byte[] decodedData;
    private boolean errorDetected;
    private int errorsDetectedNumber = 0;

    private SimpleDisruptionGenerator simpleDisruptionGenerator;

    private String errors = "";

    private final static String PARITY_CHECK_ERROR = "[PARITY ERROR]";
    private final static String PARITY_CHECK_CLEAR = "[PARITY CHECK CLEAR] No parity errors detected.";

    public EvenParityBitControl() {
        errorDetected = false;
        simpleDisruptionGenerator = new SimpleDisruptionGenerator();
    }

    public void config(byte[] inputData){
        this.inputData = inputData;
    }

    public void config(byte[] inputData, float transmitionDisruptionPotency){
        this.inputData = inputData;
        simpleDisruptionGenerator.setDisruptionPotency(transmitionDisruptionPotency);
    }

    public void runSimulation(){
        //prepareData(inputData); -> this step was needed for 8-bit data case
        encodeData();
        sendSignal();
        decodeData();
    }

    public void runMultipleSimulations(int times){
        for(int i = 0; i < times; i++){
            runSimulation();
        }
    }

    private void sendSignal(){
        simpleDisruptionGenerator.setSignal(byteArrayObjectToPrimitive(encodedData));
        simpleDisruptionGenerator.disruptSignal();
        this.disruptedData = simpleDisruptionGenerator.getDisruptedSignal();
    }

    private void prepareData(byte[] data){

        ByteArrayIterable iterable = new ByteArrayIterable(data);
        Iterator<Boolean> byteIterator = iterable.iterator();

        List<Byte> convertedData = new ArrayList<>();

        while(byteIterator.hasNext()){

            byte currentByteProcessed = 0;
            byte bitToAdd;

            //System.out.println("Current byte processed on start: " + Integer.toBinaryString(currentByteProcessed & 255 | 256).substring(1));

            for(int i = 6; i >= 0; i--){
                if(byteIterator.hasNext()){
                    if(byteIterator.next()){
                        bitToAdd = 1;
                    }else{
                        bitToAdd = 0;
                    }
                    currentByteProcessed = (byte) (currentByteProcessed | (bitToAdd << i));
                    //System.out.println("Current byte processed : " + Integer.toBinaryString(currentByteProcessed & 255 | 256).substring(1));
                }
            }

            System.out.println("Current byte processed on finish: " + Integer.toBinaryString(currentByteProcessed & 255 | 256).substring(1));
            convertedData.add(currentByteProcessed);
        }

        encodedData = convertedData.toArray(new Byte[convertedData.size()]);
    }

    private void encodeData(){

        byte[] primitiveEncodedDataArray = byteArrayObjectToPrimitive(byteArrayPrimitiveToObject(inputData));

        for (int i = 0; i < primitiveEncodedDataArray.length; i++) {
            addParityBit(primitiveEncodedDataArray);
        }

        this.encodedData = byteArrayPrimitiveToObject(primitiveEncodedDataArray);

    }

    private String getEncodedSignalRepresentation(){

        String encodedSignalString = "";

        for(Byte b : this.encodedData){
            encodedSignalString += "\n" + Integer.toBinaryString(b & 255 | 256).substring(1);
        }

        return encodedSignalString;
    }

    private void addParityBit(byte[] data){

        for(int i = 0; i < data.length; i++){
            if(!countOnesAndCheckIfEven(data[i])){
                data[i] = (byte) (data[i] | (1 << 7));
            }
        }
    }

    private boolean countOnesAndCheckIfEven(byte data){

        int numberOfOnes = 0;

        ByteIterable iterable = new ByteIterable(data);
        Iterator<Boolean> bitIterator = iterable.iterator();
        while (bitIterator.hasNext()){
            if(bitIterator.next()){
                numberOfOnes++;
            }
        }

        if(numberOfOnes%2 == 0){
            return true;
        }else{
            return false;
        }

    }

    private byte[] byteArrayObjectToPrimitive(Byte[] bytes){
        byte[] primitive = new byte[bytes.length];
        int j=0;
        for(Byte b: bytes)
            primitive[j++] = b.byteValue();
        return primitive;
    }

    private Byte[] byteArrayPrimitiveToObject(byte[] bytes){
        Byte[] object = new Byte[bytes.length];
        int j = 0;
        for(byte b : bytes){
            object[j++] = b;
        }
        return object;
    }

    private void decodeData(){
        byte[] receivedData = disruptedData;

        ArrayList<Byte> decodedBytes = new ArrayList<>();

        for(int i = 0; i < receivedData.length; i++){
            if(!countOnesAndCheckIfEven(receivedData[i])){
                reportError("Bit count not correct. Transmission error was detected on byte " + (i+1) + " of received data. \n ");
                errorDetected = true;
            }else{
                decodedBytes.add(stripParityBit(receivedData[i]));
            }
        }

        decodedData = byteArrayObjectToPrimitive(decodedBytes.toArray(new Byte[decodedBytes.size()]));


    }

    private String getDecodedDataRepresentation(){

        String decodedDataString = "";

        for(byte b : decodedData){
            decodedDataString += Integer.toBinaryString(b & 255 | 256).substring(1) + "\n";
        }

        return decodedDataString;
    }

    private byte stripParityBit(byte sample){
        return (byte) (sample & ~(1 << 7));
    }

    private void reportError(String message){
        errors += PARITY_CHECK_ERROR + " There was an error : " + message;
        errorsDetectedNumber++;
    }

    public void printLogsToConsole(){
        System.out.println("-----------------Simulation Results---------------------");
        System.out.println("Input signal : ");
        System.out.println(getInputSignalRepresentation());
        System.out.println("\n Encoded signal : ");
        System.out.println(getEncodedSignalRepresentation());
        System.out.println("\n Decoded signal : ");
        System.out.println(getDecodedDataRepresentation());
        System.out.println("\n Errors : ");
        if(errorDetected){
            System.out.println(errors);
        }else {
            System.out.println(PARITY_CHECK_CLEAR + "No parity errors detected.");
        }
        System.out.println(" Effectiveness of error detection : " + calculateErrorToDetectedRatio()*100 + "% ");
        System.out.println("Number of changed bytes : " + simpleDisruptionGenerator.getNumberOfAffectedBytes());
        System.out.println("Number of created errors : " + simpleDisruptionGenerator.getNumberOfCreatedErrors());
        System.out.println("Number of detected errors : " + errorsDetectedNumber);
    }

    private float calculateErrorToDetectedRatio(){
        return (float) errorsDetectedNumber/ (float) simpleDisruptionGenerator.getNumberOfCreatedErrors();
    }

    private String getInputSignalRepresentation(){

        String inputDataString = "";

        for(byte b : inputData){
            inputDataString += Integer.toBinaryString(b & 255 | 256).substring(1) + "\n";
        }

        return inputDataString;
    }
}
