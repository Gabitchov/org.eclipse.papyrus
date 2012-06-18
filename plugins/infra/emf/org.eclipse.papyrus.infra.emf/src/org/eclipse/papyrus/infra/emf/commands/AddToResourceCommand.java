/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.commands;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * 
 * This command allows to add an EObject to a resource
 * 
 */
public class AddToResourceCommand extends AbstractCommand {

	/**
	 * the resource
	 */
	private final Resource resource;

	/**
	 * the object to add to the resource
	 */
	private final EObject toAdd;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param resource
	 *        the resource
	 * @param toAdd
	 *        the objectto add to the resource
	 */
	public AddToResourceCommand(final Resource resource, final EObject toAdd) {
		this.resource = resource;
		this.toAdd = toAdd;
		setLabel("Add an object to a resource");
	}

	/**
	 * 
	 * @see org.eclipse.emf.common.command.Command#execute()
	 * 
	 */
	public void execute() {
		this.resource.getContents().add(this.toAdd);
	}

	/**
	 * 
	 * @see org.eclipse.emf.common.command.Command#redo()
	 * 
	 */
	public void redo() {
		execute();
	}

	/**
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
	 * 
	 */
	@Override
	protected boolean prepare() {
		return true;
	}


	/**
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#undo()
	 * 
	 */
	@Override
	public void undo() {
		this.resource.getContents().remove(this.toAdd);
	}

	/**
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
	 * 
	 */
	@Override
	public boolean canExecute() {
		return super.canExecute() && this.resource != null;
	}
}
