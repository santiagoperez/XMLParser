import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class XMLParser {

	File file;
	String xml;
	
	XMLParser(String myFile) {
		file = new File(myFile);
	}
	
	XMLParser() {
		file = new File("settings.xml");
	}
	
	public String readFile() {
		xml = null;
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
	
	public void parse(String part) {
		String finalLine = "</";
		
		int initNameClass = 1 + part.indexOf('<');
		if (initNameClass == 0) return;
		int endNameClass = part.indexOf('>');
		String classParsed = part.substring(initNameClass,endNameClass);
		
		int initValueClass = 1 + endNameClass;
		int endValueClass = part.indexOf("</" + classParsed + ">");
		String inside = part.substring(initValueClass,endValueClass);
		
		System.out.println("Class: " + classParsed);
		System.out.println("Inside: " + inside);
		parse(inside);
		
	}
	
	public void spacesOut() {
		
		String prov = "" + xml.charAt(0);
		for (int i = 1; i < xml.length(); i++) {
			if ((prov.charAt(prov.length()-1) == '\n') && (xml.charAt(i) == ' ')) {
			} else {
				prov += xml.charAt(i);
			}
			
		}
		xml = prov;
		
	}
	
	// run
	public void go() {
		xml = readFile();
		spacesOut();
		System.out.println(xml);
		parse(xml);
		/*
		 * spaces out
		 * 
		 * parent root, 
		 * Start from 1, . get what is inside <x>. 
		 * Look for </x>. Create a string with this part. Create a class name x, parent root.
		 */
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

		XMLParser parser = new XMLParser("settings.xml");
		parser.go();
	}

}
