package generators;

import java.util.ArrayList;
import java.util.Map;

public class BlankDisruptionGenerator implements DisruptionGenerator{

    private byte[] signal;

    @Override
    public byte[] disrupt(byte[] signal) {
        this.signal = signal;
        return signal;
    }

    @Override
    public byte[] getDisruptedSignal() {
        return signal;
    }

    @Override
    public int getNumberOfCreatedErrors() {
        return 0;
    }

    @Override
    public Map<Integer, ArrayList<Integer>> getDisruptedBits() {
        return null;
    }
}
