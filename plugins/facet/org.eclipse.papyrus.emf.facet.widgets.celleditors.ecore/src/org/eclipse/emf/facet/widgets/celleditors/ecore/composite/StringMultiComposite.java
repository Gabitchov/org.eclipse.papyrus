/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Guyomar (Mia-Software) - initial API and implementation
 *   Nicolas Guyomar (Mia-Software) - Bug 334546 - [celleditors] no border on Text field
 *   Nicolas Bros (Mia-Software) - Bug 334539 - [celleditors] change listener
 *****************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.ecore.composite;

import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.emf.facet.widgets.celleditors.ecore.Activator;
import org.eclipse.emf.facet.widgets.celleditors.ecore.ui.MultiLineDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/** A cell editor for Strings */
public class StringMultiComposite<T> extends AbstractCellEditorComposite<String> {

	/** the control that is used to edit the contents of the cell */
	private final Button button;
	private Text text = null;

	private final Composite parentControl;

	/** the original value of the cell */
	private String originalFieldValue;

	public StringMultiComposite(final Composite parent, final Object originalValue, final int style) {
		super(parent);
		this.parentControl = parent;

		GridLayout gd = new GridLayout(2, false);
		gd.marginHeight = 0;
		gd.marginWidth = 0;
		gd.horizontalSpacing = 0;
		setLayout(gd);

		this.text = new Text(this, style);
		this.text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		this.button = new Button(this, SWT.PUSH);
		this.button.setText("..."); //$NON-NLS-1$
		GridData data = new GridData(SWT.FILL, SWT.FILL, false, true);
		this.button.setLayoutData(data);

		if (originalValue != null) {
			if (originalValue instanceof String) {
				this.setValue((String) originalValue);
				this.text.setSelection(0, ((String) originalValue).length());
			} else {
				Logger.logError("An instance of String was expected", Activator.getDefault()); //$NON-NLS-1$
			}
		}

		this.button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				MultiLineDialog dialog = new MultiLineDialog(StringMultiComposite.this
						.getParentControl().getShell(), StringMultiComposite.this.getValue()) {

					@Override
					protected void okPressed() {
						StringMultiComposite.this.originalFieldValue = getTextArea().getText();
						StringMultiComposite.this.getText().setText(getTextArea().getText());
						StringMultiComposite.this.commit();
						super.okPressed();
					}
				};
				dialog.open();
			}
		});

		// commit the cell editor when the mouse is clicked
		// anywhere outside the text field
		final Listener clickListener = new Listener() {
			public void handleEvent(final Event event) {
				if (event.widget instanceof Control) {
					Control control = (Control) event.widget;
					if (control.getShell() == StringMultiComposite.this.getParentControl()
							.getShell()) {
						if (event.widget != StringMultiComposite.this.getButton()) {
							if (event.widget != StringMultiComposite.this.getText()) {
								if (StringMultiComposite.this.getText().getEditable()) {
									StringMultiComposite.this.commit();
								} else {
									StringMultiComposite.this.close();
								}
							}
						}
					}
				}
			}
		};
		Display.getDefault().addFilter(SWT.MouseDown, clickListener);

		// this listener is only here to remove
		// the other listener from the Display
		this.text.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(final DisposeEvent e) {
				Display.getDefault().removeFilter(SWT.MouseDown, clickListener);
			}
		});

		this.text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent event) {
				// Enter key pressed
				if ((event.keyCode == SWT.CR && event.stateMask == 0)
						|| (event.keyCode == SWT.KEYPAD_CR && event.stateMask == 0)) {
					if (StringMultiComposite.this.getText().getEditable()) {
						StringMultiComposite.this.commit();
					}
				} else if (event.keyCode == SWT.ESC && event.stateMask == 0) {
					// Escape key pressed
					close();
				}
			}
		});
		
		this.text.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				fireChanged();
			}
		});

		this.text.forceFocus();
	}

	public StringMultiComposite(final Composite parent, final int style) {
		this(parent, null, style);
	}

	public StringMultiComposite(final Composite parent, final Object originalValue) {
		this(parent, originalValue, SWT.NONE);
	}

	protected void commit() {
		fireCommit();
	}

	public void setValue(final String value) {
		this.originalFieldValue = value;
		if (value == null) {
			this.text.setText(""); //$NON-NLS-1$
		} else {
			// If the text contains a newline then edition is not possible, the user
			// has to use the Dialog Editor
			if (value.indexOf('\n') != -1) {
				String truncatedValue = value.substring(0, value.indexOf('\n') - 1).concat("..."); //$NON-NLS-1$
				this.text.setText(truncatedValue);
				this.text.setEditable(false);
			} else {
				this.text.setText(value);
				this.text.setSelection(0, value.length());
			}
		}
	}

	public String getValue() {
		if (this.text.getEditable()) {
			return this.text.getText();
		}
		return getOriginalFieldValue();
	}

	public Button getButton() {
		return this.button;
	}

	public Composite getParentControl() {
		return this.parentControl;
	}

	public String getOriginalFieldValue() {
		return this.originalFieldValue;
	}

	protected Text getText() {
		return this.text;
	}
}
