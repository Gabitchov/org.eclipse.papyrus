/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.figure.node;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;

/**
 * <pre>
 * This class modifies findFigureAt method in order to make the figure responsive
 * when the cursor is located in a rectangle around the figure.
 * This behavior ease the creation of borderItem by allowing their creation even when
 * the selection is around the figure (not over it).
 * </pre>
 */
public class SelectableBorderedNodeFigure extends BorderedNodeFigure {

	/** The size of the active margin around the figure */
	protected int MARGIN_SIZE = 10;

	/** Constructor */
	public SelectableBorderedNodeFigure(IFigure mainFigure) {
		super(mainFigure);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		if(search.prune(this))
			return null;

		// Start by searching in the borderItemContainer
		IFigure result = getBorderItemContainer().findFigureAt(x, y, search);
		if(result != null) {
			return result;
		}

		// Then search over main figure borders with the specified MARGIN inside figure borders
		Rectangle unselectableArea = new Rectangle(getBounds().getCopy());
		unselectableArea.x = unselectableArea.x + MARGIN_SIZE;
		unselectableArea.y = unselectableArea.y + MARGIN_SIZE;
		unselectableArea.width = unselectableArea.width - 2*MARGIN_SIZE;
		unselectableArea.height = unselectableArea.height - 2*MARGIN_SIZE;

		Rectangle selectableArea = new Rectangle(getBounds().getCopy());

		if((selectableArea.contains(x, y)) && !(unselectableArea.contains(x, y))) {
			return this;
		}

		// Then search in the main figure
		result = getMainFigure().findFigureAt(x, y, search);
		if(result != null) {
			return result;
		}

		return null;
	}
}
