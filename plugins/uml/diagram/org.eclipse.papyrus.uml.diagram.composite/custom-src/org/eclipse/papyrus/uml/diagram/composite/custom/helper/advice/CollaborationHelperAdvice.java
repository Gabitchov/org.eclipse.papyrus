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
package org.eclipse.papyrus.uml.diagram.composite.custom.helper.advice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * This advice is used to remove the view of the Collaboration roles
 * 
 */
public class CollaborationHelperAdvice extends AbstractEditHelperAdvice {

	/** The hint of Collaboration role (not always possible to distinguish role and property with the model information). */
	final String COLLABORATION_ROLE_HINT = ((IHintedType)UMLElementTypes.ConnectableElement_3115).getSemanticHint();

	/** The hint of Collaboration role (not always possible to distinguish role and property with the model information). */
	final String ROLE_BINDING_HINT = ((IHintedType)UMLElementTypes.Dependency_4017).getSemanticHint();

	@Override
	protected ICommand getBeforeDestroyReferenceCommand(DestroyReferenceRequest request) {

		EObject elementToEdit = request.getContainer();
		Set<View> viewsToDelete = new HashSet<View>();

		// Test if current destroy reference is removing a Property from Collaboration role
		if((elementToEdit instanceof Collaboration) && (request.getContainingFeature() == UMLPackage.eINSTANCE.getCollaboration_CollaborationRole())) {

			// Removed referenced ConnectableElement from roles 
			ConnectableElement refRole = (ConnectableElement)request.getReferencedObject();
			Collaboration collaborationToEdit = (Collaboration)elementToEdit;

			viewsToDelete.addAll(getViewsForRole(refRole, collaborationToEdit));
		}

		if((viewsToDelete != null) && !(viewsToDelete.isEmpty())) {
			DestroyDependentsRequest req = new DestroyDependentsRequest(request.getEditingDomain(), elementToEdit, false);
			req.setClientContext(request.getClientContext());
			req.addParameters(request.getParameters());
			return req.getDestroyDependentsCommand(viewsToDelete);
		}

		return null;
	}

	@Override
	protected ICommand getBeforeSetCommand(SetRequest request) {

		EObject elementToEdit = request.getElementToEdit();
		Set<View> viewsToDelete = new HashSet<View>();

		if((elementToEdit instanceof Collaboration) && (request.getFeature() == UMLPackage.eINSTANCE.getCollaboration_CollaborationRole())) {

			Collaboration collaborationToEdit = (Collaboration)elementToEdit;

			// Get the list of roles currently removed
			Set<ConnectableElement> removedRoles = new HashSet<ConnectableElement>();
			removedRoles.addAll(collaborationToEdit.getRoles());
			if(request.getValue() instanceof ConnectableElement) {
				removedRoles.remove(request.getValue());
			} else if(request.getValue() instanceof List<?>) {
				removedRoles.removeAll((List<?>)request.getValue());
			}

			// Parse removed roles and find views to delete
			Iterator<ConnectableElement> it = removedRoles.iterator();
			while(it.hasNext()) {
				ConnectableElement currentRole = it.next();
				viewsToDelete.addAll(getViewsForRole(currentRole, collaborationToEdit));
			}

		}

		if((viewsToDelete != null) && !(viewsToDelete.isEmpty())) {
			DestroyDependentsRequest req = new DestroyDependentsRequest(request.getEditingDomain(), elementToEdit, false);
			req.setClientContext(request.getClientContext());
			req.addParameters(request.getParameters());
			return req.getDestroyDependentsCommand(viewsToDelete);
		}

		return null;
	}

	/**
	 * <pre>
	 * This method retrieves all views (only in Composite Structure Diagrams) that are representing the role.
	 * </pre>
	 * 
	 * @param role
	 *        the {@link ConnectableElement} currently removed from role list
	 * @param modifiedCollaboration
	 *        the {@link Collaboration} currently modified
	 * @return the views that should be deleted
	 */
	private Set<View> getViewsForRole(ConnectableElement role, Collaboration modifiedCollaboration) {

		Set<View> viewsToDelete = new HashSet<View>();

		// Get all view for the role in Composite Structure Diagrams
		Set<View> collaborationToEditViews = CrossReferencerUtil.getCrossReferencingViews(modifiedCollaboration, CompositeStructureDiagramEditPart.MODEL_ID);

		// Parse views of the edited Collaboration
		for(View currentCollaborationView : collaborationToEditViews) {

			Iterator<EObject> it = currentCollaborationView.eAllContents();
			while(it.hasNext()) {
				EObject currentChildObject = it.next();
				if(currentChildObject instanceof View) {
					View currentChildView = (View)currentChildObject;

					if((COLLABORATION_ROLE_HINT.equals(currentChildView.getType())) && (currentChildView.getElement() == role)) {
						viewsToDelete.add(currentChildView);
					}
				}
			}
		}

		return viewsToDelete;
	}
}
