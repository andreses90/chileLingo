package com.chilelingo.search;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin
public class PhraseController {

    private final PhraseService service;

    public PhraseController(PhraseService service) {
        this.service = service;
    }

    @GetMapping("/search")
    public List<Phrase> search(@RequestParam String q) {
        return service.search(q);
    }
}
