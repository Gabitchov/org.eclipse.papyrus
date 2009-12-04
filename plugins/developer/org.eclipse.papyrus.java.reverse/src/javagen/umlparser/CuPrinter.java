/**
 * 
 */
package javagen.umlparser;

import japa.parser.ParseException;
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;

import java.io.FileInputStream;

/**
 * @author dumoulin
 * 
 */
public class CuPrinter {

	public static void main(String args[]) {
		CompilationUnit cu;

		try {

			if(args.length == 0) {
				System.out.println("Java Parser Version 1.1:  Reading from standard input . . .");
				cu = JavaParser.parse(System.in);
			} else if(args.length == 1) {
				System.out.println("Java Parser Version 1.1:  Reading from file " + args[0] + " . . .");
				try {
					cu = JavaParser.parse(new java.io.FileInputStream(args[0]));
					System.out.println("Java Parser Version 1.1:  Java program parsed successfully.");
					// prints the resulting compilation unit to default system output
					System.out.println(cu.toString());

				} catch (java.io.FileNotFoundException e) {
					System.out.println("Java Parser Version 1.1:  File " + args[0] + " not found.");
					return;
				}
			} else {
				System.out.println("Java Parser Version 1.1:  Usage is one of:");
				System.out.println("         java JavaParser < inputfile");
				System.out.println("OR");
				System.out.println("         java JavaParser inputfile");
				return;
			}

		} catch (ParseException e) {
			System.out.println(e.getMessage());
			System.out.println("Java Parser Version 1.1:  Encountered errors during parse.");
		} finally {
			//	            in.close();
		}

	}


	public static void main2(String[] args) throws Exception {
		// creates an input stream for the file to be parsed
		FileInputStream in = new FileInputStream("test.java");

		CompilationUnit cu;
		try {
			// parse the file
			cu = JavaParser.parse(in);
		} finally {
			in.close();
		}

		// prints the resulting compilation unit to default system output
		System.out.println(cu.toString());
	}

}
