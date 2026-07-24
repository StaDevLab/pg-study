import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int TABLE_SIZE = 50;
    private static final int CELL_COUNT = TABLE_SIZE * TABLE_SIZE;

    private int[] parent;
    private String[] values;

    public String[] solution(String[] commands) {

        parent = new int[CELL_COUNT];
        values = new String[CELL_COUNT];

        for (int i = 0; i < CELL_COUNT; i++) {
            parent[i] = i;
        }

        List<String> answer = new ArrayList<>();

        for (String command : commands) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "UPDATE":
                    update(tokens);
                    break;

                case "MERGE":
                    merge(tokens);
                    break;

                case "UNMERGE":
                    unmerge(tokens);
                    break;

                case "PRINT":
                    print(tokens, answer);
                    break;
            }
        }

        return answer.toArray(new String[0]);
    }

    private void update(String[] tokens) {

        if (tokens.length == 4) {
            int row = Integer.parseInt(tokens[1]);
            int column = Integer.parseInt(tokens[2]);
            String value = tokens[3];

            int index = getIndex(row, column);
            int root = find(index);

            values[root] = value;
            return;
        }

        String oldValue = tokens[1];
        String newValue = tokens[2];

        for (int i = 0; i < CELL_COUNT; i++) {
            if (parent[i] == i && oldValue.equals(values[i])) {
                values[i] = newValue;
            }
        }
    }

    private void merge(String[] tokens) {

        int row1 = Integer.parseInt(tokens[1]);
        int column1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int column2 = Integer.parseInt(tokens[4]);

        int index1 = getIndex(row1, column1);
        int index2 = getIndex(row2, column2);

        int root1 = find(index1);
        int root2 = find(index2);

        // 이미 같은 그룹이면 무시
        if (root1 == root2) {
            return;
        }

        String mergedValue;

        if (values[root1] != null) {
            mergedValue = values[root1];
        } else {
            mergedValue = values[root2];
        }

        parent[root2] = root1;

        values[root1] = mergedValue;
        values[root2] = null;
    }

    private void unmerge(String[] tokens) {

        int row = Integer.parseInt(tokens[1]);
        int column = Integer.parseInt(tokens[2]);

        int target = getIndex(row, column);
        int root = find(target);

        String savedValue = values[root];

        List<Integer> members = new ArrayList<>();

        for (int i = 0; i < CELL_COUNT; i++) {
            if (find(i) == root) {
                members.add(i);
            }
        }

        for (int member : members) {
            parent[member] = member;
            values[member] = null;
        }

        values[target] = savedValue;
    }

    private void print(String[] tokens, List<String> answer) {

        int row = Integer.parseInt(tokens[1]);
        int column = Integer.parseInt(tokens[2]);

        int index = getIndex(row, column);
        int root = find(index);

        if (values[root] == null) {
            answer.add("EMPTY");
        } else {
            answer.add(values[root]);
        }
    }

    private int find(int cell) {

        if (parent[cell] != cell) {
            parent[cell] = find(parent[cell]);
        }

        return parent[cell];
    }

    private int getIndex(int row, int column) {
        return (row - 1) * TABLE_SIZE + (column - 1);
    }
}