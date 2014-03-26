/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 410346
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.providers.DefaultPaletteProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusDiagram;
import org.eclipse.papyrus.infra.viewpoints.policy.Activator;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.ui.IEditorPart;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Represents a palette provider which filters it content based on the use cases
 * @author Laurent Wouters
 */
public class FilteringPaletteProvider implements IPaletteProvider {

	/**
	 * Provider of a policy-enforced custom palette
	 * 
	 * @author Laurent Wouters
	 */
	private static class CustomPaletteProvider extends LocalPaletteProvider {
		/**
		 * Sets the palette at the given uri as the contribution
		 * 
		 * @param uri
		 *            URI of a custom palette
		 */
		public void setContributions(String uri) {
			readXMLDocument(uri);
		}
		
		public NodeList getContributions() {
			return contributions;
		}

		/**
		 * @see org.eclipse.papyrus.uml.diagram.common.service.LocalPaletteProvider#getXmlFile(java.lang.String)
		 */
		@Override
		public InputStream getXmlFile(String path) throws IOException {
			return URIConverter.INSTANCE.createInputStream(URI.createURI(path));
		}
	}
	
	/**
	 * Retrieve all elements of a palette contribution
	 * 
	 */
	private static class WalkerPaletteContribution implements IPapyrusPaletteConstant {
		
		/**
		 * Retrieve all elements ID of the palette contributions
		 * 
		 * @param contributions
		 * 				the palette contributions
		 * @return the list of palette nodes ID
		 */
		public static List<String> getAllPaletteNodesID(NodeList contributions) {
			List<String> paletteNodesID =  new ArrayList<String>();
			for(int i = 0; i < contributions.getLength(); i++) {
				Node node = contributions.item(i);
				if(PALETTE_DEFINITION.equals(node.getNodeName())) {
					paletteNodesID.addAll(walkDefinition(node));
				}
			}
			return paletteNodesID;
		}

		/**
		 * Parse the given node, assuming its type is a palette definition
		 * 
		 * @param paletteDefinitionNode
		 *        		the node to parse
		 * @return the list of palette nodes ID        
		 */
		private static List<String> walkDefinition(Node paletteDefinitionNode) {
			List<String> paletteNodesID =  new ArrayList<String>();
			NodeList nodes = paletteDefinitionNode.getChildNodes();
			for(int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				if(CONTENT.equals(node.getNodeName())) {
					paletteNodesID.addAll(walkContentNode(node));
				}
			}
			return paletteNodesID;
		}
		
		/**
		 *  Parse the contents of a palette definition
		 *  
		 * @param paletteContentNode
		 * 	 			the node to parse
		 * @return the list of palette nodes ID
		 */
		private static List<String> walkContentNode(Node paletteContentNode) {
			List<String> paletteNodesID =  new ArrayList<String>();
			NodeList nodes = paletteContentNode.getChildNodes();
			for(int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				String name = node.getNodeName();
				String nodeID = null;
				if(DRAWER.equals(name)) {
					nodeID = node.getAttributes().getNamedItem(ID).getNodeValue();
					paletteNodesID.add(nodeID);
					if(node.getChildNodes().getLength() > 0) {
						paletteNodesID.addAll(walkContentNode(node));
					}
				} else if(STACK.equals(name)) {
					nodeID = node.getAttributes().getNamedItem(ID).getNodeValue();
					paletteNodesID.add(nodeID);
					if(node.getChildNodes().getLength() > 0) {
						paletteNodesID.addAll(walkContentNode(node));
					}
				} else if(SEPARATOR.equals(name)) {
					nodeID = node.getAttributes().getNamedItem(ID).getNodeValue();
					paletteNodesID.add(nodeID);
					if(node.getChildNodes().getLength() > 0) {
						paletteNodesID.addAll(walkContentNode(node));
					}
				} else if(TOOL.equals(name)) {
					nodeID = node.getAttributes().getNamedItem(ID).getNodeValue();
					paletteNodesID.add(nodeID);
					if(node.getChildNodes().getLength() > 0) {
						paletteNodesID.addAll(walkContentNode(node));
					}
				} else if(ASPECT_TOOL.equals(name)) {
					nodeID = node.getAttributes().getNamedItem(ID).getNodeValue();
					paletteNodesID.add(nodeID);
					if(node.getChildNodes().getLength() > 0) {
						paletteNodesID.addAll(walkContentNode(node));
					}
				}
			}
			return paletteNodesID;
		}
	}

