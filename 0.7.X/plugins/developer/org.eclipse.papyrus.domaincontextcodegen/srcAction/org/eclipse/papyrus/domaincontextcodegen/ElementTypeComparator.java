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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.domaincontextcodegen;
import java.util.Comparator;

public class ElementTypeComparator implements Comparator<ElementType> {
   
	public int compare(ElementType o1, ElementType o2) {        
		String name1=o1.getSpecificName();
		String name2=o2.getSpecificName();
        int i=name1.compareTo(name2);
        return i;
	}
}