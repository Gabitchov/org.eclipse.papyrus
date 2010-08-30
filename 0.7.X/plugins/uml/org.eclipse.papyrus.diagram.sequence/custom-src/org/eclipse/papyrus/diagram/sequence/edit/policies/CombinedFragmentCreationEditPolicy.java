/*****************************************************************************
 * Copyright (c) 2010 CEA
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
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.Set;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.InteractionFragment;


public class CombinedFragmentCreationEditPolicy extends CreationEditPolicy {

	@SuppressWarnings("unchecked")
	@Override
	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {
		String elementId = getElementIdFromHint(request.getViewAndElementDescriptor().getSemanticHint());

		if(elementId != null && getHost() instanceof IGraphicalEditPart) {

			Rectangle selectionRect = getSelectionRectangle(request, elementId, (IGraphicalEditPart)getHost());

			Set<InteractionFragment> coveredInteractionFragments = SequenceUtil.getCoveredInteractionFragments(selectionRect, getHost(), 0.5);

			request.getExtendedData().put(SequenceRequestConstant.COVERED_INTERACTIONFRAGMENTS, coveredInteractionFragments);
		}
		return super.getCreateElementAndViewCommand(request);
	}

	private Rectangle getSelectionRectangle(CreateViewAndElementRequest request, String elementId, IGraphicalEditPart gep) {
		Rectangle selectionRect = new Rectangle();

		Point location = request.getLocation();
		Dimension size = request.getSize();

		if(location != null) {
			selectionRect.x = location.x;
			selectionRect.y = location.y;
		} else {
			// default values (should not be triggered)
			selectionRect.x = 100;
			selectionRect.y = 100;
		}

		if(size != null) {
			selectionRect.height = size.height;
			selectionRect.width = size.width;
		} else {
			// default values hardcoded...
			selectionRect.height = 61;
			selectionRect.width = 112;
		}

		return selectionRect;
	}

	private static String getElementIdFromHint(String hint) {
		if(((IHintedType)UMLElementTypes.InteractionOperand_3005).getSemanticHint().equals(hint)) {
			return "InteractionOperand";
		}
		if(((IHintedType)UMLElementTypes.CombinedFragment_3004).getSemanticHint().equals(hint)) {
			return "CombinedFragment";
		}
		return null;
	}
}
