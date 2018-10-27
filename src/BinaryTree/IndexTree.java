package BinaryTree;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Your class. Notice how it has no generics.
// This is because we use generics when we have no idea what kind of data we are getting
// Here we know we are getting two pieces of data:  a string and a line number
public class IndexTree {

	// This is your root 
	// again, your root does not use generics because you know your nodes
	// hold strings, an int, and a list of integers
	private IndexNode root;

	
	// Make your constructor
	// It doesn't need to do anything
	
	// complete the methods below

    public IndexTree() {
        this.root = null;

    }

    // this is your wrapper method
	// it takes in two pieces of data rather than one
	// call your recursive add method
	public void add(String word, int lineNumber){
        this.root = add(root, word, lineNumber);
	}
	
	
	
	// your recursive method for add
	// Think about how this is slightly different the the regular add method
	// When you add the word to the index, if it already exists, 
	// you want to  add it to the IndexNode that already exists
	// otherwise make a new indexNode
	private IndexNode add(IndexNode root, String word, int lineNumber){
		if (root == null) {
		    return new IndexNode(word,lineNumber);  //  StackOverflow error
        }
        int compare = word.compareTo(root.word);

        if (compare == 0) {
            root.left = add(root.left,word, lineNumber);
            root.occurences++;
            return root;
        } else if (compare < 0) {
            root.left = add(root.left, word, lineNumber);
            return root;
        } else {
            root.right = add(root.right, word, lineNumber);
            return root;
        }
	}
	
	
	
	
	// returns true if the word is in the index
    public boolean contains(String word) {
        return contains(this.root, word);
    }

	private boolean contains(IndexNode root, String word){
		if (root == null) {
		    return false;
        }

        int compare = word.compareTo(root.word);

		if (compare == 0) {
		    return true;
        }
        else if (compare < 0) {
            return contains(root.left,word);
        }
        else {
            return contains(root.right, word);
        }
	}
	
	// call your recursive method
	// use book as guide
	public void delete(String word){
        this.root = delete(this.root, word);
		
	}

	private IndexNode delete (IndexNode root, String word) {
        word = word.toUpperCase();

        if (root == null) {
            return null;
        }

        int compare = word.compareTo(root.word);

        if (compare < 0) {
            root.left = delete(root.left, word);
            return root;
        } else if (compare > 0) {
            root.right = delete(root.right, word);
            return root;
        } else {  // root is the item we want to delete
            // case 1, root is leaf
            if (root.left == null && root.right == null) {
                return null;
            } // case 2, root has only left child
            else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                IndexNode rootOfLeftSubtree = root.left;
                IndexNode parentOfPredecessor = null;
                IndexNode predecessor = null;
                if (rootOfLeftSubtree.right == null) {
                    root.word = rootOfLeftSubtree.word;
                    root.word = rootOfLeftSubtree.word;
                    return root;
                } else {
                    parentOfPredecessor = rootOfLeftSubtree;
                    IndexNode current = rootOfLeftSubtree.right;
                    while (current.right != null) {
                        parentOfPredecessor = current;
                        current = current.right;
                    }
                    predecessor = current;
                    root.word = predecessor.word;
                    parentOfPredecessor.right = predecessor.left;
                    return root;
                }
            }
        }
    }
	
	// your recursive case
	// remove the word and all the entries for the word
	// This should be no different than the regular technique.

	
	
	// prints all the words in the index in inorder order
	// To successfully print it out
	// this should print out each word followed by the number of occurrences and the list of all occurrences
	// each word and its data gets its own line
	public void printIndex(){
		printIndex(this.root);
	}

	private void printIndex(IndexNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            printIndex(root.left);
        }

        if (root.right != null) {
            printIndex(root.right);
        }

    }


	
	public static void main(String[] args){
		IndexTree index = new IndexTree();

		String fileName = "pg100.txt";
		int lineNum = 1;

		try {
            Scanner scanner = new Scanner(new File(fileName));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //System.out.println(line);
                String words[] = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll(":", "");
                    word = word.replaceAll(",", "");
                    word = word.replaceAll("!", "");
                    word = word.replaceAll("\\.", "");
                    word = word.replaceAll(";", "");
                    word = word.replaceAll("\\?", "");
                    word = word.replaceAll("\\[", "");
                    word = word.replaceAll("\\]", "");
                    word = word.toUpperCase();
                    index.add(word, lineNum);
                }
                lineNum++;  //  The reading and the index tree are working.
            }
            //  Having problem with StackOverFlow after closing the loop
            scanner.close();
        } catch (FileNotFoundException e1) {
		    e1.printStackTrace();
        }
        index.printIndex();
		
		// add all the words to the tree
		
		// print out the index
		
		// test removing a word from the index

		
	}
}
