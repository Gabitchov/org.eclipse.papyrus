/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.provider;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * This labelprovider provides icon and text for tables to display them in treeviewer
 * 
 */
public class TableLabelProvider extends EMFLabelProvider implements IFilteredLabelProvider {

	@Override
	public String getText(Object table) {
		Object el = table;
		if(table instanceof IAdaptable) {
			el = ((IAdaptable)table).getAdapter(EObject.class);
		}
		if(el != null && el instanceof Table) {
			return ((Table)el).getName();
		}
		return ""; //$NON-NLS-1$
	}

	@Override
	public Image getImage(Object table) {
		if(table instanceof IAdaptable) {
			table = ((IAdaptable)table).getAdapter(EObject.class);
		}
		if(table instanceof Table) {
			final String iconPath = ((Table)table).getTableConfiguration().getIconPath();
			if(iconPath != null) {
				return Activator.getDefault().getImage(iconPath);
			}
		}
		return null;
	}

	public boolean accept(Object table) {
		Object el = table;
		if(table instanceof IAdaptable) {
			el = EMFHelper.getEObject(table);
		}
		if(el != null) {
			return el instanceof Table;
		}

		return false;
	}

}
