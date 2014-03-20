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
package org.eclipse.papyrus.infra.core.resource;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;


/**
 * A specialized status that indicates that execution of a command was rolled back. Additional context that it provides includes model elements that
 * triggered rollback.
 */
public interface IRollbackStatus extends IStatus {

	/** A {@linkplain IStatus#getCode() status code} indicating that the reason for the rollback could not be determined or is otherwise unclassified. */
	int UNKNOWN_REASON = 0;

	/** A {@linkplain IStatus#getCode() status code} indicating that rollback occurred because of an uncaught exception in command execution. */
	int UNCAUGHT_EXCEPTION = 1;

	/** A {@linkplain IStatus#getCode() status code} indicating that rollback occurred to revert modifications to an object that is read-only. */
	int READ_ONLY_OBJECT = 2;

	/**
	 * Queries the set of objects (if known) that caused the rollback, such as because they are are {@linkplain #READ_ONLY_OBJECT read-only}.
	 * 
	 * @return the set (possibly empty, but not {@code null}) of objects that caused the rollback
	 */
	Collection<?> getCausalObjects();
}
