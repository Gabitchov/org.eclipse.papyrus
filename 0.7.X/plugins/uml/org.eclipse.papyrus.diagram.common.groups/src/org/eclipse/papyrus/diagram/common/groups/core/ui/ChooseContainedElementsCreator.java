/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.diagram.common.groups.Messages;
import org.eclipse.papyrus.diagram.common.groups.core.PendingGroupNotificationsManager;
import org.eclipse.papyrus.diagram.common.groups.core.ui.utils.CreatorUtils;
import org.eclipse.papyrus.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * This class creates composite for choosing which elements are contained by the group among a list of possible children
 * 
 * @author vhemery
 */
public class ChooseContainedElementsCreator extends CompositeCreatorWithCommand {

	/**
	 * The child selection class provides the different states of selection which are possible for a child choice
	 */
	public static enum ChildSelection {
		/** This state indicate the element is selected */
		SELECTED,
		/** This state indicate the element is not selected */
		NOT_SELECTED,
		/** This state indicate the element is selected and that it can not be deselected */
		ALWAYS_SELECTED
	}

	/** the group for which children are chosen */
	private IGraphicalEditPart parentGroup;

	/** the list to choose among and their selection */
	private Map<IGraphicalEditPart, ChildSelection> listOfElements;

	/** button to check all elements at the same time */
	private Button allCheckBox;

	/** buttons for children */
	private List<Button> childCheckBoxes;

	/**
	 * Construct a new composite creator.
	 * 
	 * @param group
	 *        the group to choose children for
	 * @param elementsList
	 *        the list of elements to choose among and their initial selection
	 */
	public ChooseContainedElementsCreator(IGraphicalEditPart group, Map<IGraphicalEditPart, ChildSelection> elementsList) {
		parentGroup = group;
		listOfElements = new HashMap<IGraphicalEditPart, ChildSelection>(elementsList);
		// initialize commands for pre-selected children
		for(Entry<IGraphicalEditPart, ChildSelection> elementSelection : listOfElements.entrySet()) {
			final IGraphicalEditPart child = elementSelection.getKey();
			switch(elementSelection.getValue()) {
			case SELECTED:
				Command cmd = Utils.getUpdateGraphicalParentCmd(child, parentGroup);
				addResultingCommandForObject(child, cmd);
				break;
			case ALWAYS_SELECTED:
				cmd = Utils.getUpdateGraphicalParentCmd(child, parentGroup);
				addResultingCommandForObject(child, cmd);
				break;
			case NOT_SELECTED:
				break;
			}
		}
	}

	/**
	 * Know whether there is a user choice to make
	 * 
	 * @return true if need opening
	 */
	public boolean needToOpen() {
		Set<ChildSelection> set = new HashSet<ChildSelection>(listOfElements.values());
		set.remove(ChildSelection.ALWAYS_SELECTED);
		return !set.isEmpty();
	}

	/**
	 * 
	 * Create the composite to choose an element in the parent using the toolkit
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.ICompositeCreator#createComposite(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.forms.widgets.FormToolkit)
	 * @param parent
	 *        parent composite
	 * @param toolkit
	 *        toolkit to use to create widgets
	 * @return composite to choose an element
	 */
	public Composite createComposite(Composite parent, FormToolkit toolkit) {
		if(toolkit == null) {
			toolkit = new FormToolkit(parent.getDisplay());
		}
		Composite top = toolkit.createComposite(parent, SWT.NONE);
		top.setLayout(new FormLayout());

		FormText textLabel = toolkit.createFormText(top, false);
		String message = NLS.bind(Messages.ChooseContainedElementsCreator_Message, CreatorUtils.getLabel(parentGroup));
		textLabel.setText(message, false, true);
		FormData data = CreatorUtils.getTopFormData();
		textLabel.setLayoutData(data);

		allCheckBox = toolkit.createButton(top, Messages.ChooseContainedElementsCreator_CheckAll, SWT.CHECK);
		allCheckBox.setSelection(false);
		data = CreatorUtils.getFormDataRightAlignedUnder(textLabel);
		allCheckBox.setLayoutData(data);
		allCheckBox.addSelectionListener(new SelectionAdapter() {

			/**
			 * Check all buttons
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * @param e
			 *        selection event
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(allCheckBox.getSelection()) {
					for(Button check : childCheckBoxes) {
						if(check != null && check.isEnabled()) {
							check.setSelection(true);
						}
					}
				} else {
					for(Button check : childCheckBoxes) {
						if(check != null && check.isEnabled()) {
							check.setSelection(false);
						}
					}
				}
			}
		});
		Button previousCheckBox = allCheckBox;
		childCheckBoxes = new ArrayList<Button>(listOfElements.size());
		int i = 0;
		for(Entry<IGraphicalEditPart, ChildSelection> elementSelection : listOfElements.entrySet()) {
			final int index = i;
			if(ChildSelection.ALWAYS_SELECTED.equals(elementSelection.getValue())) {
				// we can skip this one instead of making a disabled checkbox
				childCheckBoxes.add(index, null);
				continue;
			}
			final IGraphicalEditPart child = elementSelection.getKey();
			String label = CreatorUtils.getLabel(child);
			Button checkBox = toolkit.createButton(top, label, SWT.CHECK);
			childCheckBoxes.add(index, checkBox);
			switch(elementSelection.getValue()) {
			case SELECTED:
				checkBox.setSelection(true);
				break;
			case ALWAYS_SELECTED:
				checkBox.setSelection(true);
				checkBox.setEnabled(false);
				break;
			case NOT_SELECTED:
				checkBox.setSelection(false);
				break;
			}
			data = CreatorUtils.getFormDataUnder(previousCheckBox);
			checkBox.setLayoutData(data);
			previousCheckBox = checkBox;
			checkBox.addSelectionListener(new SelectionAdapter() {

				/**
				 * Update the command to choose the child
				 * 
				 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
				 * @param e
				 *        selection event
				 */
				@Override
				public void widgetSelected(SelectionEvent e) {
					if(childCheckBoxes.get(index).getSelection()) {
						Command cmd = Utils.getUpdateGraphicalParentCmd(child, parentGroup);
						addResultingCommandForObject(child, cmd);
					} else {
						addResultingCommandForObject(child, null);
					}
				}
			});
			i++;
		}
		return top;
	}

	/**
	 * Get label to choose containing group
	 * 
	 * @see org.eclipse.papyrus.diagram.common.groups.core.ui.CompositeCreatorWithCommand#getRunLabel()
	 * @return string label
	 */
	@Override
	protected String getRunLabel() {
		return Messages.ChooseContainedElementsCreator_Run;
	}

	/**
	 * Remove the notification in {@link PendingGroupNotificationsManager}
	 * 
	 * @see org.eclipse.papyrus.diagram.common.groups.core.ui.CompositeCreatorWithCommand#removeNotification()
	 */
	@Override
	protected void removeNotification() {
		DiagramEditPart diagram = DiagramEditPartsUtil.getDiagramEditPart(parentGroup);
		PendingGroupNotificationsManager manager = PendingGroupNotificationsManager.getInstanceForDiagram(diagram);
		if(manager != null) {
			manager.removeChooseChildrenNotification(parentGroup);
		}
	}

	/**
	 * Get the group for which children are chosen
	 * 
	 * @return group edit part
	 */
	public IGraphicalEditPart getGroup() {
		return parentGroup;
	}
}
