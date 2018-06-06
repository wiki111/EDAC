import graphic_interface.Panel;

public class Main {

    public static void main(String[] args) {

        /*
        //Parity Control test configuration.

        SignalGenerator signalGenerator = new Simple7BitSignalGenerator(3);
        DisruptionGenerator disruptionGenerator = new SimpleDisruptionGenerator();
        EDACAlgorithm algorithm = new EvenParityBitControl();
        */

        /*
        //CRC test configuration

        SignalGenerator signalGenerator = new Simple7BitSignalGenerator(2);
        DisruptionGenerator disruptionGenerator = new BlankDisruptionGenerator();
        EDACAlgorithm algorithm = new CyclicRedundancyCheck32Bit("crc32");

        */

        //Hamming Code test configuration

        /*SignalGenerator signalGenerator = new Simple7BitSignalGenerator(10);
        DisruptionGenerator disruptionGenerator = new OneBitDisruptionGenerator();
        EDACAlgorithm algorithm = new HammingCode();


        //Running the simulation :
        SimulationRunner runner = new ConsoleSimulationRunner(algorithm, signalGenerator, disruptionGenerator);
        runner.runSimulation();*/

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });

    }
}
