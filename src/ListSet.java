import java.util.*;

public class ListSet implements Iterable<Integer> {

    private ArrayList<Integer> setClass;

    public ListSet()
    {
        setClass = new ArrayList<Integer>();
    }
    
    public ListSet(int array[])
    {
        setClass = new ArrayList<Integer>();

        for (int value: array)
        {
            if(!setClass.contains(value))
            {
                setClass.add(value);
            }
        }
    }

    public ListSet(ArrayList<Integer> arrayValues)
    {
        setClass = new ArrayList<Integer>();

        Iterator<Integer> iterate = arrayValues.iterator();
        while(iterate.hasNext())
        {
            setClass.add(iterate.next());
        }
    }

    public boolean add(int value)
    {
        boolean added = false;
        if(!this.contains(value))
        {
            this.setClass.add(value);
            added = true;
        }
        return added;
    }
    public boolean addAll(ListSet unionClass)
    {
        int valueToAdd;
        boolean addedSomething = false;
        Iterator<Integer> iterate = unionClass.iterator();
        while(iterate.hasNext())
        {
            valueToAdd = iterate.next();
            if(!this.contains(valueToAdd))
            {
                this.add(valueToAdd);
                addedSomething = true;
            }
        }
        Iterator<Integer> iteratorNew = this.iterator();

        return addedSomething;
    }

    public int size()
    {
        return this.setClass.size();
    }

    public boolean isEmpty()
    {
        return this.setClass.isEmpty();
    }

    public void clear()
    {
        this.setClass.clear();
    }

    public boolean contains(int value)
    {
        return this.setClass.contains(value);
    }

    public boolean containsAll(ArrayList<Integer> otherClass)
    {
        return this.setClass.containsAll(otherClass);
    }

    public boolean remove(int value)
    {
        boolean removed = false;

        if(this.contains(value))
        {
            this.setClass.remove(this.setClass.indexOf(value));
            removed = true;
        }
        return removed;
    }

    public boolean removeAll(ArrayList<Integer> collectionValues)
    {
        Iterator<Integer> iterate = collectionValues.iterator();

        boolean removed = false;
        int valueRemove;
        while(iterate.hasNext())
        {
            valueRemove = iterate.next();

            if(this.contains(valueRemove))
            {

                this.setClass.remove(this.setClass.indexOf(valueRemove));
                removed = true;
            }
        }
        return removed;
    }

    public boolean retainAll(ListSet otherClass)
    {
        Iterator<Integer> iterate = otherClass.iterator();

        boolean intersection = false;
        int value;
        ListSet newSet = new ListSet();
        while(iterate.hasNext())
        {
            value = iterate.next();
            if(this.contains(value))
            {
                newSet.add(value);
                intersection = true;
            }
        }
        return intersection;
    }

    public String toString()
    {
        String string = "";

        Collections.sort(this.setClass);

        Iterator<Integer> iterate = this.iterator();

        while(iterate.hasNext())
        {
            string = string + "{" + iterate.next() + "}" + " ";
        }
        return string;
    }


    
    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> iterate = this.setClass.iterator();
        return iterate;
    }


    public ArrayList<Integer> getSetClass() {
        return setClass;
    }

    public void setSetClass(ArrayList<Integer> setClass) {
        this.setClass = setClass;
    }

}
