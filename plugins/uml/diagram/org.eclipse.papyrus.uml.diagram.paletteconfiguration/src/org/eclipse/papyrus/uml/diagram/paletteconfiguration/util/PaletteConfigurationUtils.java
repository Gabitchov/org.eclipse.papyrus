/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.paletteconfiguration.util;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ChildConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.LeafConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationFactory;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.SeparatorConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.StackConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration;


/**
 * Utility class for {@link PaletteConfiguration} elements
 */
public class PaletteConfigurationUtils {

	public static Collection<String> getRequiredProfiles(PaletteConfiguration paletteConfiguration) {
		if(paletteConfiguration == null) {
			return Collections.emptyList();
		}
		return paletteConfiguration.getRequiredProfiles();
	}
	
	/**
	 * Removes a configuration from its container
	 * 
	 * @param configuration
	 *        the configuration to remove
	 * @return <code>true</code> if the configuration was removed from its container
	 */
	public static boolean removeConfiguration(Configuration configuration) {
		return new PaletteconfigurationSwitch<Boolean>() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public Boolean caseStackConfiguration(StackConfiguration configuration) {
				return removeStack(configuration);
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public Boolean caseDrawerConfiguration(DrawerConfiguration configuration) {
				return removeDrawer(configuration);
			};

			/**
			 * {@inheritDoc}
			 */
			@Override
			public Boolean caseToolConfiguration(ToolConfiguration configuration) {
				return removeTool(configuration);
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public Boolean caseSeparatorConfiguration(SeparatorConfiguration configuration) {
				return removeSeparator(configuration);
			};
		}.doSwitch(configuration);
	}

	/**
	 * Removes a drawer from a palette configuration
	 * 
	 * @param configuration
	 *        the drawer configuration to remove
	 * @return <code>true</code> if the drawer configuration has been removed
	 */
	public static boolean removeDrawer(DrawerConfiguration configuration) {
		EObject container = configuration.eContainer();
		if(!(container instanceof PaletteConfiguration)) {
			return false;
		}

		PaletteConfiguration paletteConfiguration = ((PaletteConfiguration)container);
		return paletteConfiguration.getDrawerConfigurations().remove(configuration);
	}

	/**
	 * Removes a stack from a palette configuration
	 * 
	 * @param configuration
	 *        the stack configuration to remove
	 * @return <code>true</code> if the stack configuration has been removed
	 */
	public static boolean removeStack(StackConfiguration configuration) {
		EObject container = configuration.eContainer();
		if(!(container instanceof DrawerConfiguration)) {
			return false;
		}

		DrawerConfiguration drawerConfiguration = ((DrawerConfiguration)container);
		return drawerConfiguration.getOwnedConfigurations().remove(configuration);
	}

	/**
	 * Removes a tool from its container
	 * 
	 * @param configuration
	 *        the tool configuration to remove
	 * @return <code>true</code> if the tool configuration has been removed
	 */
	public static boolean removeTool(ToolConfiguration configuration) {
		EObject container = configuration.eContainer();
		if((container instanceof DrawerConfiguration)) {
			DrawerConfiguration drawerConfiguration = ((DrawerConfiguration)container);
			return drawerConfiguration.getOwnedConfigurations().remove(configuration);
		} else if((container instanceof StackConfiguration)) {
			StackConfiguration stackConfiguration = ((StackConfiguration)container);
			return stackConfiguration.getOwnedConfigurations().remove(configuration);
		}
		return false;
	}

	/**
	 * Removes a separator from its container
	 * 
	 * @param configuration
	 *        the separator configuration to remove
	 * @return <code>true</code> if the separator configuration has been removed
	 */
	public static boolean removeSeparator(SeparatorConfiguration configuration) {
		EObject container = configuration.eContainer();
		if((container instanceof DrawerConfiguration)) {
			DrawerConfiguration drawerConfiguration = ((DrawerConfiguration)container);
			return drawerConfiguration.getOwnedConfigurations().remove(configuration);
		} else if((container instanceof StackConfiguration)) {
			StackConfiguration stackConfiguration = ((StackConfiguration)container);
			return stackConfiguration.getOwnedConfigurations().remove(configuration);
		}
		return false;
	}

	/**
	 * Creates a new separator configuration and adds it to the specified parent configuration
	 * 
	 * @param drawerConfiguration
	 *        parent configuration for the created separator
	 * @return the created separator configuration
	 */
	public static SeparatorConfiguration createSeparator(DrawerConfiguration drawerConfiguration) {
		String id = generateID("Separator");
		SeparatorConfiguration separatorConfiguration = PaletteconfigurationFactory.eINSTANCE.createSeparatorConfiguration();
		separatorConfiguration.setId(id);
		separatorConfiguration.setLabel(id);
		drawerConfiguration.getOwnedConfigurations().add(separatorConfiguration);
		return separatorConfiguration;
	}

	/**
	 * Creates a new separator configuration and adds it to the specified parent configuration
	 * 
	 * @param leafConfiguration
	 *        configuration after which the created separator should be added
	 * @return the created separator configuration
	 */
	public static SeparatorConfiguration createSeparator(LeafConfiguration leafConfiguration) {
		String id = generateID("Separator");
		SeparatorConfiguration separatorConfiguration = PaletteconfigurationFactory.eINSTANCE.createSeparatorConfiguration();
		separatorConfiguration.setId(id);
		separatorConfiguration.setLabel(id);
		EObject parentContainer = leafConfiguration.eContainer();
		if(parentContainer instanceof DrawerConfiguration) {
			int i = ((DrawerConfiguration)parentContainer).getOwnedConfigurations().indexOf(leafConfiguration);
			if(i >= 0) {
				((DrawerConfiguration)parentContainer).getOwnedConfigurations().add(i + 1, separatorConfiguration);
			} else
				throw new RuntimeException("Impossible to find the index of the configuration: " + leafConfiguration);
		} else
			throw new RuntimeException("Impossible to create a stack outside a DrawerConfiguration: " + leafConfiguration);
		return separatorConfiguration;
	}

	/**
	 * Creates a new stack configuration and adds it to the specified parent configuration
	 * 
	 * @param drawerConfiguration
	 *        parent configuration for the created separator
	 * @return the stack separator configuration
	 */
	public static StackConfiguration createStack(DrawerConfiguration drawerConfiguration) {
		String id = generateID("Stack");
		StackConfiguration stackConfiguration = PaletteconfigurationFactory.eINSTANCE.createStackConfiguration();
		stackConfiguration.setId(id);
		stackConfiguration.setLabel(id);
		drawerConfiguration.getOwnedConfigurations().add(stackConfiguration);
		return stackConfiguration;
	}

	/**
	 * Creates a new stack configuration and adds it after the given leaf configuration
	 * 
	 * @param leafConfiguration
	 *        the configuration after which the created configuration is added
	 * @return the stack separator configuration
	 */
	public static StackConfiguration createStack(LeafConfiguration leafConfiguration) {
		String id = generateID("Stack");
		StackConfiguration stackConfiguration = PaletteconfigurationFactory.eINSTANCE.createStackConfiguration();
		stackConfiguration.setId(id);
		stackConfiguration.setLabel(id);
		EObject parentContainer = leafConfiguration.eContainer();
		if(parentContainer instanceof DrawerConfiguration) {
			int i = ((DrawerConfiguration)parentContainer).getOwnedConfigurations().indexOf(leafConfiguration);
			if(i > 0) {
				((DrawerConfiguration)parentContainer).getOwnedConfigurations().add(i + 1, stackConfiguration);
			} else
				throw new RuntimeException("Impossible to find the index of the configuration: " + leafConfiguration);
		} else
			throw new RuntimeException("Impossible to create a stack outside a DrawerConfiguration: " + leafConfiguration);
		return stackConfiguration;
	}

	/**
	 * Creates a new drawer configuration and adds it to the given paletteConfiguration
	 * 
	 * @param paletteConfiguration
	 *        the container of the created configuration
	 * @return the drawer configuration
	 */
	public static void createDrawer(PaletteConfiguration paletteConfiguration) {
		boolean isFound = false;
		String newName = "";
		for(int i = 0; i < 100 && !isFound; i++) {
			isFound = false;
			boolean alreadyExists = false;
			String newLabel = "Drawer_" + i;
			Iterator<DrawerConfiguration> it = paletteConfiguration.getDrawerConfigurations().iterator();
			while(it.hasNext()) {
				DrawerConfiguration configuration = it.next();
				String label = configuration.getLabel();
				if(newLabel.equalsIgnoreCase(label)) {
					alreadyExists = true;
				}
			}

			if(!alreadyExists) {
				isFound = true;
				newName = newLabel;
			}
		}

		DrawerConfiguration drawerConfiguration = PaletteconfigurationFactory.eINSTANCE.createDrawerConfiguration();
		drawerConfiguration.setId(generateID("Drawer"));
		drawerConfiguration.setLabel(newName);
		paletteConfiguration.getDrawerConfigurations().add(drawerConfiguration);
	}

	/**
	 * Generates the ID for a local element
	 * 
	 * @param base
	 *        the begining of the id
	 * @return the separator id
	 */
	protected static String generateID(String base) {
		StringBuffer id = new StringBuffer();
		id.append(base);
		id.append("_");
		id.append(System.currentTimeMillis());
		return id.toString();
	}

	/**
	 * Moves a drawer configuration before the specified one
	 * 
	 * @param paletteConfiguration
	 *        the configuration containing the drawer configurations
	 * @param drawerConfigurationToMove
	 *        the drawer configuration that should be moved
	 * @param drawerConfiguration
	 *        the drawer configuration in front of which the drawer configuration to move should be placed.
	 */
	public static void moveDrawerConfiguration(PaletteConfiguration paletteConfiguration, DrawerConfiguration drawerConfigurationToMove, DrawerConfiguration drawerConfiguration) {
		int referenceIndex = paletteConfiguration.getDrawerConfigurations().indexOf(drawerConfiguration);
		int indexToMove = paletteConfiguration.getDrawerConfigurations().indexOf(drawerConfigurationToMove);

		if(referenceIndex == -1) {
			Activator.log.error("Impossible to find the drawer before which the drawer to move should be placed", null);
			return;
		}

		if(indexToMove == -1) {
			Activator.log.error("Impossible to find the drawer to move", null);
			return;
		}

		if(referenceIndex == indexToMove) {
			// nothing to do, as this should be the same element..
			return;
		} else if(referenceIndex < indexToMove) { // the element to move is after the reference element. Remove it and ad it to the right place
			paletteConfiguration.getDrawerConfigurations().remove(drawerConfigurationToMove);
			paletteConfiguration.getDrawerConfigurations().add(referenceIndex, drawerConfigurationToMove);
		} else {
			paletteConfiguration.getDrawerConfigurations().remove(drawerConfigurationToMove);
			paletteConfiguration.getDrawerConfigurations().add(referenceIndex - 1, drawerConfigurationToMove);
		}

	}

	/**
	 * Moves a separator configuration in a drawer
	 * 
	 * @param drawerConfiguration
	 *        the configuration where to move the element. should be a {@link DrawerConfiguration}.
	 * @param separatorConfigurationToMove
	 *        the separator configuration to move
	 */
	public static void moveSeparatorConfiguration(DrawerConfiguration drawerConfiguration, SeparatorConfiguration separatorConfigurationToMove) {
		DrawerConfiguration oldContainer = (DrawerConfiguration)separatorConfigurationToMove.eContainer();
		if(oldContainer.equals(drawerConfiguration)) {
			drawerConfiguration.getOwnedConfigurations().remove(separatorConfigurationToMove);
		}
		drawerConfiguration.getOwnedConfigurations().add(separatorConfigurationToMove);
	}

	/**
	 * Moves the specified Separator configuration before the specified child configuration
	 * 
	 * @param childConfiguration
	 *        the configuration before which the {@link SeparatorConfiguration} should be moved
	 * @param separatorConfigurationToMove
	 *        the {@link SeparatorConfiguration} to move
	 */
	public static void moveSeparatorConfiguration(ChildConfiguration childConfiguration, SeparatorConfiguration separatorConfigurationToMove) {
		DrawerConfiguration parentConfiguration = (DrawerConfiguration)childConfiguration.eContainer();

		// check if the container of the separator configuration is the new one. If yes, the separator Configuration should be removed from its parent container first
		Configuration oldContainer = (Configuration)separatorConfigurationToMove.eContainer();

		// check indexes
		int index = parentConfiguration.getOwnedConfigurations().indexOf(childConfiguration);
		if(index == -1) {
			Activator.log.error("Impossible to find the child configuration:" + childConfiguration, null);
			return;
		}

		// now add the element. remove from the container if target and source container are equals (to avoid duplication) 
		if(oldContainer.equals(parentConfiguration)) {
			parentConfiguration.getOwnedConfigurations().remove(separatorConfigurationToMove);
		}

		parentConfiguration.getOwnedConfigurations().add(index, separatorConfigurationToMove);



	}

	/**
	 * Moves a stack configuration in a drawer
	 * 
	 * @param drawerConfiguration
	 *        the configuration where to move the element. should be a {@link DrawerConfiguration}.
	 * @param stackConfigurationToMove
	 *        the stack configuration to move
	 */
	public static void moveStackConfiguration(DrawerConfiguration drawerConfiguration, StackConfiguration stackConfigurationToMove) {
		DrawerConfiguration oldContainer = (DrawerConfiguration)stackConfigurationToMove.eContainer();
		if(oldContainer.equals(drawerConfiguration)) {
			drawerConfiguration.getOwnedConfigurations().remove(stackConfigurationToMove);
		}
		drawerConfiguration.getOwnedConfigurations().add(stackConfigurationToMove);

	}

	/**
	 * Moves the specified Stack configuration before the specified child configuration
	 * 
	 * @param childConfiguration
	 *        the configuration before which the {@link StackConfiguration} should be moved
	 * @param stackConfigurationToMove
	 *        the {@link StackConfiguration} to move
	 */
	public static void moveStackConfiguration(ChildConfiguration childConfiguration, StackConfiguration stackConfigurationToMove) {
		DrawerConfiguration parentConfiguration = (DrawerConfiguration)childConfiguration.eContainer();

		// check if the container of the stack configuration is the new one. If yes, the stack Configuration should be removed from its parent container first
		Configuration oldContainer = (Configuration)stackConfigurationToMove.eContainer();

		// check indexes
		int index = parentConfiguration.getOwnedConfigurations().indexOf(childConfiguration);
		if(index == -1) {
			Activator.log.error("Impossible to find the child configuration:" + childConfiguration, null);
			return;
		}

		// now add the element. remove from the container if target and source container are equals (to avoid duplication) 
		if(oldContainer.equals(parentConfiguration)) {
			parentConfiguration.getOwnedConfigurations().remove(stackConfigurationToMove);
		}

		parentConfiguration.getOwnedConfigurations().add(index, stackConfigurationToMove);
	}

	/**
	 * Moves a tool configuration in a drawer
	 * 
	 * @param drawerConfiguration
	 *        the configuration where to move the element. should be a {@link DrawerConfiguration}.
	 * @param toolConfigurationToMove
	 *        the tool configuration to move
	 */
	public static void moveToolConfiguration(DrawerConfiguration drawerConfiguration, ToolConfiguration toolConfigurationToMove) {
		Configuration oldContainer = (Configuration)toolConfigurationToMove.eContainer();
		if(oldContainer.equals(drawerConfiguration)) {
			drawerConfiguration.getOwnedConfigurations().remove(toolConfigurationToMove);
		}
		drawerConfiguration.getOwnedConfigurations().add(toolConfigurationToMove);
	}

	/**
	 * Moves the specified Tool configuration before the specified child configuration
	 * 
	 * @param childConfiguration
	 *        the configuration before which the {@link ToolConfiguration} should be moved
	 * @param toolConfigurationToMove
	 *        the {@link ToolConfiguration} to move
	 */
	public static void moveToolConfiguration(ChildConfiguration childConfiguration, ToolConfiguration toolConfigurationToMove) {
		EObject parentConfiguration = childConfiguration.eContainer();

		// check if the container of the stack configuration is the new one. If yes, the tool Configuration should be removed from its parent container first
		Configuration oldContainer = (Configuration)toolConfigurationToMove.eContainer();

		if(parentConfiguration instanceof DrawerConfiguration) {
			// check indexes
			int index = ((DrawerConfiguration)parentConfiguration).getOwnedConfigurations().indexOf(childConfiguration);
			if(index == -1) {
				Activator.log.error("Impossible to find the child configuration:" + childConfiguration, null);
				return;
			}

			// now add the element. remove from the container if target and source container are equals (to avoid duplication) 
			if(oldContainer.equals(parentConfiguration)) {
				((DrawerConfiguration)parentConfiguration).getOwnedConfigurations().remove(toolConfigurationToMove);
			}

			((DrawerConfiguration)parentConfiguration).getOwnedConfigurations().add(index, toolConfigurationToMove);
		} else if(parentConfiguration instanceof StackConfiguration) {
			// check indexes
			int index = ((StackConfiguration)parentConfiguration).getOwnedConfigurations().indexOf(childConfiguration);
			if(index == -1) {
				Activator.log.error("Impossible to find the child configuration:" + childConfiguration, null);
				return;
			}

			// now add the element. remove from the container if target and source container are equals (to avoid duplication) 
			if(oldContainer.equals(parentConfiguration)) {
				((StackConfiguration)parentConfiguration).getOwnedConfigurations().remove(toolConfigurationToMove);
			}

			((StackConfiguration)parentConfiguration).getOwnedConfigurations().add(index, toolConfigurationToMove);
		} else {
			Activator.log.error("Not handled yet: parent of the tool is:" + parentConfiguration, null);
		}
	}

	/**
	 * Moves the specified Tool configuration before the specified child configuration
	 * 
	 * @param stackConfiguration
	 *        the configuration before which the {@link ToolConfiguration} should be moved
	 * @param toolConfigurationToMove
	 *        the {@link ToolConfiguration} to move
	 */
	public static void moveToolConfiguration(StackConfiguration stackConfiguration, ToolConfiguration toolConfigurationToMove) {
		// check if the container of the stack configuration is the new one. If yes, the tool Configuration should be removed from its parent container first
		EObject oldContainer = toolConfigurationToMove.eContainer();

		// now add the element. remove from the container if target and source container are equals (to avoid duplication) 
		if(oldContainer.equals(stackConfiguration)) {
			stackConfiguration.getOwnedConfigurations().remove(toolConfigurationToMove);
		}

		stackConfiguration.getOwnedConfigurations().add(toolConfigurationToMove);
	}

}
