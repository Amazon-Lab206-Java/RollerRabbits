package com.cadence.events.service;

import org.springframework.stereotype.Service;

import com.cadence.events.models.Message;
import com.cadence.events.repo.MessageRepo;

@Service
public class MessageService {
    
    private MessageRepo messageRepo;
    
    public MessageService(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
        
    }
    
    // 1
    public void save(Message message) {
    	messageRepo.save(message);
    }
    
}