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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;

public class PropertyLinkedToClassifierNode extends PropertyLinkedToClassifier {

	public static final String ROUTE_SELECTED = "routeSelected";

	private Node graphNode;

	public PropertyLinkedToClassifierNode(Classifier classifier, Property property, Node graphNode) {
		super(classifier, property);
		this.graphNode = graphNode;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		String lName = "";
		if (getAvailableRoutes().isEmpty()) {
			lName = getProperty().getName();
		} else if (!hasSeveralRoutes()) {
			lName = getAvailableRoutes().get(0).getName();
		} else {
			lName = getSelectedRoute();
		}
		return lName;
	}

	private String getSelectedRoute() {
		String result = "";
		if ("".equals(getRootingProperty(graphNode, ROUTE_SELECTED))) {
			LinkedList<Route> filteredAvailableRoute = filterAvailableRoute(getAvailableRoutes());
			if (filteredAvailableRoute.size() == 1) {
				result = filteredAvailableRoute.getFirst().getName();
			} else if (!filteredAvailableRoute.isEmpty()){
				// doesn't display dialog box, only get the first route
				//result = getUserSelectionRoute(filteredAvailableRoute);
				result = filteredAvailableRoute.getFirst().getName(); 
			}
		} else {
			String oldRouteSelectedValue = getRootingProperty(graphNode, ROUTE_SELECTED);
			Map<String, Route> routeNameAndRoute = getRouteNameAndRoute(getAvailableRoutes());
			if (routeNameAndRoute.containsKey(oldRouteSelectedValue)) {
				result = oldRouteSelectedValue;
			} else {
				result = calculateNewRoute(oldRouteSelectedValue);
			}
		}
		return result;
	}

	/*
	private String getUserSelectionRoute(LinkedList<Route> filteredAvailableRoute) {
		IWorkbench workBench = SysmlDiagramEditorPlugin.getInstance().getWorkbench();
		Shell shell = workBench.getActiveWorkbenchWindow().getShell();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, new LabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof Route) {
					return ((Route) element).getName();
				}
				return super.getText(element);
			}
		});
		dialog.setTitle("Routing selection");
		dialog.setMessage("Select the route of the property (* = any string, ? = any char):");
		dialog.setElements(filteredAvailableRoute.toArray());
		dialog.setHelpAvailable(false);
		dialog.setMultipleSelection(false);
		dialog.open();

		String result = "";
		if (dialog.getResult() != null) {
			result = ((Route) dialog.getFirstResult()).getName();
		} else {
			result = filteredAvailableRoute.getFirst().getName();
		}
		return result;
	}
	*/

	/**
	 * Filter the available route for accessing a property. Remove from the list the property that
	 * are already displayed in the diagram.
	 * 
	 * @param availableRoutes
	 *            the availableRoutes for this property
	 * @return the availableRoutes for this property that are not already displayed in the diagram
	 */
	private LinkedList<Route> filterAvailableRoute(List<Route> availableRoutes) {
		Map<String, Route> routeNameAndRoute = getRouteNameAndRoute(availableRoutes);
		for (Object view : DiagramEditPartsUtil.getEObjectViews(getProperty())) {
			if (view instanceof Node) {
				String routeNamedSaved = getRootingProperty((Node) view, ROUTE_SELECTED);
				if (routeNameAndRoute.containsKey(routeNamedSaved)) {
					routeNameAndRoute.remove(routeNamedSaved);
				}				
			}
		}
		return new LinkedList<Route>(routeNameAndRoute.values());
	}

	/**
	 * Return a map containing the routes and their associated names from a list of routes
	 * 
	 * @param routes
	 *            the list of routes
	 * @return the map with key the route, and value the name of the route.
	 */
	private Map<String, Route> getRouteNameAndRoute(List<Route> routes) {
		Map<String, Route> routeAndName = new HashMap<String, Route>();
		for (Route route : routes) {
			routeAndName.put(route.getName(), route);
		}
		return routeAndName;
	}

	private String calculateNewRoute(String oldRouteSelectedValue) {
		List<String> availableSpecificRoute = new LinkedList<String>();
		// If the length of the availableRoutes is bigger than the length of the old route, it means
		// that the property
		// is dragged/dropped to a parent container of its current container
		if (getAvailableRoutes().get(0).getName().length() > oldRouteSelectedValue.length()) {
			for (Route route : getAvailableRoutes()) {

				if (route.getName().indexOf(oldRouteSelectedValue) > 0) {
					availableSpecificRoute.add(route.getName());
				}
			}
			// If a unique route is present in the list, it means that there is only a route
			// possible
			if (availableSpecificRoute.size() == 1) {
				return availableSpecificRoute.get(0);
			}
			else {
				// Otherwise it means there is several routes possible. We need to check the name of the
				// container
			}
		}
		// Otherwise the element is dragged/dropped to a child container of its current container
		else {
			for (Route route : getAvailableRoutes()) {
				if (oldRouteSelectedValue.indexOf(route.getName()) > 0) {
					availableSpecificRoute.add(route.getName());
				}
			}
			if (availableSpecificRoute.size() == 1) {
				return availableSpecificRoute.get(0);
			}
		}
		return "";
	}
	
	/**
	 * TODO Remove it if eAnnotation is not needed 
	 * Gets the rooting property.
	 * 
	 * @param node the node
	 * @param key the key
	 * @return the rooting property
	 */
	private String getRootingProperty(Node node, String key) {
		String value = "";
		// use a right format for source
		EAnnotation eAnnotation = node.getEAnnotation(ROUTE_SELECTED);
		if (eAnnotation != null) {
			value = eAnnotation.getDetails().get(ROUTE_SELECTED);
		}
		return value;
	}
	
//    public void createRootingProperty(Node node, String key, String name)
//    {
//    	if ("".equals(getRootingProperty(node, key))) {
//    		EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
//    		annotation.setSource(ROUTE_SELECTED);
//    		node.getEAnnotations().add(annotation);
//    		
//    		annotation.getDetails().put(ROUTE_SELECTED, key);    		
//    	}
//    }

}
