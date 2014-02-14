/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 372865 - FacetSet selection dialog
 *     Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *     Nicolas Bros (Mia-Software) - Bug 372626 - Aggregates
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.widget;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.efacet.core.internal.exported.IResolverManager;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.dialogs.FacetSetTreeContentProvider;
import org.eclipse.emf.facet.efacet.ui.internal.exported.widget.IFacetSetSelectionWidget;
import org.eclipse.emf.facet.util.emf.ui.internal.utils.ImageUtils;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/** A control that displays a tree of FacetSets with checkboxes to select them. */
public class FacetSetSelectionControl implements IFacetSetSelectionWidget {

	/** An OK status, but without the "OK" message, because we don't want "OK" to appear in the status bar */
	protected static final IStatus OK_STATUS = new Status(IStatus.OK, Activator.PLUGIN_ID, ""); //$NON-NLS-1$
	protected static final String INVALID_ELEMENTS = Messages.FacetSetSelectionControl_selectionContainsInvalidElements;
	protected static final String ONLY_FACET_SETS = Messages.FacetSetSelectionControl_onlyFacetSetsAllowedInSelection;

	private final Composite cParent;
	private CheckboxTreeViewer treeViewer;
	private Collection<? extends FacetSet> available;

	private final int selectionMaxSize;
	private final boolean allowEmpty;
	private IStatus validationStatus;
	private final Runnable onChange;
	private final Set<FacetSet> selected = new HashSet<FacetSet>();

	/** Create a checkbox tree to select FacetSets. */
	public FacetSetSelectionControl(final Composite parentComposite, final int selectionMaxSize, final boolean allowEmpty, final Runnable onChange) {
		this.cParent = parentComposite;
		this.selectionMaxSize = selectionMaxSize;
		this.allowEmpty = allowEmpty;
		this.onChange = onChange;
	}

