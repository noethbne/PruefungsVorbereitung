package AlgenDaten.Wiederholung;

public class Aufgabe1 {
    public static int[] merge(int[] array1, int[] array2){
        int[] temp = new int[array1.length + array2.length];
        int count1 = 0;
        int count2 = 0;
        int countTemp = 0;
        while(true){
            if(count2 == array2.length){
                while(count1 < array1.length){
                    temp[countTemp++] = array2[count1++];
                }
                break;
            }else if(count1 == array1.length){
                while(count2 < array2.length){
                    temp[countTemp++] = array2[count2++];
                }
                break;
            }

            if(array1[count1] < array2[count2]){
                if(countTemp == 0){
                    temp[countTemp++] = array1[count1++];
                }else if(array1[count1] != temp[countTemp-1]){
                    temp[countTemp++] = array1[count1++];
                }else{
                    count1++;
                }                    
            }else{
                if(countTemp == 0){
                    temp[countTemp++] = array2[count2++];
                }else if(array2[count2] != temp[countTemp-1]){
                    temp[countTemp++] = array2[count2++];
                }else{
                    count2++;
                }
            }
        }

        int[] res = new int[countTemp];
        for(int i = 0; i < countTemp; i++){
            res[i] = temp[i];
        }

        return res;
    }
    public static void print(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + "   ");
        }
    }
    public static void main(String[] args){
            int[] array1 = {1,2,3,4,5};
            int[] array2 = {2,4,6,8,10,12};
    
            print(merge(array1, array2));
            System.out.println("");
            
            int[] array3 = {1,2,2,3,3,3,4,4,4,4};
            int[] array4 = {0,5,10};
    
            print(merge(array3, array4));
        }
}
