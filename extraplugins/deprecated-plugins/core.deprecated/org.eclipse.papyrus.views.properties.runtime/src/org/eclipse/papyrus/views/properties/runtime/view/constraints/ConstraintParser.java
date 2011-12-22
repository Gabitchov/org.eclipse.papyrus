/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.view.constraints;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.osgi.framework.Bundle;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 * Utility class to parse the constraint xml nodes. This has been created to provide an entry point to extension points. This class should evolve in
 * next versions. Each constraint should provide its own parser.
 */
public class ConstraintParser {

	/**
	 * Parses the constraint node, which gives some constraints on the descriptor that will be used.
	 * 
	 * @param contextNode
	 *        the xml node to parse
	 * @param bundle
	 *        the bundle used to find the class loader, in case of required class loader
	 * @return the list of parsed constraints
	 */
	public static List<IConstraintDescriptor> parseConstraints(Node contextNode, Bundle bundle) {
		List<IConstraintDescriptor> constraintDescriptors = new ArrayList<IConstraintDescriptor>();
		// retrieve meta class for which the fragment is valid
		// and additional constraints (applied profiles, applied stereotypes, ocl constraints, etc)
		NodeList children2 = contextNode.getChildNodes();
		Class<?> elementClass = null;
		for(int j = 0; j < children2.getLength(); j++) {
			Node child2 = children2.item(j);
			// check child 2 is an element class definition
			if("elementClass".equals(child2.getNodeName())) {
				if(child2.getAttributes() != null && child2.getAttributes().getNamedItem("name") != null) {
					String elementClassName = child2.getAttributes().getNamedItem("name").getNodeValue();
					// should retrieve java class corresponding to this class
					try {
						elementClass = bundle.loadClass(elementClassName);
						constraintDescriptors.add(new ObjectTypeConstraintDescriptor(elementClass));
					} catch (ClassNotFoundException e) {
						Activator.log.error(e);
					}
				}
			} else if("appliedStereotypes".equals(child2.getNodeName())) {
				List<String> appliedStereotypeQNames = new ArrayList<String>();
				// each child node of this node is the stereotype with qualified names
				NodeList stereotypeNodes = child2.getChildNodes();
				for(int i = 0; i < stereotypeNodes.getLength(); i++) {
					Node stereotypeNode = stereotypeNodes.item(i);
					String stereotypeNodeName = stereotypeNode.getNodeName();
					if("appliedStereotype".equals(stereotypeNodeName)) {
						// retrieve attribute QN
						NamedNodeMap attributes = stereotypeNode.getAttributes();
						if(attributes != null) {
							Node qualifiedName = attributes.getNamedItem("qualifiedName");
							if(qualifiedName != null) {
								appliedStereotypeQNames.add(qualifiedName.getNodeValue());
							}
						}
					}
				}
				constraintDescriptors.add(new AppliedStereotypeConstraintDescriptor(appliedStereotypeQNames));
			}
		}
		return constraintDescriptors;
	}
}
