/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/

package org.eclipse.papyrus.diagram.common.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.diagram.common.ids.UMLDiagramEditorIDs;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

// TODO: Auto-generated Javadoc
/**
 * Allows the selection of a kind of UML diagram.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class SelectEditorToOpenDialog extends Dialog {

	/** The selected editor id. */
	private String selectedEditorID = null;

	/** The combo. */
	private CCombo combo = null;

	/** The model i ds. */
	private List<String> modelIDs = UMLDiagramEditorIDs.getAllModelIDs();

	/**
	 * Instantiates a new select editor to open dialog.
	 * 
	 * @param shell
	 *            the shell
	 */
	public SelectEditorToOpenDialog(Shell shell) {
		super(shell);
		shell.setText("Select Diagram To Open"); // TODO externalizae string
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		/**
		 * combobox with all model IDs
		 */

		parent.setLayout(new GridLayout(2, false));

		Label label = new Label(parent, SWT.LEAD);
		label.setText("Select model"); // TODO : externalize string
		label.setLayoutData(new GridData(SWT.LEAD, SWT.CENTER, false, false));

		combo = new CCombo(parent, SWT.BORDER | SWT.LEAD);

		for (String modelID : modelIDs) {
			combo.add(modelID);
		}

		if (modelIDs.size() > 0) {
			combo.select(0);
			selectedEditorID = modelIDs.get(0);
		}

		combo.setLayoutData(new GridData(SWT.LEAD, SWT.CENTER, true, false));

		combo.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				comboSelected();
			}
		});

		return parent;
	}

	/**
	 * Combo selected.
	 */
	private void comboSelected() {
		selectedEditorID = combo.getText();
		Button button = getButton(IDialogConstants.OK_ID);
		if (button == null) {
			return;
		}
		if (modelIDs.contains(selectedEditorID)) {
			button.setEnabled(true);
		} else {
			button.setEnabled(false);
		}
	}

	/**
	 * Gets the selected editor id.
	 * 
	 * @return the selected editor id
	 */
	public String getSelectedEditorID() {
		return selectedEditorID;
	}
}
