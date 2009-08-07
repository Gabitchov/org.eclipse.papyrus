/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.custom.figures;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

/**
 * Figure for Composite representation of Class.
 */
public class CompositeFigure extends NodeNamedElementFigure {

	/**
	 * Layout manager for the Composite figure
	 */
	private class CompositeLayoutManager extends AbstractLayout {

		/**
		 * Space separation between figure Top border and first child
		 */
		private int UPPER_SPACE = 2;

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {
			// Return preferred size of the name label
			return getNameLabel().getPreferredSize();
		}

		/**
		 * {@inheritDoc}
		 */
		public void layout(IFigure container) {

			// Update Figure children bounds (labels, containers...)
			List<?> childrenList = container.getChildren();
			for (int i = 0; i < childrenList.size(); i++) {

				// Initialize child bounds
				IFigure currentChild = (IFigure) childrenList.get(i);
				Rectangle oldBounds = ((IFigure) childrenList.get(i)).getBounds();
				Rectangle newBounds = new Rectangle(oldBounds);

				// Update child size
				newBounds.setSize(currentChild.getPreferredSize());
				newBounds.width = getBounds().width;

				// Update child position
				if (i > 0) {
					// Calculate position based on the above child
					IFigure previousChild = (IFigure) childrenList.get(i - 1);
					int previousChildY = previousChild.getBounds().getBottomLeft().y;

					newBounds.x = getBounds().x;
					newBounds.y = previousChildY + 1;
				} else {
					// First child, placed in the upper left corner
					newBounds.x = getBounds().x;
					newBounds.y = getBounds().y + UPPER_SPACE;
					// UPPER_SEPARATION adds a vertical empty space before the
					// first child.
					// This is used to avoid element icon to appear on the
					// border
					// when no qualified name is shown
				}

				// Set calculated bounds in current child
				currentChild.setBounds(newBounds);
			}

			// Update Composite compartment bounds
			if (getCompositeCompartmentFigure() != null) {

				// Initialize compartment bounds
				Rectangle oldCompositeBound = getCompositeCompartmentFigure().getBounds();
				Rectangle newCompositeBound = new Rectangle(oldCompositeBound);

				// Update compartment size taking above children into account
				newCompositeBound.height = getBounds().y + getBounds().height - oldCompositeBound.y;
				newCompositeBound.width = getBounds().width;

				// Set calculated bounds in Composite compartment
				getCompositeCompartmentFigure().setBounds(newCompositeBound);
			}
		}
	}

	/**
	 * Composite compartment of the figure
	 */
	private RectangleFigure compositeCompartment;

	/**
	 * Optional Tag Label for the figure. May be used by inherited figures (ex:
	 * {@link InterfaceCompositeFigure}) to add a stereotype like label describing element type (ex:
	 * <<Interface>>).
	 */
	private Label tagLabel;

	/**
	 * Creates a new CompositeFigure.
	 * 
	 * <pre>
	 * 	 +-------------------+
	 * 	 |   [Stereotypes]   | - Child 0
	 * 	 |  [QualifiedName]  | - Child 1
	 * 	 |    [ClassName]    | - ...
	 * 	 +-------------------+
	 * 	 |                   |
	 * 	 |     +------+      | - CompositeContainer
	 * 	 |     | Part |      |
	 * 	 |     +------+      |
	 * 	 |                   |
	 * 	 +-------------------+
	 * </pre>
	 */
	public CompositeFigure() {
		super();
		setLayoutManager(new CompositeLayoutManager());

		// Add internal Compartment figure
		compositeCompartment = new RectangleFigure();
		this.add(compositeCompartment);
	}

	/**
	 * Get the Composite compartment of the figure
	 * 
	 * @return the composite compartment
	 */
	public RectangleFigure getCompositeCompartmentFigure() {
		return compositeCompartment;
	}

	/**
	 * Initialize tagLabel with the keyword parameter
	 * 
	 * @param keyword
	 *            the string to show in label
	 */
	protected void createTagLabel(String keyword) {

		// Retrieve current figure font
		FontData[] fontdata = { new FontData("Arial", 12, SWT.NORMAL) };
		Font font = Activator.fontManager.get(fontdata);

		// Create the TagLabel
		tagLabel = new Label();
		tagLabel.setFont(font);
		tagLabel.setForegroundColor(getForegroundColor());
		tagLabel.setOpaque(false);
		tagLabel.setText(Activator.ST_LEFT + keyword + Activator.ST_RIGHT);

		// Add the tag label to the figure at the position 0
		this.add(tagLabel, 0);
	}
}
