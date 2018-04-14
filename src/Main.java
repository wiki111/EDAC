import generators.Simple7BitSignalGenerator;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        byte[] signal = Simple7BitSignalGenerator.generateSignal(3);

        for(byte b : signal){
            System.out.println("Generated signal " + Integer.toBinaryString(b & 255 | 256).substring(1));
        }

        EvenParityBitControl evenParityBitControl = new EvenParityBitControl(signal);

    }
}
