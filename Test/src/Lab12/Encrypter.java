package Lab12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Encrypter {
	 private int shift;
	    private String encrypted;
	    private String encryptMe;

	   public static final String alpha = "abcdefghijklmnopqrstuvwxyz";
	    /**
	     * Default Constructor
	     */
	    public Encrypter() {
	        this.shift = 1;
	        this.encrypted = "";
	    }

	    /**
	     * Non-default Constructor
	     * @param s - custom shift amount
	     */
	    public Encrypter(int s) {
	        this.shift = s;
	        this.encrypted = "";
	    }

	    /**
	     * Encrypts the content of a file and writes the result to another file.
	     *
	     * @param inputFilePath      the path to the file containing the text to be encrypted
	     * @param encryptedFilePath the path to the file where the encrypted text will be written
	     * @throws Exception if an error occurs while reading or writing the files
	     */
	    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
	        //TODO: Call the read method, encrypt the file contents, and then write to new file
	    	 
	    	
	    	encryptMe =readFile("encryptMe.txt");
	    	
	    	encryptMe = encryptMe.toLowerCase();
	        String cipher = "";
	        for (int ii = 0; ii < encryptMe.length(); ii++) {
	         int charPosition = alpha.indexOf(encrypted.charAt(ii));
	         int keyVal = (shift + charPosition) % 26;
	        char replaceVal = alpha.charAt(keyVal);
	        cipher += replaceVal;
	        
	        writeFile("encryptMe.txt", "newEncrypted.txt");
	        }
	    }

	    /**
	     * Decrypts the content of an encrypted file and writes the result to another file.
	     *
	     * @param messageFilePath    the path to the file containing the encrypted text
	     * @param decryptedFilePath the path to the file where the decrypted text will be written
	     * @throws Exception if an error occurs while reading or writing the files
	     */
	   public void decrypt(String messageFilePath, String decryptedFilePath) throws Exception {
	        //TODO: Call the read method, decrypt the file contents, and then write to new file
		 encrypted = readFile("encrypted.txt");
	    encrypted = encrypted.toLowerCase();
	    String message = "";
	    for (int ii = 0 ; ii< encrypted.length(); ii++) {
	      int charPosition = alpha.indexOf(encrypted.charAt(ii));
	      int keyVal = (charPosition - shift) % 26;
	      if (keyVal < 0) {
	        keyVal = alpha.length() + keyVal;
	      }
	      char replaceVal = alpha.charAt(keyVal);
	      message += replaceVal;
	    }
	    
	  
	   
	    writeFile("encrypted.txt", "decrypted.txt");
	    }

	    /**
	     * Reads the content of a file and returns it as a string.
	     *
	     * @param filePath the path to the file to be read
	     * @return the content of the file as a string
	     * @throws Exception if an error occurs while reading the file
	     */
	    private static String readFile(String filePath) throws Exception {
	        String message = "";
	        //TODO: Read file from filePath
	        
	        try (Scanner fileScanner = new Scanner (Paths.get(""))){
				while (fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
				} 
				fileScanner.close();
			}catch (Exception e) {
				System.out.println("Error: " + e.toString());}

			System.out.println("File was read");
	        return message;
	       
	    }

	    /**
	     * Writes data to a file.
	     *
	     * @param data     the data to be written to the file
	     * @param filePath the path to the file where the data will be written
	     */
	    private static void writeFile(String data, String filePath) {
	        //TODO: Write to filePath
	    	try (PrintWriter output = new PrintWriter("")){
	    		
	    		output.close();
	    		
	    	}catch (Exception e) {
	    		System.out.println("Error:" + e.toString());
	    	}
	    }

	    /**
	     * Returns a string representation of the encrypted text.
	     *
	     * @return the encrypted text
	     */
	    @Override
	    public String toString() {
	        return encrypted;
	    }
	}

