package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import lv.venta.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Long>{

	ArrayList<Grade> findByGrvalueLessThan(int i);

	ArrayList<Grade> findByStudentIds(long id);

	@Query(nativeQuery = true, value = "select avg(grvalue) from grade_table where idc=(?1);")
	float calculateAVGGrade_MyFunction(long id);

	
}
