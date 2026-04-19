import java.util.*;

class Solution {

    public int solution(int[] ingredient) {

        int answer = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < ingredient.length; i++) {

            stack.push(ingredient[i]);

            if (ingredient[i] == 1 && stack.size() >= 4) {

                boolean burger = true;

                int bt = stack.pop();
                int meat = stack.pop();
                if (meat != 3) burger = false;
                int veg = stack.pop();
                if (veg != 2) burger = false;
                int bb = stack.pop();
                if (bb != 1) burger = false;

                if (burger) {
                    answer++;
                }
                else {
                    stack.push(bb);
                    stack.push(veg);
                    stack.push(meat);
                    stack.push(bt);
                }

            }

        }

        return answer;
    }
}