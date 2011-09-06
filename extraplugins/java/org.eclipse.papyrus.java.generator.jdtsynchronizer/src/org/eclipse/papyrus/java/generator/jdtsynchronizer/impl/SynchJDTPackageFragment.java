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

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.papyrus.java.generator.jdtsynchronizer.GeneratorPreference;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTPackageFragment;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;


/**
 * allow to generate package fragment
 * 
 * @author Deblock Nicolas & Manuel Giles
 * 
 */
public class SynchJDTPackageFragment extends EObjectImpl implements JDTVisitor {

	public IPackageFragmentRoot iroot;

	private GeneratorPreference preference;

	/**
	 * Constructor
	 * 
	 * @param iroot
	 *        the IPackageFragmentRoot parent
	 */
	public SynchJDTPackageFragment(IPackageFragmentRoot iroot, GeneratorPreference preference) {
		super();
		this.iroot = iroot;
		this.preference = preference;
	}


	public void visit(JDTJavaElement element) throws JDTVisitorException {
		// if element can't be generated, we stop all
		if(!element.isGenerated())
			return;
		if(!preference.isPackageToGenerate(element.getElementName()))
			return;

		JDTPackageFragment packag = (JDTPackageFragment)element;

		try {
			// search the package
			IJavaElement tmp = null;
			IPackageFragment ipack = null;


			if((tmp = SynchTools.searchIJavaElement(iroot.getChildren(), packag.getElementName())) != null &&
					tmp instanceof IPackageFragment)
				ipack = (IPackageFragment)tmp;

			// if name=null, it's the default package
			if(packag.getQualifiedName() == null) {
				// generate Compilation unit without package
				IJavaElement defaultPackageElement = SynchTools.searchIJavaElement(iroot.getChildren(), IPackageFragment.DEFAULT_PACKAGE_NAME);
				if(defaultPackageElement != null)
					ipack = (IPackageFragment)defaultPackageElement;
			}

			// if the package don't exist, we create it!
			if(ipack == null) {

				// find the name of the package
				ipack = iroot.createPackageFragment(packag.getQualifiedName(), true, null);

			}

			// call the children compilationUnit
			JDTVisitor visitor = new SynchJDTCompilationUnit(ipack, preference);
			for(JDTCompilationUnit cu : packag.getCompilationUnits())
				cu.accept(visitor);

		} catch (JavaModelException e) {
			e.printStackTrace();
			throw new JDTVisitorException(e.getMessage(), e.getCause());
		} catch (Exception e) {
			e.printStackTrace();
			throw new JDTVisitorException(e.getMessage(), e.getCause());
		}
	}

}
