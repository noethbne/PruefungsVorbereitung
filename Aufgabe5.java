public class Aufgabe5 {

    public int [] getMinMax(int array[])
    {
        int max = array[0];
        int min = array[0];
        for (int i=1; i<array.length; i++)
        {
            if (array[i] > max) max = array[i];
            else if (array[i] < min) min = array[i];
        }

        int res[] = {min, max};
        return res;
    }
}
