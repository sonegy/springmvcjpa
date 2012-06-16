package sonegy.sample.mvcjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sonegy.sample.mvcjpa.domain.SimpleTag;
import sonegy.sample.mvcjpa.repository.SimpleTagRepository;

@Service
@Transactional(readOnly=true)
public class SimpleTagService {
	@Autowired
	SimpleTagRepository simpleTagRepository;
	
	public List<SimpleTag> getTags() {
		return simpleTagRepository.findAll(new Sort(Direction.ASC, "tag"));
	}
}