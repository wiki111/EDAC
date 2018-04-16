import generators.Simple7BitSignalGenerator;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        byte[] signal = Simple7BitSignalGenerator.generateSignal(100);

        EvenParityBitControl evenParityBitControl = new EvenParityBitControl();
        evenParityBitControl.config(signal, 0.5f);
        evenParityBitControl.runSimulation();
        evenParityBitControl.printLogsToConsole();

    }
}
