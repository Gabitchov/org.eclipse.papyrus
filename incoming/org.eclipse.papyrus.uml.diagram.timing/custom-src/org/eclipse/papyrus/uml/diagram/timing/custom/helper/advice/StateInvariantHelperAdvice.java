/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.helper.advice;

import java.util.Collection;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.OperationForbiddenException;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.LifelineUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateInvariantUtils;
import org.eclipse.uml2.uml.StateInvariant;

/**
 * This HelperAdvice completes {@link StateInvariant} edit commands with commands specific to the timing diagram in
 * order to keep the model and diagram consistent when deleting a {@link StateInvariant}.
 */
public class StateInvariantHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterDestroyDependentsCommand(final DestroyDependentsRequest request) {
		final EObject destructee = request.getElementToDestroy();
		if(destructee instanceof StateInvariant) {
			try {
				final StateInvariant stateInvariant = (StateInvariant)destructee;
				final Collection<EObject> elementsToDestroy = StateInvariantUtils.getElementsToDelete(stateInvariant);
				if(!elementsToDestroy.isEmpty()) {
					final CompositeCommand compositeCommand = new CompositeCommand(Messages.StateInvariantHelperAdvice_DestroyStateInvariant);

					for(final EObject eObject : elementsToDestroy) {
						final DestroyElementRequest destroyElementRequest = new DestroyElementRequest(eObject, false);
						compositeCommand.add(new DestroyElementCommand(destroyElementRequest));
					}
					final IUndoableOperation updateFragmentNamesCommand = LifelineUtils.getUpdateFragmentNamesCommand(stateInvariant);
					if(updateFragmentNamesCommand != null) {
						compositeCommand.add(updateFragmentNamesCommand);
					}
					return compositeCommand;
				}
			} catch (final OperationForbiddenException e) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		return null;
	}
}
