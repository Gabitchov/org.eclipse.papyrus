/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.toolbox.notification.builders;

import java.util.HashSet;

import org.eclipse.papyrus.infra.widgets.toolbox.notification.IBuilder;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.ICompositeCreator;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.INotification;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.dialogs.AsyncNotification;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.dialogs.ImagePapyrusAsyncNotificationPopup;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.dialogs.PapyrusAsyncNotificationPopup;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.utils.PapyrusControlsFactory;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.view.AbstractInsideComposite;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.view.PapyrusNotificationView;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.view.ViewNotification;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * <pre>
 * This builder creates notification both in a temporary pop-up and in Papyrus notification view. 
 * It is not supposed to be registered in extension point as its implementation can possibly interfere with existing ones
 * ({@link ViewBuilder}, {@link AsyncNotifierBuilder}).
 * 
 * It is assumed the title, message and type are set before use.
 * 
 * Usage example : new NotificationBuilder().setBuilderClass(MyBuilder.class).setType(type).setTitle(title).setMessage(message).run();
 * 
 * The expected behavior is the following : 
 * - if the notification view is not active, a popup is shown and a notification is added in the view.
 * - if the notification view is active the notification is added in the view (no popup).
 * - if the notification view is not opened, it get created but do not get the focus so that the active view does not switch automatically.
 * </pre>
 */
public class CombinedPopupAndViewBuilder implements IBuilder {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.toolbox.notification.IBuilder#build(org.eclipse.papyrus.infra.widgets.toolbox.notification.PropertyWrapper,
	 * org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	public INotification build(PropertyWrapper wrapper, FormToolkit toolkit) {

		// Find PapyrusNotificationView or create it but do not give it the focus, let the user decide when to consult these
		// informations.
		PapyrusNotificationView notificationView = (PapyrusNotificationView)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(PapyrusNotificationView.ID);
		if(notificationView == null) {
			try {
				notificationView = (PapyrusNotificationView)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(PapyrusNotificationView.ID, null, IWorkbenchPage.VIEW_CREATE);
			} catch (PartInitException e) {
				// log error - unable to create notification view
				return null;
			}
		}

		// If the Notification view is not visible show temporary notification
		if((notificationView != null) && !(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().isPartVisible(notificationView))) {
			createNotificationPopup(wrapper, toolkit);
		}

		// In any case, log the notification in the PapyrusNotificationView so that the user can consult this later.
		return createNotificationLog(notificationView, wrapper, toolkit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.toolbox.notification.IBuilder#accept(java.lang.String, java.lang.Object)
	 */
	public boolean accept(String parameterName, Object value) {
		return true;
	}

	/**
	 * This method creates the notification as a temporary popup.
	 * 
	 * @param wrapper
	 *        the notification property wrapper.
	 * @param toolkit
	 *        the form toolkit.
	 * @return the notification.
	 */
	private INotification createNotificationPopup(final PropertyWrapper wrapper, FormToolkit toolkit) {

		PapyrusAsyncNotificationPopup popup = new ImagePapyrusAsyncNotificationPopup(Display.getDefault(), toolkit, wrapper.getType());
		popup.setTitle(wrapper.getTitle());
		popup.setText(wrapper.getMessage());
		popup.addAllRunnable(wrapper.getActions() == null ? new HashSet<NotificationRunnable>() : wrapper.getActions());

		AsyncNotification notification = new AsyncNotification(popup);
		popup.setINotification(notification);

		popup.open();

		return notification;
	}

	/**
	 * This method add notifications in the notification view.
	 * 
	 * @param notificationView
	 *        the notification view.
	 * @param wrapper
	 *        the notification property wrapper.
	 * @param toolkit
	 *        the form toolkit.
	 * @return the notification.
	 */
	private INotification createNotificationLog(PapyrusNotificationView notificationView, final PropertyWrapper wrapper, final FormToolkit toolkit) {

		ICompositeCreator compositeCreator = wrapper.getComposite();
		if(compositeCreator == null) {

			compositeCreator = new ICompositeCreator() {

				public Composite createComposite(Composite parent, FormToolkit toolkit) {
					return PapyrusControlsFactory.createCompositeWithType(Display.getDefault().getActiveShell(), toolkit, parent, wrapper.getType(), wrapper.getImage(), wrapper.getMessage(), false);
				}

			};
		}

		AbstractInsideComposite compositeNotification = notificationView.setComposite(compositeCreator, wrapper.getTitle(), wrapper.getActions());
		ViewNotification notification = new ViewNotification(compositeNotification);
		compositeNotification.setINotification(notification);

		return notification;
	}
}
