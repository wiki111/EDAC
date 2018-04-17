package console;

public interface ConsoleResultPrinter {
    void printBasicResults(byte[] input, byte[] encoded, byte[] disrupted, byte[] decoded, int errorsNumber, String errors);
}
