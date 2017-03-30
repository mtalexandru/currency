package ro.mtalexandru.model;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
		@NamedQuery(name="findAllExercises", query="Select e from Exercise e")
})
public class Exercise {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Range(min = 1, max = 120)
	private int minutes;

	@NotNull
	private String activity;
	
	@ManyToOne //SAU	@ManyToOne(cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	@XmlInverseReference(mappedBy="exercises")
	private Goal goal;

	public String getActivity() {
		return activity;
	}

	public Goal getGoal() {
		return goal;
	}

	public Long getId() {
		return id;
	}
	
	public int getMinutes() {
		return minutes;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
}
