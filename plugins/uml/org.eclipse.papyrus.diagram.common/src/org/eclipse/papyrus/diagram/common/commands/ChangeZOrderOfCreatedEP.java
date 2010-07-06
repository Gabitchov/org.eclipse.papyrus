/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.ZOrderRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

// TODO: Auto-generated Javadoc
/**
 * Command to change the ZOrdering of the new created EditPart. The possible actions are Send to
 * back, Bring to the front, Send backward and Bring forward. Check ZOrderRequest class for the list
 * of strings.
 * 
 * @author <a href="mailto:gmerin@prodevelop.es">Gabriel Merin</a>
 */
// @unused
public class ChangeZOrderOfCreatedEP extends AbstractTransactionalCommand {

	/** The view descriptor. */
	private ViewDescriptor viewDescriptor = null;

	/** The viewer. */
	private EditPartViewer viewer = null;

	/** The request string. */
	private String requestString = "";

	/**
	 * Constructor. If reqString is not a valid ZOrderRequest string, then
	 * ZOrderRequest.REQ_SEND_TO_BACK is the default request string.
	 * 
	 * @param domain
	 *        the domain
	 * @param descriptor
	 *        the descriptor
	 * @param viewer
	 *        the viewer
	 * @param reqString
	 *        the req string
	 */
	public ChangeZOrderOfCreatedEP(TransactionalEditingDomain domain, ViewDescriptor descriptor, EditPartViewer viewer, String reqString) {
		super(domain, "Change ZOrder of Created Node", null);
		viewDescriptor = descriptor;
		this.viewer = viewer;
		if(isAllowedReqString(reqString)) {
			requestString = reqString;
		} else {
			requestString = ZOrderRequest.REQ_SEND_TO_BACK;
		}
	}

	/**
	 * Checks if the parameter reqString is a valid ZOrderRequest string.
	 * 
	 * @param reqString
	 *        the req string
	 * 
	 * @return true if a valid string, false otherwise.
	 */
	private boolean isAllowedReqString(String reqString) {
		if(ZOrderRequest.REQ_SEND_TO_BACK.equals(reqString)) {
			return true;
		}
		if(ZOrderRequest.REQ_SEND_BACKWARD.equals(reqString)) {
			return true;
		}
		if(ZOrderRequest.REQ_BRING_FORWARD.equals(reqString)) {
			return true;
		}
		if(ZOrderRequest.REQ_BRING_TO_FRONT.equals(reqString)) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.emf.commands.core.command. AbstractTransactionalCommand#
	 * doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 * org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		View view = (View)viewDescriptor.getAdapter(View.class);
		if(view == null) {
			return CommandResult.newErrorCommandResult("Element view not created");
		}

		Command command = getZOrderCommand(view);
		if(command != null) {
			command.execute();
		}

		return CommandResult.newOKCommandResult();

	}

	/**
	 * Creates a new ZOrdering command to move the new created View accordingly.
	 * 
	 * @param view
	 *        the view
	 * 
	 * @return the appropriate ZOrder command depending on the requestString passed during the
	 *         constructor of the class.
	 */
	private Command getZOrderCommand(View view) {
		IGraphicalEditPart newElementEP = (IGraphicalEditPart)viewer.getEditPartRegistry().get(view);
		newElementEP.getFigure().getUpdateManager().performUpdate();

		ZOrderRequest zOrderReq = new ZOrderRequest(requestString);
		List<IGraphicalEditPart> elements = new ArrayList<IGraphicalEditPart>();
		elements.add(newElementEP);
		zOrderReq.setPartsToOrder(elements);

		Command command = newElementEP.getParent().getCommand(zOrderReq);
		return command;
	}

}
