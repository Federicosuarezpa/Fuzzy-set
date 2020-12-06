import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static ArrayList<Integer> integersList = new ArrayList<Integer>();
    private static ArrayList<Integer> anotherIntegerList = new ArrayList<Integer>();

    private static ArrayList<Float> floatList = new ArrayList<Float>();
    private static ArrayList<Float> anotherFloatList = new ArrayList<Float>();

    private static float maxFloat = 1;
    private static float minFloat = 0;

    private static int maxInt = 100;

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
    public static void main(String[] args) {

        randomNumbers(10);

        FuzzySet firstSet = new FuzzySet(integersList,floatList);

        FuzzySet secondSet = new FuzzySet(anotherIntegerList,anotherFloatList);

        firstSet.addAll(secondSet);

        System.out.println(firstSet);


    }
}
