package AlgenDaten.Wiederholung;

public class Aufgabe5 {
    public static int[] getMinMax(int array[]){
        int max = array[0];
        int min = array[0];

        for(int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
            else if(array[i] < min){
                min = array[i];
            }
        }

        int res[] = {min, max};
        return res;
    }

    public static void main(String[] args){
        int[] test1 = {4,2,8,7,-15,0,3,9};
        int[] test2 = {10,9,8,7,6,5,4,3,2,1,0};

        getMinMax(test1);
        getMinMax(test2);
    }
}
