/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.custom.sdk.ui.internal.util.widget.getorcreate;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.facet.custom.core.ICustomizationPropertiesCatalogManager;
import org.eclipse.emf.facet.custom.core.ICustomizationPropertiesCatalogManagerFactory;
import org.eclipse.emf.facet.custom.sdk.ui.internal.Activator;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.util.emf.ui.util.EditingUtil;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.AbstractGetOrCreateFilteredElementCommandWidget;
import org.eclipse.swt.widgets.Composite;

/**
 * This widget extends {@link AbstractGetOrCreateFilteredElementCommandWidget} and allow
 * the selection of a {@link Facet} that the Customization will extend. It
 * displays a selection window with a textfield to filter the element in the
 * selection window. Extending {@link AbstractGetOrCreateFilteredElementCommandWidget},
 * a [New...] button can be displayed. Here, no button is displayed because we
 * only select the extended facet into the existing facet.
 * <p/>
 * 
 * The selection window will be full up with the customization properties
 * returned by {@link ICustomizationPropertiesCatalogManager}.
 */
public class GetFiltredExtendedFacetWidget extends
		AbstractGetOrCreateFilteredElementCommandWidget<Facet, Object> {

	protected static final String TMP_NAME = Activator.getDefault()
			.getBundle().getSymbolicName()
			+ ".tmp"; //$NON-NLS-1$
	public static final File DEFAULT_FILE = new File(Platform
			.getStateLocation(Activator.getDefault().getBundle()).toOSString(),
			GetFiltredExtendedFacetWidget.TMP_NAME);

	private final ICustomizationPropertiesCatalogManager customPropCatMan;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param properties
	 *            the map of properties of the parent.
	 */
	public GetFiltredExtendedFacetWidget(final Composite parent) {
		super(parent);
		this.customPropCatMan = ICustomizationPropertiesCatalogManagerFactory.INSTANCE
				.getOrCreateCustomizationPropertiesCatalogManager(EditingUtil
						.createDefaultResource(
								GetFiltredExtendedFacetWidget.DEFAULT_FILE)
						.getResourceSet());
	}

	@Override
	protected Map<String, Facet> getElements() {
		final Map<String, Facet> allFacets = new HashMap<String, Facet>();
		final List<FacetSet> facetSets = this.customPropCatMan
				.getAllRegisteredCustomizationPropertySet();
		for (final FacetSet facetSet : facetSets) {
			for (final EClassifier eClassifier : facetSet.getEClassifiers()) {
				if ((eClassifier instanceof Facet)
						&& (eClassifier.getName() != null)) {
					allFacets.put(eClassifier.getName(), (Facet) eClassifier);
				}
			}
		}
		return allFacets;
	}

	@Override
	protected IDialog<Object> createDialog() {
		// No "New..." button.
		return null;
	}

	@Override
	public Command getCommand() {
		// Here, this widget only return a selected element so, no command is
		// returned.
		return null;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	public void onDialogValidation() {
		// Nothing.
	}

	/**
	 * @return
	 */
	public Facet getFacetSelected() {
		return getElementSelected();
	}

}
