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

public class DataBlock implements java.io.Serializable {

	String data; //Initialized Data
	
	public DataBlock(String s) { //Intialized the String "s".
		data = s; //Assigns Data to the S string for later use in Data Reader.
	}
}