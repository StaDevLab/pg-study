import java.util.*;

class Solution {
    public String solution(String s) {

        StringTokenizer st = new StringTokenizer(s);

        ArrayList<Integer> al = new ArrayList<>();

        while (st.hasMoreTokens()) {
            al.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(al);

        StringBuilder sr = new StringBuilder();

        sr.append(al.get(0)).append(" ").append(al.get(al.size()-1));

        return sr.toString();
    }
}