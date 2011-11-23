/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.sysml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This HelperAdvice completes {@link Classifier} edit commands with :
 * 		- possibly required (sysML) association re-factor command.
 * </pre>
 */
public class ClassifierEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * While moving a {@link Property} to a Classifier:
	 * - add possibly required (sysML) association re-factor command when needed.
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeMoveCommand(MoveRequest request) {

		ICommand gmfCommand = super.getBeforeMoveCommand(request);

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

			// The moved property has to be related to a SysML association
			if((relatedAssociation == null) || !(ElementUtil.hasNature(relatedAssociation, SysMLElementTypes.SYSML_NATURE))) {
				continue;
			}

			// Make sure the target differs from current container
			if((movedProperty.eContainer() == request.getTargetContainer()) && (movedProperty.eContainingFeature() == request.getTargetFeature(movedProperty))) {
				continue;
			}

			// Make sure the target differs from related association (this move does not imply a re-factor, but simply an ownership change of an association end)
			if((relatedAssociation == request.getTargetContainer()) && ((request.getTargetFeature(movedProperty) == null) || (UMLPackage.eINSTANCE.getAssociation_OwnedEnd() == request.getTargetFeature(movedProperty)))) {
				continue; // This is a SysML Property#isNavigable update which does not require an Association refactoring action 
			}
			if((getOppositeAssociationEnd(movedProperty).getType() == request.getTargetContainer())) {
				continue; // This is a SysML Property#isNavigable update which does not require an Association refactoring action 
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

	/**
	 * Get the opposite end of an AssociationEnd (binary association assumed).
	 * 
	 * @param associationEnd
	 *        the association end
	 * @return the opposite association end or null
	 */
	private Property getOppositeAssociationEnd(Property associationEnd) {
		Property oppositeEnd = null;

		if(associationEnd.getAssociation() != null) {
			Association association = associationEnd.getAssociation();
			Set<Property> ends = new HashSet<Property>();
			ends.addAll(association.getMemberEnds());
			ends.remove(associationEnd);

			oppositeEnd = (ends.size() > 0) ? ends.iterator().next() : null;
		}
		return oppositeEnd;
	}
}
