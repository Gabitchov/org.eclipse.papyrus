/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.controlmode.profile.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.services.resourceloading.preferences.StrategyChooser;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.uml.controlmode.profile.Activator;
import org.eclipse.papyrus.uml.controlmode.profile.Messages;
import org.eclipse.papyrus.uml.controlmode.profile.helpers.ProfileApplicationHelper;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Check if profile application is correctly duplicated on all controlled sub-packages and duplicate it if needed.
 * In case of deletion, it also removes unnecessary profile applications.
 * 
 * @author vhemery
 */
public class ProfileApplicationDuplicationChecker extends AbstractModelConstraint {

	/**
	 * This is a result which is intended to be set with a boolean value with notification runables.
	 * 
	 * @author vhemery
	 */
	public class BooleanResult {

		boolean value = false;

		/**
		 * Get result
		 * 
		 * @return boolean result value
		 */
		public boolean getValue() {
			return value;
		}

		/**
		 * Set result
		 * 
		 * @param pValue
		 *        boolean result value
		 */
		public void setValue(boolean pValue) {
			value = pValue;
		}

	}

	/** Format String for a list entry */
	private static final String ENTRY_FORMAT = "<li>%s</li>";

	/** Constant for load all loading strategy */
	protected static final int LOAD_ALL_STRATEGY = 0;

	private IValidationContext lastValidatedContext = null;

