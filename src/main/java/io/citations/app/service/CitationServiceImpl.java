package io.citations.app.service;

import io.citations.app.entity.Citation;
import io.citations.app.entity.User;
import io.citations.app.repository.CitationRepository;
import io.citations.app.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CitationServiceImpl implements CitationService {

    private CitationRepository citationRepository;
    private UserRepository userRepository;

    public CitationServiceImpl(CitationRepository citationRepository, UserRepository userRepository) {
        this.citationRepository = citationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Citation addNewCitation(String citation, String email) {
        User user=userRepository.findByEmail(email);
        Citation citation1=new Citation();
        citation1.setCitation(citation);
        citation1.setIdUser(user);
        return citationRepository.save(citation1);
    }

    @Override
    public Citation editCitation(Long id, String newCitation) {
        Citation citation=citationRepository.findById(id).orElse(null);
        citation.setCitation(newCitation);
        return citationRepository.save(citation);
    }

    @Override
    public void deleteCitation(Long id) {
        citationRepository.deleteById(id);
    }

    @Override
    public Citation showOneCitation(Long id) {
        return citationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Citation> showAllCitation() {
        return citationRepository.findAll();
    }
}
