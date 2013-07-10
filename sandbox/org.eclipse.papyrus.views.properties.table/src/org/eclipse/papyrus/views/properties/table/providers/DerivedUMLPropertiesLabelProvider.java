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
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IdAxis;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElementWrapper;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.views.properties.table.axis.DerivedUMLPropertiesAxisManager;
import org.eclipse.swt.graphics.Image;


public class DerivedUMLPropertiesLabelProvider extends LabelProvider implements IFilteredLabelProvider {

	@Override
	public boolean accept(final Object element) {
		if(element instanceof LabelProviderCellContextElementWrapper) {
			Object object = ((LabelProviderCellContextElementWrapper)element).getObject();
			if(object instanceof IdAxis) {
				String id = ((IdAxis)object).getElement();
				return DerivedUMLPropertiesAxisManager.MULTIPLICITY.equals(id);
			}

		}
		return false;
	}

	@Override
	public String getText(final Object element) {
		return "multiplicity : String [0..1]";
	}

	@Override
	public Image getImage(final Object element) {
		org.eclipse.papyrus.infra.widgets.Activator widgetActivator = org.eclipse.papyrus.infra.widgets.Activator.getDefault();
		String emtNattablePluginID = org.eclipse.papyrus.infra.emf.nattable.Activator.PLUGIN_ID;
		return widgetActivator.getImage(emtNattablePluginID, "icons/attributes.gif");
	}

}
