/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.layout.FreeFormLayoutEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.figure.node.InteractionRectangleFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.CompactLifelineFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.CrossFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.FullLifelineFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.SmallSquareFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.layouts.FillLayout;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.Constants;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.TickUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FreeTimeRulerCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TickEditPart;

public class CustomFreeTimeRulerCompartmentEditPart extends FreeTimeRulerCompartmentEditPart {

	public CustomFreeTimeRulerCompartmentEditPart(final View view) {
		super(view);
	}

	@Override
	public IFigure createFigure() {
		final ResizableCompartmentFigure result = (ResizableCompartmentFigure)super.createFigure();
		result.setTitleVisibility(false);
		result.setBorder(null);
		result.getScrollPane().setBorder(null);
		result.setLayoutManager(new FreeFormLayoutEx() {

			@Override
			public void layout(final IFigure container) {
				try {
					layoutTicks(container);
				} catch (final Exception e) {
					Activator.log.error("Error in ticks layout", e); //$NON-NLS-1$
				}
			}
		});
		return result;
	}

	/**
	 * Hide the scrollbar
	 * 
	 * @see http://wiki.eclipse.org/Papyrus_Developer_Guide/NoScrollbar
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		((ResizableCompartmentFigure)getFigure()).getScrollPane().setScrollBarVisibility(org.eclipse.draw2d.ScrollPane.NEVER);
		refreshBounds();
	}

	@Override
	public boolean isSelectable() {
		// No need to select the compartment.
		// This saves one click when selecting something inside.
		return false;
	}

	protected void layoutTicks(final IFigure container) {
		final EditPartViewer viewer = CustomFreeTimeRulerCompartmentEditPart.this.getRoot().getViewer();

		@SuppressWarnings("unchecked")
		final Map<IFigure, EditPart> visualPartMap = viewer.getVisualPartMap();
		final InteractionRectangleFigure interactionFigure = FigureUtils.findParentFigureInstance(container, InteractionRectangleFigure.class);
		final List<SmallSquareFigure> osFigures = FigureUtils.findChildFigureInstances(interactionFigure, SmallSquareFigure.class);
		final List<CrossFigure> destructionOSFigures = FigureUtils.findChildFigureInstances(interactionFigure, CrossFigure.class);

		final List<EditPart> osEditParts = new ArrayList<EditPart>();

		for(final SmallSquareFigure figure : osFigures) {
			final EditPart editPart = visualPartMap.get(FigureUtils.findParentFigureInstance(figure, BorderedNodeFigure.class));
			if(editPart != null) {
				osEditParts.add(editPart);
			}
		}
		for(final CrossFigure figure : destructionOSFigures) {
			final EditPart editPart = visualPartMap.get(FigureUtils.findParentFigureInstance(figure, BorderedNodeFigure.class));
			if(editPart != null) {
				osEditParts.add(editPart);
			}
		}

		// reset the layout so that the BorderItemsAwareFreeFormLayer fills its parent FreeformViewport
		if(!(container.getParent().getLayoutManager() instanceof FillLayout)) {
			container.getParent().setLayoutManager(new FillLayout());
		}

		// The grand-parent is a FreeformViewport, which lets its child expand outside of its clientArea, and
		// constantly resets the bounds (in org.eclipse.draw2d.FreeformViewport#readjustScrollBars)
		// So, layout based on the grand-parent's clientArea.
		// final Rectangle clientArea = container.getParent().getClientArea();
		@SuppressWarnings("unchecked")
		final List<IFigure> children = container.getChildren();

		for(int i = 0; i < children.size(); i++) {
			final IFigure child = children.get(i);
			final List<BorderedNodeFigure> marks = FigureUtils.findChildFigureInstances(child, BorderedNodeFigure.class);
			for(final BorderedNodeFigure verticalMarkFigure : marks) {
				final boolean compactLifeline = FigureUtils.findParentFigureInstance(verticalMarkFigure, CompactLifelineFigure.class) != null;
				final boolean fullLifeline = FigureUtils.findParentFigureInstance(verticalMarkFigure, FullLifelineFigure.class) != null;
				final TickEditPart tickEditPart = (TickEditPart)visualPartMap.get(verticalMarkFigure);
				final IGraphicalEditPart occurrenceSpecificationEditPart = TickUtils.findOccurrenceSpecificationEditPartFromTickEditPart(tickEditPart, viewer);
				if(occurrenceSpecificationEditPart != null) {
					final CompartmentEditPart timelineCompartment = EditPartUtils.findParentTimelineCompartment(occurrenceSpecificationEditPart);
					final GraphicalEditPart interactionEditPart = (InteractionEditPartTN)EditPartUtils.findParentEditPartWithId(timelineCompartment, InteractionEditPartTN.VISUAL_ID);
					final int startX;
					if(fullLifeline) {
						startX = Constants.STATE_DEFINITIONS_WIDTH + 1;
					} else if(compactLifeline) {
						startX = 1;
					} else {
						startX = timelineCompartment.getFigure().getBounds().x - interactionEditPart.getFigure().getBounds().x;
					}
					final Dimension markSize = verticalMarkFigure.getPreferredSize();
					final IFigure osFigure = occurrenceSpecificationEditPart.getFigure();
					final Rectangle osBounds = osFigure.getBounds();
					verticalMarkFigure.setBounds(new Rectangle(startX + osBounds.x - 1, 0, markSize.width, markSize.height));
				}
			}
		}
	}

}
