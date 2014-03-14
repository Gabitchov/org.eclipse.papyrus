/*****************************************************************************
 * Copyright (c) 2013, 2014 Atos Origin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *  Christian W. Damus (CEA) - bug 429826
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @deprecated Use the {@link org.eclipse.papyrus.infra.core.resource.AbstractReadOnlyHandler} class, instead.
 */
@Deprecated
public abstract class AbstractReadOnlyHandler extends org.eclipse.papyrus.infra.core.resource.AbstractReadOnlyHandler {

	public AbstractReadOnlyHandler(EditingDomain editingDomain) {
		super(editingDomain);
	}
}
