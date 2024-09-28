class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String leader = new String(chars);
            if(map.get(leader) == null) {
                map.put(leader,new ArrayList<>());
            }
            map.get(leader).add(str);
        }
       
       List<List<String>> values = new ArrayList<>(map.values());
       return values;
    }
}