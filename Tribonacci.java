import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;

public class Tribonacci {
    public static void main(String[] args) {
        int number = 30;
        Instant start = Instant.now();
        System.out.println("Tribonucci with map: "+ tribonacci_base(number));
        Instant finish = Instant.now();
        System.out.println("Time use for Tribonucci with map: " + Duration.between(start, finish).toMillis());
        Instant start1 = Instant.now();
        System.out.println(tribo_brute(number));
        Instant finish1 = Instant.now();
        System.out.println("Time use for Tribonucci_brute " + Duration.between(start1, finish1).toMillis());
    }

    public static int tribonacci_base(int i){
        return tribonacci(i, new HashMap<>());
    }
    public static int tribonacci(int i, HashMap<Integer, Integer> map){
        if (i == 0 || i == 1) return 0;
        if (i == 2) return 1;
        if (map.containsKey(i)){
            return map.get(i);
        }
        int result = tribonacci(i-3, map) + tribonacci(i -2, map) + tribonacci(i -1, map);
        map.get(result);
        return result;
    }

    //    This would be brute force:
    public static int tribo_brute(int i){
        Instant start = Instant.now();
        if(i == 0 || i == 1) return 0;
        if(i == 2) return 1;
        return tribo_brute(i -3) + tribo_brute(i-2)+ tribo_brute(i -1);
    }
}
