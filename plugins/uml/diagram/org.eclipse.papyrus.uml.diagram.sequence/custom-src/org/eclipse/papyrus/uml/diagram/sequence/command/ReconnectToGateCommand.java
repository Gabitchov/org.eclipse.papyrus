/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class ReconnectToGateCommand extends AbstractTransactionalCommand {

	public static final String REDIRECT_GATE_FAILED = "Reconnect to gate failed.";

	private EditPartViewer editPartViewer;

	private IAdaptable newEndAdapter;

	private ReconnectRequest reconnectRequest;

	private Command command;

	/**
	 * Constructor.
	 * 
	 * @param domain
	 * @param label
	 * @param affectedFiles
	 */
	public ReconnectToGateCommand(TransactionalEditingDomain domain, EditPartViewer editPartViewer, IAdaptable newEndAdapter, ReconnectRequest reconnectRequest) {
		super(domain, "Reconnect Relationship", null);
		this.editPartViewer = editPartViewer;
		this.newEndAdapter = newEndAdapter;
		this.reconnectRequest = reconnectRequest;
	}

	/**
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
	 * 
	 * @return
	 */
	@Override
	public boolean canExecute() {
		return editPartViewer != null && newEndAdapter != null && reconnectRequest != null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getAffectedFiles() {
		if(newEndAdapter != null) {
			View view = (View)newEndAdapter.getAdapter(View.class);
			if(view != null) {
				List result = new ArrayList();
				IFile file = WorkspaceSynchronizer.getFile(view.eResource());
				if(file != null) {
					result.add(file);
				}
				return result;
			}
		}
		return super.getAffectedFiles();
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		View view = (View)newEndAdapter.getAdapter(View.class);
		EditPart target = (EditPart)editPartViewer.getEditPartRegistry().get(view);
		boolean redirected = false;
		EditPart oldTarget = reconnectRequest.getTarget();
		Point location = reconnectRequest.getLocation();
		if(target != null) {
			reconnectRequest.setTargetEditPart(target);
			reconnectRequest.setLocation(SequenceUtil.getAbsoluteBounds((IGraphicalEditPart)target).getCenter());
			command = target.getCommand(reconnectRequest);
			if(command != null && command.canExecute()) {
				command.execute();
				redirected = true;
			}
		}
		if(!redirected) {
			reconnectRequest.setTargetEditPart(oldTarget);
			reconnectRequest.setLocation(location);
			reconnectRequest.getExtendedData().put(REDIRECT_GATE_FAILED, Boolean.TRUE);
			command = oldTarget.getCommand(reconnectRequest);
			if(command != null && command.canExecute()) {
				command.execute();
			}
		}
		return CommandResult.newOKCommandResult();
	}

}
