package generators;

public interface DisruptionGenerator {

    byte[] disrupt(byte[] signal);
    byte[] getDisruptedSignal();
    int getNumberOfCreatedErrors();
}
