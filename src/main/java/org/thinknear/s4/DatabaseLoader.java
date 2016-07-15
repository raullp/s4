package org.thinknear.s4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.thinknear.s4.domain.Class;
import org.thinknear.s4.domain.Student;
import org.thinknear.s4.repositories.ClassRepository;
import org.thinknear.s4.repositories.StudentRepository;

/**
 * Created by raul on 7/14/16.
 */
@Component
public class DatabaseLoader implements CommandLineRunner{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassRepository classRepository;

    @Override
    public void run(String... strings) throws Exception {
        studentRepository.save(makeStudent("Mace", "Windu"));
        studentRepository.save(makeStudent("Padmé", "Amidala"));
        studentRepository.save(makeStudent("Lando", "Calrissian"));
        studentRepository.save(makeStudent("Qui-Gon", "Jinn"));
        studentRepository.save(makeStudent("Obi-Wan", "Kenobi"));
        studentRepository.save(makeStudent("Jango", "Fett"));
        studentRepository.save(makeStudent("Boba", "Fett"));
        studentRepository.save(makeStudent("Kylo", "Ren"));
        studentRepository.save(makeStudent("Han", "Solo"));
        studentRepository.save(makeStudent("Anakin", "Skywalker"));
        studentRepository.save(makeStudent("Luke", "Skywalker"));

        classRepository.save(makeClass("shaping-up-with-angular", "Shaping up with Angular.js", "Learn to extend HTML's syntax with AngularJS to create dynamic web applications."));
        classRepository.save(makeClass("staying-sharp-angular", "Staying sharp with Angular.js", "Use AngularJS to create flexible directives and reusable services for a modular and speedy app!"));
        classRepository.save(makeClass("rails-for-zombies", "Rails for Zombies Redux", "Learn Ruby on Rails, an open-source framework."));
    }

    private Student makeStudent(String firstName, String lastName) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);

        return student;
    }

    private Class makeClass(String code, String title, String description) {
        Class clazz = new Class();
        clazz.setCode(code);
        clazz.setTitle(title);
        clazz.setDescription(description);

        return clazz;
    }
}
