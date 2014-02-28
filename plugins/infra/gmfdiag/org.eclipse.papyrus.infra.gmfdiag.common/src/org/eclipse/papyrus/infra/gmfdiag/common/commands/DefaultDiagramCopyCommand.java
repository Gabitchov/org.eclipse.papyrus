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
package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.AbstractCommand.NonDirtying;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;

/**
 * Command that puts a list of object in the clipboard
 */
public class DefaultDiagramCopyCommand extends AbstractOverrideableCommand implements NonDirtying {

	/** list of objects to put in the clipboard */
	private final Collection<Object> objectsToPutInClipboard;

	public Collection<Object> getObjectsToPutInClipboard() {
		return objectsToPutInClipboard;
	}

	/** old list of the clipboard, for undo */
	private Collection<Object> oldClipboardContent;

	/**
	 * Creates a new Command that set the new content of the clipboard
	 * 
	 * @param domain
	 *        editing domain for which the clipboard is set.
	 */
	public DefaultDiagramCopyCommand(EditingDomain domain, PapyrusClipboard<Object> papyrusClipboard, Collection<IGraphicalEditPart> pObjectsToPutInClipboard) {
		super(domain);
		objectsToPutInClipboard = new ArrayList<Object>();
		EcoreUtil.Copier copier = new EcoreUtil.Copier();
		List<EObject> objectToCopy = new ArrayList<EObject>();
		for(IGraphicalEditPart iGraphicalEditPart : pObjectsToPutInClipboard) {
			Object object = iGraphicalEditPart.getModel();
			if(object instanceof View) {
				View view = (View)object;
				EObject element = view.getElement();
				objectToCopy.add(view);
				objectToCopy.add(element);
			}
			copier.copyAll(objectToCopy);
			copier.copyReferences();
			for(EObject eObject : objectToCopy) {
				papyrusClipboard.addInternalCopyInClipboard(eObject, copier.get(eObject));
			}
		}

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
