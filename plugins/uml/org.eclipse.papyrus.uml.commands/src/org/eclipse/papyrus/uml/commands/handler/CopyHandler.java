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
package org.eclipse.papyrus.uml.commands.handler;

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
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.uml.commands.Activator;

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
	protected Command getCommand(ServicesRegistry registry) {
		if(registry != null) {
			final TransactionalEditingDomain editingDomain;
			try {
				editingDomain = ServiceUtils.getInstance().getTransactionalEditingDomain(registry);
			} catch (ServiceException ex) {
				Activator.log.error(ex);
				return UnexecutableCommand.INSTANCE;
			}

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
		}
		return UnexecutableCommand.INSTANCE;
	}


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
		protected PutInClipboardCommand(EditingDomain domain, Collection<Object> objectsToPutInClipboard) {
			super(domain);
			this.objectsToPutInClipboard = objectsToPutInClipboard;
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

}
