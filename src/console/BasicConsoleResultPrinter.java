package console;

import simulation.Simulation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class BasicConsoleResultPrinter implements ConsoleResultPrinter{

    private Simulation simulation;

    public BasicConsoleResultPrinter(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public void printBasicResults() {

        String workingString = "";

        System.out.println("-----------------Simulation Results---------------------");

        System.out.println("Input signal : ");
        for(byte b : simulation.getInput()){
            workingString += Integer.toBinaryString(b & 255 | 256).substring(1) + "\n";
        }
        System.out.println(workingString);

        System.out.println("\n Encoded signal : ");
        workingString = "";
        for(byte b : simulation.getEncoded()){
            workingString += Integer.toBinaryString(b & 255 | 256).substring(1) + "\n";
        }
        System.out.println(workingString);

        System.out.println("\n Disrupted signal : ");
        workingString = "";
        for(byte b : simulation.getDisrupted()){
            workingString += Integer.toBinaryString(b & 255 | 256).substring(1) + "\n";
        }
        System.out.println(workingString);

        System.out.println("Disrupted bits control log : ");
        if(simulation.getDisruptedBits() != null){
            Iterator it = simulation.getDisruptedBits().entrySet().iterator();
            while (it.hasNext()){
                Map.Entry entry = (Map.Entry) it.next();
                for ( Integer bit : (ArrayList<Integer>) entry.getValue() ) {
                    System.out.println("Disrupted bit " + bit + " of byte " + entry.getKey());
                }
            }
        }


        System.out.println("\n Decoded signal : ");
        workingString = "";
        for(byte b : simulation.getDecoded()){
            workingString += Integer.toBinaryString(b & 255 | 256).substring(1) + "\n";
        }
        System.out.println(workingString);

        boolean isDecodedTheSameAsInput = true;

        int i = 0;

        for (byte b : simulation.getInput()){
            if(b != simulation.getDecoded()[i]){
                isDecodedTheSameAsInput = false;
            }
            i++;
        }

        if(isDecodedTheSameAsInput){
            System.out.println("[INFO] Decoded signal is the same as input.");
        }else {
            System.out.println("[WARNING] Decoded signal is NOT the same as input. (!!!)");
        }


        System.out.println("\n Errors : ");
        System.out.println("Number of detected errors : " + simulation.getNumberOfErrorsDetected());
        System.out.println("Actual number of errors : " + simulation.getActualNumberOfErrors());
        System.out.println("Algorithm error detection effectiveness : " + simulation.getErrorDetectedToActualRatio() * 100 + "%");
        System.out.println("Error logs registered by algorithm while decoding : ");
        System.out.println(simulation.getErrorLog());
    }
}
