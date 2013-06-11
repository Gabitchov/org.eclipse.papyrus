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
package org.eclipse.papyrus.compare.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.diagram.internal.extensions.NodeChange;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Helper for extracting information used by the ComparePapyrusDiagramPostProcessor,
 * in order to establish requirements between Diffs representing changes on Generalization in a .uml model,
 * and Diffs representing changes on nodes for inherited features in .notation model.
 *
 */
@SuppressWarnings("restriction")
public class GeneralizationChangesHelper {

	/**
	 * The Comparison analyzed by this GeneralizationChangesHelper
	 */
	protected Comparison comparison ;

	/**
	 * A mapping between Features and Diffs representing changes for corresponding graphical nodes,
	 * in the case where these graphical nodes represent inherited features, in the context of a node 
	 * for an inheriting classifier.
	 */
	protected Map<Feature, NodeChange> displayedInheritedFeatureToNodeChange = new HashMap<Feature, NodeChange>() ;
	
	/**
	 * A mapping between Generalizations and Diffs representing addition or deletion of this generalization.
	 */
	protected Map<Generalization, ReferenceChange> generalizationToReferenceChange = new HashMap<Generalization, ReferenceChange>() ;
	
	/**
	 * A mapping between pairings of Classifier/Feature to Generalization path, where a path is a List<Generalization>,
	 * and represents the list of Generalization required by a given Classifier to inherit from a given Feature 
	 */
	protected Map<Classifier, Map<Feature, List<Generalization>>> classifierAndFeatureToGeneralizationPath = new HashMap<Classifier, Map<Feature, List<Generalization>>>() ;
	
	/**
	 * The list of Classes for which there exists a Diff implying addition of a node for an inherited Feature.
	 * FIXME Shall work for Classifiers in general
	 */
	protected List<Class> classesWithNodeForInheritedFeature_ADDED = new ArrayList<Class>() ;
	
	/**
	 * The list of Classes for which there exists a Diff implying deletion of a node for an inherited Feature.
	 * FIXME Shall work for Classifiers in general
	 */
	protected List<Class> classesWithNodeForInheritedFeature_DELETED = new ArrayList<Class>() ;

	/**
	 * Constructor for this helper. Instantiation of this helper implies classification of Diffs associated with the given comparison. 
	 * 
	 * @param comparison
	 */
	public GeneralizationChangesHelper(Comparison comparison) {
		this.comparison = comparison ;
		this.classifyDiffs();
	}

	/**
	 * Classify Diffs related to the context Comparison.
	 * Classification consists in: 
	 * - Identifying Diffs corresponding to changes on Generalizations in the .uml model
	 * - identifying Diffs corresponding to changes on nodes representing inherited features in the .notation model
	 * - Constructing local maps and lists to ease navigation between semantic elements and classified diffs
	 * (c.f., displayedInheritedFeatureToNodeChange, generalizationToReferenceChange, classifierAndFeatureToGeneralizationPath,
	 * classesWithNodeForInheritedFeature_ADDED, classesWithNodeForInheritedFeature_DELETED)
	 */
	protected void classifyDiffs() {
		for (Diff difference : this.comparison.getDifferences()) {
			if (difference instanceof ReferenceChange) {
				// TODO Changes may be required in connection with the following bug:
				// Bug 406405 - A macroscopic change has to be created for UML DirectedRelationship elements 
				this.evaluateGeneralizationChange((ReferenceChange)difference) ;
			}
			else if (difference instanceof NodeChange) {
				this.evaluateNodeForInheritedFeatureChange((NodeChange)difference) ;
			}
		}
	}

	/**
	 * Evaluates if the given difference concerns a change on a Generalization,
	 * and classifies it accordingly.
	 * 
	 * @param difference The difference being evaluated
	 */
	protected void evaluateGeneralizationChange(ReferenceChange difference) {
		// difference is a generalization if the associated eReference is Classifier.generalization
		if (difference.getReference().equals(UMLPackage.eINSTANCE.getClassifier_Generalization())) {
			this.generalizationToReferenceChange.put((Generalization)difference.getValue(), difference) ;
		}
	}

