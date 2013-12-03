/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
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
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.custom.command.CustomContextLinkCreateCommand;
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

	/**
	 * Can execute if :
	 * - source is Constraint
	 * - target is a Namespace or a Namespace typed property
	 * - there is no context link already outgoing from the source Constraint
	 */
	@Override
	public boolean canExecute() {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && !(source instanceof Constraint)) {
			return false;
		}
		if(target != null && !(target instanceof Namespace)) {
			if (target instanceof Property) {
				if (!(((Property) target).getType() instanceof Namespace)) {
					// not a Part / Reference / ConstraintProperty => could not create context link
					return false;
				}
			}
			else {
				// not a Property, not a Namespace => could not create context link
				return false;
			}
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		View viewSource = findView(source);
		
		// Only one context link per Constraint
		if(viewSource != null && source instanceof Constraint) {
			List<?> sourceConnections = ViewUtil.getSourceConnections(viewSource);
			if (!sourceConnections.isEmpty()) {
				return false;
			}
		}		
		return true;
	}
	
	/**
	 * Set the Constraint context and update Constraint name with new owner ownedRules if necessary
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		Namespace context = resolveTargetNamespace();
		if(getSource() != null && context != null) {
			getSource().setContext(context);
			String defaultNameWithIncrementFromBase = NamedElementHelper.getDefaultNameWithIncrementFromBase(Constraint.class.getSimpleName(), context.getOwnedRules(), getSource());
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
	 * Get the property Namespace in case of property typed by a Namespace
	 */
	@Override
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
