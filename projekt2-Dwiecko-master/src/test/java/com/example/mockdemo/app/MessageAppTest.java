package com.example.mockdemo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.mockdemo.messenger.MessageServiceImplementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MessageAppTest {
	private Messenger messenger;
	private MessageServiceImplementation messageService;

	private final String VALID_SERVER = "https://inf.ug.edu.pl";
	private final String INVALID_SERVER = "http://inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@BeforeEach
	public void SetUp() {
		messageService = new MessageServiceImplementation();
		messenger = new Messenger(messageService);
	}
	@AfterEach
	public void TearDown(){
		messageService = null;
		messenger = null;
	}
	
	@Test
	public void ValidServerAndValidMessageReturns0() {
		int validServerAndMessage = messenger.sendMessage(VALID_SERVER, VALID_MESSAGE);
		
		assertEquals(0, validServerAndMessage);
	}
	
	@Test
	public void InvalidServerAndValidMessageReturns1() {
		int invalidServerAndMessage = messenger.sendMessage(INVALID_SERVER, VALID_MESSAGE);

		assertEquals(1, invalidServerAndMessage);
	}
	
	@Test
	public void ValidServerAndInvalidMessageReturns2() {
		int validServerAndInvalidMessage = messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE);

		assertEquals(2, validServerAndInvalidMessage);
	}

	@Test
	public void InvalidServerAndInvalidMessageReturns2() {
		int invalidServerAndInvalidMessage = messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE);

		assertEquals(2, invalidServerAndInvalidMessage);
	}

	@Test
	public void CodeResultOfSendMessageIsOfTypeInt() {
		int code = messenger.sendMessage(INVALID_SERVER, INVALID_MESSAGE);
		assertTrue(Integer.class.isInstance(code));
	}

	@Test
	public void SpecialCharacterCheck() {
		int code = messenger.sendMessage("https://!!!!.pl", INVALID_MESSAGE);

		assertNotEquals(0, code, "Special characters should not return code for correct data");
	}
}
