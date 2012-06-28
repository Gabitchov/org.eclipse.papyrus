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
package org.eclipse.papyrus.infra.emf.compare.diff.internal.command;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * 
 * This command allows to copy the XMI_ID from one EObject to another one, only if they are not owned by the same resource
 * 
 */
//TODO should be moved in infra.emf plugin when the problem of the saùme resource will be corrected in Papyrus
public class CopyXMIIDCommand extends AbstractCommand {

	/**
	 * the EObject which provides the XMI_ID
	 */
	private final EObject source;

	/**
	 * the EObject which receive the XMI_ID
	 */
	private final EObject target;

	/**
	 * the initial XMI_ID of the target
	 */
	private String initialID;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        the EObject which provides the XMI_ID
	 * @param target
	 *        the EObject which receive the XMI_ID
	 */
	public CopyXMIIDCommand(final EObject source, final EObject target) {
		this.source = source;
		this.target = target;
		this.initialID = null;
		setLabel("Copy XMI_ID command"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.emf.common.command.Command#execute()
	 * 
	 */
	public void execute() {
		final Resource sourceResource = source.eResource();
		final Resource targetResource = target.eResource();
		if(sourceResource instanceof XMIResource && targetResource instanceof XMIResource) {
			if(sourceResource != targetResource) {//see bug 377189: [Nested UML Compare] the merged elements have the same XMI ID
				final String xmi_id = EMFHelper.getXMIID(this.source);
				this.initialID = EMFHelper.getXMIID(target);
				((XMIResource)this.target.eResource()).setID(this.target, xmi_id);
			}
		}
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
	 * @return
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
		final Resource targetResource = target.eResource();
		if(targetResource instanceof XMIResource) {
			((XMIResource)this.target.eResource()).setID(this.target, this.initialID);
		}
	}

}
