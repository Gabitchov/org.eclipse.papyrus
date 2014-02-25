/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.editpolicies

import com.google.inject.Inject
import com.google.inject.Singleton
import metamodel.MetaModel
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import org.eclipse.papyrus.papyrusgmfgenextension.GenerateUsingElementTypeCreationCommand
import plugin.Activator
import xpt.Common
import xpt.OclMigrationProblems_qvto
import xpt.diagram.editpolicies.Utils_qvto
import xpt.editor.VisualIDRegistry
import xpt.providers.ElementTypes

//Documentation: PapyrusGenCode
//This tamplate has been modified in order to allow the moving command
@Singleton class BaseItemSemanticEditPolicy extends xpt.diagram.editpolicies.BaseItemSemanticEditPolicy {
	@Inject extension Common;
	@Inject Activator xptPluginActivator;
	@Inject extension VisualIDRegistry
	@Inject ElementTypes xptElementTypes;
	@Inject extension OclMigrationProblems_qvto;
	@Inject extension Utils_qvto
	@Inject MetaModel xptMetaModel;

	override BaseItemSemanticEditPolicy(GenDiagram it) '''
«copyright(editorGen)»
package «packageName(it)»;

«generatedClassComment()»
public class «className(it)» extends org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy {

	«attributes(it)»
	
	«constructor(it)»

	«generatedMemberComment(
		'Extended request data key to hold editpart visual id.\n' + 'Add visual id of edited editpart to extended data of the request\n' + 'so command switch can decide what kind of diagram element is being edited.\n' + 'It is done in those cases when it\'s not possible to deduce diagram\n' + 'element kind from domain element.\n' + 'Add the reoriented view to the request extended data so that the view\n ' + 'currently edited can be distinguished from other views of the same element\n ' +
			'and these latter possibly removed if they become inconsistent after reconnect\n'
	)»
	@SuppressWarnings("unchecked")
	public org.eclipse.gef.commands.Command getCommand(org.eclipse.gef.Request request) {
		if (request instanceof org.eclipse.gef.requests.ReconnectRequest) {
			Object view = ((org.eclipse.gef.requests.ReconnectRequest) request).getConnectionEditPart().getModel();
			if (view instanceof org.eclipse.gmf.runtime.notation.View) {
				Integer id = new Integer(«getVisualIDMethodCall(it)»((org.eclipse.gmf.runtime.notation.View) view));
				request.getExtendedData().put(VISUAL_ID_KEY, id);
				request.getExtendedData().put(GRAPHICAL_RECONNECTED_EDGE, (org.eclipse.gmf.runtime.notation.View)view);
			}
		}
		return super.getCommand(request);
	}
	
	«generatedMemberComment('Returns visual id from request parameters.')»
	protected int getVisualID(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest request) {
		Object id = request.getParameter(VISUAL_ID_KEY);
		return id instanceof Integer ? ((Integer) id).intValue() : -1;
	}

	«semanticPart(it)»

	«generatedMemberComment('Returns editing domain from the host edit part.')»
	protected org.eclipse.emf.transaction.TransactionalEditingDomain getEditingDomain() {
		return ((org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) getHost()).getEditingDomain();
	}

	«addDestroyShortcutsCommand(it)»

«IF links.exists(link|!link.sansDomain)»
	«linkConstraints(it)»
«ENDIF»

	«additions(it)»
}
'''

	override attributes(GenDiagram it) '''
		«generatedMemberComment('Extended request data key to hold editpart visual id.')»
		public static final String VISUAL_ID_KEY = "visual_id"; «nonNLS()»
		«generatedMemberComment('Extended request data key to hold the edge view during a reconnect request.')»
		public static final String GRAPHICAL_RECONNECTED_EDGE = "graphical_edge"; «nonNLS»
		«generatedMemberComment()»
		private final org.eclipse.gmf.runtime.emf.type.core.IElementType myElementType;
	'''

