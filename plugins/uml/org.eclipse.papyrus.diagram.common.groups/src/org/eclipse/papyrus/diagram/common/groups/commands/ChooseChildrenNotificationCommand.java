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

import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.groups.core.GroupNotificationBuilderFactory;
import org.eclipse.papyrus.diagram.common.groups.core.ui.ChooseChildrenICompositeCreator;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;

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

	private IGraphicalEditPart host;

	/**
	 * Construct the command for asking to choose graphical children of a adapter
	 * Constructor.
	 * 
	 * @param domain
	 *        @see {@link AbstractTransactionalCommand}
	 * @param label
	 *        @see {@link AbstractTransactionalCommand}
	 * @param _allChildren
	 *        @see {@link #allChildren}
	 * @param _automaticChildren
	 *        @see {@link #automaticChildren}
	 * @param _adapter
	 *        @see {@link #adapter}
	 */
	public ChooseChildrenNotificationCommand(TransactionalEditingDomain domain, String label, List<IGraphicalEditPart> _allChildren, List<IGraphicalEditPart> _automaticChildren, IAdaptable _adapter, IGraphicalEditPart getHost) {
		super(domain, label, null);
		this.allChildren = _allChildren;
		this.automaticChildren = _automaticChildren;
		this.adapter = _adapter;
		this.host = getHost;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!allChildren.isEmpty() && getEditPartFromAdapter(allChildren.get(0))) {
			NotificationBuilder parentNotification = GroupNotificationBuilderFactory.getQuestionBuilder("The following elements can be graphical children. Select you want your new group to be their graphical parent :");
			ChooseChildrenICompositeCreator creator = new ChooseChildrenICompositeCreator(mainEditPart, allChildren, automaticChildren, host);
			parentNotification.setComposite(creator).addAction(creator).run();
			return CommandResult.newOKCommandResult();
		}
		return CommandResult.newErrorCommandResult("The editPart of the adaptable element has not been found");//$NON-NLS-1$
	}

	/**
	 * Set the main edit part attribute from the adapter
	 * 
	 * @param any
	 *        Any {@link IGraphicalEditPart} from which we can get the EditPartRegistery
	 * @return true if succeed
	 */
	private Boolean getEditPartFromAdapter(IGraphicalEditPart any) {
		Object _mainEditPart = adapter.getAdapter(EditPart.class);
		if(_mainEditPart instanceof IGraphicalEditPart) {
			mainEditPart = (IGraphicalEditPart)_mainEditPart;
			return true;
		} else {
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
		}
		return false;
	}

}
