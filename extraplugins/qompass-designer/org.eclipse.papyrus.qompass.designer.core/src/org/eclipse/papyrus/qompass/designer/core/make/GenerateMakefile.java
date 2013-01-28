package org.eclipse.papyrus.qompass.designer.core.make;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.papyrus.qompass.designer.core.Log;

/*
 * TODO:
 *  - Currently not used (and unclear, if useful)
 * 
 * 	- Determination of root folder
 * 	- files within fileList have relative folder names? (if not assure)
 *  - supporting def file (not only for Accord)
 *  - integration with execution
 */

/**
 * Generate a makefile based on found source files, i.e. .cpp files
 * 
 * @author manel
 * 
 */
@Deprecated
public class GenerateMakefile {

	/**
	 * Makefile Generation Algorithm:
	 * For each Node
	 * include $(ROOT_PATH)/Makefile.defs
	 * NAME = Util
	 * SRCS =\
	 * File1.cpp\
	 * File2.cpp\
	 * ...
	 * FileN.cpp
	 * include $(ROOT_PATH)/Makefile.rules
	 */
	public static void generate() {
		ArrayList<String> fileList = new ArrayList<String>();
		ArrayList<String> folderList = new ArrayList<String>();
		ArrayList<String> nodeList = new ArrayList<String>();
		ArrayList<String> nodeSources = new ArrayList<String>();

		ShowFiles showFiles = new ShowFiles("/local/home/ansgar/workspace-v3.3/TestCppProject/AluSocketGen");

		showFiles.getFilesRec(fileList, folderList);
		nodeList = showFiles.findNodesDir(folderList);
		for(String node : nodeList) {
			nodeSources = showFiles.getNodeSources(fileList, node);
			String nodePath = showFiles.getRootPath() + "/" + node + "/Makefile";
			createFileList(nodePath, nodeSources, node);
		}
	}

	/**
	 * Create a list of .cpp files
	 * 
	 * @param fileName
	 * @param cppFileList
	 * @param NodeName
	 */
	public static void createFileList(String fileName, ArrayList<String> cppFileList, String NodeName) {
		// create the makefile
		try {
			java.io.File makefile = new java.io.File(fileName);

			makefile.createNewFile();
			// not avail in Java 1.5?
			// makefile.setWritable(true); 

			FileOutputStream writer = new java.io.FileOutputStream(makefile);

			writer.write("include $(ACCORD_ROOT)/Makefile.defs\n\n".getBytes());
			writer.write(("NAME=" + NodeName + "\n\n").getBytes());

			// Calculate list of sources
			writer.write("SRCS=\\\n".getBytes());

			if(cppFileList != null && cppFileList.size() != 0) {

				// Calculate list of .cpp files
				for(int i = 0; i < cppFileList.size(); i++) {
					writer.write(("\t" + cppFileList.get(i)).getBytes());
					if(i < cppFileList.size() - 1) {
						// add \ to all but last item
						writer.write("\\".getBytes());
					}
					writer.write("\n".getBytes());
				}
			}
			writer.write("\n".getBytes());

			writer.write("include $(ACCORD_ROOT)/Makefile.rules".getBytes());

			writer.flush();
			writer.close();
		} catch (IOException e) {
			Log.log(Log.ERROR_MSG, Log.UTILS, "error during writing of makefile: " + e.getMessage());
		}
	}
}
