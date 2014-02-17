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
package org.eclipse.papyrus.uml.diagram.paletteconfiguration.provider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.ContributeToPaletteOperation;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.gef.ui.internal.palette.PaletteStack;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.uml.diagram.common.part.PapyrusPalettePreferences;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.Activator;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ChildConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.LeafConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.SeparatorConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.StackConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.util.PaletteconfigurationSwitch;
import org.eclipse.ui.IEditorPart;
import org.osgi.framework.Bundle;


/**
 * Palette provider with enhanced elements types
 */
public class ExtendedPluginPaletteProvider extends AbstractProvider implements IPaletteProvider {

	/** name of the type */
	public static final String TYPE_NAME = "testSpecializationTypeName";

	/** palette factory */
	protected ExtendedPaletteFactory paletteFactory = new ExtendedPaletteFactory();

	/** path to the palette configuration model in the bundle */
	protected static final String PATH = "path";

	/** name of the attribute: id of the palette */
	private static final String ID = "ID";

	/** id of the plugin declaring the extension */
	protected String contributorID;

	/** unique identifier for this palette contribution */
	protected String paletteID;

	/** contributions to the palette */
	protected List<PaletteConfiguration> contributions;

	/** map for toolID => extended element type */
	protected Map<String, IElementTypesBasedTool> mapToolId2Entries = new HashMap<String, IElementTypesBasedTool>();

	/** default icon for tools */
	protected static final ImageDescriptor DEFAULT_TOOL_IMAGE_DESCRIPTOR = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/tool.gif");

	/** default icon for stacks */
	protected static final ImageDescriptor DEFAULT_STACK_IMAGE_DESCRIPTOR = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/stack.gif");

