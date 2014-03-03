/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.impl.diagram.editparts

import com.google.inject.Inject
import com.google.inject.Singleton
import metamodel.MetaModel
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenNode
import xpt.diagram.commands.CreateShortcutDecorationsCommand
import xpt.diagram.editparts.Common
import xpt.diagram.editparts.Utils_qvto

/**
 * Revisit: [MG]: @Inject extension same-named-api-class -> template extends api-class?
 */
//DOCUMENTATION: PapyrusGencode
//This template has been modify to allow the drag and drop
@Singleton class DiagramEditPart extends impl.diagram.editparts.DiagramEditPart {
		@Inject extension MetaModel;
	@Inject extension Utils_qvto;
	
	@Inject Common xptEditpartsCommon;
	@Inject CreateShortcutDecorationsCommand createShoutrtcutDecorationCommand;
	
//BEGIN: PapyrusGenCode
//computes super type of the link edit part in case the edit part manages a representation of a UML element
def extendsListContents(GenDiagram it)'''
org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusDiagramEditPart
'''
//END: BEGIN: PapyrusGenCode

override createDefaultEditPoliciesBody(GenDiagram it) '''
	super.createDefaultEditPolicies();
	
	installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CREATION_ROLE, new org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy());
	installEditPolicy(org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy.PASTE_ROLE, new org.eclipse.papyrus.uml.diagram.common.editpolicies.DuplicatePasteEditPolicy());
	
	«xptEditpartsCommon.installSemanticEditPolicy(it)»
	«xptEditpartsCommon.installCanonicalEditPolicy(it)»
	«««	«xptEditpartsCommon.installCreationEditPolicy(it)»
	«IF generateCreateShortcutAction() && null == editorGen.application»
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.DRAG_DROP_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy() {
			public org.eclipse.gef.commands.Command getDropObjectsCommand(org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest dropRequest) {
				java.util.List<org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor> viewDescriptors = new java.util.ArrayList<org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor>();
				for (java.util.Iterator<?> it = dropRequest.getObjects().iterator(); it.hasNext();) {
					Object nextObject = it.next();
					if (false == nextObject instanceof org.eclipse.emf.ecore.EObject) {
						continue;
					}
					viewDescriptors.add(new org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor(new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter((org.eclipse.emf.ecore.EObject) nextObject), org.eclipse.gmf.runtime.notation.Node.class, null, getDiagramPreferencesHint()));
				}
				return createShortcutsCommand(dropRequest, viewDescriptors);
			}

			private org.eclipse.gef.commands.Command createShortcutsCommand(org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest dropRequest, java.util.List<org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor> viewDescriptors) {
				org.eclipse.gef.commands.Command command = createViewsAndArrangeCommand(dropRequest, viewDescriptors);
				if (command != null) {
					return command.chain(new org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy(new «createShoutrtcutDecorationCommand.qualifiedClassName(it)»(getEditingDomain(), (org.eclipse.gmf.runtime.notation.View) getModel(), viewDescriptors)));
				}
				return null;
			}
		});
	«ENDIF»
	«IF shouldGenerateDiagramViewmap(it)»
		// diagram figure does layout; need to install child editpolicy to show selection feedback
		installEditPolicy(org.eclipse.gef.EditPolicy.LAYOUT_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {
			protected org.eclipse.gef.EditPolicy createChildEditPolicy(org.eclipse.gef.EditPart child) {
				final org.eclipse.gef.editpolicies.NonResizableEditPolicy p = new org.eclipse.gef.editpolicies.NonResizableEditPolicy();
				p.setDragAllowed(false);
				return p;
			}
			protected org.eclipse.gef.commands.Command getMoveChildrenCommand(org.eclipse.gef.Request request) {
				return null;
			}
			protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gef.requests.CreateRequest request) {
				return null;
			}
		});
	«ENDIF»
	«xptEditpartsCommon.behaviour(it)»
	// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
'''

def featureForMetaclass (GenNode it)'''
		if (« MetaClass(modelFacet.metaClass)».equals(class1)) {
			return «MetaFeature(modelFacet.containmentMetaFeature)»;
		}
'''

}
