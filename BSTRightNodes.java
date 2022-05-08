package com.greatlearning.dsa.assignement;

class Node{
	int data;
	Node leftnode, rightnode;

	Node(int item){
		data = item;
		leftnode = rightnode = null;
	}
}

public class BSTRightNodes{
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

//convert to Skewed tree
	static void BT_RightSkewed(Node root,int order){

		if(root == null)
			return;


		if(order > 0)
			BT_RightSkewed(root.rightnode, order);

		else
			BT_RightSkewed(root.leftnode, order);

		Node rightNode = root.rightnode;
		Node leftNode = root.leftnode;


		if(headNode == null){
			headNode = root;
			root.leftnode = null;
			prevNode = root;
		}
		else{
			prevNode.rightnode = root;
			root.leftnode = null;
			prevNode = root;
		}

		if (order > 0)
			BT_RightSkewed(leftNode, order);

		else
			BT_RightSkewed(rightNode, order);

	}

	static void traverseRightSkewed(Node root){
		if(root == null)
			return;

		System.out.print(root.data + " ");
		traverseRightSkewed(root.rightnode);       
	}


	public static void main (String[] args){

		BSTRightNodes tree = new BSTRightNodes();
		tree.node = new Node(50);
		tree.node.leftnode = new Node(30);
		tree.node.rightnode = new Node(60);
		tree.node.leftnode.leftnode = new Node(10);
		tree.node.rightnode.leftnode= new Node(55);

		int order = 0;
		BT_RightSkewed(node, order);
		traverseRightSkewed(headNode);
	}
}