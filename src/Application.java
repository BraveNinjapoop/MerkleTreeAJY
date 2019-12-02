/**
Project #4, MerkleTreeAJY
@author - Austin Young
Date, 01DEC19
**/

import java.util.Scanner;
import StackAndQueuePackage.LinkedQueue;
import StackAndQueuePackage.LinkedStack;
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

public class Application {
	
	private static Scanner in = new Scanner (System.in); //Creates the scanner for user input. 
	private static String movie; //Initialized the "movie" string used for hashing.
	private static Boolean marker = false; //Initialized the "marker" for the while loop below.
	
public static void main(String [] args) {
		
	System.out.println("Input file name: "); //Input a file name that's found in the Project itself (ie. movies.txt, moviesv2.txt).
	movie = in.next();
	
LinkedQueue <DataBlock> dataBlockQueue = new LinkedQueue <DataBlock>(); //Creates a new Linked Queue from the StackAndQueuePackage.
	DataReader dataReader = new DataReader(movie, dataBlockQueue); //Creates a new DataReader from class Data Reader.
	MerkleTree merkle = new MerkleTree(); //Creates a new Merkle Tree to organize the movie data from the Merkle Class.
	LinkedQueue <String> hashQueue = new LinkedQueue <String>(); //Creates a Hash using the Linked Queues.
	LinkedStack <String> nodeStack = new LinkedStack <String>(); //Creates a Node using the Linked Stack.
				
while(dataBlockQueue.isEmpty() == false) { 
	DataBlock d = dataBlockQueue.dequeue(); //Deque's the DataBlock.
	merkle.computeLeaves(d, hashQueue, nodeStack); //Computes the Leaves from the Merkle Tree class.
	System.out.println(merkle.getResult()); //Prints the Results out, resulting in the first Hash's to be created on the console.
	
	}
		
while((marker==false) && (hashQueue.isEmpty()==false)) {
	if(hashQueue.isEmpty() == false) {
		String R = hashQueue.dequeue(); //Deque's the left leaves of the Merkle Tree.
		String L = hashQueue.dequeue(); //Deque's the right leaves of the Merkle Tree.
		String Rt = L + R; //Add's the left and right leaves together.
		merkle.computeRoots(Rt, hashQueue, nodeStack); //Computes the combined left and right leaves to create a Hash.
		System.out.println(merkle.getResult()); //Prints the resulting Hash, the last Hash in the console will be the Hash that can be used for Verification.
	
			}
		}
	}
}