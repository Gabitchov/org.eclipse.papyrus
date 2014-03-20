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
package org.eclipse.papyrus.views.modelexplorer.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
//import org.eclipse.papyrus.emf.facet.infra.browser.Messages;
//import org.eclipse.papyrus.emf.facet.infra.browser.custom.MetamodelView;
//import org.eclipse.papyrus.emf.facet.infra.browser.custom.TypeView;
//import org.eclipse.papyrus.emf.facet.infra.browser.uicore.CustomizationManager;
//import org.eclipse.papyrus.emf.facet.infra.facet.Facet;
//import org.eclipse.papyrus.emf.facet.infra.facet.FacetSet;
//import org.eclipse.papyrus.emf.facet.infra.facet.core.FacetSetCatalog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManagerFactory;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.dialog.ILoadCustomizationsDialog;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.exported.dialog.ILoadCustomizationsDialogFactory;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialogCallbackWithPreCommit;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.papyrus.infra.services.semantic.service.SemanticService;
import org.eclipse.papyrus.views.modelexplorer.Activator;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.dialog.PapyrusLoadBrowserCustomizationDialog;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * This is a class that launches the button load Customization. this code comes
 * from the {@link LoadCustomizationsDialog}
 */
public class LoadBrowserCustomization extends AbstractHandler {

