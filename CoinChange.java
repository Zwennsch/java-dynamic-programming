import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChange {
    public static void main(String[] args) {
        int amount = 5;
        List<Integer> coins = List.of(1,2,3);
        System.out.println(countingChange(amount, coins));
    }

    private static int countingChange(int amount, List<Integer> coins) {
        return countingChange(amount, 0, coins, new HashMap<>());
    }
    private static int countingChange(int amount, int coinIdx, List<Integer> coins, Map<List<Integer>, Integer> memo) {
        if(amount == 0){
            return 1;
        }
        if(coinIdx >= coins.size()){
            return 0;
        }
        List<Integer> key = List.of(amount, coinIdx);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int totalWays = 0;
        int value = coins.get(coinIdx);
        for(int qty = 0; qty * value <= amount; qty++){
            int subamount = amount - qty * value;
            totalWays += countingChange(subamount, coinIdx+1, coins, memo);
        }
        memo.put(key, totalWays);
        return totalWays;
    }
}
