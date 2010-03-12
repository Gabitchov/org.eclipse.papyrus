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
package org.eclipse.papyrus.diagram.activity.edit.dialogs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.diagram.activity.part.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.uml2.uml.Activity;

/**
 * This class provides a dialog to initialize a CallAction at its creation.
 */
public abstract class CreateCallActionDialog extends CreateInvocationActionDialog {

	private Button isSynchronousButton;

	private boolean synchronous = false;

	/**
	 * Create a new dialog to initialize a CallAction.
	 * 
	 * @param shell
	 *        parent shell
	 * @param owner
	 *        the activity that owns the action
	 */
	public CreateCallActionDialog(Shell shell, Activity owner) {
		super(shell, owner);
	}

	/**
	 * Create the IsSynchronous section.
	 * 
	 * @param pParent
	 *        the section's parent widget
	 * @param pToolkit
	 *        the form toolkit
	 */
	protected void createExtraSections(Composite pParent, FormToolkit pToolkit) {
		createIsSynchronousSection(pParent, pToolkit);
	}

	/**
	 * Refresh the enabled and disabled elements in various sections
	 * 
	 * @param isSelectionSelected
	 *        true if we choose to select an existing element, false if we choose to create an element
	 */
	protected void refreshSectionsEnable(boolean isSelectionSelected) {
		super.refreshSectionsEnable(isSelectionSelected);
		// handle synchronization constraint
		if(isSelectionSelected) {
			updateSynchronous(getSelectedInvoked());
		} else {
			updateSynchronous(null);
		}
	}

	/**
	 * Define the object that will be invoked by the action (if selection mode is chosen)
	 * 
	 * @param invokedElement
	 *        the selected element
	 */
	protected void setInvokedSelection(EObject invokedElement) {
		super.setInvokedSelection(invokedElement);
		updateSynchronous(invokedElement);
	}

	/**
	 * Create the section to ask whether the action must be synchronous.
	 * 
	 * @param pParent
	 *        the section's parent widget
	 * @param pToolkit
	 *        the form toolkit
	 */
	private void createIsSynchronousSection(Composite pParent, FormToolkit pToolkit) {
		// create the section
		String lSectionTitle = getIsSynchronousSectionTitle();
		Section lSection = pToolkit.createSection(pParent, Section.EXPANDED | Section.TITLE_BAR);
		if(lSectionTitle != null) {
			lSection.setText(lSectionTitle);
		}

		ScrolledForm lInsideScrolledForm = pToolkit.createScrolledForm(lSection);
		lInsideScrolledForm.setExpandHorizontal(true);
		lInsideScrolledForm.setExpandVertical(true);
		Composite lBody = lInsideScrolledForm.getBody();

		GridLayout lLayout = new GridLayout();
		lLayout.numColumns = 1;
		lBody.setLayout(lLayout);

		// content of the section
		isSynchronousButton = pToolkit.createButton(lBody, Messages.CreateCallActionDialog_IsSynchronous, SWT.CHECK | SWT.WRAP);
		isSynchronousButton.setSelection(true);

		lInsideScrolledForm.reflow(true);
		lSection.setClient(lInsideScrolledForm);
	}

	/**
	 * Set correctly the invoked object, by creating it if needed.
	 * Then, notifies that the ok button of this dialog has been pressed.
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 * 
	 */
	@Override
	protected void okPressed() {
		// register synchronous
		synchronous = isSynchronousButton.getSelection();
		super.okPressed();
	}

	/**
	 * Get whether the CallAction must be synchronous.
	 * 
	 * @return the invoked object to use.
	 */
	public boolean getIsSynchronous() {
		return synchronous;
	}

	/**
	 * Test is the invoked object has parameters which will generate output pins
	 * 
	 * @param invokedObject
	 *        the object whose parameters must be inspected
	 * @return true if there are parameters which will be mapped with output pins
	 */
	abstract protected boolean hasOutParameters(EObject invokedObject);

	/**
	 * 
	 * @param selectedInvoked
	 *        the invoked object selected
	 */
	private void updateSynchronous(EObject selectedInvoked) {
		if(hasOutParameters(selectedInvoked)) {
			isSynchronousButton.setSelection(true);
			isSynchronousButton.setEnabled(false);
		} else {
			isSynchronousButton.setEnabled(true);
		}
	}

	/**
	 * Get the title of the is synchronous section
	 * 
	 * @return section title
	 */
	protected String getIsSynchronousSectionTitle() {
		return Messages.CreateCallActionDialog_IsSynchronousTitle;
	}

}
