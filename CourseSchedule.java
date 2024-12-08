class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
           

            Map<Integer, Set<Integer>> map = new HashMap<>();

            for (int[] prerequisite : prerequisites) {
                int dependent = prerequisite[0];
                int dependency = prerequisite[1];

                map.putIfAbsent(dependent, new HashSet<>());
                map.get(dependent).add(dependency);
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                if (!map.containsKey(i)) {
                    queue.add(i);
                }
            }


            List<Integer> keysToRemove = new ArrayList<>();

            while (!queue.isEmpty()) {
                int current = queue.remove();

                for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                    int key = entry.getKey();
                    Set<Integer> set = entry.getValue();
                    if (set.contains(current)) {
                        set.remove(current);
                        if (set.size() == 0) {
                            queue.add(key);
                            // map.remove(key);
                            keysToRemove.add(key);
                        }
                    }
                }
            }

            for (int key : keysToRemove) {
                map.remove(key);
            }

            if (map.size() > 0) {
                return false;
            } else {
               return true;
            }
        }

    }


//Other approach 51 out 54 cases passed, small fix needed
class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            int dependent = prerequisite[0];
            int dependency = prerequisite[1];

            map.putIfAbsent(dependent, new HashSet<>());
            map.get(dependent).add(dependency);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if(!helper(map, entry.getKey(), new HashSet<>())) {
                return false;
            }
        }

        return true;
    }

    public boolean helper(Map<Integer, Set<Integer>> map, int keyToWork, Set<Integer> visited) {
        if (visited.contains(keyToWork)) {
            return false;
        }
        visited.add(keyToWork);
        if (map.containsKey(keyToWork) && map.get(keyToWork).size() > 0) {
            List<Integer> keysToRemove = new ArrayList<>();
            for (int key : map.get(keyToWork)) {
                boolean clear = helper(map, key, visited);
                if (clear == true) {
                    keysToRemove.add(key);
                } else {
                    return false;
                }
            }
            for (int key : keysToRemove) {
                map.get(keyToWork).remove(key);
            }
            if (map.get(keyToWork).isEmpty()) {
                return true;
            }
            return false;
        } else {
            return true;
        }
    }

}


