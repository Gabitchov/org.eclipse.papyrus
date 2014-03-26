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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;


/**
 * 
 * abstract runnable used to refresh the connection, source and target editparts
 * 
 */
public abstract class AbstractRefreshConnectionElementsRunnable<T> implements RunnableWithResult<T> {

	/**
	 * the status of the runnable
	 */
	private IStatus status;

	/**
	 * the result of the runnable
	 */
	private T result;

	/**
	 * the container editpart of the refreshed connection
	 */
	private final IGraphicalEditPart containerEP;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param containerEP
	 *        the editpart owning the connection
	 */
	public AbstractRefreshConnectionElementsRunnable(final IGraphicalEditPart containerEP) {
		this.containerEP = containerEP;
	}

	/**
	 * 
	 * @see org.eclipse.emf.transaction.RunnableWithResult#getResult()
	 * 
	 * @return
	 */
	public final T getResult() {
		return result;
	}

	/**
	 * 
	 * @see org.eclipse.emf.transaction.RunnableWithResult#setStatus(org.eclipse.core.runtime.IStatus)
	 * 
	 * @param status
	 *        set the new status for the runnable
	 */
	public final void setStatus(IStatus status) {
		this.status = status;
	}

	/**
	 * 
	 * @see org.eclipse.emf.transaction.RunnableWithResult#getStatus()
	 * 
	 * @return
	 *         the status of the runnable
	 */
	public final IStatus getStatus() {
		return status;
	}

	/**
	 * 
	 * @return
	 *         the container edit part
	 */
	protected final IGraphicalEditPart getContainerEditPart() {
		return this.containerEP;
	}
	/**
	 * 
	 * @param connectionToRefresh
	 *        the connection edit part to refresh
	 */
	protected final void refreshConnection(final AbstractConnectionEditPart connectionToRefresh) {
		connectionToRefresh.refresh();
		final EditPart sourceEp = connectionToRefresh.getSource();
		if(sourceEp != null) {
			sourceEp.refresh();
		}
		final EditPart targetEP = connectionToRefresh.getTarget();
		if(targetEP != null) {
			targetEP.refresh();
		}
		//to force the call to the router, to update the figure
		connectionToRefresh.getFigure().validate();
	}

	/**
	 * 
	 * @return
	 *         the figure for the container edit part
	 */
	protected final IFigure getContainerFigure() {
		return this.containerEP.getFigure();
	}

	/**
	 * 
	 * @param result
	 *        set the result of the runnable
	 */
	protected final void setResult(T result) {
		this.result = result;
	}
	
};