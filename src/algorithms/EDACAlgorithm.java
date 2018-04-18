package algorithms;

public interface EDACAlgorithm {

    byte[] encode(byte[] data);
    byte[] decode(byte[] data);
    String getErrors();
    int getErrorsCount();
    int getCorrectedErrorsCount();

}
