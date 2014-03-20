/**
 * Copyright (c) 2007-2012 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Borland) - [243151] explicit source/target for links
 * 								- #386838 - migrate to Xtend2
 * 	  Vincent Lorenzo (CEA-LIST) 
 */
package aspects.xpt.diagram.editpolicies

import com.google.inject.Inject
import com.google.inject.Singleton
import impl.diagram.commands.DeleteLinkCommand
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService
import utils.UtilsItemSemanticEditPolicy
import xpt.Common

@Singleton class LinkItemSemanticEditPolicy extends xpt.diagram.editpolicies.LinkItemSemanticEditPolicy {
	@Inject extension Common;
	@Inject extension DeleteLinkCommand
	@Inject extension UtilsItemSemanticEditPolicy

	override dispatch getDestroySemanticCommand(TypeLinkModelFacet it, GenLink genLink) '''
		««« Test to know which delete command should be used in the generated code : "Traditional Delete Command" or the Delete Service

		«IF it.eResource.allContents.filter(typeof (EditPartUsingDeleteService)).filter[v | v.genView.contains(genLink)].size !=0 »
		
			«generatedMemberComment»
			«getDestroyElementCommandByService(it)»
		«ELSE»
			«generatedMemberComment»
			protected org.eclipse.gef.commands.Command getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest req) {
				org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand cmd = new org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand(getEditingDomain(), null);
				cmd.setTransactionNestingEnabled(true);
				java.util.List<org.eclipse.emf.ecore.EObject> todestroy=new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
				todestroy.add(req.getElementToDestroy());
				//cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(req));
				cmd.add(new org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper(new org.eclipse.emf.edit.command.DeleteCommand(getEditingDomain(),todestroy )));
				return getGEFWrapper(cmd.reduce());
				//return getGEFWrapper(«newDeleteLinkWithClassCommand(it,genLink, 'req')»);
			}
		«ENDIF»	
	'''


}
