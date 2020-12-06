import java.util.ArrayList;
import java.util.Random;

public class Main {

    /*Some global static variables*/
    private static ArrayList<Integer> integersList = new ArrayList<Integer>();
    private static ArrayList<Integer> anotherIntegerList = new ArrayList<Integer>();

    private static ArrayList<Float> floatList = new ArrayList<Float>();
    private static ArrayList<Float> anotherFloatList = new ArrayList<Float>();

    private static float maxFloat = 1;
    private static float minFloat = 0;

    private static int maxInt = 100;

    /*Method to generate n random values to generete fuzzy sets and after do the intersection of both, where n = iter*/
    public static void randomNumbers(int iter)
    {
        Random randomNumber = new Random();
        float randomFloat;
        int randomInt;
        for(int i = 0; i < iter ; i++)
        {
            randomFloat = minFloat + randomNumber.nextFloat() * (maxFloat - minFloat);
            floatList.add(randomFloat);

            randomFloat = minFloat + randomNumber.nextFloat() * (maxFloat - minFloat);
            anotherFloatList.add(randomFloat);

            randomInt = randomNumber.nextInt(maxInt);
            integersList.add(randomInt);

            randomInt = randomNumber.nextInt(maxInt);
            anotherIntegerList.add(randomInt);
        }
    }

    public static void test()
    {
        /*Clean variable's content*/
        integersList.clear();
        anotherIntegerList.clear();

        floatList.clear();
        anotherFloatList.clear();

        /*Initialize some values to check if the program works well*/

        integersList.add(1);
        integersList.add(2);
        integersList.add(3);
        integersList.add(4);

        anotherIntegerList.add(1);
        anotherIntegerList.add(2);
        anotherIntegerList.add(3);

        floatList.add(0.5f);
        floatList.add(0.2f);
        floatList.add(0.3f);
        floatList.add(0.364f);

        anotherFloatList.add(0.1f);
        anotherFloatList.add(0f);
        anotherFloatList.add(0.5f);

        FuzzySet a = new FuzzySet(integersList,floatList);

        FuzzySet b = new FuzzySet(anotherIntegerList, anotherFloatList);

        /*Then our fuzzy sets will be A = {1:0.5 ; 2:0.2 ; 3:0.3 ; 4:0.364;} and B = {1:0.1 ; 2:0 ; 3:0.5}*/

        /*The intersection of this two sets should be A U B = {1:0.1 ; 3:0.3} because there's not 4 value on set B and
        * the value 2 have degree 0, then we remove it, like the example provided by the assignment*/

        a.addAll(b);

        /*We now create a new Fuzzy set with this values to check if it's contained by the intersection*/
        /*First of all we clean the content*/

        integersList.clear();
        floatList.clear();

        integersList.add(1);
        integersList.add(3);

        floatList.add(0.1f);
        floatList.add(0.3f);

        FuzzySet c = new FuzzySet(integersList,floatList);

        System.out.println(c);
        System.out.println(a);

        System.out.println(a.containsAll(c));

    }
    public static void main(String[] args) {

        randomNumbers(10);

        FuzzySet firstSet = new FuzzySet(integersList,floatList);

        FuzzySet secondSet = new FuzzySet(anotherIntegerList,anotherFloatList);

        firstSet.addAll(secondSet);

        System.out.println(firstSet);

        test();

    }
}
