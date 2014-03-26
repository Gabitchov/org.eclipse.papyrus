/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/


package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;


/**
 * 
 * see bug 430702: [Diagram] Moving source of a link moves the target too.
 * 
 * This class allows to fix the anchors for a collection of connection edit part
 * 
 */
public class FixEdgeAnchorsDeferredCommand extends AbstractFixEdgeAnchorDeferredCommand {

	/**
	 * the list of the connections to refresh
	 */
	private Collection<?> connectionsEditPartToRefresh;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param request
	 *        the creation request
	 * @param containerEP
	 *        the diagram edit part
	 */
	public FixEdgeAnchorsDeferredCommand(final TransactionalEditingDomain editingDomain, final IGraphicalEditPart containerEP, final Collection<?> connectionsEditPartToRefresh) {
		super(editingDomain, "Fix Edge Anchors", containerEP); //$NON-NLS-1$
		this.connectionsEditPartToRefresh = new ArrayList<Object>(connectionsEditPartToRefresh);
	}


	/**
	 * Executes a fix anchor command for the created edge
	 * 
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		final RefreshConnectionElementsRunnable refreshRunnable = new RefreshConnectionElementsRunnable(this.connectionsEditPartToRefresh,  getContainerEP());
		
		EditPartUtil.synchronizeRunnableToMainThread(getContainerEP(), refreshRunnable);
		final Collection<AbstractConnectionEditPart> toRefresh = refreshRunnable.getResult();
		final Iterator<AbstractConnectionEditPart> iter = toRefresh.iterator();
		while(iter.hasNext()) {
			final CompoundCommand cc = new CompoundCommand("Fix connections anchors"); //$NON-NLS-1$
			final AbstractConnectionEditPart current = iter.next();
			addFixAnchorCommand(current, cc);
			if(cc.canExecute()) {
				cc.execute();
			} else {
				Activator.log.warn("Command to fix the anchors is null"); //$NON-NLS-1$
			}
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#cleanup()
	 * 
	 */
	protected void cleanup() {
		super.cleanup();
		this.connectionsEditPartToRefresh.clear();
	}

	private static class RefreshConnectionElementsRunnable extends AbstractRefreshConnectionElementsRunnable<Collection<AbstractConnectionEditPart>> {

		/**
		 * the list of the connections to refresh
		 */
		private Collection<?> connectionsEditPartToRefresh;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param connectionsEditPartToRefresh
		 *        the list of the connection edit part to refresh
		 * @param containerEP
		 */
		public RefreshConnectionElementsRunnable(final Collection<?> connectionsEditPartToRefresh, final IGraphicalEditPart containerEP) {
			super(containerEP);
			this.connectionsEditPartToRefresh = connectionsEditPartToRefresh;
		}

		/**
		 * 
		 * @see java.lang.Runnable#run()
		 * 
		 */
		public void run() {
			getContainerEditPart().refresh();

			// We update the figure world 
			getContainerFigure().invalidate();
			getContainerFigure().validate();
			final Iterator<?> iter = connectionsEditPartToRefresh.iterator();
			final Collection<AbstractConnectionEditPart> connectionsEP = new HashSet<AbstractConnectionEditPart>();
			setResult(connectionsEP);
			while(iter.hasNext()) {
				final Object object = iter.next();
				if(object instanceof AbstractConnectionEditPart) {
					connectionsEP.add((AbstractConnectionEditPart)object);
					refreshConnection((AbstractConnectionEditPart)object);
				}
			}
			setStatus(Status.OK_STATUS);
		}
	}
}
