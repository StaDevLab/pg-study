class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0; // 콜라의 총 개수

        while (n >= a) { // 빈 병이 a개 이상 있을 때만 콜라로 교환 가능
            int exchange = n / a; // 현재 빈 병으로 몇 번 교환할 수 있는지 계산
            int received = exchange * b; // 교환해서 받을 수 있는 콜라 병 수를 계산
            int remain = n % a; // 교환하지 못하고 남는 빈 병 개수를 계산

            answer += received; // 이번 교환으로 받은 콜라 병 수를 총합에 더함
            n = remain + received; // 남은 빈 병과 새로 받은 콜라를 마신 뒤 생기는 빈 병을 합침
        }

        return answer;
    }
}