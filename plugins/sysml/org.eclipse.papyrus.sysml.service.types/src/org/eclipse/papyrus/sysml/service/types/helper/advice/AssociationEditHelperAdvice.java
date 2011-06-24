/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/** Association edit helper advice */
public class AssociationEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Add SysML Nature on the {@link Association}.
	 *  
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		
		final Association association = (Association)request.getElementToConfigure();
		
		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					
				// Add SysML Nature on the new Association
				ElementUtil.addNature(association, SysMLElementTypes.SYSML_NATURE);
				
				return CommandResult.newOKCommandResult(association);
			}
		};	
	}

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Add a command to destroy {@link Association} ends referenced by the {@link Association} 
	 * to delete.
	 *  
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest req) {
		List<EObject> dependentsToDestroy = new ArrayList<EObject>();

		Association association = (Association)req.getElementToDestroy();
		for (Property end : association.getMemberEnds()) {	
			dependentsToDestroy.add(end);
		}

		// Return command to destroy dependents ends 
		if(!dependentsToDestroy.isEmpty()) {
			return req.getDestroyDependentsCommand(dependentsToDestroy);
		}

		return super.getBeforeDestroyDependentsCommand(req);
	}
}