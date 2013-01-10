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
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;

public class EditPartUtils {

	public static EditPart findFirstChildEditPartWithId(final EditPart editPart, final int visualId) {
		final List<? extends EditPart> result = findChildEditPartsWithId(editPart, visualId);
		if(result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	public static List<? extends EditPart> findChildEditPartsWithId(final EditPart editPart, final int visualId) {
		final List<EditPart> editParts = new ArrayList<EditPart>();
		internalFindChildEditPartsWithId(editPart, visualId, editParts);
		return editParts;
	}

	private static void internalFindChildEditPartsWithId(final EditPart editPart, final int visualId, final List<EditPart> result) {
		final Object model = editPart.getModel();
		if(model instanceof View) {
			final View view = (View)model;
			if(UMLVisualIDRegistry.getVisualID(view) == visualId) {
				result.add(editPart);
			}
		}
		@SuppressWarnings("unchecked")
		final List<EditPart> children = editPart.getChildren();
		for(final EditPart child : children) {
			internalFindChildEditPartsWithId(child, visualId, result);
		}
	}

	public static EditPart findParentEditPartWithId(final EditPart editPart, final int visualId) {
		EditPart parent = editPart;
		while(parent != null) {
			final Object model = parent.getModel();
			if(model instanceof View) {
				final View parentView = (View)model;
				if(UMLVisualIDRegistry.getVisualID(parentView) == visualId) {
					return parent;
				}
				parent = parent.getParent();
			} else {
				break;
			}
		}
		return null;
	}

	/**
	 * Find the EditPart whose Figure is closest to the given y-coordinate.
	 * 
	 * @param ordinate
	 *        the y-coordinate
	 * @param editParts
	 *        the EditParts among which to choose
	 * @return the EditPart closest to the given vertical coordinate
	 */
	public static GraphicalEditPart findEditPartClosestToOrdinate(final int ordinate, final List<? extends GraphicalEditPart> editParts) {
		if(editParts.isEmpty()) {
			return null;
		}

		final TreeMap<Integer, GraphicalEditPart> distanceMap = new TreeMap<Integer, GraphicalEditPart>();
		for(final GraphicalEditPart editPart : editParts) {
			final IFigure figure = editPart.getFigure();
			final Rectangle bounds = new Rectangle(figure.getBounds());
			figure.getParent().translateToAbsolute(bounds);
			final int posY = bounds.y + bounds.height / 2;
			final int distance = Math.abs(posY - ordinate);
			distanceMap.put(Integer.valueOf(distance), editPart);
		}
		final Entry<Integer, GraphicalEditPart> firstEntry = distanceMap.firstEntry();
		return firstEntry.getValue();
	}

	public static boolean isEditPartFor(final EditPart editPart, final EClass... eClasses) {
		final Object model = editPart.getModel();
		if(model instanceof View) {
			final View view = (View)model;
			return ViewUtils.isViewFor(view, eClasses);
		}
		return false;
	}

	public static CompartmentEditPart findParentTimelineCompartment(final EditPart editPart) {
		CompartmentEditPart compartmentEditPart = (FullLifelineTimelineCompartmentEditPartCN)EditPartUtils.findParentEditPartWithId(editPart, FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID);
		if(compartmentEditPart == null) {
			compartmentEditPart = (CompactLifelineCompartmentEditPartCN)EditPartUtils.findParentEditPartWithId(editPart, CompactLifelineCompartmentEditPartCN.VISUAL_ID);
		}
		return compartmentEditPart;
	}

	/** Reveals the given EditPart in its viewer */
	public static void revealEditPart(final EditPart editPart) {
		if(editPart != null && editPart.getViewer() != null) {
			editPart.getViewer().reveal(editPart);
		}
	}
}
