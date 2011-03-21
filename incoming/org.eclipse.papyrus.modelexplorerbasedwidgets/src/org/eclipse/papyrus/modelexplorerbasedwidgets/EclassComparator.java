/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorerbasedwidgets;

import java.util.Comparator;

import org.eclipse.emf.ecore.EClass;

/**
 * comparator EClass by taking in account their names 
 *
 */
public class EclassComparator implements Comparator<EClass>{

	public int compare(EClass eclass0, EClass eclass1) {

		String emp1Name = (eclass0).getName();        
		String emp2Name = (eclass1).getName();
		//uses compareTo method of String class to compare names of the Eclasses
		return emp1Name.compareTo(emp2Name);
	}


}
