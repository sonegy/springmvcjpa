package sonegy.sample.mvcjpa.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import sonegy.sample.mvcjpa.domain.SimpleContent;
import sonegy.sample.mvcjpa.domain.SimpleStatus;
import sonegy.sample.mvcjpa.domain.SimpleTag;

public class SimpleContentSpec {

	public static class SimpleContent_ {
		public static String status = "status";
		public static String simpleTags = "simpleTags";
	}
	public static Specification<SimpleContent> isStatus(final SimpleStatus simpleStatus) {
		return new Specification<SimpleContent>() {
			public Predicate toPredicate(Root<SimpleContent> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(SimpleContent_.status), simpleStatus);
			}			
		};
	}
	public static Specification<SimpleContent> isTag(final SimpleTag simpleTag) {
		return new Specification<SimpleContent>() {
			public Predicate toPredicate(Root<SimpleContent> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get(SimpleContent_.simpleTags), simpleTag);
			}
		};
	}
}
