/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.qompass.designer.core.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * This class adds the FCM profile, parts of the MARTE profile and required package imports to your model.
 */
public class AddProfileAndModelLibsHandler extends CmdHandler {

	public static final String FCM_PROFILE_URI = "pathmap://FCM_PROFILES/FCM.profile.uml"; //$NON-NLS-1$

	public static final String MARTE_PROFILE_URI = "pathmap://Papyrus_PROFILES/MARTE.profile.uml";//$NON-NLS-1$

	public static final String EC3M_BASIC_CALLS_URI = "pathmap://QML_CORE/core.uml"; //$NON-NLS-1$

	public static final String EC3M_MARTE_CALLS_URI = "pathmap://QML_MARTE/marte.uml"; //$NON-NLS-1$

	static final String MARTE_FOUNDATIONS = "MARTE_Foundations"; //$NON-NLS-1$
	
	static final String MARTE_F_ALLOC = "Alloc"; //$NON-NLS-1$
	
	static final String MARTE_DESIGN_MODEL = "MARTE_DesignModel"; //$NON-NLS-1$

	static final String MARTE_DM_HLAM ="HLAM"; //$NON-NLS-1$
	
	static final String MARTE_DM_GCM ="GCM"; //$NON-NLS-1$
	
	public static final int APPLY_FCM = 1;

	public static final int APPLY_ALLOC = 2;

