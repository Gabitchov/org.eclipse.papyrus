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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.DeleteStateDefinitionCommand;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForDo;
import org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands.RefreshCommandForUndo;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.StateDefinitionFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EditPartUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.FigureUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateDefinitionUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateInvariantUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionEditPart;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.StateInvariant;

public class CustomStateDefinitionEditPart extends StateDefinitionEditPart {

	public CustomStateDefinitionEditPart(final View view) {
		super(view);
	}

	@Override
	public void setSelected(final int value) {
		super.setSelected(value);
		// set selection on figure
		final StateDefinitionFigure stateDefinitionFigure = FigureUtils.findChildFigureInstance(getFigure(), StateDefinitionFigure.class);
		stateDefinitionFigure.setSelected(value != EditPart.SELECTED_NONE);
		// repaint compartment
		final ResizableCompartmentFigure compartmentFigure = FigureUtils.findParentFigureInstance(getFigure(), ResizableCompartmentFigure.class);
		compartmentFigure.repaint();
	}

	@Override
	public Command getCommand(final Request request) {
		if (request.getType() == REQ_DELETE) {
			final FullLifelineEditPartCN lifelineEditPart = (FullLifelineEditPartCN) EditPartUtils.findParentEditPartWithId(this,
					FullLifelineEditPartCN.VISUAL_ID);
			final Lifeline lifeline = (Lifeline) ((View) lifelineEditPart.getModel()).getElement();
			final View view = (View) getModel();
			final String id = StateDefinitionUtils.getStateDefinitionViewID(view);
			if (lifeline.getInteraction() != null) {
				final List<StateInvariant> stateInvariants = StateInvariantUtils.findStateInvariantsWithId(id, lifeline.getInteraction());
				if (stateInvariants.size() > 0) {
					// cannot delete a StateDefinition used in a StateInvariant
					return UnexecutableCommand.INSTANCE;
				}
			}
			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(view);
			final CompoundCommand compoundCommand = new CompoundCommand(Messages.CustomStateDefinitionEditPart_DeleteStateDefinition);
			compoundCommand.add(new RefreshCommandForUndo(lifelineEditPart));
			compoundCommand.add(new ICommandProxy(new DeleteCommand(editingDomain, view)));
			compoundCommand.add(new ICommandProxy(new DeleteStateDefinitionCommand(id, lifeline, editingDomain)));
			compoundCommand.add(new RefreshCommandForDo(lifelineEditPart));
			return compoundCommand;
		}

		if (request.getType() == REQ_RECONNECT_TARGET) {
			// don't let the user reconnect anything to a state definition
			return UnexecutableCommand.INSTANCE;
		}
		return super.getCommand(request);
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") final Class key) {
		// GMF returns the View by default, but Papyrus expects a semantic element.
		// There is no semantic element, so we return null in order for Papyrus to handle
		// the delete menu action enablement correctly.
		// XXX warning: this might cause unforeseen bugs somewhere else.
		if (key == EObject.class) {
			return null;
		}
		return super.getAdapter(key);
	}

	@Override
	public DragTracker getDragTracker(final Request request) {
		// lock the drag to the containing compartment
		return new DragEditPartsTrackerEx(this) {
			@Override
			protected boolean handleDragStarted() {
				lockTargetEditPart(CustomStateDefinitionEditPart.this.getParent());
				return super.handleDragStarted();
			}
		};
	}
}
