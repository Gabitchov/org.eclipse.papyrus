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
 *   Nicolas Guyomar (Mia-Software) - Bug 349574 - EMF Facet Ecore String composite textField cannot be disabled
 *****************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.ecore.composite;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public abstract class StringComposite<T> extends AbstractCellEditorComposite<T> {

	/** the control that is used to edit the contents of the cell */
	private Text textField = null;

	private final Composite parentControl;

	/** the original value of the cell **/
	private IConverter<T> converter;

	protected static final Color RED = new Color(Display.getCurrent(), 255, 192, 192);
	protected static final Color WHITE = Display.getCurrent().getSystemColor(
			SWT.COLOR_LIST_BACKGROUND);

	public StringComposite(final Composite parent, final int style) {
		super(parent);
		setLayout(new FillLayout());
		this.parentControl = parent;
		this.textField = new Text(this, style);

		this.textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent event) {
				// Enter key pressed
				if ((event.keyCode == SWT.CR && event.stateMask == 0)
						|| (event.keyCode == SWT.KEYPAD_CR && event.stateMask == 0)) {
					if (StringComposite.this.getTextField().getEditable()) {
						StringComposite.this.commit();
					}
				} else if (event.keyCode == SWT.ESC && event.stateMask == 0) {
					// Escape key pressed
					close();
				}
			}

			@Override
			public void keyReleased(final KeyEvent e) {
				if (!StringComposite.this.validate(StringComposite.this.getTextField().getText())
						.isOK()) {
					StringComposite.this.getTextField().setBackground(StringComposite.RED);
				} else {

					StringComposite.this.getTextField().setBackground(StringComposite.WHITE);
				}
				super.keyReleased(e);
			}

		});
		final Listener clickListener = new Listener() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt. widgets.Event)
			 */
			public void handleEvent(final Event event) {
				if (event.widget instanceof Control) {
					Control control = (Control) event.widget;
					if (control.getShell() == StringComposite.this.getParentControl().getShell()) {
						if (event.widget != StringComposite.this.getTextField()) {
							StringComposite.this.commit();
						}
					}
				}
			}
		};
		Display.getDefault().addFilter(SWT.MouseDown, clickListener);
		// this listener is only here to remove
		// the other listener from the Display
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(final DisposeEvent e) {
				Display.getDefault().removeFilter(SWT.MouseDown, clickListener);
			}
		});
		
		this.textField.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				fireChanged();
			}
		});

		this.textField.forceFocus();
	}

	public StringComposite(final Composite parent) {
		this(parent, SWT.NONE);
	}

	protected void commit() {
		if (getValidator().validate(getValue()).isOK()) {
			fireCommit();
		}
	}

	@Override
	public void setEnabled(final boolean enabled) {
		this.textField.setEnabled(enabled);
		super.setEnabled(enabled);
	}
	
	public boolean getEditable() {
		return this.textField.getEditable();
	}

	public void setValue(final T value) {
		if (value == null) {
			this.textField.setText(""); //$NON-NLS-1$
		} else {
			String strValue = getConverter().toString(value);
			this.textField.setText(strValue);
			this.textField.setSelection(0, strValue.length());
		}
	}

	public String getText() {
		return this.textField.getText();
	}

	protected Text getTextField() {
		return this.textField;
	}

	protected Composite getParentControl() {
		return this.parentControl;
	}

	public T getValue() {
		return this.getConverter().toObject(this.getText());
	}

	private IConverter<T> getConverter() {
		if (this.converter == null) {
			this.converter = this.initConverter();
		}
		return this.converter;
	}

	public abstract IConverter<T> initConverter();

	public interface IConverter<T> {
		public T toObject(String string);

		public String toString(T object);
	}

	public abstract IStatus validate(String string);
}
