/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.validation;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Profile;

/**
 * A Helper for profile validation
 * 
 * @author Camille Letavernier
 * 
 */
public class ProfileValidationHelper {

	/**
	 * The Diagnostic source for Profile Application
	 * 
	 * @see Diagnostic#getSource()
	 */
	public static final String PROFILE_APPLICATION = "org.eclipse.papyrus.uml.profile.application";

	/**
	 * The profile-application specific error code for undefined profiles
	 * 
	 * @see #PROFILE_APPLICATION
	 * @see Diagnostic#getCode()
	 */
	public static final int PROFILE_NOT_DEFINED = 1;

	/**
	 * Check a set of profiles before application. Opens a diagnostic dialog in the given shell if problems are detected, and returns false
	 * Returns true and does nothing if all profiles are valid
	 * 
	 * The validator only checks profile definitions (i.e. check profile before application)
	 * 
	 * @param shell
	 *        The shell to display an error message to the user
	 * @param profiles
	 * @return
	 *         True if all profiles are valid; false if at least one profile is invalid
	 */
	public static boolean checkApplicableProfiles(Shell shell, Collection<Profile> profiles) {
		Diagnostic diagnostic = validateApplicableProfiles(profiles);
		if(diagnostic != null && diagnostic.getSeverity() == Diagnostic.ERROR) {
			DiagnosticDialog.openProblem(shell, "An error occurred during profile application", null, diagnostic);
			return false;
		}

		return true;
	}

	/**
	 * Creates a Diagnostic from a collection of profiles. The validator only checks profile definitions (i.e. check profile before application)
	 * 
	 * @param profilesToValidate
	 * @return
	 */
	public static Diagnostic validateApplicableProfiles(Collection<Profile> profilesToValidate) {
		if(profilesToValidate.isEmpty()) {
			return null;
		}

		BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.OK, PROFILE_APPLICATION, 0, "The following errors prevent the profile application:", new Object[0]);
		for(Profile profile : profilesToValidate) {
			validateApplicableProfile(profile, diagnostic);
		}

		if(diagnostic.getChildren().size() == 1) {
			return diagnostic.getChildren().get(0);
		}

		return diagnostic;
	}

	/**
	 * Validates a profile before application
	 * 
	 * @param profile
	 *        The profile to check
	 * @param diagnostic
	 *        in-out diagnostic for validation
	 */
	public static void validateApplicableProfile(Profile profile, BasicDiagnostic diagnostic) {
		if(profile != null) {
			EPackage definitionPackage = profile.getDefinition();
			if(definitionPackage == null) {
				String message = String.format("The profile %s is not defined", profile.getQualifiedName());
				BasicDiagnostic basicDiagnostic = new BasicDiagnostic(Diagnostic.ERROR, PROFILE_APPLICATION, PROFILE_NOT_DEFINED, message, new Object[]{ profile });
				diagnostic.merge(basicDiagnostic);
				return;
			}

			EditingDomain domain = EMFHelper.resolveEditingDomain(profile);
			AdapterFactory adapterFactory = domain instanceof AdapterFactoryEditingDomain ? ((AdapterFactoryEditingDomain)domain).getAdapterFactory() : null;
			Diagnostician diagnostician = createDiagnostician(adapterFactory, new NullProgressMonitor());
			Map<Object, Object> context = diagnostician.createDefaultContext();
			diagnostician.validate(definitionPackage, diagnostic, context);
		}
	}


	/**
	 * create a diagnostician to evaluate a profile
	 * 
	 * @param adapterFactory
	 * @param progressMonitor
	 * @return
	 */
	static Diagnostician createDiagnostician(final AdapterFactory adapterFactory, final IProgressMonitor progressMonitor) {
		return new Diagnostician() {

			@Override
			public String getObjectLabel(EObject eObject) {
				if(adapterFactory != null && !eObject.eIsProxy()) {
					IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(eObject, IItemLabelProvider.class);
					if(itemLabelProvider != null) {
						return itemLabelProvider.getText(eObject);
					}
				}
				return super.getObjectLabel(eObject);
			}

			@Override
			public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
				progressMonitor.worked(1);
				return super.validate(eClass, eObject, diagnostics, context);
			}
		};
	}


}
