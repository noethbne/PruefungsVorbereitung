package AlgenDaten;

public class Aufgabe4 {
    public static void bucketSort(int array[])
    {
        int max = array[0];
        int min = array[0];
        
        for (int i=1; i<array.length; i++)
        {
            if (array[i] > max) max = array[i];
            if (array[i] < min) min = array[i];
        }
        
        int buckets[] = new int[max - min + 1];

        for (int i=0; i<array.length; i += 1)
        {
            buckets[array[i]-min] = buckets[array[i]-min] + 1;
        }

        int idx=0;
        for (int b=0; b<buckets.length; b += 1)
        {
            for (int i=0; i<buckets[b]; i += 1)
            {
                array[idx] = b + min;
                idx += 1;
            }
        }
    }

    public static void print(int array[]){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ,");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] test1 = {4,2,8,7,-15,0,3,9};
        int[] test2 = {10,9,8,7,6,5,4,3,2,1,0};

        print(test1);
        bucketSort(test1);
        print(test1); 
        System.out.println();
        print(test2);
        bucketSort(test2);
        print(test2);
    }
}
