package udSah.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udSah.practice.entity.Student;
import udSah.practice.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {


    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq) {
        Student studentResp = studentService.createStudent(studentReq);

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        Student studentResp = studentService.getStudent(id);
        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentResp = studentService.getAllStudent();
        return ResponseEntity.ok(studentResp);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id) {
        Student deletedStudent = studentService.deleteStudent(id);

        if(deletedStudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletedStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student studentReq) {

        Student updatedStudent =
                studentService.updateStudent(id, studentReq);

        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedStudent);


    }
}
