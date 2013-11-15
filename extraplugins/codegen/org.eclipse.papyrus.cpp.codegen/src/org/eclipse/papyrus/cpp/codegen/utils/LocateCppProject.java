/*******************************************************************************
 * Copyright (c) 2006 - 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.cpp.codegen.utils;

import org.eclipse.cdt.core.CCProjectNature;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.cpp.codegen.Activator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.PackageableElement;

public class LocateCppProject {
	/**
	 * Locate and return the target project for the given packageable element.  Return null if
	 * no target project can be found.
	 *
	 * Ensures that the target project is correctly setup to contain generated C/C++ code.  Does
	 * not create a new project, but may modify existing ones.
	 * 
	 * @param pe a packageable element within a model
	 * @param interactive if true, ask the user to apply the C++ nature if required.
	 * @return the associated project, if the C++ nature is applied.
	 */
	public static IProject getTargetProject(PackageableElement pe, boolean interactive) {
		URI uri = pe.eResource().getURI();

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if(uri.segmentCount() < 2)
			return null;
			
		IProject modelProject = root.getProject(uri.segment(1));
		if(!modelProject.exists())
			return null;
	
		// Make sure the target project has the C and C++ build natures.
		try {
			if(!modelProject.hasNature(CCProjectNature.CC_NATURE_ID)) {
				boolean apply = interactive && MessageDialog.openQuestion(new Shell(),
						Messages.LocateCppProject_0,
						Messages.LocateCppProject_1);
				if (!apply) {
					return null;
				}
				CCProjectNature.addCCNature(modelProject, null);
			}
		}
		catch(CoreException e) {
			Activator.log.error(e);
		}
		return modelProject;
	}
}
