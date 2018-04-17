package algorithms;

public class CyclicRedundancyCheck16Bit {

    private static final int generator_polynomial = 0x00001021;

    private int calculatedCRC;


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

    public void computeCRCWithLookupTableFor(byte[] data){

    }


}
