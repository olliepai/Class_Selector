import java.util.Comparator;

public class StudentModuleComparator implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		
		String o1ModuleNumber = o1.getMostRecentFormattedModule().getName().substring(5, 6);
		String o2ModuleNumber = o2.getMostRecentFormattedModule().getName().substring(5, 6);
		
		return o1ModuleNumber.compareTo(o2ModuleNumber);
	}

}
