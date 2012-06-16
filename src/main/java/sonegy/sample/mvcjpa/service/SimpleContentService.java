package sonegy.sample.mvcjpa.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sonegy.sample.mvcjpa.domain.SimpleContent;
import sonegy.sample.mvcjpa.domain.SimpleStatus;
import sonegy.sample.mvcjpa.domain.SimpleTag;
import sonegy.sample.mvcjpa.repository.SimpleContentRepository;
import sonegy.sample.mvcjpa.repository.SimpleTagRepository;

@Service
@Transactional(readOnly=true)
public class SimpleContentService {
	private static final Logger logger = LoggerFactory.getLogger(SimpleContentService.class);
	
	@Autowired
	SimpleContentRepository simpleContentRepository;
	@Autowired
	SimpleTagRepository simpleTagRepository;

	public Page<SimpleContent> getContents(SimpleStatus status, Pageable pageable) {
		if(status == null)
			return simpleContentRepository.findAll(pageable);
		else 
			return simpleContentRepository.findByStatus(status, pageable);
	}
	public Page<SimpleContent> getContents(Specification<SimpleContent> specification, Pageable pageable) {
		return simpleContentRepository.findAll(specification, pageable);
	}
	
	public Page<SimpleContent> getContents(SimpleTag simpleTag) {
		return simpleContentRepository.findBySimpleTags(simpleTag);
	}

	public SimpleContent getContent(Long id) {
		return simpleContentRepository.findOne(id);
	}

	@Transactional
	public void save(SimpleContent simpleContent) {
		Set<SimpleTag> simpleTags = simpleContent.getSimpleTags();
		simpleTagRepository.save(simpleTags);
		simpleContentRepository.save(simpleContent);
	}
	
	@Transactional
	public void delete(Long id) {
		simpleContentRepository.delete(id);
	}
}