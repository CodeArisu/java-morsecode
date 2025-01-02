package testUnits;

import static org.junit.jupiter.api.Assertions.*;
import app.MorseEncrypter;

import org.junit.jupiter.api.Test;

class MorseEncyptionTest {
	
	MorseEncrypter morse_test;
	
	MorseEncyptionTest() {
		morse_test = new MorseEncrypter();
	}
	
	@Test
	void letterIsEquivalentToConvertedMorseA() {

		String res = morse_test.getConvertionValuePairs('A');
		assertEquals(".-", res);
	
	}
	
	@Test
	void letterIsEquivalentToConvertedMorseZ() {

		String res = morse_test.getConvertionValuePairs('Z');
		assertEquals("--..", res);
	
	}
	
	@Test
	void sizeOfTheMapSuccessLoop() {
		assertEquals(27, morse_test.GetMapSize());
	}
	
	@Test
	void getEncryptedOutputTestHi() {
		
		String testString = "HI";
		
		morse_test.QueueMorseOutput(testString);
		
		assertEquals("......", morse_test.EncryptedOutput());
		
	}
	
	@Test
	void getEncryptedOutputFalseTestHi() {
		
		String testString = "HELLO";
		
		morse_test.QueueMorseOutput(testString);
		
		assertNotEquals("......", morse_test.EncryptedOutput());
		
	}
	
	@Test
	void getEncryptedMessageLongTextTest() {
		String testString = "HELLO";
		
		morse_test.QueueMorseOutput(testString);
		
		assertEquals("......-...-..---", morse_test.EncryptedOutput());
	}
	
	@Test
	void getCaseInsensitiveHelloOutput() {
		String testString = "hello";
		
		morse_test.QueueMorseOutput(testString);
		
		assertEquals("......-...-..---", morse_test.EncryptedOutput());
	}
	
	@Test
	void getCaseInsensitiveHelloWorldOutput() {
		String testString = "heLloWorld";
		
		morse_test.QueueMorseOutput(testString);
		
		assertEquals("......-...-..---.-----.-..-..-..", morse_test.EncryptedOutput());
	}
	
	@Test
	void getCaseOutputWithSpace() {
		String testString = "heLlo World";
		
		morse_test.QueueMorseOutput(testString);
		
		assertEquals("......-...-..---/.-----.-..-..-..", morse_test.EncryptedOutput());
	}
	
	@Test
	void getCaseOutputWithSpaceError() {
		String testString = "heLlo World";
		
		morse_test.QueueMorseOutput(testString);
		
		assertNotEquals("......-...-..---.-----.-..-..-..", morse_test.EncryptedOutput());
	}
	
	@Test
	void getMultipleCaseWhitespaces() {
		String testString = "Al pH  a";
		
		morse_test.QueueMorseOutput(testString);
		
		assertEquals(".-.-../.--.....//.-", morse_test.EncryptedOutput());
	}
	
	@Test
	void getCaseInsensitiveHelloOutputRandomCases() {
		String testString = "hELlO";
		
		morse_test.QueueMorseOutput(testString);
		
		assertEquals("......-...-..---", morse_test.EncryptedOutput());
	}
	


}
