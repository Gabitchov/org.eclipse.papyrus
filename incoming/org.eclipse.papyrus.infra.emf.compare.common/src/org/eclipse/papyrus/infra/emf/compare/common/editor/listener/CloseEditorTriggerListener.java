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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;


public class CloseEditorTriggerListener extends TriggerListener {

	private EObject rawModel;

	private ServicesRegistry registry;

	public CloseEditorTriggerListener(final EObject rawModel, final ServicesRegistry registry) {
		this.rawModel = rawModel;
		this.registry = registry;
	}

	@Override
	protected Command trigger(TransactionalEditingDomain domain, Notification notification) {
		int type = notification.getEventType();
		Object feature = notification.getFeature();
		final Object notifier = notification.getNotifier();
		IPageMngr mngr = null;
		try {
			mngr = ServiceUtils.getInstance().getIPageMngr(registry);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final IPageMngr mngr2 = mngr;
		if(notifier instanceof PageRef) {
			PageRef ref = (PageRef)notifier;
			EObject pageId = ref.getEmfPageIdentifier();
			if(pageId == rawModel) {
				CompoundCommand command = new CompoundCommand();
				Command sashRemoveComd = new RecordingCommand(domain) {

					@Override
					protected void doExecute() {
						mngr2.removePage(rawModel);
					}
				};
				EList<EObject> tabls = rawModel.eResource().getContents();
				command.append(sashRemoveComd);
				command.append(new RemoveCommand(domain, tabls, rawModel));

				//			
				//			return new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "Delete Compare Editor", null) {
				//
				//				@Override
				//				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				//
				////					mngr2.removePage(rawModel);
				////					int index = ((PageRef)notifier).getParent().getChildren().indexOf(notifier);
				////					((PageRef)notifier).getParent().removePage(index);
				//					
				//					//we remove the rawModel of its resource
				//					rawModel.eResource().getContents().remove(rawModel);
				//					return null;
				//				}
				//			});
				return command;
			}
		}
		return null;
	}

}
