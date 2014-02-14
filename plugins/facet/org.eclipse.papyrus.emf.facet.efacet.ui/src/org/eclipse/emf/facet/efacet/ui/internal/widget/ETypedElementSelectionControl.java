/*******************************************************************************
 * Copyright (c) 2010, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 370806 - [table] rewrite the "allowed contents" query selection dialog for v0.2
 *     Vincent Lorenzo (CEA-LIST) - Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *     Gregoire Dupe (Mia-Software) - Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *     Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *     Vincent Lorenzo (CEA-LIST) - Bug 357621 - Improve the label displayed for Customization and Facets
 *     Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *     Olivier Remaud (Soft-Maint) - Bug 377615 - Query View filtering
 *     Vincent Lorenzo (CEA-LIST) - Bug 357621 - Improve the label displayed for Customization and Facets
 *     Vincent Lorenzo (CEA-LIST) - Bug 377909 - The elements displayed in the ETypedElement dialog are not sorted by alphabetic order 
*******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.widget;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.emf.facet.custom.core.ICustomizationManagerFactory;
import org.eclipse.emf.facet.custom.ui.ICustomizedLabelProviderFactory;
import org.eclipse.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.utils.ImageProvider;
import org.eclipse.emf.facet.util.core.internal.exported.IFilter;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

/**
 * A control that displays a tree of ETypedElements under a list of containers (EPackages for example), with a filter
 * text field.
 */
public class ETypedElementSelectionControl implements IETypedElementTabSelectionWidgetInternal {

	public static final String TAB_ID = "flat.view.id"; //$NON-NLS-1$
	
	public static final String TITLE = Messages.ETypedElementSelectionControl_FlatView;
	
	/** An OK status, but without the "OK" message, because we don't want "OK" to appear in the status bar */
	private static final IStatus OK_STATUS = new Status(IStatus.OK, Activator.PLUGIN_ID, ""); //$NON-NLS-1$

	private FilteredTree filteredTree;
	protected Collection<? extends ETypedElement> available;
	private final int selectionMaxSize;
	private final boolean allowEmpty;
	private Button rbNoSelection;
	private Button rbSelection;
	private IStatus validationStatus;
	private final IBaseLabelProvider labelProvider;
	private final Composite cParent;
	private final Collection<? extends EObject> knownEPackage;

	/** Create a tree with a filter text field to select ETypedElements. */
	public ETypedElementSelectionControl(final Composite parentComposite,
			final int selectionMaxSize, final boolean allowEmpty,
			final ICustomizationManager customManager,
			final Collection<? extends EObject> knownEPackage) {
		this.cParent = parentComposite;
		this.knownEPackage = knownEPackage;
		this.selectionMaxSize = selectionMaxSize;
		this.allowEmpty = allowEmpty;
		ICustomizationManager tempCustomManager;
		if (customManager == null) {
			tempCustomManager = ICustomizationManagerFactory.DEFAULT.getOrCreateICustomizationManager(new ResourceSetImpl());
		} else {
			tempCustomManager = customManager;
		}
		this.labelProvider = ICustomizedLabelProviderFactory.DEFAULT
				.createCustomizedLabelProvider(tempCustomManager);
	}

