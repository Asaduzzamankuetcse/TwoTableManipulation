package com.twoTableManipulation.workingSets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TwoTableController {
	@Autowired
	private TwoTableService twoTableService;
	@GetMapping(value="/twotable/create")
	public String createForm(Model model){
		model.addAttribute(new TwoTableEntity());
		model.addAttribute("body", "twotable/createTwoTable");
		return "layouts/default";
	}
	@PostMapping(value="/twotable/create")
	public String postForm(Model model,TwoTableEntity twoTableEntity){
		twoTableService.saveForm(twoTableEntity);
		return "redirect:/twotable/list";

	}

}
