// Package
package org.example.studentmanagement;

// Import Annotation classes
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get list of students
    @RequestMapping("/list")
    @ResponseBody
    public List<Student> getStudents() {
        return studentService.findAll();
    }

    // Add Srudent
    @PostMapping("/add")
    @ResponseBody
    public Student addStudent(@RequestBody Student student) {
        return studentService.add(student);
    }

    // Get student by Id
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Student getStudent(@PathVariable int id) {
        return studentService.find(id);
    }

    // Delete Student by ID
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public List<Student> deleteStudent(@PathVariable int id) {
        return studentService.delete(id);
    }

    // Update Student By ID
    @PostMapping("/update")
    @ResponseBody
    public Student updateStudent(@PathVariable Student student) {
        return studentService.update(student);
    }

    // -------------------- HTML END POINTS --------------------
    // http://localhost:8080/student/index

    // connecting front end and backend
    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("appversion", "V 1.0.0.1");
        model.addAttribute("students", studentService.findAll());
        return "Index";
    }
    // Get new Student Form
    @RequestMapping("/addstudent")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());
        return "addstudent";
    }

    // Insert detials  into database from UI
    @RequestMapping("/add-action")
    public String addStudentUI(@Valid @ModelAttribute("student") Student student,BindingResult bindingResult, Model model) {
        if(!bindingResult.hasErrors()) {
            studentService.add(student);
            return "redirect:/student/index" ;
        }
        else {
            return "addstudent";
        }
    }

    // Delete details from databese from UI
    @RequestMapping("/delete-action/{id}")
    public String deleteStudentUI(@PathVariable int id) {
        studentService.delete(id);
        return "redirect:/student/index";
    }

    // Edit Student UI action
    @RequestMapping("/edit-action/{id}")
    public String editStudentUI(@PathVariable int id, Model model) {
        // filling the student object using the student ID from path
        model.addAttribute("student",studentService.find(id));
        return "editstudent";
    }
}

// Hardcide manually add detials to table
//        public List<Student> getStudents() {
//        List <Student> students = new ArrayList<>();
//        Student student1 = new Student(1001,"Bihandu Silva", "Bihandu.silva@gmail.com","Morotuwa, Colombo");
//        students.add(student1);
//        return students;

