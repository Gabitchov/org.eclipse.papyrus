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

import java.io.ObjectInputStream.GetField;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.swt.widgets.Display;


/**
 * 
 * This command is used to fix the edge anchor just after the creation of the edge, in order to get anchor on the sides of the source
 * and target figure and not somewhere inside the figure.
 * 
 * This fix allows to avoid to get source (or target) location moving instead you are moving the target (or source) anchor
 * 
 * see bug 430702: [Diagram] Moving source of a link moves the target too.
 */
public class FixEdgeAnchorAfterCreationDeferredCommand extends AbstractFixEdgeAnchorDeferredCommand {

	/**
	 * the request used to create connection view
	 */
	protected CreateConnectionViewRequest request;

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
	public FixEdgeAnchorAfterCreationDeferredCommand(final TransactionalEditingDomain editingDomain, final CreateConnectionViewRequest request, final IGraphicalEditPart containerEP) {
		super(editingDomain, "Fix Edge Anchor after creation", containerEP); //$NON-NLS-1$
		this.request = request;
	}


	/**
	 * Executes a fix anchor command for the created edge
	 * 
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		//we execute all ui thread
		while(Display.getDefault().readAndDispatch());

		//we refresh the editparts
		RefreshConnectionElementsRunnable refreshRunnable = new RefreshConnectionElementsRunnable(this.request, getContainerEP());
		EditPartUtil.synchronizeRunnableToMainThread(getContainerEP(), refreshRunnable);

		//we do the work
		final AbstractConnectionEditPart connectionEP = refreshRunnable.getResult();
		if(connectionEP != null) {
			final CompoundCommand cc = new CompoundCommand("Fix connections anchors"); //$NON-NLS-1$
			addFixAnchorCommand(connectionEP, cc);
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
		this.request = null;
		super.cleanup();
	}


	/**
	 * 
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
	 * 
	 * @return
	 */
	@Override
	public boolean canExecute() {
		return super.canExecute() && this.request != null;
	}

	/**
	 * 
	 * The runnable used to refresh the views
	 * 
	 */
	private static class RefreshConnectionElementsRunnable extends AbstractRefreshConnectionElementsRunnable<AbstractConnectionEditPart> {

		/**
		 * the connection request
		 */
		final CreateConnectionViewRequest request;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param request
		 *        the request used to create the connection view
		 * @param containerEP
		 *        the edit part owning the new connection editpart
		 * @param containerFigure
		 */
		public RefreshConnectionElementsRunnable(final CreateConnectionViewRequest request, final IGraphicalEditPart containerEP) {
			super(containerEP);
			this.request = request;
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
			final View view = (View)this.request.getConnectionViewDescriptor().getAdapter(View.class);
			if(view != null) {
				final Map<?, ?> epRegistry = getContainerEditPart().getRoot().getViewer().getEditPartRegistry();
				Object editPart = epRegistry.get(view);
				if(editPart instanceof AbstractConnectionEditPart) {
					setResult((AbstractConnectionEditPart)editPart);
					refreshConnection(getResult());
				}
			}
			setStatus(Status.OK_STATUS);
		}
	};

}
