package udSah.practice.service;

import org.springframework.stereotype.Service;
import udSah.practice.entity.Student;
import udSah.practice.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service

public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public Student createStudent( Student studentReq){
        return studentRepository.save(studentReq);
    }

    public Student getStudent( Long id){
        return  studentRepository.findById(id);
    }

    public List<Student> getAllStudent(){
        return  studentRepository.findByAll();
    }


    public Student deleteStudent( Long id){
        return  studentRepository.delete(id);

    }

    public Student updateStudent(Long id, Student studentReq){

        return studentRepository.updateStudent(id,studentReq);
    }

}
