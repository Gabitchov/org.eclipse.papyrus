/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.FullLifelineFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.parts.FloatingMessageAnchor;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.Constants;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.MessageUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;

public class CustomFullLifelineEditPartCN extends FullLifelineEditPartCN {

	public CustomFullLifelineEditPartCN(final View view) {
		super(view);
	}

	@Override
	public void setSelected(final int value) {
		super.setSelected(value);
		// set selection on figure
		final FullLifelineFigure lifelineFigure = FigureUtils.findChildFigureInstance(getFigure(), FullLifelineFigure.class);
		lifelineFigure.setSelected(value != EditPart.SELECTED_NONE);
		// repaint
		getFigure().getParent().repaint();
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure nodeFigure = super.createNodeFigure();
		final FullLifelineFigure lifelineFigure = FigureUtils.findChildFigureInstance(nodeFigure, FullLifelineFigure.class);
		// collapses the time ruler rectangle if the time ruler is not used
		lifelineFigure.getLifelineDataContainerFigure().setLayoutManager(new AbstractLayout() {
			public void layout(final IFigure container) {
				final int timeRulerHeight = Constants.TIME_RULER_HEIGHT;
				final boolean displayTimeRuler = lifelineFigure.isDisplayTimeRuler();
				final Rectangle clientArea = container.getClientArea();
				@SuppressWarnings("unchecked")
				final List<IFigure> children = container.getChildren();
				for (int i = 0; i < children.size(); i++) {
					final IFigure child = children.get(i);
					if (child == lifelineFigure.getChronogramContainerFigure()) {
						if (displayTimeRuler) {
							child.setBounds(new Rectangle(clientArea).getResized(0, -timeRulerHeight));
						} else {
							child.setBounds(clientArea);
						}
					} else if (child == lifelineFigure.getTimeRulerContainerFigure()) {
						if (displayTimeRuler) {
							final Rectangle bounds = new Rectangle(clientArea);
							bounds.height = timeRulerHeight;
							bounds.y = clientArea.y + clientArea.height - timeRulerHeight;
							child.setBounds(bounds);
						} else {
							child.setBounds(new Rectangle(clientArea.x, clientArea.y + clientArea.height, clientArea.width, 0));
						}
					}
				}
			}

			@Override
			protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
				return new Dimension(-1, -1);
			}
		});
		return nodeFigure;
	}

	@Override
	public DragTracker getDragTracker(final Request request) {
		// lock the drag to the containing compartment
		return new DragEditPartsTrackerEx(this) {
			@Override
			protected boolean handleDragStarted() {
				lockTargetEditPart(CustomFullLifelineEditPartCN.this.getParent());
				return super.handleDragStarted();
			}
		};
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(final ConnectionEditPart connEditPart) {
		return new FloatingMessageAnchor(connEditPart, new Point(20, -20));
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(final ConnectionEditPart connEditPart) {
		return new FloatingMessageAnchor(connEditPart, new Point(-20, 20));
	}

	/** Display feedback at the start location (where the create request was started) */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(final Request request) {
		if (request instanceof CreateRequest) {
			return new XYAnchor(MessageUtils.getLastStartLocation());
		}
		return super.getTargetConnectionAnchor(request);
	}

	/** Display feedback at the cursor location */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(final Request request) {
		if (request instanceof LocationRequest) {
			final LocationRequest locationRequest = (LocationRequest) request;
			return new XYAnchor(locationRequest.getLocation());
		}
		return super.getTargetConnectionAnchor(request);
	}

}
