package algorithms;

public class HammingCode implements EDACAlgorithm {

    private int encoded_data_length = 0;
    private int parity_bits_added = 0;

    @Override
    public byte[] encode(byte[] data) {

        System.out.println("Input data : ");
        for(byte b : data){
            System.out.println(Integer.toBinaryString(b & 255 | 256).substring(1));
        }

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

        encoded_data_length = data.length * 8 + parity_counter;
        parity_bits_added = parity_counter;

        encodedData = new byte[data.length + (int)Math.ceil(parity_counter / 8.0)];

        int j = 0;
        int dst_bit_counter = 0;
        int src_bit_counter = 0;
        int dst_byte_counter = 0;
        int src_byte_counter = 0;

        for(int i = 1; i <= encodedData.length * 8; i++){
            if(Math.pow(2, j) != i){

                byte currentDestinationByte = encodedData[dst_byte_counter];

                if(src_byte_counter < data.length){
                    byte currentSourceByte = data[src_byte_counter];

                    if(((currentSourceByte >> src_bit_counter) & 1) == 1){
                        currentDestinationByte = (byte) (currentDestinationByte | (1<<dst_bit_counter));
                    }else {
                        currentDestinationByte = (byte) (currentDestinationByte & ~(1<<dst_bit_counter));
                    }
                }else{
                    currentDestinationByte = (byte) (currentDestinationByte & ~(1<<dst_bit_counter));
                }

                encodedData[dst_byte_counter] = currentDestinationByte;

                if(src_bit_counter < 7){
                    src_bit_counter++;
                }else{
                    src_bit_counter = 0;
                    src_byte_counter++;
                }

            }else{
                j++;
            }

            if(dst_bit_counter < 7){
                dst_bit_counter++;
            }else{
                dst_bit_counter = 0;
                dst_byte_counter++;
            }

        }
        System.out.println("Rewritten data : ");
        for(byte b : encodedData){
            System.out.println(Integer.toBinaryString(b & 255 | 256).substring(1));
        }


        for(int i = 0; i < parity_counter; i++){
            boolean parity_bit_value = getParity(i, encodedData);
            int position = (int) Math.pow(2,i) - 1;
            int bit_position = position%8;
            int byte_position = (int)Math.floor(position/8);
            if(parity_bit_value){
                encodedData[byte_position] |= (1<<(bit_position));
            }else{
                encodedData[byte_position] &= ~(1<<(bit_position));
            }
        }
        System.out.println("Encoded data : ");
        for(byte b : encodedData){
            System.out.println(Integer.toBinaryString(b & 255 | 256).substring(1));
        }

        return encodedData;
    }

    private boolean getParity(int power, byte[] data){
        boolean parity = false;

        int parity_counter = 0;
        int dst_bit_counter = 0;
        int dst_byte_counter = 0;

        for(int i = 0; i < encoded_data_length; i++){
            if(((i+1) & i) != 0) {
                int k  = i + 1;
                String s = Integer.toBinaryString(k);
                int x = ((Integer.parseInt(s))/((int)Math.pow(10, power)))%10;
                if(x == 1) {
                    if(((data[dst_byte_counter] >> dst_bit_counter) & 1) == 1){
                        parity_counter = (parity_counter + 1)%2;
                    }
                }
            }

            if(dst_bit_counter < 7){
                dst_bit_counter ++;
            }else{
                dst_bit_counter = 0;
                dst_byte_counter++;
            }

        }

        if(parity_counter == 1){
            parity = true;
        }

        return parity;
    }

    @Override
    public byte[] decode(byte[] data) {

        byte[] decodedData;

        int[] parity = new int[parity_bits_added];

        String syndrome = new String();



        for(int power = 0; power < parity_bits_added; power++){
            for(int i = 0; i < encoded_data_length; i++){
                int k = i + 1;
                String s = Integer.toBinaryString(k);
                int bit = ((Integer.parseInt(s))/((int)Math.pow(10, power)))%10;
                if(bit == 1){
                    int byte_counter = (int) Math.floor(i/8);
                    int bit_counter = i%8;
                    if(((data[byte_counter] >> bit_counter) & 1) == 1){
                        parity[power] = (parity[power] + 1)%2;
                    }
                }

            }
            syndrome = parity[power] + syndrome;
        }

        int error_location = Integer.parseInt(syndrome, 2);
        if(error_location != 0){
            data[(int) Math.floor((error_location-1)/8)] ^= (1 << ((error_location-1)%8));
        }

        return getOriginalData(data, parity_bits_added);
    }

    private byte[] getOriginalData(byte[] dataWithAppendedBits, int numberOfAppendedBits){
        int numberOfDataBits = encoded_data_length - numberOfAppendedBits;
        byte[] originalData = new byte[(int)Math.ceil((numberOfDataBits)/8)];

        int counter = 0;

        for(int i = 0; i < encoded_data_length; i++){
            if(((i+1) & i) != 0){
                if(((dataWithAppendedBits[(int)Math.floor(i/8)] >> (i%8)) & 1) == 1){
                    int byte_position = (int) Math.floor(counter/8);
                    int bit_position = counter%8;
                    originalData[byte_position] |= (1 << bit_position);
                }
                counter++;
            }
        }

        return originalData;
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
