package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilteringService;

@Service
public class IFilteringServiceImpl implements IFilteringService{
	
	@Autowired
	private IStudentRepo studentRepo;
	
	@Autowired
	private IGradeRepo gradeRepo;
	
	@Autowired
	private ICourseRepo courseRepo;
	
	@Autowired
	private IProfessorRepo professorRepo;
	
	
	@Override
	public ArrayList<Grade> selectFailedGradesInSystem() throws Exception {
		ArrayList<Grade> result = gradeRepo.findByGrvalueLessThan(4);
		if(result.isEmpty()) throw new Exception("No failed grades");
		return result;
	}

	@Override
	public ArrayList<Grade> selectGradeByStudentId(long id) throws Exception {
		if(id < 1) throw new Exception("ID should be greater than 0");
		
		if(!studentRepo.existsById(id)) throw new Exception("Student with id("+id+") does not exist");
		
		ArrayList<Grade> result = gradeRepo.findByStudentIds(id);
		
		if(result.isEmpty()) throw new Exception("Student with id("+id+") does not have any grades");
		
		
		return result;
		
	}

	@Override
	public ArrayList<Course> selectCoursebyStudentId(long id) throws Exception {
		if(id < 1) throw new Exception("ID should be greater than 0");
		
		if(!studentRepo.existsById(id)) throw new Exception("Student with id("+id+") does not exist");
		
		ArrayList<Course> result = courseRepo.findByGradesStudentIds(id);
		
		if(result.isEmpty()) throw new Exception("Student with id("+id+") does not have any courses");
		
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception {
		if(id < 1) throw new Exception ("ID should be greater than 0");
		
		if(!professorRepo.existsById(id)) throw new Exception("Professor with id("+id+") does not exist");
		
		ArrayList<Course> result = courseRepo.findByProfessorIdp(id);
		
		if(result.isEmpty()) throw new Exception("Professor with id("+id+") does not have any courses");
		return result;
	}

	@Override
	public float calculateAVGGradeInCourse(long id) throws Exception {
		if(id < 1) throw new Exception ("ID should be greater than 0");
		
		if(!courseRepo.existsById(id)) throw new Exception("Course with this ("+id+") does not exist");
		
		float result = gradeRepo.calculateAVGGrade_MyFunction(id);
		
		if(result == 0) throw new Exception("No grades for the course"); 
		
		return result;
	}
	
}                       
