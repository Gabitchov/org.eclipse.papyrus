/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmt.modisco.infra.browser.Messages;
import org.eclipse.gmt.modisco.infra.browser.MoDiscoBrowserPlugin;
import org.eclipse.gmt.modisco.infra.browser.custom.MetamodelView;
import org.eclipse.gmt.modisco.infra.browser.custom.TypeView;
import org.eclipse.gmt.modisco.infra.browser.ui.LoadCustomizationsDialog;
import org.eclipse.gmt.modisco.infra.browser.uicore.CustomizationManager;
import org.eclipse.gmt.modisco.infra.facet.Facet;
import org.eclipse.gmt.modisco.infra.facet.FacetSet;
import org.eclipse.gmt.modisco.infra.facet.core.FacetSetCatalog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.Activator;
import org.eclipse.papyrus.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * This is a class that launches the button load Customization. this code comes
 * from the {@link LoadCustomizationsDialog}
 */
@SuppressWarnings("restriction")
public class LoadBrowserCustomization extends AbstractHandler {

	/**
	 * 
	 * 
	 * @return the common navigator
	 */
	protected CommonNavigator getCommonNavigator() {
		IViewPart part = org.eclipse.papyrus.modelexplorer.NavigatorUtils
.findViewPart("org.eclipse.papyrus.modelexplorer.modelexplorer"); // FIXME should use a constant here!
		// the part is only a book, retrieving correct page
		if (part instanceof ModelExplorerPageBookView) {
			IViewPart page = ((ModelExplorerPageBookView)part).getActiveView();
			if(page instanceof CommonNavigator) {
				return ((CommonNavigator)page);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		if (Activator.getDefault().getCustomizationManager() != null) {
			CustomizationManager customizationManager = Activator.getDefault()
					.getCustomizationManager();
			final List<MetamodelView> registeredCustomizations = customizationManager
					.getRegisteredCustomizations();

			final LoadCustomizationsDialog loadCustomizationsDialog = new LoadCustomizationsDialog(
					new Shell(), registeredCustomizations, getMetamodelURI());
			if (loadCustomizationsDialog.open() == Window.OK) {
				try {

					 customizationManager.clearCustomizations();
					List<MetamodelView> selectedCustomizations = loadCustomizationsDialog
							.getSelectedCustomizations();

					if (loadCustomizationsDialog.isLoadRequiredFacetsSelected()) {
						// load facets corresponding to customizations
						loadFacetsForCustomizations(selectedCustomizations,
								customizationManager);
					}
					for (MetamodelView metamodelView : selectedCustomizations) {
						customizationManager
								.registerCustomization(metamodelView);
					}
					customizationManager.loadCustomizations();

					// Activator.getDefault().getCustomizationManager().loadCustomizations(selectedCustomizations);

				} catch (final Exception e) {
					Activator.getDefault().getLog().log(
							new Status(IStatus.ERROR, Activator.PLUGIN_ID,
									"Error initializing customizations", e)); //$NON-NLS-1$
				}
			}
			// load customizations defined as default through the customization
			// extension
			if (getCommonNavigator() != null) {
				getCommonNavigator().getCommonViewer().refresh();
			}
		}
		return null;
	}

	/**
	 * 
	 * @return the RessourceSet
	 */
	private DiResourceSet getDiResourceSet() {
		return EditorUtils.getDiResourceSet();
	}

	/**
	 * load the facets
	 * 
	 * @param customizations
	 *            list of customization
	 * @param customizationManager
	 *            the Customization Manager
	 */
	protected void loadFacetsForCustomizations(
			final List<MetamodelView> customizations,
			final CustomizationManager customizationManager) {
		final Set<Facet> referencedFacets = new HashSet<Facet>();
		final Collection<FacetSet> facetSets = FacetSetCatalog.getSingleton()
				.getAllFacetSets();

		for (MetamodelView customization : customizations) {
			String metamodelURI = customization.getMetamodelURI();
			// find customized FacetSet
			FacetSet customizedFacetSet = null;
			if (metamodelURI != null) {
				for (FacetSet facetSet : facetSets) {
					if (metamodelURI.equals(facetSet.getNsURI())) {
						customizedFacetSet = facetSet;
						break;
					}
				}
			}
			if (customizedFacetSet == null) {
				continue;
			}

			// find customized Facets
			EList<TypeView> types = customization.getTypes();
			for (TypeView typeView : types) {
				String metaclassName = typeView.getMetaclassName();
				Facet facet = findFacetWithFullyQualifiedName(metaclassName,
						customizedFacetSet);
				if (facet != null) {
					referencedFacets.add(facet);
				} else {
					MoDiscoBrowserPlugin
							.logWarning(NLS
									.bind(
											Messages.BrowserActionBarContributor_missingRequiredFacet,
											new Object[] {
													metaclassName,
													customizedFacetSet
															.getName(),
													customization.getName() }));
				}
			}

			for (Facet referencedFacet : referencedFacets) {
				customizationManager.loadFacet(referencedFacet);
			}
		}

		//
		// for modified facets
		// customizationManager.getInstancesForMetaclasses().buildDerivationTree();
		// customizationManager.getAppearanceConfiguration().touch();
		// customizationManager.refreshDelayed(true);
	}

	/**
	 * fin a facet from
	 * 
	 * @param metaclassName
	 * @param customizedFacetSet
	 * @return
	 */
	private Facet findFacetWithFullyQualifiedName(final String metaclassName,
			final FacetSet customizedFacetSet) {
		EList<Facet> facets = customizedFacetSet.getFacets();
		for (Facet facet : facets) {
			String facetName = getMetaclassQualifiedName(facet);
			if (metaclassName.equals(facetName)) {
				return facet;
			}
		}
		return null;
	}

	/** @return the qualified name of the given metaclass */
	public static String getMetaclassQualifiedName(final EClassifier eClass) {
		final ArrayList<String> qualifiedNameParts = new ArrayList<String>();
		final StringBuilder builder = new StringBuilder();

		EPackage ePackage = eClass.getEPackage();
		while (ePackage != null) {
			qualifiedNameParts.add(ePackage.getName());
			ePackage = ePackage.getESuperPackage();
		}

		for (int i = qualifiedNameParts.size() - 1; i >= 0; i--) {
			builder.append(qualifiedNameParts.get(i) + "."); //$NON-NLS-1$
		}

		builder.append(eClass.getName());

		return builder.toString();
	}

	/**
	 * Get the metmodel URI
	 * **/
	public String getMetamodelURI() {

		try {
			EList<EObject> contents = getDiResourceSet().getModelResource()
					.getContents();
			if (contents.size() > 0) {
				EObject eObject = contents.get(0);
				EClass eClass = eObject.eClass();
				if (eClass != null) {
					return eClass.getEPackage().getNsURI();
				}
			}
		} catch (Exception e) {
			Activator.log.error(e);
		}
		return ""; //$NON-NLS-1$
	}

}
