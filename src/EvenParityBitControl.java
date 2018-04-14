import generators.SimpleDisruptionGenerator;
import utilities.ByteArrayIterable;
import utilities.ByteIterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EvenParityBitControl {

    private byte[] originalData;
    private Byte[] encodedData;
    private String failuresLog;

    public EvenParityBitControl(byte[] inputData) {
        this.originalData = inputData;
        encodedData = byteArrayPrimitiveToObject(inputData);
        //prepareData(inputData); -> this step was needed for 8-bit data case
        encodeData();
        sendSignal();
    }

    public Byte[] getEncodedDataObject() {
        return encodedData;
    }

    public byte[] getEncodedDataPrimitive(){
        return byteArrayObjectToPrimitive(encodedData);
    }

    public byte[] getOriginalData() {
        return originalData;
    }

    private void sendSignal(){
        SimpleDisruptionGenerator simpleDisruptionGenerator = new SimpleDisruptionGenerator(byteArrayObjectToPrimitive(encodedData));
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

        int numberOfOnes = 0;

        byte[] primitiveEncodedDataArray = byteArrayObjectToPrimitive(encodedData);

        for (int i = 0; i < primitiveEncodedDataArray.length; i++) {
            ByteIterable iterable = new ByteIterable(primitiveEncodedDataArray[i]);
            Iterator<Boolean> bitIterator = iterable.iterator();
            while (bitIterator.hasNext()){
                if(bitIterator.next()){
                    numberOfOnes++;
                }
            }
            if((numberOfOnes%2 != 0) && (numberOfOnes != 0)){
                primitiveEncodedDataArray[i] = (byte) (primitiveEncodedDataArray[i] | (1 << 7));
            }
            numberOfOnes = 0;
            //System.out.println("Encoded byte from loop " + Integer.toBinaryString(primitiveEncodedDataArray[i] & 255 | 256).substring(1));
        }

        this.encodedData = byteArrayPrimitiveToObject(primitiveEncodedDataArray);

        for(Byte b : this.encodedData){
            System.out.println("Encoded Byte " + Integer.toBinaryString(b & 255 | 256).substring(1));
        }

        for(byte b : primitiveEncodedDataArray){
            //System.out.println("Encoded byte " + Integer.toBinaryString(b & 255 | 256).substring(1));
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

    }
}
