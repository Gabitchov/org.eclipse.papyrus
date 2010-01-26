/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Thibault Landre (Atos Origin) thibault.landre@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.utils;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * PropertyLinkedToClassifier checks if a specified property is linked to a classifier
 */
public class PropertyLinkedToClassifier {

	/** The classifier. */
	private final Classifier classifier;

	/** The property. */
	private final Property property;

	/** The list routes. */
	private List<Route> routes;

	/**
	 * Instantiates a new property linked to classifier.
	 * 
	 * @param classifier
	 * @param property
	 */
	public PropertyLinkedToClassifier(Classifier classifier, Property property) {
		this.classifier = classifier;
		this.property = property;
		this.routes = new LinkedList<Route>();
		refresh();
	}

	/**
	 * Checks if the property is linked to classifier.
	 * 
	 * @return true, if is linked to classifier
	 */
	public boolean isLinkedToClassifier() {
		return !routes.isEmpty();
	}

	/**
	 * Gets the available routes.
	 * 
	 * @return the available routes
	 */
	public List<Route> getAvailableRoutes() {
		return routes;
	}

	/**
	 * Gets the property.
	 * 
	 * @return the property
	 */
	protected Property getProperty() {
		return property;
	}

	/**
	 * Gets the number available route.
	 * 
	 * @return the number available route
	 */
	public int getNumberAvailableRoute() {
		return routes.size();
	}

	/**
	 * Refresh link to classifier.
	 * 
	 * @param classifierParent
	 * @param propertyToFind
	 * @param route
	 */
	private void refreshLinkToClassifier(Classifier classifierParent, final Property propertyToFind, final Route route) {
		EList<Property> classifierParentAttributes = classifierParent.getAllAttributes();
		// If the property is contained by the classifier
		if (classifierParentAttributes.contains(propertyToFind)) {
			route.addSegment(propertyToFind);
			routes.add(route);
		} else {
			for (Property attribute : classifierParentAttributes) {
				if (!(attribute instanceof Port)) {
					Type attributeType = attribute.getType();
					// stop loop
					if (route.getProperties().contains(attribute)) {
						// TODO Launch a warning ? an error ?
						break;
					}
					if (attributeType instanceof Classifier) {
						Route newRoute = new Route(new LinkedList<Property>(route.getProperties()));
						newRoute.addSegment(attribute);
						refreshLinkToClassifier((Classifier) attributeType, propertyToFind, newRoute);
					}
				}
			}
		}
	}

	/**
	 * Checks for several routes.
	 * 
	 * @return true, if successful
	 */
	public boolean hasSeveralRoutes() {
		return routes.size() > 1;
	}

	/**
	 * Refresh.
	 */
	public void refresh() {
		routes.clear();
		refreshLinkToClassifier(classifier, property, new Route());
	}

}
