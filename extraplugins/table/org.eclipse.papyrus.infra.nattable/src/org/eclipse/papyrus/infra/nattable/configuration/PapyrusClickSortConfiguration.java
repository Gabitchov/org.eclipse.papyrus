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
package org.eclipse.papyrus.infra.nattable.configuration;

import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.BeveledBorderDecorator;
import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.CellPainterDecorator;
import org.eclipse.nebula.widgets.nattable.sort.config.DefaultSortConfiguration;
import org.eclipse.nebula.widgets.nattable.ui.util.CellEdgeEnum;
import org.eclipse.papyrus.infra.nattable.painter.CustomImagePainter;
import org.eclipse.papyrus.infra.nattable.painter.CustomizedCellPainter;
import org.eclipse.papyrus.infra.nattable.painter.PapyrusSortableHeaderTextPainter;

/**
 * The configuration used to do the sort
 * 
 * @author vl222926
 * 
 */
public class PapyrusClickSortConfiguration extends DefaultSortConfiguration {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public PapyrusClickSortConfiguration() {
		super(new BeveledBorderDecorator(new CellPainterDecorator(new PapyrusSortableHeaderTextPainter(new CustomizedCellPainter(), CellEdgeEnum.RIGHT), CellEdgeEnum.LEFT, new CustomImagePainter())));
	}

}
