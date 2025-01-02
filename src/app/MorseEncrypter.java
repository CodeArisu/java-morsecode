package app;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MorseEncrypter {
	
	private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
	private final String[] convertion = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
										"..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", 
										"--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", 
										"-.--", "--..", "/"};
	private final int alphabetCount = alphabet.length();
	private char[] letterChar;
	private HashMap<Character, String> hashedMorse;
	private Queue<String> morseQueue;
	private StringBuilder outputStr;
	
	
	public MorseEncrypter() {
		try {
			morseQueue = new LinkedList<>();
			hashedMorse = new HashMap<>();
			outputStr = new StringBuilder();
			EncryptMapping();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// returns integer map size
	public int GetMapSize() {
		return hashedMorse.size();
	}
	
	/*
	 * get converted value morse
	 */
	@SuppressWarnings("unused")
	public String getConvertionValuePairs(char letterInput) {
		for(Map.Entry<Character, String> cnvSet : hashedMorse.entrySet()) {
			if(cnvSet.getKey().equals(letterInput)) {
				return cnvSet.getValue();
			}
		}
		return "";
	}
	
	/*
	 * Checks alphabet and conversion has similar length
	 */
	private boolean LetterConvertedIsNotEqual() {	
		if(letterChar.length != alphabetCount) {
			return true;
		}
		if(convertion.length != alphabetCount) {
			return true;
		}
		if(letterChar.length != convertion.length) {
			return true;
		}
		return false;
	}
	
	
	/*
	 * This maps out the value of character as V
	 * and String conversion of code as K mapping
	 * each of the letters to each corresponding
	 * conversion as key value pairs
	 */
	private void EncryptMapping() throws Exception {
		letterChar = alphabet.toCharArray();
		if(LetterConvertedIsNotEqual()) {
			throw new Exception("Uncorresponded Alphabet/Conversion Size");
		}
		for(int i = 0; i < alphabetCount; i++) {
			hashedMorse.put(letterChar[i], convertion[i]);
		}
	}
	
	
	/*
	 * Stores the data into queue to have
	 * a linear data set of strings
	 */
	public void QueueMorseOutput(String textInputs) {
		char[] chTextInputs = ToCaseInsensitive(textInputs);
		int inputLength = textInputs.length();
		int entryIndex = 0;
		do {
			for(Map.Entry<Character, String> cnvSet : hashedMorse.entrySet()) 
			{
				if(cnvSet.getKey().equals(chTextInputs[entryIndex]) && inputLength == chTextInputs.length) 
				{
					morseQueue.add(cnvSet.getValue());
				}
			}
			entryIndex++;
		} while(entryIndex < chTextInputs.length);
	}
	
	
	/*
	 * Returns the output and empties the
	 * stack
	 */
	public String EncryptedOutput() {
		String textOutput = "";
		int stackLength = morseQueue.size();
		for(int i = 0; i < stackLength; i++) {
			outputStr.append(morseQueue.poll());
		}
		textOutput = outputStr.toString();
		return textOutput; 
	}
	
	
	/*
	 * Changes the case sensitivity of the char LowerCase
	 * to UpperCase 
	 */
	private char[] ToCaseInsensitive(String input) {
		char[] convertedCase = input.toCharArray();
		for(int i = 0; i < convertedCase.length; i++) {
			convertedCase[i] = Character.toUpperCase(convertedCase[i]);
		}
		return convertedCase;
	}

}
