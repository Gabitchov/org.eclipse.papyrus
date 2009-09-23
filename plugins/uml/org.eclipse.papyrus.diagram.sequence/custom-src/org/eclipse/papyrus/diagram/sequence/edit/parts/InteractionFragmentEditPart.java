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
 *   Atos Origin - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.parts;

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;

public abstract class InteractionFragmentEditPart extends ShapeNodeEditPart {

	public InteractionFragmentEditPart(View view) {
		super(view);
	}

	/**
	 * Resize the InteractionFragmentFigure when the covered lifelines are selected in the
	 * properties view.
	 */
	public void resizeInteractionFragmentFigure() {
		Object obj = getModel();
		if (obj instanceof Shape) {
			// we get the element linked to this editpart
			EObject element = ((Shape) obj).getElement();

			if (element instanceof InteractionFragment) {
				// we get the list of the covered lifelinnes by the InteractionUse
				List<Lifeline> lifelineCoveredList = ((InteractionFragment) element).getCovereds();

				if (lifelineCoveredList != null && getParent() != null) {
					// we get the interactionCompartimentEditPart to have access to all lifelines
					// EditParts
					List<EditPart> childrenEditPart = getParent().getChildren();
					if (childrenEditPart != null) {
						// The max value guarantee that the first figure will set the minX value
						int minX = Integer.MAX_VALUE;
						int maxX = -Integer.MAX_VALUE;
						int maxR = -Integer.MAX_VALUE;

						for (EditPart childEditPart : childrenEditPart) {
							// we check all the EditParts to select only the lifelineEditParts
							if (childEditPart instanceof LifelineEditPart) {
								Object childModel = childEditPart.getModel();
								if (childModel instanceof Shape) {
									// we get the object Lifeline linked the selected
									// lifelineEditPart
									EObject childElement = ((Shape) childModel).getElement();
									if (childElement instanceof Lifeline) {
										Lifeline lifeline = (Lifeline) childElement;
										for (Lifeline lfn : lifelineCoveredList) {
											// we check if the lifeLine in the intreactionUse's
											// parent Interaction is a covered Lifeline
											if (lifeline.equals(lfn)) {
												LifelineEditPart liflelineEditPart = (LifelineEditPart) childEditPart;
												if (liflelineEditPart.getFigure().getBounds().x > maxX) {
													maxX = liflelineEditPart.getFigure().getBounds().x;
													// the maxR will represent the futur value of
													// the rectangle right value.
													maxR = liflelineEditPart.getFigure().getBounds().right();

												}
												if (liflelineEditPart.getFigure().getBounds().x < minX) {
													// the min value will represent the rectangle x
													// value.
													minX = liflelineEditPart.getFigure().getBounds().x;
												}
											}
										}
									}
								}
							}
						}

						if (minX != Integer.MAX_VALUE || maxR != -Integer.MAX_VALUE) {
							// after this loop we have the coordinate of two lifeline figure ,
							// even if we have more than two covered Lifelne we choose the
							// extremities.
							getNewSize(minX, maxR);
						}
					}
				}
			}
		}
	}

	/**
	 * resize the interactinUse figure
	 * 
	 * @param min
	 *            the min x position of a covered lifline
	 * @param max
	 *            the max x position of a coverd lifeline
	 * 
	 */
	protected void getNewSize(int min, int max) {
		int h = getFigure().getBounds().height;
		int y = getFigure().getBounds().y;

		Dimension size = new Dimension(max - min, h);

		Point loc = new Point(min, y);

		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), new Rectangle(loc, size));
	}

}