	override semanticPart(GenDiagram it) '''
		«getSemanticCommand(it)»
		
		«addDeleteViewCommand(it)»
		
		«getEditHelperCommand(it)»
		
		«getContextElementType(it)»
		
		«getSemanticCommandSwitch(it)»
		
		«getConfigureCommand(it)»
		
		«getCreateRelationshipCommand(it)»
		
		«getCreateCommand(it)»
		
		// RS: add code for extended types
		«getCreateExtendedTypeCommand(it)»
		«getExtendedStartCreateRelationshipCommand(it)»
		«getExtendedCompleteCreateRelationshipCommand(it)»
		// RS: End of add code for extended types
		«getCreateSemanticServiceEditCommand(it)»
		
		«getSetCommand(it)»
		
		«getEditContextCommand(it)»
		
		«getDestroyElementCommand(it)»
		
		«getDestroyReferenceCommand(it)»
		
		«getDuplicateCommand(it)»
		
		«getMoveCommand(it)»
		
		«getReorientReferenceRelationshipCommand(it)»
		
		«getReorientRelationshipCommand(it)»
		
		«getGEFWrapper(it)»
	'''

	override getContextElementType(GenDiagram it) '''
		«generatedMemberComment()»
		protected org.eclipse.gmf.runtime.emf.type.core.IElementType getContextElementType(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest request) {
			org.eclipse.gmf.runtime.emf.type.core.IElementType requestContextElementType = «xptElementTypes.qualifiedClassName(it)».getElementType(getVisualID(request));
			return requestContextElementType != null ? requestContextElementType : myElementType;
		}
	'''

	override getCreateRelationshipCommand(GenDiagram it) '''
«generatedMemberComment()»
protected org.eclipse.gef.commands.Command getCreateRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest req) {
	«IF it.eResource.allContents.filter(typeof(GenerateUsingElementTypeCreationCommand)).size < 1»
	return null;
	«ENDIF»
	«IF it.eResource.allContents.filter(typeof(GenerateUsingElementTypeCreationCommand)).size() > 0»
	org.eclipse.papyrus.infra.services.edit.service.IElementEditService commandService = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(((org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)getHost()).resolveSemanticElement());
	if(req.getElementType() != null) {
		commandService = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(req.getElementType());
	}

	if(commandService == null) {
		return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
	}

	org.eclipse.gmf.runtime.common.core.command.ICommand semanticCommand = commandService.getEditCommand(req);

	if((semanticCommand != null) && (semanticCommand.canExecute())) {
		return getGEFWrapper(semanticCommand);
	} 
	return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
	«ENDIF»
}
'''

	override getCreateCommand(GenDiagram it) '''
«generatedMemberComment()»
 protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req) {
 		// no more usage of the extended types here. 
        return null;
  }
'''

	def getCreateExtendedTypeCommand(GenDiagram it) '''
«generatedMemberComment»
 protected org.eclipse.gef.commands.Command getExtendedTypeCreationCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest request, org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType requestElementType) {
		org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(request.getContainer());
		if(provider == null) {
			return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
		}
		// Retrieve create command from the Element Edit service
		org.eclipse.gmf.runtime.common.core.command.ICommand createGMFCommand = provider.getEditCommand(request);
		return getGEFWrapper(createGMFCommand);
	}
'''

	def getExtendedStartCreateRelationshipCommand(GenDiagram it) '''
«generatedMemberComment»
 protected org.eclipse.gef.commands.Command getExtendedStartCreateRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest request, org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType requestElementType) {
	org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(requestElementType);
	if(provider == null) {
		return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
	}
	// Retrieve create command from the Element Edit service
	org.eclipse.gmf.runtime.common.core.command.ICommand createGMFCommand = provider.getEditCommand(request);
	return getGEFWrapper(createGMFCommand);
}
'''

