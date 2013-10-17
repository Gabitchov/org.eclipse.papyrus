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
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Utility class for Connector edit helpers.
 */
public class ConnectorUtils extends org.eclipse.papyrus.uml.service.types.utils.ConnectorUtils {

	/**
	 * the key used to store the nested path as parameter of the request. The value will be a List of {@link Property}
	 */
	public static String NESTED_CONNECTOR_END_PATH = "connectorEndPath"; //$NON-NLS-1$

	/**
	 * the separator used in the role path to distinguish the part
	 */
	public static final String PART_SEPARATOR = "."; //$NON-NLS-1$

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

		for(View view : nestedPath) {
			if((view.getElement() != null) && (view.getElement() instanceof Property)) {
				nestedPropertyPath.add((Property)view.getElement());
			}
		}

		// if end is a port, and the list is not empty, add the property from the check view in the list
		if(!nestedPropertyPath.isEmpty() && checkedEnd.getElement() instanceof Port) {
			Property partWithPort = getPartWithPort(checkedEnd, oppositeEnd);
			if(partWithPort != null) {
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

	/**
	 * 
	 * @param end
	 *        the connector end
	 * @return
	 *         the path for the role of the connector end (without using label provider)
	 */
	public static final String getRolePath(final ConnectorEnd end) {
		final NestedConnectorEnd nestedConnectorEnd = UMLUtil.getStereotypeApplication(end, NestedConnectorEnd.class);
		final ConnectableElement role = end.getRole();
		final StringBuilder rolePath = new StringBuilder();
		if(role != null) {
			if(nestedConnectorEnd != null) {
				final List<Property> properties = nestedConnectorEnd.getPropertyPath();
				for(final Property current : properties) {
					rolePath.append(current.getName());
					rolePath.append(ConnectorUtils.PART_SEPARATOR);
				}
			} else {
				//when the stereotype is applied, the Property for partWithPort is included in the stereotype#path
				final Property partWithPort = end.getPartWithPort();
				if(partWithPort != null) {
					rolePath.append(partWithPort.getName());
					rolePath.append(ConnectorUtils.PART_SEPARATOR);
				}
			}
			rolePath.append(role.getName());
		}

		return rolePath.toString();
	}

	/**
	 * 
	 * @param nestedPath
	 *        the nested path
	 * @return
	 *         <code>true</code> if we are breaking encapsulation (see SysML rules in SysML Standard 1.2, p.44):
	 *         isEncapsulated: Boolean [0..1] If true, then the block is treated as a black box; a part typed by this black box can only be connected
	 *         via its ports or directly to its outer boundary. If false, or if a value is not present, then connections can be established to
	 *         elements of its internal structure via deep-nested connector ends.
	 */
	public static final boolean isCrossingEncapuslation(final List<Property> nestedPath) {
		for(final Property current : nestedPath) {
			final Type type = current.getType();
			if(type != null) {
				final Block block = UMLUtil.getStereotypeApplication(type, Block.class);
				if(block != null && block.isEncapsulated()) {
					return true;
				}
			}
		}
		return false;
	}
}
