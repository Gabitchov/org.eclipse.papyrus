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
package org.eclipse.papyrus.infra.nattable.views.editor.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.emf.nattable.provider.EMFCellLabelProvider;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderCellContextElement;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.nattable.views.editor.utils.Utils;

/**
 *
 * @author Vincent Lorenzo
 *
 */
public class ModelViewsCellLabelProvider extends EMFCellLabelProvider {//FIXME maybe not useful to extends it for each kind of table : we must be able to return the value owned by the cell each time!!!

	/**
	 *
	 * @see org.eclipse.papyrus.infra.emf.nattable.provider.EMFCellLabelProvider#accept(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	public boolean accept(Object element) {
		if(element instanceof ILabelProviderCellContextElement) {
			final ILayerCell cell = ((ILabelProviderCellContextElement)element).getCell();
			final IConfigRegistry registry = ((ILabelProviderContextElement)element).getConfigRegistry();
			final INattableModelManager manager = registry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
			final Object rowElement = getRowObject(cell, registry);
			final Object columnElement = getColumnObject(cell, registry);
			final IPageManager mngr = Utils.getIPagneManager(manager.getTable());
			if(rowElement instanceof EObject && mngr.allPages().contains(rowElement) && columnElement instanceof String) {
				return ((String)columnElement).startsWith(Utils.NATTABLE_EDITOR_PAGE_ID);
			} else if(columnElement instanceof EObject && rowElement instanceof String && (mngr.allPages().contains(columnElement))) {
				return ((String)rowElement).startsWith(Utils.NATTABLE_EDITOR_PAGE_ID);
			}
		}
		return false;
	}

}
