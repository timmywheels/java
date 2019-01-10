public class Main {

    public static void main(String[] args) {

        // ints have width of 32
        int myMinValue = -2147483648;
        // can use underscores to make number easier to read
        int myMaxValue = 2_147_483_647;

        // byte has a width of 8
        byte myByteValue = -128;

        // cast value to byte
        byte myNewByteValue = (byte) (myByteValue / 2);

        // short has a width of 16
        short myShortValue = 32767;
        short myNewShrtValue = (short) (myShortValue / 2);

        // long has a width of 64
        // use 'l' or 'L' to signify long
        long myLongValue = 100L;


        byte myByte = 10;

        short myShort = 300;

        int myInt = 5_000_000;

        long myLong = 50_000 + (10 * (myByte + myShort + myInt));

        System.out.println("myLong:" + myLong);


    }

}
