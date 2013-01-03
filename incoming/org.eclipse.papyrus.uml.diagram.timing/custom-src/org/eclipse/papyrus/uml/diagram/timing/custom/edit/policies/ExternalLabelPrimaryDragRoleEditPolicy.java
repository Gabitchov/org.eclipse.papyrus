/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  Nicolas Bros (Mia-Software) - remove dead code, refresh on execute/undo/redo
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableLabelEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForUndo;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;

/**
 * This policy provides the selection handles, feedback and move command for an external node label. The expected
 * behavior is to provide an external label that can freely move and with a link feedback towards its parent figure
 * during the move.
 * 
 * @author nbros : I copied this class from
 *         org.eclipse.papyrus.uml.diagram.clazz.custom.policies.ExternalLabelPrimaryDragRoleEditPolicy, removed dead
 *         code, added a Refresh, and constrained the bounds within the containing compartment.
 */
public class ExternalLabelPrimaryDragRoleEditPolicy extends NonResizableLabelEditPolicy {

	@Override
	protected List<?> createSelectionHandles() {
		final MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
		mh.setBorder(null);
		return Collections.singletonList(mh);
	}

	@Override
	protected Command getMoveCommand(final ChangeBoundsRequest request) {
		final LabelEditPart editPart = (LabelEditPart) getHost();

		final IFigure parentFigure = getHostFigure().getParent();
		final Rectangle parentBounds = parentFigure.getBounds();

		// First, start from the original bounds
		Rectangle updatedBounds = new Rectangle(getInitialFeedbackBounds());
		// Add the delta corresponding to the move
		updatedBounds = updatedBounds.getTranslated(FigureUtils.scaleByZoom(request.getMoveDelta(), parentFigure));
		// Constrain the bounds within the containing compartment if any
		updatedBounds = FigureUtils.constrainBoundsWithinContainingCompartment(updatedBounds, getHostFigure());
		// Then translate the bounds so that they are relative to the figure (BorderItemContainerFigure)
		// to which the label is attached
		updatedBounds = updatedBounds.getTranslated(parentBounds.getLocation().getNegated());

		final CompoundCommand compoundCommand = new CompoundCommand();
		compoundCommand.add(new RefreshCommandForUndo((GraphicalEditPart) editPart.getParent().getParent()));
		compoundCommand.add(new ICommandProxy(new SetBoundsCommand(editPart.getEditingDomain(), DiagramUIMessages.MoveLabelCommand_Label_Location,
				new EObjectAdapter((View) editPart.getModel()), updatedBounds)));
		compoundCommand.add(new RefreshCommandForDo(editPart));
		return compoundCommand;
	}
}
