/*****************************************************************************
 * Copyright (c) 2010-2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
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
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This HelperAdvice completes {@link Classifier} edit commands with the deletion of :
 * - any Generalization related to the Classifier (source or target).
 * - any Association related to the Classifier (source or target type).
 * 
 * This helper also add Association re-factor command when an Association member end is
 * moved.
 * 
 * </pre>
 */
public class ClassifierHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * While deleting a Classifier:
	 * - remove {@link Generalization} in which this Classifier is involved
	 * - remove {@link Association} in which this Classifier is involved
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		List<EObject> dependents = new ArrayList<EObject>();
		if(request.getElementToDestroy() instanceof Classifier) {

			Classifier classifierToDelete = (Classifier)request.getElementToDestroy();

			// Get related generalizations
			dependents.addAll(classifierToDelete.getSourceDirectedRelationships(UMLPackage.eINSTANCE.getGeneralization()));
			dependents.addAll(classifierToDelete.getTargetDirectedRelationships(UMLPackage.eINSTANCE.getGeneralization()));

			// Get related association for this classifier, then delete member ends for which this classifier is the type.
			for(Association association : classifierToDelete.getAssociations()) {
				for(Property end : association.getMemberEnds()) {
					if(end.getType() == classifierToDelete) {
						dependents.add(association);
					}
				}
			}
		}

		// Return the command to destroy all these dependent elements
		if(!dependents.isEmpty()) {
			return request.getDestroyDependentsCommand(dependents);
		}

		return null;
	}

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * While moving a {@link Property} to a Classifier:
	 * - re-orient Association possibly related to the moved Property
	 * - remove deprecated connectorEnd
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeMoveCommand(MoveRequest request) {

		ICommand gmfCommand = super.getBeforeMoveCommand(request);


		// Find any ConnectorEnd that would become invalid after the Property move
		for(Object movedObject : request.getElementsToMove().keySet()) {

			// Select Property (excluding Port) in the list of moved elements
			if(!(movedObject instanceof Property) || (movedObject instanceof Port)) {
				continue;
			}

			// Find ConnectorEnd referencing the edited Property as partWithPort or role
			Property movedProperty = (Property)movedObject;
			EReference[] refs = new EReference[]{ UMLPackage.eINSTANCE.getConnectorEnd_PartWithPort(), UMLPackage.eINSTANCE.getConnectorEnd_Role() };
			@SuppressWarnings("unchecked")
			Collection<ConnectorEnd> referencers = EMFCoreUtil.getReferencers(movedProperty, refs);

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(movedProperty);
			if(provider != null) {
				for(ConnectorEnd end : referencers) {
					// General case, delete the ConnectorEnd
					DestroyElementRequest req = new DestroyElementRequest(end, false);
					ICommand deleteCommand = provider.getEditCommand(req);

					// Add current EObject destroy command to the global command
					gmfCommand = CompositeCommand.compose(gmfCommand, deleteCommand);
				}
			}
		}


		// Treat related associations that required a re-factor action
		// Retrieve elements already under re-factor.
		List<EObject> currentlyRefactoredElements = (request.getParameter(RequestParameterConstants.ASSOCIATION_REFACTORED_ELEMENTS) != null) ? (List<EObject>)request.getParameter(RequestParameterConstants.ASSOCIATION_REFACTORED_ELEMENTS) : new ArrayList<EObject>();

		// Find Associations related to any moved Property
		for(Object movedObject : request.getElementsToMove().keySet()) {

			// Select Property (excluding Port) in the list of moved elements
			if(!(movedObject instanceof Property) || (movedObject instanceof Port)) {
				continue;
			}

			Property movedProperty = (Property)movedObject;
			Association relatedAssociation = movedProperty.getAssociation();

			// The moved property has to be related to a UML association
			if((movedProperty.getAssociation() == null) || !(ElementUtil.hasNature(movedProperty.getAssociation(), UMLElementTypes.UML_NATURE))) {
				continue;
			}

			// Make sure the target differs from current container
			if((movedProperty.eContainer() == request.getTargetContainer()) && (movedProperty.eContainingFeature() == request.getTargetFeature(movedProperty))) {
				continue;
			}

			// Moved element already under re-factor ?
			if(currentlyRefactoredElements.contains(movedObject) || currentlyRefactoredElements.contains(relatedAssociation)) {
				continue;

			} else {
				currentlyRefactoredElements.add((EObject)movedObject);
				request.getParameters().put(RequestParameterConstants.ASSOCIATION_REFACTORED_ELEMENTS, currentlyRefactoredElements);
			}

			ICommand refactorCommand = getAssociationRefactoringCommand(movedProperty, relatedAssociation, request);
			gmfCommand = CompositeCommand.compose(gmfCommand, refactorCommand);
		}

		if(gmfCommand != null) {
			gmfCommand = gmfCommand.reduce();
		}

		return gmfCommand;
	}

	/**
	 * Create a re-factoring command related to a Property move.
	 * 
	 * @param movedProperty
	 *        the moved property
	 * @param associationToRefactor
	 *        the association to re-factor (re-orient action)
	 * @param request
	 *        the original move request
	 * @return the re-factoring command
	 */
	private ICommand getAssociationRefactoringCommand(Property movedProperty, Association associationToRefactor, MoveRequest request) {

		Association relatedAssociation = movedProperty.getAssociation(); // Should not be null, test before calling method.

		// Re-orient the related association (do not use edit service to avoid infinite loop here)
		int direction = ReorientRelationshipRequest.REORIENT_TARGET;
		if(movedProperty == associationToRefactor.getMemberEnds().get(0)) {
			direction = ReorientRelationshipRequest.REORIENT_SOURCE;
		}

		ReorientRelationshipRequest reorientRequest = new ReorientRelationshipRequest(relatedAssociation, request.getTargetContainer(), movedProperty.eContainer(), direction);
		reorientRequest.addParameters(request.getParameters());

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(relatedAssociation);
		if(provider != null) {
			return provider.getEditCommand(reorientRequest);
		}

		return null;
	}
}
