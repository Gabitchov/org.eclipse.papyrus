/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 *	  Modified by Patrick Tessier (CEA LIST)
 *	  Emilien Perico (Atos Origin) - update template for GMF 2.2 compliance
 */
package aspects.xpt.navigator

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenNavigator
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorReferenceType
import xpt.Common
import xpt.Common_qvto
import xpt.editor.VisualIDRegistry
import xpt.navigator.Utils_qvto

@Singleton class NavigatorContentProvider extends xpt.navigator.NavigatorContentProvider {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension Utils_qvto;

	@Inject VisualIDRegistry xptVisualIDRegistry;


	override NavigatorContentProvider(GenNavigator it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment()»
		public class «className(it)» implements org.eclipse.ui.navigator.ICommonContentProvider {
		
			«attributes(it)»
			
			«constructor(it)»
			
			«genAllMethodNodeCase» 
		
			«iContentProvider(it)»
			
			«iStructuredContentProvider(it)»
			
			«iMementoAware(it)»
			   
			   «iCommonContentProvider(it)»
			   
			   «iTreeContentProvider(it)»
			   
			   «additions(it)»
		}
	'''



	override processChanges(GenNavigator it) '''
		for (java.util.Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
			org.eclipse.emf.ecore.resource.Resource nextResource = (org.eclipse.emf.ecore.resource.Resource) it.next();
				nextResource.unload();
		}
		if (myViewer != null) {
			myViewer.getControl().getDisplay().asyncExec(myViewerRefreshRunnable);
		}
		return true;
	'''



	override dispose(GenNavigator it) '''
		«generatedMemberComment()»
		public void dispose() {
			myWorkspaceSynchronizer.dispose();
			myWorkspaceSynchronizer = null;
			myViewerRefreshRunnable = null;
			
			for (java.util.Iterator it = myEditingDomain.getResourceSet().getResources().iterator(); it.hasNext();) {
				org.eclipse.emf.ecore.resource.Resource resource = (org.eclipse.emf.ecore.resource.Resource) it.next();
				resource.unload();
			}
			
			((org.eclipse.emf.transaction.TransactionalEditingDomain) myEditingDomain).dispose();
			myEditingDomain = null;
		}
	'''



	override getFileChildren(GenNavigator it) '''
		«var references = getChildReferencesFrom(it, null)»
		«getFileResource(it)»
		java.util.Collection result = new java.util.ArrayList();
		«FOR groupName : getGroupNames(references)» 
			«initGroupVariables(groupName, it, references, 'file', null)»
		«ENDFOR»
		java.util.ArrayList<org.eclipse.gmf.runtime.notation.View> topViews = new java.util.ArrayList<org.eclipse.gmf.runtime.notation.View>(resource.getContents().size());
		for (org.eclipse.emf.ecore.EObject o : resource.getContents()) {
			if (o instanceof org.eclipse.gmf.runtime.notation.View) {
				topViews.add((org.eclipse.gmf.runtime.notation.View) o);
			}
		}
		«FOR ref : references»
			«addNavigatorItemsPrefix(ref)»selectViewsByType(resource.getContents(), «getChildViewType(ref.child)»)«addNavigatorItemsSuffix(ref, 'file', false)»
		«ENDFOR»
		«FOR groupName : getGroupNames(references)»
			«addGroups(groupName, references)»
		«ENDFOR»
		return result.toArray();
	'''



	override getViewChildren(GenNavigator it) '''
		«generatedMemberComment()»
		private Object[] getViewChildren(org.eclipse.gmf.runtime.notation.View view, Object parentElement) {
		   	switch («xptVisualIDRegistry.getVisualIDMethodCall(it.editorGen.diagram)»(view)) {
				«««	BEGIN: PapyrusGenCode
				««« Restructuration of the case 
		   		«FOR node : getNavigatorContainerNodes(it)»
		   			«caseNavigatorNode(node, it)»	
		   		«ENDFOR»
		   		«««BEGIN: PapyrusGenCode
			}
			return EMPTY_ARRAY;
		}
	'''

	override utilityMethods(GenNavigator it) '''
		«generatedMemberComment»
		private java.util.Collection getLinksSourceByType(java.util.Collection edges, String type) {
			java.util.Collection result = new java.util.ArrayList();
		 	for (java.util.Iterator it = edges.iterator(); it.hasNext();) {
		 		org.eclipse.gmf.runtime.notation.Edge nextEdge = (org.eclipse.gmf.runtime.notation.Edge) it.next();
		 		org.eclipse.gmf.runtime.notation.View nextEdgeSource = nextEdge.getSource();
		 		if (type.equals(nextEdgeSource.getType()) && isOwnView(nextEdgeSource)) {
		 			result.add(nextEdgeSource);
		 		}
		 	}
		 	return result;
		}
			
		«generatedMemberComment»
		 private java.util.Collection getLinksTargetByType(java.util.Collection edges, String type) {
			java.util.Collection result = new java.util.ArrayList();
		 	for (java.util.Iterator it = edges.iterator(); it.hasNext();) {
		 		org.eclipse.gmf.runtime.notation.Edge nextEdge = (org.eclipse.gmf.runtime.notation.Edge) it.next();
		 		org.eclipse.gmf.runtime.notation.View nextEdgeTarget = nextEdge.getTarget();
		 		if (type.equals(nextEdgeTarget.getType()) && isOwnView(nextEdgeTarget)) {
		 			result.add(nextEdgeTarget);
		 		}
		 	}
		 	return result;
		}
		«generatedMemberComment»
		 private java.util.Collection getOutgoingLinksByType(java.util.Collection nodes, String type) {
			java.util.Collection result = new java.util.ArrayList();
		 	for (java.util.Iterator it = nodes.iterator(); it.hasNext();) {
		 		org.eclipse.gmf.runtime.notation.View nextNode = (org.eclipse.gmf.runtime.notation.View) it.next();
				result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		 	}
		 	return result;
		}
			
		«generatedMemberComment»
		private java.util.Collection getIncomingLinksByType(java.util.Collection nodes, String type) {
			java.util.Collection result = new java.util.ArrayList();
		 	for (java.util.Iterator it = nodes.iterator(); it.hasNext();) {
		 		org.eclipse.gmf.runtime.notation.View nextNode = (org.eclipse.gmf.runtime.notation.View) it.next();
				result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		 	}
		 	return result;
		}
			
		«generatedMemberComment»
		private java.util.Collection getChildrenByType(java.util.Collection nodes, String type) {
			java.util.Collection result = new java.util.ArrayList();
			for (java.util.Iterator it = nodes.iterator(); it.hasNext();) {
				org.eclipse.gmf.runtime.notation.View nextNode = (org.eclipse.gmf.runtime.notation.View) it.next();
				result.addAll(selectViewsByType(nextNode.getChildren(), type));
			}
			return result;
		}
			
		«generatedMemberComment»
		private java.util.Collection getDiagramLinksByType(java.util.Collection diagrams, String type) {
			java.util.Collection result = new java.util.ArrayList();
			for (java.util.Iterator it = diagrams.iterator(); it.hasNext();) {
				org.eclipse.gmf.runtime.notation.Diagram nextDiagram = (org.eclipse.gmf.runtime.notation.Diagram) it.next();
				result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
			}
			return result;
		}
		«generatedMemberComment»
		private java.util.Collection selectViewsByType(java.util.Collection views, String type) {
			java.util.Collection result = new java.util.ArrayList();
			for (java.util.Iterator it = views.iterator(); it.hasNext();) {
				org.eclipse.gmf.runtime.notation.View nextView = (org.eclipse.gmf.runtime.notation.View) it.next();
				if (type.equals(nextView.getType()) && isOwnView(nextView)) {
					result.add(nextView);
				}
			}
			return result;
		}
			
				«generatedMemberComment()»
				private boolean isOwnView(org.eclipse.gmf.runtime.notation.View view) {
					return «VisualIDRegistry::modelID(editorGen.diagram)».equals(«xptVisualIDRegistry.
					getModelIDMethodCall(editorGen.diagram)»(view));
				}
			
		«generatedMemberComment»
		private java.util.Collection createNavigatorItems(java.util.Collection views, Object parent, boolean isLeafs) {
			java.util.Collection result = new java.util.ArrayList();
			for (java.util.Iterator it = views.iterator(); it.hasNext();) {
				result.add(new «getNavigatorItemQualifiedClassName()»((org.eclipse.gmf.runtime.notation.View) it.next(), parent, isLeafs));
			}
			return result;
		}
		«getForeignShortcuts(it)»
	'''

	override getForeignShortcuts(GenNavigator it) '''
		«IF editorGen.diagram.generateCreateShortcutAction() && getChildReferencesFrom(it, editorGen.diagram).notEmpty»
			
				«generatedMemberComment()»
				private java.util.Collection getForeignShortcuts(org.eclipse.gmf.runtime.notation.Diagram diagram, Object parent) {
					java.util.Collection result = new java.util.ArrayList();
					for (java.util.Iterator it = diagram.getChildren().iterator(); it.hasNext();) {
						org.eclipse.gmf.runtime.notation.View nextView = (org.eclipse.gmf.runtime.notation.View) it.next();
						if (!isOwnView(nextView) && nextView.getEAnnotation("Shortcut") != null) { «nonNLS»
							result.add(nextView);
						}
					}
					return createNavigatorItems(result, parent, false);
				}
		«ENDIF»
	'''

	

	override caseNavigatorNode(GenCommonBase it, GenNavigator navigator) '''
		
			case «VisualIDRegistry::visualID(it)»: {
				«««BEGIN: PapyrusGenCode
				««« this code has been modified to call directly submethods
				//modification of the template to avoid mistake of 65kb.
				return getViewChildrenFor«it.editPartClassName»(view, parentElement);
				«««END: PapyrusGenCode
			}
	'''
	

	
//BEGIN: PapyrusGenCode
//Loop to call generator of each method
def genAllMethodNodeCase(GenNavigator it)'''
«FOR container :getNavigatorContainerNodes(it)»
« caseMethodNodeNode(container,it) »
«ENDFOR»

'''
//END: PapyrusGenCode
//BEGIN: PapyrusGenCode
//this template has been modified to fixe bug generation by GMF framework.
//Is avoid generated method that are greater than 64Kb
def caseMethodNodeNode(GenCommonBase it, GenNavigator navigator) '''
/**
 *
 *Papyrus Template
 *this method is a modification of gmf code in order to avoid  getViewChidreen() method becoming greater than 64kb.
 *@generated
**/
private Object[] getViewChildrenFor«it.editPartClassName»(org.eclipse.gmf.runtime.notation.View view, Object parentElement){
	java.util.Collection result = new java.util.ArrayList();
	«addForeignShortcuts(it)»
	«var _references = getChildReferencesFrom(navigator, it)»
		«FOR groupNames : getGroupNames(_references)»
			«initGroupVariables(groupNames,navigator, _references, 'parentElement', it)»
		«ENDFOR»
		


		«IF ! _references.empty»
		«FOR referencesIterator : 1.._references.size»
		«var reference = _references.get(referencesIterator-1)»
			«IF ! reference.findConnectionPaths.empty»
			«FOR pathsIterator : 1..reference.findConnectionPaths.size»
				«var path = reference.findConnectionPaths.get(pathsIterator-1)»
				«IF ! path.segments.empty»
				«FOR segmentsIterator : 1..path.segments.size»
				«var segment = path.segments.get(segmentsIterator-1)»
					«IF referencesIterator==1 && pathsIterator==1 && segmentsIterator==1»java.util.Collection «ENDIF»
					connectedViews = «childrenMethodName(segment.from,reference.referenceType, segment) »
					(«IF segmentsIterator==0»java.util.Collections.singleton(view)«ELSE»connectedViews«ENDIF»
					, «xptVisualIDRegistry.typeMethodCall(segment.to)»);

				«ENDFOR»
				«ENDIF»
				«addNavigatorItemsPrefix(reference)»connectedViews«addNavigatorItemsSuffix(reference,'parentElement', reference.referenceType != GenNavigatorReferenceType.CHILDREN_LITERAL) »
			«ENDFOR»
			«ENDIF»
		«ENDFOR»
		«ENDIF»
		
		«FOR groupNames : getGroupNames(_references)»
		« addGroups(groupNames,_references) »
		«ENDFOR»
		

	return result.toArray();
}
'''
//END: PapyrusGenCode







}
