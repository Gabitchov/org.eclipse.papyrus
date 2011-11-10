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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.groups.core.PendingGroupNotificationsManager;
import org.eclipse.papyrus.uml.diagram.common.groups.core.ui.ChooseChildrenNotificationConfigurator;
import org.eclipse.papyrus.uml.diagram.common.groups.core.ui.NotificationConfigurator;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;

/**
 * This command will create a notification to ask the user to choose the graphical children of an element
 * 
 * @author arthur daussy
 * 
 */
public class ChooseChildrenNotificationCommand extends AbstractTransactionalCommand {

	/**
	 * All possible graphical children
	 */
	private List<IGraphicalEditPart> allChildren;

	/**
	 * All children which are automatically chosen as graphical child
	 */
	private List<IGraphicalEditPart> automaticChildren;

	/**
	 * {@link IAdaptable} of the view (used to retrieve the {@link EditPart})
	 */
	private IAdaptable adapter;

	/**
	 * {@link EditPart} on which we have to choose the graphical children
	 */
	private IGraphicalEditPart mainEditPart;


	/**
	 * {@link EditPart} hosting the {@link EditPolicy}
	 */
	private IGraphicalEditPart host;

	/**
	 * Pending Group manager
	 */
	private PendingGroupNotificationsManager manager;

	/**
	 * List of all notification created and modifed
	 */
	private List<ChooseChildrenNotificationConfigurator> createdNotificationConfigurator;

	/**
	 * {@link DiagramEditPart}
	 */
	private DiagramEditPart diagramPart;

	/**
	 * Construct the command for asking to choose graphical children of a adapter
	 * Constructor.
	 * 
	 * @param domain
	 * @see {@link AbstractTransactionalCommand}
	 * @param label
	 * @see {@link AbstractTransactionalCommand}
	 * @param _allChildren
	 * @see {@link #allChildren}
	 * @param _automaticChildren
	 * @see {@link #automaticChildren}
	 * @param _adapter
	 * @see {@link #adapter}
	 */
	public ChooseChildrenNotificationCommand(TransactionalEditingDomain domain, String label, List<IGraphicalEditPart> _allChildren, List<IGraphicalEditPart> _automaticChildren, IAdaptable _adapter, IGraphicalEditPart getHost, DiagramEditPart _diagramPart) {
		super(domain, label, null);
		this.allChildren = _allChildren;
		this.automaticChildren = _automaticChildren;
		this.adapter = _adapter;
		this.host = getHost;
		this.diagramPart = _diagramPart;
		this.manager = PendingGroupNotificationsManager.getInstanceForDiagram(DiagramEditPartsUtil.getDiagramEditPart(getHost));
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!getEditPartFromEditPartAdapter()) {
			if(!allChildren.isEmpty()) {
				getEditPartFromViewAdapter(allChildren.get(0));
			}
		}
		if(mainEditPart != null) {
			createdNotificationConfigurator = new ArrayList<ChooseChildrenNotificationConfigurator>();
			NotificationConfigurator configurator = PendingGroupNotificationsManager.getInstanceForDiagram(diagramPart).getChooseChildrenPendingNotification(mainEditPart);
			ChooseChildrenNotificationConfigurator notificationConfigurator = null;
			if(configurator == null) {
				//If there is no a pending notification for this main edit part then it create one	
				if(!allChildren.isEmpty() && isChildrenToChoose()) {
					notificationConfigurator = new ChooseChildrenNotificationConfigurator(mainEditPart, allChildren, automaticChildren, host, manager);
					notificationConfigurator.runConfigurator();
				}
			} else {
				//Else update the old one if needed TODO TODO
				// 1 - Compare if there is any modification TODO
				if(configurator instanceof ChooseChildrenNotificationConfigurator) {
					notificationConfigurator = (ChooseChildrenNotificationConfigurator)configurator;
					if(notificationConfigurator.isThereAnyModification(mainEditPart, allChildren, automaticChildren, host)) {
						// 2 - There are some update the old notification TODO
						notificationConfigurator.closeNotification();
						if(!allChildren.isEmpty() && isChildrenToChoose()) {
							notificationConfigurator = new ChooseChildrenNotificationConfigurator(mainEditPart, allChildren, automaticChildren, host, manager);
							notificationConfigurator.runConfigurator();
						}

					}
				}
			}
			if(notificationConfigurator != null) {
				createdNotificationConfigurator.add(notificationConfigurator);
			}
			return CommandResult.newOKCommandResult();
		}
		return CommandResult.newErrorCommandResult("The editPart of the adaptable element has not been found");//$NON-NLS-1$
	}

	/**
	 * Return true if there is some children on which the user should choose the graphical parent
	 * 
	 * @return
	 */
	private boolean isChildrenToChoose() {
		return (allChildren.size() > automaticChildren.size());
	}

	/**
	 * Set the main edit part attribute from the adapter
	 * 
	 * @param any
	 *        Any {@link IGraphicalEditPart} from which we can get the EditPartRegistery
	 * @return true if succeed
	 */
	private Boolean getEditPartFromEditPartAdapter() {
		Object _mainEditPart = adapter.getAdapter(EditPart.class);
		if(_mainEditPart instanceof IGraphicalEditPart) {
			mainEditPart = (IGraphicalEditPart)_mainEditPart;
			return true;
		}
		return false;
	}

	/**
	 * Get the {@link IGraphicalEditPart} from view adapter
	 * 
	 * @param any
	 * @return
	 */
	private Boolean getEditPartFromViewAdapter(IGraphicalEditPart any) {
		Object view = adapter.getAdapter(View.class);
		Map<?, ?> registery = any.getViewer().getEditPartRegistry();
		if(view instanceof View) {
			View childView = (View)view;
			Object auxPart = registery.get(childView);
			if(auxPart instanceof IGraphicalEditPart) {
				mainEditPart = (IGraphicalEditPart)auxPart;
				return true;
			}
		}
		return false;
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
		for(ChooseChildrenNotificationConfigurator notifConfigurator : createdNotificationConfigurator) {
			notifConfigurator.closeNotification();
		}
		super.didUndo(tx);


	}

}
