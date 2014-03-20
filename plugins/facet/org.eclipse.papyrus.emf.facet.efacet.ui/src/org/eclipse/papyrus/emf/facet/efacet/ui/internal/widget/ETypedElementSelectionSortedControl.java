/*******************************************************************************
 * Copyright (c) 2012 CEA-LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Vincent Lorenzo (CEA-LIST) - Bug 357621 - Improve the label displayed for Customization and Facets
 *     Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *     Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *     Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *     Vincent Lorenzo (CEA-LIST) - Bug 357621 - Improve the label displayed for Customization and Facets
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.efacet.ui.internal.widget;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.papyrus.emf.facet.efacet.core.FacetUtils;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.ui.internal.utils.ImageProvider;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.IFilter;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

/**
 * A control that displays a tree of ETypedElements under a list of containers
 * (EPackages for example), with a filter text field.
 * 
 * the result should be : Ecore - FacetSet/Custom/... UML - FacetSet/Custom/...
 * Aggregate - FacetSet/Custom/...
 */
public class ETypedElementSelectionSortedControl extends
		ETypedElementSelectionControl {

	/** this groupByMap is used to define the input of the treeviewer */
	private final Map<EPackage, Set<EObject>> groupByMap;

	/** the name of the tabs */
	private static final String NAME = Messages.ETypedElementSelectionSortedControl_groupByMetamodelView;

	public static final String GROUPED_TAB_ID = "group.by.metamodel.view.id"; //$NON-NLS-1$

	public static final String TOOLTIP = Messages.ETypedElementSelectionSortedControl_toolTip;

	/**
	 * 
	 * @param parentComposite
	 * @param selectionMaxSize
	 * @param allowEmptySelection
	 * @param customizationMgr
	 */
	public ETypedElementSelectionSortedControl(final Composite parentComposite,
			final int selectionMaxSize, final boolean allowEmpty,
			final ICustomizationManager customizationMgr,
			final Collection<? extends EObject> knownEPackage) {
		super(parentComposite, selectionMaxSize, allowEmpty,
				customizationMgr, knownEPackage);
		this.groupByMap = new HashMap<EPackage, Set<EObject>>();
	}

	@Override
	public void setAvailableETypedElements(
			final Collection<? extends ETypedElement> newAvailable) {
		this.available = newAvailable;
		prepareInput();
		setInput(this.groupByMap.keySet());
	}

	/**
	 * this method is used to organize the input
	 */
	private void prepareInput() {
		if (this.available != null) {
			for (ETypedElement eTypedElement : this.available) {
				final EObject container = getTopmostContainer(eTypedElement);
				if (container != null && containsETypedElement(container)) {
					addContainer(container);
				}
			}
		}
		for (EObject current : getKnownEPackage()) {
			if (containsETypedElement(current)) {
				addContainer(current);
			}
		}
	}

	
	/**
	 * Add a container to the groupByMap
	 * 
	 * @param container
	 *            a container to add
	 */
	private void addContainer(final EObject container) {
		if (container instanceof FacetSet) { //we show only FacetSet in this view
			final FacetSet facetSet = (FacetSet) container;
			final Set<EPackage> packs = FacetUtils
					.getAllExtendedEPackage(facetSet);
			if (packs.isEmpty()) {
				Logger.logError(NLS.bind("Package not found: {0}", //$NON-NLS-1$
						container), Activator.getDefault());
			}
			for (EPackage current : packs) {
				getValues(current).add(container);
			}
		}
	}
	
	/**
	 * 
	 * @param pack
	 *            an EPackage
	 * @return the values associated to the EPackage
	 */
	private Collection<EObject> getValues(final EPackage pack) {
		if (!this.groupByMap.containsKey(pack)) {
			final Set<EObject> values = new HashSet<EObject>();
			this.groupByMap.put(pack, values);
		}
		return this.groupByMap.get(pack);
	}
	
	@Override
	protected IContentProvider createContentProvider() {
		return new SortedContentProvider(new IFilter<EObject>() {
			public boolean filter(final EObject eObject) {
				return filterChild(eObject);
			}
		});
	}

	@Override
	public String getTitle() {
		return ETypedElementSelectionSortedControl.NAME;
	}

	@Override
	public Image getImage() {
		return ImageProvider.getInstance().getTreeViewIcon();
	}

	@Override
	public String getToolTipText() {
		return ETypedElementSelectionSortedControl.TOOLTIP;
	}

	@Override
	public String getTabId() {
		return ETypedElementSelectionSortedControl.GROUPED_TAB_ID;
	}

	public Set<EObject> getChlidren(final Object parentElement) {
		return this.groupByMap
				.get(parentElement);
	}
	
	private class SortedContentProvider extends
			ETypedElementSelectionControlContentProvider {

		public SortedContentProvider(final IFilter<EObject> childrenFilter) {
			super(childrenFilter);
		}

		@Override
		public Object[] getChildren(final Object parentElement) {
			Object[] children;
			final Set<EObject> list = ETypedElementSelectionSortedControl.this
					.getChlidren(parentElement);
			if (list == null) {
				children = super.getChildren(parentElement);
			} else {
				children = list.toArray();
			}
			return children;
		}

		@Override
		public Object getParent(final Object element) {
			Object parent = super.getParent(element);
			if (parent == null && element instanceof FacetSet) {
				final Set<EPackage> packs = FacetUtils
						.getAllExtendedEPackage((FacetSet) element);
				if (!packs.isEmpty()) {
					parent = packs.iterator().next();
				}
			}
			return parent;
		}

	}
}
