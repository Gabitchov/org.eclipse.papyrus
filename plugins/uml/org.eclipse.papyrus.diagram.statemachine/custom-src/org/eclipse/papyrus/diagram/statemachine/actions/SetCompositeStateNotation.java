/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Francisco Javier Cano Mu�oz (Prodevelop) - Initial API 
 *  implementation.
 *  Marc Gil Sendra (Prodevelop)
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.actions;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.commands.ChangeCompositeStateFigureCommand;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State2EditPart;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.State4EditPart;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.uml.State;


// TODO: Auto-generated Javadoc
/**
 * The Class SetCompositeStateNotation.
 */
public class SetCompositeStateNotation extends DiagramAction {

	/** The Constant DISABLED_TEXT. */
	private static final String DISABLED_TEXT = "Switch composite State notation";

	/** The Constant DISABLED_TOOLTIP. */
	private static final String DISABLED_TOOLTIP = "Compose or decompose composite state";

	/** The new view descriptor. */
	private ViewDescriptor newViewDescriptor = null;

	/**
	 * Instantiates a new sets the composite state notation.
	 * 
	 * @param workbenchPage
	 *        the workbench page
	 * @param actionId
	 *        the action id
	 */
	public SetCompositeStateNotation(IWorkbenchPage workbenchPage,
			String actionId) {
		super(workbenchPage);
		setId(actionId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
	 */
	@Override
	protected Request createTargetRequest() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#isSelectionListener()
	 */
	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#init()
	 */
	@Override
	public void init() {
		super.init();
		updateText();
		setImageDescriptor(UMLElementTypes.getImageDescriptor(UMLElementTypes
				.getElement(UMLElementTypes.State_2003)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		updateText();
	}

	/**
	 * Update text.
	 */
	private void updateText() {
		GraphicalEditPart editPart = getSelectedEditPart();
		if(editPart instanceof State2EditPart) {
			setText("Compose");
			setToolTipText("Change Composite State Notation");
			return;
		}
		if(editPart instanceof State4EditPart) {
			setText("Decompose");
			setToolTipText("Change Composite State Notation");
			return;
		}
		setText(DISABLED_TEXT);
		setToolTipText(DISABLED_TOOLTIP);
	}

	/**
	 * Gets the selected edit part.
	 * 
	 * @return the selected edit part
	 */
	private GraphicalEditPart getSelectedEditPart() {
		for(Object ob : getSelectedObjects()) {
			if(ob instanceof GraphicalEditPart) {
				return (GraphicalEditPart)ob;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#getCommand()
	 */
	@Override
	protected Command getCommand() {
		final GraphicalEditPart editPart = getSelectedEditPart();
		if(editPart == null) {
			return UnexecutableCommand.INSTANCE;
		}
		Command deleteCommand = getDeleteViewCommand(editPart);
		if(deleteCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}
		Command createViewCommand = getCreateViewCommand(editPart);
		if(createViewCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}

		ChangeCompositeStateFigureCommand command = new ChangeCompositeStateFigureCommand();
		command.setCreateCommand(createViewCommand);
		command.setDeleteCommand(deleteCommand);
		command.setOldStateEditPart(editPart);
		command.setRootEditPart(editPart.getParent());
		command.setViewDescriptor(newViewDescriptor);
		command.setLabel("Change Composite State Notation");

		return command;
	}

	/**
	 * Gets the delete view command.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the delete view command
	 */
	private Command getDeleteViewCommand(GraphicalEditPart editPart) {
		View view = (View)editPart.getModel();
		return new ICommandProxy(new DeleteCommand(view));
	}

	/**
	 * Gets the creates the view command.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the creates the view command
	 */
	private Command getCreateViewCommand(GraphicalEditPart editPart) {
		CreateViewRequest createViewRequest = getCreateViewRequest(editPart);
		if(createViewRequest == null) {
			return null;
		}
		return editPart.getParent().getCommand(createViewRequest);
	}

	/**
	 * Gets the creates the view request.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the creates the view request
	 */
	private CreateViewRequest getCreateViewRequest(GraphicalEditPart editPart) {

		View view = (View)editPart.getModel();
		if(view == null || false == view.getElement() instanceof State) {
			return null;
		}

		State state1 = (State)view.getElement();
		String semanticHint = getSemanticHint(editPart);
		ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter(
				state1), Node.class, semanticHint, getPreferencesHint());

		newViewDescriptor = viewDescriptor;

		CreateViewRequest createViewRequest = new CreateViewRequest(
				viewDescriptor);
		createViewRequest.setLocation(getLocation(editPart));
		return createViewRequest;
	}

	/**
	 * Gets the semantic hint.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the semantic hint
	 */
	private String getSemanticHint(GraphicalEditPart editPart) {
		String semanticHint = "";
		if(editPart instanceof State2EditPart)
			semanticHint = String.valueOf(State4EditPart.VISUAL_ID);
		else if(editPart instanceof State4EditPart)
			semanticHint = String.valueOf(State2EditPart.VISUAL_ID);
		return semanticHint;
	}

	/**
	 * Gets the location.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the location
	 */
	private Point getLocation(GraphicalEditPart editPart) {
		//return editPart.getFigure().getBounds().getTopLeft();
		return new Point(editPart.getFigure().getBounds().getLocation());
	}
}
