/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.psf.runtime;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;


public class ImportResult {

	private IProject[] importedProjects;

	private Map<String, IStatus> diagnostic;

	public IProject[] getImportedProjects() {
		return importedProjects;
	}

	public void setImportedProjects(IProject[] importedProjects) {
		this.importedProjects = importedProjects;
	}

	public Map<String, IStatus> getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(Map<String, IStatus> diagnostic) {
		this.diagnostic = diagnostic;
	}

}
