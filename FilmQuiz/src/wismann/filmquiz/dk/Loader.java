package wismann.filmquiz.dk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loader {
	
	public static void Load() throws FileNotFoundException {
		
		BufferedReader br = new BufferedReader(new FileReader("svar.txt"));
		try {
			String line = null;
			while (( line = br.readLine() ) != null) {
				String[] splitString = line.split(";");
				String question = splitString[0];
				String answer = splitString[1];
				ArrayList<String> options = new ArrayList<String>();
				options.add(splitString[2]);
				options.add(splitString[3]);
				options.add(splitString[4]);
				String categoryString = splitString[5];
				Category category = null;
				
				switch (categoryString) {
				case "Navne":
					category = Category.NAVNE;
					break;
				case "Steder":
					category = Category.STEDER;
					break;
				default:
					break;
				}				
				
				Question q = new Question(question, answer, options, category);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
