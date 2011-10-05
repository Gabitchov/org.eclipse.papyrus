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
package org.eclipse.papyrus.controlmode.umlprofiles.providers;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IValidationListener;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.emf.validation.service.ValidationEvent;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.papyrus.controlmode.umlprofiles.Activator;
import org.eclipse.papyrus.controlmode.umlprofiles.helpers.SafeDialogOpenerDuringValidation;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;

/**
 * Provides validation for UML models
 */
public class UMLValidationProvider {

	/**
	 * Whether constraints are active
	 */
	private static boolean constraintsActive = false;

	/**
	 * Ids of constraints which report is already managed by themselves.
	 */
	protected static final Collection<String> SELF_MANAGING_CONSTRAINTS = Arrays.asList("org.eclipse.papyrus.controlmode.umlprofiles.validation.ProfileApplicationDuplicationChecker");

	/**
	 * Validation listener which reports problems to the user
	 */
	private static class ValidationReportListener implements IValidationListener {

		/**
		 * Report the validation result to the user in case operation did not fully succeed
		 * 
		 * @see org.eclipse.emf.validation.service.IValidationListener#validationOccurred(org.eclipse.emf.validation.service.ValidationEvent)
		 * 
		 * @param event
		 *        provides the validation operation results
		 */
		public void validationOccurred(ValidationEvent event) {
			boolean needReport = false;
			if(event.getSeverity() >= IStatus.WARNING) {
				needReport = true;
			}
			if(needReport && event.getEvaluationMode().isLive()) {
				StringBuffer messageBuff = new StringBuffer();
				List<String> handledConstraints = new LinkedList<String>(SELF_MANAGING_CONSTRAINTS);
				for(IConstraintStatus status : event.getValidationResults()) {
					// report only major problems
					if(status.getSeverity() >= event.getSeverity()) {
						String constraintId = status.getConstraint().getDescriptor().getId();
						String constraintPlugin = status.getConstraint().getDescriptor().getPluginId();
						if(Activator.PLUGIN_ID.equals(constraintPlugin) && !handledConstraints.contains(constraintId)) {
							handledConstraints.add(constraintId);
							messageBuff.append(status.getMessage());
						}
					}
				}
				if(messageBuff.length() == 0) {
					// no error to report
					return;
				}
				final String message = messageBuff.toString();
				if(event.getSeverity() >= IStatus.ERROR) {
					SafeDialogOpenerDuringValidation<Void> opener = new SafeDialogOpenerDuringValidation<Void>() {

						protected Void openDialog() {
							NotificationBuilder.createWarningPopup(message).run();
							return null;
						}
					};
					opener.execute();
				} else {
					SafeDialogOpenerDuringValidation<Void> opener = new SafeDialogOpenerDuringValidation<Void>() {

						protected Void openDialog() {
							NotificationBuilder.createInfoPopup(message).run();
							return null;
						}
					};
					opener.execute();
				}
			}
		}
	}

	/**
	 * Add a validation listener to report problems
	 */
	static {
		ModelValidationService.getInstance().addValidationListener(new ValidationReportListener());
	}

	/**
	 * Run an operation with checking of the constraints
	 * 
	 * @param editingDomain
	 *        editing domain
	 * @param operation
	 *        operation to run
	 */
	public static void runWithConstraints(TransactionalEditingDomain editingDomain, Runnable operation) {
		final Runnable op = operation;
		Runnable task = new Runnable() {

			public void run() {
				try {
					constraintsActive = true;
					op.run();
				} finally {
					constraintsActive = false;
				}
			}
		};
		if(editingDomain != null) {
			try {
				editingDomain.runExclusive(task);
			} catch (Exception e) {
				Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Validation failed", e));
			}
		} else {
			task.run();
		}
	}

	/**
	 * Context for validation
	 */
	public static class DefaultCtx implements IClientSelector {

		/**
		 * Indicate whether validation is activated
		 * 
		 * @see org.eclipse.emf.validation.model.IClientSelector#selects(java.lang.Object)
		 * 
		 * @param object
		 *        object to eventually validate
		 * @return true if validation is required
		 */
		public boolean selects(Object object) {
			if(constraintsActive) {
				return true;
			}
			if(object instanceof EObject) {
				EObject eObj = (EObject)object;
				ResourceSet set = eObj.eResource().getResourceSet();
				return set instanceof ModelSet;
			}
			return false;
		}
	}

	/**
	 * Format a model element
	 * 
	 * @param object
	 *        element to format
	 * @return text
	 */
	static String formatElement(EObject object) {
		return EMFCoreUtil.getQualifiedName(object, true);
	}

}
