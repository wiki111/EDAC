package generators;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SimpleDisruptionGenerator {

    private byte[] disruptedSignal;
    private float disruptionPotency = 3;
    private byte[] signal;
    private int numberOfAffectedBytes = 0;
    private int numberOfCreatedErrors = 0;

    public SimpleDisruptionGenerator() {
    }

    public int getNumberOfAffectedBytes() {
        return numberOfAffectedBytes;
    }

    public int getNumberOfCreatedErrors() {
        return numberOfCreatedErrors;
    }

    public void setDisruptionPotency(float disruptionPotency) {
        this.disruptionPotency = disruptionPotency;
    }

    public void setSignal(byte[] signal) {
        this.signal = signal;
    }

    public void disruptSignal(){
        int randomBit;
        ArrayList<Integer> bytesToDisrupt = pickRandomBytesToDisrupt(signal.length * disruptionPotency, signal.length);

       /* for(byte b: signal){
            System.out.println("Input signal " + Integer.toBinaryString(b & 255 | 256).substring(1));
        } */

        for(int i = 0; i < signal.length; i++){
            if(bytesToDisrupt.contains(i)){
                signal[i] = disrupt(signal[i]);
            }
        }
        this.disruptedSignal = signal;
    }

    private ArrayList<Integer> pickRandomBytesToDisrupt(float amount, int total){
        int numberOfBytes = Math.round(amount);
        ArrayList<Integer> pickedBytes = new ArrayList<>();
        for(int i = 0; i < numberOfBytes ; i++){
            int randomByteIndex = ThreadLocalRandom.current().nextInt(0, total);
            pickedBytes.add(randomByteIndex);
        }
        return pickedBytes;
    }

    private byte disrupt(byte b){

        boolean createdError = true;

        byte disruptedByte = b;

        int randomBit1 =  ThreadLocalRandom.current().nextInt(1, 8);
        disruptedByte = (byte) (disruptedByte | (1 << randomBit1));


        int randomBit2 = ThreadLocalRandom.current().nextInt(1, 8);
        disruptedByte = (byte) (disruptedByte & ~(1 << randomBit2));

        if(disruptedByte == b){
            createdError = false;
        }

        if(!createdError){
            System.out.println(
                    "[BYTE AFFECTED] Affected byte (random OR was : "
                            + randomBit1
                            + " and random AND was : "
                            + randomBit2
                            +  " ) - original byte : "
                            + Integer.toBinaryString(b & 255 | 256).substring(1)
                            + " affected byte : "
                            + Integer.toBinaryString(disruptedByte & 255 | 256).substring(1)
            );
        }else{
            System.out.println(
                    "[DISRUPTION GENERATED] Disrupted byte (random OR was : "
                            + randomBit1
                            + " and random AND was : "
                            + randomBit2
                            +  " ) "
                            + Integer.toBinaryString(disruptedByte & 255 | 256).substring(1)
            );
            numberOfCreatedErrors++;
        }

        numberOfAffectedBytes++;



        return disruptedByte;
    }

    public byte[] getDisruptedSignal() {
        return disruptedSignal;
    }
}
