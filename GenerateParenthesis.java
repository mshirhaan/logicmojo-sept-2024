class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n,0, 0,result, "");
        return result;
    }

    public void helper(int n, int oc, int cc, List<String> result, String str) {
        if(str.length() == n*2) {
            result.add(str);
            return;
        }
        if(oc==n) {
            //You can only close
            helper(n, oc, cc+1, result, str+")");
            return;
        }
        if(cc < oc) {
            //you have two options
            helper(n, oc+1, cc, result, str+"(");
            helper(n, oc, cc+1, result, str+")");
            return;
        }
        helper(n, oc+1, cc, result, str+"(");
    }
}
