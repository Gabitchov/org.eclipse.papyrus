/*******************************************************************************
 * Copyright (c) 2006 - 2007 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.views.panels;

import org.eclipse.papyrus.cpp.profile.StUtils;
import org.eclipse.papyrus.views.cpp.Activator;
import org.eclipse.papyrus.views.cpp.CommandSupport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;

import Cpp.CppVisibility;


/**
 * Panel displayed when a Generalization is selected
 */
public class CppGeneralizationPanel extends CppAbstractPanel {

	/** Combo box to display visibility */
	private Combo vPropCombo;

	/** current selected generalization */
	private Generalization selectedGeneralization;

	public CppGeneralizationPanel(Composite parent, int style) {
		super(parent, style);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#getSelectedElement()
	 */
	@Override
	public Generalization getSelectedElement() {
		return selectedGeneralization;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#setSelectedElement(org.eclipse.uml2.uml.Element)
	 */
	@Override
	public void setSelectedElement(Element newElement) {
		super.setSelectedElement(newElement);
		if(newElement instanceof Generalization) {
			this.selectedGeneralization = (Generalization)newElement;
		} else
			throw new RuntimeException("bad selection: " + newElement + " should be a UML2 generalization");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accorduml.ui.views.panels.AccordUMLAbstractPanel#createContent()
	 */
	public Control createContent()
	{
		// creates a composite

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		this.setLayout(gridLayout);

		// Contains checkboxes associated to stereotypes
		Group qualifierGroup = new Group(this, 0);
		qualifierGroup.setLayout(new RowLayout());
		qualifierGroup.setText("Generalization visibility");

		// Visibility properties combo box
		vPropCombo = new Combo(qualifierGroup, SWT.DROP_DOWN | SWT.READ_ONLY);
		String items[] = { "public", "protected", "private" };
		vPropCombo.setItems(items);
		vPropCombo.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				checkVirtual();
			}
		});

		this.pack();
		return this;
	}

	/**
	 * Called when the visibility qualifier is modified
	 */
	public void checkVirtual()
	{
		// Treat the generalization
		int comboSelected = vPropCombo.getSelectionIndex();

		final String visibilityVal;
		switch(comboSelected) {
		case 0: /* public */
			visibilityVal = "public";
			break;
		case 1: /* protected */
			visibilityVal = "protected";
			break;
		case 2: /* private */
			visibilityVal = "private";
			break;
		default: /* public */
			visibilityVal = "public";
			break;
		}
		final CppVisibility visibility = StUtils.getApplication(selectedGeneralization, CppVisibility.class);
		if(visibility != null) {
			String vis = visibility.getValue();
			if(!vis.equals(visibilityVal)) {
				CommandSupport.exec("Set visibility for generalization", new Runnable() {

					public void run() {
						visibility.setValue(visibilityVal);
					}
				});
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accorduml.ui.views.panels.AccordUMLAbstractPanel#entryAction()
	 */
	public void entryAction() {
		super.entryAction();
		reset();
	}

	// Required by super class
	public void save() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#checkModifications()
	 */
	@Override
	public boolean checkModifications() {
		// no specific stereotypes tagged value to save
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#refreshPanel()
	 */
	@Override
	protected void refreshPanel()
	{
		if(selectedGeneralization != null) {
			final CppVisibility visibility = StUtils.getApplication(selectedGeneralization, CppVisibility.class);
			if(visibility != null) {
				String vis = visibility.getValue();

				if(vis.equals("public")) {
					vPropCombo.select(0);
				} else if(vis.equals("protected")) {
					vPropCombo.select(1);
				} else if(vis.equals("private")) {
					vPropCombo.select(2);
				} else {
					Activator.log(new RuntimeException("Generalization: should never happen, model should be corrected before"));
					vPropCombo.select(0);
				}
			} else {
				Activator.log(new RuntimeException("Generalization: should never happened, model should be corrected before"));
				vPropCombo.select(0);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#isModelValid()
	 */
	@Override
	protected boolean isModelValid()
	{
		if(selectedGeneralization == null) {
			return true;
		}

		final CppVisibility visibility = StUtils.getApplication(selectedGeneralization, CppVisibility.class);
		if(visibility != null) {
			String vis = visibility.getValue();

			if(!(vis.equals("public")) || !(vis.equals("protected")) || !(vis.equals("private"))) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#updateModel()
	 */
	@Override
	protected void updateModel() {
		super.updateModel();
		if(selectedGeneralization == null) {
			return;
		}

		final CppVisibility visibility = StUtils.getApplication(selectedGeneralization, CppVisibility.class);
		if(visibility != null) {
			String vis = visibility.getValue();
			if(!(vis.equals("public")) || !(vis.equals("protected")) || !(vis.equals("private"))) {
				CommandSupport.exec("Correct illegal visibility value", new Runnable() {

					public void run() {
						visibility.setValue("public");
					}
				});
			}
		}
		else {
			// good idea? apply value, even if visibility unspecified
			// GenUtils.setStereotype (selectedGeneralization, CppVisibility.class, true);
			// GenUtils.setTaggedValue (selectedGeneralization, CppVisibility.class, "value", "public");
		}
	}
}
