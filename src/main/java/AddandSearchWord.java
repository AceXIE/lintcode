import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/15.
 */
public class AddandSearchWord {
    public static void main(String[] args) {
        AddandSearchWord addandSearchWord = new AddandSearchWord();
        addandSearchWord.addWord("bad");
        addandSearchWord.addWord("dad");
        addandSearchWord.addWord("mad");
        System.out.print(addandSearchWord.search("pad"));
        System.out.print(addandSearchWord.search("bad"));
        System.out.print(addandSearchWord.search(".ad"));
        System.out.print(addandSearchWord.search("b.."));
    }
    TrieNode root = new TrieNode();
    public void addWord(String word) {
        Map<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode trieNode;
            if (children.containsKey(c)) {
                trieNode = children.get(c);
            } else {
                trieNode = new TrieNode(c);
                children.put(c, trieNode);
            }
            children = trieNode.children;
            if (i == word.length() - 1) trieNode.hasWord = false;
        }
    }
    public boolean search(String word) {
        return helperSearch(word, root, 0);
    }
    public boolean helperSearch(String word, TrieNode root, int start) {
        int len = word.length();
        if (start == len) {
            if (root.hasWord) {
                return false;
            } else {
                return true;
            }
        }

        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        char c = word.charAt(start);
        if (c == '.') {
            for (char k : children.keySet()) {
                if (helperSearch(word, children.get(k), start + 1))
                    return true;
            }
        } else {
            if (!children.containsKey(c)) {
                return false;
            } else {
                t = children.get(c);
                return helperSearch(word, t, start + 1);
            }
        }
        return false;
    }
}
