package sonegy.sample.mvcjpa.controller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sonegy.sample.mvcjpa.domain.SimpleUser;
import sonegy.sample.mvcjpa.service.SimpleUserService;

@Controller
@RequestMapping("simpleUsers")
public class SimpleUserController {
	private static final Logger logger = LoggerFactory.getLogger(SimpleUserController.class);
	
	@Autowired
	SimpleUserService simpleUserService;
	
	@RequestMapping
	public void getUsers( 
			Pageable pageable, Model model) {
		logger.debug("{}", ToStringBuilder.reflectionToString(pageable));
		Page<SimpleUser> page =  simpleUserService.getUsers(pageable);
		model.addAttribute("page", page);
	}
	
	@RequestMapping("{id}")
	public String getUser(@PathVariable Long id, Model model) {
		model.addAttribute(simpleUserService.getUser(id));
		return "simpleUsers/view";
	}
	
	@RequestMapping(value="form",method=RequestMethod.GET)
	public void getForm(
			@ModelAttribute SimpleUser simpleUser, Model model){
		if(simpleUser.getId() != null) {
			simpleUser = simpleUserService.getUser(simpleUser.getId());
			model.addAttribute(simpleUser);
		}
	}
	
	@RequestMapping(value="form",method=RequestMethod.POST)
	public String save(
			@ModelAttribute SimpleUser simpleUser) {
		simpleUserService.save(simpleUser);
		return "redirect:" + simpleUser.getId();
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam Long id) {
		simpleUserService.delete(id);
		return "redirect:/simpleUsers";
	}
}