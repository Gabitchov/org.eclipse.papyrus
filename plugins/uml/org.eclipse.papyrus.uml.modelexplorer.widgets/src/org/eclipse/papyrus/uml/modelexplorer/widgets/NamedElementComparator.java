/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.modelexplorer.widgets;

import java.util.Comparator;

import org.eclipse.uml2.uml.NamedElement;

/**
 * comparator UML NamedElement by taking in account their names 
 *
 */
public class NamedElementComparator implements Comparator<Object>{

	public int compare(Object namedElement0, Object namedElement1) {
		if(namedElement0 instanceof NamedElement && namedElement1 instanceof NamedElement){
			String emp1Name = ((NamedElement)namedElement0).getName();        
			String emp2Name = ((NamedElement)namedElement1).getName();
			//uses compareTo method of String class to compare names of the Eclasses
			return emp1Name.compareTo(emp2Name);
		}
		else{return 0;}
	}



}
