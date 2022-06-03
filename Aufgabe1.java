

public class Aufgabe1{
    public static int[] merge(int[] array1, int[] array2){
        int[] arrayErg = new int[array1.length + array2.length];

        int count1 = 0;
        int count2 = 0;
        int countErg = 0;

        if(array1[count1] < array2[count2]){
            arrayErg[countErg++] = array1[count1++];
        }else{  
            arrayErg[countErg++] = array2[count2++];           
        }

        while(true){
            if(count1 == array1.length){
                for(int i = count2; i < array2.length; i++){
                    if(arrayErg[countErg] != array2[i]){
                        arrayErg[countErg++] = array2[i];
                    }
                }
                break;
            }
            if(count2 == array2.length){
                for(int i = count1; i < array1.length; i++){
                    if(arrayErg[countErg] != array1[i]){
                        arrayErg[countErg++] = array1[i];
                    }
                }
                break;
            }

            if(array1[count1] < array2[count2]){
                if(array1[count1] != arrayErg[countErg-1]){
                    arrayErg[countErg++] = array1[count1++];
                }else{
                    count1++;
                }
            }else{
                if(array2[count2] != arrayErg[countErg-1]){
                    arrayErg[countErg++] = array2[count2++];
                }else{
                    count2++;
                }
            }
        }
        int[] array = new int[countErg];
        for(int i = 0; i < array.length; i++){
            array[i] = arrayErg[i];
        }
        
        return array;
    }

    public static void print(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + "   ");
        }
    }

    public static void main(String[] args){
    /*     int[] array1 = {1,2,3,4,5};
        int[] array2 = {2,4,6,8,10,12};

        print(merge(array1, array2));
        */
        int[] array1 = {1,2,2,3,3,3,4,4,4,4};
        int[] array2 = {0,5,10};

        print(merge(array1, array2));
    }
}