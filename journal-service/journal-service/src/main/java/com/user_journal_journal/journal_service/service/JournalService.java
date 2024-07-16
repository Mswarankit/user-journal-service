package com.user_journal_journal.journal_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {
    @Autowired
    private JournalRepository journalRepository;

    @KafkaListener(topics = "user-events", groupId = "journal-group")
    public void listen(String message) {
        Journal journal = new Journal();
        journal.setEvent(message);
        journalRepository.save(journal);
    }

    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }
}