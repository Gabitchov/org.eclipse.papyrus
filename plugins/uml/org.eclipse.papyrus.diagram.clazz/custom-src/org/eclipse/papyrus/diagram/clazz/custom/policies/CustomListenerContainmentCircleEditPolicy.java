/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Fadoi LAKHAL  Fadoi.Lakhal@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import static org.eclipse.papyrus.diagram.common.Activator.log;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.papyrus.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.diagram.clazz.custom.edit.part.CContainmentCircleEditPart;

public class CustomListenerContainmentCircleEditPolicy extends AbstractEditPolicy implements NotificationListener, IPapyrusListener {


	/** stores the host associated semantic element */
	protected EObject hostSemanticElement;


	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {

		View view = (View)getHost().getModel();
		hostSemanticElement = view.getElement();
		getDiagramEventBroker().addNotificationListener(view, this);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void desactivate() {

		View view = (View)getHost().getModel();
		getDiagramEventBroker().removeNotificationListener(view, this);
		hostSemanticElement = null;
	}


	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	private DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}


	public void notifyChanged(Notification notification) {

		CContainmentCircleEditPart ccp = (CContainmentCircleEditPart)getHost();

		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(notification.getEventType() == 4) {
			if(ccp.getSourceConnections().size() < 1) {
				final CompoundCommand cc = new CompoundCommand(DiagramUIMessages.DeleteCommand_Label);
				cc.add(getCustomDeleteViewCommand((View)ccp.getModel()));
				executeCommand(cc);
			}
		}
	}


	protected Command getCustomDeleteViewCommand(View view) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		return new ICommandProxy(new DeleteCommand(editingDomain, view));
	}

	/**
	 * Executes the supplied command inside an <code>unchecked action</code>
	 * 
	 * @param cmd
	 *        command that can be executed (i.e., cmd.canExecute() == true)
	 */
	protected void executeCommand(final Command cmd) {
		Map<String, Boolean> options = null;
		EditPart ep = getHost();
		boolean isActivating = true;
		EditPartViewer viewer = ep.getViewer();
		if(viewer instanceof DiagramGraphicalViewer) {
			isActivating = ((DiagramGraphicalViewer)viewer).isInitializing();
		}

		if(isActivating || !EditPartUtil.isWriteTransactionInProgress((IGraphicalEditPart)getHost(), false, false))
			options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);

		AbstractEMFOperation operation = new AbstractEMFOperation(((IGraphicalEditPart)getHost()).getEditingDomain(), StringStatics.BLANK, options) {

			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

				cmd.execute();

				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			log.error(e);
		}
	}
}
