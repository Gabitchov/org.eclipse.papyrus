/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Gregoire Dupe (Mia-Software) - initial API and implementation
 *   Nicolas Bros (Mia-Software) - Bug 339664 - org.eclipse.emf.facet.widgets.celleditors API cleaning
 *   Nicolas Bros (Mia-Software) - Bug 334539 - [celleditors] change listener
 *   Gregoire Dupe (Mia-Software) - Bug 344563 - NPE with Enum Editor
 *   Nicolas Guyomar (Mia-Software) - Bug 344563 - NPE with Enum Editor 
 *****************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal.core.composite;

import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.emf.facet.widgets.celleditors.internal.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public abstract class EnumComposite<T> extends AbstractCellEditorComposite<T> {

	/** the control that is used to edit the contents of the cell */
	private Combo combo = null;

	private final Composite parentControl;

	private T lastValue;

	public EnumComposite(final Composite parent) {
		super(parent);
		setLayout(new FillLayout());
		this.parentControl = parent;
		this.combo = new Combo(this, SWT.NONE);
		final Listener clickListener = new Listener() {
			public void handleEvent(final Event event) {
				if (event.widget instanceof Control) {
					Control control = (Control) event.widget;
					if (control.getShell() == EnumComposite.this.getParentControl().getShell()) {
						if (event.widget != EnumComposite.this.getCombo()) {
							EnumComposite.this.commit();
						}
					}
				}
			}
		};

		this.combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				fireChanged();
			}
		});
		
		this.combo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent event) {
				// Enter key pressed
				if ((event.keyCode == SWT.CR && event.stateMask == 0)
						|| (event.keyCode == SWT.KEYPAD_CR && event.stateMask == 0)) {
						commit();
				} else if (event.keyCode == SWT.ESC && event.stateMask == 0) {
					// Escape key pressed
					close();
				}
			}
		});

		Display.getDefault().addFilter(SWT.MouseDown, clickListener);
		// this listener is only here to remove
		// the other listener from the Display
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(final DisposeEvent e) {
				Display.getDefault().removeFilter(SWT.MouseDown, clickListener);
			}
		});

		this.combo.forceFocus();
	}

	protected void commit() {
		fireCommit();
	}

	public void setValue(final T value) {
		this.lastValue = value;
		if (value == null) {
			this.combo.setText(""); //$NON-NLS-1$
		} else {
			String strValue = getEnumString(value);
			this.combo.setText(strValue);
		}
	}

	public T getValue() {
		try {
			this.lastValue = this.getEnumValue(this.combo.getText());
		} catch (Exception e) {
			Logger.logError(e, Activator.getDefault());
		}
		return this.lastValue;
	}

	protected abstract T getEnumValue(String text);

	protected abstract String getEnumString(T value);

	protected abstract String[] getEnumStrings();

	public Combo getCombo() {
		return this.combo;
	}

	protected Composite getParentControl() {
		return this.parentControl;
	}

}
