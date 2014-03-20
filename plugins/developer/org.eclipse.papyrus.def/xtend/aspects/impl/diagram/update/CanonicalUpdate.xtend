/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Artem Tikhomirov             - refactoring of containerBaseCanonicalMethods.xpt; extraction of API/non-API of CEP templates
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.impl.diagram.update

import com.google.inject.Inject
import com.google.inject.Singleton
import metamodel.MetaModel
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common
import xpt.diagram.updater.DiagramUpdater
import xpt.diagram.updater.NodeDescriptor
import xpt.diagram.updater.Utils_qvto
import xpt.diagram.updater.LinkDescriptor
import xpt.editor.VisualIDRegistry

@Singleton class CanonicalUpdate extends impl.diagram.update.CanonicalUpdate {
	@Inject extension Common;
	@Inject extension Utils_qvto;

	@Inject NodeDescriptor nodeDescriptor;
	@Inject MetaModel xptMetaModel;
	@Inject DiagramUpdater xptDiagramUpdater;
	@Inject LinkDescriptor linkDescriptor;
	@Inject VisualIDRegistry xptVisualIDRegistry;

	override def getFeaturesToSynchronizeMethod(GenContainerBase it) '''
		«IF getSemanticChildrenChildFeatures(it).size == 1»
			
				«generatedMemberComment»
				protected org.eclipse.emf.ecore.EStructuralFeature getFeatureToSynchronize() {
					return «xptMetaModel.MetaFeature(getSemanticChildrenContainmentFeatures(it).head)»;
				}
		«ELSEIF getSemanticChildrenChildFeatures(it).size > 1»
			
				«generatedMemberComment»
				protected java.util.Set<org.eclipse.emf.ecore.EStructuralFeature> getFeaturesToSynchronize() {
					if (myFeaturesToSynchronize == null) {
						myFeaturesToSynchronize = new java.util.HashSet<org.eclipse.emf.ecore.EStructuralFeature>();
						«FOR f : getSemanticChildrenContainmentFeatures(it)»
							«addContainmentFeature(f)»
						«ENDFOR»
					}
					return myFeaturesToSynchronize;
				}
		«ENDIF»
	'''

	override def getSemanticChildrenListMethod(GenContainerBase it) '''
		«generatedMemberComment»
		protected java.util.List<org.eclipse.emf.ecore.EObject> getSemanticChildrenList() {
			«IF hasSemanticChildren(it)/*REVISIT: is there real need for this check - Generator seems to consult needsCanonicalEP, which in turns ensures there are semantic children?*/»
				org.eclipse.gmf.runtime.notation.View viewObject = (org.eclipse.gmf.runtime.notation.View) getHost().getModel();
				java.util.LinkedList<org.eclipse.emf.ecore.EObject> result = new java.util.LinkedList<org.eclipse.emf.ecore.EObject>();
				java.util.List<«nodeDescriptor.qualifiedClassName(it.diagram.editorGen.diagramUpdater)»> childDescriptors = «xptDiagramUpdater.
			getSemanticChildrenMethodCall(it)»(viewObject);
				for («nodeDescriptor.qualifiedClassName(it.diagram.editorGen.diagramUpdater)» d : childDescriptors) {
					result.add(d.getModelElement());
				}
				return result;
			«ELSE»
				return java.util.Collections.EMPTY_LIST;
			«ENDIF»
		}
	'''

	override def refreshConnectionsBody(GenDiagram it) '''
		«Domain2Notation(it)» domain2NotationMap = new «Domain2Notation(it)»();
		java.util.Collection<«linkDescriptor.qualifiedClassName(editorGen.diagramUpdater)»> linkDescriptors = collectAllLinks(getDiagram(), domain2NotationMap);
		java.util.List<org.eclipse.gmf.runtime.notation.View> edges = new java.util.ArrayList<org.eclipse.gmf.runtime.notation.View>();
		for (Object edge : getDiagram().getEdges())
		{
			if (edge instanceof org.eclipse.gmf.runtime.notation.View)
			{
				edges.add((org.eclipse.gmf.runtime.notation.View) edge);
			}
		}
		java.util.Collection<org.eclipse.gmf.runtime.notation.View> existingLinks = new java.util.LinkedList<org.eclipse.gmf.runtime.notation.View>(edges);
		for (java.util.Iterator<org.eclipse.gmf.runtime.notation.View> linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
			org.eclipse.gmf.runtime.notation.Edge nextDiagramLink = (org.eclipse.gmf.runtime.notation.Edge) linksIterator.next();
			int diagramLinkVisualID = «xptVisualIDRegistry.getVisualIDMethodCall(it)»(nextDiagramLink);
			if (diagramLinkVisualID == -1«FOR link : links.filter[gl|gl.modelFacet == null]»«compareLinkVisualID(link)»«ENDFOR») {
				if (nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {
					linksIterator.remove();
				}
				continue;
			}
			org.eclipse.emf.ecore.EObject diagramLinkObject = nextDiagramLink.getElement();
			org.eclipse.emf.ecore.EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
			org.eclipse.emf.ecore.EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
			for (java.util.Iterator<«it.editorGen.diagramUpdater.linkDescriptorQualifiedClassName»> linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {
				«linkDescriptor.qualifiedClassName(it.editorGen.diagramUpdater)» nextLinkDescriptor = linkDescriptorsIterator.next();
				if (diagramLinkObject == nextLinkDescriptor.getModelElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination() && diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
					linksIterator.remove();
					linkDescriptorsIterator.remove();
					break;
				}
			}
		}
		deleteViews(existingLinks.iterator());
		return createConnections(linkDescriptors, domain2NotationMap);
	'''

	override def collectAllLinksMethod(GenDiagram it) '''
		«generatedMemberComment»
		private java.util.Collection<«linkDescriptor.qualifiedClassName(it.editorGen.diagramUpdater)»> collectAllLinks(org.eclipse.gmf.runtime.notation.View view, «Domain2Notation(
				it)» domain2NotationMap) {
			if (!«VisualIDRegistry::modelID(it)».equals(«xptVisualIDRegistry.getModelIDMethodCall(it)»(view))) {
				return java.util.Collections.emptyList();
			}
			java.util.LinkedList<«linkDescriptor.qualifiedClassName(it.editorGen.diagramUpdater)»> result = new java.util.LinkedList<«linkDescriptor.
				qualifiedClassName(it.editorGen.diagramUpdater)»>();
			switch («xptVisualIDRegistry.getVisualIDMethodCall(it)»(view)) {
				«FOR se : it.allSemanticElements»
				«caseSemanticElement(se)»
				«ENDFOR»
			}
			for (java.util.Iterator<?> children = view.getChildren().iterator(); children.hasNext();) {
				result.addAll(collectAllLinks((org.eclipse.gmf.runtime.notation.View) children.next(), domain2NotationMap));
			}
			for (java.util.Iterator<?> edges = view.getSourceEdges().iterator(); edges.hasNext();) {
				result.addAll(collectAllLinks((org.eclipse.gmf.runtime.notation.View) edges.next(), domain2NotationMap));
			}
			return result;
		}
		'''

}
