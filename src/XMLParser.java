import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class XMLParser {

	File file;
	String xml;
	ArrayList<String> fields = new ArrayList<String>();
	//int indexTextParse = 1;
	
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
	
	// Deletes the chain text in the global XML
	public void deleteInXML(String text) {
		xml = xml.substring(0, xml.indexOf(text)) + xml.substring(xml.indexOf(text)+text.length(),xml.length());
	}
	
	public void parse(String parent, String part) {
		String finalLine = "</";
		
		if (part.indexOf("<") == -1) {
			String chainToDelete = "<"+parent+">"+ part + "</"+parent+">";
			deleteInXML(chainToDelete);
			return;
		}
		
			int initNameClass = 1+part.indexOf('<');
			int endNameClass = part.indexOf('>');
			String classParsed = part.substring(initNameClass,endNameClass);
			
			int initValueClass = 1 + endNameClass;
			int endValueClass = part.indexOf("</" + classParsed + ">");
			String inside = part.substring(initValueClass,endValueClass);
			if (!fields.contains(classParsed)) {
				fields.add(classParsed);
				System.out.println("Class: " + classParsed);
				System.out.println("Inside: " + inside);
				System.out.println("Parent: " + parent);
				System.out.println();
			}
			parent = classParsed;
			parse(parent,inside);
		
	}
	
	public void spacesAndEntersOut() {
		
		String prov = "" + xml.charAt(0);
		
		// Out spaces
		for (int i = 1; i < xml.length(); i++) {
			if ((prov.charAt(prov.length()-1) == '\n') && (xml.charAt(i) == ' ')) {
			} else {
				prov += xml.charAt(i);
			}
		}
		
		xml = prov;
		prov = "" + xml.charAt(0);
		
		// Out enters. COMBINE IN THE SAME LOOP!!!
		for (int i = 1; i < xml.length(); i++) {
			if (xml.charAt(i) == '\n') {
			} else {
				prov += xml.charAt(i);
			}
		}
		xml = prov;
	}
	
	// run
	public void go() {
		xml = readFile();
		spacesAndEntersOut();
		System.out.println(xml);
		while(xml.length() > 0) {
			parse("",xml);
		}
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
