/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.commands;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.interactionoverview.provider.CustomViewProvider;
import org.eclipse.papyrus.uml.diagram.interactionoverview.utils.CallBehaviorUtil.CallBehaviorActionType;
import org.eclipse.uml2.uml.CallBehaviorAction;

public class ChangeInteractionUseToInteraction extends
		AbstractChangeInteractionTypeCommand {

	public ChangeInteractionUseToInteraction(final TransactionalEditingDomain domain, final IGraphicalEditPart callBehaviorActionView) {
		super(domain, callBehaviorActionView,"ChangeInteractionUseToInteraction");
	}
	
	@Override
	protected CallBehaviorActionType getTargetCallBehaviorType() {
		return CallBehaviorActionType.snapshot;
	}

	@Override
	protected Node createTargetCallBehaviorView(
			CallBehaviorAction callBehaviorAction, View containerView, int index) {
		CustomViewProvider viewProvider = new CustomViewProvider();
		return viewProvider.createCallBehaviorAction_5000(callBehaviorAction, containerView, index, true, this.callBehaviorActionEditPart.getDiagramPreferencesHint());
	}

}
