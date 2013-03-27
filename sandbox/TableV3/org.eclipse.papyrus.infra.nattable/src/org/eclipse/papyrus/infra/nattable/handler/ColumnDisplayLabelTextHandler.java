/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage;

/**
 * The handler to change the boolean value used to display the text in the column label header
 * 
 * @author Vincent Lorenzo
 * 
 */
public class ColumnDisplayLabelTextHandler extends AbstractColumnChangeLabelConfigurationValueHandler {


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractChangeLabelConfigurationValueHandler#getEditedFeature()
	 * 
	 * @return
	 */
	@Override
	protected EStructuralFeature getEditedFeature() {
		return NattablelabelproviderPackage.eINSTANCE.getEObjectLabelProviderConfiguration_DisplayLabel();
	}

}
