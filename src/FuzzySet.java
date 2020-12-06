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

    public boolean containsAll(FuzzySet otherSet)
    {
        boolean container = false;
        if (super.containsAll(otherSet.getSetClass()) && this.degreeValue.containsAll(otherSet.getDegreeValue()))
        {
            container = true;
        }
        return container;
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
                    /*Here we can check visualy if our results are good,because we'll see the values that are identical
                    * and which degree we got, should be always the min*/
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

    public ArrayList<Float> getDegreeValue() {
        return degreeValue;
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
