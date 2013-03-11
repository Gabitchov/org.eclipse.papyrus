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
package org.eclipse.papyrus.sysml.nattable.provider;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElement;
import org.eclipse.papyrus.sysml.service.types.matcher.FlowPortNAMatcher;
import org.eclipse.papyrus.uml.nattable.provider.AbstractUMLNattableCellLabelProvider;
import org.eclipse.uml2.uml.Port;

/**
 * This label provider allows to display N/A for the direction of the FlowPort when its requred!
 * 
 * @author Vincent Lorenzo
 * 
 */
public class SysMLFlowPortDirectionLabelProvider extends AbstractUMLNattableCellLabelProvider {

	/**
	 * N/A FlowPort matcher
	 */
	private static final FlowPortNAMatcher matcher = new FlowPortNAMatcher();

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.provider.EMFCellLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public boolean accept(final Object element) {
		if(element instanceof LabelProviderCellContextElement) {
			final ILayerCell cell = ((LabelProviderCellContextElement)element).getCell();
			final IConfigRegistry registry = ((LabelProviderCellContextElement)element).getConfigRegistry();
			final Object columnObject = getColumnObject(cell, registry);
			String str = AxisUtils.getPropertyId(columnObject);
			if(str == null) {
				final Object rowObject = getRowObject(cell, registry);
				str = AxisUtils.getPropertyId(rowObject);
			}
			if(str != null) {
				return str.endsWith(org.eclipse.papyrus.sysml.nattable.utils.Constants.STEREOTYPE_FLOWPORT_DIRECTION);
			}
		}
		return false;
	}

	@Override
	public String getText(Object element) {
		final ILayerCell cell = ((LabelProviderCellContextElement)element).getCell();
		final IConfigRegistry configRegistry = ((LabelProviderCellContextElement)element).getConfigRegistry();
		final Object rowObject = getRowObject(cell, configRegistry);
		final Object columObject = getColumnObject(cell, configRegistry);
		Port port = null;
		if(rowObject instanceof Port) {
			port = (Port)rowObject;
		} else if(columObject instanceof Port) {
			port = (Port)columObject;
		}
		if(port != null && matcher.matches(port)) {
			return Constants.NOT_AVALAIBLE;
		}
		return super.getText(element);
	}
}
