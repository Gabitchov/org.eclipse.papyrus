/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import java.util.Arrays;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.IdentityCommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This abstract helper is used to set the source and the target for a {@link DirectedRelationship}
 */
public abstract class DirectedRelationshipEditHelper extends ElementEditHelper {

	/**
	 * Subclasses should implement this method providing the EReference to be used as source.
	 * 
	 * @return the source EReference
	 */
	protected abstract EReference getSourceReference();

	/**
	 * Subclasses should implement this method providing the EReference to be used as target.
	 * 
	 * @return the target EReference
	 */
	protected abstract EReference getTargetReference();

	/**
	 * Test if the relationship creation is allowed.
	 * 
	 * @param source
	 *        the relationship source can be null
	 * @param target
	 *        the relationship target can be null
	 * @return true if the creation is allowed
	 */
	protected abstract boolean canCreate(EObject source, EObject target);

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {

		EObject source = req.getSource();
		EObject target = req.getTarget();

		boolean noSourceOrTarget = (source == null || target == null);
		boolean noSourceAndTarget = (source == null && target == null);

		if (!noSourceAndTarget && !canCreate(source, target)) {
			// Abort creation.
			return UnexecutableCommand.INSTANCE;
		}
		
		if(noSourceOrTarget && !noSourceAndTarget) {
			// The request isn't complete yet. Return the identity command so
			// that the create relationship gesture is enabled.
			return IdentityCommand.INSTANCE;
		}
		
		// Propose a container if none is set in request.
		EObject proposedContainer = EMFCoreUtil.getLeastCommonContainer(Arrays.asList(new EObject[]{source, target}), UMLPackage.eINSTANCE.getPackage());

		// If no common container is found try source nearest package
		EObject sourcePackage = EMFCoreUtil.getContainer(source, UMLPackage.eINSTANCE.getPackage());
		if ((proposedContainer == null) && !(isReadOnly(sourcePackage))) {
			proposedContainer = sourcePackage;
		}

		// If no common container is found try target nearest package
		EObject targetPackage = EMFCoreUtil.getContainer(target, UMLPackage.eINSTANCE.getPackage());
		if ((proposedContainer == null) && !(isReadOnly(targetPackage))) {
			proposedContainer = targetPackage;
		}
		
		req.setContainer(proposedContainer);
		
		return new CreateRelationshipCommand(req);
	}

	private boolean isReadOnly(EObject eObject) {
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		boolean isReadOnly = (eObject.eResource() != null) && (editingDomain.isReadOnly(eObject.eResource()));
		
		return isReadOnly;
	}

	/**
	 * This method provides the object to be use as source.
	 * 
	 * @return the source value (EList or EObject)
	 */
	protected Object getSourceObject(ConfigureRequest req) {
		Object result = null;
		if(getSourceReference().getUpperBound() != 1) {
			EList<EObject> objects = new BasicEList<EObject>();
			objects.add((EObject)req.getParameter(CreateRelationshipRequest.SOURCE));

			result = objects;
		} else {
			result = req.getParameter(CreateRelationshipRequest.SOURCE);
		}

		return result;
	}

	/**
	 * This method provides the object to be used as target.
	 * 
	 * @return the target value (EList or EObject)
	 */
	protected Object getTargetObject(ConfigureRequest req) {
		Object result = null;
		if(getTargetReference().getUpperBound() != 1) {
			EList<EObject> objects = new BasicEList<EObject>();
			objects.add((EObject)req.getParameter(CreateRelationshipRequest.TARGET));

			result = objects;
		} else {
			result = req.getParameter(CreateRelationshipRequest.TARGET);
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getConfigureCommand(final ConfigureRequest req) {

		ICommand configureCommand = new ConfigureElementCommand(req) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				DirectedRelationship element = (DirectedRelationship)req.getElementToConfigure();

				if(req.getParameter(CreateRelationshipRequest.SOURCE) != null) {
					element.eSet(getSourceReference(), getSourceObject(req));
				}

				if(req.getParameter(CreateRelationshipRequest.TARGET) != null) {
					element.eSet(getTargetReference(), getTargetObject(req));
				}

				return CommandResult.newOKCommandResult(element);
			}
		};

		return CompositeCommand.compose(configureCommand, super.getConfigureCommand(req));
	}
}
