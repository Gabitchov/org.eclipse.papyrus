/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.dnd.strategy.instancespecification.ui;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;

/**
 * A TreeContentProvider which returns a collection of properties from a
 * collection of classifiers.
 * 
 * The roots are the classifiers, the leafs are the properties.
 * 
 * @author Camille Letavernier
 */
public class ClassifierPropertiesContentProvider implements ITreeContentProvider {

	private Viewer viewer;

	private Collection<Classifier> input;

	public void dispose() {
		viewer = null;
		input = null;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = viewer;
		this.input = (Collection<Classifier>)newInput;
	}

	public Object[] getElements(Object inputElement) {
		Collection<Classifier> result = new LinkedHashSet<Classifier>();

		for(Classifier classifier : input) {
			getAllGenerals(classifier, result);
		}

		return result.toArray();
	}

	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof Classifier) {
			Classifier element = (Classifier)parentElement;
			//			Set<Property> children = new LinkedHashSet<Property>();

			return element.getAttributes().toArray();

			//			//Find all extended or implemented classifiers (Including self)
			//			LinkedHashSet<Classifier> allGenerals = new LinkedHashSet<Classifier>();
			//			getAllGenerals(element, allGenerals);

			//Find all properties
			//			for(Classifier classifier : allGenerals) {
			//				//Skip properties owned by another classifier, 
			//				//when this classifier is included in the input (To avoid duplication)
			//				if(isCloserClassifier(element, classifier)) {
			//					children.addAll(classifier.getAttributes());
			//				}
			//			}
			//
			//			//Remove all redefined properties
			//			LinkedHashSet<Property> childrenCopy = new LinkedHashSet<Property>(children);
			//			for(Property property : children) {
			//				childrenCopy.removeAll(property.getRedefinedProperties());
			//			}
			//
			//			return childrenCopy.toArray();
		}

		return new Object[0];
	}

	protected boolean isCloserClassifier(Classifier current, Classifier classifier) {
		if(current == classifier || input.size() == 1) {
			return true;
		}

		if(input.contains(classifier)) {
			return false;
		}

		return true;
	}

	protected void getAllGenerals(Classifier classifier, Collection<Classifier> result) {
		if(result.contains(classifier)) {
			return;
		}

		//		Don't take the implemented interfaces into account. The semantic here is not clear enough.
		//
		//		if(classifier instanceof BehavioredClassifier) {
		//			for(Classifier general : ((BehavioredClassifier)classifier).getImplementedInterfaces()) {
		//				getAllGenerals(general, result);
		//			}
		//		}

		for(Classifier general : classifier.getGenerals()) {
			getAllGenerals(general, result);
		}

		result.add(classifier);
	}

	public Object getParent(Object element) {
		if(element instanceof Property) {
			return ((Property)element).getOwner();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if(element instanceof Classifier) {
			return !((Classifier)element).getAllAttributes().isEmpty();
		}
		return false;
	}

}
