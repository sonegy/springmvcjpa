package sonegy.sample.mvcjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sonegy.sample.mvcjpa.domain.User;
import sonegy.sample.mvcjpa.repository.UserRepository;

@Service
@Transactional(readOnly=true)
public class UserService {
	@Autowired
	UserRepository userRepository;

	public Page<User> getUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public User getUser(Long id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public void delete(Long id) {
		userRepository.delete(id);		
	}

	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}
}