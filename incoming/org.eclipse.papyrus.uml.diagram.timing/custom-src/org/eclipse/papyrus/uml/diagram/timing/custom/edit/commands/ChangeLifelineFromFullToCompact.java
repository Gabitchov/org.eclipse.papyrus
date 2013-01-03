/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.LifelineUtils.LifelineType;
import org.eclipse.papyrus.uml.diagram.timing.providers.UMLViewProvider;
import org.eclipse.uml2.uml.Lifeline;

public class ChangeLifelineFromFullToCompact extends AbstractChangeLifelineTypeCommand {

	public ChangeLifelineFromFullToCompact(final TransactionalEditingDomain domain, final IGraphicalEditPart lifelineView) {
		super(domain, lifelineView, Messages.ChangeLifelineFromFullToCompact_commandLabel);
	}

	@Override
	protected LifelineType getTargetLifelineType() {
		return LifelineType.compact;
	}

	@Override
	protected Node createTargetLifelineView(final UMLViewProvider umlViewProvider, final Lifeline lifeline, final View containerView, final int index) {
		return umlViewProvider.createLifeline_20(lifeline, containerView, index, true, this.lifelineEditPart.getDiagramPreferencesHint());
	}
}
