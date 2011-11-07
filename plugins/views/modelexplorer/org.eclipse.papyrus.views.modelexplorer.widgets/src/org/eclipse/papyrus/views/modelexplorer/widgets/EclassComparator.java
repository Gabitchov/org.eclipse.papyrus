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
package org.eclipse.papyrus.views.modelexplorer.widgets;

import java.util.Comparator;

import org.eclipse.emf.ecore.EClass;

/**
 * comparator EClass by taking in account their names 
 *
 */
public class EclassComparator implements Comparator<Object>{

	/**
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 *
	 */
	public int compare(Object eclass0, Object eclass1) {
		//it verify if this isan Eclass
		if(eclass0 instanceof EClass && eclass1 instanceof EClass){
			String emp1Name = ((EClass)eclass0).getName();        
			String emp2Name = ((EClass)eclass1).getName();
			//uses compareTo method of String class to compare names of the Eclasses
			return emp1Name.compareTo(emp2Name);
		}
		else{return 0;}
	}


}
