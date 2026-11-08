// import packages
package org.example.studentmanagement;
// import annotation classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Import class
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    // List all students
    public List<Student> findAll() {
        return studentRepo.findAll();
    }
    // Save a new Student
    public Student add(Student student) {
        return studentRepo.save(student);
    }
    // Find Student by ID
    public Student find(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    // Delete Student by ID
    public List<Student> delete(int id) {
        studentRepo.deleteById(id);
        return studentRepo.findAll();
    }

    // Update Student by ID
    public Student update(Student student) {
        return studentRepo.save(student);
    }
}
