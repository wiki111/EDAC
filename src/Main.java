import algorithms.CyclicRedundancyCheck16Bit;
import algorithms.CyclicRedundancyCheck32Bit;
import algorithms.EDACAlgorithm;
import algorithms.EvenParityBitControl;
import generators.*;
import simulation.Simulation;
import simulation.SimulationRunner;

public class Main {

    public static void main(String[] args) {

        /*
        SignalGenerator signalGenerator = new Simple7BitSignalGenerator(3);
        DisruptionGenerator disruptionGenerator = new SimpleDisruptionGenerator();
        EDACAlgorithm algorithm = new EvenParityBitControl();

        SimulationRunner runner = new SimulationRunner(algorithm, signalGenerator, disruptionGenerator);
        runner.runSimulation();
        */

       /*
        SignalGenerator signalGenerator = new Simple7BitSignalGenerator(2);
        DisruptionGenerator disruptionGenerator = new BlankDisruptionGenerator();
        EDACAlgorithm algorithm = new CyclicRedundancyCheck32Bit("crc32");
        SimulationRunner runner = new SimulationRunner(algorithm, signalGenerator, disruptionGenerator);
        runner.runSimulation();
        */

       int k = 6;
       String s = Integer.toBinaryString(k);
       int y = Integer.parseInt(s);
        int x = ((Integer.parseInt(s))/((int) Math.pow(10, 1)))%10;

    }
}
