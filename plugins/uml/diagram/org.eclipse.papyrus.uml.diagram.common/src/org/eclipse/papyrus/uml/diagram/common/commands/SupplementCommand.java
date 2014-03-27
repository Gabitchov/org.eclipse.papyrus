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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * This class is used to supplement a gmf connection command.
 * 
 * @author Patrick Tessier
 */
public abstract class SupplementCommand {

	private EObject container;

	private final EObject source;

	private final EObject target;

	protected final Diagram diagram;
	
	/**
	 * the supplement command has the same parameter as connection create
	 * command of gmf command
	 * 
	 * @param container
	 *        the container of the link
	 * @param source
	 *        the source of the link
	 * 
	 * @param target
	 *        the target of the link
	 */
	public SupplementCommand(EObject container, EObject source, EObject target, Diagram diagram) {
		super();
		this.container = container;
		this.source = source;
		this.target = target;
		this.diagram = diagram;
	}

	/**
	 * this is the same fucntionnality as {@link IUndoableOperation}
	 * 
	 * @return true if the command ca be executed
	 */
	// @unused
	public abstract boolean canExecute();

	/**
	 * Creates the request to configure the new element.
	 * 
	 * @see EditElementCommand
	 * @return the request
	 */
	// @unused
	protected abstract ConfigureRequest createConfigureRequest(ConfigureRequest request);

	/**
	 * this is the method tat realize the execution of the command
	 * 
	 * @param newElement
	 *        the new element ro configure
	 * @return the new element
	 */
	public abstract EObject doDefaultElementCreation(TransactionalEditingDomain domain, EObject newElement);

	/**
	 * use to obtain the container of the link
	 * 
	 * @return the container of the link
	 */
	public EObject getContainer() {
		return container;
	}

	/**
	 * use to obtain the source of the link
	 * 
	 * @return the source of the link
	 */
	public EObject getSource() {
		return source;
	}

	/**
	 * use to obtain the target of the link
	 * 
	 * @return the target of the link
	 */
	public EObject getTarget() {
		return target;
	}

	/**
	 * use to set the container of the link
	 */
	// @unused
	public void setContainer(EObject container) {
		this.container = container;
	}
}
