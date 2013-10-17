/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.dialogs;


import java.util.Arrays;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.qompass.designer.core.Description;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.templates.ConnectorBinding;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationRTException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.AbstractElementListSelectionDialog;
import org.eclipse.ui.dialogs.FilteredList;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Select a connector type and implementation (group)
 * TODO: show information about the used connector [usage, implem properties, ...]
 * similar help for ports?
 * 
 * @author ansgar
 * 
 */
public class ConnectorSelectionDialog extends AbstractElementListSelectionDialog {

	protected Package m_model;

	protected EList<Package> visitedPackages;

	protected Text m_description;

	protected Button fTypeOnly;

	private EList<Class> connectorList;

	private Feature m_selectedConnector;

	private Object[] fUpperElements;

	protected FilteredList fUpper;

	protected FilteredList fLower;

	private InteractionComponent initialSelection = null;

	public ConnectorSelectionDialog(Shell parent, Package model, Feature selectedConnector) {
		super(parent, new QNameLabelProvider());
		connectorList = new BasicEList<Class>();
		visitedPackages = new BasicEList<Package>();
		getAllConnectors(model, selectedConnector, connectorList);
		m_selectedConnector = selectedConnector;
		setMultipleSelection(false);
		m_model = model;
	}

	public Control createDialogArea(Composite parent) {
		Composite contents = (Composite)super.createDialogArea(parent);
		createMessageArea(contents);
		// createLabel(contents, "Connector type");
		GridData gridData = DialogUtils.createFillGridData();
		gridData.heightHint = 200;

		Group fUpperGroup = new Group(contents, SWT.NONE);
		fUpperGroup.setLayout(new GridLayout());
		fUpperGroup.setLayoutData(gridData);
		fUpperGroup.setText(" Abstract interaction components "); //$NON-NLS-1$
		createFilterText(fUpperGroup);
		fUpper = createFilteredList(fUpperGroup);

		final Group fLowerGroup = new Group(contents, SWT.NONE);
		fLowerGroup.setLayout(new GridLayout());
		fLowerGroup.setLayoutData(gridData);
		fLowerGroup.setText(" Realizations/groups of interaction components "); //$NON-NLS-1$
		// createLabel(contents, lowerLabel);
		fLower = createFilteredList(fLowerGroup);
		fFilteredList = fUpper;
		org.eclipse.papyrus.FCM.Connector fcmConnector = UMLUtil.getStereotypeApplication(m_selectedConnector, org.eclipse.papyrus.FCM.Connector.class);
		if(fcmConnector != null) {
			// getInitialElementSelections();
			initialSelection = fcmConnector.getIc();
		} else {
			initialSelection = null;
		}

		fTypeOnly = new Button(contents, SWT.CHECK);
		fTypeOnly.setText("Select type only"); //$NON-NLS-1$
		SelectionListener fTypeOnlySL = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if(fTypeOnly.getSelection()) {
					fLower.setEnabled(false);
					fLowerGroup.setEnabled(false);
					fLower.setSelection(new int[0]);
					fLower.setElements(null);
				}
				else {
					fLower.setEnabled(true);
					fLowerGroup.setEnabled(true);
					handleSelectionChanged();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		fTypeOnly.addSelectionListener(fTypeOnlySL);

		fUpper.setElements(connectorList.toArray());

		// create initial selections
		if(initialSelection instanceof InteractionComponent) {
			InteractionComponent componentComp = initialSelection;
			Class componentCompBase = componentComp.getBase_Class();
			if(!componentCompBase.isAbstract()) {
				// get first superclass that is a component type
				Class componentTypeBase = Utils.componentType(componentCompBase);
				componentComp = UMLUtil.getStereotypeApplication(componentTypeBase, InteractionComponent.class);
			} else {
				// fLower.setEnabled (false);
				// fLowerGroup.setEnabled(false);
				fTypeOnly.setSelection(true);
			}
			// update status (listener does not evaluate passed data)
			fTypeOnlySL.widgetSelected(null);

			// set initial selections
			fUpper.setSelection(new Object[]{ componentComp.getBase_Class() });
		}

		Label info = createMessageArea(contents);
		info.setText("Information about connector implementation:"); //$NON-NLS-1$
		// m_description = createMessageArea(contents);

		GridData descriptionGD = new GridData();
		descriptionGD.horizontalAlignment = GridData.FILL;
		descriptionGD.grabExcessHorizontalSpace = true;
		descriptionGD.heightHint = 80;
		descriptionGD.grabExcessVerticalSpace = true;
		descriptionGD.verticalAlignment = GridData.FILL;

		m_description = new Text(contents, SWT.NONE | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
		m_description.setLayoutData(descriptionGD);

		fLower.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				Object[] selected = fLower.getSelection();
				if((selected.length > 0) && (selected[0] instanceof NamedElement)) {
					NamedElement selectedNE = (NamedElement)selected[0];
					m_description.setText(Description.getDescription(selectedNE));
				}
				else {
					m_description.setText("");
					updateOkState();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		return contents;
	}

	@Override
	/**
	 * Update the enablement of the OK button based on whether or not there
	 * is a selection.
	 *
	 */
	protected void updateOkState() {
		if(fTypeOnly.getSelection()) {
			super.updateOkState();
		} else {
			Button okButton = getOkButton();
			if(okButton != null) {
				okButton.setEnabled(fLower.getSelection().length != 0);
			}
		}
	}


	protected Label createLabel(Composite parent, String name) {
		if(name == null) {
			return null;
		}
		Label label = new Label(parent, SWT.NONE);
		label.setText(name);
		label.setFont(parent.getFont());
		return label;
	}

	/**
	 * Creates a label if name was not <code>null</code>.
	 * 
	 * @param parent
	 *        the parent composite.
	 * @param name
	 *        the name of the label.
	 * @return returns a label if a name was given, <code>null</code> otherwise.
	 */


	/**
	 * @see SelectionStatusDialog#computeResult()
	 */
	protected void computeResult() {
		Object[] result = new Object[]{ getSelectedElement(fTypeOnly.getSelection()) };
		setResult(Arrays.asList(result));
	}

	/**
	 * @see AbstractElementListSelectionDialog#handleDefaultSelected()
	 */
	protected void handleDefaultSelected() {
		if(validateCurrentSelection() && (getSelectedElement(false) != null)) {
			buttonPressed(IDialogConstants.OK_ID);
		}
	}

	/**
	 * @see AbstractElementListSelectionDialog#handleSelectionChanged()
	 */
	protected void handleSelectionChanged() {
		handleUpperSelectionChanged();
	}

	private void handleUpperSelectionChanged() {
		int index = getSelectionIndex();
		if(index >= 0) {
			fUpperElements = getFoldedElements(index);

			if((fUpperElements == null) || fTypeOnly.getSelection()) {
				// lower list remains empty, if typeOnly is true
				fLower.setElements(new Object[]{});
			} else {
				fLower.setElements(getLowerList(fUpperElements[0]));
				if(initialSelection instanceof InteractionComponent) {
					// select existing selection in lower section
					fLower.setSelection(new Object[]{ initialSelection });
					// do not try to set it again.
					initialSelection = null;
				}
			}
		}
		validateCurrentSelection();
	}

	/**
	 * Returns the selected element from the upper or lower pane.
	 * 
	 * @return Object
	 */
	protected Object getSelectedElement(boolean upper) {
		Object[] selection;
		if(upper) {
			selection = fFilteredList.getSelection();
		} else {
			selection = fLower.getSelection();
		}
		if(selection.length > 0) {
			return selection[0];
		}
		return null;
	}

	protected Object[] getLowerList(Object selectedUpperObj) {
		EList<Class> connectorList = new UniqueEList<Class>();
		if(selectedUpperObj instanceof Class) {
			visitedPackages = new BasicEList<Package>();
			getImplGroups(m_model, (Class)selectedUpperObj, connectorList);
		}
		return connectorList.toArray();
	}

	void getAllConnectors(Package pkg, Feature selectedConnector, EList<Class> connectorList) {
		for(Element el : pkg.getMembers()) {
			if(el instanceof Package) {
				if(!visitedPackages.contains(el)) {
					visitedPackages.add((Package)el);
					getAllConnectors((Package)el, selectedConnector, connectorList);
				}
			} else if(el instanceof Class) {
				if(StereotypeUtil.isApplied(el, InteractionComponent.class) && Utils.isCompType((Class)el)) {

					if(selectedConnector == null) {
						connectorList.add((Class)el);
					} else {
						try {
							Element owner = (Class)selectedConnector.getOwner();
							if(owner instanceof Class) {
								Class composite = (Class)owner;
								Log.log(Status.INFO, Log.DIALOGS, "ConnectorSelectionDialog.getAllConnectors: try to bind connector " + //$NON-NLS-1$
									((Class)el).getQualifiedName());
								ConnectorBinding.obtainBinding(composite, selectedConnector, (Class)el, false);
								connectorList.add((Class)el);
							} else {
								connectorList.add((Class)el);
							}
						} catch (TransformationException e) {
							// transform into runtime exception
							throw new TransformationRTException(e.getMessage());
						}
					}
				}
			}
		}
	}

	void getImplGroups(Package pkg, Class selectedConnType, EList<Class> implGroupList) {
		for(Element el : pkg.getMembers()) {
			if(el instanceof Package) {
				if(!visitedPackages.contains(el)) {
					visitedPackages.add((Package)el);
					getImplGroups((Package)el, selectedConnType, implGroupList);
				}
			} else if(el instanceof Class) {
				Class class_ = (Class)el;
				if(class_.getGeneralization(selectedConnType) != null) {
					implGroupList.add((Class)el);
				}
			}
		}
	}
}
