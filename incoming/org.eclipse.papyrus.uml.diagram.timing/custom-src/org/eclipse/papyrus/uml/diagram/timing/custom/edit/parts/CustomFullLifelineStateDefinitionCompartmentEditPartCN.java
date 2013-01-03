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

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.layouts.FillLayout;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineStateDefinitionCompartmentEditPartCN;

public class CustomFullLifelineStateDefinitionCompartmentEditPartCN extends FullLifelineStateDefinitionCompartmentEditPartCN {

	private WrappingLabel stateDefsAffordanceLabel;

	public CustomFullLifelineStateDefinitionCompartmentEditPartCN(final View view) {
		super(view);
	}

	@Override
	public IFigure createFigure() {
		final ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setBorder(null);
		result.getScrollPane().getContents().setBorder(null);

		result.setLayoutManager(new StackLayout());

		// layout StateDefinitions so that they are regularly spaced and fill the whole height
		result.getContentPane().setLayoutManager(new XYLayout() {
			@Override
			public void layout(final IFigure container) {
				// reset the layout so that the BorderItemsAwareFreeFormLayer fills its parent FreeformViewport
				if (!(container.getParent().getLayoutManager() instanceof FillLayout)) {
					container.getParent().setLayoutManager(new FillLayout());
				}

				// The grand-parent is a FreeformViewport, which lets its child expand outside of its clientArea, and
				// constantly resets the bounds (in org.eclipse.draw2d.FreeformViewport#readjustScrollBars)
				// So, layout based on the grand-parent's clientArea.
				final Rectangle clientArea = container.getParent().getClientArea();
				final int nChildren = container.getChildren().size();
				final int margin;
				final int spacing;
				if (nChildren == 1) {
					margin = clientArea.height / 2;
					spacing = 0;
				} else {
					margin = clientArea.height / (nChildren - 1) / 3;
					spacing = (clientArea.height - 2 * margin) / (nChildren - 1);
				}

				for (int i = 0; i < nChildren; i++) {
					final IFigure child = (IFigure) container.getChildren().get(i);
					final Dimension ps = child.getPreferredSize();
					final int w = ps.width;
					// the height is twice as big as needed by default
					final int h = ps.height / 2;
					final int x = clientArea.x + clientArea.width / 2 - w / 2;
					final int y = clientArea.y + margin + spacing * i - h / 2;
					child.setBounds(new Rectangle(x, y, w, h));
				}
			}

			@Override
			protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
				return null;
			}
		});
		result.setTitleVisibility(false);
		createStateDefsAffordanceLabel(result);
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
		((ResizableCompartmentFigure) getFigure()).getScrollPane().setScrollBarVisibility(org.eclipse.draw2d.ScrollPane.NEVER);
		refreshBounds();
	}

	@Override
	public boolean isSelectable() {
		// No need to select the compartment.
		// This saves one click when selecting something inside.
		return false;
	}

	/**
	 * Display a Label when there are no StateDefinitions, so that the user knows that they must add at least a
	 * StateDefinition.
	 */
	private void createStateDefsAffordanceLabel(final IFigure parent) {
		this.stateDefsAffordanceLabel = new WrappingLabel();
		this.stateDefsAffordanceLabel.setTextWrap(true);
		this.stateDefsAffordanceLabel.setAlignment(PositionConstants.CENTER);
		this.stateDefsAffordanceLabel.setTextJustification(PositionConstants.CENTER);
		this.stateDefsAffordanceLabel.setText(Messages.CustomFullLifelineStateDefinitionCompartmentEditPartCN_AddStateDefinitionsHere);
		this.stateDefsAffordanceLabel.setForegroundColor(ColorConstants.gray);
		parent.add(this.stateDefsAffordanceLabel);
		this.stateDefsAffordanceLabel.setBounds(new Rectangle(parent.getBounds()));
		this.stateDefsAffordanceLabel.setVisible(false);
	}

	@Override
	protected void refreshChildren() {
		super.refreshChildren();
		this.stateDefsAffordanceLabel.setVisible(getChildren().size() == 0);
	}
}
