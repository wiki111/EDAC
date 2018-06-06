package generators;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class BitDisruptionGenerator implements DisruptionGenerator {

    private int numberOfBitsToDisrupt = 0;
    private byte[] disruptedSignal;
    private int createdErrors = 0;
    private ArrayList<Integer> pickedBytes;

    public void setNumberOfBitsToDisrupt(int numberOfBitsToDisrupt) {
        this.numberOfBitsToDisrupt = numberOfBitsToDisrupt;
    }

    @Override
    public byte[] disrupt(byte[] signal) {

        byte[] input = signal.clone();
        createdErrors = 0;

        ArrayList<Integer> bytesToDisrupt = pickRandomBytesToDisrupt(numberOfBitsToDisrupt, input.length);

        for(Integer position : bytesToDisrupt){
            input[position] = disruptBit(input[position]);
        }

        return input;
    }

    private byte disruptBit(byte b) {

        int randomBit = ThreadLocalRandom.current().nextInt(1, 8);

        int randomBitValue = (b >> randomBit) & 0x01;

        if(randomBitValue == 1){
            b = (byte) (b & ~(1 << randomBit));
        }else{
            b = (byte) (b | (1 << randomBit));
        }

        createdErrors++;

        return b;
    }

    private ArrayList<Integer> pickRandomBytesToDisrupt(float amount, int total){
        int numberOfBytes = Math.round(amount);
        pickedBytes = new ArrayList<>();
        for(int i = 0; i < numberOfBytes ; i++){
            int randomByteIndex = ThreadLocalRandom.current().nextInt(0, total);
            pickedBytes.add(randomByteIndex);
        }
        return pickedBytes;
    }

    @Override
    public byte[] getDisruptedSignal() {
        return disruptedSignal;
    }

    @Override
    public int getNumberOfCreatedErrors() {
        return createdErrors;
    }

    @Override
    public Map<Integer, ArrayList<Integer>> getDisruptedBits() {
        return null;
    }
}
