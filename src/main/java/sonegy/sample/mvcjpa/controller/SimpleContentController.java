package sonegy.sample.mvcjpa.controller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sonegy.sample.mvcjpa.domain.SimpleContent;
import sonegy.sample.mvcjpa.domain.SimpleStatus;
import sonegy.sample.mvcjpa.domain.SimpleTag;
import sonegy.sample.mvcjpa.service.SimpleContentService;
import sonegy.sample.mvcjpa.service.SimpleContentSpec;
import sonegy.sample.mvcjpa.service.SimpleContentSpec.SimpleContent_;
import sonegy.sample.mvcjpa.service.SimpleTagService;

@Controller
@RequestMapping("simpleContents")
public class SimpleContentController {
	private static final Logger logger = LoggerFactory.getLogger(SimpleContentController.class);
	
	@Autowired
	SimpleContentService simpleContentService;
	@Autowired
	SimpleTagService simpleTagService;
	
	public static class Search {
		private String tag;
		private boolean notUseSimpleStatus;
		private SimpleStatus simpleStatus;
		public SimpleStatus getSimpleStatus() {
			return simpleStatus;
		}
		public void setSimpleStatus(SimpleStatus simpleStatus) {
			this.simpleStatus = simpleStatus;
		}
		public boolean isNotUseSimpleStatus() {
			return notUseSimpleStatus;
		}
		public void setNotUseSimpleStatus(boolean notUseSimpleStatus) {
			this.notUseSimpleStatus = notUseSimpleStatus;
		}
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
	}
	@RequestMapping
	public void getContents( 
			@ModelAttribute Search search,
			Pageable pageable, Model model) {
		logger.debug("{}", ToStringBuilder.reflectionToString(pageable));
		Page<SimpleContent> page = null;
		if(search.getTag() == null) {
			page =  simpleContentService.getContents(
			search.notUseSimpleStatus ? null :
			search.getSimpleStatus(), pageable);			
		}else {
			page =  simpleContentService.getContents(new SimpleTag(search.getTag()));
		}
		
//		Specifications<SimpleContent> spec = null;
//		if(search.isNotUseSimpleStatus()) {
//			spec = Specifications.where(SimpleContentSpec.isStatus(search.getSimpleStatus()));
//		}
//		if(search.getTag() != null){
//			spec = Specifications.where(SimpleContentSpec.isTag(new SimpleTag(search.getTag())));
//		}
//		Page<SimpleContent> page = simpleContentService.getContents(spec, pageable);
		
		model.addAttribute("simpleStatusList", SimpleStatus.values());
		model.addAttribute("page", page);
		model.addAttribute("tags", simpleTagService.getTags());
	}
	
	@RequestMapping("{id}")
	public String getContent(@PathVariable Long id, Model model) {
		model.addAttribute(simpleContentService.getContent(id));
		return "simpleContents/view";
	}
	
	@RequestMapping(value="form",method=RequestMethod.GET)
	public void getForm(
			@ModelAttribute SimpleContent simpleContent, Model model){
		if(!simpleContent.isNew()) {
			simpleContent = simpleContentService.getContent(simpleContent.getId());
			model.addAttribute(simpleContent);
		}
		model.addAttribute("simpleStatusList", SimpleStatus.values());
	}
	
	@RequestMapping(value="form",method=RequestMethod.POST)
	public String save(
			@ModelAttribute SimpleContent simpleContent) {
		if(!simpleContent.isNew()) {
			SimpleContent stored = simpleContentService.getContent(simpleContent.getId());
			stored.setTitle(simpleContent.getTitle());
			stored.setSimpleTagText(simpleContent.getSimpleTagText());
			stored.setContent(simpleContent.getContent());
			stored.setStatus(simpleContent.getStatus());
			simpleContent = stored;
		}
		simpleContentService.save(simpleContent);
		return "redirect:" + simpleContent.getId();
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam Long id) {
		simpleContentService.delete(id);
		return "redirect:/simpleContents";
	}
}