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

import org.eclipse.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class BooleanComposite extends AbstractCellEditorComposite<Boolean> {

	private Combo combo = null;
	private boolean enableSelectionListener = true;
	private Control parentControl = null;

	public BooleanComposite(final Composite parent) {
		this(parent, SWT.NONE);
	}

	public BooleanComposite(final Composite parent, final int style) {
		super(parent, style);
		this.parentControl = parent;
		GridLayout gd = new GridLayout(1, false);
		gd.marginHeight = 0;
		gd.marginWidth = 0;
		gd.horizontalSpacing = 0;
		setLayout(gd);

		this.combo = new Combo(this, SWT.READ_ONLY);
		this.combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		this.combo.setItems(new String[] { "true", "false" }); //$NON-NLS-1$ //$NON-NLS-2$
		this.combo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent event) {

				if ((event.keyCode == SWT.CR && event.stateMask == 0)) {
					// Enter key pressed
					commit();
				} else if (event.keyCode == SWT.ESC && event.stateMask == 0
						|| (event.keyCode == SWT.KEYPAD_CR && event.stateMask == 0)) {
					// Escape key pressed
					close();
				}
				BooleanComposite.this.setEnableSelectionListener(false);
			}
		});

		this.combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (BooleanComposite.this.getEnableSelectionListener()) {
					fireChanged();
					commit();
					super.widgetSelected(e);
				}
				BooleanComposite.this.setEnableSelectionListener(true);
			}
		});

		// commit the cell editor when the mouse is clicked
		// anywhere outside the text field
		final Listener clickListener = new Listener() {
			public void handleEvent(final Event event) {
				if (event.widget instanceof Control) {
					Control control = (Control) event.widget;
					if (control.getShell() == BooleanComposite.this.getParentControl().getShell()) {
						if (event.widget != BooleanComposite.this.getCombo()) {
							commit();
						}
					}
				}
			}
		};
		Display.getDefault().addFilter(SWT.MouseDown, clickListener);

		// this listener is only here to remove
		// the other listener from the Display
		getCombo().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(final DisposeEvent e) {
				Display.getDefault().removeFilter(SWT.MouseDown, clickListener);
			}
		});

		this.combo.forceFocus();
	}

	protected void commit() {
		fireCommit();
	}

	public Boolean getValue() {
		if (this.combo.getSelectionIndex() == 0) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;

	}

	public void setValue(final Boolean value) {
		if (value != null) {
			if (value.booleanValue()) {
				this.combo.select(0);
			} else {
				this.combo.select(1);
			}
		}
	}

	protected Combo getCombo() {
		return this.combo;
	}

	protected boolean getEnableSelectionListener() {
		return this.enableSelectionListener;
	}

	protected void setEnableSelectionListener(final boolean value) {
		this.enableSelectionListener = value;
	}

	protected Control getParentControl() {
		return this.parentControl;
	}

}
