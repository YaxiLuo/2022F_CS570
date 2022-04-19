import java.util.ArrayList;

public class IDLList<E> {
	
	/*
	 * Submitting hw3:Lists
	 * Rishikesh Yadav [CWID: 20007668]
	 */
	
	private class Node<E>{
		private E data;
		private Node<E> next;
		private Node<E> prev;
		
		//Creation of node with next and previous pointers as null.
		public Node(E elem) {
			data = elem;
			next = null;
			prev = null;
		}
		
		//Creation of node with the specified next and previous pointers.
		public Node(E elem, Node<E> prev, Node<E> next) {
			data = elem;
			this.next = next;
			this.prev = prev;
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	int size;
	ArrayList<Node<E>> indices;
	
	//Constructor to create an empty double-linked list.
	public IDLList() {
		head = null;
		tail = null;
		size = 0;
		
		indices = new ArrayList<Node<E>>();
	}
	
	//Add an element at the head
	public boolean add(int index, E elem) {
		if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) { // add to the beginning of the list
            add(elem);
        } else {
            // somewhere between the beginning and the end
            Node<E> current = indices.get(index);
            Node<E> newNode = new Node<>(elem, current.prev, current);
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
            indices.add(index, newNode);
        }
        return true;
	}
	
	//Add an element at given index position
	public boolean add (E elem) {
		if (head == null)
		{
            head = new Node<E>(elem, null, null);
            tail = head;
        }
		else if(head == tail)
		{
            head = new Node<E>(elem, null, tail);
            tail.prev = head;
        }
		else {
			Node<E> temp = new Node<E>(elem, null, head);
            head.prev = temp;
            head = temp;
            
        }
		indices.add(0, head);
        size++;
        return true;
	}
	
	//Appends an element 'elem' at the last of the list
	public boolean append (E elem) {
		if (head == null)
		{
            head = new Node<E>(elem, null, null);
            tail = head;
            size++;
            return indices.add(head);
        }
		else if (head == tail)
		{
            tail = new Node<E>(elem, head, null);
            head.next = tail;
            size++;
            return indices.add(tail);
        }
		else {
			Node<E> temp = new Node<E>(elem, tail, null);
	        tail.next = temp;
	        tail = temp;
	        size++;
	        return indices.add(tail);
		}
	}
	
	//Fetches the element at index position
	public E get(int index){
		return indices.get(index).data;
	}
	
	//Fetches the head element of the list
	public E getHead(){
		if(head == null) {
			throw new IndexOutOfBoundsException();
		}
		return head.data;
	}
	
	//Fetches the tail element of the list
	public E getLast(){
		if(tail == null) {
			throw new IndexOutOfBoundsException();
		}
		return tail.data;
	}
	
	//Returns the size of the list
	public int size(){
		return size;
	}	
	
	//Removes and returns the head element of the list
	public E remove(){
		if(head == null) {
			throw new IllegalStateException();
		}
		else if(head == tail) {
			Node<E> output = head;
            head = null;
            tail = null;
            size--;
            indices.clear();
            return output.data;
		}
		else {
			Node<E> output  = head;
			head = head.next;
			size--;
			indices.remove(0);
			return output.data;
		}
	}
	
	//Removes and returns the tail element of the list
	public E removeLast(){
		if(tail == null) {
			throw new IllegalStateException();
		}
		else if(head == tail) {
			Node<E> output = tail;
			tail = null;
			head = null;
			indices.clear();
			size--;
			return output.data;
		}
		else {
			Node<E> output = tail;
			tail = tail.prev;
			tail.next = null;
			size--;
			indices.remove(size);
			return output.data;
		}
		
	}
	
	//Removes and returns the element at the index position of the list
	public E removeAt(int index){
	        if (index < 0 || index > size) {
	            throw new IllegalStateException();
	        }
	        if (index == 0) {
	            return remove();
	        }
	        if (index == size - 1) {
	            return removeLast();
	        }
	        Node<E> temp = indices.remove(index);
	        temp.prev.next = temp.next;
	        temp.next.prev = temp.prev;
	        size--;
	        return temp.data;
	    }
	
	//Removes the element 'elem' from the list
	public boolean remove (E elem){
		if (elem.equals(head.data)) {
            remove();
            return true;
        }
		else if (elem.equals(tail.data)) {
            removeLast();
            return true;
        }
		Node<E> temp = head;
	    int index = 1;
	    while (temp != null) {
	        if (temp.data.equals(elem)) {
	        	temp.prev.next = temp.next;
	        	temp.next.prev = temp.prev;
	            indices.remove(index);
	            size--;
	            return true;
	        }
	        temp = temp.next;
	        index++;
	    }
	    return false;
	}
	
	//Returns a string representation of the list
	public String toString(){
		Node<E> start = head;
        StringBuilder s = new StringBuilder();
        while (start != null) {
            s.append(start.data.toString() + ", ");
            start = start.next;
        }
        return s.toString();
	}
}
