package Treap;

import java.util.Random;
import java.util.Stack;

/** 
 * @author Rishikesh Yadav CWID : 20007668
 * @param <E> Generic Type Data
 */
public class Treap<E extends Comparable<E>> {
	
	/**
	 * private class Node to create and manipulate node
	 * @param <E>
	 */
	private class Node<E>{
		
		//Data Fields
		public  E  data;
		public int  priority;
		public Node <E >  left; 
		public Node <E >  right;
		
		/**
		* Constructor
		* @param data key to be stored for sorting
	    * @param priority .. Priority to create the max-heap
	    */  
		public Node(E data, int priority) {
			if(data == null) {
				throw new NullPointerException("Data not provided");
			}
			this.data = data;
			this.priority = priority;
			this.left = null;
			this.right = null;
		}
		
		/**Methods
		 * Performs Right rotation 
		 * @return The root node of result tree
		 */
		public Node<E > rotateRight(){
			Node<E> newRoot = new Node<E>(data, priority);
			if(this.left != null) {
				this.data = this.left.data;
				this.priority = this.left.priority;
				newRoot.left = this.left.right;
				newRoot.right = this.right;
				this.left = this.left.left;
				this.right = newRoot;
			}
			return this;
		}
		
		/**Methods
		 * Performs Left Rotation
		 * @return The root node of result tree
		 */
		public Node<E > rotateLeft(){
			Node<E> newRoot = new Node<E>(data, priority);
			if(this.right!=null)
			{
				this.data = this.right.data;
				this.priority = this.right.priority;
				newRoot.left = this.left;
				newRoot.right = this.right.left;
				this.left = newRoot;								
				this.right = this.right.right;
			}
			return this;
		}
		
	}
	
	//Data Fields
	private Node<E> root;
	private Random priorityGenerator;
	
	/**
	 * Empty constructor
	 * Creates an empty Treap
	 */
	public Treap(){
		priorityGenerator = new Random();
		root = null;
	}
	
	/**
	 * Constructor with parameter
	 * Initializes priorityGenerator using new Random(seed)
	 * @param seed
	 */
	public Treap(long seed){
		priorityGenerator = new Random(seed);
		root = null;
	}
	
	/**
	 * This function takes just the key and creates priority and perform insertion in tree
	 * @param key The key which will be added to tree
	 * @return Boolean value of addition operation
	 */
	boolean add(E key){
		int a = priorityGenerator.nextInt();
		return add(key, a);
	}
	
	/**
	 * This function takes key and priority and insert and arrange the tree
	 * @param key The key which will be added to tree
	 * @param priority Priority on which max-heap will be arranged
	 * @return Boolean value of addition operation
	 */
	boolean add(E key, int priority)
	{
		Node<E > newNode = new Node<E>(key, priority);
		Node<E > temp = root;
		Stack<Node> stack = new Stack<Node>();
		if(root==null)
		{
			root = new Node(key, priority);
			return true;
		}
		if(find(key)){
			return false;
		}
		while(temp!=null)
		{
			stack.push(temp);
			if((key.compareTo(temp.data)) < 0)
				temp = temp.left;
			else
				temp = temp.right;
		}
		
		if((key.compareTo((E)stack.peek().data)) < 0)	
			stack.peek().left = newNode;
		else
		{		
			stack.peek().right = newNode;			
		}
		stack.push(newNode);
		reheap(stack);
		return true;
	}
	
	/**Methods
	 * Helper function to arrange tree as per max-heap
	 * @param stack Arranging Stack of nodes
	 */
	private void reheap(Stack<Node> stack){
		Node<E> childNode = stack.pop();
		Node<E> parentNode = stack.pop();
		while(parentNode!= null && childNode.priority > parentNode.priority)
		{
			if((childNode.data.compareTo(parentNode.data)) > 0)
				parentNode.rotateLeft();
			else
				parentNode.rotateRight();
			if(!stack.isEmpty())
				parentNode = stack.pop();
			else
				parentNode = null;
		}}
	
