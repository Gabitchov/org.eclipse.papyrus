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
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This HelperAdvice completes {@link EncapsulatedClassifier} edit commands with:
 * 		- the deletion of any ConnectorEnd related to a Port when the Port is moved to the EncapsulatedClassifier.
 * </pre>
 */
public class EncapsulatedClassifierHelperAdvice extends AbstractEditHelperAdvice {


	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * While moving a {@link Port} to an EncapsulatedClassifier:
	 * - remove related {@link ConnectorEnd}
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeMoveCommand(MoveRequest request) {

		ICommand gmfCommand = super.getBeforeMoveCommand(request);
		List<EObject> dependents = new ArrayList<EObject>();

		// Find ConnectorEnds related to any moved Port
		for(Object movedObject : request.getElementsToMove().keySet()) {

			// Select Port in the list of moved elements
			if(!(movedObject instanceof Port)) {
				continue;
			}

			Port movedPort = (Port)movedObject;

			// Make sure the target differs from current container
			if((movedPort.eContainer() == request.getTargetContainer()) && (movedPort.eContainingFeature() == request.getTargetFeature(movedPort))) {
				continue;
			}

			// Find related ConnectorEnds
			EReference[] refs = new EReference[]{ UMLPackage.eINSTANCE.getConnectorEnd_Role(), UMLPackage.eINSTANCE.getConnectorEnd_PartWithPort() };
			@SuppressWarnings("unchecked")
			Collection<ConnectorEnd> connectorEndRefs = EMFCoreUtil.getReferencers(movedPort, refs);
			dependents.addAll(connectorEndRefs);
		}

		// Add commands to destroy related ConnectorEnds
		for(EObject eObjectToDestroy : dependents) {

			// General case, delete the dependents ConnectorEnd(s)
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(eObjectToDestroy.eContainer());
			if(provider == null) {
				continue;
			}

			DestroyElementRequest req = new DestroyElementRequest((ConnectorEnd)eObjectToDestroy, false);
			ICommand deleteCommand = provider.getEditCommand(req);

			// Add current EObject destroy command to the global command
			gmfCommand = CompositeCommand.compose(gmfCommand, deleteCommand);
		}

		if(gmfCommand != null) {
			gmfCommand = gmfCommand.reduce();
		}

		return gmfCommand;
	}
}
