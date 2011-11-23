/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.sysml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This HelperAdvice completes {@link Property} edit commands with:
 * 		- possibly required (sysML) association re-factor command.
 * </pre>
 */
public class PropertyEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * While setting {@link Property} (excluding {@link Port}) type:
	 * - add possibly required (sysML) association re-factor command when needed.
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeSetCommand(SetRequest request) {
		ICommand gmfCommand = super.getBeforeSetCommand(request);

		EObject elementToEdit = request.getElementToEdit();

		if((elementToEdit instanceof Property) && !(elementToEdit instanceof Port) && (request.getFeature() == UMLPackage.eINSTANCE.getTypedElement_Type()) && (request.getValue() instanceof Type)) {

			Property propertyToEdit = (Property)elementToEdit;
			Association relatedAssociation = propertyToEdit.getAssociation();

			// The edited property has to be related to a SysML association
			if((relatedAssociation == null) || !(ElementUtil.hasNature(relatedAssociation, SysMLElementTypes.SYSML_NATURE))) {
				return gmfCommand;
			}

			// Setting new type can be related to an association re-orient (or trigger the association re-orient)
			// Retrieve elements already under re-factor.
			List<EObject> currentlyRefactoredElements = (request.getParameter(RequestParameterConstants.ASSOCIATION_REFACTORED_ELEMENTS) != null) ? (List<EObject>)request.getParameter(RequestParameterConstants.ASSOCIATION_REFACTORED_ELEMENTS) : new ArrayList<EObject>();
			if(!currentlyRefactoredElements.contains(propertyToEdit)) {
				currentlyRefactoredElements.add(propertyToEdit);
				request.getParameters().put(RequestParameterConstants.ASSOCIATION_REFACTORED_ELEMENTS, currentlyRefactoredElements);

				// Current association already under re-factor ?
				if(currentlyRefactoredElements.contains(relatedAssociation)) {
					return gmfCommand;
				}
			}

			ICommand refactorCommand = getAssociationRefactoringCommand(propertyToEdit, relatedAssociation, request);
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
}
