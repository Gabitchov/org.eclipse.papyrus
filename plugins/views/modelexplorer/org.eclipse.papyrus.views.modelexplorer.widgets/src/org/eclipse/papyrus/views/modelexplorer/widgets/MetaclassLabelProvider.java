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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.widgets;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.LabelProvider;

/**
 *this is label provider to display the name of an Eclass 
 *
 */

public class MetaclassLabelProvider extends LabelProvider {

	/**
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 *
	 */
	public String getText(Object element) {
		if(element instanceof EClass){
			return ((EClass)element).getName();
		}
		else {
			return super.getText(element);
		}
	}
}
