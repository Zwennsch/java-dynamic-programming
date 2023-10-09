import java.util.HashMap;

public class MinChange {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,3};

        System.out.println(minChange(amount, coins));
    }
    static int minChange(int amount, int[] coins){
        return minChangeHelper(amount, coins, new HashMap<Integer, Integer>());
    }

    static int minChangeHelper(int amount, int[] coins, HashMap<Integer,Integer> memo){
        if (amount == 0) return 0;
        if (amount < 1) return -1;
        if (memo.containsKey(amount)){
            return memo.get(amount);
        }
        int mincoins = -1;
        for (int coin : coins){
            int subamount = amount - coin;
            int subcoins = minChangeHelper(subamount, coins, memo);
            if (subcoins != -1){
                int numCoins = subcoins + 1;
                if(numCoins < mincoins || mincoins == -1){
                    mincoins = numCoins;
                }
            }
        }
        memo.put(amount, mincoins);
        return mincoins;
    }
}
