package console;

public class BasicConsoleResultPrinter implements ConsoleResultPrinter{
    @Override
    public void printBasicResults(byte[] input, byte[] encoded, byte[] disrupted, byte[] decoded, int errorsNumber, String errors) {

        String workingString = "";

        System.out.println("-----------------Simulation Results---------------------");

        System.out.println("Input signal : ");
        for(byte b : input){
            workingString += Integer.toBinaryString(b & 255 | 256).substring(1) + "\n";
        }
        System.out.println(workingString);

        System.out.println("\n Encoded signal : ");
        workingString = "";
        for(byte b : encoded){
            workingString += Integer.toBinaryString(b & 255 | 256).substring(1) + "\n";
        }
        System.out.println(workingString);

        System.out.println("\n Disrupted signal : ");
        workingString = "";
        for(byte b : disrupted){
            workingString += Integer.toBinaryString(b & 255 | 256).substring(1) + "\n";
        }
        System.out.println(workingString);

        System.out.println("\n Decoded signal : ");
        workingString = "";
        for(byte b : decoded){
            workingString += Integer.toBinaryString(b & 255 | 256).substring(1) + "\n";
        }
        System.out.println(workingString);

        System.out.println("\n Errors : ");
        System.out.println("Number of detected errors : " + errorsNumber);
        System.out.println(errors);
    }
}
