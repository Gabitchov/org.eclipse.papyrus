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
 *  Laurent Wouters (CEA LIST) laurent.wouters@cea.fr - Refactoring
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.uml.diagram.common.service.palette.AspectToolService;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectActionProvider;
import org.eclipse.papyrus.uml.diagram.common.service.palette.StereotypePostAction;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Visitor of an XML palette definition that keeps track of the required profiles
 */
public class XMLPaletteDefinitionProfileInspector implements XMLPaletteDefinitionVisitor, IPapyrusPaletteConstant {

	final private Collection<String> requiredProfiles;

	/**
	 * Gets the profiles required for the palette
	 * @return A collection of the required profiles
	 */
	public Collection<String> getRequiredProfiles() {
		return requiredProfiles;
	}
	
	/**
	 * Initializes the inspector
	 */
	public XMLPaletteDefinitionProfileInspector() {
		this.requiredProfiles = new HashSet<String>();
	}

	/**
	 * {@inheritDoc}
	 */
	public void onContent(Node node) {
		// nothing specific here
	}

	/**
	 * {@inheritDoc}
	 */
	public void onDrawer(Node node) {
		// nothing specific here
	}

	/**
	 * {@inheritDoc}
	 */
	public void onToolEntry(Node node) {
		// nothing specific here
	}

	/**
	 * {@inheritDoc}
	 */
	public void onStack(Node node) {
		// nothing specific here
	}

	/**
	 * {@inheritDoc}
	 */
	public void onSeparator(Node node) {
		// nothing specific here
	}

	/**
	 * {@inheritDoc}
	 */
	public void onAspectToolEntry(Node node) {
		if(node.getChildNodes().getLength() > 0) {
			NodeList children = node.getChildNodes();
			for(int i = 0; i < children.getLength(); i++) {
				Node childNode = children.item(i);
				String childName = childNode.getNodeName();
				if(IPapyrusPaletteConstant.POST_ACTION.equals(childName)) {
					// node is a post action => retrieve the id of the provider
					// in charge of this configuration
					IAspectActionProvider provider = AspectToolService.getInstance().getProvider(AspectToolService.getProviderId(childNode));
					if(provider != null) {
						IAspectAction action = provider.createAction(childNode);
						if(action instanceof StereotypePostAction) {
							List<String> stereotypesToApply = ((StereotypePostAction)action).getStereotypesToApply();
							for(String stereotypeQN : stereotypesToApply) {
								String profileName = PaletteUtil.findProfileNameFromStereotypeName(stereotypeQN);
								requiredProfiles.add(profileName);
							}
						}
					} else {
						Activator.log.error("impossible to find factory with id: " + AspectToolService.getProviderId(childNode), null);
					}
				}
			}
		}
	}

}
