package sonegy.sample.mvcjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sonegy.sample.mvcjpa.domain.SimpleUser;
import sonegy.sample.mvcjpa.repository.SimpleUserRepository;

@Service
@Transactional(readOnly=true)
public class SimpleUserService {
	@Autowired
	SimpleUserRepository simpleUserRepository;

	public SimpleUser getUser(Long id) {
		return simpleUserRepository.findOne(id);
	}

	@Transactional
	public void save(SimpleUser simpleUser) {
		simpleUserRepository.save(simpleUser);
	}

	@Transactional
	public void delete(Long id) {
		simpleUserRepository.delete(id);
	}

	public Page<SimpleUser> getUsers(Pageable pageable) {
		if(pageable.getSort() == null) {
			pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), new Sort(Direction.DESC, "id"));
		}
		return simpleUserRepository.findAll(pageable);
	}	
}