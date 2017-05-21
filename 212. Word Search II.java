public class Solution {
    public class TrieNode {
        boolean isBegin;
        boolean isEnd;
        char c;
        String word;
        TrieNode[] child;
        public TrieNode (char c) {
            this.c = c;
            child = new TrieNode[26];
        }
        
    }
    
    
    public void addWord (TrieNode root, String [] words) {
        for (int i = 0; i < words.length; i++) {
            TrieNode cur = root;
            for (int j = 0; j < words[i].length(); i++) {
                if (cur.child[words[i].charAt(j) - 'a'] == null) {
                    cur.child[words[i].charAt(j) - 'a'] = new TrieNode(words[i].charAt(j));
                }
                if (j == 0) {
                    cur.child[words[i].charAt(j) - 'a'].isBegin = true;
                }
                cur = cur.child[words[i].charAt(j) - 'a' ];
            }
            cur.isEnd = true;
            cur.word = words[i];
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        List<String> res = new ArrayList<>();
        if (n == 0 || words.length == 0 || words[0].length() == 0) {
            return res;
        }
        int m = board[0].length;
        TrieNode root = new TrieNode('A');    
        addWord(root, words);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(root.child, board, i, j, res);
            }
        }
        return res;
    }
    
    public void dfs(TrieNode[] child, char[][] board, int x, int y, List<String> res) {
        int n = board.length;
        int m = board[0].length;
        if (x >= n || x < 0 || y >= m || y < 0){
            return;
        }
        if (board[x][y] == '#' || child[board[x][y] - 'a'] == null) {
            return;
        }
        if (child[board[x][y] - 'a'].isEnd) {
            res.add(child[board[x][y] - 'a'].word);
            child[board[x][y] - 'a'].isEnd = false;
        }
        char cur = board[x][y];
        board[x][y] = '#';
        dfs(child[cur - 'a'].child, board, x + 1, y, res);
        dfs(child[cur - 'a'].child, board, x - 1, y, res);
        dfs(child[cur - 'a'].child, board, x, y + 1, res);
        dfs(child[cur - 'a'].child, board, x, y - 1, res);
        board[x][y] = cur;
    }  
}
