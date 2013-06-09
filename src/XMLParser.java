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
	public String deleteInXML(String completeText , String chain) {
		completeText = completeText.substring(0, completeText.indexOf(chain)) +
					completeText.substring(completeText.indexOf(chain)+chain.length(),completeText.length());
		return completeText;
	}
	
	public void parse(String parent, String part) {
		
//		if (part.indexOf("<") == -1) {
//			return;
//		}
		while(part.length() > 0 && xml.contains(part)) {
			int initNameClass = 1+part.indexOf('<');
			int endNameClass = part.indexOf('>');
			String classParsed = part.substring(initNameClass,endNameClass);
			String classId = "";
			if (classParsed.contains(" ")) {
				String[] classPlusId = classParsed.split(" ");
				classParsed = classPlusId[0];
				classId = classPlusId[1];
			}
			
			int initValueClass = 1 + endNameClass;
			int endValueClass = part.indexOf("</" + classParsed + ">");
			String inside = part.substring(initValueClass,endValueClass);
			//if (!fields.contains(classParsed)) {
				//fields.add(classParsed);
				System.out.println("Class: " + classParsed);
				System.out.println("Inside: " + inside);
				System.out.println("Parent: " + parent);
				System.out.println();
			//}
			if (inside.contains("<")) {
				parent = classParsed;
				parse(parent,inside);
			} else {
				String chainToDelete = "<"+classParsed+">"+ inside + "</"+classParsed+">";
				part = deleteInXML(part,chainToDelete);
				xml = deleteInXML(xml,chainToDelete);
				if (part.equals("")) {
					String chainEnd = "<" + parent + ">" + "</" + parent + ">"; 
					if (xml.contains(chainEnd)) xml = deleteInXML(xml,chainEnd); // End part
					return;
				}
			}
			parse(parent,part);
		}
		
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
			if (xml.charAt(i) == '\n' || xml.charAt(i) == '\t') {
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
		XMLParser parser = new XMLParser("settings5.xml");
		parser.go();
	}

}
