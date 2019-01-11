public class Main {
    public static void main(String[] args){

        boolean isAlien = true;

        if (isAlien)
            System.out.println("It's an alien!");
        else{
            System.out.println("It's not an alien");
        }


        boolean isCar = false;

        boolean wasCar = isCar ? true : false;

        System.out.println("Was it a car?:" + wasCar);



        double firstVal = 20d;
        double secondVal = 80;
        double myTotal = firstVal + secondVal * 25;
        System.out.println("myTotal: " + myTotal);

        double theRemainder = myTotal % 40;

        if (theRemainder <= 20)
            System.out.println("This was over the limit!");

    }
}
