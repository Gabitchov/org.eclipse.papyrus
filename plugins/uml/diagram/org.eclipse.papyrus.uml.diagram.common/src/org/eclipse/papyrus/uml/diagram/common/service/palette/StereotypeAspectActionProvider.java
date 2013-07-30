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
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Factory in charge of the aspect actions taken before/after palette actions
 */
public class StereotypeAspectActionProvider extends AbstractAspectActionProvider {

	/** stereotype action key */
	public final static String STEREOTYPE_ACTION_KEY = "org.eclipse.papyrus.postaction.applystereotype";

	/** Factory ID */
	public final static String FACTORY_ID = "org.eclipse.papyrus.applystereotypeactionprovider";

	/**
	 * Constructor.
	 */
	public StereotypeAspectActionProvider() {
	}

	/**
	 * @{inheritDoc
	 */
	public IAspectAction createAction(Node configurationNode) {
		StereotypePostAction action = new StereotypePostAction();
		action.init(configurationNode, this);
		return action;
	}

	/**
	 * Creates a configuration node for this provider, given a list of
	 * stereotypes to apply.
	 * <P>
	 * This method is used in the customize palette dialog, when pre-creating all available tools with stereotypes applied
	 * </P>
	 * 
	 * @param stereotypeList
	 *        the list of stereotypes to apply
	 * @return the configuration node from the list
	 */
	public static NodeList createConfigurationNode(String stereotypeList) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			Element paletteDefElement = document.createElement(IPapyrusPaletteConstant.ASPECT_TOOL);

			// create post action for stereotype application
			Element postActionNode = document.createElement(IPapyrusPaletteConstant.POST_ACTION);
			postActionNode.setAttribute(IPapyrusPaletteConstant.ID, FACTORY_ID);
			postActionNode.setAttribute(IPapyrusPaletteConstant.STEREOTYPES_TO_APPLY, stereotypeList);
			paletteDefElement.appendChild(postActionNode);
			return paletteDefElement.getChildNodes();

		} catch (ParserConfigurationException e) {
			Activator.getDefault().logError("impossible to create the palette tree viewer content", e);
		}
		return null;
	}

	/**
	 * @{inheritDoc
	 */
	public boolean isEnable(IPaletteEntryProxy entryProxy) {
		return true;
	}

}
