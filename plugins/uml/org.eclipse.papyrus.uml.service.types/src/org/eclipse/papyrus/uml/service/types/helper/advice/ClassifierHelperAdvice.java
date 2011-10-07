/*****************************************************************************
 * Copyright (c) 2010-2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 *		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.service.types.command.AssociationReorientCommand;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This HelperAdvice completes {@link Classifier} edit commands with the deletion of :
 * - any Generalization related to the Classifier (source or target).
 * - any Association related to the Classifier (source or target type).
 * </pre>
 */
public class ClassifierHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * While deleting a Classifier:
	 * - remove {@link Generalization} in which this Classifier is involved
	 * - remove {@link Association} in which this Classifier is involved
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		List<EObject> dependents = new ArrayList<EObject>();
		if(request.getElementToDestroy() instanceof Classifier) {

			Classifier classifierToDelete = (Classifier)request.getElementToDestroy();

			// Get related generalizations
			dependents.addAll(classifierToDelete.getSourceDirectedRelationships(UMLPackage.eINSTANCE.getGeneralization()));
			dependents.addAll(classifierToDelete.getTargetDirectedRelationships(UMLPackage.eINSTANCE.getGeneralization()));

			// Get related association for this classifier, then delete member ends for which this classifier is the type.
			for(Association association : classifierToDelete.getAssociations()) {
				for(Property end : association.getMemberEnds()) {
					if(end.getType() == classifierToDelete) {
						dependents.add(association);
					}
				}
			}
		}

		// Return the command to destroy all these dependent elements
		if(!dependents.isEmpty()) {
			return request.getDestroyDependentsCommand(dependents);
		}

		return null;
	}

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * While moving a {@link Property} to a Classifier:
	 * - re-orient Association possibly related to the moved Property
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeMoveCommand(MoveRequest request) {

		ICommand gmfCommand = super.getBeforeMoveCommand(request);

		// In case the move is called by the association re-orient, the re-orient parameter is propagated.
		// In such a case the association re-orient is already managed.
		View graphicallyReorientedView = (View)request.getParameter(RequestParameterConstants.GRAPHICAL_RECONNECTED_EDGE);
		if(graphicallyReorientedView == null) {

			// Find Associations related to any moved Property
			for(Object movedObject : request.getElementsToMove().keySet()) {

				// Select Property (excluding Port) in the list of moved elements
				if(!(movedObject instanceof Property) || (movedObject instanceof Port)) {
					continue;
				}

				Property movedProperty = (Property)movedObject;

				// Make sure the target differs from current container
				if((movedProperty.eContainer() == request.getTargetContainer()) && (movedProperty.eContainingFeature() == request.getTargetFeature(movedProperty))) {
					continue;
				}

				// Parse associations related to the moved property
				for(Association associationToReorient : getRelatedAssociations(movedProperty)) {

					// Re-orient the related association (do not use edit service to avoid infinite loop here)
					int direction = ReorientRelationshipRequest.REORIENT_TARGET;
					if(movedProperty == ((Association)associationToReorient).getMemberEnds().get(0)) {
						direction = ReorientRelationshipRequest.REORIENT_SOURCE;
					}

					ReorientRelationshipRequest reorientRequest = new ReorientRelationshipRequest(associationToReorient, request.getTargetContainer(), movedProperty.eContainer(), direction);
					ICommand reorientCommand = new AssociationReorientCommand(reorientRequest);
					gmfCommand = CompositeCommand.compose(gmfCommand, reorientCommand);

					// Clean inconsistent views representing the related association
					for(View view : getRelatedAssociationViews(associationToReorient)) {
						DestroyElementRequest destroyViewRequest = new DestroyElementRequest(view, false);
						DestroyElementCommand destroyViewCommand = new DestroyElementCommand(destroyViewRequest);
						gmfCommand = CompositeCommand.compose(gmfCommand, destroyViewCommand);
					}
				}
			}
		}

		if(gmfCommand != null) {
			gmfCommand = gmfCommand.reduce();
		}

		return gmfCommand;
	}

	/**
	 * Get association that reference the property as member end.
	 * @param property the referenced property
	 * @return related associations
	 */
	private Set<Association> getRelatedAssociations(Property property) {
		Set<Association> relatedAssociations = new HashSet<Association>();

		// Find all related Associations
		EReference[] refs = new EReference[]{ UMLPackage.eINSTANCE.getAssociation_MemberEnd() };
		@SuppressWarnings("unchecked")
		Collection<Association> associations = EMFCoreUtil.getReferencers(property, refs);
		relatedAssociations.addAll(associations);

		return relatedAssociations;
	}

	/**
	 * Get views that represent the association.
	 * @param association the referenced association 
	 * @return related views
	 */
	private Set<View> getRelatedAssociationViews(Association association) {
		Set<View> viewsToDestroy = new HashSet<View>();

		// Find all views representing the Associations
		EReference[] refs = new EReference[]{ NotationPackage.eINSTANCE.getView_Element() };
		@SuppressWarnings("unchecked")
		Collection<View> associationViews = EMFCoreUtil.getReferencers(association, refs);
		viewsToDestroy.addAll(associationViews);

		return viewsToDestroy;
	}
}
