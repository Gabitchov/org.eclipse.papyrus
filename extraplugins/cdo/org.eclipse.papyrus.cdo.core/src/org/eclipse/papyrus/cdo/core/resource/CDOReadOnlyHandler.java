/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.core.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler2;


/**
 * This is the CDOReadOnlyHandler type.  Enjoy.
 */
public class CDOReadOnlyHandler
		implements IReadOnlyHandler2 {

	public CDOReadOnlyHandler() {
		super();
	}

	public boolean handlesURIs(URI[] uris, EditingDomain editingDomain) {
		boolean result = false;
		
		if ((uris.length > 0) && CDOUtils.isCDOEditingDomain(editingDomain)) {
			for (int i = 0; !result && (i < uris.length); i++) {
				if (CDOUtils.isCDOURI(uris[i])) {
					result = true;
				}
			}
		}
		
		return result;
	}
	
	public boolean isReadOnly(URI[] uris, EditingDomain editingDomain) {
		// TODO Support CDO permissions
		return false;
	}

	public boolean enableWrite(URI[] uris, EditingDomain editingDomain) {
		// TODO Support CDO permissions
		return true;
	}

}
