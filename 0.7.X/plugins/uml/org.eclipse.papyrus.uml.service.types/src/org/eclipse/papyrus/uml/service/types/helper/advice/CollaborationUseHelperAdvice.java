/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Helper advice for all {@link CollaborationUse} elements.
 */
public class CollaborationUseHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeDestroyReferenceCommand(DestroyReferenceRequest request) {
		ICommand gmfCommand = null;

		EObject elementToEdit = request.getContainer();

		// Test if current destroy reference is removing a RoleBinding from CollaborationUse role, and destroy this role binding
		if((elementToEdit instanceof CollaborationUse) && (request.getContainingFeature() == UMLPackage.eINSTANCE.getCollaborationUse_RoleBinding())) {

			CollaborationUse cUse = (CollaborationUse)elementToEdit;

			// Removing referenced Dependency from roleBinding should delete the dependency
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(cUse);
			if(provider != null) {

				// Retrieve delete command from the Element Edit service
				DestroyElementRequest req = new DestroyElementRequest(request.getReferencedObject(), false);
				ICommand deleteCommand = provider.getEditCommand(req);

				// Add current EObject destroy command to the global command
				gmfCommand = CompositeCommand.compose(gmfCommand, deleteCommand);
			}
		}

		if(gmfCommand != null) {
			gmfCommand = gmfCommand.reduce();
		}

		return gmfCommand;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ICommand getBeforeSetCommand(SetRequest request) {
		ICommand gmfCommand = null;

		EObject elementToEdit = request.getElementToEdit();

		// Test if current set command is removing a RoleBinding(s) from CollaborationUse role, and destroy this role binding
		if((elementToEdit instanceof CollaborationUse) && (request.getFeature() == UMLPackage.eINSTANCE.getCollaborationUse_RoleBinding())) {

			CollaborationUse cUse = (CollaborationUse)elementToEdit;

			// Removing referenced Dependency from roleBinding should delete the dependency
			Set<Dependency> roleBindingsToDelete = new HashSet<Dependency>();
			roleBindingsToDelete.addAll(cUse.getRoleBindings());
			roleBindingsToDelete.removeAll((List<Dependency>)request.getValue());

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(cUse);
			if(provider != null) {
				// Parse roleBindings and create deletion command
				Iterator<Dependency> it = roleBindingsToDelete.iterator();
				while(it.hasNext()) {
					Dependency roleBinding = it.next();

					// Retrieve delete command from the Element Edit service
					DestroyElementRequest req = new DestroyElementRequest(roleBinding, false);
					ICommand deleteCommand = provider.getEditCommand(req);

					// Add current EObject destroy command to the global command
					gmfCommand = CompositeCommand.compose(gmfCommand, deleteCommand);
				}
			}
		}

		// Test if current set command is modifying the type of the CollaborationUse
		if((elementToEdit instanceof CollaborationUse) && (request.getFeature() == UMLPackage.eINSTANCE.getCollaborationUse_Type())) {

			CollaborationUse cUse = (CollaborationUse)elementToEdit;

			Collaboration newType = (Collaboration)request.getValue();
			if(newType != cUse.getType()) {

				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(cUse);
				if(provider != null) {

					// Parse roleBindings and create deletion command for all
					Iterator<Dependency> it = cUse.getRoleBindings().iterator();
					while(it.hasNext()) {
						Dependency roleBinding = it.next();

						// Retrieve delete command from the Element Edit service
						DestroyElementRequest req = new DestroyElementRequest(roleBinding, false);
						ICommand deleteCommand = provider.getEditCommand(req);

						// Add current EObject destroy command to the global command
						gmfCommand = CompositeCommand.compose(gmfCommand, deleteCommand);
					}
				}
			}

		}

		if(gmfCommand != null) {
			gmfCommand = gmfCommand.reduce();
		}

		return gmfCommand;
	}
}
