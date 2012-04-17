/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.figure;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;

/**
 * this figure is the representation of a subject in the usecase diagram
 * 
 */
public class UseCaseClassifierFigure extends NodeNamedElementFigure {

	private final RectangleFigure shapeCompartment;

	/**
	 * this is the layout manager in charge to place element in the enumeration
	 * 
	 */
	private class SubjectLayoutManager extends AbstractLayout {

		/**
		 * gap in x to display name stereotypes and qualified name
		 */
		protected final int GAP_X = 10;

		/**
		 * gap in y to display the first label at the top of the package
		 */
		protected final int GAP_Y = 5;

		/**
		 * 
		 * {@inheritDoc}
		 */
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {
			int minimumWith = 0;
			int minimumHeight = 0;
			// display name
			if(getNameLabel() != null) {
				if(getNameLabel().getPreferredSize().width > minimumWith) {
					minimumWith = getNameLabel().getPreferredSize().width;
				}
				minimumHeight += getNameLabel().getPreferredSize().height;
			}
			return new Dimension(minimumWith, minimumHeight);
		}

		/**
		 * 
		 * {@inheritDoc}
		 */
		public void layout(IFigure container) {
			List childrenList = container.getChildren();
			for(int i = 0; i < container.getChildren().size(); i++) {
				Rectangle bound = new Rectangle(((IFigure)childrenList.get(i)).getBounds());
				IFigure fig = ((IFigure)childrenList.get(i));
				fig.invalidate();
				Dimension pref = ((IFigure)childrenList.get(i)).getPreferredSize();
				fig.invalidate();
				Dimension prefConstraint = ((IFigure)childrenList.get(i)).getPreferredSize(container.getBounds().width, -1);
				bound.setSize(prefConstraint);
				if(i > 0) {
					bound.y = ((IFigure)childrenList.get(i - 1)).getBounds().getBottomLeft().y + 1;
					bound.x = getBounds().x + GAP_X;
				} else {
					bound.x = getBounds().x + GAP_X;
					bound.y = getBounds().y + GAP_Y;
				}
				((IFigure)childrenList.get(i)).setBounds(bound);
			}
			// container
			Rectangle lastRectangle = getExtensionPointContainerFigure().getBounds();
			lastRectangle.height = getBounds().y + getBounds().height - lastRectangle.y;
			lastRectangle.x = container.getBounds().x;
			lastRectangle.width = getBounds().width;
			//getPackageableElementFigure().setBounds(lastRectangle);
			if(getGMFExtensionPointContainerFigure() != null) {
				//getGMFPackageableElementContainer().setBounds(lastRectangle);
			}
		}
	}

	public UseCaseClassifierFigure() {
		super();
		setLayoutManager(new SubjectLayoutManager());
		setOpaque(false);
		shapeCompartment = new RectangleFigure();
		add(shapeCompartment);
		getExtensionPointContainerFigure().setFill(false);
	}

	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	public org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure getGMFExtensionPointContainerFigure() {
		if(shapeCompartment.getChildren().size() > 0) {
			return (org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure)shapeCompartment.getChildren().get(0);
		}
		return null;
	}

	public RectangleFigure getExtensionPointContainerFigure() {
		return shapeCompartment;
	}
}
