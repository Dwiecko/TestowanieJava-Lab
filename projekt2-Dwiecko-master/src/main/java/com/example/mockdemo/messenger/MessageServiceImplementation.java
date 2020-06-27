package com.example.mockdemo.messenger;

public class MessageServiceImplementation implements MessageService {

	public ConnectionStatus checkConnection(String server) {
		if (!server.endsWith(".pl")) {
			return ConnectionStatus.FAILURE;
        }
        return ConnectionStatus.SUCCESS;
	}

	public SendingStatus send(String server, String message) throws MalformedRecipientException {
        if(isNullable(server) || server.trim().length() < 4) throw new MalformedRecipientException();//server must have at least 1 letter and ends with .pl  
        if(isNullable(message) || message.trim().length() < 3) throw new MalformedRecipientException();//messsage must have at least 3 letters
        if(checkConnection(server) == ConnectionStatus.FAILURE) return SendingStatus.SENDING_ERROR;
        if(checkConnection(server) == ConnectionStatus.SUCCESS) return SendingStatus.SENT;
        return SendingStatus.SENDING_ERROR;
    }
    
    private boolean isNullable(String textToCheck) {
        if(textToCheck != null) return false;
        return true;
    }
}