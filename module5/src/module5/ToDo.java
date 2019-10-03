package module5;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ToDo {
	Task[] tasks;
	 private int countTask;

	    //Constructor
	    public ToDo(){
	        tasks = new Task[10];
	        countTask = 0;

}
	    public void addTask(Task task){
	        tasks[countTask++] = task;
	    }
	    public void remove(String taskName){
	        for(int i = 0; i<countTask ; i++)
	            if (tasks[i].getName().equalsIgnoreCase(taskName)){
	                Task temp = tasks[i];
	                // left shifting the object values.
	                for (int temp_index = i; temp_index<countTask; temp_index++)
	                    tasks[temp_index] = tasks[temp_index + 1];
	                System.out.println(temp);
	                countTask--;
	            }
	    }
	    public Task update(String taskName){
	        for (int i = 0; i < countTask; i++)
	            if(taskName.equalsIgnoreCase(tasks[i].getName())){
	                if (tasks[i].getStatus().equalsIgnoreCase("incomplete") || tasks[i].getStatus().equalsIgnoreCase("processing")) {
	                    tasks[i].setStatus("complete");
	                    return tasks[i];
	                }
	            }
	        return null;
	    }
	    public Task[] getPendingTasks(){
	        Task[] subarray = new Task[1];
	        for (int i = 0; i<countTask; i++)
	            if (tasks[i].getStatus().equalsIgnoreCase("incomplete") || tasks[i].getStatus().equalsIgnoreCase("processing")) {
	                subarray[subarray.length - 1] = tasks[i];
	                subarray = Arrays.copyOf(subarray, subarray.length + 1);
	            }
	        return subarray;
	    }
	    public Task[] getTasksOnDate(Date date){
	        Task[] subarray = new Task[1];
	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        String searchDate = formatter.format(date);
	        for (int i = 0; i<countTask; i++) {
	            String dueDate = formatter.format(tasks[i].getDueDate());
	            if (searchDate.equals(dueDate)) {
	                subarray[subarray.length - 1] = tasks[i];
	                subarray = Arrays.copyOf(subarray, subarray.length + 1);
	            }
	        }
	        return subarray;
	    }
	    public Task getTaskByName(String taskName){
	        for (int i = 0; i < countTask; i++){
	            if (taskName.equalsIgnoreCase(tasks[i].getName()))
	                return tasks[i];
	        }
	        System.out.println("task name not found!!");
	        return null;
	    }
	    public void displayTasks(){
	        for(int i = 0; i < countTask; i++)
	            System.out.println(tasks[i]);
	    }
	    public Task[] getOverDueTasks(){
	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        Date today = new Date();
	        Task subtasks[] = new Task[1];
	        for (int i = 0; i<countTask; i++){
	            if(tasks[i].getDueDate().before(today)){
	                subtasks[subtasks.length - 1] = tasks[i];
	                subtasks = Arrays.copyOf(subtasks, subtasks.length + 1);
	            }
	        }
	        return subtasks;
	    }
	}

	    
