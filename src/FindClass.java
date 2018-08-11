import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FindClass {
	ArrayList<Student> students = new ArrayList<Student>();

	private String userName;
	private String userCurrentModule;
	private int userLevel;

	public FindClass(String userName, String userCurrentModule) {
		this.userName = userName;
		this.userCurrentModule = userCurrentModule;
		this.userLevel = Integer.parseInt(this.userCurrentModule.substring(5, 6));

		initializeSampleData();
	}

	public ArrayList<Student> getCandidates() {
		ArrayList<Student> candidates = new ArrayList<Student>();

		for (int i = 0; i < students.size(); i++) {
			int candidateLevel = Integer.parseInt(students.get(i).getLevel());

			if (userLevel == candidateLevel) {
				candidates.add(students.get(i));
			}
		}
	
		return candidates;
	}
	
	public ArrayList<Student> sortCandidates() {
		ArrayList<Student> sortedCandidates = new ArrayList<Student>();
		StudentModuleComparator comparator = new StudentModuleComparator();
		int userCurrentModuleNumber = Integer.parseInt(userCurrentModule.substring(userCurrentModule.length() - 1, userCurrentModule.length()));
		
		sortedCandidates.sort(comparator);
		
		return sortedCandidates;
	}
	
	public void initializeSampleData() {
		ArrayList<Module> student1Commits = new ArrayList<Module>();
		student1Commits.add(new Module("Level2-Module4"));
		student1Commits.add(new Module("blah"));
		student1Commits.add(new Module("Level5-Module3"));

		ArrayList<Module> student2Commits = new ArrayList<Module>();
		student1Commits.add(new Module("Level4-Module4"));
		student1Commits.add(new Module("blah"));
		student1Commits.add(new Module("Level5-Module3"));

		ArrayList<Module> student3Commits = new ArrayList<Module>();
		student1Commits.add(new Module("Level3-Module4"));
		student1Commits.add(new Module("blah"));
		student1Commits.add(new Module("Level1-Module3"));

		ArrayList<Module> student4Commits = new ArrayList<Module>();
		student1Commits.add(new Module("Level2-Module4"));
		student1Commits.add(new Module("blah"));
		student1Commits.add(new Module("Level5-Module3"));

		ArrayList<Module> student5Commits = new ArrayList<Module>();
		student1Commits.add(new Module("Level1-Module4"));
		student1Commits.add(new Module("blah"));
		student1Commits.add(new Module("Level5-Module3"));

		students.add(new Student("Student 1", new Class("5@CV Starfish"), student1Commits));
		students.add(new Student("Student 2", new Class("5@MX Snail"), student2Commits));
		students.add(new Student("Student 3", new Class("3@CV Llama"), student3Commits));
		students.add(new Student("Student 4", new Class("5@CV Starfish"), student4Commits));
		students.add(new Student("Student 5", new Class("5@MX Cow"), student5Commits));
	}
}
