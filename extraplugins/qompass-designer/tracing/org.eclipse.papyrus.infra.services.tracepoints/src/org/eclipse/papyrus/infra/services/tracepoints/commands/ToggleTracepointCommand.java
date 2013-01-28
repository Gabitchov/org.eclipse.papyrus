/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.tracepoints.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.papyrus.infra.services.tracepoints.TraceActions;
import org.eclipse.papyrus.infra.services.tracepoints.TraceMechanism;
import org.eclipse.papyrus.infra.services.tracepoints.TracepointConstants;


public class ToggleTracepointCommand extends AbstractTracepointCommand {

	public ToggleTracepointCommand(EObject selectedElement) {
		super("Toggle tracepoint", TransactionUtil.getEditingDomain(selectedElement), selectedElement);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		updateResourceAndURI();
		try {
			IMarker marker = toggleMarker();
			marker.setAttribute(TracepointConstants.isTracepoint, true);
			// set default options from preferences
			marker.setAttribute(TracepointConstants.traceAction, TraceActions.actionFromPreferences(selectedElement));
			marker.setAttribute(TracepointConstants.traceMechanism, TraceMechanism.getDefaultMechanism(selectedElement));
		} catch (CoreException e) {

		}
		return null;
	}
}
