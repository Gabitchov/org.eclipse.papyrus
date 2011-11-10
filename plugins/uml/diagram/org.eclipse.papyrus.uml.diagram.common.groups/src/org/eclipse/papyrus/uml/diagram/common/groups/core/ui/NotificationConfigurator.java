package org.eclipse.papyrus.uml.diagram.common.groups.core.ui;



import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.ICompositeCreator;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.INotification;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.IContext;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.view.AbstractInsideComposite;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.view.PapyrusNotificationView;
import org.eclipse.papyrus.uml.diagram.common.groups.core.GroupNotificationBuilderFactory;
import org.eclipse.papyrus.uml.diagram.common.groups.core.PendingGroupNotificationsManager;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public abstract class NotificationConfigurator implements ICompositeCreator, NotificationRunnable {

	public enum Mode {
		QUESTION_MODE, WARNING_MODE
	}

	/**
	 * Instance of the {@link PendingGroupNotificationsManager} for tue current diagram
	 */
	protected PendingGroupNotificationsManager manager;

	/**
	 * {@link NotificationBuilder}
	 */
	protected NotificationBuilder notificationBuilder;

	/**
	 * {@link INotification} for choosing children
	 */
	protected INotification notification;

	/**
	 * View of the Papyrus notification view
	 */
	protected AbstractInsideComposite papyrusNotificationView;

	/**
	 * EditPart about which the notification is about
	 * (e.g Parent in case of ChooseChildrenNotificationConfigurator)
	 */
	protected IGraphicalEditPart mainEditPart;

	/**
	 * Label of the notification
	 */
	private String label;

	public NotificationConfigurator(IGraphicalEditPart _mainEdipart, PendingGroupNotificationsManager _manager, String _label, Mode mode) {
		this.mainEditPart = _mainEdipart;
		this.manager = _manager;
		this.label = _label;
		switch(mode) {
		case WARNING_MODE:
			notificationBuilder = GroupNotificationBuilderFactory.getWarningBuilder(_label);
			break;
		case QUESTION_MODE:
		default:
			notificationBuilder = GroupNotificationBuilderFactory.getQuestionBuilder(_label);
			break;
		}

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable#getLabel()
	 * 
	 * @return
	 */
	public String getLabel() {
		return label;
	}



	public void setMainEditPart(IGraphicalEditPart mainEditPart) {
		this.mainEditPart = mainEditPart;
	}

	/**
	 * Run the notification
	 * 
	 * @return
	 */
	public INotification runConfigurator() {
		notification = notificationBuilder.setComposite(this).addAction(this).run();
		if(notification != null) {
			if(manager != null) {
				manager.storeNotification(this);
			}
			try {
				IViewPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(PapyrusNotificationView.ID);
				if(part instanceof PapyrusNotificationView) {
					PapyrusNotificationView view = (PapyrusNotificationView)part;
					Collection<NotificationRunnable> singleton = new ArrayList<NotificationRunnable>(1);
					singleton.add(this);
					AbstractInsideComposite viewCompo = view.setComposite(this, getLabel(), singleton);
					papyrusNotificationView = viewCompo;
					viewCompo.setINotification(notification);


				}
			} catch (PartInitException e) {
				// do not log in notification view
			}
		}
		return notification;
	}

	/**
	 * Get the current notification
	 * 
	 * @return the notification
	 */
	public INotification getNotification() {
		return notification;
	}



	/**
	 * Close the notification
	 * 
	 * @param context
	 * 
	 */
	protected abstract void closeNotitfication(IContext context);


	/**
	 * Close the notification
	 */
	public void closeNotification() {
		closeNotitfication(null);
	}

	/**
	 * Get the {@link IGraphicalEditPart} of the Notification
	 * 
	 * @return
	 */
	public IGraphicalEditPart getMainEditPart() {
		return mainEditPart;
	}

}
