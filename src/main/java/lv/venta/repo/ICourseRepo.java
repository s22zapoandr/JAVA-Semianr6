package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import lv.venta.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Long>{

	ArrayList<Course> findByProfessorIdp(long id);

	ArrayList<Course> findByGradesStudentIds(long id);

}
