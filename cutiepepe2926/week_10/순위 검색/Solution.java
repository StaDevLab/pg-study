import java.util.*;

class Solution {

    // 초이스 목록 : 개발언어(3), 직군(2), 경력(2), 소울(2)
    // [조건]을 만족하는 사람 중 코딩테스트 점수를 X점 이상 받은 사람은 모두 몇 명?
    // 쿼리 조건이 많아서 info 전체 탐색은 의미가 없음
    // 언어, 직군, 경력, 소울에 대해서 HashMap으로 묶고 점수만 배열정렬해 저장으로 처리
    // 쿼리 별로 정렬된 배열을 꺼내 갯수 구하기

    public int[] solution(String[] info, String[] query) {

        int[] answer = new int[query.length];

        HashMap<String, ArrayList<Integer>> map = new HashMap<>(); // 검색 조건
        Integer[] onlyScore = new Integer[info.length]; // 조건없이 점수만

        for (int i = 0; i < info.length; i++) {

            String[] arr = info[i].split(" ");

            String language = arr[0];
            String position = arr[1];
            String career = arr[2];
            String soul = arr[3];
            int score = Integer.parseInt(arr[4]);

            onlyScore[i] = score;

            String[] languages = {language, "-"};
            String[] positions = {position, "-"};
            String[] careers = {career, "-"};
            String[] souls = {soul, "-"};

            for (String l : languages) {
                for (String p : positions) {
                    for (String c : careers) {
                        for (String s : souls) {

                            String key = l + p + c + s;

                            // 조건이 전부 - 인 경우는 onlyScore로 따로 처리
                            if (key.equals("----")) {
                                continue;
                            }

                            if (!map.containsKey(key)) {
                                map.put(key, new ArrayList<>());
                            }

                            map.get(key).add(score);
                        }
                    }
                }
            }
        }

        // 조건 없는 전체 점수 정렬
        Arrays.sort(onlyScore);

        // 조건별 점수 정렬
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < query.length; i++) {

            String q = query[i].replace(" and ", " ");
            String[] arr = q.split(" ");

            String language = arr[0];
            String position = arr[1];
            String career = arr[2];
            String soul = arr[3];
            int score = Integer.parseInt(arr[4]);

            String key = language + position + career + soul;

            if (key.equals("----")) {
                int index = binarySearch(onlyScore, score);
                answer[i] = onlyScore.length - index;
                continue;
            }

            if (!map.containsKey(key)) {
                answer[i] = 0;
                continue;
            }

            ArrayList<Integer> list = map.get(key);

            int index = binarySearch(list, score);
            answer[i] = list.size() - index;
        }

        return answer;
    }

    static int binarySearch(ArrayList<Integer> list, int score) {

        int left = 0;
        int right = list.size();

        while (left < right) {

            int mid = (left + right) / 2;

            if (list.get(mid) >= score) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static int binarySearch(Integer[] arr, int score) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = (left + right) / 2;

            if (arr[mid] >= score) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}