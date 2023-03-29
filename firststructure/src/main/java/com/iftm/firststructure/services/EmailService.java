package com.iftm.firststructure.services;

import com.iftm.firststructure.models.Email;
import com.iftm.firststructure.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public Optional<Email> findById(Long id) {
        return emailRepository.findById(id);
    }

    public Email save(Email email) {
        if(!email.getFrom().isBlank() && !email.getTo().isEmpty() && !email.getSubject().isEmpty() && !email.getBody().isEmpty() && !email.getAttachment().isEmpty()) {
            return emailRepository.save(email);
        }
        return null;
    }

    public Email update(Email email) {
        var dbEmail = emailRepository.findById(email.getId());
        if(dbEmail.isPresent()) {
            return emailRepository.save(email);
        }
        return null;
    }

    public String delete(Long id) {
        var dbEmail = emailRepository.findById(id);
        if(dbEmail.isPresent()) {
            emailRepository.deleteById(id);
            return "Email id " + id + " has been deleted!";
        }else
            return "ID " + id + " not found!";
    }
}
