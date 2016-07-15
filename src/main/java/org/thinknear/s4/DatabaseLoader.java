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
        studentRepository.save(new Student("Mace", "Windu"));
        studentRepository.save(new Student("Padmé", "Amidala"));
        studentRepository.save(new Student("Lando", "Calrissian"));
        studentRepository.save(new Student("Qui-Gon", "Jinn"));
        studentRepository.save(new Student("Obi-Wan", "Kenobi"));
        studentRepository.save(new Student("Jango", "Fett"));
        studentRepository.save(new Student("Boba", "Fett"));
        studentRepository.save(new Student("Kylo", "Ren"));
        studentRepository.save(new Student("Han", "Solo"));
        studentRepository.save(new Student("Anakin", "Skywalker"));
        studentRepository.save(new Student("Luke", "Skywalker"));

        classRepository.save(makeClass("shaping-up-with-angular", "Shaping up with Angular.js", "Learn to extend HTML's syntax with AngularJS to create dynamic web applications."));
        classRepository.save(makeClass("staying-sharp-angular", "Staying sharp with Angular.js", "Use AngularJS to create flexible directives and reusable services for a modular and speedy app!"));
        classRepository.save(makeClass("rails-for-zombies", "Rails for Zombies Redux", "Learn Ruby on Rails, an open-source framework."));
    }

    private Class makeClass(String code, String title, String description) {
        Class clazz = new Class();
        clazz.setCode(code);
        clazz.setTitle(title);
        clazz.setDescription(description);

        return clazz;
    }
}
