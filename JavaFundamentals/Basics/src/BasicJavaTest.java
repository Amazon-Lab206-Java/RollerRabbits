public class BasicJavaTest {

    public static void main(int[] String[]) {
        BasicJava basics = new BasicJava();

        basics.oneTo255();
        basics.odds();
        basics.printSum();
        int[] myArray = {1, 3, 5, 7, 9, 13};
        basics.iterateArray(myArray);
        basics.findMax(myArray);
        basics.getAverage(myArray);
        basics.OddArray(myArray);
        basics.greaterThanY(myArray, 5);
        basics.squaredValues(myArray);
        int[] myArray2 = {1, 5, 10, -2};
        basics.ellimNeg(myArray2);
        basics.maxMinAvg(myArray2);
        int[] myArray3 = {1, 5, 10, 7, -2};
        basics.arrayShift(myArray3);
    }

}
