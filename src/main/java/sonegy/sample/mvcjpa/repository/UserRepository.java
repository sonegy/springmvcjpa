package sonegy.sample.mvcjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sonegy.sample.mvcjpa.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
