/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 */
package org.eclipse.papyrus.emf.facet.util.emf.core.internal.command;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.emf.facet.util.emf.core.command.ICommandFactoryResult;

public class CommandFactoryResult<T> implements ICommandFactoryResult<T> {

	private final Command cmd;
	private final T result;

	public CommandFactoryResult(final Command cmd, final T result) {
		this.cmd = cmd;
		this.result = result;
	}

	public Command getCommand() {
		return this.cmd;
	}

	public T getResult() {
		return this.result;
	}

}
