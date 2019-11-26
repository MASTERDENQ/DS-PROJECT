/**
 * Written By :
 * Tyrone Wallace - 1706903
 * Dimitri Russell - 1801488
 * Reinaldo Peno - 1803640
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Written By :
 * Tyrone Wallace - 1706903
 * Dimitri Russell - 1801488
 * Reinaldo Peno - 1803640
 */

//class: O(nlog(n))

public class Tree {
	private LeafNode root;

	//populates the tree with location id numbers
	
	//function: O(nlog(n))
	public void populate() {
		int placeID = 0;
		try {
			File file = new File("startingID.txt");

			Scanner fileReader;
			fileReader = new Scanner(file);

			placeID = Integer.parseInt(fileReader.next());

			fileReader.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Failed to read from file");
		}
		
		for(int i=100; i < placeID; i++) {
			setRoot(insert(getRoot(), i)); 
		}
	}
	
	//Searches the tree for a locations id number and returns the line that the locations information is saved to in file
	
	//function: O(log(n))
	public int search(int searchFor) {
		LeafNode current = root;

		while (true) {
			if (current.getKey() == searchFor) {
				return current.getFileLine();
			} else if (current.getKey() > searchFor) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
	}
	
	//function: O(1)
	public int height(LeafNode N) {
		if (N == null)
			return 0;

		return N.getHeight();
	}
	
	//function: O(1)
	public int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	//function: O(1)
	public LeafNode rightRotate(LeafNode y) {
		LeafNode x = y.getLeft();
		LeafNode T2 = x.getRight();

		x.setRight(y);
		y.setLeft(T2);

		y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
		x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

		return x;
	}
	
	//function: O(1)
	public LeafNode leftRotate(LeafNode x) {
		LeafNode y = x.getRight();
		LeafNode T2 = y.getLeft();

		y.setLeft(x);
		x.setRight(T2);

		x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
		y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

		return y;
	}

	//function: O(1)
	public int getBalance(LeafNode N) {
		if (N == null)
			return 0;
		//return balance factor
		return height(N.getLeft()) - height(N.getRight());
	}
	
	//function: O(log(n))
	public LeafNode insert(LeafNode LeafNode, int key) {
		
		//if root empty, set key as root
		if (LeafNode == null)
			return (new LeafNode(key));
		
		//insertion
		if (key < LeafNode.getKey())
			LeafNode.setLeft(insert(LeafNode.getLeft(), key));
		else if (key > LeafNode.getKey())
			LeafNode.setRight(insert(LeafNode.getRight(), key));
		else
			return LeafNode;

		//set height of node in question
		LeafNode.setHeight(1 + max(height(LeafNode.getLeft()), height(LeafNode.getRight())));
		
		//calculate Balance Factor
		int balance = getBalance(LeafNode);

		
		if (balance > 1 && key < LeafNode.getLeft().getKey())
			return rightRotate(LeafNode);

		if (balance < -1 && key > LeafNode.getRight().getKey())
			return leftRotate(LeafNode);

		if (balance > 1 && key > LeafNode.getLeft().getKey()) {
			LeafNode.setLeft(leftRotate(LeafNode.getLeft()));
			return rightRotate(LeafNode);
		}

		if (balance < -1 && key < LeafNode.getRight().getKey()) {
			LeafNode.setRight(rightRotate(LeafNode.getRight()));
			return leftRotate(LeafNode);
		}

		return LeafNode;
	}
	
	//function: O(1)
	public LeafNode getRoot() {
		return root;
	}
	
	//function: O(1)
	public void setRoot(LeafNode node) {
		root = node;
	}
}
