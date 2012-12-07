/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.uml.table.widget.celleditors.composite;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.facet.widgets.celleditors.AbstractCellEditorComposite;
import org.eclipse.emf.facet.widgets.celleditors.internal.Messages;
import org.eclipse.emf.facet.widgets.internal.CustomizableLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ComboContentAdapter;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.SimpleContentProposalProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.widgets.editors.ReferenceCombo;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profilefacet.utils.StereotypePropertyUtils;
import org.eclipse.papyrus.uml.table.widget.celleditors.utils.StereotypePropertyFacetElementUtils;
import org.eclipse.papyrus.uml.table.widget.celleditors.utils.NoReferencedElement;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
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
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class UnaryReferencePapyrusCellEditorComposite extends AbstractCellEditorComposite<EObject> {

	private static final int GRID_DATA_HEIGHT = 50;

	private final Button button;

	private final Combo combo;

	private final Control parentControl;

	private final EObject source;

	private final Map<String, EObject> fElements = new TreeMap<String, EObject>();


	private final EStructuralFeature feature;

	/**
	 * @param parent
	 *        the parent composite
	 * @param eObjects
	 *        the possible choices
	 */
	public UnaryReferencePapyrusCellEditorComposite(final Composite parent, final List<EObject> eObjects, final EObject source1, final EStructuralFeature feature1) {
		super(parent);
		assert source1 instanceof Element;
		this.source = StereotypePropertyFacetElementUtils.getRealSource(source1, feature1);
		this.feature = StereotypePropertyFacetElementUtils.getRealFeature(source1, feature1);
		Stereotype ste = null;
		if(feature1 instanceof StereotypePropertyElement) {
			ste = StereotypePropertyUtils.getAppliedStereotype((Element)source1, (StereotypePropertyElement)feature1);
		}
		this.parentControl = parent;
		final ILabelProvider labelProvider = new UMLLabelProvider();
		final ILabelProvider customizableLabelProvider = new CustomizableLabelProvider();
		final UMLContentProvider provider;
		if(ste != null) {
			provider = new UMLContentProvider(source, feature, ste, source.eResource().getResourceSet());
		} else {
			provider = new UMLContentProvider(source1, feature1, null, source.eResource().getResourceSet());
		}

		EObject noReferencedElement = null;

		for(EObject eObject : eObjects) {
			String label;
			if(eObject instanceof NoReferencedElement) {
				label = eObject.toString();
				noReferencedElement = eObject;
			} else {
				label = customizableLabelProvider.getText(eObject);;
			}
			// find a unique label
			if(this.fElements.get(label) != null) {
				int suffix = 2;
				while(this.fElements.get(label + " (" + suffix + ")") != null) { //$NON-NLS-1$ //$NON-NLS-2$
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
		fontData[0].setHeight(fontData[0].getHeight()/* - 2 */);
		Font font = new Font(Display.getDefault(), fontData);
		this.combo.setFont(font);
		for(String label : this.fElements.keySet()) {
			this.combo.add(label);
		}

		//we force the null value to the first place
		if(noReferencedElement != null) {
			this.combo.remove(noReferencedElement.toString());
			this.combo.add(noReferencedElement.toString(), 0);
		}

		GridData comboGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		this.combo.setLayoutData(comboGridData);
		addCompletionHandler(this.combo, this.fElements.keySet());

		//we set the initial value in the combo : 
		Object currentValue = this.source.eGet(this.feature);
		if(currentValue == null) {
			if(noReferencedElement != null) {
				int index = this.combo.indexOf(noReferencedElement.toString());
				if(index > -1) {
					this.combo.select(index);
				}
			}
		} else {
			final String txt = customizableLabelProvider.getText(currentValue);
			int index = this.combo.indexOf(txt);
			if(index > -1) {
				this.combo.select(index);
			}
		}
		this.combo.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(final KeyEvent event) {
				// Enter key pressed
				if((event.keyCode == SWT.CR && event.stateMask == 0) || (event.keyCode == SWT.KEYPAD_CR && event.stateMask == 0)) {
					if(isValid()) {
						commit();
					} else {
						MessageDialog.openWarning(parent.getShell(), Messages.UnaryReferenceCellEditorComposite_0, Messages.UnaryReferenceCellEditorComposite_1);
					}
				} else if(event.keyCode == SWT.ESC && event.stateMask == 0) {
					// Escape key pressed
					close();
				}
			}
		});

		this.button = new Button(this, SWT.PUSH);
		this.button.setText("..."); //$NON-NLS-1$
		GridData buttonGridData = new GridData(SWT.FILL, SWT.FILL, false, true);
		buttonGridData.heightHint = UnaryReferencePapyrusCellEditorComposite.GRID_DATA_HEIGHT;
		this.button.setLayoutData(buttonGridData);
		this.button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent e) {
				TreeSelectorDialog dialog = new TreeSelectorDialog(Display.getCurrent().getActiveShell()) {

					@Override
					public void okPressed() {
						Object selectedElements[] = new Object[this.getResult().length];
						Object result[] = this.getResult();
						for(int i = 0; i < result.length; i++) {
							Object adapted = provider.getAdaptedValue(result[i]);
							selectedElements[i] = adapted;
						}
						String selectedElementLabel = null;

						if(selectedElements.length > 0) {
							Set<Entry<String, EObject>> entrySet = UnaryReferencePapyrusCellEditorComposite.this.getfElements().entrySet();
							for(Entry<String, EObject> entry : entrySet) {
								if(entry.getValue() == selectedElements[0]) {
									selectedElementLabel = entry.getKey();
									break;
								}
							}
						}
						UnaryReferencePapyrusCellEditorComposite.this.getCombo().setText(selectedElementLabel);
						commit();
						super.okPressed();
						super.close();
					}

				};


				dialog.setLabelProvider(labelProvider);
				dialog.setContentProvider(provider);
				if(source != null) {
					dialog.setInitialElementSelections(Collections.singletonList(source.eGet(feature)));
				}

				dialog.setTitle(feature.getEType().getName());

				dialog.open();

			}
		});

		// commit the cell editor when the mouse is clicked
		// anywhere outside the text field
		final Listener clickListener = new Listener() {

			public void handleEvent(final Event event) {
				if(event.widget instanceof Control) {
					Control control = (Control)event.widget;
					if(control.getShell() == UnaryReferencePapyrusCellEditorComposite.this.getParentControl().getShell() && event.widget != UnaryReferencePapyrusCellEditorComposite.this.getButton() && event.widget != UnaryReferencePapyrusCellEditorComposite.this.getCombo()) {
						if(isValid()) {
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
		SimpleContentProposalProvider contentProposalProvider = new SimpleContentProposalProvider(completionsArray);
		contentProposalProvider.setFiltering(true);
		ContentProposalAdapter adapter = new ContentProposalAdapter(comboBox, new ComboContentAdapter(), contentProposalProvider, null, null);
		// adapter.setFilterStyle(ContentProposalAdapter.FILTER_CHARACTER);
		adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);

	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.celleditors.IWidget#getValue()
	 * 
	 * @return
	 */
	public EObject getValue() {
		return this.fElements.get(this.combo.getText());
	}

	protected void commit() {
		fireCommit();
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

	public void setValue(EObject value) {
		//not used
	}
}
