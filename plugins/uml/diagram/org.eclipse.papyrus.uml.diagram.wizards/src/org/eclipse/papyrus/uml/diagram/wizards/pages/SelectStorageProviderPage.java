/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.pages;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.uml.diagram.wizards.Activator;
import org.eclipse.papyrus.uml.diagram.wizards.INewModelStorageProvider;
import org.eclipse.papyrus.uml.diagram.wizards.NewModelStorageProviderRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**
 * This is the SelectStorageProviderPage type. Enjoy.
 */
public class SelectStorageProviderPage
		extends WizardPage
		implements ISelectionProvider {

	public static final String PAGE_ID = "SelectStorageProvider"; //$NON-NLS-1$

	private final NewModelStorageProviderRegistry registry;

	private CopyOnWriteArrayList<ISelectionChangedListener> selectionListeners = new CopyOnWriteArrayList<ISelectionChangedListener>();

	private List<Button> providerRadioButtons = new java.util.ArrayList<Button>(
		3);

	private Button selection;

	public SelectStorageProviderPage(NewModelStorageProviderRegistry registry) {
		super(PAGE_ID);

		this.registry = registry;

		setTitle("Model Storage");
		setDescription("Select the kind of storage for the new model.");
	}

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		SelectionListener buttonListener = createRadioButtonListener();

		Composite myComposite = new Composite(parent, SWT.NONE);
		myComposite.setLayout(new GridLayout());

		new Label(myComposite, SWT.NONE)
			.setText("Where would you like to store the new model?");

		Composite selectionArea = new Composite(myComposite, SWT.NONE);
		selectionArea.setLayout(new GridLayout());
		GridDataFactory.fillDefaults().grab(true, true).applyTo(selectionArea);

		for (NewModelStorageProviderRegistry.Descriptor next : registry) {
			final Button newRadio = new Button(selectionArea, SWT.RADIO);
			newRadio.setText(next.getLabel());
			if (providerRadioButtons.isEmpty()) {
				newRadio.setSelection(true);
				this.selection = newRadio;
			}

			providerRadioButtons.add(newRadio);

			INewModelStorageProvider.ISelectProviderPart part = next
				.createSelectProviderPart();
			if (part != null) {
				Control partControl = part.createControl(selectionArea);
				GridDataFactory.fillDefaults().grab(true, false)
					.indent(convertWidthInCharsToPixels(5), 0)
					.applyTo(partControl);
				part.setEnabled(newRadio.getSelection());

				part.addPartCompleteListener(new INewModelStorageProvider.ISelectProviderPart.IPartCompleteListener() {

					public void partCompletenessChanged(
							INewModelStorageProvider.ISelectProviderPart part) {
						updatePageComplete(newRadio);
					}
				});
			}

			newRadio.setData(new ProviderPair(next, part));
			newRadio.addSelectionListener(buttonListener);
		}

		setControl(myComposite);
	}

	private SelectionListener createRadioButtonListener() {
		return new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Button selected = (Button) e.widget;
				if (selected.getSelection() && (selected != selection)) {
					select(selected);
				}
			}
		};
	}

	private void select(Button radioButton) {
		selection.setSelection(false);
		updateEnablement(selection);

		selection = radioButton;
		updateEnablement(selection);

		updatePageComplete(selection);

		fireSelectionEvent();
	}

	private void updateEnablement(Button radioButton) {
		ProviderPair pair = getProvider(radioButton);

		if (pair.part != null) {
			pair.part.setEnabled(radioButton.getSelection());
		}
	}

	private ProviderPair getProvider(Button radioButton) {
		return (ProviderPair) radioButton.getData();
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionListeners.addIfAbsent(listener);
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {

		selectionListeners.remove(listener);
	}

	public ISelection getSelection() {
		return new StructuredSelection(getProvider(selection).provider);
	}

	public void setSelection(ISelection selection) {
		if ((selection instanceof IStructuredSelection) && !selection.isEmpty()) {
			Object first = ((IStructuredSelection) selection).getFirstElement();
			Button newSelection = null;

			for (Button next : providerRadioButtons) {
				if (getProvider(next) == first) {
					newSelection = next;
					break;
				}
			}

			if ((newSelection != null) && (newSelection != this.selection)) {
				newSelection.setSelection(true);
				select(newSelection);
			}
		}
	}

	private void updatePageComplete(Button providerButton) {
		ProviderPair pair = getProvider(providerButton);
		setPageComplete((pair.part == null) || pair.part.isPartComplete());
	}

	private void fireSelectionEvent() {
		if (!selectionListeners.isEmpty()) {
			SelectionChangedEvent event = new SelectionChangedEvent(this,
				getSelection());

			for (ISelectionChangedListener next : selectionListeners) {
				try {
					next.selectionChanged(event);
				} catch (Exception e) {
					Activator.log.error(
						"Uncaught exception in selection listener.", e);
				}
			}
		}
	}

	//
	// Nested types
	//

	private static class ProviderPair {

		final INewModelStorageProvider provider;

		final INewModelStorageProvider.ISelectProviderPart part;

		ProviderPair(INewModelStorageProvider provider,
				INewModelStorageProvider.ISelectProviderPart part) {

			this.provider = provider;
			this.part = part;
		}
	}
}
