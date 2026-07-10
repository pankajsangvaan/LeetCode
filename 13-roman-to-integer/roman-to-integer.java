import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);

        int ans = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            int x = map.get(String.valueOf(s.charAt(i)));

            if (i != s.length() - 1 &&
                x < map.get(String.valueOf(s.charAt(i + 1)))) {

                ans -= x;
            } else {
                ans += x;
            }
        }

        return ans;
    }
}