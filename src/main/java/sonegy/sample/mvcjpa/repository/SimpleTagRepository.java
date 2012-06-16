package sonegy.sample.mvcjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sonegy.sample.mvcjpa.domain.SimpleTag;

public interface SimpleTagRepository extends JpaRepository<SimpleTag, String> {

}
