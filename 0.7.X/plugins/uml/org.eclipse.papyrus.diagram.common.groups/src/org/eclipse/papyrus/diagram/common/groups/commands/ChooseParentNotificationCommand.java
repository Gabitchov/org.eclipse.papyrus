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
package org.eclipse.papyrus.diagram.common.groups.commands;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.groups.Messages;
import org.eclipse.papyrus.diagram.common.groups.core.GroupNotificationBuilderFactory;
import org.eclipse.papyrus.diagram.common.groups.core.ui.ChooseParentICompositeCreator;
import org.eclipse.papyrus.diagram.common.groups.utils.GroupRequestConstants;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;

/**
 * Command to print the notification for chosing parent
 * TODO allow graphical or model mode
 * 
 * @author adaussy
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
	private CreateViewAndElementRequest request;

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
	public ChooseParentNotificationCommand(TransactionalEditingDomain domain, String label, List<IGraphicalEditPart> parents, CreateViewAndElementRequest request) {
		super(domain, label, null);
		mode = GRAPHICAL_MODE;
		this.parents = parents;
		this.request = request;
	}

	/**
	 * Constructor created element reassignment.
	 * 
	 * @param domain
	 *        editing domain
	 * @param label
	 *        command label
	 */
	public ChooseParentNotificationCommand(TransactionalEditingDomain domain, String label) {
		super(domain, label, null);
		mode = GRAPHICAL_MODE;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
		if(parents != null) {
			Iterator<? extends CreateViewRequest.ViewDescriptor> descriptors = request.getViewDescriptors().iterator();
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
			String label = new String(Messages.ChooseParentNotificationCommand_ChooseGraphicalParent);
			NotificationBuilder parentNotification = GroupNotificationBuilderFactory.getChooseGraphicalParentBuilder(label);
			ChooseParentICompositeCreator creator = new ChooseParentICompositeCreator(parents, childEditPart);
			parentNotification.setComposite(creator).addAction(creator).run();
			return CommandResult.newOKCommandResult();
		} else {
			return CommandResult.newErrorCommandResult(GroupRequestConstants.CHOOSE_PARENT_ERROR_NOTIFICATION);
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

}
