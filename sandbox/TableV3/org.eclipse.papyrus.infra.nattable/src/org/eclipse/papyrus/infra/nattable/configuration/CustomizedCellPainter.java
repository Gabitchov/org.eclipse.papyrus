/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.configuration;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElement;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;

/**
 * Custom CellPainter to define the LabelProvider to use
 * 
 * @author Vincent Lorenzo
 * 
 */
//FIXME : we should use the TextPainter itself, now with the GenericDisplayConverter, it should works fine
public class CustomizedCellPainter extends TextPainter {

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.painter.cell.AbstractTextPainter#convertDataType(org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell,
	 *      org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 * 
	 * @param cell
	 * @param configRegistry
	 * @return
	 */
	@Override
	protected String convertDataType(final ILayerCell cell, final IConfigRegistry configRegistry) {
		final LabelProviderService serv = configRegistry.getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
		final ILabelProviderContextElement contextElement = new LabelProviderCellContextElement(cell, configRegistry);
		final ILabelProvider provider = serv.getLabelProvider(Constants.TABLE_LABEL_PROVIDER_CONTEXT, contextElement);
		return provider.getText(contextElement);
	}

}
