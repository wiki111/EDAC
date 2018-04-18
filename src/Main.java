import algorithms.CyclicRedundancyCheck16Bit;
import algorithms.EDACAlgorithm;
import algorithms.EvenParityBitControl;
import generators.DisruptionGenerator;
import generators.SignalGenerator;
import generators.Simple7BitSignalGenerator;
import generators.SimpleDisruptionGenerator;
import simulation.SimulationRunner;

public class Main {

    public static void main(String[] args) {

        /*
        EvenParityBitControl evenParityBitControl = new EvenParityBitControl();
        evenParityBitControl.config(signal, 0.5f);
        evenParityBitControl.runSimulation();
        evenParityBitControl.printLogsToConsole();


        CyclicRedundancyCheck16Bit crc16 = new CyclicRedundancyCheck16Bit();

        byte[] dataForCrc16 = new byte[]{0x05};

        crc16.computeCRCFor(dataForCrc16);

        System.out.println(crc16.getCalculatedCRC());
        System.out.println(String.format("0x%08X", crc16.getCalculatedCRC()));
        */
        /*
        SignalGenerator signalGenerator = new Simple7BitSignalGenerator(3);
        DisruptionGenerator disruptionGenerator = new SimpleDisruptionGenerator();
        EDACAlgorithm algorithm = new EvenParityBitControl();

        SimulationRunner runner = new SimulationRunner(algorithm, signalGenerator, disruptionGenerator);
        runner.runSimulation();
        */

        CyclicRedundancyCheck16Bit crc16 = new CyclicRedundancyCheck16Bit();
        crc16.computeCRCWithLookupTableFor(new byte[]{0x01, 0x02});

    }
}
