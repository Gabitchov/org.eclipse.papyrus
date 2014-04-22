/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Thibault Le Ouay t.leouay@sherpa-eng.com
 *****************************************************************************/


package org.eclipse.papyrus.customization.properties.generation.validators;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.customization.properties.generation.generators.EcoreGenerator;
import org.eclipse.papyrus.customization.properties.generation.generators.IGenerator;
import org.eclipse.papyrus.customization.properties.generation.generators.ProfileGenerator;
import org.eclipse.papyrus.customization.properties.generation.messages.Messages;

public class SourceValidator extends AbstractValidator {
	protected IGenerator generator;

	public SourceValidator(IGenerator generator) {
		this.generator = generator;
	}

	public IStatus validate(Object value) {
		if (value instanceof String) {
			String s = (String) value;
			if (!s.equals("")) { //$NON-NLS-1$
				if (this.generator instanceof EcoreGenerator) {
					if (!s.endsWith("ecore")) { //$NON-NLS-1$
						return error(Messages.SourceValidator_2);
					}
				} else if (this.generator instanceof ProfileGenerator) {
					if (!s.endsWith("profile.uml")) { //$NON-NLS-1$
						return error(Messages.SourceValidator_4);
					}
				}

				IWorkspaceRoot myWorkspaceRoot = ResourcesPlugin.getWorkspace()
						.getRoot();
				IFile file =null;
				try{
					IPath path = new Path(s);
					file = myWorkspaceRoot.getFile(path);

				}
				catch(IllegalArgumentException ex){
					return error(ex.getMessage());
				}
				if (!file.exists()) {
					return error(Messages.SourceValidator_5);

				}
			}
			else return error(Messages.SourceValidator_6);
			
			return Status.OK_STATUS;

		}
		return error(Messages.SourceValidator_7);
	}

}
