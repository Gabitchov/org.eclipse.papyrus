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
package org.eclipse.papyrus.infra.nattable.provider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.manager.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.graphics.Image;


public abstract class AbstractNattableCellLabelProvider implements IFilteredLabelProvider{

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 * 
	 */
	public boolean accept(Object element) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 * 
	 */
	public Image getImage(Object element) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 * 
	 */
	public String getText(Object element) {
		return "";
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 * 
	 * @param listener
	 *        always throws {@link UnsupportedOperationException}
	 */
	public void addListener(ILabelProviderListener listener) {
		throw new UnsupportedOperationException();
	}

	public void dispose() {
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 * 
	 * @param element
	 * @param property
	 * @return
	 *         false
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 * 
	 * @param listener
	 *        always throws {@link UnsupportedOperationException}
	 */
	public void removeListener(ILabelProviderListener listener) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cell
	 * @param registry
	 * @return
	 *         the row object for this cell
	 */
	protected Object getRowObject(final ILayerCell cell, final IConfigRegistry registry) {
		int rowIndex = cell.getRowIndex();
		ITableAxisElementProvider provider = getAxisContentProvider(registry);
		return provider.getRowElement(rowIndex);
	}

	/**
	 * 
	 * @param cell
	 * @param registry
	 * @return
	 *         the column object for this cell
	 */
	protected Object getColumnObject(final ILayerCell cell, final IConfigRegistry registry) {
		int columnIndex = cell.getColumnIndex();
		ITableAxisElementProvider provider = getAxisContentProvider(registry);
		return provider.getColumnElement(columnIndex);
	}

	/**
	 * 
	 * @param registry
	 * @return
	 *         the table axis element provider
	 */
	protected ITableAxisElementProvider getAxisContentProvider(final IConfigRegistry registry) {
		return registry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
	}

	/**
	 * 
	 * @param registry
	 * @return
	 *         the label provider service
	 */
	protected LabelProviderService getLabelProviderService(final IConfigRegistry registry) {
		return registry.getConfigAttribute(NattableConfigAttributes.LABEL_PROVER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
	}
}
