package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Course;
import lv.venta.model.Grade;

public interface IFilteringService {
	
	public abstract ArrayList<Grade> selectFailedGradesInSystem() throws Exception;
	public abstract ArrayList<Grade> selectGradeByStudentId(long id) throws Exception;
	public abstract ArrayList<Course> selectCoursebyStudentId(long id) throws Exception; 
	public abstract ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception;
	public abstract float calculateAVGGradeInCourse(long id) throws Exception;
	
	
}
