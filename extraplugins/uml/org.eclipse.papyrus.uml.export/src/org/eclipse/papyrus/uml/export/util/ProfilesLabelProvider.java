/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.util;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.uml2.uml.Profile;


// TODO: Auto-generated Javadoc
/**
 * The Class ProfilesLabelProvider.
 */
public class ProfilesLabelProvider extends LabelProvider {

	/**
	 * Instantiates a new profiles label provider.
	 */
	public ProfilesLabelProvider() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the text.
	 * 
	 * @param element
	 *        the element
	 * @return the text
	 * @{inheritedDoc
	 */
	@Override
	public String getText(Object element) {
		if(!(element instanceof Profile)) {
			return super.getText(element);
		}

		return ((Profile)element).getName();
	}

}
