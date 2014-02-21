/**
 *  Copyright (c) 2011 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Gregoire Dupe (Mia-Software) - Bug 345730 - Deleting an element in the model breaks the table
 */
package org.eclipse.emf.facet.util.emf.core.command;

/**
 * This interface is used to force an EMF command to not be "undo-able"
 * @since 0.1.1
 */
public interface ILockableUndoCommand {

	/**
	 * @param enableUndo false to lock the command in an not "undo-able" mode
	 */
	public void enableCanUndo(boolean enableUndo);
}
