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
package org.eclipse.papyrus.infra.nattable.painter;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.cell.CheckBoxPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;


public class CustomCheckBoxPainter extends CheckBoxPainter {

	@Override
	public ICellPainter getCellPainterAt(int x, int y, ILayerCell cell, GC gc, Rectangle bounds, IConfigRegistry configRegistry) {
		try {
			isChecked(cell, configRegistry);
		} catch (Exception e) {
			TextPainter painter = new TextPainter();
			return painter.getCellPainterAt(x, y, cell, gc, bounds, configRegistry);
		}
		return super.getCellPainterAt(x, y, cell, gc, bounds, configRegistry);
	}

	@Override
	public void paintCell(ILayerCell cell, GC gc, Rectangle bounds, IConfigRegistry configRegistry) {
		try {
			isChecked(cell, configRegistry);
		} catch (Exception e) {
			TextPainter painter = new TextPainter();
			painter.paintCell(cell, gc, bounds, configRegistry);
			return;
		}
		super.paintCell(cell, gc, bounds, configRegistry);
	}
}
