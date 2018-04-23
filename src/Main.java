import algorithms.*;
import generators.*;
import simulation.Simulation;
import simulation.SimulationRunner;

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

        SignalGenerator signalGenerator = new Simple7BitSignalGenerator(100);
        DisruptionGenerator disruptionGenerator = new BlankDisruptionGenerator();
        EDACAlgorithm algorithm = new HammingCode();


        SimulationRunner runner = new SimulationRunner(algorithm, signalGenerator, disruptionGenerator);
        runner.runSimulation();

    }
}