	/**
	 * The original palette provider to delegate to
	 */
	private DefaultPaletteProvider proxied;
	/**
	 * The root configuration element for this palette provider
	 */
	private IConfigurationElement config;
	/**
	 * The exception to the filtering scheme.
	 * Palette entry IDs in this array are always allowed, regardless of the current configuration.
	 */
	private String[] exceptions;
	
	private NodeList contributions;
	
	/**
	 * Initializes the provider
	 * @param proxied The original provider
	 * @param exceptions Entry IDs that should never be filtered
	 */
	public FilteringPaletteProvider(DefaultPaletteProvider proxied, String[] exceptions) {
		this.proxied = proxied;
		this.exceptions = exceptions.clone();
	}
	
	/**
	 * Determines whether a palette element with the given entry ID should be exposed to the user
	 * @param editor a diagram editor to which a palette is being contributed
	 * @param entryID A palette element entry ID
	 * @return <code>true</code> if the element should be exposed
	 */
	public boolean shouldExpose(IEditorPart editor, String entryID) {
		for (int i=0; i!=exceptions.length; i++)
			if (entryID.startsWith(exceptions[i]))
				return true;
		return PolicyChecker.getCurrent().isInPalette(((DiagramEditor)editor).getDiagram(), entryID);
	}
	
	/**
	 * Clear the contributions of the proxied palette provider.
	 * This is necessary because the actual contributions depends on the diagram's properties.
	 */
	private void clearContributions() {
		// this is going to be dirty ...
		try {
			Field field = proxied.getClass().getDeclaredField("contributions");
			field.setAccessible(true);
			List<?> list = (List<?>)field.get(proxied);
			list.clear();
		}
		catch (Exception e) {
			Activator.getDefault().getPapyrusLog().error("Failed to setup the filtering palette's configuration", e);
		}
	}
	
	/**
	 * Retrieves the URI of the policy-enforced custom palette, if any
	 * 
	 * @return The policy-enforced custom palette's URI
	 */
	private String getCustomPalette(Diagram diagram) {
		ViewPrototype proto = ViewPrototype.get(diagram);
		PapyrusDiagram pd = (PapyrusDiagram) proto.getConfiguration();
		if (pd == null)
			return null;
		return pd.getCustomPalette();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider#contributeToPalette(org.eclipse.ui.IEditorPart, java.lang.Object, org.eclipse.gef.palette.PaletteRoot, java.util.Map)
	 */
	public void contributeToPalette(IEditorPart editor, Object content, PaletteRoot root, Map predefinedEntries) {
		// the view needs to be known now because the actual filtering is called within setContributions
		Diagram diagram = ((DiagramEditor)editor).getDiagram();
		
		// Setting up the actual contribution
		clearContributions();
		proxied.setContributions(config);
		// delegate the call to the proxied provider which is now ready
		proxied.contributeToPalette(editor, content, root, predefinedEntries);
		
		// retrieves the custom palette
		String paletteURI = getCustomPalette(diagram);
		if (paletteURI != null && !paletteURI.isEmpty()) {
			CustomPaletteProvider provider = new CustomPaletteProvider();
			provider.setContributions(paletteURI);
			contributions = provider.getContributions();
			List<String> nodesID = WalkerPaletteContribution.getAllPaletteNodesID(contributions);
			
			// verify if the elements (nodes) from the custom palette already contributed
			if (!isCustomPaletteContributed(predefinedEntries, nodesID)) {
				provider.contributeToPalette(editor, content, root, predefinedEntries);
			}
		}
    }
	
	/**
	 * Verify if the elements (nodes) from the custom palette already contributed
	 * 
	 * @param predefinedEntries
	 * 				the Predefined Entries already added
	 * @param nodesID
	 * 				the list of elements (nodes) ID from the custom palette
	 * @return true or false
	 */
	public boolean isCustomPaletteContributed(Map predefinedEntries, List<String> nodesID) {
		 for (String nodeID : nodesID ) {
			 if (!predefinedEntries.containsKey(nodeID)) {
				 return false;
			 }
		 }
        return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider#setContributions(org.eclipse.core.runtime.IConfigurationElement)
	 */
	public void setContributions(IConfigurationElement configElement) { config = configElement; }
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) { return proxied.provides(operation); }

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#addProviderChangeListener(org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener)
	 */
	public void addProviderChangeListener(IProviderChangeListener listener) { proxied.addProviderChangeListener(listener); }

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#removeProviderChangeListener(org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener)
	 */
	public void removeProviderChangeListener(IProviderChangeListener listener) { proxied.removeProviderChangeListener(listener); }
}
