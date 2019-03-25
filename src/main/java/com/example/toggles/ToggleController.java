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
    StudentRepository studentRepository;

    @Autowired
    public ToggleController(FeatureManager featureManager, StudentRepository studentRepository) {
        this.featureManager = featureManager;
        this.studentRepository = studentRepository;
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
    public Student createStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);
        return savedStudent;


    }

}
