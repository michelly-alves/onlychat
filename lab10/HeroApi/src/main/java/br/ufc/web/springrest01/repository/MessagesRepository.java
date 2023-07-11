package br.ufc.web.springrest01.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ufc.web.springrest01.model.Messages;
import br.ufc.web.springrest01.model.UserAccount;

@Repository
public interface MessagesRepository extends CrudRepository<Messages, Integer>{

    List<Messages> getMessagesBySenderAndRecipient(UserAccount sender, UserAccount recipient);

    List<Messages> findBySenderAndRecipient(UserAccount sender, UserAccount recipient);

    List<Messages> findBySenderOrRecipient(UserAccount user, UserAccount user2, Sort sort);
}
