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

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.config.DefaultColumnHeaderStyleConfiguration;
import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.BeveledBorderDecorator;
import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.CellPainterDecorator;
import org.eclipse.nebula.widgets.nattable.ui.util.CellEdgeEnum;
import org.eclipse.papyrus.infra.nattable.painter.CustomImagePainter;

/**
 * 
 * The default style for the column. We provide a specific label provider and image painter
 * 
 */
public class PapyrusColumnHeaderStyleConfiguration extends DefaultColumnHeaderStyleConfiguration {


	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.layer.config.DefaultColumnHeaderStyleConfiguration#configureRegistry(org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 * 
	 * @param configRegistry
	 */
	@Override
	public void configureRegistry(final IConfigRegistry configRegistry) {
		this.cellPainter = new BeveledBorderDecorator(new CellPainterDecorator(new CustomizedCellPainter(), CellEdgeEnum.LEFT, new CustomImagePainter()));//new CustomizedCellPainter());
		super.configureRegistry(configRegistry);
	}

}
