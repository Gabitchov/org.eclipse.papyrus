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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.command;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;

public class AttachInstanceSpecifcationCommand extends AbstractTransactionalCommand {

	protected IAdaptable viewAdapter;

	protected EditPartViewer viewer;

	public AttachInstanceSpecifcationCommand(TransactionalEditingDomain domain, IAdaptable viewAdapter,
			EditPartViewer viewer) {
		super(domain, "attach instance", null);
		this.viewAdapter = viewAdapter;
		this.viewer = viewer;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		View view = (View)viewAdapter.getAdapter(View.class);
		if(view != null && view.eContainer() != null) {
			View parent = (View)view.eContainer();
			InstanceSpecification instanceSpecification = org.eclipse.uml2.uml.UMLFactory.eINSTANCE
					.createInstanceSpecification();
			if(parent.getElement() instanceof Package) {
				((Package)parent.getElement()).getPackagedElements().add(instanceSpecification);
			}
			view.setElement(instanceSpecification);
		}
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public List getAffectedFiles() {
		if(viewer != null) {
			EditPart editpart = viewer.getRootEditPart().getContents();
			if(editpart instanceof IGraphicalEditPart) {
				View view = (View)((IGraphicalEditPart)editpart).getModel();
				if(view != null) {
					IFile f = WorkspaceSynchronizer.getFile(view.eResource());
					return f != null ? Collections.singletonList(f) : Collections.EMPTY_LIST;
				}
			}
		}
		return super.getAffectedFiles();
	}
}
