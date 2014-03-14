/**
 * @author: Manel Fredj - CEA
 * This class enables to change the namespace of di2 metamodel from
 * replace  http://www.papyrusuml.org into http://www.papyrusuml.org/di2
 */

package org.eclipse.papyrus.conversion.di2todi.popupactions;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class PapyrusNamespace
{
	/////////////////////////////////////////////////////////////////////////////////////////////
	//replace  http://www.papyrusuml.org -- by -- http://www.papyrusuml.org/di2
	
	public static void replaceNamespace(String absolutepath)
	{
		try {
			String oldNameSpace = "di2=\"http://www.papyrusuml.org\""; 
			String newNameSpace="di2=\"http://www.papyrusuml.org/di2\"";
			String  oldtext =readFileAsString(absolutepath);
			// replace the namespace in the di2 file
			String newtext = oldtext.replaceAll (oldNameSpace, newNameSpace);
	            
			FileWriter writer = new FileWriter(absolutepath);
			writer.write(newtext);writer.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static void restoreDi2Namespace(String absolutepath)
	{
		try {
			String oldNameSpace="di2=\"http://www.papyrusuml.org/di2\"";
			String newNameSpace = "di2=\"http://www.papyrusuml.org\""; 
			
			String  oldtext =readFileAsString(absolutepath);
			// replace the namespace in the di2 file
			String newtext = oldtext.replaceAll (oldNameSpace, newNameSpace);
	            
			FileWriter writer = new FileWriter(absolutepath);
			writer.write(newtext);writer.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
    /**
     * @param filePath the name of the file to open. Not sure if it can accept 
     *    cccURLs or just filenames. Path handling could be better, and buffer
     *    sizes are hardcoded
     */ 
	private static String readFileAsString (String filePath)
		throws java.io.IOException
	{
		byte[] buffer = new byte[(int) new File(filePath).length()];
		BufferedInputStream f = null;
		try {
			f = new BufferedInputStream(new FileInputStream(filePath));
			f.read(buffer);
		}
		finally {
			if (f != null) {
				try {
					f.close();
				}
				catch (IOException ignored) {
				}
			}
		}
		return new String(buffer);
	}
}
