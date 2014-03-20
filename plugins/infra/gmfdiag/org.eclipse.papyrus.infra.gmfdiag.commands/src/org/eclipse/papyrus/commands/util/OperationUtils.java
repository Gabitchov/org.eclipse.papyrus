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

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;


/**
 * Utilities for working with undoable operations.
 */
public class OperationUtils {

	/**
	 * Not instantiable by clients.
	 */
	private OperationUtils() {
		super();
	}

	public static boolean anyDirtying(IUndoableOperation[] undoHistory) {
		boolean result = false;

		if((undoHistory != null) && (undoHistory.length > 0)) {
			for(int i = 0; i < undoHistory.length; i++) {
				if(!isNonDirtying(undoHistory[i])) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	/**
	 * Queries whether an operation is non-dirtying. The only known non-dirtying operations, currently, are those that wrap a
	 * {@link AbstractCommand.NonDirtying}.
	 * 
	 * @param operation
	 *        an undoable operation
	 * 
	 * @return whether it is a non-dirtying operation
	 */
	public static boolean isNonDirtying(IUndoableOperation operation) {
		Command command = unwrap(operation);
		return command instanceof AbstractCommand.NonDirtying;
	}

	/**
	 * Obtains the singular EMF {@link Command} that is wrapped by an {@code operation}, if it is a command wrapper of some kind.
	 * 
	 * @param operation
	 *        an operation
	 * 
	 * @return the {@link Command} that it wraps, or {@code null} if it does not wrap a singular EMF command
	 */
	public static Command unwrap(IUndoableOperation operation) {
		Command result = null;

		if(operation instanceof EMFCommandOperation) {
			result = ((EMFCommandOperation)operation).getCommand();
		} else if(operation instanceof EMFtoGMFCommandWrapper) {
			result = ((EMFtoGMFCommandWrapper)operation).getEMFCommand();
		}

		return result;
	}

	public static boolean anyDirtyingAfter(IUndoableOperation[] undoHistory, IUndoableOperation savepoint) {
		boolean result = false;

		if(savepoint == null) {
			result = anyDirtying(undoHistory);
		} else if((undoHistory != null) && (undoHistory.length > 0)) {
			int i = 0;

			for(i = 0; i < undoHistory.length; i++) {
				if(undoHistory[i] == savepoint) {
					i++; // Advance over the save point to start testing
					break;
				}
			}

			for(; i < undoHistory.length; i++) {
				if(!isNonDirtying(undoHistory[i])) {
					result = true;
					break;
				}
			}
		}

		return result;
	}
}
