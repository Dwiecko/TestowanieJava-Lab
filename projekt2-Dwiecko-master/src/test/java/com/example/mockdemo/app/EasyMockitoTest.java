package com.example.mockdemo.app;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class EasyMockitoTest {

    private Messenger _messenger;
    private MessageService _serviceMock;
    
    private final String CORRECTSERVER = "https://trojmiasto.pl";
    private final String INCORRECTSERVER = "https://trojmiasto.eu";
    private final String SERVERWITHSPECIALCHARS = "https://#@!#!.pl";

    private final String CORRECTMESSAGE = "Correct";
    private final String INCORRECTMESSAGE = "a";   

    @BeforeEach
	public void SetUp()
	{
		_serviceMock = createMock(MessageService.class);
		_messenger = new Messenger(_serviceMock);
    }

    @AfterEach
	public void tearDown()
	{
		_serviceMock = null;
		_messenger = null;
    }
    
    @Test
    @DisplayName("Error")
	public void verifyErrorCodeInCorrectServerAndCorrectMessage() throws MalformedRecipientException
	{
        expect(_serviceMock.send(SERVERWITHSPECIALCHARS, CORRECTMESSAGE))
                           .andReturn(SendingStatus.SENDING_ERROR);
        replay(_serviceMock);
        
		assertEquals(1, _messenger.sendMessage(SERVERWITHSPECIALCHARS, CORRECTMESSAGE));
		verify(_serviceMock);
	}
    
    @Test
    @DisplayName("Error")
	public void verifyErrorCodeDueToIncorrectServerAndCorrectMessage() throws MalformedRecipientException
	{
        expect(_serviceMock.send(INCORRECTSERVER, CORRECTMESSAGE))
                           .andReturn(SendingStatus.SENDING_ERROR);
        replay(_serviceMock);
        
		assertEquals(1, _messenger.sendMessage(INCORRECTSERVER, CORRECTMESSAGE));
		verify(_serviceMock);
	}

    @Test
    @DisplayName("Success")
	public void verifySuccesCodeDueToCorrectServer()
	{
        expect(_serviceMock.checkConnection(CORRECTSERVER))
                           .andReturn(ConnectionStatus.SUCCESS);
        replay(_serviceMock);
        
		assertEquals(0, _messenger.testConnection(CORRECTSERVER));
		verify(_serviceMock);
    }
    
    @Test
    @DisplayName("Sent")
	public void verifySentCodeDueToCorrectServerAndMessage() throws MalformedRecipientException
	{
        expect(_serviceMock.send(CORRECTSERVER, CORRECTMESSAGE))
                           .andReturn(SendingStatus.SENT);
        replay(_serviceMock);
        
		assertEquals(0, _messenger.sendMessage(CORRECTSERVER, CORRECTMESSAGE));
		verify(_serviceMock);
    }
    
    @Test
    @DisplayName("Exception")
	public void verifyExceptionCodeDueToIncorrectServerAndMessage() throws MalformedRecipientException
	{
        expect(_serviceMock.send(INCORRECTSERVER, INCORRECTMESSAGE))
                           .andThrow(new MalformedRecipientException());
        replay(_serviceMock);
        
		assertEquals(2, _messenger.sendMessage(INCORRECTSERVER, INCORRECTMESSAGE));
		verify(_serviceMock);
    }

    @Test
    @DisplayName("Failure")
	public void verifyFailureCodeDueToIncorrectServer()
	{
        expect(_serviceMock.checkConnection(INCORRECTSERVER))
                           .andReturn(ConnectionStatus.FAILURE);
        replay(_serviceMock);
        
		assertEquals(1, _messenger.testConnection(INCORRECTSERVER));
		verify(_serviceMock);
    }
    
    @Test
    @DisplayName("Failure")
	public void verifyFailureCodeDueToIncorrectServerWithSpecialChars()
	{
        expect(_serviceMock.checkConnection(SERVERWITHSPECIALCHARS))
                           .andReturn(ConnectionStatus.FAILURE);
        replay(_serviceMock);

		assertEquals(1, _messenger.testConnection(SERVERWITHSPECIALCHARS));
		verify(_serviceMock);
    }
    
    @Test
    @DisplayName("Failure")
	public void verifyFailureCodeDueToIncorrectServerWithoutURL()
	{
        expect(_serviceMock.checkConnection("Server name"))
                           .andReturn(ConnectionStatus.FAILURE)
                           .once();
        replay(_serviceMock);
        
		assertEquals(1, _messenger.testConnection("Server name"));
		verify(_serviceMock);
	}
}