/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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

package org.eclipse.papyrus.customization.palette.proxies;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.papyrus.customization.palette.dialog.PaletteAspectToolEntryProxy;
import org.eclipse.papyrus.customization.palette.dialog.PaletteContainerProxy;
import org.eclipse.papyrus.customization.palette.dialog.PaletteEntryProxy;
import org.eclipse.papyrus.customization.palette.dialog.PaletteLocalDrawerProxy;
import org.eclipse.papyrus.customization.palette.dialog.PaletteLocalSeparatorProxy;
import org.eclipse.papyrus.customization.palette.dialog.PaletteLocalStackProxy;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.service.AspectCreationEntry;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.papyrus.uml.diagram.common.service.XMLPaletteDefinitionVisitor;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPaletteEntryProxy;
import org.w3c.dom.Node;

/**
 * Implementation that creates proxies used by the palette previewer in the customiza dialog
 */
public class XMLPaletteDefinitionProxyFactory implements XMLPaletteDefinitionVisitor, IPapyrusPaletteConstant {

	/** map of predefined entries */
	protected final Map<String, PaletteEntry> predefinedEntries;

	/** root proxy */
	protected PaletteContainerProxy containerProxy;

	/** registry of created nodes */
	protected final Map<Node, IPaletteEntryProxy> registry;

	/**
	 * Creates a new XMLDefinitionPaletteFactory
	 * 
	 * @param root
	 *        the palette root to fill
	 * @param predefinedEntries
	 *        existing predefined entries
	 */
	public XMLPaletteDefinitionProxyFactory(Map<String, PaletteEntry> predefinedEntries) {
		this.predefinedEntries = predefinedEntries;
		registry = new HashMap<Node, IPaletteEntryProxy>();
	}
	
	/**
	 * Returns the parent proxy for the given node
	 * 
	 * @param node
	 *        the node for which the parent is searched
	 * @return the parent of this node
	 */
	protected PaletteContainerProxy getParentProxy(Node node) {
		return (PaletteContainerProxy)registry.get(node.getParentNode());
	}

	/**
	 * {@inheritDoc}
	 */
	public void onContent(Node node) {
		containerProxy = new PaletteContainerProxy(null);
		registry.put(node, containerProxy);
	}

	/**
	 * {@inheritDoc}
	 */
	public void onDrawer(Node node) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);
		PaletteContainerProxy proxy;
		Node descriptionNode = node.getAttributes().getNamedItem(DESCRIPTION);
		proxy = new PaletteLocalDrawerProxy(node.getAttributes().getNamedItem(NAME).getNodeValue(), node.getAttributes().getNamedItem(ID).getNodeValue(), node.getAttributes().getNamedItem(ICON_PATH).getNodeValue(), (descriptionNode != null) ? descriptionNode.getNodeValue() : "");

		getParentProxy(node).addChild(proxy);
		registry.put(node, proxy);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void onSeparator(Node node) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteLocalSeparatorProxy proxy = new PaletteLocalSeparatorProxy(id);
		getParentProxy(node).addChild(proxy);
		registry.put(node, proxy);

	}

	/**
	 * {@inheritDoc}
	 */
	public void onStack(Node node) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteLocalStackProxy proxy = new PaletteLocalStackProxy(id);
		getParentProxy(node).addChild(proxy);
		registry.put(node, proxy);
	}

	/**
	 * {@inheritDoc}
	 */
	public void onToolEntry(Node node) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);
		PaletteEntryProxy proxy = new PaletteEntryProxy(entry);
		getParentProxy(node).addChild(proxy);
		registry.put(node, proxy);
	}

	/**
	 * {@inheritDoc}
	 */
	public void onAspectToolEntry(Node node) {
		String id = node.getAttributes().getNamedItem(ID).getNodeValue();
		PaletteEntry entry = predefinedEntries.get(id);

		if(entry instanceof AspectCreationEntry) {
			PaletteAspectToolEntryProxy proxy = new PaletteAspectToolEntryProxy((AspectCreationEntry)entry);
			getParentProxy(node).addChild(proxy);
			registry.put(node, proxy);
		} else {
			Activator.log.error("impossible to log class " + id, null);
		}
	}

	/**
	 * Returns the root proxy for the created element
	 * 
	 * @return the container proxy
	 */
	public PaletteContainerProxy getRootProxy() {
		return containerProxy;
	}
}
