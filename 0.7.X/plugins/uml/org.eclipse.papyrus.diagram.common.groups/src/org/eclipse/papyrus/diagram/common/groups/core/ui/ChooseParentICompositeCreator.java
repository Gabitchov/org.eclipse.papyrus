/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.groups.core.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.diagram.common.groups.Messages;
import org.eclipse.papyrus.diagram.common.groups.commands.ChangeGraphicalParentCommand;
import org.eclipse.papyrus.diagram.common.groups.core.ui.utils.CreatorUtils;
import org.eclipse.papyrus.ui.toolbox.notification.ICompositeCreator;
import org.eclipse.papyrus.ui.toolbox.notification.INotification;
import org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.ui.toolbox.notification.builders.IContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;


public class ChooseParentICompositeCreator implements ICompositeCreator, NotificationRunnable {

	private List<IGraphicalEditPart> parents;


	/** buttons for children */
	private List<Button> childCheckBoxes;


	private IGraphicalEditPart childPart;


	public ChooseParentICompositeCreator(List<IGraphicalEditPart> parents, IGraphicalEditPart childPartParam) {
		super();
		this.parents = parents;
		childCheckBoxes = new ArrayList<Button>(parents.size());
		childPart = childPartParam;
	}


	public Composite createComposite(Composite parent, FormToolkit toolkit) {
		if(toolkit == null) {
			toolkit = new FormToolkit(parent.getDisplay());
		}
		Composite top = toolkit.createComposite(parent, SWT.NONE);
		top.setLayout(new FormLayout());
		FormText textLabel = toolkit.createFormText(top, false);
		textLabel.setText(Messages.ChooseParentNotificationCommand_ChooseGraphicalParent, false, true);
		FormData data = new FormData();
		textLabel.setLayoutData(data);
		Control previousElement = textLabel;
		int index = 0;
		for(IGraphicalEditPart parentEditPart : parents) {
			String label = CreatorUtils.getLabel(parentEditPart);
			Button checkBox = toolkit.createButton(top, label, SWT.RADIO);
			if(childPart.getParent().equals(parentEditPart)) {
				checkBox.setSelection(true);

			} else {
				checkBox.setSelection(false);
			}
			data = CreatorUtils.getFormDataUnder(previousElement);
			checkBox.setLayoutData(data);
			previousElement = checkBox;
			childCheckBoxes.add(checkBox);
			index++;
			//FIXME add a mouse listenner when mouse is over change color the color of the edit part
		}


		return top;
	}


	public void run(IContext context) {
		//Utils.getUpdateGraphicalParentCmd();


		int index = 0;
		IGraphicalEditPart newParent = null;
		for(Button button : childCheckBoxes) {
			if(button.getSelection()) {
				newParent = parents.get(index);
			}
			index++;
		}
		//If the system has found the edit part of the new parent
		if(newParent != null) {
			//The system create a command
			ChangeGraphicalParentCommand reassignGraphicalParent = new ChangeGraphicalParentCommand(newParent.getEditingDomain(), "Change graphical parent", newParent, childPart);

			//If the command is valid the system execut it
			if(reassignGraphicalParent != null && reassignGraphicalParent.canExecute()) {
				//FIXME Execute the command
				//reassignGraphicalParent.execute(monitor, info)
			}
		}

		// Close the notification
		Object get = context.get(IContext.NOTIFICATION_OBJECT);
		if(get instanceof INotification) {
			INotification notification = (INotification)get;
			notification.delete();
		}



	}


	public String getLabel() {
		return "ok";
	}

}
