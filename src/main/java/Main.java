import jakarta.persistence.*;
import model.Student;
import repo.StudentJpaRepo;
import repo.StudentRepo;

public class Main {


    public static void main(String[] args) {

        Student student = new Student();
        student.setEmail("email");
        student.setName("name");

        Student student1 = new Student();
        student1.setName("TAQ");
        student1.setEmail("ta@q.com");

        Student student2 = new Student();
        student2.setEmail("email3");
       // student2.setName("NE IVAN");

        CustomEntityManagerFactory.addEntityClass(Student.class);


        EntityManager entityManager = CustomEntityManagerFactory.getEntityManager();

        StudentRepo repo = new StudentJpaRepo(entityManager);

        System.out.println(repo.add(student));
        System.out.println("__________________________^ADD____________________________");

        System.out.println(repo.add(student1));
        System.out.println("__________________________^ADD____________________________");

        System.out.println(repo.add(student2));
        System.out.println("__________________________^ADD____________________________");

        student.setName("anotherNAme");
        System.out.println(repo.update(student));
        System.out.println("__________________________^UPDATE____________________________");

        repo.remove(student);

        System.out.println(repo.getAll());
        System.out.println("__________________________^GET ALL____________________________");

        System.out.println(repo.getStudentById(2));
        System.out.println("__________________________^GET BY ID____________________________");
        entityManager.close();
    }
}
