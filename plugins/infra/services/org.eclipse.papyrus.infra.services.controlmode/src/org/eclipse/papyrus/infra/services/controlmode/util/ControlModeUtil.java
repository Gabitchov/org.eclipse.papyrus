/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.util;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.controlmode.ControlModePlugin;
import org.eclipse.papyrus.infra.services.controlmode.commands.IControlCondition;
import org.eclipse.papyrus.infra.services.controlmode.commands.IControlUncontrolCondition;

/**
 * 
 * @author Camille Letavernier
 * 
 */
public class ControlModeUtil {

	/** extension point ID for custom control command */
	private static final String CONTROL_CONDITION_EXTENSION_POINT_ID = "org.eclipse.papyrus.infra.services.controlmode.customControlCommand";

	/** attribute ID for the custom command class. */
	private static final String CONTROL_CONDITION_ATTRIBUTE_EXTENSION_POINT = "controlCondition";

	/** element ID for the custom command class. */
	private static final String CONTROL_CONDITION_ELEMENT_EXTENSION_POINT = "enableControlCommand";

	private static List<IControlCondition> commands = getCommandConditionsExtensions();

	/**
	 * Tests whether the parameter EObject can be controlled
	 * 
	 * @param eObject
	 * @return
	 */
	public static boolean canControl(EObject eObject) {
		boolean enableControl = true;
		for(IControlCondition cond : commands) {
			// check if action is disabled by an extension
			enableControl &= cond.enableControl(eObject);
		}

		EditingDomain domain = EMFHelper.resolveEditingDomain(eObject);

		return enableControl && domain.isControllable(eObject) && !AdapterFactoryEditingDomain.isControlled(eObject);
	}

	/**
	 * Tests whether the parameter EObject can be uncontrolled
	 * 
	 * @param eObject
	 * @return
	 */
	public static boolean canUncontrol(EObject eObject) {
		boolean enableUnControl = true;
		for(IControlCondition cond : commands) {
			if(cond instanceof IControlUncontrolCondition) {
				IControlUncontrolCondition controlUnControl = (IControlUncontrolCondition)cond;
				// check if action is disabled by an extension
				enableUnControl &= controlUnControl.enableUnControl(eObject);
			}
		}

		EditingDomain domain = EMFHelper.resolveEditingDomain(eObject);
		if(domain == null) {
			return false;
		}

		return enableUnControl && domain.isControllable(eObject) && AdapterFactoryEditingDomain.isControlled(eObject);
	}

	/**
	 * Gets the conditions that enable control action
	 * 
	 * @return the command extensions
	 */
	private static List<IControlCondition> getCommandConditionsExtensions() {
		List<IControlCondition> commands = new LinkedList<IControlCondition>();
		IConfigurationElement[] extensions = Platform.getExtensionRegistry().getConfigurationElementsFor(CONTROL_CONDITION_EXTENSION_POINT_ID);
		for(IConfigurationElement e : extensions) {
			if(CONTROL_CONDITION_ELEMENT_EXTENSION_POINT.equals(e.getName())) {
				try {
					IControlCondition controlCondition = (IControlCondition)e.createExecutableExtension(CONTROL_CONDITION_ATTRIBUTE_EXTENSION_POINT);
					commands.add(controlCondition);
				} catch (CoreException exception) {
					ControlModePlugin.log.error(exception);
				}
			}
		}
		return commands;
	}
}
