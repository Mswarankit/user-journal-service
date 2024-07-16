package com.user_journal_journal.journal_service.controller;

import com.user_journal_journal.journal_service.model.Journal;
import com.user_journal_journal.journal_service.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/journals")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @GetMapping
    public List<Journal> getAllJournals() {
        return journalService.getAllJournals();
    }
}