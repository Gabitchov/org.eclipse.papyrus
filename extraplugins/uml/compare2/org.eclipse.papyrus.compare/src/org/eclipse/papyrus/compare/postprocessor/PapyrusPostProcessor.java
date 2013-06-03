/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.compare.postprocessor;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.diagram.internal.extensions.NodeChange;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.papyrus.compare.utils.GeneralizationChangesHelper;
import org.eclipse.uml2.uml.Class ; 
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Generalization;

/**
 * PostProcessor specific to integration with Papyrus.
 * Creates needed requirements between Diffs implying addition/deletion of Generalizations in a .uml model, 
 * and Diffs implying addition/deletion of graphical nodes for inherited features.
 *
 */
@SuppressWarnings("restriction")
public class PapyrusPostProcessor implements IPostProcessor {

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.postprocessor.IPostProcessor#postMatch(org.eclipse.emf.compare.Comparison, org.eclipse.emf.common.util.Monitor)
	 */
	@Override
	public void postMatch(Comparison comparison, Monitor monitor) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.postprocessor.IPostProcessor#postDiff(org.eclipse.emf.compare.Comparison, org.eclipse.emf.common.util.Monitor)
	 */
	@Override
	public void postDiff(Comparison comparison, Monitor monitor) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.postprocessor.IPostProcessor#postRequirements(org.eclipse.emf.compare.Comparison, org.eclipse.emf.common.util.Monitor)
	 */
	@Override
	public void postRequirements(Comparison comparison, Monitor monitor) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.postprocessor.IPostProcessor#postEquivalences(org.eclipse.emf.compare.Comparison, org.eclipse.emf.common.util.Monitor)
	 */
	@Override
	public void postEquivalences(Comparison comparison, Monitor monitor) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.postprocessor.IPostProcessor#postConflicts(org.eclipse.emf.compare.Comparison, org.eclipse.emf.common.util.Monitor)
	 */
	@Override
	public void postConflicts(Comparison comparison, Monitor monitor) {
	}

	/**
	 * This post comparison consists in computing additional requirements between Diffs contained in the given comparison,
	 * for Diffs implying addition/deletion of Generalizations in a .uml model, and Diffs implying addition/deletion of
	 * graphical nodes for inherited features.
	 * Requirements between those Diffs are added so that:
	 * - When a merge implies deletion of a Generalization, Diffs corresponding to deletion of nodes for inherited features (requiring this Generalization) are also merged
	 * - When a merge implies addition of a node for an inherited feature, Diffs corresponding to addition of a Generalization (required for the inheritance of this feature) are also merged   
	 * 
	 * It means that merging the deletion of a node for an inherited feature does not imply merging the deletion of a Generalization (required for this inheritance), if any.
	 * 
	 * (non-Javadoc)
	 * @see org.eclipse.emf.compare.postprocessor.IPostProcessor#postComparison(org.eclipse.emf.compare.Comparison, org.eclipse.emf.common.util.Monitor)
	 */
	@Override
	public void postComparison(Comparison comparison, Monitor monitor) {
		// Construct a GeneralizationChangesHelper from the given comparison
		GeneralizationChangesHelper helper = new GeneralizationChangesHelper(comparison) ;
		// Use this helper to compute requirements
		this.computeRequirements(helper);
	}

	/**
	 * Adds additional requirements between Diffs classified by the given helper.
	 * Requirements are added when required between Diffs implying addition/deletion of Generalizations in a .uml model, 
	 * and Diffs implying addition/deletion of graphical nodes for inherited features.
	 * 
	 * @param helper A GeneralizationChangesHelper containing a pre-classification of Diffs
	 */
	protected void computeRequirements(GeneralizationChangesHelper helper) {
		// Compute diff requirements related to additions of graphical nodes for inherited features
		List<Class> classesWIthNodesForInheritedFeatures_ADDED = helper.getClassesWithInheritedPropertyNode(DifferenceKind.ADD) ;
		for (Class c : classesWIthNodesForInheritedFeatures_ADDED) {
			Set<Feature> features = helper.getInheritedFeaturesWithNodeChange(c) ;
			for (Feature f : features) {
				for (Generalization generalization : helper.getGeneralizationPath(c, f)) {
					ReferenceChange generalizationAdded = helper.getGeneralizationChange(generalization) ;
					if (generalizationAdded != null) {
						NodeChange nodeAdded = helper.getFeatureNodeChange(f) ;
						if (nodeAdded != null) {
							nodeAdded.getRequires().add(generalizationAdded) ;
							generalizationAdded.getRequiredBy().add(nodeAdded) ;
						}
					}
				}
			}
		}
		
		// Compute diff requirements related to deletions of nodes for inherited features
		List<Class> classesWIthNodesForInheritedFeatures_DELETED = helper.getClassesWithInheritedPropertyNode(DifferenceKind.DELETE) ;
		for (Class c : classesWIthNodesForInheritedFeatures_DELETED) {
			Set<Feature> features = helper.getInheritedFeaturesWithNodeChange(c) ;
			for (Feature f : features) {
				for (Generalization generalization : helper.getGeneralizationPath(c, f)) {
					ReferenceChange generalizationDeleted = helper.getGeneralizationChange(generalization) ;
					if (generalizationDeleted != null) {
						NodeChange nodeDeleted = helper.getFeatureNodeChange(f) ;
						if (nodeDeleted != null) {
							nodeDeleted.getRequiredBy().add(generalizationDeleted) ;
							generalizationDeleted.getRequires().add(nodeDeleted) ;
						}
					}
				}
			}
		}
	}

}
