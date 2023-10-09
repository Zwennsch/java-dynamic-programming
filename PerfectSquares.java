import java.util.HashMap;

public class PerfectSquares {
    public static void main(String[] args) {
        int number = 13;
        System.out.println((int)perfect_spuares(number, new HashMap()));
    }


    public static double perfect_spuares(int number, HashMap<Integer, Integer> memo){
        if(number == 0){
            return 0;
        }
        if (memo.containsKey(number)){
            return memo.get(number);
        }
        double minSquares = Double.POSITIVE_INFINITY;
        for(int i = 1; i <= Math.sqrt(number); i++ ){
            int square = i*i;
            double numSquares =  perfect_spuares(number - square, memo) + 1;
            if (numSquares < minSquares){
                minSquares = numSquares;
                memo.put(number, (int) minSquares);
            }
        }
        return minSquares;
    }
}
