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

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.manager.table.AbstractNattableWidgetManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderCellContextElementWrapper;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElementWrapper;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElementWrapper;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.graphics.Image;

/**
 * The LabelProvider used in the table
 * 
 * @author Vincent Lorenzo
 * 
 */
public class NattableTopLabelProvider extends AbstractNattableCellLabelProvider {


	/**
	 * 
	 * @param cell
	 * @param configRegistry
	 * @return
	 */
	protected String getColumnHeaderLabel(final ILabelProviderCellContextElementWrapper cell, final IConfigRegistry configRegistry) {
		return getLabel(cell, configRegistry, Constants.HEADER_LABEL_PROVIDER_CONTEXT);
	}

	/**
	 * 
	 * @param cell
	 * @param configRegistry
	 * @return
	 */
	protected String getRowHeaderLabel(final ILabelProviderCellContextElementWrapper cell, final IConfigRegistry configRegistry) {
		return getLabel(cell, configRegistry, Constants.HEADER_LABEL_PROVIDER_CONTEXT);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public String getText(Object element) {
		final ILabelProviderCellContextElementWrapper contextElement = (ILabelProviderCellContextElementWrapper)element;
		final IConfigRegistry configRegistry = contextElement.getConfigRegistry();
		final LabelStack labels = getLabelStack(contextElement, configRegistry);
		if(labels.hasLabel(GridRegion.COLUMN_HEADER)) {
			return getColumnHeaderLabel(contextElement, configRegistry);
		} else if(labels.hasLabel(GridRegion.ROW_HEADER)) {
			return getRowHeaderLabel(contextElement, configRegistry);
		} else if(labels.hasLabel(GridRegion.BODY)) {
			return getBodyLabel(contextElement, configRegistry);
		}
		Object value = contextElement.getObject();
		if(value != null) {
			return value.toString();
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * 
	 * @param cell
	 * @param configRegistry
	 * @return
	 */
	protected LabelStack getLabelStack(final ILabelProviderCellContextElementWrapper contextElement, final IConfigRegistry configRegistry) {
		LabelStack labels = contextElement.getConfigLabels();
		if(labels.getLabels().isEmpty()) {
			//in case of copy, we don't have the label
			final INattableModelManager manager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
			labels = ((AbstractNattableWidgetManager)manager).getGridLayer().getBodyLayer().getConfigLabelsByPosition(contextElement.getColumnPosition(), contextElement.getRowPosition());
		}
		return labels;
	}

	/**
	 * 
	 * @param cell
	 * @param configRegistry
	 * @param labelproviderContext
	 * @return
	 */
	protected String getLabel(final ILabelProviderCellContextElementWrapper contextElement, final IConfigRegistry configRegistry, final String labelproviderContext) {
		String txt = ""; //$NON-NLS-1$
		//		Object value = cell.getDataValue();
		//		final ILabelProviderContextElement contextElement = new LabelProviderCellContextElement(cell, configRegistry);
		LabelProviderService serv = configRegistry.getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
		ILabelProvider labelProvider = serv.getLabelProvider(labelproviderContext, contextElement);
		if(labelProvider != null) {
			txt = labelProvider.getText(contextElement);
		} else {
			labelProvider = serv.getLabelProvider(labelproviderContext, contextElement.getObject());
			if(labelProvider != null) {
				txt = labelProvider.getText(contextElement.getObject());
			} else {
				labelProvider = serv.getLabelProvider(contextElement.getObject());
				if(labelProvider != null) {
					txt = labelProvider.getText(contextElement.getObject());
				} else {
					txt = contextElement.getObject().toString();
				}
			}
		}
		return txt;
	}

	/**
	 * 
	 * @param cellWrapperContextElement
	 * @param configRegistry
	 * @return
	 */
	protected String getBodyLabel(final ILabelProviderCellContextElementWrapper cellWrapperContextElement, final IConfigRegistry configRegistry) {//Body or data grid?
		return getLabel(cellWrapperContextElement, configRegistry, Constants.BODY_LABEL_PROVIDER_CONTEXT);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public boolean accept(Object element) {
		return element instanceof ILabelProviderCellContextElementWrapper;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#getImage(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public Image getImage(Object element) {
		final ILabelProviderCellContextElementWrapper contextElement = (ILabelProviderCellContextElementWrapper)element;


		Object object = contextElement.getObject();
		String labelProviderContextId = null;
		final IConfigRegistry configRegistry = contextElement.getConfigRegistry();
		if(object instanceof IAxis) {
			labelProviderContextId = ((IAxis)object).getManager().getLabelProviderContext();
			return getImage(contextElement, configRegistry, labelProviderContextId);
		}
		final LabelStack labels = getLabelStack(contextElement, configRegistry);
		if(labels.hasLabel(GridRegion.COLUMN_HEADER)) {
			return getColumnHeaderImage(contextElement, configRegistry);
		} else if(labels.hasLabel(GridRegion.ROW_HEADER)) {
			return getRowHeaderImage(contextElement, configRegistry);
		} else if(labels.hasLabel(GridRegion.BODY)) {
			return getBodyLabelImage(contextElement, configRegistry);
		}

		return null;
	}

	/**
	 * 
	 * @param cell
	 * @param configRegistry
	 * @return
	 */
	private Image getBodyLabelImage(ILabelProviderCellContextElementWrapper cell, IConfigRegistry configRegistry) {
		return null;
	}

	/**
	 * 
	 * @param cell
	 *        the cell
	 * @param configRegistry
	 *        the config registry
	 * @return
	 *         the image to display in the row
	 */
	private Image getRowHeaderImage(ILabelProviderCellContextElementWrapper cell, IConfigRegistry configRegistry) {
		return getImage(cell, configRegistry, Constants.HEADER_LABEL_PROVIDER_CONTEXT);
	}

	/**
	 * 
	 * @param cell
	 *        the cell
	 * @param configRegistry
	 *        the config registry
	 * @param labelproviderContext
	 *        the context to used to find the label provider
	 * @return
	 */
	private Image getImage(ILabelProviderCellContextElementWrapper contextElement, IConfigRegistry configRegistry, String labelproviderContext) {
		Image image = null;
		LabelProviderService serv = configRegistry.getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
		ILabelProvider labelProvider = serv.getLabelProvider(labelproviderContext, contextElement);
		if(labelProvider != null) {
			image = labelProvider.getImage(contextElement);
		} else {
			Object value = contextElement.getObject();
			labelProvider = serv.getLabelProvider(labelproviderContext, value);
			if(labelProvider != null) {
				image = labelProvider.getImage(value);
			} else {
				labelProvider = serv.getLabelProvider(value);
				if(labelProvider != null) {
					image = labelProvider.getImage(value);
				}
			}
		}
		return image;
	}

	/**
	 * 
	 * @param cell
	 *        the cell
	 * @param configRegistry
	 *        the config registry
	 * @return
	 *         the image to display for the header
	 */
	private Image getColumnHeaderImage(ILabelProviderCellContextElementWrapper cell, IConfigRegistry configRegistry) {
		return getImage(cell, configRegistry, Constants.HEADER_LABEL_PROVIDER_CONTEXT);
	}

}
