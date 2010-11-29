/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This HelperAdvice completes {@link Property} edit commands with the deletion of any
 * ConnectorEnd related to the PropertyProperty.
 * </pre>
 */
public class PropertyHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		// Get related ConnectorEnd
		List<ConnectorEnd> ends = new ArrayList<ConnectorEnd>();
		if(request.getElementToDestroy() instanceof Property) {
			Property propertyToDelete = (Property)request.getElementToDestroy();

			// Possible references from ConnectorEnd to Property (or Port)
			EReference[] refs = new EReference[]{ UMLPackage.eINSTANCE.getConnectorEnd_Role(), UMLPackage.eINSTANCE.getConnectorEnd_PartWithPort() };
			@SuppressWarnings("unchecked")
			Collection<ConnectorEnd> referencers = EMFCoreUtil.getReferencers(propertyToDelete, refs);

			ends.addAll(referencers);
		}

		// Return the command to destroy all these ConnectorEnds
		if(!ends.isEmpty()) {
			return request.getDestroyDependentsCommand(ends);
		}

		return null;
	}

	/**
	 * Find and destroy inconsistent ConectorEnd when the Property type is set.
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeSetCommand(org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest)
	 * 
	 * @param request
	 *        the request to modify the model
	 * @return
	 *         the command to destroy the ConnectorEnd becoming inconsistent
	 * 
	 */
	@Override
	protected ICommand getBeforeSetCommand(SetRequest request) {
		ICommand gmfCommand = null;

		Type newType = null;
		EObject elementToEdit = request.getElementToEdit();

		if((elementToEdit instanceof Property) && !(elementToEdit instanceof Port) && (request.getFeature() == UMLPackage.eINSTANCE.getTypedElement_Type())) {

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
