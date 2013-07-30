/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Mario Cervera Ubeda (Integranova)
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.actions.handlers;

import java.util.Hashtable;

import org.eclipse.gmf.runtime.common.ui.services.action.global.AbstractGlobalActionHandlerProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandler;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandlerContext;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;

// TODO: Auto-generated Javadoc
/**
 * The Class ClipboardActionHandlerProvider.
 */
public class ClipboardActionHandlerProvider extends AbstractGlobalActionHandlerProvider {

	/** List for handlers. */
	private Hashtable handlerList = new Hashtable();

	/**
	 * Returns a global action handler that supports operations (cut, copy, and
	 * paste).
	 * 
	 * @param context
	 *        the context
	 * 
	 * @return the global action handler
	 */
	@Override
	public IGlobalActionHandler getGlobalActionHandler(final IGlobalActionHandlerContext context) {

		/* Create the handler */

		if(!getHandlerList().containsKey(context.getActivePart())) {

			getHandlerList().put(context.getActivePart(), getClipboardActionHandler());

			/*
			 * Register as a part listener so that the cache can be cleared when
			 * the part is disposed
			 */
			context.getActivePart().getSite().getPage().addPartListener(new IPartListener() {

				private IWorkbenchPart localPart = context.getActivePart();

				/**
				 * @see org.eclipse.ui.IPartListener#partActivated(IWorkbenchPart)
				 */
				public void partActivated(IWorkbenchPart part) {
					// Do nothing
				}

				/**
				 * @see org.eclipse.ui.IPartListener#partBroughtToTop(IWorkbenchPart)
				 */
				public void partBroughtToTop(IWorkbenchPart part) {
					// Do nothing
				}

				/**
				 * @see org.eclipse.ui.IPartListener#partClosed(IWorkbenchPart)
				 */
				public void partClosed(IWorkbenchPart part) {
					/* Remove the cache associated with the part */
					if(part != null && part == localPart && getHandlerList().containsKey(part)) {
						getHandlerList().remove(part);
						localPart.getSite().getPage().removePartListener(this);
						localPart = null;
					}
				}

				/**
				 * @see org.eclipse.ui.IPartListener#partDeactivated(IWorkbenchPart)
				 */
				public void partDeactivated(IWorkbenchPart part) {
					// Do nothing
				}

				/**
				 * @see org.eclipse.ui.IPartListener#partOpened(IWorkbenchPart)
				 */
				public void partOpened(IWorkbenchPart part) {
					// Do nothing
				}
			});
		}

		return (ClipboardActionHandler)getHandlerList().get(context.getActivePart());
	}

	/**
	 * Returns the handlerList.
	 * 
	 * @return Hashtable
	 */
	private Hashtable getHandlerList() {
		return handlerList;
	}

	protected ClipboardActionHandler getClipboardActionHandler() {
		return new ClipboardActionHandler();
	}

}
