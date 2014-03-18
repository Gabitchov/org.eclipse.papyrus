/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.uml2.uml.NamedElement;

/**
 * A Command to apply a rename on a UML Element
 */
public class RenameElementCommand extends RecordingCommand {

	private NamedElement element;

	private String name;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param namedElement
	 *        The UML Element w
	 * @param stereotypes
	 *        The stereotypes to apply
	 */
	public RenameElementCommand(TransactionalEditingDomain domain, NamedElement namedElement, String name) {
		super(domain);
		this.element = namedElement;
		this.name = name;
	}


	@Override
	protected void doExecute() {
		element.setName(name);
	}

}