	/** default icon for drawers */
	protected static ImageDescriptor DEFAULT_DRAWER_IMAGE_DESCRIPTOR = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "/icons/drawer.gif");

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof ContributeToPaletteOperation) {
			IEditorPart part = ((ContributeToPaletteOperation)operation).getEditor();
			// check this can be a papyrus one. Otherwise, there should be no contribution
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void contributeToPalette(IEditorPart editor, Object content, PaletteRoot root, Map predefinedEntries) {
		// for each element in the contribution list, create drawers/tools/stacks/etc.
		if(contributions == null || contributions.size() == 0) {
			return;
		}

		// work for each configuration
		for(PaletteConfiguration configuration : contributions) {
			List<DrawerConfiguration> drawerConfigurations = configuration.getDrawerConfigurations();
			if(drawerConfigurations != null && drawerConfigurations.size() > 0) {
				for(DrawerConfiguration drawerConfiguration : drawerConfigurations) {
					generateDrawer(root, drawerConfiguration, predefinedEntries);
				}
			}
		}
	}

	/**
	 * Generates the drawer and its content from its configuration
	 * 
	 * @param root
	 *        the root container of the palette
	 * @param drawerConfiguration
	 *        the configuration that manages the drawer
	 * @param predefinedEntries
	 *        predefined existing entries
	 */
	@SuppressWarnings("restriction")
	protected PaletteDrawer generateDrawer(PaletteRoot root, DrawerConfiguration drawerConfiguration, Map predefinedEntries) {
		String id = drawerConfiguration.getId();
		// retrieve drawer or create one if necessary
		PaletteDrawer drawer = retrieveExistingEntry(predefinedEntries, id, PaletteDrawer.class);
		if(drawer == null) {
			String label = drawerConfiguration.getLabel();
			drawer = new ExtendedPaletteDrawer(label, id);
			// complete entry: description and icon
			completeEntry(drawerConfiguration, drawer);
			predefinedEntries.put(id, drawer);
			root.add(drawer);
		}

		generateContent(drawer, drawerConfiguration, predefinedEntries);

		return drawer;
	}

	/**
	 * Completes the entry with information like description, icon, etc.
	 * 
	 * @param configuration
	 *        the configuration of the entry
	 * @param entry
	 *        the entry to customize
	 */
	protected void completeEntry(Configuration configuration, PaletteEntry entry) {
		// description
		entry.setDescription(configuration.getDescription());

		// icon. If it is not set, the tool should use the icon of the type created by the tool
		ImageDescriptor imageDescriptor = null;
		IconDescriptor iconDescriptor = configuration.getIcon();
		if(iconDescriptor != null) {
			String bundleID = iconDescriptor.getPluginID();
			if(bundleID == null) {
				// by default, try to load images in the plugin that declares the configuration
				bundleID = contributorID;
			}
			String iconPath = iconDescriptor.getIconPath();
			imageDescriptor = Activator.imageDescriptorFromPlugin(bundleID, iconPath);
		}

		if(imageDescriptor == null && configuration instanceof ToolConfiguration) {
			ToolConfiguration toolConfiguration = ((ToolConfiguration)configuration);
			// FIXME retrieve icon from the element type 
		}

		// retrieve the default icon for drawers, stacks or tools.
		if(imageDescriptor == null) {
			imageDescriptor = new PaletteconfigurationSwitch<ImageDescriptor>() {

				/**
				 * {@inheritDoc}
				 */
				@Override
				public ImageDescriptor caseDrawerConfiguration(DrawerConfiguration object) {
					return ExtendedPluginPaletteProvider.DEFAULT_DRAWER_IMAGE_DESCRIPTOR;
				};

				/**
				 * {@inheritDoc}
				 */
				@Override
				public ImageDescriptor caseToolConfiguration(ToolConfiguration object) {
					return ExtendedPluginPaletteProvider.DEFAULT_TOOL_IMAGE_DESCRIPTOR;
				};

				/**
				 * {@inheritDoc}
				 */
				@Override
				public ImageDescriptor caseStackConfiguration(StackConfiguration object) {
					return ExtendedPluginPaletteProvider.DEFAULT_STACK_IMAGE_DESCRIPTOR;
				};

				/**
				 * {@inheritDoc}
				 */
				@Override
				public ImageDescriptor defaultCase(org.eclipse.emf.ecore.EObject object) {
					return null;
				};
			}.doSwitch(configuration);
		}

		if(imageDescriptor != null) {
			entry.setLargeIcon(imageDescriptor);
			entry.setSmallIcon(imageDescriptor);
		}
	}

	/**
	 * Generates the content for a palette drawer
	 * 
	 * @param drawer
	 *        the drawer to complete
	 * @param drawerConfiguration
	 *        the configuration of the drawer
	 * @param predefinedEntries
	 *        predefined existing entries
	 */
	protected void generateContent(PaletteDrawer drawer, DrawerConfiguration drawerConfiguration, Map predefinedEntries) {
		for(ChildConfiguration configuration : drawerConfiguration.getOwnedConfigurations()) {
			if(configuration.eClass().equals(PaletteconfigurationPackage.eINSTANCE.getStackConfiguration())) {
				generateStack(drawer, (StackConfiguration)configuration, predefinedEntries);
			} else if(configuration.eClass().equals(PaletteconfigurationPackage.eINSTANCE.getToolConfiguration())) {
				generateTool(drawer, (ToolConfiguration)configuration, predefinedEntries);
			} else if(configuration.eClass().equals(PaletteconfigurationPackage.eINSTANCE.getSeparatorConfiguration())) {
				generateSeparator(drawer, (SeparatorConfiguration)configuration, predefinedEntries);
			}
		}
	}

	/**
	 * Generates the tool from its configuration and container
	 * 
	 * @param container
	 *        the container in which the tool should be added
	 * @param configuration
	 *        the configuration of the tool entry
	 * @param predefinedEntries
	 *        predefined existing entries
	 */
	protected CombinedTemplateCreationEntry generateTool(PaletteContainer container, ToolConfiguration configuration, Map predefinedEntries) {
		switch(configuration.getKind()) {
		case CONNECTION_TOOL:
			return generateConnectionTool(container, configuration, predefinedEntries);
		case CREATION_TOOL:
			return generateCreationTool(container, configuration, predefinedEntries);
		}
		return null;
	}

	/**
	 * Generates the connection tool from its configuration and container
	 * 
	 * @param container
	 *        the container in which the tool should be added
	 * @param configuration
	 *        the configuration of the tool entry
	 * @param predefinedEntries
	 *        predefined existing entries
	 */
	protected CombinedTemplateCreationEntry generateConnectionTool(PaletteContainer container, ToolConfiguration configuration, Map predefinedEntries) {
		String toolID = configuration.getId();
		CombinedTemplateCreationEntry toolEntry = retrieveExistingEntry(predefinedEntries, toolID, CombinedTemplateCreationEntry.class);

		if(toolEntry == null) {
			// create a new one from the configuration
			String label = configuration.getLabel();
			// create icon descriptor
			toolEntry = new ExtendedConnectionToolEntry(toolID, label, paletteFactory, configuration.getElementDescriptors());
			completeEntry(configuration, toolEntry);
			container.add(toolEntry);
			// register the tool in the tool predefined entries
			predefinedEntries.put(toolID, toolEntry);
			mapToolId2Entries.put(toolID, (ExtendedConnectionToolEntry)toolEntry);
		}

		return toolEntry;
	}

	/**
	 * Generates the creation tool from its configuration and container
	 * 
	 * @param container
	 *        the container in which the tool should be added
	 * @param configuration
	 *        the configuration of the tool entry
	 * @param predefinedEntries
	 *        predefined existing entries
	 */
	protected CombinedTemplateCreationEntry generateCreationTool(PaletteContainer container, ToolConfiguration configuration, Map predefinedEntries) {
		String toolID = configuration.getId();
		CombinedTemplateCreationEntry toolEntry = retrieveExistingEntry(predefinedEntries, toolID, CombinedTemplateCreationEntry.class);

		if(toolEntry == null) {
			// create a new one from the configuration
			String label = configuration.getLabel();
			// create icon descriptor
			toolEntry = new ExtendedCreationToolEntry(toolID, label, paletteFactory, configuration.getElementDescriptors());
			completeEntry(configuration, toolEntry);
			container.add(toolEntry);
			// register the tool in the tool predefined entries
			predefinedEntries.put(toolID, toolEntry);
			mapToolId2Entries.put(toolID, (ExtendedCreationToolEntry)toolEntry);
		}

		return toolEntry;
	}


	/**
	 * Try to retrieve a tool entry in the list of predefined entries
	 * 
	 * @param toolID
	 *        id of the tool to look for
	 * @param predefinedEntries
	 *        predefined existing entries
	 * @return the tool found or <code>null</code>
	 */
	protected PaletteToolEntry retrieveTool(String toolID, Map predefinedEntries) {
		Object value = predefinedEntries.get(toolID);
		if(value instanceof PaletteToolEntry) {
			return ((PaletteToolEntry)value);
		}
		return null;
	}

	/**
	 * Generates the stack and its content from its configuration and container
	 * 
	 * @param container
	 *        the container in which the stack should be added
	 * @param configuration
	 *        the configuration of the stack
	 * @param predefinedEntries
	 *        predefined existing entries
	 */
	@SuppressWarnings("restriction")
	protected PaletteStack generateStack(PaletteContainer container, StackConfiguration configuration, Map predefinedEntries) {
		String stackID = configuration.getId();
		PaletteStack stack = retrieveExistingEntry(predefinedEntries, stackID, PaletteStack.class);

		if(stack == null) {
			// create a new one from the configuration
			String label = configuration.getLabel();
			String description = configuration.getDescription();
			// create icon descriptor
			stack = new PaletteStack(stackID, label, description, DEFAULT_STACK_IMAGE_DESCRIPTOR);
			completeEntry(configuration, stack); // seems to be not useful, as the constructor has all informations
			predefinedEntries.put(stackID, stack);
			container.add(stack);
		}

		// generate the nodes of the stack
		for(LeafConfiguration leafConfiguration : configuration.getOwnedConfigurations()) {
			if(leafConfiguration instanceof SeparatorConfiguration) {
				generateSeparator(stack, (SeparatorConfiguration)leafConfiguration, predefinedEntries);
			} else if(leafConfiguration instanceof ToolConfiguration) {
				generateTool(stack, (ToolConfiguration)leafConfiguration, predefinedEntries);	
			}
		}

		return stack;
	}

	/**
	 * Generates a {@link PaletteSeparator}, adds it to a container and returns it
	 * @param container the container where to add the created separator
	 * @param leafConfiguration the configuration of the element to create
	 * @param predefinedEntries the predefined entries (unused here)
	 * @return the created separator
	 */
	protected PaletteSeparator generateSeparator(PaletteContainer container, SeparatorConfiguration leafConfiguration, Map predefinedEntries) {
		PaletteSeparator separator = new PaletteSeparator(leafConfiguration.getId()) ;
		container.add(separator);
		return separator;
	}

	/**
	 * Retrieve an existing drawer from the current root node
	 * 
	 * @param predefinedEntries
	 *        the currently existing palette entries
	 * @param id
	 *        the id of the drawer to retrieve
	 * @param entryClass
	 *        the type of element to retrieve
	 * @return the drawer found or <code>null</code> if no drawer was retrieved
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <T extends PaletteEntry> T retrieveExistingEntry(Map predefinedEntries, String id, Class<T> elementClass) {
		Object value = predefinedEntries.get(id);
		if(value == null) {
			return null;
		}
		if(elementClass.isAssignableFrom(value.getClass())) {
			return (T)value;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setContributions(IConfigurationElement configElement) {
		// retrieve the model file
		contributorID = configElement.getNamespaceIdentifier();
		paletteID = configElement.getAttribute(ID);
		String path = configElement.getAttribute(PATH);

		if(paletteID == null) {
			Activator.log.error("Impossible to find the palette identifier for contribution " + configElement.getValue(), null);
			contributions = Collections.emptyList();
			return;
		}
		if(path == null) {
			Activator.log.error("Impossible to find the path for contribution " + configElement.getValue(), null);
			contributions = Collections.emptyList();
			return;
		}

		Bundle bundle = Platform.getBundle(contributorID);
		if(bundle == null) {
			Activator.log.error("Impossible to find the bundle with ID: " + contributorID, null);
			contributions = Collections.emptyList();
			return;
		}

		try {
			contributions = loadConfigurationModel(bundle, path);
		} catch (FileNotFoundException e) {
			Activator.log.error(e);
			contributions = Collections.emptyList();
		} catch (IOException e) {
			Activator.log.error(e);
			contributions = Collections.emptyList();
		}
	}

	/**
	 * Loads and returns the model, given the bundle and path of the model file.
	 * 
	 * @param bundle
	 *        the id of the bundle
	 * @param path
	 *        the path to the file in the bundle
	 */
	protected List<PaletteConfiguration> loadConfigurationModel(Bundle bundle, String path) throws FileNotFoundException, IOException {
		// stores the bundle in which the resource is located.
		// warning: in case of fragments, the contributor id can the the plugin, but the file can be localized in the fragment
		// In this case, the real bundle used to load the file is the fragment bundle...
		// String bundleId = null;

		// creates a resource set that will load the configuration
		ResourceSet resourceSet = new ResourceSetImpl();

		Resource resource = loadResourceFromPreferences(resourceSet);

		if(resource == null) {
			resource = loadResourceFromPlugin(bundle, path, resourceSet);
		}

		if(resource == null) {
			throw new FileNotFoundException("Loading palette configuration... Impossible to find a resource for path; " + path + " for bundle: " + bundle);
		}
		resource.load(Collections.emptyMap());
		if(resource.getContents().size() > 0) {

			return new ArrayList<PaletteConfiguration>(EcoreUtil.<PaletteConfiguration> getObjectsByType(resource.getContents(), PaletteconfigurationPackage.eINSTANCE.getPaletteConfiguration()));
		}
		return Collections.emptyList();
	}

	/**
	 * Returns the id of the bundle that declares this provider, can be null if not yet initialized
	 * 
	 * @return the id of the bundle, or <code>null</code>
	 */
	protected String getContributorID() {
		return contributorID;
	}

	/**
	 * Returns the list of contribution for this provider
	 * 
	 * @return the list of contribution for this provider
	 */
	public List<PaletteConfiguration> getContributions() {
		return contributions;
	}

	/**
	 * Returns the resource used for the configuration.
	 * <P>
	 * It checks in the preferences area, then in the plugin area
	 * </P>
	 */
	protected Resource loadResourceFromPreferences(ResourceSet resourceSet) {
		Resource resource = null;
		// look in preference area
		String path = PapyrusPalettePreferences.getPaletteRedefinition(paletteID);
		if(path != null) {
			// read in preferences area of diagram common! Thus, it can be accessed from the common plugin...
			IPath resourcePath = org.eclipse.papyrus.uml.diagram.common.Activator.getDefault().getStateLocation().append(path);
			URI uri = URI.createFileURI(resourcePath.toOSString());
			if(uri != null && uri.isFile()) {
				resource = resourceSet.createResource(uri);
				if(resource != null) {
					return resource;
				}
			}

		}
		return resource;
	}

	/**
	 * Loads the resource from the plugin area
	 * 
	 * @return the resource to load.
	 * @throws FileNotFoundException
	 */
	protected Resource loadResourceFromPlugin(Bundle bundle, String path, ResourceSet resourceSet) throws FileNotFoundException {
		Resource resource = null;
		String bundleId = null;
		// try to load the resource in the fragments of the bundle, then the bundle itself. 
		URL entry = null;
		// try in fragments...
		Bundle[] fragments = Platform.getFragments(bundle);
		if(fragments != null) {
			for(Bundle fragment : fragments) {
				entry = fragment.getEntry(path);
				if(entry != null) {
					bundleId = fragment.getSymbolicName();
					continue;
				}
			}
		}
		// look now in the bundle itself.
		if(entry == null) {
			entry = bundle.getEntry(path);
			// no entry was found in the children fragments, look in the bundle itself
			if(entry == null) {
				throw new FileNotFoundException("Loading palette configuration... Impossible to find a resource for path; " + path + " for bundle: " + bundle);
			} else {
				bundleId = bundle.getSymbolicName();
			}
		}

		resource = resourceSet.createResource(URI.createPlatformPluginURI("/" + bundleId + "/" + path, true));
		return resource;
	}

	/**
	 * factory used to create new tools for the extended palette provider. It will find or create a new element type for each tool which has extended
	 * features.
	 */
	public class ExtendedPaletteFactory extends PaletteFactory.Adapter {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Tool createTool(String toolId) {
			IElementTypesBasedTool toolEntry = mapToolId2Entries.get(toolId);
			if(toolEntry instanceof ExtendedCreationToolEntry) {
				return new AspectUnspecifiedTypeCreationTool(((ExtendedCreationToolEntry)toolEntry).getElementTypes());
			} else if(toolEntry instanceof ExtendedConnectionToolEntry) {
				return new AspectUnspecifiedTypeConnectionTool(((ExtendedConnectionToolEntry)toolEntry).getElementTypes());
			}
			Activator.log.warn("Impossible to create a tool for the given tool id: " + toolId + ". Tool Entry found was :" + toolEntry);
			return null;
		}
	}
}
