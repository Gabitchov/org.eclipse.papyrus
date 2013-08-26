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
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Override of the paintCell() method
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.painter;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.nebula.widgets.nattable.resize.command.RowResizeCommand;
import org.eclipse.nebula.widgets.nattable.style.CellStyleUtil;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.nebula.widgets.nattable.style.IStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElementWrapper;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElementWrapper;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;

/**
 * Custom CellPainter to define the LabelProvider to use
 * 
 * @author Vincent Lorenzo
 * 
 */
//TODO : we should use the TextPainter itself, now with the GenericDisplayConverter, it should works fine
public class CustomizedCellPainter extends TextPainter {

	/**
	 * the color used for error;
	 */
	private final Color errorColor = new Color(Display.getDefault(), 255, 0, 0);

	/**
	 * 
	 * Constructor. We're overriding it to always set word-wrapping for our cells.
	 * 
	 */
	public CustomizedCellPainter() {
		super(false, true);//with (true,true), automatic newLine when the text is too long to be displayed.
	}

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
		final ILabelProviderContextElementWrapper contextElement = new LabelProviderCellContextElementWrapper(cell, configRegistry);
		final ILabelProvider provider = serv.getLabelProvider(Constants.TABLE_LABEL_PROVIDER_CONTEXT, contextElement);
		String str = provider.getText(contextElement);
		if(str == null) {
			str = ""; //$NON-NLS-1$
		}
		return str;
	}

	/**
	 * Overridden to show, additionally to the contents of a cell, a vertical arrow pointing down in case there are masked lines
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter#paintCell(org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell,
	 *      org.eclipse.swt.graphics.GC, org.eclipse.swt.graphics.Rectangle, org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 * 
	 * @param cell
	 * @param gc
	 * @param rectangle
	 * @param configRegistry
	 */
	@Override
	public void paintCell(ILayerCell cell, GC gc, Rectangle rectangle, IConfigRegistry configRegistry) {
		super.paintCell(cell, gc, rectangle, configRegistry);
		IStyle cellStyle = CellStyleUtil.getCellStyle(cell, configRegistry);
		int fontHeight = gc.getFontMetrics().getHeight();
		String text = convertDataType(cell, configRegistry);
		text = getTextToDisplay(cell, gc, rectangle.width, text);

		int numberOfNewLines = getNumberOfNewLines(text);
		//we're extending the row height (only if word wrapping is enabled)
		int contentHeight = (fontHeight * numberOfNewLines) + (spacing * 2);
		int contentToCellDiff = (cell.getBounds().height - rectangle.height);

		if(performRowResize(contentHeight, rectangle)) {
			ILayer layer = cell.getLayer();
			layer.doCommand(new RowResizeCommand(layer, cell.getRowPosition(), contentHeight + contentToCellDiff));
		}
		if(numberOfNewLines > 1) {

			int yStartPos = rectangle.y + CellStyleUtil.getVerticalAlignmentPadding(cellStyle, rectangle, contentHeight);
			String[] lines = text.split("\n"); //$NON-NLS-1$
			for(String line : lines) {
				int lineContentWidth = Math.min(getLengthFromCache(gc, line), rectangle.width);

				Image im = org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("org.eclipse.papyrus.infra.nattable", "/icons/arrow_down_end.png"); //$NON-NLS-1$ //$NON-NLS-2$
				gc.drawText(line, rectangle.x + CellStyleUtil.getHorizontalAlignmentPadding(cellStyle, rectangle, lineContentWidth) + spacing, yStartPos + spacing, SWT.DRAW_TRANSPARENT | SWT.DRAW_DELIMITER);

				//We test if, given the current cell size and text position, we should display the down pointing arrow.
				if(contentHeight > rectangle.height && yStartPos + fontHeight > rectangle.height + rectangle.y) {
					int yDownRowIcon = rectangle.y + rectangle.height - im.getBounds().height;
					int xDownRowIcon = rectangle.x + rectangle.width - im.getBounds().width;
					gc.drawImage(im, xDownRowIcon, yDownRowIcon);
				}

				//after every line calculate the y start pos new
				yStartPos += fontHeight;
			}
		}
	}


	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.painter.cell.BackgroundPainter#getBackgroundColour(org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell,
	 *      org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 * 
	 * @param cell
	 * @param configRegistry
	 * @return
	 */
	@Override
	protected Color getBackgroundColour(final ILayerCell cell, final IConfigRegistry configRegistry) {
		Object value = cell.getDataValue();
		boolean hasError = false;
		if(value instanceof Problem) {
			hasError = true;
		} else if(value instanceof Collection<?>) {
			final Iterator<?> iter = ((Collection<?>)value).iterator();
			while(!hasError && iter.hasNext()) {
				hasError = iter.next() instanceof Problem;
			}
		}

		if(hasError) {
			return this.errorColor;
		}
		return super.getBackgroundColour(cell, configRegistry);
	}

}
