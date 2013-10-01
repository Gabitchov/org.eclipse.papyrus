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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.swt.graphics.Image;

/**
 * Provides stereotype and name management for {@link TimeObservationNodeFigure} and {@link DurationObservationNodeFigure}
 */
public class AbstractObservationNodeFigure extends NodeNamedElementFigure {

	/** Plug-in ID where UML2 icons can be found */
	public static final String ID = "org.eclipse.uml2.uml.edit"; //$NON-NLS-1$

	/** Icons relative path for UML2 elements in org.eclipse.uml2.uml.edit */
	public static final String PATH = "/icons/full/obj16/"; //$NON-NLS-1$

	/**
	 * Figure layout manager
	 * 
	 */
	protected class AbstractObservationLayoutManager extends AbstractLayout {

		/**
		 * 
		 * {@inheritDoc}
		 */
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {
			int minimumWidth = 0;
			int minimumHeight = 0;
			// Adapt the container to the contents
			for(int i = 0; i < container.getChildren().size(); i++) {
				// we ignore the stereotype Label and the qualified name label
				if(container.getChildren().get(i) instanceof Label) {
					// Do nothing
				} else {
					minimumHeight = minimumHeight + ((IFigure)container.getChildren().get(i)).getPreferredSize().height + 2;
					minimumWidth = minimumWidth + ((IFigure)container.getChildren().get(i)).getPreferredSize().width + 1;
				}
			}
			return new Dimension(minimumWidth, minimumHeight);
		}

		/**
		 * 
		 * {@inheritDoc}
		 */
		public void layout(IFigure container) {
			List<?> childrenList = container.getChildren();
			for(int i = 0; i < container.getChildren().size(); i++) {
				// stereotype and qualified name labels are not displayed
				if(container.getChildren().get(i) instanceof Label) {
					((IFigure)container.getChildren().get(i)).setVisible(false);
				}
				Rectangle bound = new Rectangle(((IFigure)childrenList.get(i)).getBounds());
				bound.setSize(((IFigure)childrenList.get(i)).getPreferredSize());
				if(i > 0) {
					bound.y = container.getBounds().y + 2;
					bound.x = container.getBounds().x + 2;
				}
				((IFigure)childrenList.get(i)).setBounds(bound);
			}
		}
	}

	/**
	 * Label for figure icon
	 */
	protected WrappingLabel iconLabel;

	/**
	 * Constructor
	 */
	public AbstractObservationNodeFigure() {
		super();
		this.iconLabel = new WrappingLabel("");
		this.add(this.iconLabel);
		ToolbarLayout toolbarLayout = new ToolbarLayout();
		toolbarLayout.setSpacing(5);
		toolbarLayout.setVertical(false);
		this.setLayoutManager(new AbstractObservationLayoutManager());
	}

	/**
	 * Get the figure icon container
	 * 
	 * @return the icon label
	 */
	public WrappingLabel getIconContainer() {
		return iconLabel;
	}

	/**
	 * Set the icon in the figure
	 * 
	 * @param image
	 */
	public void setIcon(Image image) {
		getIconContainer().setIcon(image, 0);
	}
}
