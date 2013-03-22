/*****************************************************************************
 * Copyright (c) 2010 CEA
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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceDeleteHelper;

/**
 * This edit policy also deletes time/duration edit parts which are linked with the deleted edit part.
 */
public class ExecutionSpecificationComponentEditPolicy extends ComponentEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
		CompoundCommand deleteViewsCommand = new CompoundCommand();
		Command deleteViewCommand = super.createDeleteViewCommand(deleteRequest);
		deleteViewsCommand.add(deleteViewCommand);
		if(getHost() instanceof ShapeNodeEditPart) {
			TransactionalEditingDomain editingDomain = ((ShapeNodeEditPart)getHost()).getEditingDomain();
			SequenceDeleteHelper.completeDeleteExecutionSpecificationViewCommand(deleteViewsCommand, editingDomain, getHost());
			addDeleteViewChildrenCommand(deleteViewsCommand, editingDomain, (ShapeNodeEditPart)getHost());			
		}
		return deleteViewsCommand;
	}

	// support nested  actions and behaviors execution, https://bugs.eclipse.org/bugs/show_bug.cgi?id=384616
	public static void addDeleteViewChildrenCommand(CompoundCommand deleteViewsCommand, TransactionalEditingDomain editingDomain, ShapeNodeEditPart part) {
		List<ShapeNodeEditPart> list = LifelineXYLayoutEditPolicy.getAffixedExecutionSpecificationEditParts(part);
		for(ShapeNodeEditPart p : list){
			deleteViewsCommand.add(	new ICommandProxy(new DeleteCommand(editingDomain, (View) p.getModel())));
			SequenceDeleteHelper.completeDeleteExecutionSpecificationViewCommand(deleteViewsCommand, editingDomain, p);
			addDeleteViewChildrenCommand(deleteViewsCommand,editingDomain, p);  //recursive delete children
		}
	}
	
	public static void addDestroyElementChildrenCommand(CompoundCommand deleteElementsCommand, TransactionalEditingDomain editingDomain, EditPart part) {
		List<ShapeNodeEditPart> list = LifelineXYLayoutEditPolicy.getAffixedExecutionSpecificationEditParts((ShapeNodeEditPart)part);
		for(ShapeNodeEditPart p : list){
			Request request = new EditCommandRequestWrapper(new DestroyElementRequest(p.resolveSemanticElement(), false));
			deleteElementsCommand.add(p.getCommand(request));
		}
	}
}
