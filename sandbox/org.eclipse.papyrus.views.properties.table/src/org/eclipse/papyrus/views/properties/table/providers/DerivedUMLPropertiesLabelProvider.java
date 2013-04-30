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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.table.providers;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElement;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.views.properties.table.custom.MultiplicityHandler;


public class DerivedUMLPropertiesLabelProvider extends LabelProvider implements IFilteredLabelProvider {

	public boolean accept(Object element) {
		if(element instanceof LabelProviderCellContextElement) {
			return ((LabelProviderCellContextElement)element).getObject() == MultiplicityHandler.getInstance();
		}
		return false;
	}

	@Override
	public String getText(Object element) {
		return "multiplicity : String [0..1]";
	}

}
