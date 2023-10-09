import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountPath {
    public static void main(String[] args) {
        List<List<String>> myGrid = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("0");
        row1.add("0");
        row1.add("X");
        List<String> row2 = new ArrayList<>();
        row2.add("0");
        row2.add("0");
        row2.add("0");
        List<String> row3 = new ArrayList<>();
        row3.add("0");
        row3.add("0");
        row3.add("0");
        myGrid.add(row1);
        myGrid.add(row2);
        myGrid.add(row3);

        System.out.println(countPaths(myGrid));
    }

    public static int countPaths(List<List<String>> grid){
        return countPaths(0, 0, grid, new HashMap<>());
    }
    public static int countPaths(int startRow, int startColumn, List<List<String>> grid, HashMap<List<Integer>, Integer> memo){
        if(grid.size() == startRow || grid.get(0).size()  == startColumn){
            return 0;
        }
        if (grid.get(startRow).get(startColumn) == "X"){
            return 0;
        }
        if(grid.size()-1 == startRow && grid.get(0).size() -1 == startColumn){
            return 1;
        }
        List<Integer> pos = List.of(startRow, startColumn);
        if (memo.containsKey(pos)){
            return memo.get(pos);
        }

        int result = countPaths(startRow +1, startColumn, grid, memo) + countPaths(startRow, startColumn +1, grid, memo);
        memo.put(pos, result);
        return result;
    }
}

