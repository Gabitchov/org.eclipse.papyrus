/*****************************************************************************
 * Copyright (c) 2008, 2009 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.tabbedproperties.appearance;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractNotationPropertiesSection;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.PreferencesUtil;

/**
 * Section for properties view, for label management. More precisely, these labels are manage with
 * masks, to say if, for exammple, the name must be displayed or not.
 */
public class MaskManagedLabelSection extends AbstractNotationPropertiesSection {

	/** current edit policy of the edited object */
	protected IMaskManagedLabelEditPolicy editPolicy;

	/** current edit part */
	protected IGraphicalEditPart editPart;

	/** table that displays the possible masks */
	protected Table table;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initializeControls(Composite parent) {
		super.initializeControls(parent);
		GridLayout layout = new GridLayout(2, false);
		Group gradientGroup = getWidgetFactory().createGroup(composite, "Label Customization");
		gradientGroup.setLayout(layout);

		Composite maskPolicyCompo = getWidgetFactory().createComposite(gradientGroup, SWT.NONE);
		maskPolicyCompo.setLayout(new GridLayout(2, false));
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		maskPolicyCompo.setLayoutData(gd);

		// create viewer composite
		table = getWidgetFactory().createTable(maskPolicyCompo, SWT.CHECK);
		gd = new GridData(SWT.FILL, SWT.CENTER, true, true);
		table.setData(gd);
		table.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				// check this is a check event
				if(e.detail != SWT.CHECK) {
					return;
				}

				Object source = e.getSource();
				Widget item = e.item;
				if(source instanceof Table && item instanceof TableItem) { // instanceof check also
					// that table and item
					// are not null
					int maskValue = (Integer)((TableItem)item).getData();
					applyMask(maskValue, ((TableItem)item).getChecked());
				}
				refresh();
			}

		});
		TableColumn column = new TableColumn(table, SWT.CENTER);
		column.setWidth(120);

		// composite for buttons
		Composite buttonComposite = getWidgetFactory().createComposite(maskPolicyCompo, SWT.NONE);
		buttonComposite.setLayout(new GridLayout(1, false));
		gd = new GridData(SWT.FILL, SWT.FILL, false, true);
		buttonComposite.setLayoutData(gd);

		// create the "Set Default" button
		Button setDefaultButton = getWidgetFactory().createButton(buttonComposite, "Set Default", SWT.NONE);
		setDefaultButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		setDefaultButton.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				// when selected, it removes the eannotation linked to the view
				editPolicy.setDefaultDisplayValue();
				refresh();
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// does nothing
			}
		});

		// create the "View Preference" button
		Button viewPrefButton = getWidgetFactory().createButton(buttonComposite, "View Preferences", SWT.NONE);
		viewPrefButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		viewPrefButton.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				// when selected, open preference page
				PreferenceDialog dialog = PreferencesUtil.createPreferenceDialogOn(getPart().getSite().getShell(),
						editPolicy.getPreferencePageID(), null, null);
				dialog.open();
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// does nothing
			}
		});
	}

	/**
	 * Applies the mask to the edited element label
	 * 
	 * @param maskValue
	 *        the value of the mask
	 * @param checked
	 *        {@link Boolean} set to <code>true</code> if the mask must be applied
	 */
	protected void applyMask(int maskValue, boolean checked) {
		// computes the new value to set to the annotation (retrieve old value)
		int newValue = getMaskManagedLabelEditPolicy(editPart).getCurrentDisplayValue();
		// if checked, must add the mask to old one
		if(checked) {
			newValue = newValue | maskValue; // add the mask to the display value
		} else {
			newValue = newValue & ~maskValue; // remove the mask to the display value
		}
		editPolicy.updateDisplayValue(newValue);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refresh() {
		super.refresh();
		refreshTable();
	}

	/**
	 * Refresh the components and enable/disable them according to the isGradientUsed attribute
	 */
	protected void refreshTable() {
		// retrieve the current display masks => either display annotation or preference if no
		// annotation
		int displayValue = editPolicy.getCurrentDisplayValue();
		// refreshes the different buttons
		for(TableItem item : table.getItems()) {
			int maskValue = (Integer)item.getData();
			item.setChecked((displayValue & maskValue) == maskValue);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		executeAsReadAction(new Runnable() {

			public void run() {
				editPart = getSingleInput();
				if(editPart != null) {
					// get the correct policy
					editPolicy = getMaskManagedLabelEditPolicy(editPart);
					if(editPolicy == null) {
						Activator.getDefault().getLog().log(
								new Status(IStatus.WARNING, Activator.PLUGIN_ID,
								"Trying to display the mask managed Section with an element that does not have the correct edit policy: "
								+ editPart));
					} else {
						// dispose previous table items if necessary and create new ones
						manageTableItems();
					}
				}

			}

		});
	}

	/**
	 * manages the table items
	 */
	protected void manageTableItems() {
		// unload previous items
		for(TableItem item : table.getItems()) {
			item.dispose();
		}

		// create new items
		createItems();
	}

	/**
	 * create the table items for the given edit policy
	 */
	protected void createItems() {
		Map<Integer, String> masks = editPolicy.getMasks();
		for(int maskValue : masks.keySet()) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText("" + masks.get(maskValue)); // returns a default string: ""
			item.setData(maskValue);
		}
	}

	/**
	 * Retrieves the edit policy that manages the mask for the specified edit part
	 * 
	 * @param ep
	 *        the edit part currently selected for which we are displaying the section
	 */
	private IMaskManagedLabelEditPolicy getMaskManagedLabelEditPolicy(IGraphicalEditPart ep) {
		return (IMaskManagedLabelEditPolicy)ep
				.getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
	}
}
