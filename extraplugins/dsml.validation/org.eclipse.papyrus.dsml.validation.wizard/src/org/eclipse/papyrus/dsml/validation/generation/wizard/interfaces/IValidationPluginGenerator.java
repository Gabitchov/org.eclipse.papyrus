/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.generation.wizard.interfaces;

import org.eclipse.core.resources.IProject;
import org.eclipse.papyrus.dsml.validation.model.elements.interfaces.IConstraintsManager;
import org.eclipse.pde.internal.ui.wizards.plugin.NewPluginProjectWizard;

public interface IValidationPluginGenerator {

	final static String PLUGIN_NATURE_ID = "org.eclipse.pde.PluginNature";

	public void generate(IProject project, NewPluginProjectWizard wizard, IConstraintsManager constraintsManager);

}
