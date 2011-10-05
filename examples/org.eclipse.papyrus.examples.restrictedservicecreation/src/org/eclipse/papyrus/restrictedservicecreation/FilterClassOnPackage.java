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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.restrictedservicecreation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.service.creation.PapyrusEditHelperFilter;
import org.eclipse.papyrus.uml.service.creation.element.UMLElementTypes;

/**
 * this is a filter used to allow the creation of a class or package in the context on a package,
 *  or to allow only the creation of a property in the context of a class
 *
 */
public class FilterClassOnPackage extends PapyrusEditHelperFilter {

	/**
	 * {@inheritDoc}
	 */
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {
		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				return CommandResult.newOKCommandResult();
			}
		};
	}
	/**
	 * {@inheritDoc}
	 */
	public boolean validateRequest(IEditCommandRequest request) {
		if(request instanceof GetEditContextRequest){
			IEditCommandRequest subrequest= ((GetEditContextRequest)request).getEditCommandRequest();
			if( subrequest instanceof CreateElementRequest){
				
				//allow only creation of class or package into a package
				if(((CreateElementRequest) subrequest).getContainer() instanceof org.eclipse.uml2.uml.Package){
					if(((CreateElementRequest) subrequest).getElementType().equals(UMLElementTypes.CLASS)||
							((CreateElementRequest) subrequest).getElementType().equals(UMLElementTypes.PACKAGE)){
							return true;
					}
				}
				//allow only creation of property into a class
				if(((CreateElementRequest) subrequest).getContainer() instanceof org.eclipse.uml2.uml.Class){
					if(((CreateElementRequest) subrequest).getElementType().equals(UMLElementTypes.PROPERTY)){
							return true;
					}
				}
			}
		}
		return false;
	}

}
