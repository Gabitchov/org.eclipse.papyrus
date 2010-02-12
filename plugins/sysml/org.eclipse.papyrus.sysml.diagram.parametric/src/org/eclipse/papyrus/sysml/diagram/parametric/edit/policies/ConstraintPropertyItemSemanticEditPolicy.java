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
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.commands.Property2CreateCommand;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.Property2EditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.part.SysmlVisualIDRegistry;
import org.eclipse.papyrus.sysml.diagram.parametric.providers.SysmlElementTypes;
import org.eclipse.uml2.uml.Property;

/**
 * @generated
 */
public class ConstraintPropertyItemSemanticEditPolicy extends SysmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ConstraintPropertyItemSemanticEditPolicy() {
		super(SysmlElementTypes.ConstraintProperty_2003);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (SysmlElementTypes.Property_3002 == req.getElementType()) {
			return getGEFWrapper(new Property2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated NOT delete property views if any
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: true
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);			
			// delete host element
			cmd.add(new DestroyElementCommand(req));
			// destroy base property
			addDestroyBasePropertyCommand(cmd);
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}		
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * Delete property views of the constraint property
	 * @generated NOT
	 */
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		for (Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node) nit.next();
			switch (SysmlVisualIDRegistry.getVisualID(node)) {
			case Property2EditPart.VISUAL_ID:
				// only delete from diagram
				cmd.add(new DeleteCommand(getEditingDomain(), node));
				break;
			}
		}
	}
	
	/**
	 * Delete the base property from the constraint property
	 * @generated NOT
	 */
	private void addDestroyBasePropertyCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		EObject element = view.getElement();
		if (element instanceof ConstraintProperty) {
			Property property = ((ConstraintProperty) element).getBase_Property();
			if (property != null) {
				DestroyElementRequest request = new DestroyElementRequest(property, false);
				cmd.add(new DestroyElementCommand(request));				
			}
		}
	}

}
