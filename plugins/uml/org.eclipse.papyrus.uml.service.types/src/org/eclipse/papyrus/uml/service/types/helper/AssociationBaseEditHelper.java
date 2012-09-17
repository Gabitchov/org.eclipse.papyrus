/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.IdentityCommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.service.types.command.AssociationReorientCommand;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Edit helper class for binary {@link Association}
 */
public class AssociationBaseEditHelper extends ElementEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return new AssociationReorientCommand(req);
	}

	/**
	 * This method provides the source type provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target role
	 */
	private Classifier getSourceOwnerType(ConfigureRequest req) {
		Classifier result = null;
		Object paramObject = req.getParameter(CreateRelationshipRequest.SOURCE);
		if(paramObject instanceof Classifier) {
			result = (Classifier)paramObject;
		}

		return result;
	}

	/**
	 * This method provides the target type provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target role
	 */
	private Classifier getTargetOwnerType(ConfigureRequest req) {
		Classifier result = null;
		Object paramObject = req.getParameter(CreateRelationshipRequest.TARGET);
		if(paramObject instanceof Classifier) {
			result = (Classifier)paramObject;
		}

		return result;
	}

	/**
	 * Test if the relationship creation is allowed.
	 * 
	 * @param source
	 *        the relationship source can be null
	 * @param target
	 *        the relationship target can be null
	 * @return true if the creation is allowed
	 */
	protected boolean canCreate(EObject source, EObject target) {

		if((source != null) && !(source instanceof Classifier)) {
			return false;
		}

		if((target != null) && !(target instanceof Classifier)) {
			return false;
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getCreateRelationshipCommand(CreateRelationshipRequest req) {

		EObject source = req.getSource();
		EObject target = req.getTarget();

		boolean noSourceOrTarget = (source == null || target == null);
		boolean noSourceAndTarget = (source == null && target == null);

		if(!noSourceAndTarget && !canCreate(source, target)) {
			// Abort creation.
			return UnexecutableCommand.INSTANCE;
		}

		if(noSourceOrTarget && !noSourceAndTarget) {
			// The request isn't complete yet. Return the identity command so
			// that the create relationship gesture is enabled.
			return IdentityCommand.INSTANCE;
		}

		// Propose a container if none is set in request.
		//EObject proposedContainer = EMFCoreUtil.getLeastCommonContainer(Arrays.asList(new EObject[]{ source, target }), UMLPackage.eINSTANCE.getPackage());
		View sourceView = (View)req.getParameter(RequestParameterConstants.EDGE_CREATE_REQUEST_SOURCE_VIEW);
		if (sourceView != null) {
			Diagram diagram = sourceView.getDiagram();
			EObject proposedContainer = EMFCoreUtil.getContainer(diagram.getElement(), UMLPackage.Literals.PACKAGE);
			req.setContainer(proposedContainer);
		}
		return new CreateRelationshipCommand(req);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getConfigureCommand(final ConfigureRequest req) {

		// All Association configure are managed by HelperAdvice(s).
		if((getSourceOwnerType(req) == null) || (getTargetOwnerType(req) == null)) {
			return UnexecutableCommand.INSTANCE;
		}

		return super.getConfigureCommand(req);
	}
}
