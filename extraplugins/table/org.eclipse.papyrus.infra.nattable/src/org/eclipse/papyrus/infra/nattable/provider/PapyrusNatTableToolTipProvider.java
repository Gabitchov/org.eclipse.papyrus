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
package org.eclipse.papyrus.infra.nattable.provider;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.tooltip.NatTableContentTooltip;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.internal.SharedImages;

/**
 * 
 * @author VL222926
 *         This class provides the tooltip to display in the table
 */
@SuppressWarnings("restriction")//$NON-NLS-1$
//suppress warning for SharedImages
public class PapyrusNatTableToolTipProvider extends NatTableContentTooltip {

	/**
	 * the shared images registry
	 */
	private final ISharedImages sharedImage = new SharedImages();

	/**
	 * 
	 * Constructor.
	 * 
	 * @param natTable
	 *        the nattable
	 * @param tooltipRegions
	 *        the region on which this tooltip provider will be applied
	 */
	public PapyrusNatTableToolTipProvider(final NatTable natTable, final String... tooltipRegions) {
		super(natTable, tooltipRegions);
	}

	/**
	 * 
	 * @see org.eclipse.jface.window.DefaultToolTip#getImage(org.eclipse.swt.widgets.Event)
	 * 
	 * @param event
	 * @return
	 */
	@Override
	protected Image getImage(Event event) {
		if(isCellWithError(event)) {
			return this.sharedImage.getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
		}
		return super.getImage(event);
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.tooltip.NatTableContentTooltip#getText(org.eclipse.swt.widgets.Event)
	 * 
	 * @param event
	 * @return
	 */
	@Override
	protected String getText(final Event event) {
		if(isCellWithError(event)) {
			final ILayerCell cell = getCell(event);
			return getProblemTooltip(cell.getDataValue());
		} else {
			return super.getText(event);
		}
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	protected String getProblemTooltip(final Object value) {
		ProblemLabelProvider provider = new ProblemLabelProvider();
		if(value instanceof Problem) {
			return provider.getTooltipText((EObject)value);
		} else if(value instanceof Collection<?>) {
			final StringBuilder builder = new StringBuilder();
			final Iterator<?> iter = ((Collection<?>)value).iterator();
			while(iter.hasNext()) {
				final Object current = iter.next();
				if(current instanceof Problem){
					builder.append(provider.getTooltipText((EObject)current));
				}
				if(iter.hasNext()){
					builder.append("\n"); //$NON-NLS-1$
				}
			}
			return builder.toString();
		}
		return null;
	}

	/**
	 * 
	 * @param event
	 *        an event
	 * @return
	 *         the cell for this event
	 */
	protected ILayerCell getCell(final Event event) {
		int col = this.natTable.getColumnPositionByX(event.x);
		int row = this.natTable.getRowPositionByY(event.y);
		return this.natTable.getCellByPosition(col, row);
	}

	/**
	 * 
	 * @param event
	 *        an event
	 * @return
	 *         <code>true</code> if the cell have a problem
	 */
	protected boolean isCellWithError(final Event event) {
		final ILayerCell cell = getCell(event);
		boolean hasError = false;
		if(cell != null) {
			final Object value = cell.getDataValue();
			if(value instanceof Problem) {
				hasError = true;
			} else if(value instanceof Collection<?>) {
				final Iterator<?> iter = ((Collection<?>)value).iterator();
				while(!hasError && iter.hasNext()) {
					hasError = iter.next() instanceof Problem;
				}
			}
		}
		return hasError;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.tooltip.NatTableContentTooltip#shouldCreateToolTip(org.eclipse.swt.widgets.Event)
	 * 
	 * @param event
	 * @return
	 */
	@Override
	protected boolean shouldCreateToolTip(final Event event) {
		if(isCellWithError(event)) {
			return true;
		}
		if(!isDisplayingFullCellText(event)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param event
	 *        an event
	 * @return
	 *         <code>true</code> if the cell size allow to display the full text
	 */
	protected boolean isDisplayingFullCellText(final Event event) {
		return true;//TODO : display a tooltip when the full text is not displayed in the cell
	}
}
