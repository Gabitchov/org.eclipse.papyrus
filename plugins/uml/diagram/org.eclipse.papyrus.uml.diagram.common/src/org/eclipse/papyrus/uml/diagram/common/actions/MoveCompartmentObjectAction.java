/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial api implementation 
 * 
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.actions;

import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.ui.IWorkbenchPage;

/**
 * {@link IAction} that moves an element up and/or down in a list compartment.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class MoveCompartmentObjectAction extends DiagramAction {

	/** Type of action **/
	private int actionType = 0;

	/** Action Type */
	public static final int MOVE_TOP = 3;

	public static final int MOVE_UP = 2;

	public static final int MOVE_DOWN = 1;

	public static final int MOVE_BOTTOM = 0;

	/** Action Type String */
	private static final String MOVE_TOP_STR = "Move Top";

	private static final String MOVE_UP_STR = "Move Up";

	private static final String MOVE_DOWN_STR = "Move Down";

	private static final String MOVE_BOTTOM_STR = "Move Bottom";

	/** Action Type Image Path **/
	private static final String MOVE_TOP_IMG = "/icons/move_top.gif";

	private static final String MOVE_UP_IMG = "/icons/move_up.gif";

	private static final String MOVE_DOWN_IMG = "/icons/move_down.gif";

	private static final String MOVE_BOTTOM_IMG = "/icons/move_bottom.gif";

	/**
	 * Instantiates a new creates the move object action.
	 * 
	 * @param workbenchPage
	 *        the workbench page
	 * @param diagramKind
	 *        the diagram kind
	 */
	public MoveCompartmentObjectAction(IWorkbenchPage workbenchPage, int actionType) {
		super(workbenchPage);
		if(actionType > MOVE_TOP || actionType < MOVE_BOTTOM)
			this.actionType = getDefaultAction();
		else
			this.actionType = actionType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest
	 * ()
	 */
	@Override
	protected Request createTargetRequest() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#isSelectionListener
	 * ()
	 */
	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	/**
	 * Returns the command for moving the selected EditPart along the
	 * ListCompartmentEditPart where is contained.
	 * 
	 * @return a EMF MoveCommand to move the object
	 */
	@Override
	protected Command getCommand() {
		// Get the EditPart
		IGraphicalEditPart selEP = getSelectedEditPart();

		// Check that neither the EditPart nor the EditingDomain are null
		if(selEP == null || selEP.getEditingDomain() == null)
			return null;

		// If everything ok, get the domain and
		TransactionalEditingDomain eDomain = selEP.getEditingDomain();

		// Get the View
		Object model = selEP.getModel();
		if(model instanceof View) {
			View view = (View)model;
			if(view.eContainer() != null && view.eContainer() instanceof View) {
				// Create move through list command
				View viewParent = (View)view.eContainer();
				int pos = 0;
				switch(actionType) {
				case MOVE_TOP:
					pos = 0;
					break;
				case MOVE_UP:
					pos = viewParent.getPersistedChildren().indexOf(view) - 1;
					break;
				case MOVE_DOWN:
					pos = viewParent.getPersistedChildren().indexOf(view) + 1;
					break;
				case MOVE_BOTTOM:
					pos = viewParent.getPersistedChildren().size() - 1;
					break;
				};
				MoveCommand moveCmd = new MoveCommand(eDomain, viewParent, NotationPackage.eINSTANCE.getView_PersistedChildren(), view, pos);
				return new EMFtoGEFCommandWrapper(moveCmd);
			}
		}
		// In any other case, return null
		return null;
	}

	/**
	 * Checks whether the action should be enabled or not
	 * 
	 * @return True if everything is OK. False otherwise.
	 */
	@Override
	public boolean isEnabled() {
		// To have the action enabled the compartment should have more than one
		// element
		IGraphicalEditPart selEP = getSelectedEditPart();

		// If there is no parent, there is nothing to do
		if(selEP == null || selEP.getParent() == null)
			return false;

		// Parent must be a ListCompartment
		if(!(selEP.getParent() instanceof ListCompartmentEditPart))
			return false;

		// Parent must have more than one child
		if(selEP.getParent().getChildren().size() <= 1)
			return false;

		// The View of the EditPart cannot be null and with a parent
		if(selEP.getModel() != null && selEP.getModel() instanceof View)
			return true;
		else
			return false;

	}

	/**
 * 
 */
	@Override
	public void refresh() {
		super.refresh();
		// Set the text for the action
		setText(calculateText());
		// Set the image for the action
		setImageDescriptor(calculateImage());
	}

	/**
	 * Returns the default action. It should only be used in case a bad
	 * parameter is passed to the Constructor.
	 * 
	 * @return the MOVE_TOP action
	 */
	protected int getDefaultAction() {
		return MOVE_TOP;
	}

	/**
	 * Returns the string for the default action. It should only be used in case
	 * a bad parameter is passed to the Constructor.
	 * 
	 * @return the MOVE_TOP_STR action string
	 */
	protected String getDefaultActionStr() {
		return MOVE_TOP_STR;
	}

	/**
	 * Returns the image path for the default action. It should only be used in
	 * case a bad parameter is passed to the Constructor.
	 * 
	 * @return the MOVE_TOP_IMG action image path
	 */
	protected String getDefaultActionImgPath() {
		return MOVE_TOP_IMG;
	}

	/**
	 * Depending on the value of actionType, it returns a suitable text
	 * 
	 * @return a MOVE_XXX_STR value. It depends on the actionType value
	 */
	private String calculateText() {
		// It return the text for the action depending on the actionType value
		switch(actionType) {
		case MOVE_TOP:
			return MOVE_TOP_STR;
		case MOVE_UP:
			return MOVE_UP_STR;
		case MOVE_DOWN:
			return MOVE_DOWN_STR;
		case MOVE_BOTTOM:
			return MOVE_BOTTOM_STR;
			// We should never get here. Constructor should take care of that
		default:
			return getDefaultActionStr();
		}
	}

	/**
	 * It returns a suitable ImageDescriptor for the currect actionType value
	 * 
	 * @return the suitable ImageDescriptor
	 */
	private ImageDescriptor calculateImage() {
		String imgPath = getDefaultActionImgPath();
		switch(actionType) {
		case MOVE_TOP:
			imgPath = MOVE_TOP_IMG;
			break;
		case MOVE_UP:
			imgPath = MOVE_UP_IMG;
			break;
		case MOVE_DOWN:
			imgPath = MOVE_DOWN_IMG;
			break;
		case MOVE_BOTTOM:
			imgPath = MOVE_BOTTOM_IMG;
			break;
		}
		ImageDescriptor descriptor = Activator.imageDescriptorFromPlugin(Activator.ID, imgPath);
		return descriptor;
	}

	/**
	 * Gets the selected edit part.
	 * 
	 * @return the selected edit part
	 */
	private IGraphicalEditPart getSelectedEditPart() {
		for(Object next : getSelectedObjects()) {
			if(next instanceof IGraphicalEditPart) {
				IGraphicalEditPart editPart = (IGraphicalEditPart)next;
				return editPart;
			}
		}
		return null;
	}

}
