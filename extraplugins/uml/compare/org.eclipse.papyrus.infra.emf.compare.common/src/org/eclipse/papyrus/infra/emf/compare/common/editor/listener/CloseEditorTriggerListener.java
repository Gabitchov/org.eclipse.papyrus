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
package org.eclipse.papyrus.infra.emf.compare.common.editor.listener;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.compare.common.Activator;
import org.eclipse.papyrus.infra.emf.compare.common.messages.Messages;

/**
 * 
 * This class listen the close of the nested Compare Editor.
 * When it is closed,
 * - it removed it from the model (notation and di files are concerned)
 * - it remove itself from the list of listener on the editing domain
 * 
 */
public class CloseEditorTriggerListener extends TriggerListener {

	/**
	 * The listened model of the editor
	 */
	private final EObject rawModel;

	/** the service registry */
	private final ServicesRegistry registry;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param rawModel
	 *        the model for the editor to listen
	 * @param registry
	 *        the service registry
	 */
	public CloseEditorTriggerListener(final EObject rawModel, final ServicesRegistry registry) {
		this.rawModel = rawModel;
		this.registry = registry;
	}

	/**
	 * 
	 * @see org.eclipse.emf.transaction.TriggerListener#trigger(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param domain
	 * @param notification
	 * @return
	 */
	@Override
	protected Command trigger(final TransactionalEditingDomain domain, final Notification notification) {
		final Object notifier = notification.getNotifier();
		IPageMngr mngr = null;
		try {
			mngr = ServiceUtils.getInstance().getIPageMngr(registry);
		} catch (ServiceException e) {
			Activator.log.error(Messages.CloseEditorTriggerListener_ICantFoundTheIPageManager, e);
		}

		final IPageMngr mngr2 = mngr;
		if(notifier instanceof PageRef) {
			final PageRef ref = (PageRef)notifier;
			final EObject pageId = ref.getEmfPageIdentifier();
			if(pageId == rawModel) {
				final CompoundCommand command = new CompoundCommand();
				final Command sashRemoveComd = new RecordingCommand(domain) {

					@Override
					protected void doExecute() {
						mngr2.removePage(rawModel);
					}
				};
				EList<EObject> tabls = rawModel.eResource().getContents();
				command.append(sashRemoveComd);
				command.append(new RemoveCommand(domain, tabls, rawModel));
				final Command removeListener = new RecordingCommand(domain) {

					@Override
					protected void doExecute() {
						//we remove this listener from the editingdomain
						//it can't be done in the class which set it, because it would be removed too early
						domain.removeResourceSetListener(CloseEditorTriggerListener.this);
					}
				};
				command.append(removeListener);
				return command;
			}
		}
		return null;
	}
}
