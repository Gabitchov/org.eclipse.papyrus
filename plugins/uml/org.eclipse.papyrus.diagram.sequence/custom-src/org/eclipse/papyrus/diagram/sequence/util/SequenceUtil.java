/*****************************************************************************
 * Copyright (c) 2009 CEA
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
package org.eclipse.papyrus.diagram.sequence.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;


public class SequenceUtil {

	/**
	 * Find the container interaction fragment at the given location.
	 * The elements are drawn under the lifeline, but their model container is an interaction fragment.
	 * It can be of type Interaction or InteractionOperand
	 * 
	 * @param location
	 *        the location
	 * @return the interaction fragment or null
	 */
	public static InteractionFragment findInteractionFragmentAt(Point location, EditPart host) {

		if(host == null) {
			return null;
		}

		List<IFigure> exclusionSet = new ArrayList<IFigure>();

		InteractionFragment interactionFragment = null;
		EditPart ep = host.getRoot().getViewer().findObjectAtExcluding(location, exclusionSet);
		while(ep instanceof LifelineEditPart) {
			exclusionSet.add(((GraphicalEditPart)ep).getFigure());
			ep = host.getRoot().getViewer().findObjectAtExcluding(location, exclusionSet);
		}
		// Get the rootEditpart Content
		if(ep != null && ep.getModel() instanceof View) {
			EObject eObject = ViewUtil.resolveSemanticElement((View)ep.getModel());
			if(eObject instanceof InteractionOperand || eObject instanceof Interaction) {
				interactionFragment = (InteractionFragment)eObject;
			}
		}
		return interactionFragment;
	}
}
