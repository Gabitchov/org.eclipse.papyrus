/*******************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Bros (Mia-Software) - initial API and implementation
 *   Nicolas Guyomar (Mia-Software) - Bug 339554 - org.eclipse.papyrus.emf.facet.widgets.celleditors API cleaning
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.widgets.celleditors.internal;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.ICommandFactory;

/**
 * This is the command factory that is used when no other command factory is
 * specified through the "commandFactories" extension point.
 */
public class DefaultCommandFactory implements ICommandFactory {

	public boolean handles(final EditingDomain editingDomain) {
		return true;
	}

	public Command createSetCommand(final EditingDomain domain, final Object owner,
			final Object feature, final Object value) {
		return SetCommand.create(domain, owner, feature, value);
	}

	public Command createSetCommand(final EditingDomain domain, final Object owner,
			final Object feature, final Object value, final int index) {
		return SetCommand.create(domain, owner, feature, value, index);
	}

	public Command createMoveCommand(final EditingDomain domain, final Object owner,
			final Object feature, final Object value, final int index) {
		return MoveCommand.create(domain, owner, feature, value, index);
	}

	public Command createAddCommand(final EditingDomain domain, final Object owner,
			final Object feature, final Object value) {
		return AddCommand.create(domain, owner, feature, value);
	}

	public Command createRemoveCommand(final EditingDomain domain, final Object owner,
			final Object feature, final Object value) {
		return RemoveCommand.create(domain, owner, feature, value);
	}

	public Command createDeleteCommand(final EditingDomain domain, final Object object) {
		return DeleteCommand.create(domain, object);
	}
}
