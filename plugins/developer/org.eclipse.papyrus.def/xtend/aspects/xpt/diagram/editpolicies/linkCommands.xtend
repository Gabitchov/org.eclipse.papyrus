/**
 * Copyright (c) 2007-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Dmitry Stadnik (Borland) - creation logic was moved in commands
 *    Michael Golubev (Borland) - [243151] explicit source/target for links
 *    							- #386838 - migrate to Xtend2
 *    Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package aspects.xpt.diagram.editpolicies

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenLinkEnd
import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingReorientService
import org.eclipse.papyrus.papyrusgmfgenextension.GenerateUsingElementTypeCreationCommand
import xpt.Common
import xpt.diagram.commands.CreateLinkCommand
import xpt.diagram.editpolicies.Utils_qvto
import xpt.editor.VisualIDRegistry
import xpt.providers.ElementTypes

/**
 * Start  		start of link creation. 
 *				User click to this editpart and start dragging with link tool.
 * Complete 	end of the command
 *				User points to this editpart as a link target and release mouse button.
 *
 * Outgoing 	the node is link source
 *				This element could be a source for this type of link.
 * Incoming		the node is link destination
 *				This element could be a target for this type of link.
 *
 * Parameters:
 *
 * 	diagram 	GenDiagram used to collect all defined links
 *
 *	this		Instance of GenLinkEnd for the element link could be creates to/from.
 *				This could be GenNode or GenLink in case of links to links, 
 *              in the latter case it is assumed that its a TypeLink (so its model facet is LinkTypeModelFacet), 
 *              because RefLinks don't have underlying semantic identity   
 *
*/
@Singleton class linkCommands extends xpt.diagram.editpolicies.linkCommands {
	@Inject extension Utils_qvto;
	@Inject extension Common;

	@Inject  aspects.xpt.diagram.editpolicies.Utils_qvto aspectsUtils_qvto
	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject ElementTypes xptElementTypes;
		@Inject CreateLinkCommand xptCreateLinkCommand;

	override createLinkCommands(GenLinkEnd it) '''
		
		«IF it.eResource.allContents.filter(typeof (GenerateUsingElementTypeCreationCommand)).size <1»

		«generatedMemberComment()»
		protected org.eclipse.gef.commands.Command getCreateRelationshipCommand(
				org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest req) {
			org.eclipse.gef.commands.Command command = req.getTarget() == null ?
			getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
			return command != null ? command : super.getCreateRelationshipCommand(req);
		}
		«ENDIF»
		
		«generatedMemberComment()»
		protected org.eclipse.gef.commands.Command getStartCreateRelationshipCommand(
				org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest req) {
			org.eclipse.gmf.runtime.emf.type.core.IElementType requestElementType = req.getElementType();
			if(requestElementType == null) {
				return null;
			}
			org.eclipse.gmf.runtime.emf.type.core.IElementType baseElementType = requestElementType;
			«IF aspectsUtils_qvto.containsCreateStartLinkCommand(it)»
			boolean isExtendedType = false;
			«ENDIF»
			if(requestElementType instanceof org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType) {
				baseElementType = org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils.getClosestDiagramType(requestElementType);
				if(baseElementType != null) {
					«IF aspectsUtils_qvto.containsCreateStartLinkCommand(it)»
					isExtendedType = true;
					«ENDIF»
				} else {
					// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
					baseElementType = org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils.findClosestNonExtendedElementType((org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType)requestElementType);
					«IF aspectsUtils_qvto.containsCreateStartLinkCommand(it)»
					isExtendedType = true;
					«ENDIF»
				}
			}
			«FOR l : getAllPotentialLinks(it)»
			«startLinkCommands(l, it)»
			«ENDFOR»
			return null;
		}
		
		«generatedMemberComment()»
		protected org.eclipse.gef.commands.Command getCompleteCreateRelationshipCommand(
				org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest req) {
			org.eclipse.gmf.runtime.emf.type.core.IElementType requestElementType = req.getElementType();
			if(requestElementType == null) {
				return null;
			}
			org.eclipse.gmf.runtime.emf.type.core.IElementType baseElementType = requestElementType;
			«IF aspectsUtils_qvto.containsCreateCompleteLinkCommand(it)»
			boolean isExtendedType = false;
			«ENDIF»
			if(requestElementType instanceof org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType) {
				baseElementType = org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils.getClosestDiagramType(requestElementType);
				if(baseElementType != null) {
					«IF aspectsUtils_qvto.containsCreateCompleteLinkCommand(it)»
					isExtendedType = true;
					«ENDIF»
				} else {
					// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
					baseElementType = org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils.findClosestNonExtendedElementType((org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType)requestElementType);
					«IF aspectsUtils_qvto.containsCreateCompleteLinkCommand(it)»
					isExtendedType = true;
					«ENDIF»
				}
			}	
			«FOR l : getAllPotentialLinks(it)»
			«completeLinkCommands(l, it)»
			«ENDFOR»
			return null;
		}
	'''
	
