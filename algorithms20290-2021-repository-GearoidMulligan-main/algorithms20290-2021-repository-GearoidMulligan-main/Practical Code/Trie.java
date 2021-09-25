
public class Trie {
	// Alphabet size (# of symbols) we pick 26 for English alphabet
	static final int ALPHABET_SIZE = 26; 


	// class for Trie node 
	static class TrieNode { 
	TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
	// isEndOfWord is true if the node represents end of a word i.e. leaf node
	boolean isEndOfWord; 

	TrieNode(){ 
	isEndOfWord = false; 

	for (int i = 0; i < ALPHABET_SIZE; i++) 
	children[i] = null; 
	} 
	}

	static TrieNode root;
	// If not key present, inserts into trie 
	// If the key is prefix of Trie node,  
	//  marks leaf node
	static void insert(String key){ 
		TrieNode curr=root;
		
		for(int i=0;i<key.length();i++) {

			int letter =key.charAt(i)-'a';
			
			if(curr.children[letter]==null) {
				curr.children[letter]=new TrieNode();
			}
			curr=curr.children[letter];
		}
		curr.isEndOfWord=true;
	} 

	// Returns true if key presents in trie, else false 
	static boolean search(String key) { 
		TrieNode curr=root;
		
		for(int i=0;i<key.length();i++) {

			int letter =key.charAt(i)-'a';
			
			if(curr.children[letter]==null) {
				return false;
			}
			curr=curr.children[letter];
		}
		if(curr!=null&&curr.isEndOfWord) {
			return true;
		}
		else {
			return false;
		}
		
	} 


	// Driver 
	public static void main(String args[]) { 

	// Input keys (use only 'a' through 'z' and lower case) 
	String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};


	String output[] = {"Not present in trie", "Present in trie"}; 

	root = new TrieNode(); 

	// Construct trie 
	int i; 
	for (i = 0; i < keys.length ; i++) {
	insert(keys[i]); 
	}

	System.out.print(search("film"));


	} 

	//end of class
}
