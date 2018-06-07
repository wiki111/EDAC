package algorithms;

public class CyclicRedundancyCheck16Bit implements EDACAlgorithm {

    private int generator_polynomial;

    private static final String CRC16_ERROR = "[CRC16 DATA ERROR] The data is corrupted.";
    private static final int crc16 = 0x00008005;
    private static final int crcSDLC = 0x00001021;
    private static final int crcSDLCReverse = 0x00008408;

    private int calculatedCRC;
    private int numberOfErrors = 0;
    private String errorLog = "";
    private int numberOfCorrectedErrors = 0;
    private int[] lookupTable;

    public CyclicRedundancyCheck16Bit(String crctype) {
        switch(crctype){
            case "crc16" :
                generator_polynomial = crc16;
                break;
            case "sdlc" :
                generator_polynomial = crcSDLC;
                break;
            case "sdlc reverse" :
                generator_polynomial = crcSDLCReverse;
                break;
            default :
                generator_polynomial = crc16;
                break;

        }
        calculateLookupTable();
    }

    private void calculateLookupTable(){
        lookupTable = new int[256];

        for(int divident = 0; divident < 256; divident++){

            int currentByte = divident << 8;

            for(byte bit = 0; bit < 8; bit++){
                if((currentByte & 0x8000) != 0){
                    currentByte <<= 1;
                    currentByte ^= generator_polynomial;
                }else {
                    currentByte <<= 1;
                }
                currentByte &= ~(1 << 16);
            }
            lookupTable[divident] = currentByte;
        }

    }

    public int getCalculatedCRC() {
        return calculatedCRC;
    }

    public void computeCRCFor(byte[] data){

        int crc = 0;

        int bytecountertemp = 0;

        for(byte b : data){
            bytecountertemp++;
            crc ^= b << 8;
            for(int i = 0; i < 8; i++){

                //System.out.println("Bit " + i + " of byte " + bytecountertemp + " : " + String.format("0x%08X", crc));

                if((crc & 0x00008000) != 0){
                    crc = (crc << 1) ^ generator_polynomial;

                    //System.out.println("MSB is 1 ! Performing XOR with GP : " + String.format("0x%08X", crc));

                }else{
                    crc <<= 1;

                }

                //This modification seems to be important for java, because for 32 bit
                //data type shift left doesn't shift out the 1 at MSB.
                crc &= ~(1 << 16);
            }
        }

        calculatedCRC = crc;
    }

    @Override
    public byte[] encode(byte[] data) {
        return appendCRC(data, computeCRCWithLookupTableFor(data));
    }

    public int computeCRCWithLookupTableFor(byte[] data){
        int crc = 0;
        for (byte b : data) {
            byte pos = (byte) ((crc >> 8) ^ b);
            crc = (int)(((crc << 8) & ~(0xFFFF0000)) ^ lookupTable[(int)pos & 0xFF]);
        }
        System.out.println("Computed CRC16 code : " + String.format("0x%08X",crc));
        return crc;
    }

    private byte[] appendCRC(byte[] data, int crc){
        byte[] dataWithAppendedCRC = new byte[data.length + 2];
        System.arraycopy(data, 0, dataWithAppendedCRC, 0, data.length);
        dataWithAppendedCRC[data.length + 1] = (byte)(crc & ~(0x11111100));
        dataWithAppendedCRC[data.length] = (byte)((crc >> 8) & ~(0x11111100));
        return dataWithAppendedCRC;
    }

    @Override
    public byte[] decode(byte[] data) {

        int crc = computeCRCWithLookupTableFor(data);

        if(crc == 0){
            byte[] decodedData = new byte[data.length - 2];
            System.arraycopy(data, 0, decodedData, 0, data.length - 2);
            return decodedData;
        }else{
            errorLog = CRC16_ERROR;
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