		override startLinkCommands(GenLink it, GenLinkEnd linkEnd) '''
		if («xptElementTypes.accessElementType(it)» == baseElementType) {
		«IF createStartLinkCommand(it, linkEnd)»
		if(isExtendedType) {
			return getExtendedStartCreateRelationshipCommand(req, (org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType)requestElementType);
		}
				return getGEFWrapper(new «xptCreateLinkCommand.qualifiedClassName(it)»(req,
					«IF createStartIncomingLinkCommand(it, linkEnd)»
						req.getTarget(), req.getSource()
					«ELSE»
						req.getSource(), req.getTarget()
					«ENDIF»
				));
			«ELSE»
				return null;
			«ENDIF»
		}
	'''
	
		override completeLinkCommands(GenLink it, GenLinkEnd linkEnd) '''
		if («xptElementTypes.accessElementType(it)» == baseElementType) {
			«IF createCompleteLinkCommand(it, linkEnd)»
			if(isExtendedType) {
				return getExtendedCompleteCreateRelationshipCommand(req, (org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType)requestElementType);
			}
				return getGEFWrapper(new «xptCreateLinkCommand.qualifiedClassName(it)»(req,
					«IF createCompleteOutgoingLinkCommand(it, linkEnd)»
						req.getTarget(), req.getSource()
					«ELSE»
						req.getSource(), req.getTarget()
					«ENDIF»
				));
			«ELSE»
				return null;
			«ENDIF»
		}
	'''
	

	//	We overwrite the reorientTypeLinkCommands to manages the links which use the ReorientCommand provided by the EditService
	override reorientTypeLinkCommands(GenLinkEnd it) '''
		«generatedMemberComment(
			'Returns command to reorient EClass based link. New link target or source\n' + 'should be the domain model element associated with this node.\n'
		)»
			protected org.eclipse.gef.commands.Command getReorientRelationshipCommand(
					org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest req) {
				switch (getVisualID(req)) {
					«FOR link : getReroutableTypeLinks(it)»
					«reorientLinkCommandWithService(link) »
					«ENDFOR»
					«callReorientCommand(it)»
					«FOR link : getReroutableTypeLinks(it)»
					«reorientLinkCommandWithoutService(link) »
					«ENDFOR»
				}
				return super.getReorientRelationshipCommand(req);
				}
		'''

	//This function writes only  : "case myLinkEditPart.VISUAL_ID:" 
	//for the link which uses the ReorientCommand provided by the EditService 
	def reorientLinkCommandWithService(GenLink it) '''
		«IF it.eResource.allContents.filter(typeof(EditPartUsingReorientService)).filter[v| v.genView.contains(it)].size != 0»
			«xptVisualIDRegistry.caseVisualID(it)»
		«ENDIF»
	'''

	// This function writes the code to call the ReorientCommand provided by the ReorientService
	def callReorientCommand(GenLinkEnd it) '''
		«var  rServiceNodes = it.eResource.allContents.filter(typeof (EditPartUsingReorientService))»
		«IF !rServiceNodes.empty»
			«IF !rServiceNodes.filter[rServiceNode|(!(rServiceNode.genView.filter[view|getReroutableTypeLinks(it).toList.contains(view)].empty))].empty»
				org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider =org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(req.getRelationship());
				 if(provider == null) {
				           return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
				 }
				 // Retrieve re-orient command from the Element Edit service
				 org.eclipse.gmf.runtime.common.core.command.ICommand reorientCommand = provider.getEditCommand(req);
				          if(reorientCommand == null) {
				           return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
				          }
				 return getGEFWrapper(reorientCommand.reduce());
			«ENDIF»
		«ENDIF»
	'''

	// This function writes the code for the Links which uses their own ReorientCommand (the initial code)
	def reorientLinkCommandWithoutService(GenLink it) '''
		«IF it.eResource.allContents.filter(EditPartUsingReorientService).filter[v|v.genView.contains(it)].size == 0»
			«reorientLinkCommand(it)» 
		«ENDIF»
	'''

}
