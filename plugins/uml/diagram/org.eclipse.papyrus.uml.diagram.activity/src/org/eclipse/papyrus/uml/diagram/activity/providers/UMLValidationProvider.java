/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.uml.diagram.activity.providers;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IValidationListener;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.emf.validation.service.ValidationEvent;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.activity.helper.SafeDialogOpenerDuringValidation;
import org.eclipse.papyrus.uml.diagram.activity.helper.UMLValidationHelper;
import org.eclipse.papyrus.uml.diagram.activity.part.CustomMessages;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.ValuePin;

/**
 * @generated
 */
public class UMLValidationProvider {

	/**
	 * @generated
	 */
	private static boolean constraintsActive = false;

	/**
	 * Ids of constraints which report is already managed by themselves.
	 * 
	 * @generated NOT
	 */
	protected static final Collection<String> SELF_MANAGING_CONSTRAINTS = Arrays.asList("org.eclipse.papyrus.uml.diagram.activity.helper.PinAndParameterSynchronizer", "org.eclipse.papyrus.uml.diagram.activity.helper.ActivityParameterAndParameterSynchronizer");

	/**
	 * Validation listener which reports problems to the user
	 * 
	 * @generated NOT
	 */
	private static class ValidationReportListener implements IValidationListener {

		/**
		 * Report the validation result to the user in case operation did not fully succeed
		 * 
		 * @see org.eclipse.emf.validation.service.IValidationListener#validationOccurred(org.eclipse.emf.validation.service.ValidationEvent)
		 * 
		 * @param event
		 *        provides the validation operation results
		 * @generated NOT
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
						if(UMLDiagramEditorPlugin.ID.equals(constraintPlugin) && !handledConstraints.contains(constraintId)) {
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
							MessageDialog.openWarning(new Shell(Display.getDefault()), CustomMessages.UMLValidation_ErrorTitle, message);
							return null;
						}
					};
					opener.execute();
				} else {
					SafeDialogOpenerDuringValidation<Void> opener = new SafeDialogOpenerDuringValidation<Void>() {

						protected Void openDialog() {
							MessageDialog.openInformation(new Shell(Display.getDefault()), CustomMessages.UMLValidation_WarningTitle, message);
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
	 * 
	 * @generated NOT
	 */
	static {
		ModelValidationService.getInstance().addValidationListener(new ValidationReportListener());
	}

	/**
	 * @generated
	 */
	public static boolean shouldConstraintsBePrivate() {
		return false;
	}

	/**
	 * @generated
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
				UMLDiagramEditorPlugin.getInstance().logError("Validation failed", e); //$NON-NLS-1$
			}
		} else {
			task.run();
		}
	}

	/**
	 * @generated NOT filter for Papyrus editor only
	 */
	static boolean isInDefaultEditorContext(Object object) {
		if(shouldConstraintsBePrivate() && !constraintsActive) {
			return false;
		}
		if(object instanceof View) {
			return constraintsActive && ActivityDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID((View)object));
		}
		// filter for Papyrus editor only
		if(object instanceof EObject) {
			EObject eObj = (EObject)object;
			Resource resource = eObj.eResource();
			if(resource != null) {
				ResourceSet set = resource.getResourceSet();
				return set instanceof ModelSet;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static class DefaultCtx implements IClientSelector {

		/**
		 * @generated
		 */
		public boolean selects(Object object) {
			return isInDefaultEditorContext(object);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter7 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			ObjectNode context = (ObjectNode)ctx.getTarget();
			return UMLValidationHelper.validateInputOutputParameter(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter13 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			ValuePin context = (ValuePin)ctx.getTarget();
			return UMLValidationHelper.validateCompatibleType(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter16 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			ActivityEdge context = (ActivityEdge)ctx.getTarget();
			return UMLValidationHelper.validateSourceAndTarget(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter21 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			ObjectFlow context = (ObjectFlow)ctx.getTarget();
			return UMLValidationHelper.validateCompatibleTypes(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter22 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			ObjectFlow context = (ObjectFlow)ctx.getTarget();
			return UMLValidationHelper.validateSameUpperBounds(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter23 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			ObjectFlow context = (ObjectFlow)ctx.getTarget();
			return UMLValidationHelper.validateTarget(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter24 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			ObjectFlow context = (ObjectFlow)ctx.getTarget();
			return UMLValidationHelper.validateTransformationBehaviour(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter26 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			ObjectFlow context = (ObjectFlow)ctx.getTarget();
			return UMLValidationHelper.validateInputAndOutputParameter(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter34 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			DecisionNode context = (DecisionNode)ctx.getTarget();
			return UMLValidationHelper.validateIncomingObjectOneInputParameter(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter35 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			DecisionNode context = (DecisionNode)ctx.getTarget();
			return UMLValidationHelper.validateIncomingControlOneInputParameter(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter36 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			DecisionNode context = (DecisionNode)ctx.getTarget();
			return UMLValidationHelper.validateTwoInputParameters(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter62 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			ExceptionHandler context = (ExceptionHandler)ctx.getTarget();
			return UMLValidationHelper.validateException_HandlerBody_Constraint4(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter63 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			ActivityEdge context = (ActivityEdge)ctx.getTarget();
			return UMLValidationHelper.validateInterruptibleEdge(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter64 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			ExceptionHandler context = (ExceptionHandler)ctx.getTarget();
			return UMLValidationHelper.validateException_StructuredActivityNode_Constraint3(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter65 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			ExceptionHandler context = (ExceptionHandler)ctx.getTarget();
			return UMLValidationHelper.validateException_SourceAndTargetEdge_Constraint1(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter66 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			ActivityEdge context = (ActivityEdge)ctx.getTarget();
			return UMLValidationHelper.validateException_StructuredActivityNode_Constraint2(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	static String formatElement(EObject object) {
		return EMFCoreUtil.getQualifiedName(object, true);
	}
}
