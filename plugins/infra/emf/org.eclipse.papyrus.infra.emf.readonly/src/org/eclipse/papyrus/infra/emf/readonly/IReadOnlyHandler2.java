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
package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * An extension of the {@link IReadOnlyHandler} protocol that allows a handler
 * to declare that it definitively knows the answer to the read-only question,
 * and the subsequent handlers in the chain should not be consulted even if the
 * result is {@code false}.
 */
public interface IReadOnlyHandler2
		extends IReadOnlyHandler {

	/**
	 * Queries whether I can provide a yes/no answer to the question of the
	 * read-only-ness of the given URIs in the context of a particular editing
	 * domain.
	 * 
	 * @param uris
	 *            the URIs about which read-only-ness is to be determined
	 * @param editingDomain
	 *            the domain in the context of which editing is being done
	 * 
	 * @return whether I can provide a reliable answer for these URIs
	 */
	boolean handlesURIs(URI[] uris, EditingDomain editingDomain);
}
