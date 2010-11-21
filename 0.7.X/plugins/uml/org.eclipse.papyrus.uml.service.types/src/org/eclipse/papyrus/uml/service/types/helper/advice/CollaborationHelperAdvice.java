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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Helper advice for all {@link Collaboration} elements.
 */
public class CollaborationHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
		List<EObject> dependentsToDestroy = new ArrayList<EObject>();

		Collaboration collaboration = (Collaboration)request.getElementToDestroy();
		dependentsToDestroy.addAll(getRelatedRoleBindings(collaboration, null));

		// return command to destroy dependents
		if(!dependentsToDestroy.isEmpty()) {
			return request.getDestroyDependentsCommand(dependentsToDestroy);
		}

		return null;
	}

	@Override
	protected ICommand getBeforeDestroyReferenceCommand(DestroyReferenceRequest request) {
		ICommand gmfCommand = null;

		EObject elementToEdit = request.getContainer();

		// Test if current destroy reference is removing a Role from Collaboration role, and destroy related role bindings
		if((elementToEdit instanceof Collaboration) && (request.getContainingFeature() == UMLPackage.eINSTANCE.getCollaboration_CollaborationRole())) {

			Collaboration collaboration = (Collaboration)elementToEdit;

			// Parse relatedBindings
			Iterator<Dependency> bindingsIt = getRelatedRoleBindings(collaboration, (ConnectableElement)request.getReferencedObject()).iterator();
			while(bindingsIt.hasNext()) {
				Dependency binding = bindingsIt.next();

				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(binding.eContainer());
				if(provider != null) {

					// Retrieve delete command from the Element Edit service
					DestroyElementRequest req = new DestroyElementRequest(binding, false);
					ICommand deleteCommand = provider.getEditCommand(req);

					// Add current EObject destroy command to the global command
					gmfCommand = CompositeCommand.compose(gmfCommand, deleteCommand);
				}
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

		// Test if current destroy reference is removing a Role from Collaboration role, and destroy related role bindings
		if((elementToEdit instanceof Collaboration) && (request.getFeature() == UMLPackage.eINSTANCE.getCollaboration_CollaborationRole())) {

			Collaboration collaboration = (Collaboration)elementToEdit;

			// Parse removed roles and find related RoleBindings that need to be deleted
			Set<ConnectableElement> deletedRoles = new HashSet<ConnectableElement>();
			deletedRoles.addAll(collaboration.getRoles());
			deletedRoles.removeAll((List<ConnectableElement>)request.getValue());

			// Parse roles and create deletion command for related bindings
			Iterator<ConnectableElement> it = deletedRoles.iterator();
			while(it.hasNext()) {
				ConnectableElement role = it.next();

				// Parse relatedBindings
				Iterator<Dependency> bindingsIt = getRelatedRoleBindings(collaboration, role).iterator();
				while(bindingsIt.hasNext()) {
					Dependency binding = bindingsIt.next();

					IElementEditService provider = ElementEditServiceUtils.getCommandProvider(binding.eContainer());
					if(provider != null) {

						// Retrieve delete command from the Element Edit service
						DestroyElementRequest req = new DestroyElementRequest(binding, false);
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

	/**
	 * <pre>
	 * This method retrieve all the role bindings related to a specific role.
	 * </pre>
	 * 
	 * @param collaboration
	 *        the {@link Collaboration} owning the role
	 * @param role
	 *        the role (if null, all roles are considered)
	 * @return role bindings connecting the role
	 */
	private Set<Dependency> getRelatedRoleBindings(Collaboration collaboration, ConnectableElement role) {

		Set<Dependency> roleBindings = new HashSet<Dependency>();

		EReference[] ref = { UMLPackage.eINSTANCE.getCollaborationUse_Type() };
		Collection<?> refs = EMFCoreUtil.getReferencers(collaboration, ref);

		Iterator<?> it = refs.iterator();

		while(it.hasNext()) {
			Object object = it.next();
			if(object instanceof CollaborationUse) {

				CollaborationUse collaborationUse = (CollaborationUse)object;

				Iterator<Dependency> itBindings = collaborationUse.getRoleBindings().iterator();
				while(itBindings.hasNext()) {
					Dependency roleBinding = itBindings.next();

					if((role == null) || (roleBinding.getClients().contains(role))) {
						roleBindings.add(roleBinding);
					}
				}
			}
		}
		return roleBindings;
	}
}
