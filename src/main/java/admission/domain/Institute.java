package admission.domain;

import java.util.List;

public class Institute {
	private String name;
	private List<Faculty> faculties;

	public Institute() {

	}

	public Institute(String name, List<Faculty> faculties) {

		this.name = name;
		this.faculties = faculties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}

	@Override
	public String toString() {
		return "Institute [name=" + name + ", faculties=" + faculties + "]";
	}

}
