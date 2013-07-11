/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eclipse.project.editors.interfaces;

/**
 * 
 * Editor for the java project
 * 
 */
public interface IJavaProjectEditor extends IBuildEditor {

	/** The java nature */
	public static final String JAVA_NATURE = "org.eclipse.jdt.core.javanature"; //$NON-NLS-1$

	/** the build command for the java project */
	public static final String JAVA_BUILD_COMMAND = "org.eclipse.jdt.core.javabuilder"; //$NON-NLS-1$
	/**
	 * Add a new java source folder in the .classpath and in the build.properties
	 * 
	 * @param path
	 *        the path of the java source folder
	 */
	public void addJavaSourceFolder(final String path);
	/**
	 * Gets the classpath editor.
	 *
	 * @return the classpath editor
	 */
	public IClasspathEditor getClasspathEditor();

	
	/**
	 * Gets the builds the editor.
	 *
	 * @return the builds the editor
	 */
	public IBuildEditor getBuildEditor();

}
