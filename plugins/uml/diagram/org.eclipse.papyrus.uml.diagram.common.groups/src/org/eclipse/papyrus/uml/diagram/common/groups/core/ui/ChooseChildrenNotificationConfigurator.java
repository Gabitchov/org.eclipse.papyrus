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
package org.eclipse.papyrus.uml.diagram.common.groups.core.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.IContext;
import org.eclipse.papyrus.uml.diagram.common.groups.Messages;
import org.eclipse.papyrus.uml.diagram.common.groups.commands.ChangeGraphicalParentCommand;
import org.eclipse.papyrus.uml.diagram.common.groups.core.PendingGroupNotificationsManager;
import org.eclipse.papyrus.uml.diagram.common.groups.core.ui.utils.CreatorUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Create a IComposite creator to ask the user to choose the graphical parent of a list of possible children
 * and then run the command to change the graphical parent
 * 
 * @author arthur daussy
 * 
 */
public class ChooseChildrenNotificationConfigurator extends NotificationConfigurator {

	/**
	 * EditPart of the parent
	 */
	private IGraphicalEditPart parentEditPart;

	/**
	 * All possible graphical children
	 */
	protected List<IGraphicalEditPart> allChildren;

	/**
	 * All children which are automatically chosen as graphical child
	 */
	protected List<IGraphicalEditPart> automaticChildren;

	/**
	 * buttons for children
	 */
	private Map<Button, IGraphicalEditPart> childCheckBoxes;

	/**
	 * {@link EditPart} hosting the {@link EditPolicy}
	 */
	protected IGraphicalEditPart host;


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
	public ChooseChildrenNotificationConfigurator(IGraphicalEditPart parentEditPart, List<IGraphicalEditPart> allChildren, List<IGraphicalEditPart> automaticChildren, IGraphicalEditPart host, PendingGroupNotificationsManager manager) {
		super(parentEditPart, manager, Messages.ChooseChildrenICompositeCreator_ChooseChildren, Mode.QUESTION_MODE);
		this.parentEditPart = parentEditPart;
		this.allChildren = allChildren;
		this.automaticChildren = automaticChildren;
		this.host = host;
		this.childCheckBoxes = new HashMap<Button, IGraphicalEditPart>();
	}

	/**
	 * Run the notification and create a changeGrazphicalParent for each selected element
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable#run(org.eclipse.papyrus.ui.toolbox.notification.builders.IContext)
	 * @param context
	 */
	public void run(IContext context) {
		TransactionalEditingDomain editingDomain = mainEditPart.getEditingDomain();
		Set<IGraphicalEditPart> childrenUpdated = new HashSet<IGraphicalEditPart>();
		for(Button checkBoxButton : childCheckBoxes.keySet()) {
			if(checkBoxButton.getSelection() && checkBoxButton.isEnabled()) {
				IGraphicalEditPart childPart = childCheckBoxes.get(checkBoxButton);
				if(!childrenUpdated.contains(childPart)) {
					changeGraphicalParentOf(editingDomain, childPart);
					childrenUpdated.add(childPart);
				}
			}
		}
		closeNotitfication(context);
	}

	/**
	 * @param editingDomain
	 * @param childPart
	 */
	private void changeGraphicalParentOf(TransactionalEditingDomain editingDomain, IGraphicalEditPart childPart) {
		String label = "Change graphical parent" + " of " + CreatorUtils.getLabel(childPart) + " to " + CreatorUtils.getLabel(mainEditPart);
		ChangeGraphicalParentCommand cmd = new ChangeGraphicalParentCommand(editingDomain, label, mainEditPart, childPart, host);
		if(cmd != null && cmd.canExecute()) {
			//Execute the command
			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		}
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
		textLabel.setText(Messages.ChooseParentNotificationCommand_ChooseGraphicalChildrenMessage + CreatorUtils.getLabel(mainEditPart) + " :", false, true);
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
		for(final IGraphicalEditPart child : allChildren) {
			String label = CreatorUtils.getLabel(child);
			Button checkBox = toolkit.createButton(top, label, SWT.CHECK);
			//FIXME finish the MouseTrackLMistenner
			//			checkBox.addMouseTrackListener(new CheckboxIGraphicalFocusListenner(child));
			//If the child has already parentEditPart as graphical parent the notification will not display it
			if(!child.getParent().equals(mainEditPart)) {
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
			// add dispose listener to remove from handled widgets
			checkBox.addDisposeListener(new DisposeListener() {

				/**
				 * Remove widget from handled ones
				 * 
				 * @param e
				 *        the dispose event
				 */
				public void widgetDisposed(DisposeEvent e) {
					childCheckBoxes.remove(e.widget);
				}
			});

			checkBox.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					Widget check = e.widget;
					if(check instanceof Button) {
						boolean selection = ((Button)check).getSelection();
						for(Button b : getAllButtonFor(child)) {
							b.setSelection(selection);
						}
					}
				}

				/**
				 * This method will return a list of all button referencing a {@link IGraphicalEditPart}
				 * 
				 * @param child
				 *        The {@link IGraphicalEditPart} of which you want to find the {@link Button}
				 * @return List of all button
				 */
				private List<Button> getAllButtonFor(IGraphicalEditPart child) {
					List<Button> result = new ArrayList<Button>();
					for(Button childButton : childCheckBoxes.keySet()) {
						IGraphicalEditPart childEdipart = childCheckBoxes.get(childButton);
						if(childEdipart.equals(child)) {
							result.add(childButton);
						}
					}
					return result;
				}
			});
		}
	}


	/**
	 * This method check if the {@link ChooseChildrenNotificationConfigurator} create with all the following parameters would be different from the
	 * current one
	 * 
	 * @param _parentEditPart
	 * @see {@link #mainEditPart}
	 * @param _allChildren
	 * @see {@link #allChildren}
	 * @param _automaticChildren
	 * @see {@link #automaticChildren}
	 * @param _host
	 * @see {@link #host}
	 * @return true the notification would be different
	 */
	public boolean isThereAnyModification(IGraphicalEditPart _parentEditPart, List<IGraphicalEditPart> _allChildren, List<IGraphicalEditPart> _automaticChildren, IGraphicalEditPart _host) {
		boolean sameParentEditPart = mainEditPart.equals(_parentEditPart);
		boolean sameHost = host.equals(_host);
		boolean sameAllChildren = containsSameElements(allChildren, _allChildren);
		boolean sameAutomaticChildren = containsSameElements(automaticChildren, _automaticChildren);
		return !(sameParentEditPart && sameHost && sameAllChildren && sameAutomaticChildren);
	}

	/**
	 * Compare two list of {@link IGraphicalEditPart} elements and return true if it contains the same elements
	 * 
	 * @param list1
	 *        List of {@link IGraphicalEditPart}
	 * @param list2
	 *        List of {@link IGraphicalEditPart}
	 * @return true is contains same elements
	 */
	private boolean containsSameElements(List<IGraphicalEditPart> list1, List<IGraphicalEditPart> list2) {
		return list1.containsAll(list2) && list2.containsAll(list1);
	}

	@Override
	protected void closeNotitfication(IContext context) {
		papyrusNotificationView.dispose();
		notification.delete();
		manager.removeChooseChildrenNotification(mainEditPart);
	}

}
