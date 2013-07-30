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
package org.eclipse.papyrus.uml.diagram.common.service;

import java.util.Collection;
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
 * Factory that collects all required profiles for the given palette
 */
public class XMLRequiredProfileFactory extends AbstractXMLDefinitionPaletteFactory implements IPapyrusPaletteConstant {

	final protected Collection<String> requiredProfiles;

	/**
	 * Creates a new XMLRequiredProfileFactory.
	 * 
	 * @param requiredProfiles
	 *        list of required profiles to complete
	 */
	public XMLRequiredProfileFactory(Collection<String> requiredProfiles) {
		this.requiredProfiles = requiredProfiles;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverseContentNode(Node node) {
		// nothing specific here
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverseDrawerNode(Node node) {
		// nothing specific here
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverseToolEntryNode(Node node) {
		// nothing specific here
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverseStackNode(Node node) {
		// nothing specific here
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverseSeparatorNode(Node node) {
		// nothing specific here
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverseAspectToolEntryNode(Node node) {
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