	public static final int APPLY_HLAM_GCM = 4;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		EObject selectedObj = getSelectedEObject();
		if(selectedObj instanceof Package) {
			return true;
		}
		return false;
	}

	/**
	 * Retrieve a model library from the repository
	 * 
	 * @param uri
	 *        the URI of the repository
	 * 
	 * @return
	 */
	public PackageImport getModelLibraryImportFromURI(URI uri, ResourceSet resourceSet) {
		// Try to reach model
		Element root = getContent(uri, resourceSet);
		if(root instanceof Package) {

			// Import model library
			Package libToImport = (Package)root;
			// create import package
			PackageImport modelLibImport = UMLFactory.eINSTANCE.createPackageImport();
			modelLibImport.setImportedPackage(libToImport);

			return modelLibImport;
		}
		return null;
	}

	public static Element getContent(URI uri, ResourceSet rs) {
		// Resource resource = getTransactionalEditingDomain ().getResourceSet().getResource (uri, true);
		Resource resource = rs.getResource(uri, true);
		return getContent(resource);
	}

	public static Element getContent(Resource resource) {
		EList<EObject> contentObj = resource.getContents();
		if((contentObj.size() > 0) && (contentObj.get(0) instanceof Element)) {
			return (Element)contentObj.get(0);
		}
		return null;
	}

	/**
	 * Check whether a package import is already done
	 * 
	 * @param selectedPkg
	 * @param pi
	 * @return
	 */
	boolean isAlreadyImported(Package selectedPkg, PackageImport pi) {
		for(PackageImport existingPI : selectedPkg.getPackageImports()) {
			if((existingPI.getImportedPackage() == null) ||
				(pi.getImportedPackage() == null)) {
				// import package are null (should not happen?!)
				continue;
			}
			if((existingPI.getImportedPackage().getName() == null) ||
				(pi.getImportedPackage().getName() == null)) {
				// import package name not set (should not happen?!)
				continue;
			} else if(existingPI.getImportedPackage().getName().equals(pi.getImportedPackage().getName())) {
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(!(getSelectedEObject() instanceof Package)) {
			return null;
		}
		final Package selectedPkg = (Package)getSelectedEObject();

		final TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(selectedPkg);
		final ResourceSet resourceSet = selectedPkg.eResource().getResourceSet();

		CommandStack stack = domain.getCommandStack();
		PackageImport pi = getModelLibraryImportFromURI(URI.createURI(EC3M_BASIC_CALLS_URI), resourceSet);
		EList<Object> list = new BasicEList<Object>();
		EList<Object> selection = new BasicEList<Object>();
		if(pi != null) {
			list.add(pi);
			if(isAlreadyImported(selectedPkg, pi)) {
				selection.add(pi);
			}
		}
		pi = getModelLibraryImportFromURI(URI.createURI(EC3M_MARTE_CALLS_URI), resourceSet);
		if(pi != null) {
			list.add(pi);
			if(isAlreadyImported(selectedPkg, pi)) {
				selection.add(pi);
			}
		}
		final ListSelectionDialog dialog = new ListSelectionDialog(new Shell(),
			list.toArray(),
			new ArrayContentProvider(),
			new LabelProvider() {

				public String getText(Object pi) {
					return ((PackageImport)pi).getImportedPackage().getName();
				}
			},
			"Select Qompass model libraries for package import.\n" + //$NON-NLS-1$
				"Libraries that are already imported, are selected. Please note that additional\n" + //$NON-NLS-1$
				"Qompass model library might be loaded with the standard \"import registered library\" option\n" + //$NON-NLS-1$
				"\n" +//$NON-NLS-1$
				"Pressing \"Ok\" will continue with the application of the FCM profile and (parts of) the MARTE profile\n");//$NON-NLS-1$

		dialog.setTitle("Select import library"); //$NON-NLS-1$
		dialog.setInitialElementSelections(selection);
		// dialog.setElements (list.toArray ());
		int result = dialog.open();
		if(result == IDialogConstants.OK_ID) {
			stack.execute(new RecordingCommand(domain, "Add libraries and profiles") //$NON-NLS-1$
			{
				public void doExecute() {
					// add primitive types			
					// create import package to primitiveType
					// PackageImport pi = getModelLibraryImportFromURI (URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI));
					// selectedPkg.getPackageImports().add(pi);

					for(Object obj : dialog.getResult()) {
						PackageImport pi = (PackageImport)obj;
						if(!isAlreadyImported(selectedPkg, pi)) {
							selectedPkg.getPackageImports().add(pi);
						}
					}
					addProfiles(selectedPkg, APPLY_FCM | APPLY_ALLOC | APPLY_HLAM_GCM);
				}
			});
		}
		return null;
	}

	public static void addProfiles(Package selectedPkg, int applyCode) {

		final ResourceSet resourceSet = selectedPkg.eResource().getResourceSet();
		
		try {
			/*
			 * // Apply UML Standard profile
			 * // Retrieve standard profile
			 * Profile umlStdProfile =
			 * (Profile) getContent (URI.createURI(UMLResource.STANDARD_PROFILE_URI));
			 * // Apply to new model
			 * umlModel.applyProfile(umlStdProfile);
			 */

			if((applyCode & APPLY_FCM) != 0) {
				// Retrieve FCM profile
				Profile fcmProfile =
					(Profile)getContent(URI.createURI(FCM_PROFILE_URI), resourceSet);

				// Apply FCM profile and its nested profiles to new model
				if(fcmProfile instanceof Profile) {
					Profile profile = selectedPkg.getAppliedProfile(fcmProfile.getQualifiedName());
					if((profile == null) && (!fcmProfile.getOwnedStereotypes().isEmpty())) {
						selectedPkg.applyProfile(fcmProfile);
					}
				}
				else {
					MessageDialog.openWarning(new Shell(),
						"Warning", //$NON-NLS-1$
						"The FCM profile is not available."); //$NON-NLS-1$
				}
			}

			if((applyCode & (APPLY_ALLOC | APPLY_HLAM_GCM)) != 0) {
				// Retrieve MARTE profile
				Profile marteProfile =
					(Profile)getContent(URI.createURI(MARTE_PROFILE_URI), resourceSet);

				// Apply MARTE::MARTE_DesignModel::HLAM
				//     & MARTE::MARTE_DesignModel::GCM
				if(marteProfile != null) {
					PackageableElement foundationModel = marteProfile.getPackagedElement(MARTE_FOUNDATIONS);
					if((foundationModel instanceof Package) && ((applyCode & APPLY_ALLOC) != 0)) {
						PackageableElement alloc = ((Package)foundationModel).getPackagedElement(MARTE_F_ALLOC);

						// if(selectedPkg.getAppliedProfile(alloc.getQualifiedName()) == null) {
						selectedPkg.applyProfile((Profile)alloc);
						// }
					}
					PackageableElement designModel = marteProfile.getPackagedElement(MARTE_DESIGN_MODEL);
					if((designModel instanceof Package) && ((applyCode & APPLY_HLAM_GCM) != 0)) {
						PackageableElement hlam = ((Package)designModel).getPackagedElement(MARTE_DM_HLAM);
						if(hlam instanceof Profile) {
							// if(selectedPkg.getAppliedProfile(hlam.getQualifiedName()) == null) {
							selectedPkg.applyProfile((Profile)hlam);
							// }
						}
						PackageableElement gcm = ((Package)designModel).getPackagedElement(MARTE_DM_GCM);
						if(gcm instanceof Profile) {
							// if(selectedPkg.getAppliedProfile(gcm.getQualifiedName()) == null) {
							selectedPkg.applyProfile((Profile)gcm);
							// }
						}
					}
				}
				else {
					MessageDialog.openWarning(new Shell(),
						"Warning", "The MARTE profile is not available."); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
