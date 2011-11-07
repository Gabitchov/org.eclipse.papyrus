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

import org.eclipse.papyrus.views.modelexplorer.widgets.MetaclassLabelProvider;
import org.eclipse.uml2.uml.Stereotype;

/**
 * display the name of Eclass or stereotypes 
 *
 */
public class StereotypeMetaclassLabelProvider extends MetaclassLabelProvider {

	@Override
	public String getText(Object element) {
		if(element instanceof Stereotype){
			return ((Stereotype)element).getName();
		}
		return super.getText(element);
	}
}
