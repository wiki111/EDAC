package algorithms;

import utilities.ByteIterable;
import java.util.ArrayList;
import java.util.Iterator;

public class EvenParityBitControl implements EDACAlgorithm{

    private byte[] encodedData;
    private byte[] inputData;
    private byte[] receivedData;
    private byte[] decodedData;
    private int errorsDetectedNumber = 0;

    private boolean errorDetected;

    private String errorsLog = "";

    private final static String PARITY_CHECK_ERROR = "[PARITY ERROR]";
    private final static String PARITY_CHECK_CLEAR = "[PARITY CHECK CLEAR] No parity errors detected.";

    public EvenParityBitControl() {
        errorDetected = false;
    }

    @Override
    public byte[] encode(byte[] inputData) {
        this.inputData = inputData.clone();
        this.encodedData = addParityBit(inputData);
        return encodedData;
    }

    private byte[] addParityBit(byte[] data){
        for(int i = 0; i < data.length; i++){
            if(!countOnesAndCheckIfEven(data[i])){
                data[i] = (byte) (data[i] | (1 << 7));
            }
        }
        return data;
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

    @Override
    public byte[] decode(byte[] receivedData) {

        this.receivedData = receivedData.clone();

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

        return decodedData;
    }

    private void reportError(String message){
        errorsLog += PARITY_CHECK_ERROR + " There was an error : " + message;
        errorsDetectedNumber++;
    }

    private byte stripParityBit(byte sample){
        return (byte) (sample & ~(1 << 7));
    }

    @Override
    public byte[] getOriginalInput() {
        return inputData;
    }

    @Override
    public byte[] getEncodedData() {
        return encodedData;
    }

    @Override
    public byte[] getReceivedData() {
        return receivedData;
    }

    @Override
    public byte[] getDecodedData() {
        return decodedData;
    }

    @Override
    public String getErrors() {
        return errorsLog;
    }

    @Override
    public int getErrorsCount() {
        return errorsDetectedNumber;
    }

    @Override
    public int getCorrectedErrorsCount() {
        return 0;
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


    //------------------- STUFF TO RELOCATE, REUSE PARTS SOMEWHERE ELSE, OR DELETE -------------------


    /*
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
    */

    private String getEncodedSignalRepresentation(){

        String encodedSignalString = "";

        for(Byte b : this.encodedData){
            encodedSignalString += "\n" + Integer.toBinaryString(b & 255 | 256).substring(1);
        }

        return encodedSignalString;
    }

    private String getDecodedDataRepresentation(){

        String decodedDataString = "";

        for(byte b : decodedData){
            decodedDataString += Integer.toBinaryString(b & 255 | 256).substring(1) + "\n";
        }

        return decodedDataString;
    }





    public void printLogsToConsole(){

    }



    private String getInputSignalRepresentation(){

        String inputDataString = "";

        for(byte b : inputData){
            inputDataString += Integer.toBinaryString(b & 255 | 256).substring(1) + "\n";
        }

        return inputDataString;
    }


}