	/**
	 * Evaluates if the given difference concerns a change on a node (in the .notation)
	 * representing an inherited feature, and classifies it accordingly.
	 * 
	 * @param difference The difference being evaluated
	 */
	protected void evaluateNodeForInheritedFeatureChange(NodeChange difference) {
		Feature feature = null ;
		View view = null ;
		// Determines if the NodeChange concerns a View for a Feature
		if (difference.getView() != null && (difference.getView() instanceof View)) {
			view = (View)difference.getView() ;
			EObject semanticElement = view.getElement() ;
			if (semanticElement == null || ! (semanticElement instanceof Feature)) {
				return ;
			}
			else {
				feature = (Feature)semanticElement ;
			}
		}
		// Determines if the View corresponds to an inherited Feature.
		// Requires to retrieve the View for the Class containing this Feature
		Class class_ = null ;
		EObject viewContainer = view.eContainer() ;
		while (viewContainer != null && class_ == null) {
			if (viewContainer instanceof View) {
				EObject semanticElement = ((View)viewContainer).getElement() ;
				if (semanticElement != null && semanticElement instanceof Class) {
					class_ = (Class)semanticElement ;
				}
			}
			viewContainer = viewContainer.eContainer() ;
		}
		if (class_ == null) {
			return ;
		}
		// The difference is added to the appropriate collections if the 
		// corresponding feature is an inherited member of the Class
		if (class_.getInheritedMembers().contains(feature)) {
			if (difference.getKind() == DifferenceKind.ADD) {
				if (! this.classesWithNodeForInheritedFeature_ADDED.contains(class_)) {
					this.classesWithNodeForInheritedFeature_ADDED.add(class_) ;
				}
			}
			else if (difference.getKind() == DifferenceKind.DELETE) {
				if (! this.classesWithNodeForInheritedFeature_DELETED.contains(class_)) {
					this.classesWithNodeForInheritedFeature_DELETED.add(class_) ;
				}
			}
			List<Generalization> path = this.computeGeneralizationPath(class_, feature) ;
			this.insertGeneralizationPath(class_, feature, path);
			this.displayedInheritedFeatureToNodeChange.put(feature, difference) ;
		}
	}

	/**
	 * Returns Classes for which there are changes on nodes representing inherited properties,
	 * with the given difference kind.
	 * 
	 * @param kind The DifferenceKind for changes on nodes representing inherited properties
	 * @return Classes for which there are changes on nodes representing inherited properties, with the given DifferenceKind
	 */
	public List<Class> getClassesWithInheritedPropertyNode(DifferenceKind kind) {
		if (kind == DifferenceKind.ADD) {
			return this.classesWithNodeForInheritedFeature_ADDED ;
		}
		else if (kind == DifferenceKind.DELETE) {
			return this.classesWithNodeForInheritedFeature_DELETED ;
		}
		// Not supposed to happen
		return new ArrayList<Class>() ;
	}
	
	/**
	 * Returns the Generalization path which enables the given classifier to inherit from the given feature.
	 * If no generalization path is found, returns an empty list
	 * 
	 * FIXME Currently returns the first Generalization path that matches. Since multiple inheritance is allowed in UML, there can be multiple paths
	 * 
	 * @param classifier 
	 * @param inherited
	 * @return the Generalization path which enables the given classifier to inherit from the given feature.
	 */
	public List<Generalization> getGeneralizationPath(Classifier classifier, Feature inherited) {
		List<Generalization> path = null ;
		Map<Feature, List<Generalization>> inheritedFeatureToPath = this.classifierAndFeatureToGeneralizationPath.get(classifier) ;
		if (inheritedFeatureToPath != null) {
			path = inheritedFeatureToPath.get(inherited) ;
		}
		return path != null ? path : new ArrayList<Generalization>() ;
	}
	
