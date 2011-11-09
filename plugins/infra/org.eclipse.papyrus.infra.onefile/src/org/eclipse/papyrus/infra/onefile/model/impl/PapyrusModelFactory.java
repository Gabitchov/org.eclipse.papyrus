/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.model.impl;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusModelFactory;
import org.eclipse.papyrus.infra.onefile.model.ISubResourceFile;

public class PapyrusModelFactory implements IPapyrusModelFactory {

	public IPapyrusFile createIPapyrusFile(IFile file) {
		return new PapyrusFile(file);
	}

	public ISubResourceFile createISubResourceFile(IPapyrusFile papy, IFile r) {
		return new SubResourceFile(papy, r);
	}

	public boolean isDi(IResource file) {
		return DiModel.DI_FILE_EXTENSION.equals(file.getFileExtension());
	}

}
