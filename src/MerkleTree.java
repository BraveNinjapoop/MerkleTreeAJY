/**
Project #4, MerkleTreeAJY
@author - Austin Young
Date, 01DEC19
**/

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

public class MerkleTree {	//Creates the Merkle Tree class.
	
	BinarySearchTreeI <String> merkle = new BinarySearchTreeI<String>(); //Creates a new Binary Search Tree from StackAndQueuePackage.
	String result; //Initialized result.
	
public MerkleTree() {
		result = null; //Equals results to null so that it can be "empty".
	}
	
public void addNode(String h) {
		merkle.add(h);
	}
	
public void computeRoots(String d, LinkedQueue <String> queue, LinkedStack <String> stack){ //Creates "computeRoots" that will be called in the Application class.
	String result = null; //Defines result as null.
	MessageDigest md = null; //Defines MessageDigest as null.
	try {
		md = MessageDigest.getInstance("SHA-256"); //Message digest using the SLA256 Verification method.
			
	}
		catch (NoSuchAlgorithmException e) { //Exception that is thrown from MessageDigest if the program does not compile.
			
	}
	
	md.update(d.getBytes()); 
	byte[] digest = md.digest(); //"Digest" the Bytes that are created from the String values and turns it into Hash.
	StringBuffer hexString = new StringBuffer();
	for (int i = 0;i<digest.length;i++) {
	    	hexString.append(Integer.toHexString(0xFF & digest[i]));
	    	
	}
	result = hexString.toString().toLowerCase(); //Results the hashed values.
	stack.push(result); //Pushes the Hash's to Results and then the stack.
	queue.enqueue(result); //Queues the results to the stack.
	setResult(result); //Declares the Hash's from the Digest and assigns it to Results.
		
	}
	
public void computeLeaves(DataBlock d, LinkedQueue <String> queue, LinkedStack <String> stack){ //Creates "computeLeaves" that will be called in the Application class.
	try {
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //Message Digest using SLA1 Verification method.
	try {
		md.update(serialize(d)); //Updates the serialize package with the Bytes that we're digested.
		byte[] digest = md.digest();
		StringBuffer hexString = new StringBuffer();
	for (int i = 0;i<digest.length;i++) {
		hexString.append(Integer.toHexString(0xFF & digest[i])); //Converts the Byte Array to a string of Hex digits.
			    
	}
	setResult(hexString.toString().toLowerCase());
	stack.push(result);
	queue.enqueue(result);	
				
	}
		catch (IOException e){
				
	}	
} 
		
		catch (NoSuchAlgorithmException e) {	
		
	}
}
	
public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException { //Creates the deserialize object that is used 
	try(ByteArrayInputStream b = new ByteArrayInputStream(bytes)){ //Creates a new Input Stream for the Bytes.
		try(ObjectInputStream o = new ObjectInputStream(b)){ //Creates a new Input Stream for the Object.
			return o.readObject(); //Returns the Object from the Input Stream.
		}
	}
}
	
public static byte[] serialize(Object obj) throws IOException {  //Creates the serialize object that is used in Compute Roots and Compute Leaves.
	ByteArrayOutputStream out = new ByteArrayOutputStream(); //Creates a new Output Stream for the Bytes.
	ObjectOutputStream os = new ObjectOutputStream(out); //Creates a new Output Stream for the Object.
	
	os.writeObject(obj); //Writes the Object to the Output Stream.
	os.flush(); //Flushes the Object from the Output Stream.
	os.close(); //Closes the Object from the Output Stream.
	out.close(); //Final close. 
	
	return out.toByteArray(); //Returns the Bytes that are used for the hashing.
	
	}

// - Getters and Setters - //
	
	public void setResult(String n) {
		result = n;
		
	}
	
	public String getResult() {
		return result;
		
	}

}