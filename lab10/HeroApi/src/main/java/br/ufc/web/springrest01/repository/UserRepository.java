package br.ufc.web.springrest01.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ufc.web.springrest01.model.UserAccount;
@Repository
public interface UserRepository extends CrudRepository<UserAccount, Integer>{

    Optional<UserAccount> findUserByUsername(String username);

    Optional<UserAccount> findByEmail(String email);

    Optional<UserAccount> findById(Long recipientId);

    Optional<UserAccount> findAllById(Long senderId);

}
