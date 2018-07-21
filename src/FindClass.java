import java.util.ArrayList;

public class FindClass {
	ArrayList<String> classes = new ArrayList<String>();
	ArrayList<String> modules = new ArrayList<String>();
	
	public static void main(String[] args) {
		
	}
	
	public FindClass() {
		for (int i = 0; i < 4; i++) {
			classes.add(i + "@CV Starfish");
			classes.add(i + "@MX Llama");
			
			for (int j = 1; j < 5; j++) {
				modules.add("Level" + i + "-Module" + j);
			}
		}
	}
	
	
	
	String module = JOptionPane.showInputDialog(null, "Enter a module");
	
}

