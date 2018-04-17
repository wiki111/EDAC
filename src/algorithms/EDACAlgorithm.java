package algorithms;

public interface EDACAlgorithm {

    byte[] encode(byte[] data);
    byte[] decode(byte[] data);
    byte[] getOriginalInput();
    byte[] getEncodedData();
    byte[] getReceivedData();
    byte[] getDecodedData();
    String getErrors();
    int getErrorsCount();
    int getCorrectedErrorsCount();

}
