/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Patrick Tessier patrick.tessier@cea.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.ui.dialog;

/**
 * This class is used to compare two class element by comparing the name without taking in account
 * upper case or lower case.
 * 
 * @author Patrick Tessier
 */
public class ClassElementComparator implements java.util.Comparator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	/**
	 * 
	 * 
	 * @param o2
	 * @param o1
	 * 
	 * @return
	 */
	public int compare(final Object o1, final Object o2) {
		final org.eclipse.uml2.uml.Class e1 = (org.eclipse.uml2.uml.Class)o1; // cast inot class
		final org.eclipse.uml2.uml.Class e2 = (org.eclipse.uml2.uml.Class)o2;
		return e1.getQualifiedName().compareToIgnoreCase(e2.getQualifiedName()); // compare name of
		// the classes
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	/**
	 * 
	 * 
	 * @param obj
	 * 
	 * @return
	 */
	@Override
	public boolean equals(final Object obj) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	/**
	 * 
	 * 
	 * @return
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
