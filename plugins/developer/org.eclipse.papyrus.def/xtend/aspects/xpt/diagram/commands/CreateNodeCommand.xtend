/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.commands

import com.google.inject.Inject
import com.google.inject.Singleton
import metamodel.MetaModel
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import xpt.Common
import xpt.OclMigrationProblems_qvto
import xpt.diagram.Utils_qvto

@Singleton class CreateNodeCommand extends xpt.diagram.commands.CreateNodeCommand  {
	@Inject extension Common;

	@Inject extension OclMigrationProblems_qvto;
	@Inject extension MetaModel
	@Inject extension Utils_qvto;


	@Inject MetaModel xptMetaModel;
	
		override CreateNodeCommand(GenNode it) '''
		«copyright(it.diagram.editorGen)»
		package «packageName(it)»;
		
		
		
		«generatedClassComment()»
		public class «className(it)» extends org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand {
			
			private org.eclipse.gmf.runtime.notation.Diagram diagram = null;
		
			«_constructor(it)»
		
			«getElementToEdit(it)»
		
			«canExecuteMethod(it)»
		
			«doExecuteWithResultMethod(it)»
		
			«doConfigureMethod(it)»
			
			«additions(it)»	
		}
	'''
	
	override _constructor(GenNode it) '''
		«generatedMemberComment()»
		public «className(it)»(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req, org.eclipse.gmf.runtime.notation.Diagram diagram) {
			super(req.getLabel(), null, req);
			this.diagram = diagram;
		}
	'''

//	override CreateNodeCommand(TypeModelFacet it) '''
//		«copyright(ownerGenNode(it).diagram.editorGen)»
//		package «packageName(it)»;
//		
//		«generatedClassComment()»
//		public class «className(it)» extends org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand {
//«««	Mutating canvas auxiliary
//	«generatedMemberComment»
//	private org.eclipse.emf.ecore.EClass eClass = null;
//	«generatedMemberComment»
//	private org.eclipse.emf.ecore.EObject eObject = null;
//	«««	Mutating canvas auxiliary constructor
//	«generatedMemberComment»
//	public «ownerGenNode(it).createCommandClassName»(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req, org.eclipse.emf.ecore.EObject eObject) {
//		super(req.getLabel(), null, req);
//		this.eObject = eObject;
//		this.eClass = eObject != null ? eObject.eClass() : null;
//	}
//	«««	Mutating canvas auxiliary builder	
//	«generatedMemberComment»
//	public static «ownerGenNode(it).createCommandClassName» create(org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest req, org.eclipse.emf.ecore.EObject eObject) {
//		return new «ownerGenNode(it).createCommandClassName»(req, eObject);
//	}
//	« _constructor(it)»
//	« getElementToEdit(it)»
//	« canExecuteMethod(it)»
//	« doExecuteWithResultMethod(it)»
//	« doConfigureMethod(it)»	
//		}
//	'''
//
//
//
//	/**
//	 * TODO: either use setElementToEdit, or generate downcasted version (which may be troublesome if containment and child features point to a different parent) 
//	 */
//	override getElementToEdit(TypeModelFacet it) '''
//			«generatedMemberComment('FIXME: replace with setElementToEdit()')»
//		protected org.eclipse.emf.ecore.EObject getElementToEdit() {
//
//		«««	Mutating canvas helper
//		org.eclipse.emf.ecore.EObject container =
//				((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).getContainer();
//		if (container instanceof org.eclipse.gmf.runtime.notation.View) {
//			container = ((org.eclipse.gmf.runtime.notation.View) container).getElement();
//		}
//		if (container != null) {
//			return container;
//		}
//		return eObject;			
//
//		}
//	'''

