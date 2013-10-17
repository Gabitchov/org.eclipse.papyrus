package org.eclipse.papyrus.sysml.diagram.parametric.commands;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CustomContextLinkCreateCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ContextLinkEditPart;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Property;

public class CustomParametricContextLinkCreateCommand extends
		CustomContextLinkCreateCommand {

	public CustomParametricContextLinkCreateCommand(
			CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);
	}

	@Override
	public boolean canExecute() {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && (false == source instanceof Constraint)) {
			return false;
		}
		if(target != null && !(target instanceof Namespace)) {
			if (target instanceof Property && !(((Property) target).getType() instanceof Namespace)) {
				// Part / Reference / ConstraintProperty
				return false;
			}
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		View viewSource = findView(source);
		
		if(viewSource != null && source instanceof Constraint) {
			View viewTarget = findView(target);
			List<?> sourceConnections = ViewUtil.getSourceConnections(viewSource);
			
			for(Object connector : sourceConnections) {
				if(!(connector instanceof Connector)) {
					continue;
				}
				Edge edge = (Edge)connector;

				if(("" + ContextLinkEditPart.VISUAL_ID).equals(edge.getType())) {
					if(viewTarget == edge.getTarget()) {
						// the context link is already
						//  drawn between the Constraint and the NamedElement
						return false;
					}
				}
			}
		}
				
		if(resolveTargetNamespace() != null && (resolveTargetNamespace().getOwnedRules().contains(resolveTargetNamespace()))) {
			return false;
		}
		return true;
	}
	
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		Namespace context = resolveTargetNamespace();
		if(getSource() != null && context != null) {
			getSource().setContext(context);
			String defaultNameWithIncrementFromBase = NamedElementHelper.getDefaultNameWithIncrementFromBase(Constraint.class.getSimpleName(), context.getOwnedRules());
			getSource().setName(defaultNameWithIncrementFromBase);
			return CommandResult.newOKCommandResult();
		}		
		else {
			return CommandResult.newErrorCommandResult("Try to define Constraint context to a non Namespace element");			
		}
	}

	private View findView(EObject element) {
		if(element == null) {
			return null;
		}
		Collection<Setting> settings = CacheAdapter.getInstance().getNonNavigableInverseReferences(element);
		for(Setting ref : settings) {
			if(NotationPackage.eINSTANCE.getView_Element().equals(ref.getEStructuralFeature())) {
				View view = (View)ref.getEObject();
				if(view != null) {
					return view;
				}
			}
		}
		return null;
	}
	
	/**
	 * @generated
	 */
	protected Namespace resolveTargetNamespace() {
		EObject targetNamespace;
		if (target instanceof Property) {
			targetNamespace = ((Property) target).getType();
		}
		else {
			targetNamespace = target;
		}
		if (targetNamespace instanceof Namespace) {		
			return (Namespace)targetNamespace;
		}
		else {
			return null;
		}
	}
}
