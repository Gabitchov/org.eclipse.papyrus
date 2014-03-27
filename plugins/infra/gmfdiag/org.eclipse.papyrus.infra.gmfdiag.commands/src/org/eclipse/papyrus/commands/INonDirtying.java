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
package org.eclipse.papyrus.commands;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;


/**
 * A marker interface for GMF and GEF commands that are non-dirtying. For EMF {@link Command}s, use the {@link AbstractCommand.NonDirtying} interface.
 * 
 * @see AbstractCommand.NonDirtying
 */
public interface INonDirtying {
	// Just a marker interface
}
