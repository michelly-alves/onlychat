package br.ufc.web.springrest01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.web.springrest01.model.Messages;
import br.ufc.web.springrest01.model.UserAccount;
import br.ufc.web.springrest01.repository.MessagesRepository;

import java.util.List;

@Service
public class MessagesService {
@Autowired
    private MessagesRepository messagesRepository;

    
    public MessagesService(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    public List<Messages> getMessagesBySenderAndRecipient(UserAccount sender, UserAccount recipient) {
        return messagesRepository.findBySenderAndRecipient(sender, recipient);
    }

}
