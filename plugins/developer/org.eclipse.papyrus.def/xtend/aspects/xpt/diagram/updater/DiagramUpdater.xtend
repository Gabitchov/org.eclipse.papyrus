/**
 * Copyright (c) 2007, 2010, 2014 Borland Software Corporation, CEA, and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Borland) - [243151] explicit source/target for links
 *    Michael Golubev (Montages) - API extracted to gmf.tooling.runtime, template migrated to Xtend2
 *    Christian W. Damus (CEA) - bug 426732: override the cross-reference searches for views to use the CrossReferenceAdapter  	  
 */
package aspects.xpt.diagram.updater

import aspects.xpt.editor.VisualIDRegistry
import com.google.inject.Inject
import com.google.inject.Singleton
import metamodel.MetaModel
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater
import xpt.Common
import xpt.Common_qvto
import xpt.GenModelUtils_qvto
import xpt.diagram.updater.LinkDescriptor
import xpt.diagram.updater.NodeDescriptor
import xpt.diagram.updater.UpdaterLinkType
import xpt.diagram.updater.Utils_qvto

@Singleton class DiagramUpdater extends xpt.diagram.updater.DiagramUpdater {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension Utils_qvto;
	@Inject extension GenModelUtils_qvto;
	@Inject LinkDescriptor linkDescriptor;
	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject NodeDescriptor nodeDescriptor;

	@Inject MetaModel xptMetaModel;

	protected def typeOfCrossReferenceAdapter() '''org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter'''

	override def getConnectedLinks(GenCommonBase it, Iterable<GenLink> genLinks, UpdaterLinkType linkType,
		boolean needCrossReferencer) '''
		
		«generatedMemberComment»
		public static «listOfLinkDescriptors(it)» «linkGetterName(it, linkType)»(org.eclipse.gmf.runtime.notation.View view) {
		«IF genLinks.notEmpty»
			«xptMetaModel.DeclareAndAssign(it.metaClass, 'modelElement', 'view.getElement()')»
			«IF needCrossReferencer»
				«typeOfCrossReferenceAdapter» crossReferencer = «typeOfCrossReferenceAdapter».getCrossReferenceAdapter(view.eResource().getResourceSet());
			«ENDIF»
			«newLinkedListOfLinkDescriptors(it.diagramUpdater, 'result')»();
			«FOR link : genLinks»
				«colectConnectedLinks(link, linkType, needCrossReferencer, isExternalInterface(it.metaClass))»
			«ENDFOR»
			return result;
		«ELSE»
			return «newEmptyList()»;
		«ENDIF»
		}
	'''

	override def colectConnectedLinks(GenLink it, UpdaterLinkType linkType, boolean needCrossReferencer,
		boolean isExternalInterface) '''
		«IF it.modelFacet != null»
			«IF isExternalInterface && !it.modelFacet.oclIsKindOf(typeof(FeatureLinkModelFacet))»
				if («xptMetaModel.IsInstance(it.modelFacet.getLinkEndType(linkType), 'modelElement')») {
			«ENDIF»
			result.addAll(«chooseConnectedLinksByTypeMethodName(it.modelFacet, linkType, it)»(« //
		IF isExternalInterface && !it.modelFacet.oclIsKindOf(typeof(FeatureLinkModelFacet))»«xptMetaModel.
			CastEObject(it.modelFacet.getLinkEndType(linkType), 'modelElement')»«ELSE»modelElement«ENDIF»«IF needCrossReferencer», crossReferencer«ENDIF»));  
			«IF isExternalInterface && !it.modelFacet.oclIsKindOf(typeof(FeatureLinkModelFacet))»
				}
			«ENDIF»
		«ENDIF»
	'''

	override def getIncomingLinksByTypeMethod(GenLink it) '''
		   «generatedMemberComment»
		private static java.util.Collection<«linkDescriptor.qualifiedClassName(it.diagramUpdater)»> «getConnectedLinksByTypeMethodName(
			UpdaterLinkType::INCOMING)»(«xptMetaModel.QualifiedClassName(it.modelFacet.targetType)» target, «typeOfCrossReferenceAdapter» crossReferencer) {
		    «newLinkedListOfLinkDescriptors(it.diagramUpdater, 'result')»();
		    java.util.Collection<org.eclipse.emf.ecore.EStructuralFeature.Setting> settings = crossReferencer.getInverseReferences(target);
		    for (org.eclipse.emf.ecore.EStructuralFeature.Setting setting : settings) {
		        «getIncomingLinksByTypeMethodBody(it.modelFacet, it)»
		    }
		    return result;  
		}
	'''

	def CharSequence getICustomDiagramUpdater(GenContainerBase it) '''org.eclipse.papyrus.uml.diagram.common.part.ICustomDiagramUpdater<«nodeDescriptor.qualifiedClassName(it.diagramUpdater)»>'''

