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
package org.eclipse.papyrus.sysml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterUtils;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/** Association edit helper advice */
public class AssociationEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * avoid creation of association on another association
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeCreateRelationshipCommand(CreateRelationshipRequest request) {
		IElementType type = request.getElementType();
		if(SysMLElementTypes.ASSOCIATION.equals(type)) {
			return UnexecutableCommand.INSTANCE;
		}
		if(type != null) {
			List<IElementType> superTypes = Arrays.asList(type.getAllSuperTypes());
			if(superTypes.contains(SysMLElementTypes.ASSOCIATION)) {
				return UnexecutableCommand.INSTANCE;
			}

		}

		return super.getBeforeCreateRelationshipCommand(request);
	}

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Add a command to destroy {@link Association} when only 1 end remains.
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeDestroyReferenceCommand(DestroyReferenceRequest request) {
		ICommand gmfCommand = super.getBeforeDestroyReferenceCommand(request);

		Association association = (Association)request.getContainer();
		if((request.getContainingFeature() == UMLPackage.eINSTANCE.getAssociation_MemberEnd()) && (association.getMemberEnds().contains(request.getReferencedObject()))) {
			Set<Property> ends = new HashSet<Property>();
			ends.addAll(association.getMemberEnds());
			ends.remove(request.getReferencedObject());

			if(ends.size() <= 2) {

				DestroyElementRequest destroyRequest = new DestroyElementRequest(association, false);
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(association);
				if(provider != null) {
					ICommand destroyCommand = provider.getEditCommand(destroyRequest);
					gmfCommand = CompositeCommand.compose(gmfCommand, destroyCommand);
				}

			}
		}

		return gmfCommand;
	}

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

		List<EObject> dependentsToKeep = (RequestParameterUtils.getDependentsToKeep(req) != null) ? RequestParameterUtils.getDependentsToKeep(req) : new ArrayList<EObject>();

		Association association = (Association)req.getElementToDestroy();
		for(Property end : association.getMemberEnds()) {
			if (!dependentsToKeep.contains(end)) {
				dependentsToDestroy.add(end);
			}
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
		SetRequest setTypeRequest = null;

		// Retrieve re-oriented association and add it to the list of re-factored elements
		Association association = (Association)request.getRelationship();
		List<EObject> currentlyRefactoredElements = (RequestParameterUtils.getAssociationRefactoredElements(request) != null) ? RequestParameterUtils.getAssociationRefactoredElements(request) : new ArrayList<EObject>();

		if(currentlyRefactoredElements.contains(association)) {
			// Abort - already treated 
			return null;

		} else {
			RequestParameterUtils.addAssociationRefactoredElement(request, association);
		}

		// not possible to have an association on another association, so reorient is forbidden here 
		if(request.getNewRelationshipEnd() instanceof Association) {
			return UnexecutableCommand.INSTANCE;
		}

		// Retrieve property ends of the Association (assumed to be binary)
		Property semanticSource = association.getMemberEnds().get(0);
		Property semanticTarget = association.getMemberEnds().get(1);

		EObject modifiedPropertyType = null;


		if(request.getDirection() == ReorientRelationshipRequest.REORIENT_SOURCE) {
			if(!association.getOwnedEnds().contains(semanticSource)) {
				moveRequest = new MoveRequest(request.getNewRelationshipEnd(), semanticSource);
			}

			modifiedPropertyType = semanticTarget;
			setTypeRequest = new SetRequest(modifiedPropertyType, UMLPackage.eINSTANCE.getTypedElement_Type(), request.getNewRelationshipEnd());
		}

		if(request.getDirection() == ReorientRelationshipRequest.REORIENT_TARGET) {
			if(!association.getOwnedEnds().contains(semanticTarget)) {
				moveRequest = new MoveRequest(request.getNewRelationshipEnd(), semanticTarget);
			}

			modifiedPropertyType = semanticSource;
			setTypeRequest = new SetRequest(modifiedPropertyType, UMLPackage.eINSTANCE.getTypedElement_Type(), request.getNewRelationshipEnd());
		}

		if(moveRequest != null) {
			// Propagate parameters to the move request
			moveRequest.addParameters(request.getParameters());
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(request.getNewRelationshipEnd());
			if(provider != null) {
				ICommand moveCommand = provider.getEditCommand(moveRequest);
				gmfCommand = CompositeCommand.compose(gmfCommand, moveCommand);
			}
		}

		if(setTypeRequest != null) {
			// Propagate parameters to the set request
			setTypeRequest.addParameters(request.getParameters());

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(modifiedPropertyType);
			if(provider != null) {
				ICommand setTypeCommand = provider.getEditCommand(setTypeRequest);
				gmfCommand = CompositeCommand.compose(gmfCommand, setTypeCommand);
			}
		}

		// Destroy inconsistent views of the association
		Set<View> viewsToDestroy = new HashSet<View>();
		viewsToDestroy.addAll(getViewsToDestroy(association, request));

		//return the command to destroy all these views
		if(!viewsToDestroy.isEmpty()) {
			DestroyDependentsRequest ddr = new DestroyDependentsRequest(request.getEditingDomain(), request.getRelationship(), false);
			ddr.setClientContext(request.getClientContext());
			ddr.addParameters(request.getParameters());
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

		View currentlyReorientedView = RequestParameterUtils.getReconnectedEdge(request);
		viewsToDestroy.addAll(associationViews);
		viewsToDestroy.remove(currentlyReorientedView);

		return viewsToDestroy;
	}
}
