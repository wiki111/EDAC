package algorithms;

public class CyclicRedundancyCheck32Bit implements EDACAlgorithm{

    private long generator_polynomial;

    private static final long crc32 = 0x04C11DB7;

    private static final String CRC32_ERROR = "[CRC32 DATA ERROR] The data is corrupted.";

    private int calculatedCRC;
    private int numberOfErrors = 0;
    private String errorLog = "";
    private int numberOfCorrectedErrors = 0;
    private long[] lookupTable;

    public CyclicRedundancyCheck32Bit(String crctype) {
        switch(crctype){
            case "cr32" :
                generator_polynomial = crc32;
                break;
            default :
                generator_polynomial = crc32;
                break;

        }
        calculateLookupTable();
    }

    private void calculateLookupTable(){
        lookupTable = new long[256];

        for(int divident = 0; divident < 256; divident++){

            long currentByte = (long)(divident << 24);

            for(byte bit = 0; bit < 8; bit++){
                if((currentByte & 0x80000000) != 0){
                    currentByte <<= 1;
                    currentByte ^= generator_polynomial;
                }else {
                    currentByte <<= 1;
                }
                currentByte &= ~(1 << 32);
            }
            lookupTable[divident] = currentByte;
        }

    }

    @Override
    public byte[] encode(byte[] data) {

        return appendCRC(data, computeCRCWithLookupTableFor(data));
    }

    private long computeCRCWithLookupTableFor(byte[] data){
        long crc = 0;
        for(byte b : data){
            byte pos = (byte)((crc ^ (b << 24)) >> 24);
            crc = (((crc << 40) >>> 32) ^ lookupTable[(int)pos & 0xFF]);
        }
        return crc;
    }

    private byte[] appendCRC(byte[] data, long crc){
        byte[] dataWithAppendedCRC = new byte[data.length + 4];
        System.arraycopy(data, 0, dataWithAppendedCRC, 0, data.length);
        dataWithAppendedCRC[data.length + 3] = (byte)(crc & ~(0x11111100));
        dataWithAppendedCRC[data.length + 2] = (byte)((crc >> 8) & ~(0x11111100));
        dataWithAppendedCRC[data.length + 1] = (byte)((crc >> 16) & ~(0x11111100));
        dataWithAppendedCRC[data.length] = (byte)((crc >> 24) & ~(0x11111100));
        return dataWithAppendedCRC;
    }

    @Override
    public byte[] decode(byte[] data) {
        long crc = computeCRCWithLookupTableFor(data);

        if(crc == 0){
            byte[] decodedData = new byte[data.length - 4];
            System.arraycopy(data, 0, decodedData, 0, data.length - 4);
            return decodedData;
        }else{
            errorLog = CRC32_ERROR;
            numberOfErrors++;
            return null;
        }
    }

    @Override
    public String getErrors() {
        return errorLog;
    }

    @Override
    public int getErrorsCount() {
        return numberOfErrors;
    }

    @Override
    public int getCorrectedErrorsCount() {
        return numberOfCorrectedErrors;
    }
}
