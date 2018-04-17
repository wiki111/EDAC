import algorithms.EDACAlgorithm;
import console.BasicConsoleResultPrinter;
import console.ConsoleResultPrinter;
import generators.DisruptionGenerator;
import generators.SignalGenerator;

public class SimulationRunner {

    private EDACAlgorithm algorithm;
    private SignalGenerator signalGenerator;
    private DisruptionGenerator disruptionGenerator;
    private ConsoleResultPrinter resultPrinter;

    public SimulationRunner(EDACAlgorithm algorithm, SignalGenerator signalGenerator, DisruptionGenerator disruptionGenerator) {
        this.algorithm = algorithm;
        this.signalGenerator = signalGenerator;
        this.disruptionGenerator = disruptionGenerator;
        this.resultPrinter = new BasicConsoleResultPrinter();
    }

    public void runSimulation(){

        algorithm.decode(
                disruptionGenerator.disrupt(
                        algorithm.encode(
                                signalGenerator.generateSignal()
                        )
                )
        );

        resultPrinter.printBasicResults(
                algorithm.getOriginalInput(),
                algorithm.getEncodedData(),
                algorithm.getReceivedData(),
                algorithm.getDecodedData(),
                algorithm.getErrorsCount(),
                algorithm.getErrors());
    }

}
