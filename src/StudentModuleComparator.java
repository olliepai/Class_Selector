import java.util.Comparator;

public class StudentModuleComparator implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub

		String o1ModuleNumber = "100";
		String o2ModuleNumber = "100";

		if (o1.getMostRecentFormattedModule() != null) {
			o1ModuleNumber = o1.getMostRecentFormattedModule().getName().substring(13);
		}

		if (o2.getMostRecentFormattedModule() != null) {
			o2ModuleNumber = o2.getMostRecentFormattedModule().getName().substring(13);
		}

		return o1ModuleNumber.compareTo(o2ModuleNumber);
	}
}
