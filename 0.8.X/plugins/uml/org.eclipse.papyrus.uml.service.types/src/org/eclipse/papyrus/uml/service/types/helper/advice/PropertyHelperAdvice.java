/*****************************************************************************
 * Copyright (c) 2010-2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This HelperAdvice completes {@link Property} edit commands with:
 * 		- the deletion of any ConnectorEnd related to the Property.
 * 		- the deletion of any {@link Association} related to the Property when less than 2 ends remains. 
 * </pre>
 */
public class PropertyHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * While deleting a {@link Property}:
	 * - remove related {@link ConnectorEnd}
	 * - remove related {@link Association} when less than 2 ends remains.
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		List<EObject> dependents = new ArrayList<EObject>();
		EReference[] refs = null;

		if(request.getElementToDestroy() instanceof Property) {
			Property propertyToDelete = (Property)request.getElementToDestroy();

			// Get related ConnectorEnd to be destroyed with the property
			// Possible references from ConnectorEnd to Property (or Port)
			refs = new EReference[]{ UMLPackage.eINSTANCE.getConnectorEnd_Role(), UMLPackage.eINSTANCE.getConnectorEnd_PartWithPort() };
			@SuppressWarnings("unchecked")
			Collection<ConnectorEnd> connectorEndRefs = EMFCoreUtil.getReferencers(propertyToDelete, refs);

			dependents.addAll(connectorEndRefs);

			// Get possible associations using this Property as end
			refs = new EReference[]{ UMLPackage.eINSTANCE.getAssociation_MemberEnd() };
			@SuppressWarnings("unchecked")
			Collection<Association> associationRefs = EMFCoreUtil.getReferencers(propertyToDelete, refs);
			for(Association association : associationRefs) {

				// Test the number of  remaining ends considering the dependents elements deletion in progress
				List<Property> remainingMembers = new ArrayList<Property>();
				remainingMembers.addAll(association.getMemberEnds());
				remainingMembers.removeAll(request.getDependentElementsToDestroy());

				if(remainingMembers.size() <= 2) {
					dependents.add(association);
				}
			}
		}

		// Return the command to destroy all these dependents
		if(!dependents.isEmpty()) {
			return request.getDestroyDependentsCommand(dependents);
		}

		return null;
	}
	
	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * While setting {@link Property} (excluding {@link Port}) type:
	 * - remove related {@link ConnectorEnd} if they become inconsistent due to the new {@link Type}.
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeSetCommand(SetRequest request) {
		ICommand gmfCommand = null;

		Type newType = null;
		EObject elementToEdit = request.getElementToEdit();

		if((elementToEdit instanceof Property) && !(elementToEdit instanceof Port) && (request.getFeature() == UMLPackage.eINSTANCE.getTypedElement_Type()) && (request.getValue() instanceof Type)) {

			Property propertyToEdit = (Property)elementToEdit;

			// Find ConnectorEnd referencing the edited Property as partWithPort
			EReference[] refs = new EReference[]{ UMLPackage.eINSTANCE.getConnectorEnd_PartWithPort() };
			@SuppressWarnings("unchecked")
			Collection<ConnectorEnd> referencers = EMFCoreUtil.getReferencers(propertyToEdit, refs);

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(propertyToEdit);
			if(provider != null) {
				for(ConnectorEnd end : referencers) {
					newType = (Type)request.getValue();

					// End role should be a Port
					ConnectableElement cElt = end.getRole();
					if((newType != null) && (newType instanceof EncapsulatedClassifier) && (cElt != null) && (cElt instanceof Port)) {

						// Take the new type into account to decide if current role and partWithPort will remains 
						// valid after type modification.
						Port role = (Port)cElt;
						EncapsulatedClassifier composite = (EncapsulatedClassifier)newType;

						// If the role is valid, the ConnectorEnd should not be deleted
						if(composite.getAllAttributes().contains(role)) {
							continue;
						}
					}

					// General case, delete the ConnectorEnd
					DestroyElementRequest req = new DestroyElementRequest(end, false);
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
}
