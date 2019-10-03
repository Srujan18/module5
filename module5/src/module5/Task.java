package module5;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Task {
	 private String name, description, status;
	    private Date dueDate;
	    public Task(String name, String description, String status, Date dueDate) {
	        this.name = name;
	        this.description = description;
	        this.status = status;
	        this.dueDate = dueDate;
}
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public Date getDueDate() {
	        return dueDate;
	    }

	    public void setDueDate(Date dueDate) {
	        this.dueDate = dueDate;
	    }

	    public String toString(){
	        return (" Task Name: "+name+" Description: "+description+" Status: "+status+" Due Date: "+new SimpleDateFormat("dd/MM/yyyy").format(dueDate));
	    }
	}
