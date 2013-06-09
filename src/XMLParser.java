import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class XMLParser {

	File file;
	
	XMLParser(String myFile) {
		file = new File(myFile);
	}
	
	XMLParser() {
		file = new File("settings.xml");
	}
	
	public String readFile() {
		String xml = null;
		String line = null;
		try  {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			xml = reader.readLine();
			while ((line = reader.readLine()) != null) {
				xml = xml + "\n" + line;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return xml;
	}
	
	
	// run
	public void go() {
		String xml = readFile();
		System.out.println(xml);
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

		XMLParser parser = new XMLParser("settings2.xml");
		parser.go();
	}

}
