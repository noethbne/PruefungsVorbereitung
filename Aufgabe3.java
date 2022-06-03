import javax.swing.UIDefaults.ProxyLazyValue;

public class Aufgabe3 {
    public static boolean hasOne(int aValue){
        int val = aValue;
        
        while(val != 0){
            if(val % 10 == 1 || val % 10 == -1){
                return true;
            }
            val = val / 10;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int val1 = -11;
        int val2 = 10;
        int val3 = 22;
        int val4 = 446231644;

        System.out.println(hasOne(val1));
        System.out.println(hasOne(val2));
        System.out.println(hasOne(val3));
        System.out.println(hasOne(val4));
    }
}
