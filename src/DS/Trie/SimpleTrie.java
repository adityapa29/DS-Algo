package DS.Trie;

class TrieNode {
	
	TrieNode[] children = new TrieNode[26];
	boolean isCompleteWord;
	
	TrieNode() {
		isCompleteWord = false;
		for(int i=0; i<children.length; i++) {
			children[i] = null;
		}
	}
}

public class SimpleTrie {
	
	static TrieNode root;

	public static void main(String[] args) {
		
		String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};
		
		root = new TrieNode();
		
		for(int i=0; i<keys.length; i++) {
			insert(keys[i]);
		}
		
		System.out.println(search("the"));
		System.out.println(search("these"));
		System.out.println(search("their"));
		System.out.println(search("b"));
		System.out.println(search("by"));
		System.out.println(search("bye"));

	}
	
	public static void insert(String word) {
		int index;
		
		TrieNode pCrawl = root;
		
		for(int i=0; i<word.length(); i++) {
			index = word.charAt(i) - 'a';
			if(pCrawl.children[index] == null) {
				pCrawl.children[index] = new TrieNode();
			}
			pCrawl = pCrawl.children[index];
		}
		pCrawl.isCompleteWord = true;
	}
	
	public static boolean search(String word) {
		int index;
		TrieNode pCrawl = root;
		
		for(int i=0; i<word.length(); i++) {
			index = word.charAt(i) - 'a';
			if(pCrawl.children[index] == null)
				return false;
			else {
				pCrawl = pCrawl.children[index];
			}
		}
		return (pCrawl!=null && pCrawl.isCompleteWord);
	}
}
