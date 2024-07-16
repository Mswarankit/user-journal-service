package com.user_journal_journal.journal_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}