public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        /* store the string can access to other strings */
        Map<String,Set<String>> access=new HashMap<>();
        /* store the steps to arrive the string */
        Map<String,Integer> step=new HashMap<>();
        step.put(beginWord,1);
        while(!queue.isEmpty()){
            String temp=queue.poll();
            for(int i=0;i<temp.length();i++){
                StringBuilder sb=new StringBuilder(temp);
                for (char alpha='a';alpha<='z';alpha++){
                    if(alpha==temp.charAt(i)) continue;
                    sb.setCharAt(i,alpha);
                    if(wordList.contains(sb.toString())){
                        queue.offer(sb.toString());
                        
                        if(step.containsKey(sb.toString())){
                            step.put(sb.toString(),Math.min(step.get(sb.toString()),step.get(temp)+1));
                        }
                        else {
                            step.put(sb.toString(),step.get(temp)+1);
                        }
                        if(sb.toString().equals(endWord)) return step.get(endWord);
                    }
                }
            }
        }
        return 0;
    }
}
