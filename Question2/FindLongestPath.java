package com.greatlearning.LabDSA3.Question2;

import java.util.ArrayList;

//Boilerplate code
class Node {
	Node leftNode;
	Node rightNode;
	int nodeData;

	Node(int data) {
		nodeData = data;
		leftNode = rightNode = null;
	}
}

//Longest Path of Binary Tree
public class FindLongestPath {
	public static ArrayList<Integer> longestPath(Node root) {
		if (root == null) {
			ArrayList<Integer> path = new ArrayList<>();
			return path;
		}
		ArrayList<Integer> left = longestPath(root.leftNode);
		ArrayList<Integer> right = longestPath(root.rightNode);

		if (right.size() < left.size()) {
			left.add(root.nodeData);
		} else {
			right.add(root.nodeData);
		}
		return (left.size() > right.size() ? left : right);
	}

	// Main
	public static void main(String[] args) {
		Node root = new Node(100);
		// TODO Auto-generated method stub
		Node node1 = new Node(20);
		Node node2 = new Node(130);
		Node node3 = new Node(10);
		Node node4 = new Node(50);
		Node node5 = new Node(110);
		Node node6 = new Node(140);
		Node node7 = new Node(5);

		root.leftNode = node1;
		root.rightNode = node2;

		node1.leftNode = node3;
		node1.rightNode = node4;

		node2.leftNode = node5;
		node2.rightNode = node6;

		node3.leftNode = node7;

		System.out.print("Longest path:");

		// Output
		ArrayList<Integer> output = longestPath(root);
		for (int I : output) {
			System.out.print(I + " ");
		}
	}
}