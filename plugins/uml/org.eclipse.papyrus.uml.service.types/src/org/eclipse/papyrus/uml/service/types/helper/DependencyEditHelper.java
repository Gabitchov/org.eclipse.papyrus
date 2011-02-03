/*****************************************************************************
 * Copyright (c) 2010-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This helper is used to set the source and the target for a {@link Dependency}
 */
public class DependencyEditHelper extends DirectedRelationshipEditHelper {

	@Override
	protected EReference getSourceReference() {
		return UMLPackage.eINSTANCE.getDependency_Client();
	}

	@Override
	protected EReference getTargetReference() {
		return UMLPackage.eINSTANCE.getDependency_Supplier();
	}

	@Override
	protected ICommand getDestroyReferenceCommand(DestroyReferenceRequest req) {

		ICommand command = super.getDestroyReferenceCommand(req);

		Dependency elementToEdit = (Dependency)req.getContainer();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToEdit.eContainer());
		if(provider == null) {
			return command;
		}

		boolean shouldDestroyDependency = false;
		if(getSourceReference().equals(req.getContainingFeature()) && (elementToEdit.getClients().size() == 1)) {
			shouldDestroyDependency = true;
		}

		if(getTargetReference().equals(req.getContainingFeature()) && (elementToEdit.getSuppliers().size() == 1)) {
			shouldDestroyDependency = true;
		}

		if(shouldDestroyDependency) {
			DestroyElementRequest destroyRequest = new DestroyElementRequest(elementToEdit, false);
			command = provider.getEditCommand(destroyRequest);
		}

		return command;
	}

	@Override
	protected ICommand getSetCommand(SetRequest req) {

		// If sources or targets are set with an empty list, the dependency 
		// should be destroyed.
		if(getSourceReference().equals(req.getFeature()) || getTargetReference().equals(req.getFeature())) {

			Object values = req.getValue();
			if((values != null) && (values instanceof EList) && ((EList<?>)values).isEmpty()) {

				// Get dependency destroy command from Element Edit Service
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(req.getElementToEdit());
				if(provider != null) {
					DestroyElementRequest destroyRequest = new DestroyElementRequest(req.getElementToEdit(), false);
					ICommand destroyCommand = provider.getEditCommand(destroyRequest);
					return destroyCommand;
				}
			}
		}

		return super.getSetCommand(req);
	}
}
