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
package org.eclipse.papyrus.uml.menu.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.AbstractCommand.NonDirtying;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * Handler for the Copy Action
 * 
 * 
 * 
 */
public class CopyHandler extends AbstractEMFCommandHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.AbstractEMFCommandHandler.handler.AbstractCommandHandler#getCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getCommand() {
		final TransactionalEditingDomain editingDomain = getEditingDomain();
		List<EObject> selection = getSelectedElements();
		if(editingDomain != null && !selection.isEmpty()) {
			final Collection<Object> stereotypedSelection = new ArrayList<Object>();
			stereotypedSelection.addAll(getSelectedElements());
			//			Iterator<EObject> selecIterator = selection.iterator();
			//			while(selecIterator.hasNext()) {
			//				EObject eObject = (EObject)selecIterator.next();
			//
			//				if(eObject instanceof Element) {
			//					stereotypedSelection.addAll(((Element)eObject).getStereotypeApplications());
			//				}
			//				//copy stereotype contained into
			//				Iterator<EObject> iter = eObject.eAllContents();
			//				while(iter.hasNext()) {
			//					EObject subeObject = (EObject)iter.next();
			//					if(subeObject instanceof Element) {
			//						stereotypedSelection.addAll(((Element)subeObject).getStereotypeApplications());
			//					}
			//
			//				}
			//
			//			}

			return new PutInClipboardCommand(editingDomain, stereotypedSelection);
			//return CopyToClipboardCommand.create(getEditingDomain(), stereotypedSelection);
		}
		return UnexecutableCommand.INSTANCE;
	}


	/**
	 * Command that puts a list of object in the clipboard, and that do not copy them.
	 */
	public class PutInClipboardCommand extends AbstractOverrideableCommand implements NonDirtying {

		/** list of objects to put in the clipboard */
		private Collection<Object> objectsToPutInClipboard;

		/** old list of the clipboard, for undo */
		private Collection<Object> oldClipboardContent;

		/**
		 * Creates a new Command that set the new content of the clipboard
		 * 
		 * @param domain
		 *        editing domain for which the clipboard is set.
		 */
		protected PutInClipboardCommand(EditingDomain domain, Collection<Object> objectsToPutInClipboard) {
			super(domain);
			this.objectsToPutInClipboard = objectsToPutInClipboard;
		}

		/**
		 * {@inheritDoc}
		 */
		public void doExecute() {
			oldClipboardContent = domain.getClipboard();
			domain.setClipboard(objectsToPutInClipboard);
		}

		/**
		 * {@inheritDoc}
		 */
		public void doUndo() {
			domain.setClipboard(oldClipboardContent);
		}

		/**
		 * {@inheritDoc}
		 */
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

}
