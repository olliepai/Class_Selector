import java.util.ArrayList;

public class Student {
	private String name;
	private Class currentClass;
	ArrayList<Module> commits;
	
	public Student(String name, Class currentClass, ArrayList<Module> commits) {
		this.name = name;
		this.currentClass = currentClass;
		this.commits = commits;
	}
	
	public String getName() {
		return name;
	}
	
	public Class getClas() {
		return currentClass;
	}
	
	public String getLevel() {
		return currentClass.getName().substring(0,  1);
	}
	
	public ArrayList<Module> getModules() {
		return commits;
	}
	
	public Module getMostRecentFormattedModule() {
		for (int i = commits.size() - 1; i >= 0 ; i--) {
			if (commits.get(i).getName().matches("Level[0-9]-Module[0-9]")) {
				return commits.get(i);
			}
		}
		return null;
	}
}
