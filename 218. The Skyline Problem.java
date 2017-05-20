/**
* The idea is to split the buildings to index, height pair. The height of beginning index is negative, and the ending is positive.
* Sort the pair through comparing the index, if the index are same, taller height is prior. Then we maintain a heap to generate the skyline height iteratively.
*/
public class Solution {
    public class Height {
        int index;
        int height;
        public Height(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        int len = buildings.length;
        if (len == 0 || buildings[0].length == 0) {
            return res;  
        }
        
        // change buildings into height, index pair
        List<Height> heights = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            heights.add(new Height(buildings[i][0], -buildings[i][2]));
            heights.add(new Height(buildings[i][1], buildings[i][2]));
        }
        Collections.sort(heights, new Comparator<Height>(){
            @Override
            public int compare(Height a, Height b) {
                if (a.index == b.index) {
                    return a.height - b.height;
                } else {
                    return a.index - b.index;
                }
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.offer(0);
        int prev = 0;
        for (Height tmp : heights) {
            if (tmp.height < 0) {
                pq.offer(-tmp.height);
            } else {
                pq.remove(tmp.height);
            }
            int cur = pq.peek();
            if (cur != prev) {
                res.add(new int[]{tmp.index, cur});
                prev = cur;
            }
        }
        return res;
    }
}