	/**
	 * From the inherited features of the given classifier, returns those for which the inherited features of 
	 * the given classifier that are related to changes on graphical nodes.
	 * 
	 * @param classifier
	 * @return the inherited features of the given classifier that are related to change on graphical nodes
	 */
	public Set<Feature> getInheritedFeaturesWithNodeChange(Classifier classifier) {
		Set<Feature> inheritedFeatures = null ;
		Map<Feature, List<Generalization>> inheritedFeatureToPath = this.classifierAndFeatureToGeneralizationPath.get(classifier) ;
		if (inheritedFeatureToPath != null) {
			inheritedFeatures = inheritedFeatureToPath.keySet() ;
		}
		if (inheritedFeatures == null)
			inheritedFeatures = new HashSet<Feature>() ;
		return inheritedFeatures ;
	}
	
	/**
	 * Returns the generalization path that enables the given classifier to inherit from the given feature.
	 * 
	 * FIXME Currently returns the first Generalization path that matches. Since multiple inheritance is allowed in UML, there can be multiple paths
	 * 
	 * @param classifier
	 * @param inherited
	 * @return the generalization path that enables the given classifier to inherit from the given feature.
	 */
	protected List<Generalization> computeGeneralizationPath(Classifier classifier, Feature inherited) {
		Classifier featuringClassifier = inherited.getFeaturingClassifiers().get(0) ; // There is always 1 and only 1 featuring classifier
		Generalization match = null ;
		for (int i = 0 ; i < classifier.getGeneralizations().size() && match == null ; i++) {
			Generalization generalization = classifier.getGeneralizations().get(i) ;
			if (generalization.getGeneral() == featuringClassifier) {
				match = generalization ;
			}
		}
		List<Generalization> path = new ArrayList<>() ;
		// if no match found, it means that the feature is not directly inherited.
		// Repeat recursively on general classifiers of the classifier to construct the generalization path
		if (match == null) {
			for (int i = 0 ; i < classifier.getGeneralizations().size() && path.size() == 0 ; i++) {
				Generalization generalization = classifier.getGeneralizations().get(i) ;
				Classifier general = generalization.getGeneral() ;
				List<Generalization> remaining = this.computeGeneralizationPath(general, inherited) ;
				if (remaining.size() != 0) {
					path.add(generalization) ;
					path.addAll(remaining) ;
				}
			}
		}
		else {
			path = new ArrayList<Generalization>() ;
			path.add(match) ;
		}
		return path ;
	}

	/**
	 * Inserts a generalization path in the local map inheritedFeatureToGeneralizationPath,
	 * in the context of a specific classifier (cf. classifierAndFeatureToGeneralizationPath)
	 * 
	 * @param classifier The context classifier that inherits the given feature
	 * @param inherited The feature inherited following the given path, in the context of the given classifier
	 * @param path The generalization path (as a List) enabling the given classifier to inherit from the given feature
	 */
	protected void insertGeneralizationPath(Classifier classifier, Feature inherited, List<Generalization> path) {
		Map<Feature, List<Generalization>> inheritedFeatureToGeneralizationPath = this.classifierAndFeatureToGeneralizationPath.get(classifier) ;
		if (inheritedFeatureToGeneralizationPath == null) {
			inheritedFeatureToGeneralizationPath = new HashMap<Feature, List<Generalization>>() ;
		}
		inheritedFeatureToGeneralizationPath.put(inherited, path) ;
		this.classifierAndFeatureToGeneralizationPath.put(classifier, inheritedFeatureToGeneralizationPath) ;
	}
	
	/**
	 * From the comparison object from which this helper was constructed,
	 * returns the ReferenceChange diff corresponding to the given Generalization, if any.
	 * 
	 * @param generalization
	 * @return the ReferenceChange diff corresponding to the given Generalization, if any.
	 */
	public ReferenceChange getGeneralizationChange(Generalization generalization) {
		return this.generalizationToReferenceChange.get(generalization) ;
	}
	
	/**
	 * From the comparison object from which this helper was constructed,
	 * returns the NodeChange diff corresponding to the given feature, if any.
	 * 
	 * @param feature
	 * @return
	 */
	public NodeChange getFeatureNodeChange(Feature feature) {
		return this.displayedInheritedFeatureToNodeChange.get(feature) ;
	}
}
