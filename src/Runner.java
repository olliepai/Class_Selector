import javax.swing.JOptionPane;

public class Runner {
	public static void main(String[] args) {
		String userName = JOptionPane.showInputDialog(null, "Enter a student's name");
		String userCurrentModule = JOptionPane.showInputDialog(null, "Enter the module they're currently on");
		
		FindClass finder = new FindClass(userName, userCurrentModule);
	}
}
