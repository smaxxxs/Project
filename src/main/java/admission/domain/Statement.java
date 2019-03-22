package admission.domain;

import java.util.List;

public class Statement {
	private List <Request> requests;

	public Statement() {
	}

	public Statement(List<Request> requests) {
		this.requests = requests;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	@Override
	public String toString() {
		return "Statement [requests=" + requests + "]";
	}
	
	
}
