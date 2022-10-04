package io.citations.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.citations.app.entity.Citation;
import io.citations.app.service.CitationService;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/citations")
public class CitationController {

    private CitationService citationService;

    public CitationController(CitationService citationService) {
        this.citationService = citationService;
    }

    @PostMapping("/")
    public void addNewCitation(HttpServletResponse response, HttpServletRequest request)throws Exception{
        String citation=request.getParameter("citation");
        String email=request.getParameter("email");
        new ObjectMapper().writeValue(response.getOutputStream(),citationService.addNewCitation(citation,email));
    }

    @PatchMapping("/")
    public void editCitation(HttpServletRequest request, HttpServletResponse response)throws Exception{
        Long id=Long.parseLong(request.getParameter("id"));
        String citation=request.getParameter("citation");
        citationService.editCitation(id,citation);
        new ObjectMapper().writeValue(response.getOutputStream(),"Citation modifiée");
    }

    @DeleteMapping("/{id}")
    public String deleteCitation(@PathVariable Long id){
        if(citationService.showOneCitation(id)==null){
            return "CITATION NOT FOUND";
        }else{
            citationService.deleteCitation(id);
            return "CITATION REMOVED";
        }

    }

    @GetMapping("/{id}")
    public Citation showOneCitation(@PathVariable Long id){
        return citationService.showOneCitation(id);
    }

    @GetMapping("/")
    public List<Citation> showAllCitation(){
        return citationService.showAllCitation();
    }
}
