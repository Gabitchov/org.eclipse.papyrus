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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest.ConnectionViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.util.OccurrenceSpecificationHelper;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.OccurrenceSpecification;


/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class RepairExecutionSpecificationEndCommand extends AbstractTransactionalCommand {

	private CreateConnectionViewAndElementRequest request;

	/**
	 * Constructor.
	 * 
	 * @param domain
	 * @param label
	 * @param affectedFiles
	 */
	public RepairExecutionSpecificationEndCommand(TransactionalEditingDomain domain, CreateConnectionViewAndElementRequest request) {
		super(domain, "Repair Execution Specification Ends", null);
		this.request = request;
	}

	public List getAffectedFiles() {
		ConnectionViewAndElementDescriptor descriptor = request.getConnectionViewAndElementDescriptor();
		View view = (View)descriptor.getAdapter(View.class);

		if(view != null) {
			List result = new ArrayList();
			IFile file = WorkspaceSynchronizer.getFile(view.eResource());

			if(file != null) {
				result.add(file);
			}
			return result;
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
		ConnectionViewAndElementDescriptor descriptor = request.getConnectionViewAndElementDescriptor();
		if(descriptor != null) {
			Edge view = (Edge)descriptor.getAdapter(View.class);
			OccurrenceSpecificationHelper.repairExecutionSpecificationEnds(view);
		}
		return CommandResult.newOKCommandResult();
	}

}
