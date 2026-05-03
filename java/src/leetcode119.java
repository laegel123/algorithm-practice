import java.util.ArrayList;
import java.util.List;

public class leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> rows = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));
                }
            }

            rows.add(row);
        }

        return rows.get(rowIndex);
    }
}
