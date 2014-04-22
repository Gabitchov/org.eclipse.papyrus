/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.papyrus.uml.diagram.common.Activator;

/**
 * Utility to execute command inside an action.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CommandUtil {

	/**
	 * Executes the supplied command inside an <code>unchecked action</code>
	 * 
	 * Taken from the CanonicalEditPolicy class
	 * 
	 * @param cmd
	 *        command that can be executed (i.e., cmd.canExecute() == true)
	 * @param part
	 */
	public static void executeCommand(final Command cmd, IGraphicalEditPart part) {
		Map<String, Boolean> options = null;
		boolean isActivating = true;
		// use the viewer to determine if we are still initializing the diagram
		// do not use the DiagramEditPart.isActivating since
		// ConnectionEditPart's parent will not be a diagram edit part
		EditPartViewer viewer = part.getViewer();
		if(viewer instanceof DiagramGraphicalViewer) {
			isActivating = ((DiagramGraphicalViewer)viewer).isInitializing();
		}

		if(isActivating || !EditPartUtil.isWriteTransactionInProgress(part, false, false))
			options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);

		AbstractEMFOperation operation = new AbstractEMFOperation((part).getEditingDomain(), StringStatics.BLANK, options) {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

				cmd.execute();

				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Activator.log.error(e);
		}
	}

}
