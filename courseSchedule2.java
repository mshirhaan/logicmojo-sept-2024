class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
            Map<Integer, Set<Integer>> map = new HashMap<>();

            int[] order = new int[n];
            int k = 0;

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
                    order[k++] = i;
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
                            order[k++] = key;
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
                return new int[0];
            } 
            return order;
        }
    }
