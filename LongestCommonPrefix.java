class Solution {
    public String longestCommonPrefix(String[] strs) {

        int count = 0;

        for (int i = 0; i < strs[0].length(); i++) {
            boolean flag = true;
            for (String str : strs) {
                if (i >= str.length() || strs[0].charAt(i) != str.charAt(i)) {
                    flag = false;
                    break;
                }

            }
            if (flag == false) {
                break;
            }
            count++;
        }
        return strs[0].substring(0, count);
    }
}