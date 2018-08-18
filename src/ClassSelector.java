import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ClassSelector {
	ArrayList<Student> students = new ArrayList<Student>();

	private String userName;
	private String userCurrentModule;
	private int userLevel;
	private int moduleNumber;

	public ClassSelector(String userName, String userCurrentModule) {
		this.userName = userName;
		this.userCurrentModule = userCurrentModule;
		this.userLevel = Integer.parseInt(this.userCurrentModule.substring(5, 6));
		this.moduleNumber = Integer.parseInt(this.userCurrentModule.substring(13, 14));

		initializeSampleData();
	}
	
	public String findClass() {
		// find candidates
		ArrayList<Student> candidates = new ArrayList<Student>();

		for (int i = 0; i < students.size(); i++) {
			int candidateLevel = Integer.parseInt(students.get(i).getLevel());

			if (userLevel == candidateLevel) {
				candidates.add(students.get(i));
			}
		}

		// sort candidates
		StudentModuleComparator comparator = new StudentModuleComparator();
		int userCurrentModuleNumber = Integer
				.parseInt(userCurrentModule.substring(userCurrentModule.length() - 1, userCurrentModule.length()));

		candidates.sort(comparator);

		for (int i = 0; i < candidates.size(); i++) {
			int candidateModuleNumber = Integer
					.parseInt(candidates.get(i).getMostRecentFormattedModule().getName().substring(13));
			if (candidateModuleNumber == moduleNumber) {
				candidates.add(0, candidates.remove(i));
			}
		}
		
		// format results
		String results = "Same Module:\n";

		int pos = 0;

		while (Integer.parseInt(
				candidates.get(pos).getMostRecentFormattedModule().getName().substring(13)) == moduleNumber
				&& pos < candidates.size()) {
			results += "Student: " + candidates.get(pos).getName() + ", Class: "
					+ candidates.get(pos).getClas().getName() + ", Module: "
					+ candidates.get(pos).getMostRecentFormattedModule().getName() + "\n";
			pos++;
		}

		results += "\nBehind:\n";

		while (Integer.parseInt(
				candidates.get(pos).getMostRecentFormattedModule().getName().substring(13)) < moduleNumber
				&& pos < candidates.size()) {
			results += "Student: " + candidates.get(pos).getName() + ", Class: "
					+ candidates.get(pos).getClas().getName() + ", Module: "
					+ candidates.get(pos).getMostRecentFormattedModule().getName() + "\n";
			pos++;
		}

		results += "\nAhead:\n";

		while (Integer.parseInt(
				candidates.get(pos).getMostRecentFormattedModule().getName().substring(13)) < moduleNumber
				&& pos < candidates.size()) {
			results += "Student: " + candidates.get(pos).getName() + ", Class: "
					+ candidates.get(pos).getClas().getName() + ", Module: "
					+ candidates.get(pos).getMostRecentFormattedModule().getName() + "\n";
			pos++;
		}

		return results;
	}

	public void initializeSampleData() {
		ArrayList<Module> student1Commits = new ArrayList<Module>();
		student1Commits.add(new Module("Level2-Module4"));
		student1Commits.add(new Module("blah"));
		student1Commits.add(new Module("Level5-Module3"));

		ArrayList<Module> student2Commits = new ArrayList<Module>();
		student2Commits.add(new Module("Level4-Module4"));
		student2Commits.add(new Module("blah"));
		student2Commits.add(new Module("Level5-Module4"));

		ArrayList<Module> student3Commits = new ArrayList<Module>();
		student3Commits.add(new Module("Level3-Module4"));
		student3Commits.add(new Module("blah"));
		student3Commits.add(new Module("Level1-Module4"));

		ArrayList<Module> student4Commits = new ArrayList<Module>();
		student4Commits.add(new Module("Level2-Module4"));
		student4Commits.add(new Module("blah"));
		student4Commits.add(new Module("Level5-Module7"));

		ArrayList<Module> student5Commits = new ArrayList<Module>();
		student5Commits.add(new Module("Level1-Module4"));
		student5Commits.add(new Module("blah"));
		student5Commits.add(new Module("Level5-Module3"));

		students.add(new Student("Student 1", new Class("5@CV Starfish"), student1Commits));
		students.add(new Student("Student 2", new Class("5@MX Snail"), student2Commits));
		students.add(new Student("Student 3", new Class("3@CV Llama"), student3Commits));
		students.add(new Student("Student 4", new Class("5@CV Starfish"), student4Commits));
		students.add(new Student("Student 5", new Class("5@MX Cow"), student5Commits));
	}
}
