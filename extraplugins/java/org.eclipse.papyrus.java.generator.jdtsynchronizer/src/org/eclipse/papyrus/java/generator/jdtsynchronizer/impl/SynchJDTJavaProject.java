/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Initial API and implementation
 * 	Manuel Giles	 giles.manu@live.fr		 - Initial API and implementation
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Idea of the java generator project & help for the conception 
 *
 *****************************************************************************/

package org.eclipse.papyrus.java.generator.jdtsynchronizer.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.papyrus.java.generator.jdtsynchronizer.GeneratorPreference;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.util.JdtmmPreference;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;

/**
 * Allow to generate Code thanks to a JDT model
 * 
 * @author Deblock Nicolas & Manuel Giles
 * 
 */
public class SynchJDTJavaProject implements JDTVisitor {

	private IJavaModel ijm;

	private IWorkspaceRoot iroot;

	private GeneratorPreference preference;

	/**
	 * Constructor
	 * 
	 * @param modelJDT
	 *        the model JDT to generate
	 */
	public SynchJDTJavaProject(IJavaModel ijm, IWorkspaceRoot iroot, GeneratorPreference preference) {
		this.ijm = ijm;
		this.iroot = iroot;
		this.preference = preference;
	}


	public void visit(JDTJavaElement element) throws JDTVisitorException {
		// if element can't be generated, we stop all
		if(!element.isGenerated())
			return;

		if(!(element instanceof JDTJavaProject))
			return;
		// cast element to JDTJavaProject
		JDTJavaProject project = (JDTJavaProject)element;

		// set the multi-value for the metamodel
		JdtmmPreference.setClassMultiValue(preference.genericClassForMultiValue().substring(preference.genericClassForMultiValue().lastIndexOf(".") + 1));


		// search IJavaProject				
		//IProject projet =  iroot.getProject(project.getElementName());
		IJavaProject ijavaProjet = ijm.getJavaProject(project.getElementName());

		// if ijavaProjet don't exist, create this!
		if(!ijavaProjet.exists()) {
			//			System.out.println("create the project " + project.getElementName());
			IProject proj = iroot.getProject(project.getElementName());

			try {
				proj.create(null);
				proj.open(null);

				// Specifies type of project
				IProjectDescription description = proj.getDescription();
				description.setNatureIds(new String[]{ JavaCore.NATURE_ID });
				proj.setDescription(description, null);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ijavaProjet = JavaCore.create(proj);
		}

		// include the default JRE library if don't exist		
		List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
		IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
		boolean creerJRE = true;


		try {
			// take libs to project class path
			for(IClasspathEntry elem : ijavaProjet.getRawClasspath()) {
				if(elem.getPath().toString().contains(JavaRuntime.JRE_CONTAINER))
					creerJRE = false;
				entries.add(elem);
			}
			// if jre don't exist, we add it to classpath
			if(creerJRE) {
				entries.add(JavaCore.newContainerEntry(JavaRuntime.newJREContainerPath(vmInstall)));
				ijavaProjet.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
			throw new JDTVisitorException(e.getMessage(), e.getCause());
		}



		// browse all PackageFragmentRoot and call the visit
		JDTVisitor visitor = new SynchJDTPackageFragmentRoot(ijavaProjet, preference);
		for(JDTPackageFragmentRoot root : project.getPackageFragmentRoots()) {
			root.accept(visitor);
		}
	}
}
