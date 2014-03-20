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
package utils

import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet

@Singleton class UtilsItemSemanticEditPolicy {

	//Command for the EditPart which use the Delete Service 
	def getDestroyElementCommandByService(GenNode i) '''
		protected org.eclipse.gef.commands.Command getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest req) {
			org.eclipse.emf.ecore.EObject selectedEObject = req.getElementToDestroy();
			org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider =org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(selectedEObject);
			if(provider != null) {
				// Retrieve delete command from the Element Edit service
				org.eclipse.gmf.runtime.common.core.command.ICommand deleteCommand = provider.getEditCommand(req);
		
				if(deleteCommand != null) {
			return new org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy(deleteCommand);
				}
			}
			return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
			}
	'''

	def getDestroyElementCommandByService(TypeLinkModelFacet it) '''
		protected org.eclipse.gef.commands.Command getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest req) {
			org.eclipse.emf.ecore.EObject selectedEObject = req.getElementToDestroy();
			org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider =org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(selectedEObject);
			if(provider != null) {
				// Retrieve delete command from the Element Edit service
				org.eclipse.gmf.runtime.common.core.command.ICommand deleteCommand = provider.getEditCommand(req);
		
				if(deleteCommand != null) {
			return new org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy(deleteCommand);
				}
			}
			return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
			}
	'''
}
