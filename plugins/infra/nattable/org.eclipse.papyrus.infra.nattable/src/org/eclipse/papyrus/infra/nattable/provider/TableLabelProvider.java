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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
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
		Object el = table;
		if(table instanceof IAdaptable) {
			el = ((IAdaptable)table).getAdapter(EObject.class);
		}
		if(el != null && el instanceof Table) {
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

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider#accept(java.lang.Object)
	 * 
	 * @param object
	 * @return
	 */
	public boolean accept(Object object) {
		if(object instanceof IStructuredSelection) {
			return accept((IStructuredSelection)object);
		}
		Object el = object;
		if(object instanceof IAdaptable) {
			el = EMFHelper.getEObject(object);
		}
		if(el != null) {
			return el instanceof Table;
		}

		return false;
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
			Assert.isTrue(current instanceof Table);
			Table table = (Table)current;
			String icon = table.getTableConfiguration().getIconPath();
			Assert.isNotNull(icon);
			if(iconPath == null) {
				iconPath = icon;
			}
			if(!iconPath.equals(icon)) {
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
	protected Image getNonCommonIcon(final Object commonObject) {
		return org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(org.eclipse.papyrus.infra.nattable.Activator.PLUGIN_ID, "/icons/table.gif");
	}



}
