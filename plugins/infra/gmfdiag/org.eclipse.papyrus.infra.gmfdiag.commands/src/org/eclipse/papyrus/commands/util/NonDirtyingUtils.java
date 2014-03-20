/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.commands.util;

import java.util.Map;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.INonDirtying;


/**
 * Utilities for working with non-dirtying EMF, GEF, and GMF commands.
 * 
 * @see INonDirtying
 * @see AbstractCommand.NonDirtying
 */
public class NonDirtyingUtils {

	/**
	 * Not instantiable by clients.
	 */
	private NonDirtyingUtils() {
		super();
	}

	public static IUndoableOperation wrap(TransactionalEditingDomain domain, Command command) {
		if(command instanceof AbstractCommand.NonDirtying) {
			return new NonDirtyingEMFCommandOperation(domain, command);
		}
		return new EMFCommandOperation(domain, command);
	}

	public static IUndoableOperation wrap(TransactionalEditingDomain domain, Command command, Map<?, ?> options) {
		if(command instanceof AbstractCommand.NonDirtying) {
			return new NonDirtyingEMFCommandOperation(domain, command, options);
		}
		return new EMFCommandOperation(domain, command, options);
	}

	public static CompoundCommand nonDirtyingEMFCompound() {
		return new NonDirtyingEMFCompoundCommand();
	}

	public static Command chain(Command command1, Command command2) {
		if((command1 instanceof AbstractCommand.NonDirtying) && (command2 instanceof AbstractCommand.NonDirtying)) {
			return new NonDirtyingEMFCompoundCommand().chain(command1).chain(command2);
		}
		return command1.chain(command2);
	}

	public static org.eclipse.gef.commands.CompoundCommand nonDirtyingGEFCompound() {
		return new NonDirtyingGEFCompoundCommand();
	}

	public static org.eclipse.gef.commands.Command chain(org.eclipse.gef.commands.Command command1, org.eclipse.gef.commands.Command command2) {
		if((command1 instanceof INonDirtying) && (command2 instanceof INonDirtying)) {
			return new NonDirtyingGEFCompoundCommand().chain(command1).chain(command2);
		}
		return command1.chain(command2);
	}

	public static CompositeCommand nonDirtyingGMFComposite(String label) {
		return new NonDirtyingGMFCompositeCommand(label);
	}

	public static ICommand compose(ICommand command1, ICommand command2) {
		if((command1 instanceof INonDirtying) && (command2 instanceof INonDirtying)) {
			return new NonDirtyingGMFCompositeCommand(command1.getLabel()).compose(command1).compose(command2);
		}
		return command1.compose(command2);
	}

	//
	// Nested types
	//

	private static class NonDirtyingEMFCommandOperation extends EMFCommandOperation implements INonDirtying {

		NonDirtyingEMFCommandOperation(TransactionalEditingDomain domain, Command command, Map<?, ?> options) {
			super(domain, checkCommand(command), options);
		}

		NonDirtyingEMFCommandOperation(TransactionalEditingDomain domain, Command command) {
			super(domain, checkCommand(command));
		}

		static Command checkCommand(Command command) {
			if(!(command instanceof AbstractCommand.NonDirtying)) {
				throw new IllegalStateException("Attempt to wrap dirtying command in a non-dirtying operation."); //$NON-NLS-1$
			}
			return command;
		}
	}

	private static class NonDirtyingEMFCompoundCommand extends CompoundCommand implements AbstractCommand.NonDirtying {

		@Override
		public void append(Command command) {
			checkNonDirtying(command);
			super.append(command);
		}

		@Override
		public boolean appendAndExecute(Command command) {
			checkNonDirtying(command);
			return super.appendAndExecute(command);
		}

		@Override
		public boolean appendIfCanExecute(Command command) {
			checkNonDirtying(command);
			return super.appendIfCanExecute(command);
		}

		@Override
		public Command chain(Command command) {
			append(command);
			return this;
		}

		private void checkNonDirtying(Command command) {
			if(!(command instanceof AbstractCommand.NonDirtying)) {
				throw new IllegalArgumentException("Attempt to append a dirtying command to a non-dirtying compound."); //$NON-NLS-1$
			}
		}
	}

	private static class NonDirtyingGEFCompoundCommand extends org.eclipse.gef.commands.CompoundCommand implements INonDirtying {

		@Override
		public void add(org.eclipse.gef.commands.Command command) {
			// GEF compounds allow appending null commands, which just has no effect
			if(command != null) {
				checkNonDirtying(command);
				super.add(command);
			}
		}

		@Override
		public org.eclipse.gef.commands.Command chain(org.eclipse.gef.commands.Command command) {
			add(command);
			return this;
		}

		private void checkNonDirtying(org.eclipse.gef.commands.Command command) {
			if(!(command instanceof INonDirtying)) {
				throw new IllegalArgumentException("Attempt to append a dirtying command to a non-dirtying compound."); //$NON-NLS-1$
			}
		}
	}

	private static class NonDirtyingGMFCompositeCommand extends CompositeCommand implements INonDirtying {

		NonDirtyingGMFCompositeCommand(String label) {
			super(label);
		}

		@Override
		public void add(IUndoableOperation operation) {
			checkNonDirtying(operation);
			super.add(operation);
		}

		private void checkNonDirtying(IUndoableOperation operation) {
			if(!(operation instanceof INonDirtying)) {
				throw new IllegalArgumentException("Attempt to append a dirtying operation to a non-dirtying composite."); //$NON-NLS-1$
			}
		}
	}
}
