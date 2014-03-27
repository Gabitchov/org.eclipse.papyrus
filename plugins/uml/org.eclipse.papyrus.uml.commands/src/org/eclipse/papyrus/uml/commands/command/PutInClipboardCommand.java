/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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

package org.eclipse.papyrus.uml.commands.command;

import java.util.Collection;

import org.eclipse.emf.common.command.AbstractCommand.NonDirtying;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Command that puts a list of object in the clipboard, and that do not copy them.
 */
public class PutInClipboardCommand extends AbstractOverrideableCommand implements NonDirtying {

	/** list of objects to put in the clipboard */
	private final Collection<Object> objectsToPutInClipboard;

	/** old list of the clipboard, for undo */
	private Collection<Object> oldClipboardContent;

	/**
	 * Creates a new Command that set the new content of the clipboard
	 * 
	 * @param domain
	 *        editing domain for which the clipboard is set.
	 */
	public PutInClipboardCommand(EditingDomain domain, Collection<Object> pObjectsToPutInClipboard) {
		super(domain);
		objectsToPutInClipboard = EcoreUtil.copyAll(pObjectsToPutInClipboard);
	}

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExecute() {
		oldClipboardContent = domain.getClipboard();
		domain.setClipboard(objectsToPutInClipboard);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doUndo() {
		domain.setClipboard(oldClipboardContent);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRedo() {
		domain.setClipboard(objectsToPutInClipboard);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean prepare() {
		return domain != null;
	}	
	
}

