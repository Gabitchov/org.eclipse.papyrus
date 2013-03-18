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
package org.eclipse.papyrus.infra.nattable.converter;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElement;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;

/**
 * This converter uses the label provider service to display the correct text
 * 
 * @author Vincent Lorenzo
 * 
 */
public class GenericDisplayConverter implements IDisplayConverter {

	/**
	 * throw new UnsupportedOperationException();
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter#canonicalToDisplayValue(java.lang.Object)
	 * 
	 * @param canonicalValue
	 * @return
	 */
	public Object canonicalToDisplayValue(Object canonicalValue) {
		throw new UnsupportedOperationException();
	}

	/**
	 * throw new UnsupportedOperationException();
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter#displayToCanonicalValue(java.lang.Object)
	 * 
	 * @param displayValue
	 * @return
	 */
	public Object displayToCanonicalValue(Object displayValue) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter#canonicalToDisplayValue(org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell,
	 *      org.eclipse.nebula.widgets.nattable.config.IConfigRegistry, java.lang.Object)
	 * 
	 * @param cell
	 * @param configRegistry
	 * @param canonicalValue
	 * @return
	 */
	public Object canonicalToDisplayValue(ILayerCell cell, IConfigRegistry configRegistry, Object canonicalValue) {
		LabelProviderService service = configRegistry.getConfigAttribute(NattableConfigAttributes.LABEL_PROVIDER_SERVICE_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.LABEL_PROVIDER_SERVICE_ID);
		ILabelProvider labelProvider = service.getLabelProvider(Constants.TABLE_LABEL_PROVIDER_CONTEXT);
		final ILabelProviderContextElement contextElement = new LabelProviderCellContextElement(cell, configRegistry);
		assert labelProvider != null;
		return labelProvider.getText(contextElement);
	}

	/**
	 * throw new UnsupportedOperationException();
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter#displayToCanonicalValue(org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell,
	 *      org.eclipse.nebula.widgets.nattable.config.IConfigRegistry, java.lang.Object)
	 * 
	 * @param cell
	 * @param configRegistry
	 * @param displayValue
	 * @return
	 */
	public Object displayToCanonicalValue(ILayerCell cell, IConfigRegistry configRegistry, Object displayValue) {
//		throw new UnsupportedOperationException();
		return displayValue;
	}


}
