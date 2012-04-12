/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.merger.provider;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.compare.merger.utils.MoveWithIndexCommand;
import org.eclipse.papyrus.uml.compare.merger.utils.MoveWithIndexRequest;


public class PapyrusMergeCommandProvider {

	public static PapyrusMergeCommandProvider INSTANCE = new PapyrusMergeCommandProvider();

	private PapyrusMergeCommandProvider() {

	}

	public Command getDestroyCommand(final TransactionalEditingDomain domain, final EObject element) {
		final IEditCommandRequest request = new DestroyElementRequest(domain, element, false);
		return getCommand(element, request);
	}

	//TODO elementToEdit and targetContainer are the same
	public Command getMoveCommand(final TransactionalEditingDomain domain, final EObject elementToEdit, final EObject targetContainer, final EReference targetFeature, final EObject elementToMove) {
		final IEditCommandRequest request = new MoveRequest(domain, targetContainer, targetFeature, elementToMove);
		return getCommand(elementToEdit, request);
	}

	private Command getCommand(final EObject elementToEdit, final IEditCommandRequest request) {
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToEdit);
		if(request instanceof MoveWithIndexRequest) {//TODO remove this test when the move with index will be in the service edit
			return new GMFtoEMFCommandWrapper(new MoveWithIndexCommand((MoveRequest)request));
		}
		if(provider != null) {
			return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
		}
		return null;
	}

	public Command getSetCommand(final TransactionalEditingDomain domain, final EObject element, final EStructuralFeature feature, final Object value) {
		final IEditCommandRequest request = new SetRequest(domain, element, feature, value);
		return getCommand(element, request);
	}

	public Command getSetXMIIDCommand(final TransactionalEditingDomain domain, final EObject element, final String id) {
		//TODO change for an EMFCommand
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Set XMI Command", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				if(element != null && element.eResource() instanceof XMIResource) {
					((XMIResource)element.eResource()).setID(element, id);
				}
				return CommandResult.newOKCommandResult();
			}
		});

	}

	public Command getAddToResourceCommand(final TransactionalEditingDomain domain, final Resource res, final EObject eobjectToAdd) {
		//TODO change for an EMFCommand
		return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Add EObject to Resource Command", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				res.getContents().add(eobjectToAdd);
				return CommandResult.newOKCommandResult();
			}
		});
	}

	//TODO elementToEdit and targetContainer are the same
	public Command getMoveWithIndexCommand(final TransactionalEditingDomain domain, final EObject elementToEdit, final EObject targetContainer, final EReference targetFeature, final EObject elementToMove, final int index) {
		final IEditCommandRequest request = new MoveWithIndexRequest(domain, targetContainer, targetFeature, elementToMove, index);
		return getCommand(elementToEdit, request);
	}
}
