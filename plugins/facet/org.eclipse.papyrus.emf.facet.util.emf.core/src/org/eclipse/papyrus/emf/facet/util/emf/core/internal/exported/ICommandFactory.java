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
 *   Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.emf.core.internal.exported;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Creates {@link Command}s for a specific {@link EditingDomain}.
 * <p>
 * See also {@link ICommandFactoriesRegistry}
 * 
 * @since 0.2
 */
// Copied from org.eclipse.papyrus.emf.facet.widgets.celleditors.ICommandFactory
public interface ICommandFactory {
	/**
	 * Whether this command factory should be used for the given {@link EditingDomain}
	 */
	boolean handles(EditingDomain editingDomain);

	/**
	 * This creates a {@link SetCommand} to set the owner's feature to the specified value.
	 */
	Command createSetCommand(EditingDomain domain, Object owner, Object feature, Object value);

	/**
	 * This creates a {@link SetCommand} to set the owner's feature to the specified value at the
	 * specified index.
	 */
	Command createSetCommand(EditingDomain domain, Object owner, Object feature,
			Object value, int index);

	/**
	 * This creates a {@link MoveCommand} to move a particular value to a particular index in the
	 * specified feature of the owner. The feature will often be <code>null</code> because the
	 * domain will deduce it.
	 */
	Command createMoveCommand(EditingDomain domain, Object owner, Object feature, Object value,
			int index);

	/**
	 * This creates an {@link AddCommand} to add a particular value to the specified feature of the
	 * owner. The feature will often be <code>null</code> because the domain will deduce it.
	 */
	Command createAddCommand(EditingDomain domain, Object owner, Object feature, Object value);

	/**
	 * This creates a {@link RemoveCommand} to remove a particular value from the specified feature
	 * of the owner.
	 */
	Command createRemoveCommand(EditingDomain domain, Object owner, Object feature, Object value);

	/** This creates a command that deletes the given object. */
	Command createDeleteCommand(EditingDomain domain, Object object);

}
