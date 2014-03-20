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

import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * 
 * This labelprovider provides icon and text for tables to display them in treeviewer AND in the property view
 * 
 */
public class TableLabelProvider extends EMFLabelProvider implements IFilteredLabelProvider {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider#getText(java.lang.Object)
	 * 
	 * @param table
	 * @return
	 */
	@Override
	public String getText(Object table) {
		if(table instanceof IStructuredSelection) {
			return super.getText((IStructuredSelection)table);
		}

		Object el = EMFHelper.getEObject(table);

		if(el instanceof Table) {
			return ((Table)el).getName();
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider#getImage(java.lang.Object)
	 * 
	 * @param table
	 * @return
	 */
	@Override
	public Image getImage(Object table) {
		if(table instanceof IStructuredSelection) {
			return getImage(((IStructuredSelection)table));
		}

		table = EMFHelper.getEObject(table);

		if(table instanceof Table) {
			final String iconPath = getIcon((Table)table);
			if(iconPath != null) {
				return Activator.getDefault().getImage(iconPath);
			}
		}
		return null;
	}

	protected String getIcon(Table table) {
		if(table == null || table.getTableConfiguration() == null || table.getTableConfiguration().getIconPath() == null) {
			return null;
		}
		return table.getTableConfiguration().getIconPath();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider#accept(java.lang.Object)
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean accept(Object object) {
		if(object instanceof IStructuredSelection) {
			return accept((IStructuredSelection)object);
		}

		return EMFHelper.getEObject(object) instanceof Table;
	}

	/**
	 * 
	 * @param selection
	 *        a selection
	 * @return
	 *         <code>true</code> if all elements in the selection are accepted
	 */
	protected boolean accept(final IStructuredSelection selection) {
		for(final Object current : selection.toList()) {
			if(!accept(current)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider#hasCommonImage(java.util.Collection)
	 * 
	 * @param objects
	 * @return
	 *         <code>true</code> if all selected table have the same icon
	 */
	@Override
	protected boolean hasCommonImage(Collection<?> objects) {
		String iconPath = null;
		for(Object current : objects) {
			if(!(current instanceof Table)) {
				return false;
			}

			String icon = getIcon((Table)current);
			if(icon == null && iconPath != null) {
				return false;
			}

			if(iconPath == null) {
				iconPath = icon;
			} else if(!iconPath.equals(icon)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider#getNonCommonIcon(java.lang.Object)
	 * 
	 * @param commonObject
	 * @return
	 */
	@Override
	protected Image getNonCommonIcon(final Object commonObject) {
		return org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(org.eclipse.papyrus.infra.nattable.Activator.PLUGIN_ID, "/icons/table.gif");
	}

}
