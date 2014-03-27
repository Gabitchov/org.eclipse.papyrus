/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *      Christian W. Damus (CEA) - bug 413703
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants;
import org.eclipse.uml2.uml.AggregationKind;
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
	 * - add possibly required (UML) association re-factor command when needed.
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeSetCommand(SetRequest request) {
		ICommand gmfCommand = super.getBeforeSetCommand(request);;

		EObject elementToEdit = request.getElementToEdit();

		// Two member ends of an association cannot be set to composite at the same time. To avoid
		// such a situation this helper turns other ends into aggregation none before changing the property aggregation.
		if((elementToEdit instanceof Property) && !(elementToEdit instanceof Port) && (request.getFeature() == UMLPackage.eINSTANCE.getProperty_Aggregation()) && (request.getValue() != AggregationKind.NONE_LITERAL)) {
			Property propertyToEdit = (Property)elementToEdit;
			
			// Only apply if the property is an association end.
			Association relatedAssociation = propertyToEdit.getAssociation();
			if(relatedAssociation != null) {
				Set<Property> members = new HashSet<Property>();
				members.addAll(relatedAssociation.getMemberEnds());
				members.remove(propertyToEdit);

				for(Property member : members) {
					if(member.getAggregation() != AggregationKind.NONE_LITERAL) {
						SetRequest setRequest = new SetRequest(member, UMLPackage.eINSTANCE.getProperty_Aggregation(), AggregationKind.NONE_LITERAL);
						SetValueCommand setAggregationCommand = new SetValueCommand(setRequest);
						gmfCommand = CompositeCommand.compose(gmfCommand, setAggregationCommand);
					}
				}
			}
		}

		// Type set to null implies the property should be removed from association member ends (if related to an Association)
		if((elementToEdit instanceof Property) && !(elementToEdit instanceof Port) && (request.getFeature() == UMLPackage.eINSTANCE.getTypedElement_Type()) && (request.getValue() == null)) {
			Property propertyToEdit = (Property)elementToEdit;
			Association relatedAssociation = propertyToEdit.getAssociation();

			if(relatedAssociation != null) {
				// General case, delete the ConnectorEnd
				DestroyReferenceRequest destroyRefRequest = new DestroyReferenceRequest(relatedAssociation, UMLPackage.eINSTANCE.getAssociation_MemberEnd(), propertyToEdit, false);
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(relatedAssociation);
				if(provider != null) {
					// Add current EObject destroy reference command to the global command
					ICommand destroyMemberRefCommand = provider.getEditCommand(destroyRefRequest);
					gmfCommand = CompositeCommand.compose(gmfCommand, destroyMemberRefCommand);
				}
			}
		}

		if((elementToEdit instanceof Property) && !(elementToEdit instanceof Port) && (request.getFeature() == UMLPackage.eINSTANCE.getTypedElement_Type()) && (request.getValue() instanceof Type)) {

			Property propertyToEdit = (Property)elementToEdit;

			// Find ConnectorEnd referencing the edited Property as partWithPort
			EReference[] refs = new EReference[]{ UMLPackage.eINSTANCE.getConnectorEnd_PartWithPort() };
			@SuppressWarnings("unchecked")
			Collection<ConnectorEnd> referencers = EMFCoreUtil.getReferencers(propertyToEdit, refs);

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(propertyToEdit);
			if(provider != null) {
				for(ConnectorEnd end : referencers) {
					Type newType = (Type)request.getValue();

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

			// Setting new type can be related to an association re-orient (or trigger the association re-orient)
			// Retrieve elements already under re-factor.
			Association relatedAssociation = propertyToEdit.getAssociation();

			// The edited property has to be related to a UML association
			if((relatedAssociation == null) || !(ElementUtil.hasNature(relatedAssociation, UMLElementTypes.UML_NATURE))) {
				return gmfCommand;
			}

			List<EObject> currentlyRefactoredElements = (request.getParameter(RequestParameterConstants.ASSOCIATION_REFACTORED_ELEMENTS) != null) ? (List<EObject>)request.getParameter(RequestParameterConstants.ASSOCIATION_REFACTORED_ELEMENTS) : new ArrayList<EObject>();
			if(!currentlyRefactoredElements.contains(propertyToEdit)) {
				currentlyRefactoredElements.add(propertyToEdit);
				request.getParameters().put(RequestParameterConstants.ASSOCIATION_REFACTORED_ELEMENTS, currentlyRefactoredElements);

				// Current association already under re-factor ?
				if(currentlyRefactoredElements.contains(relatedAssociation)) {
					return gmfCommand;
				}

				ICommand refactorCommand = getAssociationRefactoringCommand(propertyToEdit, relatedAssociation, request);
				gmfCommand = CompositeCommand.compose(gmfCommand, refactorCommand);
			}
		}

		if(gmfCommand != null) {
			gmfCommand = gmfCommand.reduce();
		}

		return gmfCommand;
	}

	/**
	 * Create a re-factoring command related to a Property move.
	 * 
	 * @param setProperty
	 *        the property which type is set
	 * @param associationToRefactor
	 *        the association to re-factor (re-orient action)
	 * @param request
	 *        the original set request
	 * @return the re-factoring command
	 */
	private ICommand getAssociationRefactoringCommand(Property setProperty, Association associationToRefactor, SetRequest request) {

		Association relatedAssociation = setProperty.getAssociation(); // Should not be null, test before calling method.

		// Re-orient the related association (do not use edit service to avoid infinite loop here)
		int direction = ReorientRelationshipRequest.REORIENT_TARGET;
		if(setProperty == associationToRefactor.getMemberEnds().get(1)) {
			direction = ReorientRelationshipRequest.REORIENT_SOURCE;
		}

		ReorientRelationshipRequest reorientRequest = new ReorientRelationshipRequest(relatedAssociation, (Type)request.getValue(), setProperty.eContainer(), direction);
		reorientRequest.addParameters(request.getParameters());

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(relatedAssociation);
		if(provider != null) {
			return provider.getEditCommand(reorientRequest);
		}

		return null;
	}

	@Override
	public void configureRequest(IEditCommandRequest request) {
		if(request instanceof CreateElementRequest) {
			configureCreateElementRequest((CreateElementRequest)request);
		} else {
			super.configureRequest(request);
		}
	}

	protected void configureCreateElementRequest(CreateElementRequest request) {
		if((request.getContainmentFeature() == null) && UMLPackage.Literals.VALUE_SPECIFICATION.isSuperTypeOf(request.getElementType().getEClass())) {
			// Prefer to create value specifications as property default values, not as lower/upper values for multiplicity
			request.setContainmentFeature(UMLPackage.Literals.PROPERTY__DEFAULT_VALUE);
		}
	}
}
