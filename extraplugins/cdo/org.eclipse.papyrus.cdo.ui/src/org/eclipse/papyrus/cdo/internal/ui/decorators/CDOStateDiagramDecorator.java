/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.decorators;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.dawn.appearance.DawnElementStylizer;
import org.eclipse.emf.cdo.dawn.spi.DawnState;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.swt.graphics.Image;

/**
 * A GMF-based label decorator for diagram views, to annotate them to indicate
 * CDO locking and transaction conflict states.
 */
public class CDOStateDiagramDecorator
		extends AbstractDecorator {

	private DawnElementStylizer stylizer;

	public CDOStateDiagramDecorator(IDecoratorTarget decoratorTarget,
			DawnElementStylizer stylizer) {
		super(decoratorTarget);

		this.stylizer = stylizer;
	}

	public void activate() {
		// pass
	}

	public void refresh() {
		removeDecoration();

		View view = (View) getDecoratorTarget().getAdapter(View.class);
		EObject element = ((view == null) || !view.isSetElement())
			? null
			: view.getElement();
		CDOObject cdo = (element == null)
			? null
			: CDOUtils.getCDOObject(element);
		if (cdo != null) {
			EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(
				EditPart.class);

			// does the view, itself, have a conflict or lock state?
			DawnState state = CDOStateAdapter.getState(view);
			if (state == DawnState.CLEAN) {
				// infer a state from the semantic element, then
				state = CDOStateAdapter.getState(element);
			}

			Image image = stylizer.getImage(editPart, state);

			if (image != null) {
				if (editPart instanceof ShapeEditPart) {
					int margin = MapModeUtil.getMapMode(
						((GraphicalEditPart) editPart).getFigure()).DPtoLP(-1);
					setDecoration(getDecoratorTarget().addShapeDecoration(
						image, Direction.SOUTH_EAST, margin, true));
				} else if (view instanceof Edge) {
					int percent = 50;
					setDecoration(getDecoratorTarget().addConnectionDecoration(
						image, percent, true));
				}
			}
		}
	}

}
