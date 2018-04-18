package simulation;

import algorithms.EDACAlgorithm;
import console.BasicConsoleResultPrinter;
import console.ConsoleResultPrinter;
import generators.DisruptionGenerator;
import generators.SignalGenerator;

public class SimulationRunner {

    private EDACAlgorithm algorithm;
    private SignalGenerator signalGenerator;
    private DisruptionGenerator disruptionGenerator;

    public SimulationRunner(EDACAlgorithm algorithm, SignalGenerator signalGenerator, DisruptionGenerator disruptionGenerator) {
        this.algorithm = algorithm;
        this.signalGenerator = signalGenerator;
        this.disruptionGenerator = disruptionGenerator;
    }

    public void runSimulation(){

        Simulation simulation = new Simulation();
        byte[] temp;

        temp = signalGenerator.generateSignal();
        simulation.setInput(temp);

        temp = algorithm.encode(temp);
        simulation.setEncoded(temp);

        temp = disruptionGenerator.disrupt(temp);
        simulation.setDisrupted(temp);
        simulation.setActualNumberOfErrors(disruptionGenerator.getNumberOfCreatedErrors());
        simulation.setDisruptedBits(disruptionGenerator.getDisruptedBits());

        temp = algorithm.decode(temp);
        simulation.setDecoded(temp);
        simulation.setNumberOfErrorsDetected(algorithm.getErrorsCount());
        simulation.setErrorLog(algorithm.getErrors());

        ConsoleResultPrinter consoleResultPrinter = new BasicConsoleResultPrinter(simulation);
        consoleResultPrinter.printBasicResults();
    }

}
