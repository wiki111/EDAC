package algorithms;

import utilities.ByteIterable;
import java.util.ArrayList;
import java.util.Iterator;

public class EvenParityBitControl implements EDACAlgorithm{

    private int errorsDetectedNumber = 0;

    private String errorsLog = "";

    private final static String PARITY_CHECK_ERROR = "[PARITY ERROR]";

    @Override
    public byte[] encode(byte[] inputData) {
        return addParityBit(inputData);
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

        ArrayList<Byte> decodedBytes = new ArrayList<>();

        for(int i = 0; i < receivedData.length; i++){
            if(!countOnesAndCheckIfEven(receivedData[i])){
                reportError("Bit count not correct. Transmission error was detected on byte " + (i+1) + " of received data. \n ");
            }else{
                decodedBytes.add(stripParityBit(receivedData[i]));
            }
        }

        return  byteArrayObjectToPrimitive(decodedBytes.toArray(new Byte[decodedBytes.size()]));
    }

    private void reportError(String message){
        errorsLog += PARITY_CHECK_ERROR + " There was an error : " + message;
        errorsDetectedNumber++;
    }

    private byte stripParityBit(byte sample){
        return (byte) (sample & ~(1 << 7));
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

}
