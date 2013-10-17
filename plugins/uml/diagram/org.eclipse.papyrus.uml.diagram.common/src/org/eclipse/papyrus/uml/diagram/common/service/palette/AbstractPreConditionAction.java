/*****************************************************************************
 * Copyright (c) 2012 Atos
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Philippe ROLAND (Atos) philippe.roland@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.w3c.dom.Node;

/**
 * Abstract aspect action class for preconditions
 * 
 * @author proland
 */
public abstract class AbstractPreConditionAction implements IPreAction {

	/** factory used to create this action */
	protected IAspectActionProvider factory;

	/**
	 * the current services registry
	 * Available only during customization
	 * At runtime, use the ViewAdapter
	 */
	private ServicesRegistry registry;

	/**
	 * @{inheritDoc
	 */
	public void init(Node configurationNode, IAspectActionProvider factory) {
		this.factory = factory;
	}

	/**
	 * @{inheritDoc
	 */
	public Image getImage() {
		return factory.getImage();
	}

	/**
	 * @{inheritDoc
	 */
	public String getLabel() {
		return factory.getName();
	}

	/**
	 * @{inheritDoc
	 */
	public String getFactoryId() {
		return factory.getFactoryId();
	}

	public IStatus checkPostCondition() {
		//Do nothing
		return null;
	}

	public IStatus checkPreCondition() {
		//Do nothing; this is already covered by the command itself, 
		//which can return an Unexecutable command
		return null;
	}

	public ICommand getConnectionPreCommand(View sourceView, View targetView) {
		List<IStatus> preConditionStatusList = checkConnectionPreCondition(sourceView, targetView);
		return handlePreconditionFailure(preConditionStatusList);
	}

	/**
	 * Check the preCondition
	 * 
	 * @param sourceView
	 *        the future connection's source's View
	 * @param targetView
	 *        the future connection's target's View
	 * @return
	 */
	protected abstract List<IStatus> checkConnectionPreCondition(View sourceView, View targetView);

	public ICommand getNodePreCommand(View containerView) {
		List<IStatus> preConditionStatusList = checkNodePreCondition(containerView);
		return handlePreconditionFailure(preConditionStatusList);
	}

	/**
	 * Check the preCondition
	 * 
	 * @param containerView
	 *        the future node's container's View
	 * @return
	 */
	protected abstract List<IStatus> checkNodePreCondition(View containerView);

	/**
	 * If the precondition check fails, call this method. It generates an appropiate log window and offers the user to continue regardless if
	 * allowContinue() returns true
	 * 
	 * @param preConditionStatusList
	 *        the list of IStatus resulting from the precondition check
	 * @return the appropriate command; null if no problems were encountered or the user chose to continue, UnexecutableCommand otherwise.
	 */
	protected ICommand handlePreconditionFailure(List<IStatus> preConditionStatusList) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("The following precondition(s) failed with the error messages:");
		boolean failed = false;
		for(IStatus status : preConditionStatusList) {
			if(!status.isOK()) {
				stringBuilder.append("\n\r\n\r" + status.getMessage());
				failed = true;
			}
		}

		if(failed) {
			//If this precondition allows the user to continue regardless
			if(allowContinue()) {
				stringBuilder.append("\n\r\n\rDo you wish to continue?");

				//attempts to use NotificationBuilder cause the transaction to fail for reasons yet unknown (a rollback causes the view's element to be unset,
				//prompting NPEs in following postActions. See commented code below)
				MessageBox dialog = new MessageBox(Display.getCurrent().getActiveShell(), SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL);
				dialog.setText("Precondition failure");
				dialog.setMessage(stringBuilder.toString());
				int returnCode = dialog.open();
				if(returnCode == SWT.OK) {
					return null;
				}

				/** XXX This is cleaner and allows for the use of html tags for improved readability, but causes errors */
				//				NotificationBuilder builder = NotificationBuilder
				//					.createYesNo(stringBuilder.toString())
				//					.setHTML(true)
				//					.setMessage(stringBuilder.toString());
				//				INotification notification = builder.run();
				//				if(notification instanceof PopupNotification) {
				//					PopupNotification popupNotification = (PopupNotification)notification;
				//					if(popupNotification.getResult() == SWT.YES) {
				//						return null;
				//					}
				//				}
				return new UnexecutableCommand(Status.CANCEL_STATUS);
			} else {
				MessageBox dialog = new MessageBox(Display.getCurrent().getActiveShell(), SWT.ICON_ERROR | SWT.OK);
				dialog.setText("Precondition failure");
				dialog.setMessage(stringBuilder.toString());
				dialog.open();
				return new UnexecutableCommand(Status.CANCEL_STATUS);
			}
		}
		return null;
	}

	/**
	 * @return true if this preCondition should allow the user to continue even if it returns false
	 */
	protected abstract boolean allowContinue();

	public void setServicesRegistry(ServicesRegistry registry) {
		this.registry = registry;
	}

	protected ServicesRegistry getServicesRegistry() {
		if(registry == null) {
			//FIXME: #setServicesRegistry() is not always properly called.
			//Workaround: We rely on the ActiveEditor to retrieve the services registry, which is dangerous
			//The initial Palette Customization wizard knows the customization context, but it is lost way before the PostAction is created
			if(registry == null) {
				try {
					registry = ServiceUtilsForActionHandlers.getInstance().getServiceRegistry();
				} catch (ServiceException ex) {
					Activator.log.error(ex);
					return null;
				}
			}
		}

		return registry;
	}

}
