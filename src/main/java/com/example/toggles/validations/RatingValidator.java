//package com.example.toggles.validations;
//
//import com.example.toggles.Student;
//import com.example.toggles.MyFeatures;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.togglz.core.manager.FeatureManager;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class RatingValidator implements
//        ConstraintValidator<Rating, Student> {
//
//    FeatureManager featureManager;
//
//    @Autowired
//    public RatingValidator(FeatureManager featureManager) {
//        this.featureManager = featureManager;
//    }
//
//    @Override
//    public boolean isValid(Student book,
//                           ConstraintValidatorContext cxt) {
//        if (featureManager.isActive(MyFeatures.RATING)) {
//            return 0 < book.getRating() && book.getRating() < 10;
//        } else {
//            return 0 < book.getRating() && book.getRating() < 5;
//        }
//    }
//}
