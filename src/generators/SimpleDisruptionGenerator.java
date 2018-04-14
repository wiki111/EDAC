package generators;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SimpleDisruptionGenerator {

    private byte[] disruptedSignal;

    public SimpleDisruptionGenerator(byte[] signal) {
        disruptSignal(signal);
    }

    private void disruptSignal(byte[] signal){
        int randomBit;
        ArrayList<Integer> bytesToDisrupt = pickRandomBytesToDisrupt(signal.length/3, signal.length);

        for(byte b: signal){
            System.out.println("Input signal " + Integer.toBinaryString(b & 255 | 256).substring(1));
        }

        for(int i = 0; i < signal.length; i++){
            if(bytesToDisrupt.contains(i)){
                signal[i] = disrupt(signal[i]);
            }
        }
        this.disruptedSignal = signal;
    }

    private ArrayList<Integer> pickRandomBytesToDisrupt(int amount, int total){
        ArrayList<Integer> pickedBytes = new ArrayList<>();
        for(int i = 0; i < amount ; i++){
            int randomByteIndex = ThreadLocalRandom.current().nextInt(1, total);
            pickedBytes.add(randomByteIndex);
        }
        return pickedBytes;
    }

    private byte disrupt(byte b){
        int randomBit1 =  ThreadLocalRandom.current().nextInt(1, 8);
        b = (byte) (b | (1 << randomBit1));
        int randomBit2 = ThreadLocalRandom.current().nextInt(1, 8);
        b = (byte) (b & ~(1 << randomBit2));
        System.out.println("Disrupted byte (random or was : " + randomBit1 +
                " and \n random and was : "
                + randomBit2 +  " ) " + Integer.toBinaryString(b & 255 | 256).substring(1));
        return b;
    }

    public byte[] getDisruptedSignal() {
        return disruptedSignal;
    }
}
