package sonegy.sample.mvcjpa.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SimpleTag {
	@Id
	private String tag;
	public SimpleTag() {
		super();
	}
	public SimpleTag(String tag) {
		super();
		setTag(tag);
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}