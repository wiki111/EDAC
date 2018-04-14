package generators;

import java.util.Random;

public class Simple7BitSignalGenerator {

    private static byte[] generatedSignal;

    public static byte[] generateSignal(int numberOfBytes){
        generatedSignal = new byte[numberOfBytes];
        new Random().nextBytes(generatedSignal);

        for(int i = 0; i < generatedSignal.length; i++){
            generatedSignal[i] = (byte)(generatedSignal[i] & ~(1 << 7));
        }

        return generatedSignal;
    }

    public static byte[] getGeneratedSignal() {
        if(generatedSignal == null){
            generateSignal(3);
        }
        return generatedSignal;
    }
}
