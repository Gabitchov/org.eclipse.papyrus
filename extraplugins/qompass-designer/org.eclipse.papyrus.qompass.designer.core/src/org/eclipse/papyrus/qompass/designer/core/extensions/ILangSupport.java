/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.extensions;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.PackageableElement;

import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;

/**
 * Interface used by Qompass extensions that support a specific programming language
 */
public interface ILangSupport {

	/**
	 * Create a project for a specific language and configure it (according to gathered configuration
	 * data before). In case of C/C++ for instance, a CDT project should be created, in case of Java,
	 * a JDT project.
	 * And implementation should call setProject and setSettings before returning the project
	 * 
	 * @param projectName
	 *        the named of the project
	 * @param node
	 *        the node for which the project should be created
	 * @return the created project
	 */
	public IProject createProject(String projectName, InstanceSpecification node) throws TransformationException;

	/**
	 * Set project information
	 * 
	 * @param project
	 *        the project (must already been initialized)
	 */
	public void setProject(IProject project);

	/**
	 * Re-create the project settings from model information
	 * 
	 * @param node
	 *        node for which settings should be set
	 * @throws TransformationException
	 */
	public void setSettings(InstanceSpecification node) throws TransformationException;

	/**
	 * Generate code for a specific language
	 * 
	 * @param monitor
	 *        a progress monitor
	 * @param element
	 *        a packageable element, typically a classifier or a package
	 * 
	 * @throws TransformationException
	 */
	public void generateCode(IProgressMonitor monitor, PackageableElement element)
		throws TransformationException;


	/**
	 * Clean the code for a certain element, i.e. remove code that has previously generated for this element
	 * This code is required for differential code generation which needs to remove elements for instance
	 * after they have been renamed.
	 * 
	 * @param project
	 *        project in which code should be generated
	 * @param element
	 *        the element for which the generate code should be removed
	 * @throws TransformationException
	 */
	public void cleanCode(IProgressMonitor monitor, PackageableElement element)
		throws TransformationException;

	/**
	 * Reset gathered configuration data
	 * 
	 * @see gatherConfigData
	 */
	public void resetConfigurationData();


	/**
	 * Gather configuration data from implementations, e.g. required include paths or libraries
	 * 
	 * @param implementation
	 *        a class copied to the target
	 */
	public void gatherConfigData(Class implementation);
}
