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
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.papyrus.java.generator.jdtsynchronizer.GeneratorPreference;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTCompilationUnit;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTType;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;

/**
 * Allow to generate compilation Unit
 * 
 * @author Deblock Nicolas & Manuel Giles
 * 
 */
public class SynchJDTCompilationUnit extends EObjectImpl implements JDTVisitor {

	private IPackageFragment ipack;

	private GeneratorPreference preference;

	/**
	 * Constructor
	 * 
	 * @param ipack
	 *        the IPackageFragment parent
	 */
	public SynchJDTCompilationUnit(IPackageFragment ipack, GeneratorPreference preference) {
		super();
		this.ipack = ipack;
		this.preference = preference;
	}

	public void visit(JDTJavaElement element) throws JDTVisitorException {
		// if element can't be generated, we stop all
		if(!element.isGenerated())
			return;
		if(SynchTools.isPrimiveType(element.getElementName()) && !element.getElementName().equals("String"))
			return;

		JDTCompilationUnit cu = (JDTCompilationUnit)element;
		try {
			ICompilationUnit icu = SynchTools.searchIJavaElement(ipack.getCompilationUnits(), cu.getElementName() + ".java");

			if(icu == null) {
				icu = ipack.createCompilationUnit(cu.getElementName() + ".java", "", true, null);
				if(!ipack.getElementName().equals(IPackageFragment.DEFAULT_PACKAGE_NAME))
					icu.createPackageDeclaration(ipack.getElementName(), null);
			}

			//call the children JDTType
			JDTVisitor visitor = new SynchJDTType(icu, preference);

			for(JDTType type : cu.getTypes())
				type.accept(visitor);

			// save the compilation unit
			icu.save(null, true);
		} catch (JavaModelException e) {
			e.printStackTrace();
			throw new JDTVisitorException(e.getMessage(), e.getCause());
		} catch (Exception e) {
			e.printStackTrace();
			throw new JDTVisitorException(e.getMessage(), e.getCause());
		}


	}

}
