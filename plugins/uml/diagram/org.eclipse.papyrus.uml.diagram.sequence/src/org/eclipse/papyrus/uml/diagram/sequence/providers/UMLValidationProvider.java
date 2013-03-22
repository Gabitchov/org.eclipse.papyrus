package org.eclipse.papyrus.uml.diagram.sequence.providers;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ITraversalStrategy;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragment2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionOperandEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message3EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message5EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message6EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message7EditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.validation.UMLValidationHelper;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionOperand;

/**
 * @generated
 */
public class UMLValidationProvider {

	/**
	 * @generated
	 */
	private static boolean constraintsActive = false;

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
	 * @generated
	 */
	static boolean isInDefaultEditorContext(Object object) {
		if(shouldConstraintsBePrivate() && !constraintsActive) {
			return false;
		}
		if(object instanceof View) {
			return constraintsActive && PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID((View)object));
		}
		return true;
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
	public static class Ctx_3001 implements IClientSelector {

		/**
		 * @generated NOT select all moved edit parts which are linked to an occurrence specification
		 */
		public boolean selects(Object object) {
			if(object instanceof Bounds) {
				// validate on resize or move
				object = ((Bounds)object).eContainer();
			}
			if(object instanceof View && PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID((View)object))) {
				final int id = UMLVisualIDRegistry.getVisualID((View)object);
				boolean result = false;
				// Lifeline
				result = result || id == LifelineEditPart.VISUAL_ID;
				// ES
				result = result || id == ActionExecutionSpecificationEditPart.VISUAL_ID;
				result = result || id == BehaviorExecutionSpecificationEditPart.VISUAL_ID;
				// CF and Interaction operands
				result = result || id == CombinedFragmentEditPart.VISUAL_ID;
				result = result || id == CombinedFragment2EditPart.VISUAL_ID;
				result = result || id == InteractionOperandEditPart.VISUAL_ID;
				// Time related : do nothing, the real event support will be also moved
				//result = result || id == TimeConstraintEditPart.VISUAL_ID;
				//result = result || id == TimeObservationEditPart.VISUAL_ID;
				//result = result || id == DurationConstraintEditPart.VISUAL_ID;
				//result = result || id == DurationObservationEditPart.VISUAL_ID;
				// Messages
				result = result || id == MessageEditPart.VISUAL_ID;
				result = result || id == Message2EditPart.VISUAL_ID;
				result = result || id == Message3EditPart.VISUAL_ID;
				result = result || id == Message4EditPart.VISUAL_ID;
				result = result || id == Message5EditPart.VISUAL_ID;
				result = result || id == Message6EditPart.VISUAL_ID;
				result = result || id == Message7EditPart.VISUAL_ID;
				// General Ordering : do nothing, the real event support will be also moved
				//result = result || id == GeneralOrderingEditPart.VISUAL_ID;
				return result;
			}
			return false;
		}
	}

	/**
	 * @generated
	 */
	public static ITraversalStrategy getNotationTraversalStrategy(IBatchValidator validator) {
		return new CtxSwitchStrategy(validator);
	}

	/**
	 * @generated
	 */
	private static class CtxSwitchStrategy implements ITraversalStrategy {

		/**
		 * @generated
		 */
		private ITraversalStrategy defaultStrategy;

		/**
		 * @generated
		 */
		private int currentSemanticCtxId = -1;

		/**
		 * @generated
		 */
		private boolean ctxChanged = true;

		/**
		 * @generated
		 */
		private EObject currentTarget;

		/**
		 * @generated
		 */
		private EObject preFetchedNextTarget;

		/**
		 * @generated
		 */
		private final int[] contextSwitchingIdentifiers;

		/**
		 * @generated
		 */
		CtxSwitchStrategy(IBatchValidator validator) {
			this.defaultStrategy = validator.getDefaultTraversalStrategy();
			this.contextSwitchingIdentifiers = new int[]{ LifelineEditPart.VISUAL_ID };
			Arrays.sort(this.contextSwitchingIdentifiers);
		}

		/**
		 * @generated
		 */
		public void elementValidated(EObject element, IStatus status) {
			defaultStrategy.elementValidated(element, status);
		}

		/**
		 * @generated
		 */
		public boolean hasNext() {
			return defaultStrategy.hasNext();
		}

		/**
		 * @generated
		 */
		public boolean isClientContextChanged() {
			if(preFetchedNextTarget == null) {
				preFetchedNextTarget = next();
				prepareNextClientContext(preFetchedNextTarget);
			}
			return ctxChanged;
		}

		/**
		 * @generated
		 */
		public EObject next() {
			EObject nextTarget = preFetchedNextTarget;
			if(nextTarget == null) {
				nextTarget = defaultStrategy.next();
			}
			this.preFetchedNextTarget = null;
			return this.currentTarget = nextTarget;
		}

		/**
		 * @generated
		 */
		public void startTraversal(Collection traversalRoots, IProgressMonitor monitor) {
			defaultStrategy.startTraversal(traversalRoots, monitor);
		}

		/**
		 * @generated
		 */
		private void prepareNextClientContext(EObject nextTarget) {
			if(nextTarget != null && currentTarget != null) {
				if(nextTarget instanceof View) {
					final int id = UMLVisualIDRegistry.getVisualID((View)nextTarget);
					int nextSemanticId = (id != -1 && Arrays.binarySearch(contextSwitchingIdentifiers, id) >= 0) ? id : -1;
					if((currentSemanticCtxId != -1 && currentSemanticCtxId != nextSemanticId) || (nextSemanticId != -1 && nextSemanticId != currentSemanticCtxId)) {
						this.ctxChanged = true;
					}
					currentSemanticCtxId = nextSemanticId;
				} else {
					// context of domain model
					this.ctxChanged = currentSemanticCtxId != -1;
					currentSemanticCtxId = -1;
				}
			} else {
				this.ctxChanged = false;
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter1 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Interaction context = (Interaction)ctx.getTarget();
			return UMLValidationHelper.validateFragmentsOrder(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter2 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			InteractionOperand context = (InteractionOperand)ctx.getTarget();
			return UMLValidationHelper.validateFragmentsOrder(context, ctx);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter3 extends AbstractModelConstraint {

		/**
		 * @generated NOT do not presume on target type
		 */
		public IStatus validate(IValidationContext ctx) {
			// do not presume on target type
			EObject target = ctx.getTarget();
			return UMLValidationHelper.validateFragmentsOrder(target, ctx);
		}
	}

	/**
	 * @generated
	 */
	static String formatElement(EObject object) {
		return EMFCoreUtil.getQualifiedName(object, true);
	}
}
