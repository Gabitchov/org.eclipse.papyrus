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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.CompactLifelineFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.FullLifelineFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.layouts.FillLayout;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.Constants;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionCompartmentEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionEditPart;

public class CustomInteractionCompartmentEditPartTN extends InteractionCompartmentEditPartTN {

	public CustomInteractionCompartmentEditPartTN(final View view) {
		super(view);
	}

	@Override
	public IFigure createFigure() {
		final ResizableCompartmentFigure result = (ResizableCompartmentFigure)super.createFigure();
		result.setTitleVisibility(false);
		result.setBorder(null);

		result.setLayoutManager(new FillLayout());
		// each lifeline takes a height proportional to its number of states
		result.getContentPane().setLayoutManager(new AbstractLayout() {

			public void layout(final IFigure container) {
				@SuppressWarnings("unchecked")
				final List<IFigure> children = container.getChildren();
				final Rectangle clientArea = container.getClientArea();
				final Map<IFigure, Integer> numberOfStates = computeNumberOfStates(children);
				double totalStates = 0;
				for(final Integer nStates : numberOfStates.values()) {
					totalStates += Math.max(nStates.intValue(), 1);
				}
				int y = clientArea.y;
				final int totalHeight = clientArea.height - Constants.MARGIN_BETWEEN_LIFELINES * (children.size() - 1);
				for(final IFigure child : children) {
					final Integer nStates = numberOfStates.get(child);
					if(nStates != null) {
						final int height = (int)(totalHeight * (Math.max(nStates.doubleValue(), 1) / totalStates));
						child.setBounds(new Rectangle(clientArea.x, y, clientArea.width, height));
						y += height + Constants.MARGIN_BETWEEN_LIFELINES;
					}
				}
			}

			@Override
			protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
				return new Dimension(-1, -1);
			}
		});

		return result;
	}

	protected Map<IFigure, Integer> computeNumberOfStates(final List<IFigure> children) {
		final LinkedHashMap<IFigure, Integer> numberOfStatesPerLifeline = new LinkedHashMap<IFigure, Integer>();
		final EditPartViewer viewer = CustomInteractionCompartmentEditPartTN.this.getRoot().getViewer();
		for(int i = 0; i < children.size(); i++) {
			final IFigure child = children.get(i);
			if(FigureUtils.findChildFigureInstance(child, FullLifelineFigure.class) != null) {
				@SuppressWarnings("unchecked")
				final Map<IFigure, EditPart> visualPartMap = viewer.getVisualPartMap();
				final FullLifelineEditPartCN lifelineEditPart = (FullLifelineEditPartCN)visualPartMap.get(child);
				final View lifelineView = (View)lifelineEditPart.getModel();
				final int nStates = findNumberOfStatesDisplayedIn(lifelineView);
				numberOfStatesPerLifeline.put(child, Integer.valueOf(nStates));
			} else if(FigureUtils.findChildFigureInstance(child, CompactLifelineFigure.class) != null) {
				numberOfStatesPerLifeline.put(child, Integer.valueOf(1));
			} else {
				Activator.log.warn("Only instances of " + FullLifelineFigure.class.getSimpleName() + " are expected in the compartment " + CustomInteractionCompartmentEditPartTN.class.getSimpleName()); //$NON-NLS-1$//$NON-NLS-2$
				continue;
			}

		}
		return numberOfStatesPerLifeline;
	}

	protected static int findNumberOfStatesDisplayedIn(final View lifelineView) {
		int n = 0;
		final View stateDefinitionCompartment = ViewUtils.findStateDefinitionCompartmentView(lifelineView);
		@SuppressWarnings("unchecked")
		final EList<View> children = stateDefinitionCompartment.getChildren();
		final String stateDefID = Integer.toString(StateDefinitionEditPart.VISUAL_ID);
		for(final View view : children) {
			if(stateDefID.equals(view.getType())) {
				n++;
			}
		}
		return n;
	}

	@Override
	public boolean isSelectable() {
		// No need to select the compartment.
		// This saves one click when selecting something inside.
		return false;
	}
}