	public void createContents() {
		final Composite composite = new Composite(this.cParent, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		createCheckboxTreeViewer(composite);
		updateValidationStatus();
	}

	protected void notifyChanged() {
		if (this.onChange != null) {
			this.onChange.run();
		}
	}

	public void setAvailableFacetSets(final Collection<? extends FacetSet> newAvailable) {
		this.available = newAvailable;
		this.treeViewer.setInput(newAvailable.toArray());
		updateValidationStatus();
		notifyChanged();
	}

	public Collection<? extends FacetSet> getAvailableFacetSets() {
		return Collections.unmodifiableCollection(this.available);
	}

	public List<FacetSet> getSelectedFacetSets() {
		return Collections.unmodifiableList(new ArrayList<FacetSet>(this.selected));
	}

	public void setSelectedFacetSets(final Collection<? extends FacetSet> facetSetsToSelect) {
		if (facetSetsToSelect == null) {
			throw new IllegalArgumentException();
		}
		this.selected.clear();
		this.selected.addAll(facetSetsToSelect);
		updateValidationStatus();
		notifyChanged();
		this.treeViewer.refresh();
	}

	public final void addCheckStateListener(final ICheckStateListener listener) {
		this.treeViewer.addCheckStateListener(listener);
	}

	protected void createCheckboxTreeViewer(final Composite parentComposite) {
		this.treeViewer = new CheckboxTreeViewer(parentComposite, SWT.BORDER);
		this.treeViewer.setContentProvider(createContentProvider());
		this.treeViewer.setLabelProvider(createLabelProvider());
		this.treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		getTreeViewer().setCheckStateProvider(createCheckStateProvider());
		addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(final CheckStateChangedEvent event) {
				FacetSetSelectionControl.this.checkStateChanged(event);
			}
		});
		getTreeViewer().refresh();
	}
	
	protected void checkStateChanged(final CheckStateChangedEvent event) {
		handleCheckStateChange(event);
		getTreeViewer().refresh();
		updateValidationStatus();
		notifyChanged();
	}

	protected void handleCheckStateChange(final CheckStateChangedEvent event) {
		final Object element = event.getElement();
		if (event.getElement() instanceof FacetSet) {
			final FacetSet facetSet = (FacetSet) event.getElement();
			FacetSet propagation = IResolverManager.DEFAULT
					.selectionRoot(element, FacetSet.class);
			if (propagation == null) {
				propagation = facetSet;
			}
			if (event.getChecked()) {
				this.selected.add(propagation);
			} else {
				this.selected.remove(propagation);
			}
		}
		this.treeViewer.refresh();
	}
	
	protected boolean isUnderCheckedSuperPackage(final Object element) {
		boolean result = false;
		if (element instanceof FacetSet) {
			final FacetSet facetSet = (FacetSet) element;
			EObject eSuperPackage = facetSet.eContainer();
			while (eSuperPackage != null) {
				if (this.selected.contains(eSuperPackage)) {
					result = true;
					break;
				}
				eSuperPackage = eSuperPackage.eContainer();
			}
		}
		return result;
	}

	protected ICheckStateProvider createCheckStateProvider() {
		return new ICheckStateProvider() {
			public boolean isGrayed(final Object element) {
				return FacetSetSelectionControl.this.isGrayed(element);
			}

			public boolean isChecked(final Object element) {
				return FacetSetSelectionControl.this.isChecked(element);
			}
		};
	}

	protected boolean isGrayed(final Object element) {
		final List<FacetSet> propagation = IResolverManager.DEFAULT
				.selectionPropagation(element, FacetSet.class);
		boolean contains = false;
		if (element instanceof EObject) {
			final EObject eObject = (EObject) element;
			contains = containsSelectedElement(eObject);
		}
		return (contains || isUnderCheckedSuperPackage(element) || propagation
				.contains(element)) && !this.selected.contains(element);
	}

	protected boolean containsSelectedElement(final EObject eObject) {
		boolean contains = false;
		final Iterator<EObject> iterator = eObject.eAllContents();
		while (iterator.hasNext()) {
			final EObject subObject = iterator.next();
			contains = this.selected.contains(subObject);
			if (contains) {
				break;
			}
		}
		return contains;
	}

	protected boolean isChecked(final Object element) {
		// This "|| isGrayed(element)" has been added avoid problems with
		// Windows 7.
		return this.selected.contains(element) || isGrayed(element);
	}

	protected void updateValidationStatus() {
		if (this.treeViewer == null) {
			return;
		}
		final Object[] checkedElements = this.treeViewer.getCheckedElements();
		IStatus newStatus = FacetSetSelectionControl.OK_STATUS;
		if (!this.allowEmpty && checkedElements.length == 0) {
			newStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(Messages.FacetSetSelectionControl_mustSelectAtLeastOneElement,
					Integer.valueOf(this.selectionMaxSize)));
		} else if (checkedElements.length > this.selectionMaxSize) {
			newStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(Messages.FacetSetSelectionControl_mustSelectAtMostNElements,
					Integer.valueOf(this.selectionMaxSize)));
		} else {
			for (final Object checkedElement : checkedElements) {
				final IStatus elementStatus = validateElement(checkedElement);
				if (elementStatus.getSeverity() >= IStatus.ERROR) {
					newStatus = elementStatus;
					break;
				}
			}
		}
		setValidationStatus(newStatus);
	}
	
	protected static IStatus validateElement(final Object checkedElement) {
		IStatus status = FacetSetSelectionControl.OK_STATUS;
		if (!(checkedElement instanceof FacetSet)) {
			status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, FacetSetSelectionControl.ONLY_FACET_SETS);
		}
		return status;
	}

	protected boolean isAvailable(final FacetSet facetSet) {
		boolean bAvailable = false;
		if (this.available.contains(facetSet)) {
			bAvailable = true;
		} else {
			EPackage parent = facetSet.getESuperPackage();
			while (parent != null) {
				if (this.available.contains(parent)) {
					bAvailable = true;
					break;
				}
				parent = parent.getESuperPackage();
			}
		}
		return bAvailable;
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

	protected ILabelProvider createLabelProvider() {
		return new LabelProvider() {
			@Override
			public String getText(final Object element) {
				String text;
				if (element instanceof ENamedElement) {
					final ENamedElement namedElement = (ENamedElement) element;
					text = namedElement.getName();
				} else {
					text = super.getText(element);
				}
				return text;
			}

			@Override
			public Image getImage(final Object element) {
				return ImageUtils.getImage(element);
			}
		};
	}

	// @SuppressWarnings("static-method") : meant to be overridden
	@SuppressWarnings("static-method")
	protected IContentProvider createContentProvider() {
		return new FacetSetTreeContentProvider(false, true, true);
	}

	public CheckboxTreeViewer getTreeViewer() {
		return this.treeViewer;
	}

	public boolean isDisposed() {
		return this.treeViewer.getTree().isDisposed();
	}

	public void selectAll() {
		this.selected.clear();
		this.selected.addAll(this.available);
		this.treeViewer.refresh();
	}

	public void deselectAll() {
		this.selected.clear();
		this.treeViewer.refresh();
	}

	public Control getControl() {
		Control control = null;
		if (this.treeViewer != null) {
			control = this.treeViewer.getTree();
		}
		return control;
	}
}
