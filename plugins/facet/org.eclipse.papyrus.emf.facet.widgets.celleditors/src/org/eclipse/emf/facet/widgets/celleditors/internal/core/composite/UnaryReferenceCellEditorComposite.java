/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas Bros (Mia-Software) - initial API and implementation
 *   Nicolas Guyomar (Mia-Software) - initial API and implementation
 *   Nicolas Bros (Mia-Software) - Bug 339664 - org.eclipse.emf.facet.widgets.celleditors API cleaning
 *   Nicolas Bros (Mia-Software) - Bug 334539 - [celleditors] change listener
 *   Grégoire Dupé (Mia-Software) - Bug 424122 - [Table] Images, fonts and colors are not shared between the instances of table
 *****************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal.core.composite;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.util.swt.fontprovider.IFontProvider;
import org.eclipse.emf.facet.util.swt.fontprovider.IFontProviderFactory;
import org.eclipse.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.emf.facet.widgets.celleditors.internal.Messages;
import org.eclipse.emf.facet.widgets.internal.CustomizableLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ComboContentAdapter;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.SimpleContentProposalProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/** A cell editor for unary references */
public class UnaryReferenceCellEditorComposite extends AbstractCellEditorComposite<EObject> {

	private static final int GRID_DATA_HEIGHT = 50;
	private final Button button;
	private final Combo combo;
	private final Control parentControl;
	private final Map<String, EObject> fElements = new TreeMap<String, EObject>();

	/**
	 * @param parent
	 *            the parent composite
	 * @param eObjects
	 *            the possible choices
	 */
	public UnaryReferenceCellEditorComposite(final Composite parent, final List<EObject> eObjects) {
		super(parent);
		this.parentControl = parent;

		CustomizableLabelProvider customizableLabelProvider = new CustomizableLabelProvider();
		for (EObject eObject : eObjects) {
			String label = customizableLabelProvider.getText(eObject);
			// find a unique label
			if (this.fElements.get(label) != null) {
				int suffix = 2;
				while (this.fElements.get(label + " (" + suffix + ")") != null) { //$NON-NLS-1$ //$NON-NLS-2$
					suffix++;
				}
				this.fElements.put(label + " (" + suffix + ")", eObject); //$NON-NLS-1$//$NON-NLS-2$
			} else {
				this.fElements.put(label, eObject);
			}
		}

		GridLayout compositeLayout = new GridLayout(2, false);
		compositeLayout.marginHeight = 0;
		compositeLayout.marginWidth = 0;
		compositeLayout.horizontalSpacing = 0;
		setLayout(compositeLayout);

		this.combo = new Combo(this, SWT.DROP_DOWN);
		// reduce the font so that the Combo fits in the cell
		FontData[] fontData = Display.getDefault().getSystemFont().getFontData();
		fontData[0].setHeight(fontData[0].getHeight() - 2);
		final IFontProvider fontProvider = IFontProviderFactory.DEFAULT
				.getOrCreateIFontProvider(Display.getDefault());
		final Font font = fontProvider.getFont(fontData[0]);
		this.combo.setFont(font);
		for (String label : this.fElements.keySet()) {
			this.combo.add(label);
		}
		GridData comboGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		this.combo.setLayoutData(comboGridData);
		addCompletionHandler(this.combo, this.fElements.keySet());

		this.combo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent event) {
				// Enter key pressed
				if ((event.keyCode == SWT.CR && event.stateMask == 0)
						|| (event.keyCode == SWT.KEYPAD_CR && event.stateMask == 0)) {
					if (isValid()) {
						commit();
					} else {
						MessageDialog.openWarning(parent.getShell(),
								Messages.UnaryReferenceCellEditorComposite_0,
								Messages.UnaryReferenceCellEditorComposite_1);
					}
				} else if (event.keyCode == SWT.ESC && event.stateMask == 0) {
					// Escape key pressed
					close();
				}
			}
		});

		this.button = new Button(this, SWT.PUSH);
		this.button.setText("..."); //$NON-NLS-1$
		GridData buttonGridData = new GridData(SWT.FILL, SWT.FILL, false, true);
		buttonGridData.heightHint = UnaryReferenceCellEditorComposite.GRID_DATA_HEIGHT;
		this.button.setLayoutData(buttonGridData);
		this.button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				ElementListSelectionDialog dialog = new ElementListSelectionDialog(
						UnaryReferenceCellEditorComposite.this.getParentControl().getShell(),
						new CustomizableLabelProvider()) {
					@Override
					protected void okPressed() {
						Object[] selectedElements = getSelectedElements();
						String selectedElementLabel = null;
						if (selectedElements.length > 0) {
							Set<Entry<String, EObject>> entrySet = UnaryReferenceCellEditorComposite.this
									.getfElements().entrySet();
							for (Entry<String, EObject> entry : entrySet) {
								if (entry.getValue() == selectedElements[0]) {
									selectedElementLabel = entry.getKey();
									break;
								}
							}
						}
						UnaryReferenceCellEditorComposite.this.getCombo().setText(
								selectedElementLabel);
						commit();
						super.okPressed();
					}
				};
				dialog.setTitle(Messages.UnaryReferenceCellEditorComposite_2);
				dialog.setElements(eObjects.toArray());
				dialog.open();
			}
		});

		// commit the cell editor when the mouse is clicked
		// anywhere outside the text field
		final Listener clickListener = new Listener() {
			public void handleEvent(final Event event) {
				if (event.widget instanceof Control) {
					Control control = (Control) event.widget;
					if (control.getShell() == UnaryReferenceCellEditorComposite.this
							.getParentControl().getShell()
							&& event.widget != UnaryReferenceCellEditorComposite.this.getButton()
							&& event.widget != UnaryReferenceCellEditorComposite.this.getCombo()) {
						if (isValid()) {
							commit();
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
		
		this.combo.addModifyListener(new ModifyListener() {
			public void modifyText(final ModifyEvent e) {
				fireChanged();
			}
		});

		this.combo.forceFocus();
	}

	protected boolean isValid() {
		return this.fElements.get(this.combo.getText()) != null;
	}

	private static void addCompletionHandler(final Combo comboBox, final Collection<String> completions) {
		String[] completionsArray = completions.toArray(new String[completions.size()]);
		SimpleContentProposalProvider contentProposalProvider = new SimpleContentProposalProvider(
				completionsArray);
		contentProposalProvider.setFiltering(true);
		ContentProposalAdapter adapter = new ContentProposalAdapter(comboBox,
				new ComboContentAdapter(), contentProposalProvider, null, null);
		// adapter.setFilterStyle(ContentProposalAdapter.FILTER_CHARACTER);
		adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);

	}

	public EObject getValue() {
		EObject eObject = this.fElements.get(this.combo.getText());
		return eObject;
	}

	protected void commit() {
		fireCommit();
	}

	public void setValue(final EObject value) {
		//
	}

	protected Button getButton() {
		return this.button;
	}

	protected Combo getCombo() {
		return this.combo;
	}

	protected Control getParentControl() {
		return this.parentControl;
	}

	protected Map<String, EObject> getfElements() {
		return this.fElements;
	}

}
