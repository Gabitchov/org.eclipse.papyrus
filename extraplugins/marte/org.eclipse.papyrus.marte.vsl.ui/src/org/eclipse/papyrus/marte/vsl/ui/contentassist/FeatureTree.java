/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.marte.vsl.ui.contentassist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

public class FeatureTree extends Tree<Feature> {

	private List<Classifier> typesCrossedToReachThisTree  ;
	
	public FeatureTree(Feature root) {
		super(root);
		typesCrossedToReachThisTree = new ArrayList<Classifier>() ;
	}
	
	public FeatureTree(Feature root, List<Classifier> typesCrossedToReachThisTree) {
		this(root) ;
		this.typesCrossedToReachThisTree.addAll(typesCrossedToReachThisTree) ;
		buildTree() ;
	}
	
	@Override
	public void buildTree() {
		Classifier featureType = null ;
		if (root instanceof Property) {
			featureType = (Classifier)((Property)root).getType() ;
		}
		else if (root instanceof Operation) {
			featureType = (Classifier)((Operation)root).getType() ;
		}
		if (featureType == null)
			return ;
		if (typesCrossedToReachThisTree.contains(featureType)) {
			return ;
		}
		else {
			typesCrossedToReachThisTree.add(featureType) ;
		}
		for (Feature property : featureType.getAllAttributes()) {
			getChildren().add(new FeatureTree(property, typesCrossedToReachThisTree)) ;
		}
		for (Feature operation : featureType.getAllOperations()) {
			getChildren().add(new FeatureTree(operation, typesCrossedToReachThisTree)) ;
		}
	}
	
	public static List<FeatureTree> buildListOfFeatureTrees(Classifier classifier) {
		List<FeatureTree> list = new ArrayList<FeatureTree>() ;
		List<Classifier> typesCrossedToReachThisTree = new ArrayList<Classifier>() ;
		typesCrossedToReachThisTree.add(classifier) ;
		for (Feature property : classifier.getAllAttributes()) {
			list.add(new FeatureTree(property, typesCrossedToReachThisTree)) ;
		}
		for (Feature operation : classifier.getAllOperations()) {
			list.add(new FeatureTree(operation, typesCrossedToReachThisTree)) ;
		}
		return list ;
	}
	
	public static boolean canClassifierBeReached(List<FeatureTree> listOfFeatureTrees, Classifier classifier) {
		boolean classifierReached = false ;
		Iterator<FeatureTree> i = listOfFeatureTrees.iterator() ;
		while (i.hasNext() && !classifierReached) {
			classifierReached = i.next().canClassifierBeReached(classifier) ;
		}
		return classifierReached ;
	}
	
	public boolean canClassifierBeReached(Classifier classifier) {
		for (Classifier type : typesCrossedToReachThisTree) {
			if (classifier == type || type.conformsTo(classifier))
				return true ;
			else if (type.getName().equals(classifier.getName()) 
					 && (type.getName().equals("Integer") 
							 || type.getName().equals("Integer") 
							 || type.getName().equals("String"))) {
				return true ;
			}
		}
		boolean classifierReached = false ;
		Iterator<Tree<Feature>> i = getChildren().iterator() ;
		while (i.hasNext() && !classifierReached) {
			classifierReached = ((FeatureTree)i.next()).canClassifierBeReached(classifier) ;
		}
		return classifierReached ;
	}
}
