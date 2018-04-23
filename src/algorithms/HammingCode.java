package algorithms;

public class HammingCode implements EDACAlgorithm {
    @Override
    public byte[] encode(byte[] data) {

        byte[] encodedData;

        int counter = 0;
        int parity_counter = 0;

        while(counter < (data.length * 8)){
            if(Math.pow(2, parity_counter) == counter + parity_counter + 1) {
                parity_counter ++;
            }else{
                counter ++;
            }
        }

        encodedData = new byte[data.length + (int)Math.ceil(parity_counter / 8.0)];

        return new byte[0];
    }

    @Override
    public byte[] decode(byte[] data) {
        return new byte[0];
    }

    @Override
    public String getErrors() {
        return null;
    }

    @Override
    public int getErrorsCount() {
        return 0;
    }

    @Override
    public int getCorrectedErrorsCount() {
        return 0;
    }
}
