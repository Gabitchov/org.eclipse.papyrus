/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.policies;

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
import org.eclipse.papyrus.diagram.clazz.edit.parts.ConstraintEditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockAttributeCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockConstraintCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockOperationCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockPartCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockReferenceCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.BlockValueCompartmentEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.OperationEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts.PropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlVisualIDRegistry;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.providers.SysmlElementTypes;

/**
 * @generated
 */
public class BlockItemSemanticEditPolicy extends SysmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public BlockItemSemanticEditPolicy() {
		super(SysmlElementTypes.Block_2001);
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
			// there are indirectly referenced children, need extra commands: true
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
			switch(SysmlVisualIDRegistry.getVisualID(node)) {
			case BlockAttributeCompartmentEditPart.VISUAL_ID:
			case BlockReferenceCompartmentEditPart.VISUAL_ID:
			case BlockValueCompartmentEditPart.VISUAL_ID:
			case BlockPartCompartmentEditPart.VISUAL_ID:
				for(Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node)cit.next();
					switch(SysmlVisualIDRegistry.getVisualID(cnode)) {
					case PropertyEditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: false
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			case BlockOperationCompartmentEditPart.VISUAL_ID:
				for(Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node)cit.next();
					switch(SysmlVisualIDRegistry.getVisualID(cnode)) {
					case OperationEditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: false
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			case BlockConstraintCompartmentEditPart.VISUAL_ID:
				for(Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node)cit.next();
					switch(UMLVisualIDRegistry.getVisualID(cnode)) {
					case ConstraintEditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: false
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
