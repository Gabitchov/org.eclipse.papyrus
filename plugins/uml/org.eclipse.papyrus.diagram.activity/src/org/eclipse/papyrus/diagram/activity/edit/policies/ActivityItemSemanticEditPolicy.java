/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityParametersCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityPostConditionsCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityPreConditionsCompartmentEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.Constraint2EditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.diagram.activity.edit.parts.ParameterEditPart;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;

/**
 * @generated
 */
public class ActivityItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ActivityItemSemanticEditPolicy() {
		super(UMLElementTypes.Activity_2001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View)getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if(annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View)getHost().getModel();
		for(Iterator nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node)nit.next();
			switch(UMLVisualIDRegistry.getVisualID(node)) {
			case ActivityActivityParametersCompartmentEditPart.VISUAL_ID:
				for(Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node)cit.next();
					switch(UMLVisualIDRegistry.getVisualID(cnode)) {
					case ParameterEditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			case ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID:
				for(Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node)cit.next();
					switch(UMLVisualIDRegistry.getVisualID(cnode)) {
					case ConstraintEditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			case ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID:
				for(Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node)cit.next();
					switch(UMLVisualIDRegistry.getVisualID(cnode)) {
					case Constraint2EditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			case ActivityActivityContentCompartmentEditPart.VISUAL_ID:
				for(Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node)cit.next();
					switch(UMLVisualIDRegistry.getVisualID(cnode)) {
					case InitialNodeEditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case ActivityFinalNodeEditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					case FlowFinalNodeEditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			}
		}
	}

}
