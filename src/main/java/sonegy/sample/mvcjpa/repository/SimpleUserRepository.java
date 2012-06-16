package sonegy.sample.mvcjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sonegy.sample.mvcjpa.domain.SimpleUser;

public interface SimpleUserRepository extends JpaRepository<SimpleUser, Long> {
}
