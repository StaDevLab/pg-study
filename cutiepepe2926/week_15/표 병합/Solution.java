import java.util.*;

class Solution {

    int[] parent = new int[2500];
    String[] value = new String[2500];

    public String[] solution(String[] commands) {

        List<String> answer = new ArrayList<>();

        // 처음에는 모든 셀이 각각 하나의 집합
        for (int i = 0; i < 2500; i++) {
            parent[i] = i;
        }

        for (String command : commands) {

            String[] split = command.split(" ");

            if (split[0].equals("UPDATE")) {

                // UPDATE r c value
                if (split.length == 4) {

                    int r = Integer.parseInt(split[1]);
                    int c = Integer.parseInt(split[2]);

                    int now = getNumber(r, c);
                    int root = find(now);

                    value[root] = split[3];

                    // UPDATE value1 value2
                } else {

                    String before = split[1];
                    String after = split[2];

                    updateAll(before, after);
                }

            } else if (split[0].equals("MERGE")) {

                int r1 = Integer.parseInt(split[1]);
                int c1 = Integer.parseInt(split[2]);
                int r2 = Integer.parseInt(split[3]);
                int c2 = Integer.parseInt(split[4]);

                int first = getNumber(r1, c1);
                int second = getNumber(r2, c2);

                merge(first, second);

            } else if (split[0].equals("UNMERGE")) {

                int r = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);

                int now = getNumber(r, c);

                unmerge(now);

            } else if (split[0].equals("PRINT")) {

                int r = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);

                int now = getNumber(r, c);
                int root = find(now);

                if (value[root] == null) {
                    answer.add("EMPTY");
                } else {
                    answer.add(value[root]);
                }
            }
        }

        return answer.toArray(new String[0]);
    }

    // 2차원 좌표를 1차원 번호로 변경
    public int getNumber(int r, int c) {
        return (r - 1) * 50 + (c - 1);
    }

    // 대표 셀 찾기
    public int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    // 두 셀 병합
    public void merge(int first, int second) {

        int firstRoot = find(first);
        int secondRoot = find(second);

        // 이미 같은 그룹
        if (firstRoot == secondRoot) {
            return;
        }

        /*
         * 첫 번째 셀에 값이 있으면 첫 번째 값 사용
         * 첫 번째 셀에 값이 없으면 두 번째 값 사용
         */
        String mergedValue;

        if (value[firstRoot] != null) {
            mergedValue = value[firstRoot];
        } else {
            mergedValue = value[secondRoot];
        }

        // 두 번째 그룹을 첫 번째 그룹에 병합
        parent[secondRoot] = firstRoot;

        // 값은 대표 셀에만 저장
        value[firstRoot] = mergedValue;
        value[secondRoot] = null;
    }

    // 같은 값을 가진 모든 셀 변경
    public void updateAll(String before, String after) {

        for (int i = 0; i < 2500; i++) {

            if (value[i] != null && value[i].equals(before)) {
                value[i] = after;
            }
        }
    }

    // 병합 해제
    public void unmerge(int now) {

        int root = find(now);

        // 병합 해제 전 값 저장
        String savedValue = value[root];

        List<Integer> mergedCells = new ArrayList<>();

        /*
         * 먼저 같은 그룹의 셀을 전부 찾는다.
         *
         * 찾는 도중 parent를 초기화하면
         * 뒤의 셀들이 기존 root를 찾지 못할 수 있다.
         */
        for (int i = 0; i < 2500; i++) {

            if (find(i) == root) {
                mergedCells.add(i);
            }
        }

        // 찾은 셀들의 병합 관계 및 값 초기화
        for (int cell : mergedCells) {
            parent[cell] = cell;
            value[cell] = null;
        }

        // 선택한 셀만 기존 값을 유지
        value[now] = savedValue;
    }
}