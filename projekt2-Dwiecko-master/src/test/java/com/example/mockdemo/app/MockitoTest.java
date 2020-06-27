package com.example.mockdemo.app;

import com.example.mockdemo.messenger.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.mockito.ArgumentCaptor;
import org.mockito.Spy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MockitoTest {
    @Spy 
    private Messenger messenger;
    private MessageService serviceMock;
    
    private final String CORRECTSERVER = "https://trojmiasto.pl";
    private final String INCORRECTSERVER = "https://trojmiasto.eu";
    private final String SERVERWITHSPECIALCHARS = "https://#@!#!.pl";

    private final String CORRECTMESSAGE = "Correct";
    private final String INCORRECTMESSAGE = "a";   

	@BeforeEach
	public void SetUp(){
		serviceMock = mock(MessageService.class);
		messenger = new Messenger(serviceMock);
    }
    
    @Test
    @DisplayName("Success")
	public void SuccessConnectionAfterCapture(){
		ArgumentCaptor<String> server = ArgumentCaptor.forClass(String.class);
        when(serviceMock.checkConnection(CORRECTSERVER))
                        .thenReturn(ConnectionStatus.SUCCESS);
        
		assertEquals(serviceMock.checkConnection(CORRECTSERVER), ConnectionStatus.SUCCESS);
		verify(serviceMock).checkConnection(server.capture());
    }
    
    @Test
    @DisplayName("Success")
	public void SuccessfulConnectionAfterPassingCorrectServer(){
        when(serviceMock.checkConnection(CORRECTSERVER))
                        .thenReturn(ConnectionStatus.SUCCESS);
        
		assertEquals(0, messenger.testConnection(CORRECTSERVER));
    }

    @Test
    @DisplayName("Sent")
	public void SentCodeAfterPassingCorrectServerAndMessage() throws MalformedRecipientException{
        when(serviceMock.send(CORRECTSERVER, CORRECTMESSAGE))
                        .thenReturn(SendingStatus.SENT);
        
		assertEquals(0, messenger.sendMessage(CORRECTSERVER, CORRECTMESSAGE));
	}
    
    @Test
    @DisplayName("Exception")
	public void ExceptionCodeAfterPassingInCorrectData() throws MalformedRecipientException{
        when(serviceMock.send(CORRECTSERVER, INCORRECTMESSAGE))
                        .thenThrow(new MalformedRecipientException());
        
        assertEquals(2, messenger.sendMessage(CORRECTSERVER, INCORRECTMESSAGE));
    }
    
    @Test
    @DisplayName("Failure")
	public void FailureConnectionAfterPassingInCorrectServer(){
        when(serviceMock.checkConnection(INCORRECTSERVER))
                        .thenReturn(ConnectionStatus.FAILURE);
        
		assertEquals(1, messenger.testConnection(INCORRECTSERVER));		
    }
    
    @Test
    @DisplayName("Failure")
	public void FailureAfterPassingInvalidServerWithSpecialChars(){
        when(serviceMock.checkConnection(SERVERWITHSPECIALCHARS))
                        .thenReturn(ConnectionStatus.FAILURE);
        
		assertEquals(1, messenger.testConnection(SERVERWITHSPECIALCHARS));		
	}
	
    @Test
    @DisplayName("Error")
	public void ErrorCodeAfterPassingInCorrectServerAndCorrectMessage() throws MalformedRecipientException{
        when(serviceMock.send(INCORRECTSERVER, CORRECTMESSAGE))
                        .thenReturn(SendingStatus.SENDING_ERROR);
        
		assertEquals(1, messenger.sendMessage(INCORRECTSERVER, CORRECTMESSAGE));
	}
}