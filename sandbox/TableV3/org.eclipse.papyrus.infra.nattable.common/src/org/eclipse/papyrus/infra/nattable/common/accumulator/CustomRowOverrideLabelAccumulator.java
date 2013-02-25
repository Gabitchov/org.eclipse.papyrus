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
package org.eclipse.papyrus.infra.nattable.common.accumulator;

import java.util.List;

import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.layer.cell.AbstractOverrider;

/**
 * 
 * Tghis accumulator is used to register CellEditor on rows
 * 
 */
public class CustomRowOverrideLabelAccumulator extends AbstractOverrider {

	private final ILayer layer;

	public CustomRowOverrideLabelAccumulator(ILayer layer) {
		this.layer = layer;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.layer.cell.IConfigLabelAccumulator#accumulateConfigLabels(org.eclipse.nebula.widgets.nattable.layer.LabelStack,
	 *      int, int)
	 * 
	 * @param configLabels
	 * @param columnPosition
	 * @param rowPosition
	 */
	@Override
	public void accumulateConfigLabels(LabelStack configLabels, int columnPosition, int rowPosition) {
		int rowIndex = layer.getRowIndexByPosition(rowPosition);
		List<String> overrides = getOverrides(Integer.valueOf(rowIndex));
		if(overrides != null) {
			for(String configLabel : overrides) {
				configLabels.addLabel(configLabel);
			}
		}
	}

	/**
	 * Register labels to be contributed a column. This label will be applied to<br/>
	 * all cells in the column.
	 */
	public void registerRowOverrides(int rowIndex, String... configLabels) {
		super.registerOverrides(Integer.valueOf(rowIndex), configLabels);
	}

	/**
	 * Register labels to be contributed a column. This label will be applied to<br/>
	 * all cells in the column.
	 */
	public void registerRowOverridesOnTop(int rowIndex, String... configLabels) {
		super.registerOverridesOnTop(Integer.valueOf(rowIndex), configLabels);
	}

}
