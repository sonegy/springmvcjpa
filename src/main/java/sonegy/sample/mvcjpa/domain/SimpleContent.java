package sonegy.sample.mvcjpa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity
public class SimpleContent extends AbstractAuditable<User, Long> {
	private static final long serialVersionUID = 1785507768518091822L;
	
	private String title;
	@Column(columnDefinition="varchar(10000)")
	private String content;
	@Enumerated(EnumType.STRING)
	private SimpleStatus status;
	@ManyToMany
	@OrderBy(value="tag asc")
	private Set<SimpleTag> simpleTags;
	@Transient
	private String simpleTagText;
	@Override
	public void setId(Long id) {
		super.setId(id);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Set<SimpleTag> getSimpleTags() {
		return simpleTags;
	}
	public void setSimpleTags(Set<SimpleTag> simpleTags) {
		this.simpleTags = simpleTags;
	}
	public SimpleStatus getStatus() {
		return status;
	}
	public void setStatus(SimpleStatus status) {
		this.status = status;
	}
	public String getSimpleTagText() {
		StringBuilder sb = new StringBuilder();
		if(simpleTags != null) {
			boolean first = true;
			for(SimpleTag tag : simpleTags) {
				if(!first) {
					sb.append(",");
				}
				first = false;
				sb.append(tag);
			}
		}
		return sb.toString();
	}
	public void setSimpleTagText(String simpleTagText) {
		simpleTags = new HashSet<SimpleTag>();
		if(simpleTagText != null) {
			String[] split = simpleTagText.split(",");
			for(String tag : split) {
				simpleTags.add(new SimpleTag(tag));
			}
		}
		this.simpleTagText = simpleTagText;
	}
}