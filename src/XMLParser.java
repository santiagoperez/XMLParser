import java.io.File;


public class XMLParser {

	File file;
	
	XMLParser(File myFile) {
		file = myFile;
	}
	
	XMLParser() {
		file = new File("settings.xml");
	}
	
	// run
	public void go() {
		//open file
		//start parsing
			//read line, if <> new class (have to use split maybe)
			//assign values
			// if </> go out from class
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XMLParser parser = new XMLParser();
		parser.go();
	}

}
