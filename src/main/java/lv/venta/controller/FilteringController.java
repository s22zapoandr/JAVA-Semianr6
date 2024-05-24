package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import lv.venta.model.Grade;
import lv.venta.service.IFilteringService;


@Controller
@RequestMapping("/filter")
public class FilteringController {
	
	@Autowired
	private IFilteringService filterService;
	
	@GetMapping("/grade/failed")
	public String getFilterGradeFailed(Model model) {
		
		try {
			ArrayList <Grade> dataFromService = filterService.selectFailedGradesInSystem();
			model.addAttribute("mypackage", dataFromService);
			return "show-all-grades-page";
		}
		catch(Exception e) {
			model.addAttribute("mypackage", e.getMessage());
			return "error-page";
		}
	}
																																																																																																													
}
