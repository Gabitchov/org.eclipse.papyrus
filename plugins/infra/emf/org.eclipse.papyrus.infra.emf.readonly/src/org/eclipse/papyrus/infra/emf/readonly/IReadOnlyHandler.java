/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.edit.domain.EditingDomain;

public interface IReadOnlyHandler {

	/**
	 * Check if a set of files is read-only.
	 * A set of files is usually considered read-only if at least
	 * one of them is read only.
	 * 
	 * @param files
	 * @return
	 */
	boolean isReadOnly(IFile[] files, EditingDomain editingDomain);

	/**
	 * Try to enable write access on a set of files.
	 * 
	 * @param files
	 * @return false if it fails to get write access.
	 */
	boolean enableWrite(IFile[] files, EditingDomain editingDomain);
}
