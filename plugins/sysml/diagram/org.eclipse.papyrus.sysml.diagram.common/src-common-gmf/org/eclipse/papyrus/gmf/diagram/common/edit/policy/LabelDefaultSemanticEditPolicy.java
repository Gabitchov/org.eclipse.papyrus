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
package org.eclipse.papyrus.gmf.diagram.common.edit.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * Semantic edit policy for label (affixed labels mainly), that allow correct destroy,
 * but forbid other edit actions.
 */
public class LabelDefaultSemanticEditPolicy extends DefaultSemanticEditPolicy {

	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return super.getDestroyElementCommand(req);
	}
	
	@Override
	protected Command getConfigureCommand(ConfigureRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected Command getSetCommand(SetRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected Command getMoveCommand(MoveRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}
}
