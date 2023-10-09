import java.util.HashMap;

public class SumPossible {

    public static void main(String[] args) {
        int amount = 7;
        int[] numbers = {2,4,6};
        System.out.println(isSumPossible_base(amount, numbers));
    }
    /**
     checks whether the amount can be created by summing up values from numbers in various ways.
     @param amount  the final amount that should be created as a sum of values
     @param numbers the numbers to use from which the amount should be summed up to.
     */
    static boolean isSumPossible_base(int amount, int[] numbers){
        return isSumPossible(amount, numbers, new HashMap<>());
    }

    /*
    checks
     */
    static boolean isSumPossible(int amount, int[] numbers, HashMap<Integer, Boolean> map){
        if (amount == 0) return true;
        if (amount < 0) return false;
        if(map.containsKey(amount)) return map.get(amount);
        for (int num : numbers){
            int subamount = amount - num;
            if (isSumPossible(subamount, numbers, map)){
                map.put(amount, true);
                return true;
            }
        }
        map.put(amount, false);
        return false;
    }
}
