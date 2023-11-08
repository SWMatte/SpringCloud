package student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Student student){
        studentService.addStudent(student);
    }
    @GetMapping()
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> getAll(@PathVariable("schoolId") Integer schoolId){
        return ResponseEntity.ok(studentService.findAllStudentsBySchool(schoolId));
    }
}
