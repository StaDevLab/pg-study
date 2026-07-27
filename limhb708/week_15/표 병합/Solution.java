import java.util.*;

class Solution {

    // 부모 노드 저장 배열
    private int[] parent = new int[2501];

    // 각 그룹의 값 저장
    private String[] value = new String[2501];

    public String[] solution(String[] commands) {

        // 모든 셀을 자기 자신으로 초기화
        for (int i = 1; i <= 2500; i++) {

            parent[i] = i;
        }

        // PRINT 결과 저장
        List<String> answer = new ArrayList<>();

        // 모든 명령어 수행
        for (String command : commands) {

            // 공백 기준 분리
            String[] split = command.split(" ");

            // UPDATE 명령
            if (split[0].equals("UPDATE")) {

                // UPDATE r c value
                if (split.length == 4) {

                    // 행
                    int r = Integer.parseInt(split[1]);

                    // 열
                    int c = Integer.parseInt(split[2]);

                    // 값
                    String newValue = split[3];

                    // 셀 번호 변환
                    int cell = convert(r, c);

                    // 대표 노드 찾기
                    int root = find(cell);

                    // 값 변경
                    value[root] = newValue;
                }

                // UPDATE value1 value2
                else {

                    // 변경 전 값
                    String oldValue = split[1];

                    // 변경 후 값
                    String newValue = split[2];

                    // 모든 셀 확인
                    for (int i = 1; i <= 2500; i++) {

                        // 값이 같은 경우
                        if (oldValue.equals(value[i])) {

                            // 값 변경
                            value[i] = newValue;
                        }
                    }
                }
            }

            // MERGE 명령
            else if (split[0].equals("MERGE")) {

                // 첫 번째 셀
                int cell1 = convert(
                        Integer.parseInt(split[1]),
                        Integer.parseInt(split[2])
                );

                // 두 번째 셀
                int cell2 = convert(
                        Integer.parseInt(split[3]),
                        Integer.parseInt(split[4])
                );

                // 병합 수행
                merge(cell1, cell2);
            }

            // UNMERGE 명령
            else if (split[0].equals("UNMERGE")) {

                // 셀 번호
                int cell = convert(
                        Integer.parseInt(split[1]),
                        Integer.parseInt(split[2])
                );

                // 병합 해제
                unmerge(cell);
            }

            // PRINT 명령
            else {

                // 셀 번호
                int cell = convert(
                        Integer.parseInt(split[1]),
                        Integer.parseInt(split[2])
                );

                // 대표 노드 찾기
                int root = find(cell);

                // 값이 없으면 EMPTY
                if (value[root] == null) {

                    answer.add("EMPTY");
                }

                // 값 출력
                else {

                    answer.add(value[root]);
                }
            }
        }

        // 결과 반환
        return answer.toArray(new String[0]);
    }

    // 좌표를 번호로 변환
    private int convert(int r, int c) {

        return (r - 1) * 50 + c;
    }

    // 대표 노드 찾기
    private int find(int x) {

        // 자기 자신이면 반환
        if (parent[x] == x) {

            return x;
        }

        // 경로 압축
        return parent[x] = find(parent[x]);
    }

    // 셀 병합
    private void merge(int a, int b) {

        // 대표 노드 찾기
        int rootA = find(a);

        // 대표 노드 찾기
        int rootB = find(b);

        // 이미 같은 그룹
        if (rootA == rootB) {

            return;
        }

        // 병합 후 사용할 값
        String mergedValue;

        // rootA 값 우선 사용
        if (value[rootA] != null) {

            mergedValue = value[rootA];
        }

        // rootB 값 사용
        else {

            mergedValue = value[rootB];
        }

        // 그룹 병합
        parent[rootB] = rootA;

        // 대표 노드 값 저장
        value[rootA] = mergedValue;

        // 기존 값 제거
        value[rootB] = null;
    }

    // 병합 해제
    private void unmerge(int cell) {

        // 대표 노드
        int root = find(cell);

        // 현재 값 저장
        String currentValue = value[root];

        // 같은 그룹 셀 저장
        List<Integer> group = new ArrayList<>();

        // 모든 셀 확인
        for (int i = 1; i <= 2500; i++) {

            // 같은 그룹인 경우
            if (find(i) == root) {

                group.add(i);
            }
        }

        // 그룹 해제
        for (int node : group) {

            parent[node] = node;

            value[node] = null;
        }

        // 선택 셀만 값 유지
        value[cell] = currentValue;
    }
}