	override getSemanticChildrenOfView(GenContainerBase it) '''
		«IF it.eResource.allContents.filter(typeof(SpecificDiagramUpdater)).filter[v|v.genNode == it && v.classpath != null].
			size != 0»
			«generatedMemberComment»
			«FOR updater : it.eResource.allContents.filter(typeof(SpecificDiagramUpdater)).filter[v|
			v.genNode == it && v.classpath != null].toIterable»
				public static «listOfNodeDescriptors» «getSemanticChildrenMethodName(it)»(org.eclipse.gmf.runtime.notation.View view) {
					«getICustomDiagramUpdater(it)» customUpdater = new «updater.classpath»();
					return customUpdater.getSemanticChildren(view);
				}
			«ENDFOR»	
		«ELSE»
			«generatedMemberComment»
			public static «listOfNodeDescriptors» «getSemanticChildrenMethodName(it)»(org.eclipse.gmf.runtime.notation.View view) {
				«IF getSemanticChildrenChildFeatures(it).notEmpty || it.getPhantomNodes().notEmpty»
					«defineModelElement(it)»
					«newLinkedListOfNodeDescriptors(it.diagramUpdater, 'result')»();
					«/* childMetaFeature can be null here! */FOR childMetaFeature : getSemanticChildrenChildFeatures(it)»
						«IF null == childMetaFeature»
							{ 	/*FIXME no containment/child feature found in the genmodel, toolsmith need to specify Class here manually*/ childElement = 
								/*FIXME no containment/child feature found in the genmodel, toolsmith need to specify correct one here manually*/;
						«ELSEIF childMetaFeature.listType»
							for (java.util.Iterator<?> it = «xptMetaModel.getFeatureValue(childMetaFeature, 'modelElement', it.getModelElementType())».iterator(); it.hasNext();) {
							«xptMetaModel.DeclareAndAssign(childMetaFeature.typeGenClass, 'childElement', 'it.next()', true)»
						«ELSE»
							{ «xptMetaModel.DeclareAndAssign(childMetaFeature.typeGenClass, 'childElement', 'modelElement',
			it.getModelElementType(), childMetaFeature)»
						«ENDIF»
						int visualID = «xptVisualIDRegistry.getNodeVisualIDMethodCall(it.diagram)»(view, «xptMetaModel.
			DowncastToEObject(childMetaFeature.typeGenClass, 'childElement')»);
						«FOR next : getSemanticChildren(it, childMetaFeature)»
							«checkChildElementVisualID(next, null != childMetaFeature && childMetaFeature.listType)»
						«ENDFOR»
						}
					«ENDFOR»
					«IF it.getPhantomNodes.notEmpty»
						org.eclipse.emf.ecore.resource.Resource resource = modelElement.eResource();
						for (java.util.Iterator<org.eclipse.emf.ecore.EObject> it = getPhantomNodesIterator(resource)) {
							org.eclipse.emf.ecore.EObject childElement = it.next();
							if (childElement == modelElement) {
								continue;
							}
							«FOR phantom : it.phantomNodes»
								«addNextIfPhantom(phantom)»
							«ENDFOR»
						}
					«ENDIF»		
					return result;
				«ELSE»
					return «newEmptyList()»;
				«ENDIF»
			}
		«ENDIF»	
	'''
	
	override defineLinkSource(TypeLinkModelFacet it, boolean inLoop) '''
		«IF sourceMetaFeature.listType»
		java.util.List<?> sources = «xptMetaModel.getFeatureValue(sourceMetaFeature, 'link', metaClass)»;
		Object theSource = sources.size() == 1 ? sources.get(0) : null;
		if («xptMetaModel.NotInstance(it.sourceType, 'theSource')») {
			«stopLinkProcessing(inLoop)»
		}
		«xptMetaModel.DeclareAndAssign(it.sourceType, 'src', 'theSource', true)»
		«ELSE»
		«xptMetaModel.DeclareAndAssign(it.sourceType, 'src', 'link', metaClass, sourceMetaFeature)»
		«ENDIF»
	'''
	
	def isDiagram(GenDiagram it) ''''''

	override defineLinkDestination(TypeLinkModelFacet it, Boolean inLoop) '''
		«IF targetMetaFeature.listType»
		java.util.List<?> targets = «xptMetaModel.getFeatureValue(it.targetMetaFeature, 'link', metaClass)»;
		Object theTarget = targets.size() == 1 ? targets.get(0) : null;
		if («xptMetaModel.NotInstance(it.targetType, 'theTarget')») {
			«stopLinkProcessing(inLoop)»
		}
		«xptMetaModel.DeclareAndAssign(it.targetType, 'dst', 'theTarget', true)»
		«ELSE»
		«xptMetaModel.DeclareAndAssign(it.targetType, 'dst', 'link', metaClass, targetMetaFeature)»
		«ENDIF»
	'''

}
