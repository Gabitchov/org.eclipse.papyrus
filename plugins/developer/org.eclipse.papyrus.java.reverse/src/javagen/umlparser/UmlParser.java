/**
 * 
 */
package javagen.umlparser;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author dumoulin
 *
 */
public class UmlParser {
 
	/**
	 * The visitor used to collect model.
	 */
	protected CompilationUnitAnalyser visitor;
	
	public UmlParser() {
	}
	
	/**
	 * Select the appropriate parsing method according to the file type.
	 * @param file
	 * @throws ParseException
	 * @throws IOException
	 */
	public void parseResource(File file) throws ParseException, IOException {
		if(file.isDirectory())
		{
			System.out.println( "  '" + file.getAbsolutePath() + " is a directory");
			parsePackage(file);
		}
		else if(file.isFile())
		{
			System.out.println( "  '" + file.getAbsolutePath() + " is a file");
			// Parse only file ending in .java
			if(file.getName().endsWith(".java"))
			  parseFile(file);
			else
				System.out.println("skip non java file '" + file.getAbsolutePath() + "'");
		}
		else
		{
			System.out.println( "  '" + file.getAbsolutePath() + " can't be identified - " + file);	
		}
	}
	
	/**
	 * Explore the package to call parse on classes
	 * @param file
	 * @throws ParseException
	 * @throws IOException
	 */
	public void parsePackage(File file) throws ParseException, IOException {
		for(File f : file.listFiles() )
		{
			parseResource(f);
		}
	}
	
	/**
	 * Parse the specified file
	 * @param filename
	 * @throws IOException 
	 * @throws ParseException 
	 */
	protected void parseFile(File file) throws ParseException, IOException
	{
		CompilationUnit cu = JavaParser.parse(file);
        // prints the resulting compilation unit to default system output
//        System.out.println(cu.toString());
        
//        visitor.visit(cu, null);
		
		visitor.processCompilationUnit(cu);
	}
	
	/**
	 * Select the appropriate parse method according to the type of the 
	 * resource denoted by the name.
	 * @param resourceName
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public void parseResource( String resourceName) throws ParseException, IOException
	{
		File file = new File(resourceName);
		parseResource(file);
	}
	
    public void execute(String resourcePath, String outputModelName) throws ParseException, IOException
    {
        System.out.println("resource=" + resourcePath);
        // Load model
        ModelManager modelManager = new ModelManager();
        modelManager.createModel(outputModelName);
//      modelManager.getModel().load(null);
        // Create visitor
        visitor = new CompilationUnitAnalyser(modelManager.getModel());
        // parse all file using the visitor
        parseResource(resourcePath);
        
        // Save the model
        modelManager.save();

    }
    
    public void executeTest(String resourcePath, String outputModelName) throws ParseException, IOException
    {
        System.out.println("resource=" + resourcePath);
        // Load model
        ModelManager modelManager = new ModelManager();
        modelManager.createModel(outputModelName);
//      modelManager.getModel().load(null);
        // Create visitor
        String javaccDir = "H:/temp/papyrus/papyrus-gmf-head2/org.eclipse.papyrus.java.reverse/src/japa/parser";
        String javagenDir = "H:/temp/papyrus/papyrus-gmf-head2/org.eclipse.papyrus.java.reverse/src/javagen/umlparser";;
        
        String[] paths = {
                "javagen",
                "javacc",
        };
        visitor = new CompilationUnitAnalyser(modelManager.getModel(), "javacc", null);
        // parse all file using the visitor
        parseResource(javaccDir);
        
        // Second parsing with same model
        visitor = new CompilationUnitAnalyser(modelManager.getModel(), "javagen", Arrays.asList(paths));
        // parse all file using the visitor
        parseResource(javagenDir);
        
        // Save the model
        modelManager.save();

    }
    
	  public static void main(String args[]) {
	        
	        if (args.length == 1) {
		    	try {
					UmlParser p = new UmlParser();
                    p.execute(args[0], "myfile.uml");
//                    p.executeTest(args[0], "myfile.uml");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					System.out.println("Problems encountered during parsing.");
					e.printStackTrace();
				}
		    	
		    } else {
		      System.out.println("Please select a file or directory to parse");
		      return;
		    }


		  }


}