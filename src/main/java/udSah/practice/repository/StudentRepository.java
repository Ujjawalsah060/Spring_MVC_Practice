package udSah.practice.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import udSah.practice.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class StudentRepository {

    private Map< Long, Student> studentDB;

    public StudentRepository(){
        studentDB = new HashMap<>();
    }

    public Student save(Student studentReq){
        studentDB.put(studentReq.getId(),studentReq);
        return  studentReq;
    }

    public  Student findById(Long id){
        return  studentDB.get(id);
    }

    public List<Student> findByAll(){
        return new ArrayList<>(studentDB.values());

    }
        public Student updateStudent(Long id, Student studentReq) {
            Student existingStudent = studentDB.get(id);
            existingStudent.setEmail(studentReq.getEmail());
            existingStudent.setAddress(studentReq.getAddress());
            existingStudent.setName(studentReq.getName());
            return existingStudent;
        }

    public Student delete(Long id){
        return  studentDB.remove(id);
    }



}