	//	[AbstractElement] Modified for Abstract domain element
	override doExecuteWithResultMethod(GenNode it) '''
		«generatedMemberComment()»
		protected org.eclipse.gmf.runtime.common.core.command.CommandResult doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IAdaptable info) throws org.eclipse.core.commands.ExecutionException {
		«««	[AbstractElement] START	
 				
 		«IF it.modelFacet.metaClass.ecoreClass.abstract != true»
		««« [AbstractElement] END
			«IF it.modelFacet.isPhantomElement()»
				«phantomElementCreation(it.modelFacet, it, 'newElement')»
			«ELSE»
				«normalElementCreation(it.modelFacet, it, 'newElement')»
			«ENDIF»
			«extraLineBreak»
			«initialize(it.modelFacet, it, 'newElement')»
			«IF true/*FIXME boolean needsExternalConfiguration*/»
				«extraLineBreak»
				doConfigure(newElement, monitor, info);
				«extraLineBreak»
			«ENDIF»
				((org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest) getRequest()).setNewElement(«xptMetaModel.
				DowncastToEObject(it.modelFacet.metaClass, 'newElement')»);
				return org.eclipse.gmf.runtime.common.core.command.CommandResult.newOKCommandResult(newElement);
			}
		«««  [AbstractElement] START	
		«ELSE»
				throw new UnsupportedOperationException("Unimplemented operation (abstract domain element).");
			}
		«ENDIF»
		««« [AbstractElement] END	
	'''


	override canExecute_Normal(TypeModelFacet it) '''
	«IF containmentMetaFeature != null»
		«IF  containmentMetaFeature.ecoreFeature != null»
			«IF ! isUnbounded(containmentMetaFeature.ecoreFeature) || (childMetaFeature != containmentMetaFeature && ! isUnbounded(childMetaFeature.ecoreFeature))»
				«IF ! isUnbounded(containmentMetaFeature.ecoreFeature)»
				«DeclareAndAssign(containmentMetaFeature.genClass,'container', 'getElementToEdit()') »
						«IF isSingleValued(containmentMetaFeature.ecoreFeature)»
						if («getFeatureValue(containmentMetaFeature,'container', containmentMetaFeature.genClass) » != null) {
							«ELSE»
						if (« getFeatureValue(containmentMetaFeature,'container', containmentMetaFeature.genClass)».size() >= «containmentMetaFeature.ecoreFeature.upperBound») {
							«ENDIF»
							return false;
						}
						«ENDIF»
						«IF childMetaFeature != containmentMetaFeature && ! isUnbounded(childMetaFeature.ecoreFeature)»
						«IF isSingleValued(childMetaFeature.ecoreFeature)»
							if («getFeatureValue(childMetaFeature,'container', containmentMetaFeature.genClass)  » != null) {
								«ELSE»
								if («getFeatureValue(childMetaFeature,'container', containmentMetaFeature.genClass)  ».size() >= «childMetaFeature.ecoreFeature.upperBound») {
								«ENDIF»
								return false;
							}
						«ENDIF»
			«ENDIF»
		«ENDIF»
	«ENDIF»
	
	org.eclipse.emf.ecore.EObject target = getElementToEdit();
	org.eclipse.papyrus.infra.viewpoints.policy.ModelAddData data = org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker.getCurrent().getChildAddData(diagram, target.eClass(), «MetaClass(metaClass)»);
	return data.isPermitted();

	'''


	override normalElementCreation(TypeModelFacet it, GenNode node, String varName) '''
		«xptMetaModel.NewInstance(it.metaClass, varName)»
		
		org.eclipse.emf.ecore.EObject target = getElementToEdit();
				org.eclipse.papyrus.infra.viewpoints.policy.ModelAddData data = org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker.getCurrent().getChildAddData(diagram, target, «varName»);
				if (data.isPermitted()) {
					if (data.isPathDefined()) {
						if (!data.execute(target, «varName»))
							return org.eclipse.gmf.runtime.common.core.command.CommandResult.newErrorCommandResult("Failed to follow the policy-specified for the insertion of the new element");
					} else {
		«extraLineBreak»
		«IF containmentMetaFeature != null»
			«xptMetaModel.DeclareAndAssign(it.containmentMetaFeature.genClass, 'qualifiedTarget', 'target')»
			«xptMetaModel.modifyFeature(containmentMetaFeature, 'qualifiedTarget', containmentMetaFeature.genClass, varName)»
		«ELSE»
			//
			// FIXME no containment feature found in the genmodel, toolsmith need to manually write code here to add «varName» to a parent
			//
		«ENDIF»
		
					}
				} else {
					return org.eclipse.gmf.runtime.common.core.command.CommandResult.newErrorCommandResult("The active policy restricts the addition of this element");
				}

		«IF hasExplicitChildFeature(it)»
			«xptMetaModel.DeclareAndAssign(it.childMetaFeature.genClass, 'childHolder', 'getElementToEdit()')»
			«xptMetaModel.modifyFeature(it.childMetaFeature, 'childHolder', childMetaFeature.genClass, varName)»
		«ENDIF»
	'''



}
