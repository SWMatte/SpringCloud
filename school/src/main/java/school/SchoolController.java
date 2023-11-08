package school;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("schools")
@Slf4j
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody School school){
        schoolService.addStudent(school);
    }
    @GetMapping()
    public ResponseEntity<List<School>> getAll(){
        return ResponseEntity.ok(schoolService.findAllStudents());
    }

    @GetMapping("/withstudents/{schoolId}")
    public ResponseEntity<FullSchoolResponse> getAll(@PathVariable Integer schoolId){
        return ResponseEntity.ok(schoolService.findSchoolWithStudent(schoolId));


    }

}
