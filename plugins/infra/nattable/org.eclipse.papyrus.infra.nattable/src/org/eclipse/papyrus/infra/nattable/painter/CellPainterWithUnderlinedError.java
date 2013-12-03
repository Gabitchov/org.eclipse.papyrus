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
package org.eclipse.papyrus.infra.nattable.painter;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.ILayer;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter;
import org.eclipse.nebula.widgets.nattable.resize.command.RowResizeCommand;
import org.eclipse.nebula.widgets.nattable.style.CellStyleUtil;
import org.eclipse.nebula.widgets.nattable.style.IStyle;
import org.eclipse.nebula.widgets.nattable.util.GUIHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;

/**
 * 
 * This cell painter draws waves above the displayed text when the cell contains one or several problem
 * 
 */
public class CellPainterWithUnderlinedError extends TextPainter {
/**
 * the offset used to do the underline with "waves"
 */
	final private int[] yErrorOffsets = { 0, 1, 2, 1 };

	/**
	 * 
	 * Constructor.
	 * 
	 * @param wrapText
	 * @param paintBg
	 */
	public CellPainterWithUnderlinedError(boolean wrapText, boolean paintBg) {
		super(wrapText, paintBg);
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.painter.cell.TextPainter#paintCell(org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell,
	 *      org.eclipse.swt.graphics.GC, org.eclipse.swt.graphics.Rectangle, org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 * 
	 * @param cell
	 * @param gc
	 * @param rectangle
	 * @param configRegistry
	 * 
	 *        Method duplcated from super class, to allow to use a specific underline style for error
	 */
	@Override
	public void paintCell(final ILayerCell cell, GC gc, final Rectangle rectangle, final IConfigRegistry configRegistry) {
		if(paintBg) {
			super.paintCell(cell, gc, rectangle, configRegistry);
		}

		if(paintFg) {
			Rectangle originalClipping = gc.getClipping();
			gc.setClipping(rectangle.intersection(originalClipping));

			IStyle cellStyle = CellStyleUtil.getCellStyle(cell, configRegistry);
			setupGCFromConfig(gc, cellStyle);

			boolean underline = renderUnderlined(cellStyle);
			boolean strikethrough = renderStrikethrough(cellStyle);
			boolean hasError = hasError(cell);

			int fontHeight = gc.getFontMetrics().getHeight();
			String text = convertDataType(cell, configRegistry);

			// Draw Text
			text = getTextToDisplay(cell, gc, rectangle.width, text);

			int numberOfNewLines = getNumberOfNewLines(text);

			//if the content height is bigger than the available row height
			//we're extending the row height (only if word wrapping is enabled)
			int contentHeight = (fontHeight * numberOfNewLines) + (spacing * 2);
			int contentToCellDiff = (cell.getBounds().height - rectangle.height);

			if(performRowResize(contentHeight, rectangle)) {
				ILayer layer = cell.getLayer();
				layer.doCommand(new RowResizeCommand(layer, cell.getRowPosition(), contentHeight + contentToCellDiff));
			}

			if(numberOfNewLines == 1) {
				int contentWidth = Math.min(getLengthFromCache(gc, text), rectangle.width);

				gc.drawText(text, rectangle.x + CellStyleUtil.getHorizontalAlignmentPadding(cellStyle, rectangle, contentWidth) + spacing, rectangle.y + CellStyleUtil.getVerticalAlignmentPadding(cellStyle, rectangle, contentHeight) + spacing, SWT.DRAW_TRANSPARENT | SWT.DRAW_DELIMITER);
				if(hasError || underline || strikethrough) {
					//start x of line = start x of text
					int x = rectangle.x + CellStyleUtil.getHorizontalAlignmentPadding(cellStyle, rectangle, contentWidth) + spacing;
					//y = start y of text
					int y = rectangle.y + CellStyleUtil.getVerticalAlignmentPadding(cellStyle, rectangle, contentHeight) + spacing;

					if(hasError) {
						//y = start y of text + font height 
						// - half of the font descent so the underline is between the baseline and the bottom
						int underlineY = y + fontHeight - (gc.getFontMetrics().getDescent() / 2);

						Color previousColor = gc.getForeground();
						gc.setForeground(GUIHelper.COLOR_RED);
						int startX = x;
						underlineY--;
						int index = 0;
						while(startX <= (x + gc.textExtent(text).x)) {
							gc.drawPoint(startX, underlineY + this.yErrorOffsets[(index % 4)]);
							index++;
							startX++;
						}
						gc.setForeground(previousColor);

					} else {

						//check and draw underline and strikethrough separately so it is possible to combine both
						if(underline) {
							//y = start y of text + font height 
							// - half of the font descent so the underline is between the baseline and the bottom
							int underlineY = y + fontHeight - (gc.getFontMetrics().getDescent() / 2);
							gc.drawLine(x, underlineY, x + gc.textExtent(text).x, underlineY);
						}

						if(strikethrough) {
							//y = start y of text + half of font height + ascent so lower case characters are
							//also strikethrough
							int strikeY = y + (fontHeight / 2) + (gc.getFontMetrics().getLeading() / 2);
							gc.drawLine(x, strikeY, x + gc.textExtent(text).x, strikeY);
						}
					}
				}
			} else {
				//draw every line by itself because of the alignment, otherwise the whole text
				//is always aligned right
				int yStartPos = rectangle.y + CellStyleUtil.getVerticalAlignmentPadding(cellStyle, rectangle, contentHeight);
				String[] lines = text.split("\n"); //$NON-NLS-1$
				for(String line : lines) {
					int lineContentWidth = Math.min(getLengthFromCache(gc, line), rectangle.width);

					gc.drawText(line, rectangle.x + CellStyleUtil.getHorizontalAlignmentPadding(cellStyle, rectangle, lineContentWidth) + spacing, yStartPos + spacing, SWT.DRAW_TRANSPARENT | SWT.DRAW_DELIMITER);
					if(hasError || underline || strikethrough) {
						//start x of line = start x of text
						int x = rectangle.x + CellStyleUtil.getHorizontalAlignmentPadding(cellStyle, rectangle, lineContentWidth) + spacing;
						//y = start y of text
						int y = yStartPos + spacing;

						if(hasError) {
							int underlineY = y + fontHeight - (gc.getFontMetrics().getDescent() / 2);
							Color previousColor = gc.getForeground();
							gc.setForeground(GUIHelper.COLOR_RED);
							int startX = x;
							underlineY--;
							int index = 0;
							while(startX <= (x + gc.textExtent(line).x)) {
								gc.drawPoint(startX, underlineY + this.yErrorOffsets[(index % 4)]);
								index++;
								startX++;
							}
							gc.setForeground(previousColor);

						} else {
							//check and draw underline and strikethrough separately so it is possible to combine both
							if(underline) {
								//y = start y of text + font height 
								// - half of the font descent so the underline is between the baseline and the bottom
								int underlineY = y + fontHeight - (gc.getFontMetrics().getDescent() / 2);
								gc.drawLine(x, underlineY, x + gc.textExtent(line).x, underlineY);
							}

							if(strikethrough) {
								//y = start y of text + half of font height + ascent so lower case characters are
								//also strikethrough
								int strikeY = y + (fontHeight / 2) + (gc.getFontMetrics().getLeading() / 2);
								gc.drawLine(x, strikeY, x + gc.textExtent(line).x, strikeY);
							}
						}
					}

					//after every line calculate the y start pos new
					yStartPos += fontHeight;
				}
			}

			gc.setClipping(originalClipping);
		}
	}

	/**
	 * 
	 * @param cell
	 *        a cell
	 * @return
	 *         <code>true</code> if the cell contents a Problem
	 */
	protected boolean hasError(final ILayerCell cell) {
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
		return hasError;
	}
}
