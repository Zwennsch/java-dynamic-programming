import java.util.HashMap;
import java.util.List;

public class MaxSumPath {
    public static void main(String[] args) {
        List<List<Integer>> grid = List.of(
                List.of(1,3,12),
                List.of(5,1,1),
                List.of(3,6,1)
        );
        System.out.println(maxPathSum(grid));
    }

    public static int maxPathSum(List<List<Integer>> map){

        return (int) (maxPathSum(0,0, map, new HashMap<>()));
    }
    public static double maxPathSum(int r, int c, List<List<Integer>> map, HashMap<List<Integer>, Double> memo){
//       case for being outside the map
        if(r == map.size() || c == map.get(0).size()) {
            return Double.NEGATIVE_INFINITY;
        }
//        base case, for the last position in the bottom right corner
        if(r == map.size()-1 && c == map.get(0).size()-1){
            return map.get(r).get(c);
        }

        List<Integer> pos = List.of(r,c);
        if(memo.containsKey(pos)){
            return memo.get(pos);
        }
        double maximum = map.get(r).get(c) + Math.max(maxPathSum(r+1, c, map, memo), maxPathSum(r, c+1, map, memo));
        memo.put(pos, maximum);
        return maximum;

    }
}
