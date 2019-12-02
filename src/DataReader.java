/**
Project #4, MerkleTreeAJY
@author - Austin Young
Date, 01DEC19
**/

import java.io.BufferedReader;
import java.io.FileReader;
import StackAndQueuePackage.LinkedQueue;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import TreePackage.BinarySearchTreeI;
import StackAndQueuePackage.LinkedStack;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import StackAndQueuePackage.LinkedQueue;

public class DataReader {
	
public DataReader(String s, LinkedQueue <DataBlock> q) { //Creates the Data Reader that pulls the values of s from Data Blocks, then calls for the Linked Queue in StackAndQueuePackage.
	String input = null; //Declares input as null
	try {
		BufferedReader reader = new BufferedReader(new FileReader(s)); //File Reader to read any file that is put into the Project.
		while ((input = reader.readLine())!= null) { 
	    DataBlock block = new DataBlock(input); //Creates a new Data Block based on user input.
	    q.enqueue(block); //Enqueue's the block of data into the Linked Queue.
		}
			
	reader.close(); //Closes the reader.
		}
	
	catch (java.io.IOException e){
				
		}	
	}
}