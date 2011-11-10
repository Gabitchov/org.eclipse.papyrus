/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
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
package org.eclipse.papyrus.uml.diagram.common.groups.commands;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.groups.Messages;
import org.eclipse.papyrus.uml.diagram.common.groups.core.PendingGroupNotificationsManager;
import org.eclipse.papyrus.uml.diagram.common.groups.core.ui.ChooseParentNotificationConfigurator;
import org.eclipse.papyrus.uml.diagram.common.groups.core.ui.NotificationConfigurator;
import org.eclipse.papyrus.uml.diagram.common.groups.utils.GroupRequestConstants;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;

/**
 * Command to display the notification for choosing parent.
 * This command handle two modes:
 * 
 * @see #GRAPHICAL_MODE : Display the notification in order to choose the graphical parent
 * @see #MODEL_MODE : Display the warning in order to choose the model parent and change automatically the graphical parent
 * @author arthur daussy
 */
public class ChooseParentNotificationCommand extends AbstractTransactionalCommand {

	/** mode for graphical parent */
	public static final boolean GRAPHICAL_MODE = true;

	/** mode for model parent */
	public static final boolean MODEL_MODE = false;

	/** the mode to use this command with */
	private boolean mode;

	/** list of possible parent parts */
	private List<IGraphicalEditPart> parents;

	/** child part to choose parent for */
	private IGraphicalEditPart childEditPart;

	/** creation request */
	private Request request;

	/** EditPart of host of the {@link EditPolicy} */
	private IGraphicalEditPart host;

	/**
	 * Manage of the pending notification
	 */
	private PendingGroupNotificationsManager manager;

	/**
	 * {@link NotificationConfigurator} of the pointed childEditPart
	 */
	private ChooseParentNotificationConfigurator notifConfigurator;


	/**
	 * Constructor for element creation.
	 * 
	 * @param domain
	 *        editing domain
	 * @param label
	 *        command label
	 * @param parents
	 *        possible parents
	 * @param request
	 *        creation request
	 */
	public ChooseParentNotificationCommand(TransactionalEditingDomain domain, String label, List<IGraphicalEditPart> parents, Request request, Boolean mode, IGraphicalEditPart getHost) {
		super(domain, label, null);
		this.parents = parents;
		this.request = request;
		this.mode = mode;
		this.host = getHost;
		this.manager = PendingGroupNotificationsManager.getInstanceForDiagram(DiagramEditPartsUtil.getDiagramEditPart(getHost));
	}





	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
		if(parents != null) {
			if(getEditPartFromDescriptor()) {
				String label;
				ChooseParentNotificationConfigurator configurator = null;
				if(mode == GRAPHICAL_MODE) {
					label = new String(Messages.ChooseParentNotificationCommand_ChooseGraphicalParent);
					configurator = new ChooseParentNotificationConfigurator(parents, childEditPart, mode, host, manager, NotificationConfigurator.Mode.QUESTION_MODE, label);
				} else {
					label = new String(Messages.ChooseParentNotificationCommand_ChooseGraphicalParent);
					configurator = new ChooseParentNotificationConfigurator(parents, childEditPart, mode, host, manager, NotificationConfigurator.Mode.WARNING_MODE, label);
				}
				if(configurator != null) {
					notifConfigurator = configurator;
					configurator.runConfigurator();
					return CommandResult.newOKCommandResult();
				}
			}
		}
		return CommandResult.newErrorCommandResult(GroupRequestConstants.CHOOSE_PARENT_ERROR_NOTIFICATION);


	}

	/**
	 * This method is going to get the edit part from the request.
	 * 1 - Get descriptors
	 * 2 - Get View (adapter)
	 * 3 - Get IGraphicalEditPart if it exist
	 * 
	 * @return true if it as found the edit part
	 */
	private Boolean getEditPartFromDescriptor() {
		if(request instanceof CreateViewAndElementRequest) {
			CreateViewAndElementRequest createRequest = (CreateViewAndElementRequest)request;
			Iterator<? extends CreateViewRequest.ViewDescriptor> descriptors = createRequest.getViewDescriptors().iterator();
			while(descriptors.hasNext()) {
				CreateViewRequest.ViewDescriptor descriptor = (CreateViewRequest.ViewDescriptor)descriptors.next();
				Object view = descriptor.getAdapter(View.class);
				if(view instanceof View) {
					View childView = (View)view;
					if(!parents.isEmpty()) {
						Object childEditPartAux = parents.get(0).getViewer().getEditPartRegistry().get(childView);
						if(childEditPartAux instanceof IGraphicalEditPart) {
							childEditPart = (IGraphicalEditPart)childEditPartAux;
						}
					}
				}
			}
		} else if(request instanceof ChangeBoundsRequest) {
			ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest)request;
			if(!changeBoundsRequest.getEditParts().isEmpty()) {
				Object editPart = changeBoundsRequest.getEditParts().get(0);
				if(editPart instanceof IGraphicalEditPart) {
					IGraphicalEditPart _childEditPart = (IGraphicalEditPart)editPart;
					View childView = _childEditPart.getNotationView();
					if(!parents.isEmpty()) {
						Object childEditPartAux = parents.get(0).getViewer().getEditPartRegistry().get(childView);
						if(childEditPartAux instanceof IGraphicalEditPart) {
							childEditPart = (IGraphicalEditPart)childEditPartAux;
						}
					}

				}
			}
		}
		if(childEditPart != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Set the list of possible parents
	 * 
	 * @param parents
	 *        list of possible parents
	 */
	public void setListOfParents(List<IGraphicalEditPart> parents) {
		this.parents = parents;
	}

	/**
	 * Set mode to use this command
	 * 
	 * @param mode
	 *        one of {@link #GRAPHICAL_MODE} or {@link #MODEL_MODE}
	 */
	public void setMode(boolean mode) {
		this.mode = mode;
	}

	/**
	 * Inform that the command has been undone and delete or update the created notification
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#didUndo(org.eclipse.emf.transaction.Transaction)
	 * @param tx
	 *        a transaction that has been undone.
	 */
	@Override
	protected void didUndo(Transaction tx) {
		if(notifConfigurator != null) {
			notifConfigurator.closeNotification();
		}
		super.didUndo(tx);
	}

}