	/**
	 * Check if profile applications are correctly duplicated on controlled package and that there is no useless copy left.
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 * 
	 * @param ctx
	 *        validation context
	 * @return validation status
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		try {
			if(ctx.equals(lastValidatedContext)) {
				return ctx.createSuccessStatus();
			} else {
				lastValidatedContext = ctx;
			}
			EObject eObject = ctx.getTarget();
			// detect profile application creation
			if((EMFEventType.ADD.equals(ctx.getEventType()) || EMFEventType.ADD_MANY.equals(ctx.getEventType())) && ctx.getFeatureNewValue() instanceof ProfileApplication) {
				ProfileApplication profileAppl = (ProfileApplication)ctx.getFeatureNewValue();
				Package pack = (Package)eObject;
				boolean res = stereotypeApplicationAdded(pack, profileAppl);
				if(!res) {
					return ctx.createFailureStatus();
				}
			}
			// detect profile application deletion
			else if(((EMFEventType.REMOVE.equals(ctx.getEventType()) && ctx.getFeatureNewValue() instanceof ProfileApplication) || EMFEventType.REMOVE_MANY.equals(ctx.getEventType()))) {
				Map<ProfileApplication, Profile> oldAssignement = new HashMap<ProfileApplication, Profile>(ctx.getAllEvents().size());
				for(Notification n : ctx.getAllEvents()) {
					// case when profile is removed from profile application : keep the reference
					if(ENotificationImpl.SET == n.getEventType() && UMLPackage.eINSTANCE.getProfileApplication_AppliedProfile().equals(n.getFeature()) && n.getNotifier() instanceof ProfileApplication) {
						Profile profile = (Profile)n.getOldValue();
						ProfileApplication profileAppl = (ProfileApplication)n.getNotifier();
						oldAssignement.put(profileAppl, profile);
					}
					// cases when profile application is removed
					if(ENotificationImpl.REMOVE == n.getEventType() && n.getOldValue() instanceof ProfileApplication && n.getNotifier() instanceof Package) {
						ProfileApplication profileAppl = (ProfileApplication)n.getOldValue();
						Package pack = (Package)n.getNotifier();
						Profile profile = profileAppl.getAppliedProfile();
						if(profile == null) {
							profile = oldAssignement.get(profileAppl);
						}
						if(profile != null) {
							boolean res = stereotypeApplicationRemoved(pack, profileAppl, profile);
							if(!res) {
								return ctx.createFailureStatus();
							}
						}
					}
				}

			}
			return ctx.createSuccessStatus();
		} catch (RuntimeException rte) {
			// avoid throwing uncaught exception which would disable the constraint
			Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.PLUGIN_ID, Messages.error_during_validation, rte));
			// ensure that the constraint's failure does not prevent modification
			return ctx.createSuccessStatus();
		}
	}

	/**
	 * Handle the case when a stereotype application is added :
	 * - Inspect controlled sub-packages
	 * - Duplicate profile applicationss on these
	 * - Create eAnnotation for duplicated profiles
	 * 
	 * @param packageElement
	 *        the package on which stereotype application has been added
	 * @param profileAppl
	 *        the added profile application
	 * @return whether addition is allowed
	 */
	private boolean stereotypeApplicationAdded(Package packageElement, ProfileApplication profileAppl) {
		//Inspect controlled sub-packages
		Set<Package> controlledPack = getControlledSubPackages(packageElement);
		boolean update = checkControlledPackagesUpdateable(controlledPack);
		if(update) {
			for(Package pack : controlledPack) {
				ProfileApplicationHelper.duplicateProfileApplication(pack, profileAppl.getAppliedProfile());
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Handle the case when a stereotype application is removed :
	 * - Forbid direct removal of a duplicated profile application (with eAnnotation)
	 * - Inspect controlled sub-packages
	 * - Remove duplicated profile applications on these (with eAnnotation)
	 * 
	 * @param packageElement
	 *        the package from which stereotype application has been removed
	 * @param profileAppl
	 *        the removed profile application
	 * @param profile
	 *        the unapplied profile
	 * @return whether removal is allowed
	 */
	private boolean stereotypeApplicationRemoved(Package packageElement, ProfileApplication profileAppl, Profile profile) {
		//Forbid direct removal of a duplicated profile application (with eAnnotation)
		if(ProfileApplicationHelper.isDuplicatedProfileApplication(profileAppl)) {
			Package parentPack = ProfileApplicationHelper.getParentPackageWithProfile(packageElement, profile, true);
			// restore stereotype application when it is called from parent intermediate package
			ProfileApplicationHelper.duplicateProfileApplication(packageElement, profile);
			String msg;
			if(parentPack != null) {
				msg = NLS.bind(Messages.warning_cannot_delete_duplicated, EMFCoreUtil.getQualifiedName(packageElement, true), EMFCoreUtil.getQualifiedName(parentPack, true));
			} else {
				// parent package can not be reached as it is in a different maybe not accessible resource (working on controlled resource)
				msg = NLS.bind(Messages.warning_cannot_delete_duplicated_alt, EMFCoreUtil.getQualifiedName(packageElement, true));
			}
			NotificationBuilder notifBuild = NotificationBuilder.createAsyncPopup(msg);
			notifBuild.run();
			return true;
		}
		//Inspect controlled sub-packages
		Set<Package> controlledPack = getControlledSubPackages(packageElement);
		boolean update = checkControlledPackagesUpdateable(controlledPack);
		if(update) {
			for(Package pack : controlledPack) {
				ProfileApplicationHelper.removeProfileApplicationDuplication(pack, profile, false);
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check if controlled sub-packages can be correctly updated :
	 * - Check if controlled package is loaded
	 * - Change the control strategy if necessary
	 * - Report error if the controlled package is read-only
	 * 
	 * @param controlledPackages
	 *        the controlled sub-packages (may be updated if contains proxies)
	 * @return true if can be updated
	 */
	private boolean checkControlledPackagesUpdateable(Set<Package> controlledPackages) {
		boolean notLoadedPackages = false;
		StringBuffer notLoadedPackagesList = new StringBuffer();
		boolean readOnlyPackages = false;
		StringBuffer readOnlyPackagesList = new StringBuffer();
		//Check if controlled package is loaded
		EditingDomain domain = null;
		for(Package pack : controlledPackages) {
			if(domain == null) {
				try {
					domain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(pack);
				} catch (ServiceException ex) {
					Activator.log.error(ex);
					return false;
				}
			}

			if(pack.eIsProxy()) {
				EObject loadedObject = domain.getResourceSet().getEObject(((InternalEObject)pack).eProxyURI(), true);
				if(loadedObject != null) {
					// pack has been reload, replace proxy;
					controlledPackages.remove(pack);
					pack = (Package)loadedObject;
					controlledPackages.add(pack);
				}
			}
			if(pack.eIsProxy()) {
				notLoadedPackages = true;
				URI uri = ((InternalEObject)pack).eProxyURI();
				String uriLastSeg = uri.lastSegment();
				String name = uriLastSeg.substring(0, uriLastSeg.length() - uri.fileExtension().length() - 1);
				String qualifName = EMFCoreUtil.getQualifiedName(pack.getOwner(), true).concat("::").concat(name);//$NON-NLS-1$
				notLoadedPackagesList.append(String.format(ENTRY_FORMAT, qualifName));
			} else {
				if(domain instanceof AdapterFactoryEditingDomain) {
					// reset read-only cache map
					((AdapterFactoryEditingDomain)domain).getResourceToReadOnlyMap().clear();
				}
				if(domain.isReadOnly(pack.eResource())) {
					readOnlyPackages = true;
					String name = EMFCoreUtil.getQualifiedName(pack, true);
					readOnlyPackagesList.append(String.format(ENTRY_FORMAT, name));
				}
			}
		}

		//Report error if the controlled package is read-only
		if(readOnlyPackages) {
			String msg = NLS.bind(Messages.error_readonly, readOnlyPackagesList.toString());
			NotificationBuilder notifBuild = NotificationBuilder.createErrorPopup(msg);
			notifBuild.setHTML(true);
			notifBuild.run();
			return false;
		}
		//Change the control strategy if necessary
		if(notLoadedPackages) {
			String msg = NLS.bind(Messages.switch_loading_strategy, notLoadedPackagesList.toString());
			final BooleanResult stategyChanged = new BooleanResult();
			Runnable runStrategySwitch = new Runnable() {

				public void run() {
					//TODO
					StrategyChooser.setCurrentStrategy(LOAD_ALL_STRATEGY);
					stategyChanged.setValue(true);
				}
			};
			Runnable cancel = new Runnable() {

				public void run() {
					stategyChanged.setValue(false);
				}
			};
			NotificationBuilder notifBuild = NotificationBuilder.createYesNo(msg, runStrategySwitch, cancel);
			notifBuild.setHTML(true);
			notifBuild.setAsynchronous(false);
			notifBuild.run();
			if(stategyChanged.getValue()) {
				// refresh set controlledPackages
				return checkControlledPackagesUpdateable(controlledPackages);
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * Get the controlled children packages
	 * 
	 * @param packageElement
	 *        package to inspect children
	 * @return set of children packages which are controlled
	 */
	private Set<Package> getControlledSubPackages(Package packageElement) {
		Set<Package> controlledPackages = new HashSet<Package>();
		TreeIterator<EObject> iterator = packageElement.eAllContents();
		while(iterator.hasNext()) {
			EObject child = iterator.next();
			if(child instanceof Package) {
				// despite what AdapterFactoryEditingDomain#isControlled says, a not loaded child is controlled
				if(AdapterFactoryEditingDomain.isControlled(child) || child.eIsProxy()) {
					controlledPackages.add((Package)child);
				}
			} else {
				iterator.prune();
			}
		}
		return controlledPackages;
	}
}
