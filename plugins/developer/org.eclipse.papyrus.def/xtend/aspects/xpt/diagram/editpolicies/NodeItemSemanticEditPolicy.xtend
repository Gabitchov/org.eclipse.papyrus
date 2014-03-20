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
 *    Artem Tikhomirov (Borland) - [257632] do not rely on EditPart presence for element deletion
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.diagram.editpolicies

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenChildNode
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import org.eclipse.papyrus.papyrusgmfgenextension.EditPartUsingDeleteService
import utils.UtilsItemSemanticEditPolicy
import xpt.Common
import xpt.editor.VisualIDRegistry

/**
 *	This template should be called only for non-design nodes (modelFacet != null) 
 *	because *ItemSemanticEditPolicy responsible for dealing with semantic model 
 *	elements and meaningless (should not be generated) for pure design nodes.   
 */
@Singleton class NodeItemSemanticEditPolicy extends xpt.diagram.editpolicies.NodeItemSemanticEditPolicy {
	
	@Inject extension Common;
	@Inject extension xpt.diagram.editpolicies.Utils_qvto;
	@Inject extension UtilsItemSemanticEditPolicy
	
	
	@Inject BaseItemSemanticEditPolicy xptBaseItemSemanticEditPolicy;
	@Inject childContainerCreateCommand xptChildContainerCreateCommand;
	@Inject linkCommands xptLinkCommands;
	@Inject VisualIDRegistry xptVisualIDRegistry;
	

	
	override NodeItemSemanticEditPolicy(GenNode it) '''
	«copyright(getDiagram().editorGen)»
	package «packageName(it)»;
	
	«generatedClassComment()»
	public class «className(it)» extends «xptBaseItemSemanticEditPolicy.qualifiedClassName(getDiagram())» {
	
		«xptBaseItemSemanticEditPolicy.defaultConstructor(it)»
	
		«xptChildContainerCreateCommand.childContainerCreateCommand(it.childNodes)»
	
	«««	Papyrus REM : 
	«««	Test to know how the delete of this EditPart is done : we used the DeleteService or the "Traditional method"
	
	«IF it.eResource.allContents.filter(typeof (EditPartUsingDeleteService)).filter[v | v.genView.contains(it)].size != 0»
		«generatedMemberComment»
		«getDestroyElementCommandByService(it)»
	«ELSE»
		«getDestroyElementCommand(it)»
		«IF hasChildrenOrCompartments(it)»
			«addDestroyChildNodesCommand(it)»
		«ENDIF»
	«ENDIF»	
	
		«xptLinkCommands.linkCommands(it)»
	
		«additions(it)»
	}
	'''

	override getDestroyElementCommand(GenNode it) '''
	«generatedMemberComment()»
protected org.eclipse.gef.commands.Command getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest req) {
 	org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) getHost().getModel();
	org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand cmd = new org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand(getEditingDomain(), null);
	cmd.setTransactionNestingEnabled(true);
	«««	«destroyEdges('view')»
	org.eclipse.emf.ecore.EAnnotation annotation = view.getEAnnotation("Shortcut");«nonNLS»
	if (annotation == null) {
		// there are indirectly referenced children, need extra commands: «it.childNodes.union(compartments.map(c | c.childNodes).flatten).exists[GenChildNode gcn | !isDirectlyOwned(gcn, it)]»
	«IF hasChildrenOrCompartments(it)»
			addDestroyChildNodesCommand(cmd);
	«ENDIF»
		addDestroyShortcutsCommand(cmd, view);
		// delete host element
		java.util.List<org.eclipse.emf.ecore.EObject> todestroy=new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		todestroy.add(req.getElementToDestroy());
		//cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(req));
		cmd.add(new org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper(new org.eclipse.emf.edit.command.DeleteCommand(getEditingDomain(),todestroy )));
	} else {«««Here, we may play smart and don't generate else for non-toplevel nodes(which can't be shortcuts). Is it worth doing?
		cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), view));
	}
	return getGEFWrapper(cmd.reduce());
}
	'''

	override addDestroyChildNodesCommand(GenNode it) '''
	«generatedMemberComment()»
	protected void addDestroyChildNodesCommand(org.eclipse.gmf.runtime.common.core.command.ICompositeCommand cmd) {
		org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) getHost().getModel();
		for (java.util.Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {
			org.eclipse.gmf.runtime.notation.Node node = (org.eclipse.gmf.runtime.notation.Node) nit.next();
			switch («xptVisualIDRegistry.getVisualIDMethodCall(it.diagram)»(node)) {
			«FOR cn : it.childNodes»
				«destroyChildNodes(cn, 'node', it)» 
			«ENDFOR»
			«FOR compartment : it.compartments»
			«xptVisualIDRegistry.caseVisualID(compartment)»
				for (java.util.Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
					org.eclipse.gmf.runtime.notation.Node cnode = (org.eclipse.gmf.runtime.notation.Node) cit.next();
					switch («xptVisualIDRegistry.getVisualIDMethodCall(it.diagram)»(cnode)) {
					«FOR cn : compartment.childNodes»	
						«destroyChildNodes(cn, 'cnode', it)»
					«ENDFOR»
					}
				}
				break;
			«ENDFOR»
			}
		}
	}
	'''


