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
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineDotLineCustomFigure;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.PartDecomposition;
import org.eclipse.uml2.uml.UMLPackage;

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
		if(obj instanceof Shape) {
			// we get the element linked to this editpart
			EObject element = ((Shape)obj).getElement();

			if(element instanceof InteractionFragment) {
				// we get the list of the covered lifelinnes by the InteractionUse
				List<Lifeline> lifelineCoveredList = ((InteractionFragment)element).getCovereds();

				if(lifelineCoveredList != null && getParent() != null) {
					// we get the interactionCompartimentEditPart to have access to all lifelines
					// EditParts
					List<EditPart> childrenEditPart = getParent().getChildren();
					if(childrenEditPart != null) {
						// The max value guarantee that the first figure will set the minX value
						int minX = Integer.MAX_VALUE;
						int maxX = -Integer.MAX_VALUE;
						int maxR = -Integer.MAX_VALUE;

						for(EditPart childEditPart : childrenEditPart) {
							// we check all the EditParts to select only the lifelineEditParts
							if(childEditPart instanceof LifelineEditPart) {
								Object childModel = childEditPart.getModel();
								if(childModel instanceof Shape) {
									// we get the object Lifeline linked the selected
									// lifelineEditPart
									EObject childElement = ((Shape)childModel).getElement();
									if(childElement instanceof Lifeline) {
										Lifeline lifeline = (Lifeline)childElement;
										for(Lifeline lfn : lifelineCoveredList) {
											// we check if the lifeLine in the intreactionUse's
											// parent Interaction is a covered Lifeline
											if(lifeline.equals(lfn)) {
												LifelineEditPart liflelineEditPart = (LifelineEditPart)childEditPart;
												if(liflelineEditPart.getFigure().getBounds().x > maxX) {
													maxX = liflelineEditPart.getFigure().getBounds().x;
													// the maxR will represent the futur value of
													// the rectangle right value.
													maxR = liflelineEditPart.getFigure().getBounds().right();

												}
												if(liflelineEditPart.getFigure().getBounds().x < minX) {
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

						if(minX != Integer.MAX_VALUE || maxR != -Integer.MAX_VALUE) {
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
	 *        the min x position of a covered lifline
	 * @param max
	 *        the max x position of a coverd lifeline
	 * 
	 */
	private void getNewSize(int min, int max) {
		int h = getFigure().getBounds().height;
		int y = getFigure().getBounds().y;

		Dimension size = new Dimension(max - min, h);

		Point loc = new Point(min, y);

		((GraphicalEditPart)getParent()).setLayoutConstraint(this, getFigure(), new Rectangle(loc, size));
	}

	/**
	 * Update covered lifelines of a Interaction fragment
	 * 
	 * @param newBounds
	 */
	public void updateCoveredLifelines(Bounds newBounds) {
		Rectangle newBound = new Rectangle(newBounds.getX(), newBounds.getY(), newBounds.getWidth(), newBounds.getHeight());
		InteractionFragment combinedFragment = (InteractionFragment)resolveSemanticElement();
		EList<Lifeline> coveredLifelines = combinedFragment.getCovereds();

		List<Lifeline> coveredLifelinesToAdd = new ArrayList<Lifeline>();
		List<Lifeline> coveredLifelinesToRemove = new ArrayList<Lifeline>();
		EditPart interactionCompartment = getInteractionCompartment();
		if(interactionCompartment != null) {
			this.getFigure().translateToAbsolute(newBound);
			for(Object child : interactionCompartment.getChildren()) {
				if(child instanceof LifelineEditPart) {
					LifelineEditPart lifelineEditPart = (LifelineEditPart)child;
					updateCoveredLifelines(lifelineEditPart, newBound, coveredLifelinesToAdd, coveredLifelinesToRemove, coveredLifelines);
				}
			}
		}
		if(!coveredLifelinesToAdd.isEmpty()) {
			CommandHelper.executeCommandWithoutHistory(getEditingDomain(), AddCommand.create(getEditingDomain(), combinedFragment, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), coveredLifelinesToAdd), true);
		}
		if(!coveredLifelinesToRemove.isEmpty()) {
			CommandHelper.executeCommandWithoutHistory(getEditingDomain(), RemoveCommand.create(getEditingDomain(), combinedFragment, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), coveredLifelinesToRemove), true);
		}

	}

	// check lifelines in PartDecomposition, see bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=364813
	private void updateCoveredLifelines(LifelineEditPart lifelineEditPart, Rectangle newBound, List<Lifeline> coveredLifelinesToAdd, List<Lifeline> coveredLifelinesToRemove, EList<Lifeline> coveredLifelines) {
		Lifeline lifeline = (Lifeline)lifelineEditPart.resolveSemanticElement();

		LifelineDotLineCustomFigure dotLineFigure = lifelineEditPart.getPrimaryShape().getFigureLifelineDotLineFigure();
		Rectangle dotLineBounds = dotLineFigure.getBounds().getCopy();
		Rectangle centralLineBounds = new Rectangle(dotLineBounds.x() + dotLineBounds.width() / 2, dotLineBounds.y(), 1, dotLineBounds.height());
		dotLineFigure.translateToAbsolute(centralLineBounds);
		if(newBound.intersects(centralLineBounds)) {
			if(!coveredLifelines.contains(lifeline)) {
				coveredLifelinesToAdd.add(lifeline);
			}
		} else if(coveredLifelines.contains(lifeline)) {
			coveredLifelinesToRemove.add(lifeline);
		}

		PartDecomposition partDecomposition = lifeline.getDecomposedAs();
		if(partDecomposition != null) {
			List subLifelines = lifelineEditPart.getChildren();
			for(Object child : subLifelines) {
				if(child instanceof LifelineEditPart) {
					updateCoveredLifelines((LifelineEditPart)child, newBound, coveredLifelinesToAdd, coveredLifelinesToRemove, coveredLifelines);
				}
			}
		}
	}

	/**
	 * Find parent editpart of lifeline
	 * 
	 * @return EditPart
	 */
	public EditPart getInteractionCompartment() {
		EditPart editPart = getParent();
		while(editPart != null && !(editPart instanceof InteractionInteractionCompartmentEditPart)) {
			editPart = editPart.getParent();
		}
		return editPart;
	}

}
