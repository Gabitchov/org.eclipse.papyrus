/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.service.types.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Utility class for Connector edit helpers.
 */
public class ConnectorUtils extends org.eclipse.papyrus.uml.service.types.utils.ConnectorUtils {

	/**
	 * @param view
	 *        the view
	 * @return the nearest encapsulated structure container or null
	 */
	public View getEncapsulatedContainer(View view) {
		View encapsulatedContainer = null;

		for(View containerView : getStructureContainers(view)) {
			
			if(view == containerView) {
				continue;
			}
			
			if((view.getElement() instanceof Port) && (containerView.getChildren().contains(view))) {
				continue;
			}

			StructuredClassifier structuredClassifier = getStructuredClassifier(containerView);
			Block block = UMLUtil.getStereotypeApplication(structuredClassifier, Block.class);
			if(block.isEncapsulated()) {
				encapsulatedContainer = containerView;
				break;
			}
		}

		return encapsulatedContainer;
	}
	
	/**
	 * Test if an encapsulation crossing is required to connect the checked end to the opposite end.
	 * 
	 * @param checkedEnd
	 *        the checked end view.
	 * @param oppositeEnd
	 *        the opposite end view.
	 * @return true if the gesture break encapsulation rule.
	 */
	public boolean isCrossingEncapsulation(View checkedEnd, View oppositeEnd) {
		boolean isCrossingEncapsulation = false;

		View encapsulatedContainer = new ConnectorUtils().getEncapsulatedContainer(checkedEnd);
		if(encapsulatedContainer != null) {
			View containerView = new ConnectorUtils().deduceViewContainer(checkedEnd, oppositeEnd);
			List<View> containers = new ConnectorUtils().getStructureContainers(checkedEnd);

			if(containers.indexOf(encapsulatedContainer) < containers.indexOf(containerView)) {
				isCrossingEncapsulation = true;
			}
		}

		return isCrossingEncapsulation;
	}
	
	/**
	 * Get the path of structure views crossed by the checked end.
	 * 
	 * @param checkedEnd
	 *        the checked end view.
	 * @param oppositeEnd
	 *        the opposite end view.
	 * @return the list of crossed structure views.
	 */
	public List<View> getNestedPath(View checkedEnd, View oppositeEnd) {
		List<View> isNestedConnectableElement = new ArrayList<View>();

		View nearestContainer = new ConnectorUtils().getNearestStructureContainer(checkedEnd);
		if(nearestContainer != null) {
			View containerView = new ConnectorUtils().deduceViewContainer(checkedEnd, oppositeEnd);
			List<View> containers = new ConnectorUtils().getStructureContainers(checkedEnd);

			if(containers.indexOf(nearestContainer) < containers.indexOf(containerView)) {
				isNestedConnectableElement = containers.subList(containers.indexOf(nearestContainer), containers.indexOf(containerView));
			}
		}

		// nested path is taken from the top block to the deepest property ==> collection must be reverted
		Collections.reverse(isNestedConnectableElement);
		
		return isNestedConnectableElement;
	}
	
	/**
	 * Get the path of structure views crossed by the checked end.
	 * 
	 * @param checkedEnd
	 *        the checked end view.
	 * @param oppositeEnd
	 *        the opposite end view.
	 * @return the list of crossed structure views.
	 */
	public List<Property> getNestedPropertyPath(View checkedEnd, View oppositeEnd) {
		List<Property> nestedPropertyPath = new ArrayList<Property>();
		List<View> nestedPath = getNestedPath(checkedEnd, oppositeEnd);

		for (View view : nestedPath) {
			if ((view.getElement() != null) && (view.getElement() instanceof Property)) {
				nestedPropertyPath.add((Property) view.getElement());
			}
		}
		
		// if end is a port, and the list is not empty, add the property from the check view in the list
		if(!nestedPropertyPath.isEmpty() && checkedEnd.getElement() instanceof Port) {
			Property partWithPort = getPartWithPort(checkedEnd, oppositeEnd);
			if(partWithPort !=null) {
				nestedPropertyPath.add(partWithPort);
			}
		}
		
		return nestedPropertyPath;
	}
	
	/**
	 * Test if the checked end is nested (means it cross StructuredClassifier borders).
	 * 
	 * @param checkedEnd
	 *        the checked end view.
	 * @param oppositeEnd
	 *        the opposite end view.
	 * @return true if the checked end is nested.
	 */
	public boolean isNestedConnectableElement(View checkedEnd, View oppositeEnd) {
		return !(getNestedPath(checkedEnd, oppositeEnd).isEmpty());
	}
	
	/**
	 * @param view
	 *        the view
	 * @return the nearest structure container or null
	 */
	public View getNearestStructureContainer(View view) {
		View nearestStructureContainer = null;

		for(View containerView : getStructureContainers(view)) {
			
			if(view == containerView) {
				continue;
			}
			
			if((view.getElement() instanceof Port) && (containerView.getChildren().contains(view))) {
				continue;
			}

			nearestStructureContainer = containerView;
			break;
		}

		return nearestStructureContainer;
	}
}