	/**
	* @param view - Notation element for the passed node
	* assumes 'cmd' to point to composite command
	*/
	override destroyEdges(GenNode it, String view) '''

«««	XXX: Though semantic editpolicy is supposed to create commands that operate with semantic elements only,
«««	old code used to delegate child/link deletion to respective editparts, which in turn led to semantic commands
«««	being combined with notational commands (BaseItemSemanticEditPolicy#addDeleteViewCommand()).
«««	---
«««	Use DiagramUpdater.get[Incoming|Outgoing]View instead, to clean links that are not present on a diagram
«««	(but don't forget to clean corresponding Edge, if any)


«««// This part is commented for Papyrus
«««// Some Papyrus diagrams with lots of elements are reaching the 65K Java limit for method size.
«««// The following change is not supposed to modify the method behavior, just propose a slight more 
«««// compact code to avoid size limit.
«««
««««IF genIncomingLinks->notEmpty()-»
«««	for («EXPAND CodeStyle::G('java.util.Iterator', '?' /*FIXME Refactor once Notation model is Java5*/)» it = «view».getTargetEdges().iterator(); it.hasNext();) {
«««		org.eclipse.gmf.runtime.notation.Edge incomingLink = (org.eclipse.gmf.runtime.notation.Edge) it.next();
««««FOREACH genIncomingLinks AS il-»
«««		if («EXPAND xpt::editor::VisualIDRegistry::getVisualIDMethodCall FOR getDiagram()»(incomingLink) == «EXPAND xpt::editor::VisualIDRegistry::visualID FOR il») {
«««			«EXPAND impl::diagram::commands::DeleteLinkCommand::newRequest('r', 'incomingLink') FOR il-»
«««			cmd.add(«EXPAND impl::diagram::commands::DeleteLinkCommand::newInstance('r') FOR il»);
«««			cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), incomingLink));
«««			continue;
«««		}
««««ENDFOREACH-»
«««	}
««««ENDIF-»
««««IF genOutgoingLinks->notEmpty()-»
«««	for («EXPAND CodeStyle::G('java.util.Iterator', '?' /*FIXME Refactor once Notation model is Java5*/)» it = «view».getSourceEdges().iterator(); it.hasNext();) {
«««		org.eclipse.gmf.runtime.notation.Edge outgoingLink = (org.eclipse.gmf.runtime.notation.Edge) it.next();
««««FOREACH genOutgoingLinks AS ol-»
«««		if («EXPAND xpt::editor::VisualIDRegistry::getVisualIDMethodCall FOR getDiagram()»(outgoingLink) == «EXPAND xpt::editor::VisualIDRegistry::visualID FOR ol») {
«««			«EXPAND impl::diagram::commands::DeleteLinkCommand::newRequest('r', 'outgoingLink') FOR ol-»
«««			cmd.add(«EXPAND impl::diagram::commands::DeleteLinkCommand::newInstance('r') FOR ol»);
«««			cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), outgoingLink));
«««			continue;
«««		}
««««ENDFOREACH-»
«««	}
««««ENDIF-»


«IF !genIncomingLinks.isEmpty()»
	for (java.util.Iterator<?> it = «view».getTargetEdges().iterator(); it.hasNext();) {
		org.eclipse.gmf.runtime.notation.Edge incomingLink = (org.eclipse.gmf.runtime.notation.Edge) it.next();
		switch(«xptVisualIDRegistry.getVisualIDMethodCall(getDiagram())»(incomingLink)) {
«IF !genIncomingLinks.filter[l | l.modelFacet instanceof FeatureLinkModelFacet].empty»		
«FOR il : genIncomingLinks.filter[l | l.modelFacet instanceof FeatureLinkModelFacet]»
			case «VisualIDRegistry.visualID(il)»:
«ENDFOR»		
				org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest destroyRefReq = new org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest(incomingLink.getSource().getElement(), null, incomingLink.getTarget().getElement(), false);
				cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand(destroyRefReq));
				cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), incomingLink));
				break;
«ENDIF»
«IF !genIncomingLinks.filter[l | l.modelFacet instanceof TypeLinkModelFacet].empty»	
«FOR il : genIncomingLinks.filter[l | l.modelFacet instanceof TypeLinkModelFacet]»
			case «VisualIDRegistry.visualID(il)»:
«ENDFOR»		
				org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest destroyEltReq = new org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(destroyEltReq));
				cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), incomingLink));
				break;
«ENDIF»				
		}
	}
«ENDIF»

«IF genOutgoingLinks.isEmpty()»
	for (java.util.Iterator<?> it = «view».getSourceEdges().iterator(); it.hasNext();) {
		org.eclipse.gmf.runtime.notation.Edge outgoingLink = (org.eclipse.gmf.runtime.notation.Edge) it.next();
		switch(«xptVisualIDRegistry.getVisualIDMethodCall(getDiagram())»(outgoingLink)) {
«IF !genOutgoingLinks.filter[l | l.modelFacet instanceof FeatureLinkModelFacet].empty»		
«FOR ol : genOutgoingLinks.filter[l | l.modelFacet instanceof FeatureLinkModelFacet]»
			case «VisualIDRegistry.visualID(ol)»:
«ENDFOR»		
				org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest destroyRefReq = new org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest(outgoingLink.getSource().getElement(), null, outgoingLink.getTarget().getElement(), false);
				cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand(destroyRefReq));
				cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), outgoingLink));
				break;
«ENDIF»
«IF !genOutgoingLinks.filter[l | l.modelFacet instanceof TypeLinkModelFacet].empty»	
«FOR ol : genOutgoingLinks.filter[l | l.modelFacet instanceof TypeLinkModelFacet]»
			case «VisualIDRegistry.visualID(ol)»:
«ENDFOR»		
				org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest destroyEltReq = new org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand(destroyEltReq));
				cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), outgoingLink));
				break;
«ENDIF»				
		}
	}
«ENDIF»
	'''


	
	private def static <T> Iterable<T> union(Iterable<? extends T> listA, Iterable<? extends T> listB) {
		var List<T> result = newLinkedList();
		result.addAll(listA);
		result.addAll(listB);
		return result;
	}
	
}
