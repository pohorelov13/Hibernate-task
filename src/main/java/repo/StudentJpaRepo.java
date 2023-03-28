package repo;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.AllArgsConstructor;
import model.Student;

import java.util.List;

@AllArgsConstructor
public class StudentJpaRepo implements StudentRepo {

    private EntityManager entityManager;

    @Override
    public Student add(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return student;
    }

    @Override
    public void remove(Student student) {
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public Student update(Student student) {
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return student;
    }

    @Override
    public List<Student> getAll() {
        return entityManager.createQuery("SELECT s from Student s", Student.class).getResultList();
    }

    @Override
    public Student getStudentById(int id) {
        return entityManager.find(Student.class, id);
    }
}
