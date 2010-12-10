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
package org.eclipse.papyrus.uml.service.types.helper;

import java.util.Map;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * This helper is used to add the contract and the implementing Classifier in an {@link InterfaceRealization}
 * 
 * 
 */
public class InterfaceRealizationEditHelper extends DependencyEditHelper {

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.service.types.helper.DependencyEditHelper#getConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 * 
	 * @param req
	 * @return
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		ICommand command = super.getConfigureCommand(req);
		if(command != null) {
			Map<?, ?> parameters = req.getParameters();
			for(Object current : parameters.keySet()) {
				if(current == CreateRelationshipRequest.SOURCE) {
					SetRequest setRequest = new SetRequest(req.getElementToConfigure(), UMLPackage.eINSTANCE.getInterfaceRealization_ImplementingClassifier(), parameters.get(CreateRelationshipRequest.SOURCE));
					ICommand setCommand = getSetCommand(setRequest);
					if(setCommand.canExecute()) {
						command.compose(setCommand);
					}
				} else if(current == CreateRelationshipRequest.TARGET) {
					SetRequest setRequest = new SetRequest(req.getElementToConfigure(), UMLPackage.eINSTANCE.getInterfaceRealization_Contract(), parameters.get(CreateRelationshipRequest.TARGET));
					ICommand setCommand = getSetCommand(setRequest);
					if(setCommand.canExecute()) {
						command.compose(setCommand);
					}
				}
			}
		}
		return command;
	}
}
