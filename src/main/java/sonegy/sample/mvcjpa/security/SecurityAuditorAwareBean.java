package sonegy.sample.mvcjpa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.transaction.annotation.Transactional;

import sonegy.sample.mvcjpa.domain.User;
import sonegy.sample.mvcjpa.repository.UserRepository;

public class SecurityAuditorAwareBean implements AuditorAware<User> {
	@Autowired
	UserRepository userRepository;
	
	@Transactional(readOnly=true)
	public User getCurrentAuditor() {
		return userRepository.findOne(1L);
	}
}
