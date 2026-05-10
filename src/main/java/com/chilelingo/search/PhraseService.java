package com.chilelingo.search;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhraseService {

    private List<Phrase> phrases = new ArrayList<>();

    public PhraseService() {
        loadData();
    }

    private void loadData() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream inputStream = getClass()
                    .getClassLoader()
                    .getResourceAsStream("data/phrases.json");

            if (inputStream == null) {
                System.out.println("No se encontró el JSON");
                return;
            }

            phrases = mapper.readValue(
                    inputStream,
                    new TypeReference<List<Phrase>>() {}
            );

            System.out.println("Frases cargadas: " + phrases.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Phrase> search(String query) {
        List<Phrase> results = new ArrayList<>();

        for (Phrase p : phrases) {
            if (p.getText().toLowerCase().contains(query.toLowerCase())) {
                results.add(p);
            }
        }

        return results;
    }
}