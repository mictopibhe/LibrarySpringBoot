//package pl.davidduke.LibraryBoot.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//import pl.davidduke.LibraryBoot.models.Person;
//import pl.davidduke.LibraryBoot.services.PeopleService;
//
//
//@Component
//public class PersonValidator implements Validator {
//
//    private final PeopleService peopleService;
//
//    @Autowired
//    public PersonValidator(PeopleService peopleService) {
//        this.peopleService = peopleService;
//    }
//
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Person.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Person person = (Person) target;
//
//        if(peopleService.findByLastnameAndFirstname(person).isPresent())
//            errors.rejectValue("surName", "", "The person with that name already exists");
//
//    }
//}