	/**
	 * 
	 * 
	 * @return the common navigator
	 */
	protected CommonNavigator getCommonNavigator() {
		IViewPart part = org.eclipse.papyrus.views.modelexplorer.NavigatorUtils.findViewPart(ModelExplorerPageBookView.VIEW_ID);
		// the part is only a book, retrieving correct page
		if(part instanceof ModelExplorerPageBookView) {
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

		if(Activator.getDefault().getCustomizationManager() != null) {
			ICustomizationManager customizationManager = Activator.getDefault().getCustomizationManager();
			final List<Customization> registeredCustomizations = ICustomizationCatalogManagerFactory.DEFAULT.getOrCreateCustomizationCatalogManager(customizationManager.getResourceSet()).getRegisteredCustomizations();

			PapyrusLoadBrowserCustomizationDialog loadCustomizationsDialog;


			Shell shell = HandlerUtil.getActiveShell(event);
			IDialogCallbackWithPreCommit<List<Customization>, Boolean, Dialog> dialogCallBack= new IDialogCallbackWithPreCommit<List<Customization>, Boolean, Dialog>() {

				public void committed(List<Customization> result, Boolean precommitResult) {
					// TODO Auto-generated method stub

				}

				public Dialog openPrecommitDialog(List<Customization> result, IDialogCallback<Boolean> precommitCallback) {
					// TODO Auto-generated method stub
					return null;
				}
			};
			ILoadCustomizationsDialog dialog=ILoadCustomizationsDialogFactory.DEFAULT.createLoadCustomizationDialog(shell, registeredCustomizations, customizationManager.getManagedCustomizations(), dialogCallBack);

			if(Window.OK == dialog.open()) {
				customizationManager.getManagedCustomizations().clear();
				customizationManager.getManagedCustomizations().addAll(	dialog.getSelectedCustomizations());


				//Save the current state of the customizations
				org.eclipse.papyrus.infra.emf.Activator.getDefault().saveCustomizationManagerState();
			}

			//			// load customizations defined as default through the customization
			//			// extension
			if(getCommonNavigator() != null) {
				getCommonNavigator().getCommonViewer().refresh();
			}
		}

		return null;
	}

	/**
	 * 
	 * @return the RessourceSet
	 */
	private ModelSet getModelSet() {
		return ModelUtils.getModelSet();
	}

	//	/**
	//	 * load the facets
	//	 * 
	//	 * @param customizations
	//	 *        list of customization
	//	 * @param customizationManager
	//	 *        the Customization Manager
	//	 */
	//	protected void loadFacetsForCustomizations(final List<MetamodelView> customizations, final CustomizationManager customizationManager) {
	//		final Set<Facet> referencedFacets = new HashSet<Facet>();
	//		final Collection<FacetSet> facetSets = FacetSetCatalog.getSingleton().getAllFacetSets();
	//
	//		for(MetamodelView customization : customizations) {
	//			String metamodelURI = customization.getMetamodelURI();
	//			// find customized FacetSet
	//			FacetSet customizedFacetSet = null;
	//			if(metamodelURI != null) {
	//				for(FacetSet facetSet : facetSets) {
	//					if(metamodelURI.equals(facetSet.getNsURI())) {
	//						customizedFacetSet = facetSet;
	//						break;
	//					}
	//				}
	//			}
	//			if(customizedFacetSet == null) {
	//				continue;
	//			}
	//
	//			// find customized Facets
	//			EList<TypeView> types = customization.getTypes();
	//			for(TypeView typeView : types) {
	//				String metaclassName = typeView.getMetaclassName();
	//				Facet facet = findFacetWithFullyQualifiedName(metaclassName, customizedFacetSet);
	//				if(facet != null) {
	//					referencedFacets.add(facet);
	//				} else {
	//					Activator.log.warn(NLS.bind(Messages.BrowserActionBarContributor_missingRequiredFacet, new Object[]{ metaclassName, customizedFacetSet.getName(), customization.getName() }));
	//				}
	//			}
	//
	//			for(Facet referencedFacet : referencedFacets) {
	//				customizationManager.loadFacet(referencedFacet);
	//			}
	//		}

	//
	// for modified facets
	// customizationManager.getInstancesForMetaclasses().buildDerivationTree();
	// customizationManager.getAppearanceConfiguration().touch();
	// customizationManager.refreshDelayed(true);
	//}

	//	/**
	//	 * fin a facet from
	//	 * 
	//	 * @param metaclassName
	//	 * @param customizedFacetSet
	//	 * @return
	//	 */
	//	private Facet findFacetWithFullyQualifiedName(final String metaclassName, final FacetSet customizedFacetSet) {
	//		EList<Facet> facets = customizedFacetSet.getFacets();
	//		for(Facet facet : facets) {
	//			String facetName = getMetaclassQualifiedName(facet);
	//			if(metaclassName.equals(facetName)) {
	//				return facet;
	//			}
	//		}
	//		return null;
	//	}

	/** @return the qualified name of the given metaclass */
	public static String getMetaclassQualifiedName(final EClassifier eClass) {
		final ArrayList<String> qualifiedNameParts = new ArrayList<String>();
		final StringBuilder builder = new StringBuilder();

		EPackage ePackage = eClass.getEPackage();
		while(ePackage != null) {
			qualifiedNameParts.add(ePackage.getName());
			ePackage = ePackage.getESuperPackage();
		}

		for(int i = qualifiedNameParts.size() - 1; i >= 0; i--) {
			builder.append(qualifiedNameParts.get(i) + "."); //$NON-NLS-1$
		}

		builder.append(eClass.getName());

		return builder.toString();
	}

	//	/**
	//	 * Get the metmodel URI
	//	 * **/
	//@Unused
	//	private String getMetamodelURI() {
	//
	//		try {
	//			EList<EObject> contents = UmlUtils.getUmlResource(getModelSet()).getContents();
	//			if(contents.size() > 0) {
	//				EObject eObject = contents.get(0);
	//				EClass eClass = eObject.eClass();
	//				if(eClass != null) {
	//					return eClass.getEPackage().getNsURI();
	//				}
	//			}
	//		} catch (Exception e) {
	//			Activator.log.error(e);
	//		}
	//		return ""; //$NON-NLS-1$
	//	}

	/**
	 * Get the metmodel URI
	 * **/
	protected List<EPackage> getMetamodels(ServicesRegistry serviceRegistry) {
		List<EPackage> ePackages = new ArrayList<EPackage>();

		/*
		 * we look for the current editors, because their are represented in the model explorer
		 * using specific facet and uiCustom. (see bug 359692)
		 */
		IPageManager pageMngr = null;
		try {
			pageMngr = ServiceUtils.getInstance().getIPageManager(serviceRegistry);
			List<Object> pages = pageMngr.allPages();
			for(int i = 0; i < pages.size(); i++) {
				if(pages.get(i) instanceof EObject) {
					EPackage ePackage = ((EObject)pages.get(i)).eClass().getEPackage();
					if(!ePackages.contains(ePackage)) {
						ePackages.add(ePackage);
					}
				}
			}
		} catch (ServiceException e) {
			Activator.log.error(e);
		}

		try {
			SemanticService semantic = serviceRegistry.getService(SemanticService.class);
			for(EObject rootElement : semantic.getSemanticRoots()) {
				EClass eClass = rootElement.eClass();
				if(eClass != null) {
					EPackage ePackage = eClass.getEPackage();
					if(!ePackages.contains(ePackage)) {
						ePackages.add(eClass.getEPackage());
					}
				}
			}
		} catch (ServiceException ex) {
			Activator.log.error(ex);
		}
		return ePackages;
	}

}
