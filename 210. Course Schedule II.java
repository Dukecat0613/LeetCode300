public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> access = new HashMap<>();
        Map<Integer, Integer> preNums = new HashMap<>();
        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            int prior = prerequisites[i][1];
            int later = prerequisites[i][0];
            preNums.put(later, preNums.getOrDefault(later, 0) + 1);
            List<Integer> tmp = access.getOrDefault(prior, new ArrayList<Integer>());
            tmp.add(later);
            access.put(prior, new ArrayList<>(tmp));
        }
        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[numCourses];
        int index = 0;
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (!preNums.containsKey(i)) {
                res[index++] = i;
                q.add(i);
                count++;
            }
        }
        while (!q.isEmpty()) {
            int prior = q.poll();
            List<Integer> priorCanAccess = access.getOrDefault(prior, null);
            if (priorCanAccess != null) {
                int size = priorCanAccess.size();
                for (int i = 0; i < size; i++) {
                    int tmpCourse = priorCanAccess.get(i);
                    int tmpCoursePreNums = preNums.getOrDefault(tmpCourse, -1);
                    if (tmpCoursePreNums == 1) {
                        res[index++] = tmpCourse;
                        count++;
                        q.add(tmpCourse);
                        preNums.remove(tmpCourse);
                    } else if (tmpCoursePreNums > 1) {
                        preNums.put(tmpCourse, tmpCoursePreNums - 1);
                    }
                }
            }
        }
        if (count != numCourses)  {
            return new int[]{};
        } else {
            return res;
        }
    }
}