	def getExtendedCompleteCreateRelationshipCommand(GenDiagram it) '''
«generatedMemberComment»
 protected org.eclipse.gef.commands.Command getExtendedCompleteCreateRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest request, org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType requestElementType) {
	org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(requestElementType);
	if(provider == null) {
		return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
	}
	// Retrieve create command from the Element Edit service
	org.eclipse.gmf.runtime.common.core.command.ICommand createGMFCommand = provider.getEditCommand(request);
	return getGEFWrapper(createGMFCommand);
}
'''

	override getMoveCommand(GenDiagram it) '''
«generatedMemberComment()»
protected org.eclipse.gef.commands.Command getMoveCommand(org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest req) {
	«««	BEGIN: PapyrusGenCode
	«««	add move command
		org.eclipse.emf.ecore.EObject targetCEObject = req.getTargetContainer();
		if(targetCEObject != null) {
			org.eclipse.papyrus.infra.services.edit.service.IElementEditService provider = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(targetCEObject);
			if(provider != null) {
				org.eclipse.gmf.runtime.common.core.command.ICommand moveCommand = provider.getEditCommand(req);
				if(moveCommand != null) {
					return new org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy(moveCommand);
				}
			}
			return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
		} else {
			return getGEFWrapper(new org.eclipse.gmf.runtime.emf.type.core.commands.MoveElementsCommand(req));
		}
	««« END: PapyrusGenCode
	
}
'''

	/**
 *		FIXME need to check constraint's provider to ensure we don't generate a field
 *		for e.g. Java (or Literal, which is unlikely, though) expressions
 * 
 * 		[Papyrus Quick Fix] Do not generate field when the expression is provided
 * 		by a GenJavaExpressionProvider.
 */
	override linkConstraints(GenDiagram it) '''

	«generatedMemberComment()»
	public static «getLinkCreationConstraintsClassName()» getLinkConstraints() {
		«getLinkCreationConstraintsClassName()» cached = «xptPluginActivator.instanceAccess(it.editorGen)».getLinkConstraints();
		if (cached == null) {
			«xptPluginActivator.instanceAccess(it.editorGen)».setLinkConstraints(cached = new «getLinkCreationConstraintsClassName()»());
		}
		return cached;
	}

«generatedClassComment()»
public static class «getLinkCreationConstraintsClassName()» {

	«generatedMemberComment»
	public «getLinkCreationConstraintsClassName()»() {«««package-local for the BaseItemSemanticEditPolicy to instantiate. Perhaps, protected is better (i.e. if someone subclasses it?)
		// use static method #getLinkConstraints() to access instance
	}

	«FOR nextLink : it.links»
	«canCreate(nextLink)»
	«ENDFOR»

	«FOR nextLink : it.links»
	«canExist(nextLink)»
	«ENDFOR»
}
'''

	/**
 * [MG] extracted from LET statement, @see checkEMFConstraints(TypeLinkModelFacet)
 */
	private def checkChildFeatureBounds(TypeLinkModelFacet it) {
		childMetaFeature != containmentMetaFeature && !isUnbounded(childMetaFeature.ecoreFeature)
	}

	def checkEMFConstraints(TypeLinkModelFacet it) '''
«IF containmentMetaFeature.ecoreFeature != null»
		«IF ! isUnbounded(containmentMetaFeature.ecoreFeature) || checkChildFeatureBounds(it)»
			if («getContainerVariable(it)» != null) {
						«checkEMFConstraints(containmentMetaFeature, it)»
						«IF checkChildFeatureBounds(it)»
							«checkEMFConstraints(childMetaFeature, it)»
						«ENDIF»
			}
		«ENDIF»
«ENDIF»
'''

	override checkEMFConstraints(GenFeature it, TypeLinkModelFacet modelFacet) '''
«IF modelFacet.containmentMetaFeature.ecoreFeature != null»
«IF ! isUnbounded(ecoreFeature)»
if («featureBoundComparator(it, getContainerVariable(modelFacet), modelFacet.getSourceType())») {
	return false;
}
«ENDIF»
«ENDIF»
'''

