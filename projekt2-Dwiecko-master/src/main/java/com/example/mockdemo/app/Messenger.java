package com.example.mockdemo.app;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class Messenger {

	private MessageService messageService;

	public Messenger(MessageService messageService) {
		this.messageService = messageService;
	}

	public int testConnection(String server) {
		int result = messageService.checkConnection(server) == (ConnectionStatus.SUCCESS) ? 0 : 1;
		return result;
	}

	public int sendMessage(String server, String message) {
		int result;
		try
        {
            SendingStatus sendingStatus = messageService.send(server, message);
            result = sendingStatus == SendingStatus.SENT ? 0 : 1;
        }
        catch (MalformedRecipientException e)
        {
            result = 2;
		}
		return result;
	}
}
