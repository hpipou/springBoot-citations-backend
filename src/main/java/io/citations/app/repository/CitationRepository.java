package io.citations.app.repository;

import io.citations.app.entity.Citation;
import io.citations.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitationRepository extends JpaRepository<Citation, Long> {
    Citation findByIdUser(User user);
}
