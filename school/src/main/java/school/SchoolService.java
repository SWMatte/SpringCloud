package school;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.client.StudentClient;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    private StudentClient studentClient;

    public SchoolService(StudentClient studentClient) {
        this.studentClient = studentClient;
    }


    public void addStudent(School school) {

        schoolRepository.save(school);
    }

    public List<School> findAllStudents() {
        return schoolRepository.findAll();
    }


    public FullSchoolResponse findSchoolWithStudent(Integer schoolId) {

        var school = schoolRepository.findById(schoolId).orElse(School.builder().name("NOT-FOUND").email("NOT-FOUND").build());
        var students = studentClient.findAllStudentBySchool(schoolId);
        return FullSchoolResponse.builder().name(school.getName()).email(school.getEmail()).students(students).build();

    }


}