	/**
	 * This function deletes the node with given key
	 * @param key The key to be deleted from the node
	 * @return boolean value for the deletion of node
	 */
	public boolean delete(E key){
		Node<E> foundNode = null ;
		Node<E> lastParent = null;
		Node<E> temp = null;
		if (find(key) == false || root==null)
			return false;
		else
		{
			while(root!= null)
			{
				if(key.compareTo(root.data) < 0){
					temp = root;
					root = root.left;
				}
				else if((key.compareTo(root.data)) > 0){
					temp = root;
					root = root.right;
				}
				else{
					foundNode = root;
					break;
				}
			}
			while((foundNode.right!=null)||(foundNode.left!=null))
			{
				if(foundNode.right==null )
				{
					lastParent = foundNode.rotateRight();
					foundNode = lastParent.right;
				}
				else if(foundNode.left == null)
				{
					lastParent = foundNode.rotateLeft();
					foundNode = lastParent.left;
				}
				else if (foundNode.left.priority < foundNode.right.priority)
				{
					lastParent = foundNode.rotateLeft();
					foundNode = lastParent.left;
				}
				else if(foundNode.left.priority > foundNode.right.priority)
				{
					lastParent = foundNode.rotateRight();
					foundNode = lastParent.right;
				}
			}	
			if(lastParent == null)
				lastParent = root;
			if((lastParent.left!= null)&&(lastParent.left.data.compareTo(key))==0)
				lastParent.left = null;
			else
			{
				lastParent.right = null;
			}
			return true;
		}
	}
	
	/**
	 * Finds a node with the given key in the Treap rooted
	 * @param root it takes the root node of the tree
	 * @param key it takes the key to find in the tree
	 * @return boolean value for find operation..returns true if it is found otherwise false
	 */
	private boolean find(Node<E> root,E key){
		if(root==null) {
			return false;
		}
		else if((key.compareTo(root.data))>0) {
			return find(root.right, key);
		}
		else if((key.compareTo(root.data))<0) {
			return find(root.left, key);
		}
		else { 
			return true;
		}
	}
	
	/**
	 * Takes only the element to perform find 
	 * It finds a node with given key in treap
	 * returns true if found otherwise false will be returned
	 * @param key The key to be found in the tree
	 * @return boolean value for find operation
	 */
	public boolean find(E key){
		if(key==null) {
			throw new NullPointerException("Key cannot be null");
		}
		boolean result = find(root, key);
		return result;
	}	
	
	/**
	 * Returns string value of tree
	 * @return String value of the tree
	 */
	public String toString(){
		StringBuilder strbuilder = new StringBuilder();
		return getPreOrderTraverse(root, 1, strbuilder);
	}
	
	/**
	 * Gets the tree in pre-order form
	 * @param node Takes the root as a node
	 * @param depth Takes the level of the starting node/root
	 * @param strbuilder StringBuilder object to build a string for the tree
	 * @return
	 */
	private String getPreOrderTraverse(Node<E>node, int depth, StringBuilder strbuilder){
		for(int i=1; i< depth; i++){
			strbuilder.append("  ");
		}		
		if(node==null)
			strbuilder.append("null\n");
		else{
			strbuilder.append("(key="+node.data+",priority="+node.priority+")\n");
			getPreOrderTraverse(node.left, depth + 1,strbuilder);
			getPreOrderTraverse(node.right, depth + 1,strbuilder);
		}
		return strbuilder.toString();
	}
	
	/**
	 * Main method()
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println("TEST CASE 1\n");
		Treap<Integer> testTree = new Treap < Integer >();
		testTree.add(4,19);
		testTree.add(2,31);
		testTree.add(6,70);
		testTree.add(1,84);
		testTree.add(3,12);
		testTree.add(5,83);
		testTree.add(7,26);
		testTree.add(-5,26);
		System.out.println(testTree.toString());
		System.out.println("Find node with key '6'? "+ testTree.find(6));
		System.out.println("Find node with key '16'? "+ testTree.find(16));
		System.out.println("Delete if key '6' exists, so result is: "+ testTree.delete(6));
		System.out.println("Delete if key '16' exists, so result is: "+ testTree.delete(16));
		System.out.println("Find node with key '6' after deleting? "+ testTree.find(6));
		System.out.println("\n\n\nTEST CASE 2\n\n");
		Treap<Character> testTree2 = new Treap<Character>();
		testTree2.add('p',99);
		testTree2.add('g',80);
		testTree2.add('u',75);
		testTree2.add('a',60);
		testTree2.add('j',65);
		testTree2.add('r',40);
		testTree2.add('z',47);
		testTree2.add('w',32);
		testTree2.add('v',21);
		testTree2.add('x',25);
		System.out.println(testTree2.toString());
		testTree2.add('i',93);
		System.out.println("Delete if key with 'z' exists, so the result is: "+ testTree2.delete('z') +"\n");
		System.out.println(testTree2.toString());
		System.out.println("\n\n\nTEST CASE 3\n\n");
		Treap<Character> testTree3 = new Treap<Character>();
		testTree3.add('h',9);
		testTree3.add('j',7);
		testTree3.add('c',4);
		testTree3.add('a',2);
		testTree3.add('e',0);
		System.out.println(testTree3.toString());
		System.out.println(testTree3.add('i',4));
		System.out.println(testTree3.add('c',8));
		System.out.println(testTree3.toString());
		
		}
}
