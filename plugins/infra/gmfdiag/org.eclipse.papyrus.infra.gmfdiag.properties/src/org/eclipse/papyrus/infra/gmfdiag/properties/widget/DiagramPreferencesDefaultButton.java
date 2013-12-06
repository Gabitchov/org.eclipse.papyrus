/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.properties.widget;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.WorkspaceViewerProperties;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramEditPartsUtil;
import org.eclipse.papyrus.infra.gmfdiag.properties.messages.Messages;
import org.eclipse.papyrus.views.properties.modelelement.DataSource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * 
 * The button used to reset the preference of the diagram to the defaut values
 * 
 */
@SuppressWarnings("restriction")
public class DiagramPreferencesDefaultButton extends Composite {

	private Button button;

	private SelectionListener listener;

	protected DataSource input;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param style
	 */
	public DiagramPreferencesDefaultButton(Composite parent, int style) {
		super(parent, style);
		GridLayout layout = new GridLayout(1, false);
		setLayout(layout);
		createButton();
	}

	/**
	 * create the reset button
	 */
	protected void createButton() {
		button = new Button(this, SWT.NONE);
		button.setText(Messages.DiagramPreferencesDefaultButton_ResetDefault);
		this.listener = createListener();
		button.addSelectionListener(this.listener);
	}

	/**
	 * Sets the input DataSource for this Property editor.
	 * 
	 * @param input
	 */
	public void setInput(DataSource input) {
		this.input = input;
	}

	/**
	 * @return the input DataSource for this Property editor
	 */
	public DataSource getInput() {
		return input;
	}


	/**
	 * 
	 * @return
	 *         the listener to use for the button
	 */
	private SelectionListener createListener() {
		final SelectionListener listener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				resetProperties();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				//nothing to do
			}
		};
		return listener;
	}

	/**
	 * 
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		super.dispose();
		this.button.removeSelectionListener(this.listener);
		this.input = null;
	}

	/**
	 * Reset the properties to their default values
	 */
	protected void resetProperties() {
		final IPreferenceStore store = getPreferencesStore();
		if(store != null) {
			store.setToDefault(WorkspaceViewerProperties.VIEWGRID);
			store.setToDefault(WorkspaceViewerProperties.VIEWRULERS);
			store.setToDefault(WorkspaceViewerProperties.GRIDORDER);
			store.setToDefault(WorkspaceViewerProperties.GRIDLINECOLOR);
			store.setToDefault(WorkspaceViewerProperties.GRIDLINESTYLE);
			store.setToDefault(WorkspaceViewerProperties.GRIDSPACING);
			store.setToDefault(WorkspaceViewerProperties.SNAPTOGRID);
			store.setToDefault(WorkspaceViewerProperties.SNAPTOGEOMETRY);
			store.setToDefault(WorkspaceViewerProperties.RULERUNIT);
		}
	}


	/**
	 * 
	 * @return
	 *         the preference store
	 */
	protected IPreferenceStore getPreferencesStore() {
		final IStructuredSelection selection = this.input.getSelection();
		final Object firstElement = selection.getFirstElement();
		if(firstElement instanceof EditPart) {
			return DiagramEditPartsUtil.getDiagramWorkspacePreferenceStore((EditPart)firstElement);
		}
		return null;
	}

}
