import java.util.HashMap;

/**
 * Created by Administrator on 2016/6/23.
 * 单词树
 */
public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("lintcode");
        trie.search("lint");//true
        trie.startsWith("lint");//false
    }
}
class TrieNode {
    boolean hasWord;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    char c;
    public TrieNode() {

    }
    public TrieNode(char c) {
        this.c = c;
    }
}
class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = root.children;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            char wc = wordArray[i];
            if (curChildren.containsKey(wc)) {
                cur = curChildren.get(wc);
            } else {
                TrieNode newNode = new TrieNode(wc);
                curChildren.put(wc, newNode);
                cur = newNode;
            }
            curChildren = cur.children;
            if (i == wordArray.length - 1) {
                cur.hasWord = true;
            }
        }
    }
    public boolean search(String word) {
        if (searchWordNodePos(word) == null) {
            return false;
        } else if (searchWordNodePos(word).hasWord) {
            return true;
        } else {
            return false;
        }
    }
    public boolean startsWith(String prefix) {
        if (searchWordNodePos(prefix) == null) {
            return false;
        }
        return true;
    }
    public TrieNode searchWordNodePos(String s) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode cur = null;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (children.containsKey(c)) {
                cur = children.get(c);
                children = cur.children;
            } else {
                return null;
            }
        }
        return cur;
    }
}