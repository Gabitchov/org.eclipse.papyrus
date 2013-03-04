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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;

/**
 * 
 * A specific cellpainter for header. This cell painter looks for specific label providers for header
 * 
 */
public class HeaderCellPainter extends CustomizedCellPainter {

	/**
	 * the id of the context for the label provider declared on the header of column
	 */
	public static final String HEADER_LABEL_PROVIDER_CONTEXT = "org.eclipse.papyrus.infra.nattable.header.labelprovider";

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.configuration.CustomizedCellPainter#convertDataType(org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell,
	 *      org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 * 
	 * @param cell
	 * @param configRegistry
	 * @return
	 */
	@Override
	protected String convertDataType(ILayerCell cell, IConfigRegistry configRegistry) {
		final Object value = cell.getDataValue();
		if(value instanceof EObject) {
			LabelProviderService service = getLabelProviderService((EObject)value);
			if(service == null) {
				service = serv;
			}
			ILabelProvider provider = service.getLabelProvider(HEADER_LABEL_PROVIDER_CONTEXT);
			if(provider != null) {
				return provider.getText(value);
			}
		}
		return super.convertDataType(cell, configRegistry);
	}
}