	public void createContents() {
		final Composite composite = new Composite(this.cParent, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		if (this.allowEmpty) {
			this.rbNoSelection = new Button(composite, SWT.RADIO);
			this.rbNoSelection.setText(Messages.ETypedElementSelectionDialog_radioButtonNoSelection);
			this.rbNoSelection.setSelection(true);
			this.rbNoSelection.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent event) {
					final boolean selected = getRadioButtonNoSelection().getSelection();
					setETypedElementSelectionEnabled(!selected);
					if (selected) {
						setSelection(StructuredSelection.EMPTY);
					}
				}
			});
			this.rbSelection = new Button(composite, SWT.RADIO);
			if (this.selectionMaxSize > 1) {
				this.rbSelection.setText(Messages.ETypedElementSelectionDialog_radioButtonMultiSelection);
			} else {
				this.rbSelection.setText(Messages.ETypedElementSelectionDialog_radioButtonSingleSelection);
			}
			this.rbSelection.setSelection(false);
			this.rbSelection.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent event) {
					final boolean selected = getRadioButtonSelection().getSelection();
					setETypedElementSelectionEnabled(selected);
					if (!selected) {
						setSelection(StructuredSelection.EMPTY);
					}
				}
			});
		}

		createFilteredTree(composite);

		this.filteredTree.getViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(final SelectionChangedEvent event) {
				updateValidationStatus();
			}
		});

		if (this.allowEmpty) {
			setETypedElementSelectionEnabled(false);
		}

		updateValidationStatus();
	}

	public void addOpenListener(final IOpenListener openListener) {
		// double-click or enter to choose the selected typed element
		this.filteredTree.getViewer().addOpenListener(new IOpenListener() {
			public void open(final OpenEvent event) {
				// only if the selection is valid
				if (!isErrorStatus()) {
					openListener.open(event);
				}
			}
		});
	}

	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		this.filteredTree.getViewer().addSelectionChangedListener(listener);
	}

	private void createFilteredTree(final Composite parentComposite) {
		this.filteredTree = new FilteredTree(parentComposite, selectionStyle(this.selectionMaxSize) | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.BORDER, createPatternFilter(), true);
		// allow tooltip for this viewer
		ColumnViewerToolTipSupport.enableFor(this.filteredTree.getViewer());
		this.filteredTree.getViewer().setContentProvider(createContentProvider());
		this.filteredTree.getViewer().setLabelProvider(this.labelProvider);
		this.filteredTree.getViewer().setFilters(new ViewerFilter[] { this.filteredTree.getPatternFilter() });
		this.filteredTree.getViewer().setComparator(new ViewerComparator());
	}

	protected void updateValidationStatus() {
		if (this.filteredTree == null) {
			return;
		}

		final Status errorElements = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
				Messages.ETypedElementSelectionControl_invalidSelectionETypedElementsOnly);
		final Status errorSelection = new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.ETypedElementSelectionControl_invalidSelection);

		final IStructuredSelection selection = (IStructuredSelection) this.filteredTree.getViewer().getSelection();
		IStatus newStatus = ETypedElementSelectionControl.OK_STATUS;
		if (!this.allowEmpty && selection.isEmpty()) {
			newStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(Messages.ETypedElementSelectionControl_invalidSelectionAtLeastOneElement,
					Integer.valueOf(this.selectionMaxSize)));
		} else if (selection.size() > this.selectionMaxSize) {
			newStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(Messages.ETypedElementSelectionControl_invalidSelectionAtMostXElements,
					Integer.valueOf(this.selectionMaxSize)));
		} else {
			final Iterator<?> iterator = selection.iterator();
			while (iterator.hasNext()) {
				final Object selectedElement = iterator.next();
				if (!(selectedElement instanceof ETypedElement)) {
					newStatus = errorElements;
					break;
				}
			}
		}
		setValidationStatus(newStatus);
	}

	protected void setValidationStatus(final IStatus status) {
		this.validationStatus = status;
	}

	public IStatus getValidationStatus() {
		return this.validationStatus;
	}

	public boolean isErrorStatus() {
		return this.validationStatus == null || this.validationStatus.getSeverity() >= IStatus.ERROR;
	}

	public void setAvailableETypedElements(final Collection<? extends ETypedElement> newAvailable) {
		this.available = newAvailable;
		final Set<EObject> containers = new HashSet<EObject>();
		for (final ETypedElement eTypedElement : newAvailable) {
			final EObject container = getTopmostContainer(eTypedElement);
			if (container != null && containsETypedElement(container)) {
				containers.add(container);
			}
		}
		for (EObject eObject : this.knownEPackage) {
			if (containsETypedElement(eObject)) {
				containers.add(eObject);
			}
		}
		setInput(containers);
	}

	protected static EObject getTopmostContainer(final EObject eObject) {
		EObject container = eObject.eContainer();
		EObject result = container;
		while (container != null) {
			result = container;
			container = container.eContainer();
		}
		return result;
	}

	public List<ETypedElement> getSelectedETypedElements() {
		final List<ETypedElement> currentlySelected = new ArrayList<ETypedElement>();
		if (this.filteredTree.isDisposed()) {
			throw new IllegalStateException("Cannot get the selection since the viewer is disposed."); //$NON-NLS-1$
		}
		final IStructuredSelection selection = (IStructuredSelection) this.filteredTree.getViewer()
				.getSelection();
		final Iterator<?> iterator = selection.iterator();
		while (iterator.hasNext()) {
			final Object element = iterator.next();
			if (element instanceof ETypedElement) {
				final ETypedElement eTypedElement = (ETypedElement) element;
				currentlySelected.add(eTypedElement);
			}
		}
		return currentlySelected;
	}

	public void setSelectedETypedElements(final Collection<? extends ETypedElement> newSelection) {
		if (newSelection == null) {
			throw new IllegalArgumentException();
		}
		final List<ETypedElement> filteredSelection = new ArrayList<ETypedElement>();
		filteredSelection.addAll(newSelection);
		// only keep available elements
		filteredSelection.retainAll(this.available);
		setSelection(new StructuredSelection(filteredSelection));
	}

	public void setSelection(final IStructuredSelection selection) {
		setETypedElementSelectionEnabled(!selection.isEmpty());
		this.filteredTree.getViewer().setSelection(selection);
		updateValidationStatus();
	}

	protected void setETypedElementSelectionEnabled(final boolean enabled) {
		getRadioButtonNoSelection().setSelection(!enabled);
		getRadioButtonSelection().setSelection(enabled);
		this.filteredTree.getViewer().getTree().setEnabled(enabled);
		this.filteredTree.getFilterControl().setEnabled(enabled);
	}

	public void setInput(final Collection<? extends EObject> containers) {
		this.filteredTree.getViewer().setInput(containers);
	}

	// @SuppressWarnings("unchecked") : this is the input type
	@SuppressWarnings("unchecked")
	public Collection<? extends EObject> getInput() {
		return (Collection<? extends EObject>) this.filteredTree.getViewer().getInput();
	}

	protected IContentProvider createContentProvider() {
		return new ETypedElementSelectionControlContentProvider(new IFilter<EObject>() {
			public boolean filter(final EObject eObject) {
				return filterChild(eObject);
			}
		});
	}

	protected boolean filterChild(final EObject eObject) {
		boolean selected;
		if (containsETypedElement(eObject)) {
			selected = true;
		} else if (eObject instanceof ETypedElement) {
			selected = isAvailable(eObject);
		} else {
			selected = false;
		}
		return selected;
	}

	protected boolean isAvailable(final EObject eObject) {
		return this.available.contains(eObject);
	}

	protected boolean containsETypedElement(final EObject eObject) {
		boolean result = false;
		final TreeIterator<EObject> eAllContents = eObject.eAllContents();
		while (eAllContents.hasNext()) {
			final EObject element = eAllContents.next();
			if (element instanceof ETypedElement) {
				final ETypedElement typedElement = (ETypedElement) element;
				if (isAvailable(typedElement)) {
					result = true;
					break;
				}
			} else {
				result = containsETypedElement(element);
				if (result) {
					break;
				}
			}
		}
		return result;
	}

	private static int selectionStyle(final int selectionMaxSize) {
		int selectionStyle;
		if (selectionMaxSize > 1) {
			selectionStyle = SWT.MULTI;
		} else {
			selectionStyle = SWT.SINGLE;
		}
		return selectionStyle;
	}

	private static PatternFilter createPatternFilter() {
		return new PatternFilter() {
			@Override
			protected boolean isLeafMatch(final Viewer viewer, final Object element) {
				final String labelText = ((ILabelProvider) ((StructuredViewer) viewer).getLabelProvider())
						.getText(element);

				if (labelText == null) {
					return false;
				}
				return wordMatches(labelText) || parentMatches(viewer, element);
			}

			private boolean parentMatches(final Viewer viewer, final Object element) {
				final ITreeContentProvider contentProvider = (ITreeContentProvider) ((StructuredViewer) viewer)
						.getContentProvider();
				final Object parent = contentProvider.getParent(element);
				if (parent == null) {
					return false;
				}
				return isLeafMatch(viewer, parent);
			}
		};
	}

	public IStructuredSelection getSelection() {
		return (IStructuredSelection) this.filteredTree.getViewer().getSelection();
	}

	protected Button getRadioButtonNoSelection() {
		return this.rbNoSelection;
	}

	protected Button getRadioButtonSelection() {
		return this.rbSelection;
	}

	public FilteredTree getFilteredTree() {
		return this.filteredTree;
	}

	public boolean isDisposed() {
		return this.filteredTree.isDisposed();
	}

	public String getTitle() {
		return ETypedElementSelectionControl.TITLE;
	}

	public String getToolTipText() {
		return getTitle();
	}

	public Image getImage() {
		return ImageProvider.getInstance().getFlatViewIcon();
	}

	public String getTabId() {
		return ETypedElementSelectionControl.TAB_ID;
	}

	public Collection<? extends EObject> getKnownEPackage() {
		return this.knownEPackage;
	}
}