	override canCreate(GenLink it) '''
«generatedMemberComment()»
public boolean canCreate«getUniqueIdentifier()»(
«IF !it.sansDomain»
«canCreateParameters(it.modelFacet)»
«ENDIF»
) {
	«IF !it.sansDomain»
	«checkEMFConstraints(it.modelFacet)»
	«ENDIF»
	return canExist«getUniqueIdentifier()»(
	«IF !it.sansDomain»
	«canCreateValues(it.modelFacet)»
	«ENDIF»
	);
}
'''

	override featureBoundsConditionClause(GenFeature it, String targetVar, GenClass targetType) '''
«««Checking upper bounds if was specified in MM
«IF ecoreFeature != null»
	«IF ! isUnbounded(ecoreFeature)»«featureBoundComparator(it, targetVar, targetType)»«ENDIF»
	«««	Checking uniqueness in addition if upper bounds != 1
	«IF ! isSingleValued(ecoreFeature) && ! isUnbounded(ecoreFeature)» || «ENDIF»
	«««	Checking uniqueness in if upper bounds !- 1
	«IF ! isSingleValued(ecoreFeature)»«featureUniquenessComparator(it, targetVar, targetType)»«ENDIF»
«ENDIF»
'''

	override featureBoundComparator(GenFeature it, String featureVar, GenClass featureVarGenClass) '''
		«xptMetaModel.getFeatureValue(it, featureVar, featureVarGenClass)»
		«IF ecoreFeature.upperBound == 1»
			!= null
		«ELSE»
			.size() >= «ecoreFeature.upperBound»
		«ENDIF»
	'''

	// Generate generic method if using semantic creation command based on element types framework.
	def getCreateSemanticServiceEditCommand(GenDiagram it) '''
«IF it.eResource.allContents.filter(typeof(GenerateUsingElementTypeCreationCommand)).size > 0»
	«generatedMemberComment»
	protected org.eclipse.gmf.runtime.common.core.command.ICommand getSemanticCreationCommand(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req) {
		org.eclipse.papyrus.infra.services.edit.service.IElementEditService commandService = org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils.getCommandProvider(req.getContainer());
		if(commandService == null) {
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}
		return commandService.getEditCommand(req);
	}
«ENDIF»	
'''

	/**
 *		XXX for now, both constraints are injected into single method
 *			which may not be suitable for modification especially when mixing
 *			java and ocl constraints (former requires manual code).
 *		Better approach would be:
 *			if either is non-null and providers are not the same - introduce two methods, 
 *			to check source and target separately. Otherwize, do it inplace.
*/
	override canExist(GenLink it) '''
		«generatedMemberComment()»
			public boolean canExist«getUniqueIdentifier()»(
		«IF !it.sansDomain»
			«canExistParameters(it.modelFacet)»
		«ENDIF»
		) {
		«IF creationConstraints != null && creationConstraints.isValid() && it.diagram.editorGen.expressionProviders != null»
			try {
			«IF creationConstraints.sourceEnd != null»
				«checkAdditionalConstraint(creationConstraints.sourceEnd.provider, creationConstraints.sourceEnd, 'source', 'target', creationConstraints.getSourceEndContextClass(), creationConstraints.getTargetEndContextClass())»
			«ENDIF»
			«IF creationConstraints.targetEnd != null»
				«checkAdditionalConstraint(creationConstraints.targetEnd.provider, creationConstraints.targetEnd, 'target', 'source', creationConstraints.getTargetEndContextClass(), creationConstraints.getSourceEndContextClass())»
			«ENDIF»
			return true;
			} catch(Exception e) {	
				«xptPluginActivator.instanceAccess(it.diagram.editorGen)».logError("Link constraint evaluation error", e); «nonNLS()»
				return false;
			}
		«ELSE»
			return true;
		«ENDIF»
		}
	'''

}
