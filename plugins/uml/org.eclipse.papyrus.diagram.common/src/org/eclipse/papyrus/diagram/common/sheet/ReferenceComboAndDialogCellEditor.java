/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tatiana Fesenko (Borland) - initial API and implementation
 */
package org.eclipse.papyrus.diagram.common.sheet;

import java.text.MessageFormat;
import java.util.List;

import org.eclipse.emf.common.ui.celleditor.ExtendedComboBoxCellEditor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.diagram.common.part.UMLElementChooserDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;

public class ReferenceComboAndDialogCellEditor extends ExtendedComboBoxCellEditor {

	private Composite myEditor;

	private Control myContents;

	private Button myButton;

	private FocusListener myButtonFocusListener;

	final private UMLElementChooserDialog myElementChooserDialog;

	final private TransactionalEditingDomain myEditingDomain;

	public ReferenceComboAndDialogCellEditor(Composite parent, List<?> list, ILabelProvider labelProvider,
			boolean sorted, UMLElementChooserDialog chooserDialog, TransactionalEditingDomain editingDomain) {
		super(parent, list, labelProvider, sorted);
		myEditingDomain = editingDomain;
		myElementChooserDialog = chooserDialog;
	}

	@Override
	protected Control createControl(Composite parent) {
		Font font = parent.getFont();
		Color bg = parent.getBackground();

		myEditor = new Composite(parent, getStyle());
		myEditor.setFont(font);
		myEditor.setBackground(bg);
		myEditor.setLayout(new DialogCellLayout());

		myContents = super.createControl(myEditor);

		myButton = createOpenDialogButton(myEditor);
		setValueValid(true);
		return myEditor;
	}

	protected Object openDialogBox(Control cellEditorWindow) {
		if(myElementChooserDialog.open() == Window.OK) {
			URI uri = myElementChooserDialog.getSelectedModelElementURI();
			try {
				return myEditingDomain.getResourceSet().getEObject(uri, true);
			} catch (WrappedException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public void deactivate() {
		if(myButton != null && !myButton.isDisposed()) {
			myButton.removeFocusListener(getButtonFocusListener());
		}
		super.deactivate();
	}

	@Override
	protected void doSetFocus() {
		myButton.setFocus();
		myButton.addFocusListener(getButtonFocusListener());
	}

	private Button createOpenDialogButton(Composite parent) {
		myButton = new Button(parent, SWT.DOWN);
		myButton.setText("..."); //$NON-NLS-1$
		myButton.setFont(parent.getFont());

		myButton.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.character == '\u001b') { // Escape
					fireCancelEditor();
				}
			}
		});

		myButton.addFocusListener(getButtonFocusListener());

		myButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				// Remove the button's focus listener since it's guaranteed
				// to lose focus when the dialog opens
				myButton.removeFocusListener(getButtonFocusListener());

				Object newValue = openDialogBox(myEditor);

				// Re-add the listener once the dialog closes
				myButton.addFocusListener(getButtonFocusListener());

				if(newValue != null) {
					boolean newValidState = isCorrect(newValue);
					if(newValidState) {
						markDirty();
						doSetValue(newValue);
					} else {
						// try to insert the current value into the error
						// message.
						setErrorMessage(MessageFormat.format(getErrorMessage(), new Object[]{ newValue.toString() }));
					}
					fireApplyEditorValue();
				}
			}
		});
		return myButton;
	}

	private FocusListener getButtonFocusListener() {
		if(myButtonFocusListener == null) {
			myButtonFocusListener = new FocusListener() {

				public void focusGained(FocusEvent e) {
					// Do nothing
				}

				public void focusLost(FocusEvent e) {
					// CellEditor.this.focusLost();
				}
			};
		}

		return myButtonFocusListener;
	}

	private class DialogCellLayout extends Layout {

		@Override
		public void layout(Composite editor, boolean force) {
			Rectangle bounds = editor.getClientArea();
			Point size = myButton.computeSize(SWT.DEFAULT, SWT.DEFAULT, force);
			if(myContents != null) {
				myContents.setBounds(0, 0, bounds.width - size.x, bounds.height);
			}
			myButton.setBounds(bounds.width - size.x, 0, size.x, bounds.height);
		}

		@Override
		public Point computeSize(Composite editor, int wHint, int hHint, boolean force) {
			if(wHint != SWT.DEFAULT && hHint != SWT.DEFAULT) {
				return new Point(wHint, hHint);
			}
			Point contentsSize = myContents.computeSize(SWT.DEFAULT, SWT.DEFAULT, force);
			Point buttonSize = myButton.computeSize(SWT.DEFAULT, SWT.DEFAULT, force);
			// Just return the button width to ensure the button is not clipped
			// if the label is long.
			// The label will just use whatever extra width there is
			Point result = new Point(buttonSize.x, Math.max(contentsSize.y, buttonSize.y));
			return result;
		}
	}

}
