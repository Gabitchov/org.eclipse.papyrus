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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.commands;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * 
 * This command allows to remove elements from a resource
 * 
 */
public class RemoveFromResourcecommand extends RecordingCommand {

	/**
	 * the managed resource
	 */
	final private Resource resource;

	/**
	 * the element to remove from the resource
	 */
	final private EObject toRemove;

	/**
	 * the list of the elements to remove from the resource
	 */
	final private Collection<EObject> elementsToRemove;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 *        the editing domain
	 * @param resource
	 *        the resource
	 * @param toRemove
	 *        the element to remove
	 */
	public RemoveFromResourcecommand(final TransactionalEditingDomain domain, final Resource resource, final EObject toRemove) {
		this(domain, resource, toRemove, null);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 *        the editing domain
	 * @param resource
	 *        the resource
	 * @param elementsToRemove
	 *        the list of the elements to remove
	 */
	public RemoveFromResourcecommand(final TransactionalEditingDomain domain, final Resource resource, final Collection<EObject> elementsToRemove) {
		this(domain, resource, null, elementsToRemove);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 *        the editing domain
	 * @param resource
	 *        the resource
	 * @param toRemove
	 *        the element to remove
	 * @param elementsToRemove
	 *        the list of the elements to remove
	 */
	protected RemoveFromResourcecommand(final TransactionalEditingDomain domain, final Resource resource, final EObject toRemove, final Collection<EObject> elementsToRemove) {
		super(domain, "Remove an EObject from a resource");
		this.resource = resource;
		this.toRemove = toRemove;
		this.elementsToRemove = elementsToRemove;
	}

	/**
	 * 
	 * remove the element(s) of the resource
	 * 
	 */
	@Override
	protected void doExecute() {
		try {
			if(this.toRemove != null) {
				this.resource.getContents().remove(toRemove);
			}

			if(this.elementsToRemove != null) {
				this.resource.getContents().removeAll(elementsToRemove);
			}
		} catch (Exception e) {
			int i = 0;
			i++;
		}
	}


	/**
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
	 * 
	 * @return
	 */
	@Override
	public boolean canExecute() {
		boolean result = super.canExecute();
		if(toRemove == null && elementsToRemove == null) {
			return false;
		}
		return result;
	}

}
