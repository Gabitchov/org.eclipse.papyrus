/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.make;

import java.io.File;
import java.util.ArrayList;

@Deprecated
public class ShowFiles {

	/**
	 * Initialize the ShowFiles class
	 * 
	 * @param rootPath
	 *        the path of a folder, that in turn contains a set of folders. It is assume that the
	 *        latter contain code related to a specific node
	 */
	public ShowFiles(String rootPath) {
		m_rootPath = rootPath;
	}

	private String m_rootPath;

	public String getRootPath() {
		return m_rootPath;
	}

	/**
	 * takes as input the list of all directories that are included under a root path (allDir), and
	 * the root path (in case different from ACCORD_ROOT), and potentially, a list of (non empty) files,
	 * which will be enriched with the set of source files (.cpp) under all directories under the root path
	 */
	public void getFilesRec(ArrayList<String> allFiles, ArrayList<String> allDir) {
		getFilesRec(allFiles, allDir, m_rootPath);
	}


	public void getFilesRec(ArrayList<String> fileList, ArrayList<String> folderList, String root) {
		File f = new File(root);
		File[] listFiles = f.listFiles();
		for(File file : listFiles) {
			if(file.isDirectory()) {
				// call recursively with 
				getFilesRec(fileList, folderList, file.toString());
				folderList.add(file.toString());
			} else {
				if(file.toString().endsWith(".cpp")) { //$NON-NLS-1$
					// found a C++ file
					fileList.add(file.toString());
				}
			}
		}
	}

	/**
	 * takes as input the list of all directories that are included under a root path (folderList),
	 * in order to provide as a result the subset of directories, corresponding to the nodes
	 */
	public ArrayList<String> findNodesDir(ArrayList<String> folderList) {
		ArrayList<String> allNodes = new ArrayList<String>();
		for(String dir : folderList) {
			String tmp = dir.replaceFirst(m_rootPath, ""); //$NON-NLS-1$
			// all the nodes are at the level (ACCORD_ROOT + 1)
			tmp = tmp.trim().replaceFirst(File.pathSeparator, ""); //$NON-NLS-1$
			if(!tmp.contains(File.pathSeparator)) {
				allNodes.add(tmp.trim());
			}
		}
		return allNodes;
	}

	/**
	 * takes as input the list of all files that are included under ACCORD_ROOT path (allFiles), and
	 * the node name (nodeName) in order to provide as a result the subset of files, corresponding to the
	 * sources of the node (NodeName)
	 */
	public ArrayList<String> getNodeSources(ArrayList<String> allFiles, String nodeName) {
		ArrayList<String> sourceFilesPath = new ArrayList<String>();

		for(String filePath : allFiles) {
			if(filePath.contains(nodeName)) {
				// path is related to given node 
				int index = filePath.indexOf(nodeName);
				String tmp = filePath.substring(index);
				index = tmp.indexOf(File.pathSeparator);
				tmp = tmp.substring(index + 1);
				sourceFilesPath.add(tmp.trim());
			}
		}
		return sourceFilesPath;
	}
}
