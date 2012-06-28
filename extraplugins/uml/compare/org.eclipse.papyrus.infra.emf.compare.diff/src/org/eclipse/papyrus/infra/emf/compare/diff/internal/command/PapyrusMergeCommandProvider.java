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
package org.eclipse.papyrus.infra.emf.compare.diff.internal.command;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

//TODO : try to merge with the PapyrusTableCommandFactory?
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

	public Command getCommand(final EObject elementToEdit, final IEditCommandRequest request) {
		final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToEdit);
		if(request instanceof MoveWithIndexRequest) {//TODO remove this test when the move with index will be in the service edit
			return new GMFtoEMFCommandWrapper(new MoveWithIndexCommand((MoveRequest)request));
		}
		if(provider != null) {
			return new GMFtoEMFCommandWrapper(provider.getEditCommand(request));
		}
		return null;
	}

	public Command getDestroyReferenceCommand(final TransactionalEditingDomain editingDomain, final EObject container, final EReference containingFeature, final EObject referencedObject, final boolean confirmationRequired) {
		final IEditCommandRequest request = new DestroyReferenceRequest(editingDomain, container, containingFeature, referencedObject, confirmationRequired);
		return getCommand(container, request);
	}

	public Command getSetCommand(final TransactionalEditingDomain domain, final EObject element, final EStructuralFeature feature, final Object value) {
		final IEditCommandRequest request = new SetRequest(domain, element, feature, value);
		return getCommand(element, request);
	}


	//TODO elementToEdit and targetContainer are the same
	public Command getMoveWithIndexCommand(final TransactionalEditingDomain domain, final EObject elementToEdit, final EObject targetContainer, final EReference targetFeature, final EObject elementToMove, final int index, final boolean reorder) {
		final IEditCommandRequest request = new MoveWithIndexRequest(domain, targetContainer, targetFeature, elementToMove, index, reorder);
		return getCommand(elementToEdit, request);
	}

}
