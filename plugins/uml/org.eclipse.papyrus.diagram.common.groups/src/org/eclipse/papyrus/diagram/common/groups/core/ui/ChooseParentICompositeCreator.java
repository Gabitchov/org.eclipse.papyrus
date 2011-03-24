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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.core.utils.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.groups.Messages;
import org.eclipse.papyrus.diagram.common.groups.commands.ChangeGraphicalParentCommand;
import org.eclipse.papyrus.diagram.common.groups.commands.ChangeModelParentCommand;
import org.eclipse.papyrus.diagram.common.groups.commands.ChooseParentNotificationCommand;
import org.eclipse.papyrus.diagram.common.groups.core.ui.utils.CreatorUtils;
import org.eclipse.papyrus.diagram.common.groups.core.utils.Utils;
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
 * ICompositor used to choose parent among a list. This IComposite handle graphical and model parent.
 * 
 * @author adaussy
 * 
 */
public class ChooseParentICompositeCreator implements ICompositeCreator, NotificationRunnable {

	/**
	 * List of availables parents
	 */
	private List<IGraphicalEditPart> parents;

	/**
	 * the mode to use this command with
	 */
	private boolean mode;

	/**
	 * buttons for children
	 */
	private List<Button> childCheckBoxes;

	/**
	 * Edit part of the children
	 */
	private IGraphicalEditPart childPart;

	/**
	 * {@link EditPart} hosting the {@link EditPolicy}
	 */
	private IGraphicalEditPart host;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parents
	 *        all available parents (model of graphical {@link #mode}
	 * @param _childPart
	 *        IGraphicalEditPart of the child (the child has to be already created)
	 * @param mode
	 *        Choose between graphical and model
	 *        Model : Change the model parent and the graphical parent
	 *        Graphical : Change only the graphical parent
	 */
	public ChooseParentICompositeCreator(List<IGraphicalEditPart> parents, IGraphicalEditPart _childPart, Boolean mode, IGraphicalEditPart getHost) {
		super();
		this.parents = parents;
		childCheckBoxes = new ArrayList<Button>(parents.size());
		childPart = _childPart;
		this.mode = mode;
		this.host = getHost;
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
	 * Create for each parent a check box and select the default one
	 * 
	 * @param toolkit
	 * @param top
	 * @param previousElement
	 */
	private void createCheckBoxes(FormToolkit toolkit, Composite top, Control previousElement) {
		FormData data;

		for(IGraphicalEditPart parentEditPart : parents) {
			String label = CreatorUtils.getLabel(parentEditPart);
			Button checkBox = toolkit.createButton(top, label, SWT.RADIO);
			//FIXME finish the MouseTrackLMistenner
			checkBox.addMouseTrackListener(new CheckboxIGraphicalFocusListenner(parentEditPart));
			if(childPart.getParent().equals(parentEditPart)) {
				checkBox.setSelection(true);

			} else {
				checkBox.setSelection(false);
			}
			data = CreatorUtils.getFormDataUnder(previousElement);
			checkBox.setLayoutData(data);
			previousElement = checkBox;
			childCheckBoxes.add(checkBox);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable#run(org.eclipse.papyrus.ui.toolbox.notification.builders.IContext)
	 * 
	 * @param context
	 */
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
			TransactionalEditingDomain editingDomain = newParent.getEditingDomain();
			/*
			 * Change the model parent if needed
			 */
			changeModelParent(newParent, editingDomain);
			/*
			 * Change the graphical parent
			 */
			changeGraphicalParent(newParent, editingDomain);
		}

		/*
		 * Close the notification
		 */
		closeNotitfication(context);
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

	/**
	 * Change the graphical parent
	 * 
	 * @param newParent
	 *        the new graphical parent of the child
	 * @param editingDomain
	 *        to create an transactionnal command
	 */
	private void changeGraphicalParent(IGraphicalEditPart newParent, TransactionalEditingDomain editingDomain) {
		String label = "Change graphical parent" + " of " + CreatorUtils.getLabel(childPart) + " to " + CreatorUtils.getLabel(newParent);
		ChangeGraphicalParentCommand reassignParent = new ChangeGraphicalParentCommand(editingDomain, label, newParent, childPart, host);
		//If the command is valid the system execute it
		if(reassignParent != null && reassignParent.canExecute()) {
			//Execute the command
			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(reassignParent));
		}
	}

	/**
	 * Change the model parent if the current mode is model
	 * 
	 * @param newParent
	 *        New model parent of the child
	 * @param editingDomain
	 *        to create the transactional command
	 */
	private void changeModelParent(IGraphicalEditPart newParent, TransactionalEditingDomain editingDomain) {
		if(mode == ChooseParentNotificationCommand.MODEL_MODE) {
			EObject childObject = childPart.resolveSemanticElement();
			EObject parentObject = newParent.resolveSemanticElement();
			EReference ref = Utils.getContainmentEReference(parentObject.eClass(), childObject.eClass());
			if(ref != null) {
				Map<EObject, EReference> chilrendToMove = new HashMap<EObject, EReference>();
				chilrendToMove.put(childObject, ref);
				ChangeModelParentCommand reassignModelparent = new ChangeModelParentCommand(editingDomain, newParent, chilrendToMove, newParent);
				//If the command is valid the system execute it
				if(reassignModelparent != null && reassignModelparent.canExecute()) {
					//Execute the command
					editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(reassignModelparent));
				}
			}
		}
	}


	public String getLabel() {
		return "ok";
	}

}
