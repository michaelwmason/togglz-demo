package com.example.toggles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

@RestController
public class ToggleController {

    FeatureManager featureManager;
    BookRepository bookRepository;

    @Autowired
    public ToggleController(FeatureManager featureManager, BookRepository bookRepository) {
        this.featureManager = featureManager;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/demo")
    public String message() {
        if (featureManager.isActive(
                MyFeatures.MESSAGE)) {
            return "MESSAGE toggle is currently active";
        } else {
            return "MESSAGE toggle is currently not active";
        }
    }

    @PostMapping("/students")
    public Book createStudent(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return savedBook;


    }

}
