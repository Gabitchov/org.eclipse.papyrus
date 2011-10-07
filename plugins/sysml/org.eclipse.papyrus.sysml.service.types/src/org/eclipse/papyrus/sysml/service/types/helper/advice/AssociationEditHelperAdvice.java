/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/** Association edit helper advice */
public class AssociationEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Add SysML Nature on the {@link Association}.
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {

		final Association association = (Association)request.getElementToConfigure();

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				// Add SysML Nature on the new Association
				ElementUtil.addNature(association, SysMLElementTypes.SYSML_NATURE);

				return CommandResult.newOKCommandResult(association);
			}
		};
	}

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Add a command to destroy {@link Association} ends referenced by the {@link Association} 
	 * to delete.
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest req) {
		List<EObject> dependentsToDestroy = new ArrayList<EObject>();

		Association association = (Association)req.getElementToDestroy();
		for(Property end : association.getMemberEnds()) {
			dependentsToDestroy.add(end);
		}

		// Return command to destroy dependents ends 
		if(!dependentsToDestroy.isEmpty()) {
			return req.getDestroyDependentsCommand(dependentsToDestroy);
		}

		return super.getBeforeDestroyDependentsCommand(req);
	}

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Add a command to related association end during re-orient.
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeReorientRelationshipCommand(ReorientRelationshipRequest request) {

		ICommand gmfCommand = super.getBeforeReorientRelationshipCommand(request);

		MoveRequest moveRequest = null;
		Association association = (Association)request.getRelationship();

		if(request.getDirection() == ReorientRelationshipRequest.REORIENT_SOURCE) {
			Property semanticSource = association.getMemberEnds().get(0);
			if(!association.getOwnedEnds().contains(semanticSource)) {
				moveRequest = new MoveRequest(request.getNewRelationshipEnd(), semanticSource);
			}
		}

		if(request.getDirection() == ReorientRelationshipRequest.REORIENT_TARGET) {
			Property semanticTarget = association.getMemberEnds().get(1);
			if(!association.getOwnedEnds().contains(semanticTarget)) {
				moveRequest = new MoveRequest(request.getNewRelationshipEnd(), semanticTarget);
			}
		}

		if(moveRequest != null) {
			// Propagate original request parameters
			moveRequest.addParameters(request.getParameters());
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(request.getNewRelationshipEnd());
			if(provider != null) {
				ICommand moveCommand = provider.getEditCommand(moveRequest);
				gmfCommand = CompositeCommand.compose(gmfCommand, moveCommand);
			}
		}

		// Destroy inconsistent views of the association
		Set<View> viewsToDestroy = new HashSet<View>();
		viewsToDestroy.addAll(getViewsToDestroy(association, request));

		//return the command to destroy all these views
		if(!viewsToDestroy.isEmpty()) {
			DestroyDependentsRequest ddr = new DestroyDependentsRequest(request.getEditingDomain(), request.getRelationship(), false);
			ICommand destroyViewsCommand = ddr.getDestroyDependentsCommand(viewsToDestroy);
			gmfCommand = CompositeCommand.compose(gmfCommand, destroyViewsCommand);
		}

		if(gmfCommand != null) {
			gmfCommand.reduce();
		}
		return gmfCommand;
	}

	/**
	 * Returns all views referencing Association except the view currently re-oriented.
	 * 
	 * @param association
	 *        the association referenced by views
	 * @param request
	 *        the re-orient relationship request
	 * @return the list of views to be destroy
	 */
	private Set<View> getViewsToDestroy(Association association, ReorientRelationshipRequest request) {
		Set<View> viewsToDestroy = new HashSet<View>();

		// Find all views representing the Associations
		EReference[] refs = new EReference[]{ NotationPackage.eINSTANCE.getView_Element() };
		@SuppressWarnings("unchecked")
		Collection<View> associationViews = EMFCoreUtil.getReferencers(association, refs);

		View currentlyReorientedView = (View)request.getParameter(RequestParameterConstants.GRAPHICAL_RECONNECTED_EDGE);
		viewsToDestroy.addAll(associationViews);
		viewsToDestroy.remove(currentlyReorientedView);

		return viewsToDestroy;
	}
}
