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
package org.eclipse.papyrus.uml.nattable.ws.preferences.provider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElementWrapper;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.uml.nattable.ws.preferences.utils.Constants;
import org.eclipse.swt.graphics.Image;


public class FileLabelProvider extends AbstractNattableCellLabelProvider {

	@Override
	public boolean accept(Object element) {
		if(element instanceof LabelProviderCellContextElementWrapper) {
			element = ((LabelProviderCellContextElementWrapper)element).getObject();
			return element instanceof String && ((String)element).startsWith(Constants.WORKSPACE_PREFIX);
		}
		return false;
	}

	@Override
	public Image getImage(Object element) {
		return Activator.getDefault().getImage(org.eclipse.papyrus.uml.nattable.ws.preferences.Activator.PLUGIN_ID, "icons/file.png");
	}

	@Override
	public String getText(Object element) {
		if(element instanceof LabelProviderCellContextElementWrapper) {
			element = ((LabelProviderCellContextElementWrapper)element).getObject();
			String path = (String)element;
			int lastIndex = path.lastIndexOf("\\") + 1;
			return path.substring(lastIndex, path.length());

		}
		return null;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		super.addListener(listener);
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return super.isLabelProperty(element, property);
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		super.removeListener(listener);
	}

	@Override
	protected Object getRowObject(ILayerCell cell, IConfigRegistry registry) {
		return super.getRowObject(cell, registry);
	}

	@Override
	protected Object getColumnObject(ILayerCell cell, IConfigRegistry registry) {
		return super.getColumnObject(cell, registry);
	}

	@Override
	protected ITableAxisElementProvider getAxisContentProvider(IConfigRegistry registry) {
		return super.getAxisContentProvider(registry);
	}

	@Override
	protected LabelProviderService getLabelProviderService(IConfigRegistry registry) {
		return super.getLabelProviderService(registry);
	}

	@Override
	protected ILabelProviderConfiguration getLabelConfiguration(LabelProviderCellContextElementWrapper element) {
		return super.getLabelConfiguration(element);
	}

}
