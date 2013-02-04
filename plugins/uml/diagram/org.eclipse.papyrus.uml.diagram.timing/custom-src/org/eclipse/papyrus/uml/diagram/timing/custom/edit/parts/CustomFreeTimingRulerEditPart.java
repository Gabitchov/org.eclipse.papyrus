/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.TimingRulerFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.layouts.FillLayout;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FreeTimingRulerEditPartCN;

public class CustomFreeTimingRulerEditPart extends FreeTimingRulerEditPartCN {

	public CustomFreeTimingRulerEditPart(final View view) {
		super(view);
	}

	@Override
	protected IFigure createNodeShape() {
		this.primaryShape = new TimingRulerFigure();
		this.primaryShape.setLayoutManager(new FillLayout() {

			@Override
			public void layout(final IFigure container) {
				for(final Object child : container.getChildren()) {
					((IFigure)child).setBounds(container.getBounds());
				}
				final ShapeCompartmentFigure compartmentFigure = FigureUtils.findChildFigureInstance(container, ShapeCompartmentFigure.class);
				if(compartmentFigure != null) {
					for(final Object child : compartmentFigure.getChildren()) {
						if(child instanceof ScrollPane) {
							((ScrollPane)child).setBounds(container.getBounds());
							// ((ScrollPane) child).setBorder(null);
							((ScrollPane)child).setScrollBarVisibility(org.eclipse.draw2d.ScrollPane.NEVER);
							// ((ScrollPane) child).getViewport().setBounds(container.getBounds());
						}
					}
					compartmentFigure.setBounds(container.getBounds());
				}
			}
		});

		return this.primaryShape;
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	@Override
	public DragTracker getDragTracker(final Request request) {
		// lock the drag to the containing compartment
		return new DragEditPartsTrackerEx(this) {

			@Override
			protected boolean handleDragStarted() {
				lockTargetEditPart(CustomFreeTimingRulerEditPart.this.getParent());
				return super.handleDragStarted();
			}
		};
	}
}
