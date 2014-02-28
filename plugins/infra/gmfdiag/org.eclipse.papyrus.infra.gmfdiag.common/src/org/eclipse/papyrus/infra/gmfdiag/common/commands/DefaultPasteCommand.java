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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;


/**
 * this handler has in charge to exexute the paste of UML element with their applied stereotypes
 * 
 */
public class DefaultPasteCommand extends AbstractCommand {

	protected EObject targetOwner;

	protected CompositeCommand command;


	/**
	 * get the command do the paste on the target owner
	 * 
	 * @param domain
	 *        the editing owner
	 * @param targetOwner
	 *        the element where the paste will be done
	 */
	public DefaultPasteCommand(EditingDomain domain, EObject targetOwner, PapyrusClipboard papyrusClipboard) {
		super();
		this.targetOwner = targetOwner;
		if(papyrusClipboard.size() > 0) {
			//Filter only EObject
			List<EObject> eobjectsTopaste = new ArrayList<EObject>();
			Iterator<Object> iterData = papyrusClipboard.iterator();
			while(iterData.hasNext()) {
				Object object = iterData.next();
				if(object instanceof EObject) {
					eobjectsTopaste.add((EObject)object);
				}
			}

			//Copy all eObjects (inspired from PasteFromClipboardCommand)
			EcoreUtil.Copier copier = new EcoreUtil.Copier();
			copier.copyAll(eobjectsTopaste);
			copier.copyReferences();
			Map<EObject, EObject> duplicatedObjects = new HashMap<EObject, EObject>();
			duplicatedObjects.putAll(copier);


			// Inform the clipboard of the elment created (used by strategies)		
			papyrusClipboard.addAllInternalToTargetCopy(duplicatedObjects);

			//Prepare the move command to move UML element to their new owner
			//Nota: move only the "root" semantic elements to be paste
			List<EObject> objectsToMove = new ArrayList<EObject>();
			Iterator<EObject> it = eobjectsTopaste.iterator();
			while(it.hasNext()) {
				EObject eObject = it.next();
				EObject copyObject = duplicatedObjects.get(eObject);
				if(copyObject != null) {
					objectsToMove.add(copyObject);
				}
			}

			MoveRequest moveRequest = new MoveRequest(targetOwner, objectsToMove);
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetOwner);
			if(provider != null) {
				command = new CompositeCommand("Paste All Object"); //$NON-NLS-1$
				ICommand editCommand = provider.getEditCommand(moveRequest);
				command.compose(editCommand);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void execute() {
		if(command != null) {
			try {
				command.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Activator.log.error(e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		if(command == null) {
			return false;
		}
		return command.canExecute();
	}

	/**
	 * {@inheritDoc}
	 */
	public void redo() {
		if(command != null) {
			try {
				command.redo(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Activator.log.error(e);
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		try {
			IProgressMonitor monitor = new NullProgressMonitor();
			command.undo(monitor, null);
		} catch (ExecutionException e) {
			Activator.log.error(e);
		}
	}

}
