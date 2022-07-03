package AlgenDaten;
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

    public int[] alt(int array[]){    
        int max, min;
         
        min = array[0];
        max = array[1];
         
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                if (array[i] > max) {
                    max = array[i];
                }
                if (array[i + 1] < min) {
                    min = array[i + 1];
                }
            } else {
                if (array[i + 1] > max) {
                    max = array[i + 1];
                }
                if (array[i] < min) {
                    min = array[i];
                }
            }
        }
        int res[] = {min, max};
        return res;
    }
}