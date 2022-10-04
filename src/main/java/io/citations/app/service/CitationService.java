package io.citations.app.service;

import io.citations.app.entity.Citation;

import java.util.List;

public interface CitationService {
    Citation addNewCitation(String citation, String email);
    Citation editCitation(Long id, String citation);
    void deleteCitation(Long id);
    Citation showOneCitation(Long id);
    List<Citation> showAllCitation();
}
