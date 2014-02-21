/**
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 *  Gregoire Dupe (Mia-Software) - Bug 373248 - Clean PMD errors
 */
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.composites;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

@SuppressWarnings("PMD.ConstructorCallsOverridableMethod")
//@SuppressWarnings("PMD.ConstructorCallsOverridableMethod") Temporary: this class must be deeply refactored.
//TODO remove the @SuppressWarnings("PMD.ConstructorCallsOverridableMethod")
//cf. bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=373248
public class BrowseComposite extends Composite {

	private Text textField;
	private Button browseButton;
	private String browseButtonText = "..."; //$NON-NLS-1$

	public BrowseComposite(final Composite parent, final int style) {
		this(parent, style, null, true);
	}

	public BrowseComposite(final Composite parent, final int style, final String buttonName, final boolean canBeChanged) {
		super(parent, SWT.NONE);
		if (buttonName != null) {
			this.browseButtonText = buttonName;
		}
		setEnabled(canBeChanged);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		final int horizontalSpacing = 4;
		layout.horizontalSpacing = horizontalSpacing;
		layout.verticalSpacing = 0;
		layout.makeColumnsEqualWidth = false;
		layout.numColumns = 2;
		setLayout(layout);
		setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		createWidgets(style);
		init();
	}

	public void addModifyListener(final ModifyListener modifyListener) {
		if (this.textField != null) {
			this.textField.addModifyListener(modifyListener);
		}
	}

	public void removeModifyListener(final ModifyListener modifyListener) {
		if (this.textField != null) {
			this.textField.removeModifyListener(modifyListener);
		}
	}

	protected void createWidgets(final int style) {
		this.textField = new Text(this, SWT.SINGLE | style);
		this.browseButton = new Button(this, SWT.PUSH);
	}

	private void init() {
		this.textField.setEditable(false);
		// We want the background white so that the user notices that there is something missing in
		// the textField, but he has to use the "..." button
		this.textField.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		this.textField.setBounds(getBounds());
		this.textField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		this.textField.addKeyListener(new KeyListener() {
			public void keyReleased(final KeyEvent e) {
				// Nothing on release
			}

			public void keyPressed(final KeyEvent event) {
				// Enter key pressed
				if ((event.keyCode == SWT.CR && event.stateMask == 0) || (event.keyCode == SWT.KEYPAD_CR && event.stateMask == 0)) {
					handleBrowse();
				}
			}
		});

		this.browseButton.setText(this.browseButtonText);
		this.browseButton.setEnabled(isEnabled());
		GridData data = new GridData(SWT.FILL, SWT.FILL, false, true);
		this.browseButton.setLayoutData(data);
		this.browseButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(final SelectionEvent e) {
				handleBrowse();
			}

			public void widgetDefaultSelected(final SelectionEvent e) {
				// Nothing
			}
		});
	}

	protected void handleBrowse() {
		// Meant to be overridden
	}

	public void updateTextFieldContent(final String content) {
		if (this.textField != null) {
			this.textField.setText(content);
			this.textField.setFocus();
		}
	}
}
