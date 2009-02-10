/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

//FIXME How to manage circular inclusions?
/**
 * 
 * 
 * 
 * 
 * This class represents a class and encapsulates an org.eclipse.uml2.uml.Class object
 */
public class Classifier extends NamedElement {

	/**
     * 
     */
	private org.eclipse.uml2.uml.Classifier uml2Classifier;

	/**
	 * 
	 * 
	 * @param uml2Classifier
	 */
	public Classifier(org.eclipse.uml2.uml.Classifier uml2Classifier) {
		super(uml2Classifier);
		this.uml2Classifier = uml2Classifier;

	}

	/**
	 * 
	 * 
	 * @return Returns the uml2Class.
	 */
	public org.eclipse.uml2.uml.Classifier getUml2Classifier() {
		return uml2Classifier;
	}

	/**
	 * Gives the implementation links from this class to interfaces.
	 * 
	 * @return A Collection of com.cea.papyrus.umlutils.Implementation.
	 * 
	 * @deprecated
	 */
	@Deprecated
	public Collection getImplementations() {
		return null;
		// FIXME : does not return anything...
		/*
		 * Collection implementations = new HashSet(); if (uml2Classifier instanceof org.eclipse.uml2.uml.Class) { org.eclipse.uml2.uml.Class currentClass = (org.eclipse.uml2.uml.Class)uml2Classifier;
		 * Iterator implementationsIt = currentClass.getImplementations().iterator(); com.cea.papyrus.umlutils.Implementation currentImpl; while(implementationsIt.hasNext()){ currentImpl = new
		 * com.cea.papyrus.umlutils.Implementation((org.eclipse.uml2.uml.Implementation) implementationsIt.next()) ; implementations.add(currentImpl); } }
		 * 
		 * return implementations;
		 */
	}

	/**
	 * Gives the generalisation links from this class to superClasses.
	 * 
	 * @return A Collection of com.cea.papyrus.umlutils.Generalizations.
	 */
	public Collection<Generalization> getGeneralizations() {
		Collection<Generalization> generalizations = new HashSet<Generalization>();
		Iterator generalizationsIt = uml2Classifier.getGeneralizations().iterator();
		org.eclipse.papyrus.umlutils.Generalization currentGnl;
		while (generalizationsIt.hasNext()) {
			currentGnl = new org.eclipse.papyrus.umlutils.Generalization((org.eclipse.uml2.uml.Generalization) generalizationsIt.next());
			generalizations.add(currentGnl);
		}
		return generalizations;
	}
}