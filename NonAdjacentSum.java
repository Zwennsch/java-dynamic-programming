import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonAdjacentSum {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2,4,5,12,7);

        System.out.println(nonAdjacentSum(nums));

    }

    private static int nonAdjacentSum(List<Integer> nums) {
        return nonAdjacentSum(nums, 0, new HashMap<>());
    }
    private static int nonAdjacentSum(List<Integer> nums, int startIndex, Map<Integer, Integer> memo) {
        if(startIndex >= nums.size()){
            return 0;
        }
        if (memo.containsKey(startIndex)){
            return memo.get(startIndex);
        }
        var result = Math.max(nums.get(startIndex) + nonAdjacentSum(nums, startIndex +2, memo),
                nonAdjacentSum(nums, startIndex +1, memo)
        );
        memo.put(startIndex, result);
        return result;
    }
}
