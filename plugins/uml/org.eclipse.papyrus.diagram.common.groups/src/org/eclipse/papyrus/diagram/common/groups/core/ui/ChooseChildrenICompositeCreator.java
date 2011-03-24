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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.core.utils.GMFtoEMFCommandWrapper;
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

/**
 * Create a IComposite creator to ask the user to choose the graphical parent of a list of possible children
 * and then run the command to change the graphical parent
 * 
 * @author arthur daussy
 * 
 */
public class ChooseChildrenICompositeCreator implements ICompositeCreator, NotificationRunnable {

	/**
	 * EditPart of the parent
	 */
	private IGraphicalEditPart parentEditPart;

	/**
	 * All possible graphical children
	 */
	private List<IGraphicalEditPart> allChildren;

	/**
	 * All children which are automatically chosen as graphical child
	 */
	private List<IGraphicalEditPart> automaticChildren;

	/**
	 * buttons for children
	 */
	private Map<Button, IGraphicalEditPart> childCheckBoxes;

	/** {@link EditPart} hosting the {@link EditPolicy} */
	private IGraphicalEditPart host;


	/**
	 * Construct a {@link ICompositeCreator} in order to asked the user to choose children among a given list
	 * Constructor.
	 * 
	 * @param parentEditPart
	 *        EditPart of the parent (This part can be the {@link CompartmentEditPart} or the main {@link EditPart} of the element
	 * @param allChildren
	 * @see {@link #allChildren}
	 * @param automaticChildren
	 * @see {@link #automaticChildren}
	 */
	public ChooseChildrenICompositeCreator(IGraphicalEditPart parentEditPart, List<IGraphicalEditPart> allChildren, List<IGraphicalEditPart> automaticChildren, IGraphicalEditPart host) {
		super();
		this.parentEditPart = parentEditPart;
		this.allChildren = allChildren;
		this.automaticChildren = automaticChildren;
		this.host = host;
		childCheckBoxes = new HashMap<Button, IGraphicalEditPart>();
	}

	/**
	 * Run the notification and create a changeGrazphicalParent for each selected element
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable#run(org.eclipse.papyrus.ui.toolbox.notification.builders.IContext)
	 * @param context
	 */
	public void run(IContext context) {
		TransactionalEditingDomain editingDomain = parentEditPart.getEditingDomain();
		for(Button checkBoxButton : childCheckBoxes.keySet()) {
			if(checkBoxButton.getSelection() && checkBoxButton.isEnabled()) {
				IGraphicalEditPart childPart = childCheckBoxes.get(checkBoxButton);
				String label = "Change graphical parent" + " of " + CreatorUtils.getLabel(childPart) + " to " + CreatorUtils.getLabel(parentEditPart);
				ChangeGraphicalParentCommand cmd = new ChangeGraphicalParentCommand(editingDomain, label, parentEditPart, childPart, host);
				if(cmd != null && cmd.canExecute()) {
					//Execute the command
					editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
				}
			}
		}
		closeNotitfication(context);
	}

	public String getLabel() {
		return Messages.ChooseChildrenICompositeCreator_ChooseChildren;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.ICompositeCreator#createComposite(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 * @param parent
	 * @param toolkit
	 * @return
	 */
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
		/*
		 * Create for each parents a checkbox
		 */
		createCheckBoxes(toolkit, top, previousElement);


		return top;
	}

	/**
	 * Create all the check boxes needed.
	 * If child is automatically assign to this parent then it appeares but it is disable
	 * If a child has already a parent:
	 * If its parent is the current EditPart then it is selected
	 * If not then it is not selected
	 * 
	 * @param toolkit
	 * @see {@link ICompositeCreator}
	 * @param top
	 * @see {@link ICompositeCreator}
	 * @param previousElement
	 *        A control element under which the check boxes bill be displayed
	 */
	private void createCheckBoxes(FormToolkit toolkit, Composite top, Control previousElement) {
		FormData data;
		for(IGraphicalEditPart child : allChildren) {
			String label = CreatorUtils.getLabel(child);
			Button checkBox = toolkit.createButton(top, label, SWT.CHECK);
			//FIXME finish the MouseTrackLMistenner
			//			checkBox.addMouseTrackListener(new CheckboxIGraphicalFocusListenner(child));
			//If the child has already parentEditPart as graphical parent the notification will not display it
			if(!child.getParent().equals(parentEditPart)) {
				if(automaticChildren.contains(child)) {
					checkBox.setSelection(true);
					checkBox.setEnabled(false);

				} else {
					checkBox.setSelection(false);
				}
				data = CreatorUtils.getFormDataUnder(previousElement);
				checkBox.setLayoutData(data);
				previousElement = checkBox;
				childCheckBoxes.put(checkBox, child);
			}
		}

	}

	/**
	 * Close the notification
	 * 
	 * @param context
	 */
	private void closeNotitfication(IContext context) {
		Object get = context.get(IContext.NOTIFICATION_OBJECT);
		if(get instanceof INotification) {
			INotification notification = (INotification)get;
			notification.delete();
		}
	}

}
