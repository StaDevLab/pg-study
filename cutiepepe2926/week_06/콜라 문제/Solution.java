class Solution {

    static int newCola = 0;

    public int solution(int a, int b, int n) {

        int answer = cola(a, b, n);

        return answer;

    }

    public int cola(int a, int b, int n) {

        if (n < a) {
            return newCola;
        }


        // 새로 받은 콜라병
        int getNewCola = (n / a) * b;

        // 최종 적으로 남은 빈 콜라병(남은 빈 콜라병 + 새로 받은 콜라병(마시고 난 후 ))
        int remainUsedCola = (n % a) + getNewCola;

        // 현재까지 받은 새 콜라병 누적
        newCola = newCola + getNewCola;

        return cola(a, b, remainUsedCola);
    }

}