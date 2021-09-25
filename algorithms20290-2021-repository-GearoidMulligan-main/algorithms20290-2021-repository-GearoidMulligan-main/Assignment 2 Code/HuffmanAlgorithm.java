/******************************************************************************
 *  Compilation:  javac HuffmanAlgorithm.java
 *
 *  Compress or expand a binary input stream using the Huffman algorithm.
 *
 * to Compress to new file: java HuffmanAlgorithm compress<filename to compress>name of new compressed file 
 * 
 * to compress file:java HuffmanAlgorithm compress<filename
 * 
 * 
 * to Decompress to new file: java HuffmanAlgorithm decompress<filename to decompress>name of new decompressed file
 * 
 * to Decompress file:java HuffmanAlgorithm decompress<filename
 * 
 * count bits: java BinaryDump< filename
 *
 ******************************************************************************/


/**
 * compress(): Reads a sequence of 8-bit bytes from standard input; compresses them
 * using Huffman codes with an 8-bit alphabet; and writes the results
 * to standard output.
 * 
 * decompress(): Reads a sequence of bits that represents a Huffman-compressed message from
 * standard input; expands them; and writes the results to standard output.
 *
 *buildTrie(int[] freq): bulids a huffman tree given the frequency of each letter in the text:
 *
 *  @author Gearoid Mulligan
 */
public class HuffmanAlgorithm {

    // alphabet size of extended ASCII
    private static final int R = 256;

    // Do not instantiate.
    private HuffmanAlgorithm() { }

    // Huffman trie node
    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        // is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        // compare, based on frequency
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    /**
     * Reads a sequence of 8-bit bytes from standard input; compresses them
     * using Huffman codes with an 8-bit alphabet; and writes the results
     * to standard output.
     */
    public static void compress() {
        // read the input
    	String input = BinaryStdIn.readString();
    	int len=input.length();
    	char[] count =  input.toCharArray();
    	int charLen=count.length;

        // tabulate frequency counts
    	int[] frequency = new int[R];
    	for(int i=0;i<len;i++) {
    		frequency[count[i]]++;
    	}
        // build Huffman trie
    	Node Root=buildTrie(frequency);


        // build code table
    	String[] code=new String[R];
    	String Code = new String();
    	buildCode(code,Root,Code);

        // print trie for decoder
    	writeTrie(Root);

        // print number of bytes in original uncompressed message
    	BinaryStdOut.write(charLen);

        // use Huffman code to encode input
    	for(int i=0;i<charLen;i++) {/**/
    		for(int j=0;j<code[count[i]].length();j++) {
    			if(code[count[i]].charAt(j)=='0') {
    				BinaryStdOut.write(false);
    			}
    			if(code[count[i]].charAt(j)=='1') {
    				BinaryStdOut.write(true);
    			}
    		}
    	}

    	BinaryStdOut.close();
    }


    /**
     * Reads a sequence of bits that represents a Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void decompress() {

        // read in Huffman trie from input stream
    	Node Root=readTrie();
    	
        // number of bytes to write
    	int len=BinaryStdIn.readInt();
    	
        // decode using the Huffman trie
    	for (int i = 0; i < len; i++) {
	    	Node n = Root;
	        while (n.isLeaf()==false) {
	            boolean checkBit = BinaryStdIn.readBoolean();
	            if (checkBit==true) { 
	            	n = n.right;
	            	}
	            else {    
	            	n = n.left;
	            }
	        }
	        BinaryStdOut.write(n.ch, 8);
    	}
        BinaryStdOut.close();
    }
   

    // build the Huffman trie given frequencies
    private static Node buildTrie(int[] freq) {

        // initialze priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<Node>();
        for (char i = 0; i < R; i++)
            if (freq[i] > 0)
                pq.insert(new Node(i, freq[i], null, null));

        // special case in case there is only one character with a nonzero frequency
        if (pq.size() == 1) {
            if (freq['\0'] == 0) pq.insert(new Node('\0', 0, null, null));
            else                 pq.insert(new Node('\1', 0, null, null));
        }

        // merge two smallest trees
        while (pq.size() > 1) {
            Node left  = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }


    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch, 8);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    // make a lookup table from symbols and their encodings
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[x.ch] = s;
        }
    }



    private static Node readTrie() {
        boolean isLeaf = BinaryStdIn.readBoolean();
        if (isLeaf) {
            return new Node(BinaryStdIn.readChar(), -1, null, null);
        }
        else {
            return new Node('\0', -1, readTrie(), readTrie());
        }
    }

    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "compress" an {@code decompress()} if it is "decompress".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
    	if      (args[0].equals("compress")) {
    		compress();
    	}
    	
    	
       if(args[0].equals("decompress")) {
        	decompress();
        }
       
    }

}