/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * A command that should be customized. This command allows to pass parameters use during execution of the command.
 * 
 * @author dumoulin
 * 
 */
public abstract class CustomizableSetValueCommand<T> extends RecordingCommand {

	protected T element;

	protected String newValue;

	/**
	 * @param domain
	 */
	public CustomizableSetValueCommand(TransactionalEditingDomain domain, T element, String newValue) {
		super(domain);
		this.element = element;
		this.newValue = newValue;
	}

	/**
	 * @param domain
	 * @param label
	 */
	public CustomizableSetValueCommand(TransactionalEditingDomain domain, T element, String newValue, String label) {
		super(domain, label);
		this.element = element;
		this.newValue = newValue;
	}

}
