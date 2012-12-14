/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.commands.DuplicateNamedElementCommand;

public class DiagramSemanticEditPolicy extends DefaultSemanticEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientRelationshipSourceCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientRelationshipTargetCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientRefRelationshipSourceCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientRefRelationshipTargetCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		Diagram currentDiagram = null;
		if(getHost() instanceof IGraphicalEditPart) {
			currentDiagram = ((IGraphicalEditPart)getHost()).getNotationView().getDiagram();
		}
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req, currentDiagram));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateNamedElementCommand {

		/**
		 * @generated
		 */
		private Diagram diagram;

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req, Diagram currentDiagram) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap(), currentDiagram);
			this.diagram = currentDiagram;
		}
	}
}
