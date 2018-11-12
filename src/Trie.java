
import java.util.HashMap;

public class Trie {

    public static class Node {
        HashMap<Character, Node> children;
        String content;
        boolean isWord;

        public Node(String content, boolean isWord) {
            this.content = content;
            this.isWord = isWord;
            this.children = new HashMap<>();
        }
    }

    private Node root = new Node("", false);

    public boolean insert(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Node n = cur.children.get(c);
            if (n == null) {
                n= new Node(s.substring(0, i + 1), i == s.length());
                cur.children.put(c, n);
            } else {
                n.isWord = (i == s.length());
            }
            cur = n;
        }
        return true;
    }

    public boolean find(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            Node next = cur.children.get(s.charAt(i));
            if (next == null) {
                return false;
            } else {
                if (i == s.length() && next.isWord) {
                    return true;
                }
                cur = next;
            }
        }
        return false;
    }

    public boolean delete(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            Node next = cur.children.get(s.charAt(i));
            if (next == null) {
                return false;
            } else {
                if (i == s.length()) {
                    if (next.children.size() == 0) {
                        cur.children.remove(s.charAt(i));
                        return true;
                    } else if (next.isWord) {
                        next.isWord = false;
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            cur = next;
        }
        return false;
    }
}
