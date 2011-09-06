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


import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.papyrus.java.generator.jdtsynchronizer.GeneratorPreference;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaElement;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaModel;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.JDTJavaProject;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitor;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;

/**
 * Allow to generate Code thanks to a JDT model
 * 
 * @author Deblock Nicolas & Manuel Giles
 * 
 */
public class SynchJDTJavaModel implements JDTVisitor {

	private GeneratorPreference preference;

	/**
	 * Constructor
	 * 
	 * @param modelJDT
	 *        the model JDT to generate
	 */
	public SynchJDTJavaModel(GeneratorPreference preference) {
		this.preference = preference;
	}

	public void visit(JDTJavaElement element) throws JDTVisitorException {
		// if element can't be generated, we stop all
		//if(!element.isGenerated()) return ;

		if(!(element instanceof JDTJavaModel))
			return;
		// cast element to JDTJavaModel
		JDTJavaModel model = (JDTJavaModel)element;

		// research the IJavaModel
		IWorkspaceRoot iroot = ResourcesPlugin.getWorkspace().getRoot();
		IJavaModel ijm = JavaCore.create(iroot);


		// browse all JDTJavaProject and call the visit
		JDTVisitor visitor = new SynchJDTJavaProject(ijm, iroot, preference);
		for(JDTJavaProject root : model.getJavaProject()) {
			root.accept(visitor);
		}
	}
}
