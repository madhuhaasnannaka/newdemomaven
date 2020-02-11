package net.guides.springboot2.crud.demo1.model;

public class DetailsFromDoctor {
private String status;

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public DetailsFromDoctor(String status) {
	super();
	this.status = status;
}

public DetailsFromDoctor() {
	super();
}
}
