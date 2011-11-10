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
package org.eclipse.papyrus.uml.service.types.helper.advice;

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
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.service.types.Activator;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ClassifierUtils;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Association edit helper advice.
 */
public class AssociationEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * This method provides the source type provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target role
	 */
	protected Classifier getSourceOwnerType(ConfigureRequest req) {
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
	protected Classifier getTargetOwnerType(ConfigureRequest req) {
		Classifier result = null;
		Object paramObject = req.getParameter(CreateRelationshipRequest.TARGET);
		if(paramObject instanceof Classifier) {
			result = (Classifier)paramObject;
		}

		return result;
	}

	/**
	 * Creates a new source {@link Property} from the targetType.
	 * 
	 * @param targetType
	 *        the type of the {@link Property}
	 * @return the new {@link Property}
	 */
	protected Property createSourceProperty(Type targetType) {

		Property sourceProperty = UMLFactory.eINSTANCE.createProperty();
		sourceProperty.setLower(1);
		sourceProperty.setUpper(1);
		sourceProperty.setType(targetType);
		sourceProperty.setName(targetType.getName().toLowerCase());

		return sourceProperty;
	}

	/**
	 * Creates a new target {@link Property} from the sourceType.
	 * 
	 * @param sourceType
	 *        the type of the {@link Property}
	 * @return the new {@link Property}
	 */
	protected Property createTargetProperty(Type sourceType) {

		Property targetProperty = UMLFactory.eINSTANCE.createProperty();
		targetProperty.setLower(1);
		targetProperty.setUpper(1);
		targetProperty.setType(sourceType);
		targetProperty.setName(sourceType.getName().toLowerCase());

		return targetProperty;
	}


	/**
	 * Add the source {@link Property} in the correct container.
	 * 
	 * @param sourceEnd
	 *        the semantic end
	 * @param owner
	 *        the end container
	 * @param targetType
	 *        the target type
	 * @param association
	 *        the association
	 * @throws UnsupportedOperationException
	 */
	protected void addSourceInModel(final Property sourceEnd, Classifier owner, Classifier targetType, Association association) throws UnsupportedOperationException {
		boolean added = ClassifierUtils.addOwnedAttribute(owner, sourceEnd);

		if(!added) {
			throw new UnsupportedOperationException("Cannot add a Property on Classifier " + owner.getQualifiedName());
		}
	}

	/**
	 * Add the source {@link Property} in the correct container.
	 * 
	 * @param targetEnd
	 *        the semantic end
	 * @param owner
	 *        the end container
	 * @param sourceType
	 *        the source type
	 * @param association
	 *        the association
	 * @throws UnsupportedOperationException
	 */
	protected void addTargetInModel(Property targetEnd, Classifier owner, Classifier sourceType, Association association) {
		boolean added = ClassifierUtils.addOwnedAttribute(owner, targetEnd);

		if(!added) {
			throw new UnsupportedOperationException("Cannot add a Property on Classifier " + owner.getQualifiedName());
		}
	}

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Complete the {@link Association} creation by:
	 * 		adding its {@link Property} ends in the model
	 * 		adding the UML Nature on the {@link Association}.
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {

		final Association association = (Association)request.getElementToConfigure();
		final Classifier sourceType = getSourceOwnerType(request);
		final Classifier targetType = getTargetOwnerType(request);

		if((sourceType == null) || (targetType == null)) {
			return UnexecutableCommand.INSTANCE;
		}

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				// Add UML Nature on the new Association
				ElementUtil.addNature(association, UMLElementTypes.UML_NATURE);

				// Create source and target ends
				Property sourceEnd = createSourceProperty(targetType);
				Property targetEnd = createTargetProperty(sourceType);

				// Add association ends references
				association.getMemberEnds().add(sourceEnd);
				association.getMemberEnds().add(targetEnd);

				// Add end properties in the model
				try {
					addSourceInModel(sourceEnd, sourceType, targetType, association);
					addTargetInModel(targetEnd, targetType, sourceType, association);
				} catch (Exception e) {
					Activator.log.error(e);
					return CommandResult.newCancelledCommandResult();
				}

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
