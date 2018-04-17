package generators;

public interface SignalGenerator {
    void setSignalLength(int length);
    byte[] generateSignal();
    byte[] getGeneratedSignal();
}
