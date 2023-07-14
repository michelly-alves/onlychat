package br.ufc.web.springrest01.rest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;

import br.ufc.web.springrest01.model.Messages;
import br.ufc.web.springrest01.model.UserAccount;
import br.ufc.web.springrest01.repository.MessagesRepository;
import br.ufc.web.springrest01.repository.UserRepository;
import br.ufc.web.springrest01.service.MessagesService;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessagesRestController {
    @Autowired
    private MessagesService messagesService;
    @Autowired
    private MessagesRepository messagesRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public MessagesRestController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @GetMapping
    public List<Messages> getAllMessages() {
        return (List<Messages>) messagesRepository.findAll();
    }


    @PostMapping
    public Messages createMessage(@RequestBody Messages message) {
        message.setTimestamp();
        return messagesRepository.save(message);
    }


    @GetMapping("/sender/{senderId}/recipient/{recipientId}")
    public List<Messages> getMessagesBySenderAndRecipient(@PathVariable int senderId, @PathVariable int recipientId) throws NotFoundException {
        UserAccount sender = userRepository.findById(senderId).orElseThrow(() -> new NotFoundException());
        UserAccount recipient = userRepository.findById(recipientId).orElseThrow(() -> new NotFoundException());
        return messagesService.getMessagesBySenderAndRecipient(sender, recipient);
    }

    public List<Messages> getMessagesByUser(UserAccount user) {
        Sort sort = Sort.by(Sort.Direction.DESC, "timestamp");
        return messagesRepository.findBySenderOrRecipient(user, user, sort);
    }
}

