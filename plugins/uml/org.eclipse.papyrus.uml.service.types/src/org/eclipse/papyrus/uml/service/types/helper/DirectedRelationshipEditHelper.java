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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.uml2.uml.DirectedRelationship;

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

	@Override
	protected ICommand getConfigureCommand(final ConfigureRequest req) {

		return new ConfigureElementCommand(req) {

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

		//		ICommand gmfCommand = null;
		//		EObject container = EMFCoreUtil.getLeastCommonContainer(
		//			terminals, SemanticPackage.eINSTANCE.getContainerElement());
	}
}
