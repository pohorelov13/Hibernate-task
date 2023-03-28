package repo;

import model.Student;

import java.util.List;

public interface StudentRepo {
    Student add(Student student);

    void remove(Student student);

    Student update(Student student);

    List<Student> getAll();

    Student getStudentById(int id);

}
