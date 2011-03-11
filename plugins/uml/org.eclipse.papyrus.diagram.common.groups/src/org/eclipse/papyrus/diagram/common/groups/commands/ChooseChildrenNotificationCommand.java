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
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.groups.core.GroupNotificationBuilderFactory;
import org.eclipse.papyrus.diagram.common.groups.core.ui.ChooseChildrenICompositeCreator;
import org.eclipse.papyrus.diagram.common.groups.core.ui.ChooseParentICompositeCreator;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;

/**
 * This command will create a notification to ask the user to choose the graphical children of an element
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
	 * Construct the command for asking to choose graphical children of a adapter
	 * Constructor.
	 *
	 * @param domain @see {@link AbstractTransactionalCommand}
	 * @param label @see {@link AbstractTransactionalCommand}
	 * @param _allChildren @see {@link #allChildren}
	 * @param _automaticChildren @see {@link #automaticChildren}
	 * @param _adapter @see {@link #adapter}
	 */
	public ChooseChildrenNotificationCommand(TransactionalEditingDomain domain, String label, List<IGraphicalEditPart> _allChildren, List<IGraphicalEditPart> _automaticChildren, IAdaptable _adapter) {
		super(domain, label, null);
		this.allChildren=_allChildren;
		this.automaticChildren = _automaticChildren;
		this.adapter = _adapter;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!allChildren.isEmpty() && getEditPartFromDescriptor(allChildren.get(0))){			
			NotificationBuilder parentNotification = GroupNotificationBuilderFactory.getQuestionBuilder("The following elements can be graphical children. Select you want your new group to be their graphical parent :");
			ChooseChildrenICompositeCreator creator = new ChooseChildrenICompositeCreator(mainEditPart, allChildren, automaticChildren);
			parentNotification.setComposite(creator).addAction(creator).run();
			return CommandResult.newOKCommandResult();
		}
		return CommandResult.newErrorCommandResult("The editPart of the adaptable element has not been found");//$NON-NLS-1$
	}

	/**
	 * FIXME create JAVA doc and maybe create abstract class GroupNotificationCommand
	 */
	private Boolean getEditPartFromDescriptor(IGraphicalEditPart any) {
		Map registery = any.getViewer().getEditPartRegistry();
		Object view = adapter.getAdapter(View.class);
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

}
