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

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.papyrus.java.generator.jdtsynchronizer.GeneratorPreference;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragmentRoot;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;


/**
 * allow to generate package fragment root
 * 
 * @author Deblock Nicolas & Manuel Giles
 * 
 */
public class SynchJDTPackageFragmentRoot implements JDTVisitor {

	private IJavaProject iprojet;

	private GeneratorPreference preference;

	/**
	 * Constructor
	 * 
	 * @param iprojet
	 *        the project parent
	 */
	public SynchJDTPackageFragmentRoot(IJavaProject iprojet, GeneratorPreference preference) {
		super();
		this.iprojet = iprojet;
		this.preference = preference;
	}



	public void visit(JDTJavaElement element) throws JDTVisitorException {
		// if element can't be generated, we stop all
		if(!element.isGenerated())
			return;

		JDTPackageFragmentRoot root = (JDTPackageFragmentRoot)element;

		try {
			// research JDTPackageFragmentRoot		
			IPackageFragmentRoot iroot = SynchTools.searchIJavaElement(iprojet.getAllPackageFragmentRoots(), root.getElementName());

			// if IPackageFragmentRoot don't exist, we create this
			if(iroot == null) {
				// create the folder
				IFolder sourceFolder = iprojet.getProject().getFolder(root.getElementName());
				try {
					sourceFolder.create(false, true, null);
				} catch (CoreException e) {
					// folder already exist
				}

				iroot = iprojet.getPackageFragmentRoot(sourceFolder);
				IClasspathEntry[] oldEntries = iprojet.getRawClasspath();
				List<IClasspathEntry> newEntries = new ArrayList<IClasspathEntry>();

				// copy the old entries in new entries
				for(int i = 0; i < oldEntries.length; i++) {
					// don't take the /projectName, else an exception are throw
					if(oldEntries[i] != null && !oldEntries[i].getPath().toString().equals("/" + iprojet.getElementName()))
						newEntries.add(oldEntries[i]);
				}

				// add the new packageFragmentRoot
				newEntries.add(JavaCore.newSourceEntry(iroot.getPath()));

				IClasspathEntry[] newEntriesArray = new IClasspathEntry[newEntries.size()];
				newEntries.toArray(newEntriesArray);

				iprojet.setRawClasspath(newEntriesArray, null);

			}

			// call children
			JDTVisitor visitPackageFragment = new SynchJDTPackageFragment(iroot, preference);
			for(JDTPackageFragment ipack : root.getPackageFragments()) {
				ipack.accept(visitPackageFragment);
			}

		} catch (JavaModelException e) {
			e.printStackTrace();
			throw new JDTVisitorException(e.getMessage(), e.getCause());
		}
	}
}
