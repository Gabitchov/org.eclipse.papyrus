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

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This helper is used to set the source and the target for a {@link Dependency}
 * 
 * 
 * 
 */
public class DependencyEditHelper extends DefaultUMLEditHelper {

	/**
	 * 
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#getConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 * 
	 * @param req
	 * @return
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		Map<?, ?> parameters = req.getParameters();
		CompositeCommand cmd = new CompositeCommand("Command to set source and target for a Dependency"); //$NON-NLS-1$
		for(Object current : parameters.keySet()) {
			if(current == CreateRelationshipRequest.SOURCE) {
				SetRequest setRequest = new SetRequest(req.getElementToConfigure(), UMLPackage.eINSTANCE.getDependency_Client(), parameters.get(CreateRelationshipRequest.SOURCE));
				ICommand setCommand = getSetCommand(setRequest);
				if(setCommand.canExecute()) {
					cmd.add(setCommand);
				}
			} else if(current == CreateRelationshipRequest.TARGET) {
				SetRequest setRequest = new SetRequest(req.getElementToConfigure(), UMLPackage.eINSTANCE.getDependency_Supplier(), parameters.get(CreateRelationshipRequest.TARGET));
				ICommand setCommand = getSetCommand(setRequest);
				if(setCommand.canExecute()) {
					cmd.add(setCommand);
				}
			}
		}
		if(!cmd.isEmpty()) {
			return cmd;
		}
		return null;
	}
}
