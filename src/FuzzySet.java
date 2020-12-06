import java.util.ArrayList;
import java.util.Iterator;

public class FuzzySet extends ListSet {

    ArrayList<Float> degreeValue;

    public FuzzySet ()
    {
        super();
        degreeValue = new ArrayList<Float>();

    }
    public FuzzySet (int values[] , ArrayList<Float> degree)
    {
        super(values);

        degreeValue = new ArrayList<Float>();

        Iterator<Float> iterate = degree.iterator();

        while(iterate.hasNext())
        {
            degreeValue.add(iterate.next());
        }
    }

    public FuzzySet (ArrayList<Integer> values , ArrayList<Float> degree)
    {
        super(values);

        degreeValue = new ArrayList<Float>();

        Iterator<Float> iterate = degree.iterator();

        while(iterate.hasNext())
        {
            degreeValue.add(iterate.next());
        }
    }

    public boolean addAll(FuzzySet values)
    {
        Iterator<Integer> iteratorInteger = values.iterator();
        Iterator<Float> iteratorFloats = values.degreeValue.iterator();

        FuzzySet newFuzzyset = new FuzzySet();


        int integerValue;
        float floatValue;
        boolean someInterception = false;

        while(iteratorInteger.hasNext())
        {
            integerValue = iteratorInteger.next();
            floatValue = iteratorFloats.next();

            if(this.contains(integerValue))
            {
                int index = this.getSetClass().indexOf(integerValue);
                float valueOriginal = this.degreeValue.get(index);


                if(valueOriginal <= floatValue && valueOriginal > 0.0)
                {
                    System.out.println("Value:" + integerValue + " degree:" + valueOriginal + " " +"Value 2:" +
                            integerValue + " degree 2:" + floatValue);

                    newFuzzyset.add(integerValue);
                    newFuzzyset.degreeValue.add(valueOriginal);
                    someInterception = true;
                }
                else if (floatValue > 0.0 && floatValue < valueOriginal)
                {
                    System.out.println("Value: " + integerValue + " degree: " + valueOriginal + " " +"Value 2: " +
                            integerValue + " degree 2: " + floatValue);
                    newFuzzyset.add(integerValue);
                    newFuzzyset.degreeValue.add(floatValue);
                    someInterception = true;

                }
            }
        }
        this.setSetClass(newFuzzyset.getSetClass());
        this.degreeValue = newFuzzyset.degreeValue;

        return someInterception;
    }

    public String toString ()
    {
        String string = "";

        Iterator<Integer> iteratorInteger = this.iterator();
        Iterator<Float> iteratorFloats = this.degreeValue.iterator();

        while(iteratorInteger.hasNext())
        {
            string = string + "{" + iteratorInteger.next() + ":" + iteratorFloats.next() + "}" + " ";
        }
        return string;
    }
}
