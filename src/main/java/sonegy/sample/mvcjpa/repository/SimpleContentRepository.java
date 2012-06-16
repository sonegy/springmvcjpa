package sonegy.sample.mvcjpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import sonegy.sample.mvcjpa.domain.SimpleContent;
import sonegy.sample.mvcjpa.domain.SimpleStatus;
import sonegy.sample.mvcjpa.domain.SimpleTag;

public interface SimpleContentRepository extends JpaRepository<SimpleContent, Long>, JpaSpecificationExecutor<SimpleContent> {
	public Page<SimpleContent> findByStatus(SimpleStatus status, Pageable pageable);
	public Page<SimpleContent> findBySimpleTags(SimpleTag simpleTag, Pageable pageable);
	public Page<SimpleContent> findBySimpleTags(SimpleTag simpleTag); 
}