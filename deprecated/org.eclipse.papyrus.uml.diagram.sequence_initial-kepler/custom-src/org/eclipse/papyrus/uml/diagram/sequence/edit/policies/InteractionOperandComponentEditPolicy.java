/*****************************************************************************
 * Copyright (c) 2009 CEA
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.papyrus.uml.diagram.sequence.util.OperandBoundsComputeHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceDeleteHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InteractionOperand;

public class InteractionOperandComponentEditPolicy extends ComponentEditPolicy {
	/**
	 * Delete Combined fragment and child from the view. Also delete message if user wants. {@inheritDoc}
	 */
	@Override
	protected Command createDeleteViewCommand(GroupRequest deleteRequest) {

		if(getEditingDomain() != null) {
			CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
			cmd.setTransactionNestingEnabled(false);
			cmd.add(new CommandProxy(super.createDeleteViewCommand(deleteRequest)));

			if(getEObject() instanceof InteractionOperand) {
				// Get the elements associated with the CF
				List<Element> elements = SequenceUtil.getInteractionOperandAssociatedElement((InteractionOperand)getEObject());
				// Create the delete view commands
				SequenceDeleteHelper.deleteView(cmd, elements, getEditingDomain());
			}
			
			OperandBoundsComputeHelper.addUpdateBoundsCommandForOperandDelelete(this.getHost(),cmd);
			
			return new ICommandProxy(cmd.reduce());
		}

		return null;
	}

	/**
	 * Copy from superclass as visibility is private
	 * 
	 * @return the editing domain
	 */
	private TransactionalEditingDomain getEditingDomain() {
		if(getHost() instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart)getHost()).getEditingDomain();
		} else if(getHost() instanceof IEditingDomainProvider) {
			Object domain = ((IEditingDomainProvider)getHost()).getEditingDomain();
			if(domain instanceof TransactionalEditingDomain) {
				return (TransactionalEditingDomain)domain;
			}
		}
		return null;
	}

	/**
	 * Get the EObject of the host
	 * 
	 * @return the EObject or null
	 */
	private EObject getEObject() {
		if(getHost() instanceof GraphicalEditPart) {
			return ((GraphicalEditPart)getHost()).resolveSemanticElement();
		}
		return null;
	}
}
