package ru.flendger.interview.lesson7;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentSpringService {
    private final StudentSpringRepository studentSpringRepository;

    public StudentSpringService(StudentSpringRepository studentSpringRepository) {
        this.studentSpringRepository = studentSpringRepository;
    }

    public List<StudentSpring> findAll() {
        return studentSpringRepository.findAll();
    }

    public Optional<StudentSpring> findById(Long id) {
        return studentSpringRepository.findById(id);
    }

    public StudentSpring save(StudentSpring studentSpring) {
        return studentSpringRepository.save(studentSpring);
    }

    @Transactional
    public void delete(Long id) {
        StudentSpring studentSpring = studentSpringRepository.getById(id);
        studentSpringRepository.delete(studentSpring);
    }
}
