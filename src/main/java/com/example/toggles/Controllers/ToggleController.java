package com.example.toggles.Controllers;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.manager.FeatureManager;

import com.example.toggles.MyFeatures;
import com.example.toggles.Entities.Book;
import com.example.toggles.Repos.BookRepository;
import com.example.toggles.ValidationGroups.Legacy;
import com.example.toggles.ValidationGroups.Modern;

@RestController
public class ToggleController {

    FeatureManager featureManager;
    BookRepository bookRepository;
    Validator validator;

    @Autowired
    public ToggleController(FeatureManager featureManager, BookRepository bookRepository, Validator validator) {
        this.featureManager = featureManager;
        this.bookRepository = bookRepository;
        this.validator = validator;
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
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        Set<ConstraintViolation<Book>> violations = validator.validate(book, Default.class,
        		featureManager.isActive(MyFeatures.RATING) ?  Modern.class : Legacy.class);
        if(violations.isEmpty()){
            Book savedBook = bookRepository.save(book);
            return new ResponseEntity<>(savedBook, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(violations.toString(), HttpStatus.BAD_REQUEST);

        }

    }

}
