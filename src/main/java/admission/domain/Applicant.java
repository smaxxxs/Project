package admission.domain;

public class Applicant {
	private Integer id;
	private String surname;
	private String name;
	// total points with 3 subjects
	private Integer score;
	// applicant's rating for admission to the faculty. Automatically counted.
	private Integer rate;

	public Applicant() {
	}

	public Applicant(Integer id, String surname, String name, Integer score, Integer rate) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.score = score;
		this.rate = rate;
	}

	public Applicant(Integer id, String surname, String name, Integer score) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.score = score;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Applicant other = (Applicant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", surname=" + surname + ", name=" + name + ", score=" + score + ", rate=" + rate
				+ "]";
	}

}
