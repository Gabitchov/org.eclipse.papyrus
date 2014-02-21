/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.util.emf.core.command;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;

/**
 * @since 0.3
 */
public final class EmfCommandUtils {

	private EmfCommandUtils() {
		// Must not be used
	}

	public static final Command createResult(final List<Command> commandList,
			final String label) {
		Command result = null;
		while (commandList.contains(null)) {
			commandList.remove(null);
		}
		if (!commandList.isEmpty()) {
			result = new CompoundCommand(label, commandList);
		}
		return result;
	}

}
