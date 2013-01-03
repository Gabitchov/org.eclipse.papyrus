/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.policies;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.OperationForbiddenException;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.Constants;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateInvariantUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.policies.CompactStateInvariantItemSemanticEditPolicyCN;

/** Hides related Views (OccurrenceSpecifications, etc.) when hiding a compact StateInvariant. */
public class CustomCompactStateInvariantItemSemanticEditPolicy extends CompactStateInvariantItemSemanticEditPolicyCN {

	@Override
	public Command getCommand(final Request request) {
		if (request.getType() == REQ_DELETE) {
			try {
				final View view = (View) getHost().getModel();
				final Set<View> viewsToRemove = new HashSet<View>();
				if (view.getType().equals(Constants.compactStateInvariantId)) {
					viewsToRemove.addAll(StateInvariantUtils.getViewsToHide(view));
				}
				if (viewsToRemove.size() > 0) {
					final CompoundCommand compoundCommand = new CompoundCommand(Messages.hideStateInvariant);
					compoundCommand.add(super.getCommand(request));
					for (final View viewToRemove : viewsToRemove) {
						compoundCommand.add(new ICommandProxy(new DeleteCommand(viewToRemove)));
					}
					return compoundCommand;
				}
			} catch (final OperationForbiddenException e) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		return super.getCommand(request);
	}
}
