/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.activitygroup;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.CreateEditPoliciesOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpolicy.IEditPolicyProvider;
import org.eclipse.papyrus.diagram.activity.activitygroup.editpolicy.notifiers.ActivityGroupEditPolicy;
import org.eclipse.papyrus.diagram.activity.activitygroup.editpolicy.notifiers.ActivityNodeEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.UMLPackage;


public class GroupEditPolicyProvider implements IEditPolicyProvider {
	
	
	public void addProviderChangeListener(IProviderChangeListener listener) {	
	}


	public void removeProviderChangeListener(IProviderChangeListener listener) {	
	}

	
	/**
	 * 
	 * {@inheritDoc}
	 */
	public void createEditPolicies(EditPart editPart) {
		if (editPart instanceof ActivityEditPart){
			editPart.installEditPolicy(IGroupEditPolicies.GROUP_FRAMEWORK_NOTIFYING_EDIT_POLICY, new ActivityGroupEditPolicy(ContainerNodeDescriptorRegistry.getInstance().getContainerNodeDescriptor(UMLPackage.Literals.ACTIVITY)));
//			editPart.installEditPolicy(GroupEditPolicies.sGROUP_FRAMEWORK_HANDLING_EDIT_POLICY, new ActivityGroupEditPolicy(ContainerNodeDescriptorRegistry.getInstance().getContainerNodeDescriptor(UMLPackage.Literals.ACTIVITY)));
		}
		if (editPart instanceof IGraphicalEditPart && editPart.getParent() instanceof IGraphicalEditPart){
			IGraphicalEditPart graphEditpart = (IGraphicalEditPart)editPart;
			//is top edit part of the element
			IGraphicalEditPart parentEditPart = (IGraphicalEditPart)editPart.getParent();
			if (!graphEditpart.resolveSemanticElement().equals(parentEditPart.resolveSemanticElement())){
				EObject resolveSemanticElement = graphEditpart.resolveSemanticElement();
				if (resolveSemanticElement instanceof ActivityNode){
					graphEditpart.installEditPolicy(IGroupEditPolicies.GROUP_FRAMEWORK_NOTIFYING_EDIT_POLICY, new ActivityNodeEditPolicy(ContainerNodeDescriptorRegistry.getInstance().getContainerNodeDescriptor(UMLPackage.Literals.ACTIVITY_NODE)));
//					graphEditpart.installEditPolicy(GroupEditPolicies.GROUP_FRAMEWORK_HANDLING_EDIT_POLICY, new NodeGroupRequestHandler(ContainerNodeDescriptorRegistry.getInstance().getContainerNodeDescriptor(UMLPackage.Literals.ACTIVITY_NODE)));
				} 
				if (resolveSemanticElement instanceof ActivityGroup) {
					graphEditpart.installEditPolicy(IGroupEditPolicies.GROUP_FRAMEWORK_NOTIFYING_EDIT_POLICY, new ActivityGroupEditPolicy(ContainerNodeDescriptorRegistry.getInstance().getContainerNodeDescriptor(resolveSemanticElement.eClass())));	
//					graphEditpart.installEditPolicy(GroupEditPolicies.GROUP_FRAMEWORK_HANDLING_EDIT_POLICY, new ActivityGroupSwitch(ContainerNodeDescriptorRegistry.getInstance().getContainerNodeDescriptor(resolveSemanticElement.eClass())).doSwitch(resolveSemanticElement));

				}
			}
			
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		CreateEditPoliciesOperation epOperation = (CreateEditPoliciesOperation)operation;
		if(!(epOperation.getEditPart() instanceof GraphicalEditPart)) {
			return false;
		}
		GraphicalEditPart gep = (GraphicalEditPart)epOperation.getEditPart();
		String diagramType = gep.getNotationView().getDiagram().getType();
		if(ActivityDiagramEditPart.MODEL_ID.equals(diagramType)) {
			return true;
		}
		return false;
	}

}
