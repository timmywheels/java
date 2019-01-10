public class Main {
    public static void main(String [] args) {

        int myIntValue = 5 / 2;
        float myFloatValue = (float) 5 / 2f;
        double myDoubleValue = 5.25d / (double) 2;

        System.out.println("myIntValue:" + myIntValue);
        System.out.println("myFloatValue:" + myFloatValue);
        System.out.println("myDoubleValue:" + myDoubleValue);


        // lbs -> kilograms converter
        double pounds = 10d;
        double kilo = pounds * 0.45359237d;

        System.out.println("kilo:" + kilo);


    }
}
