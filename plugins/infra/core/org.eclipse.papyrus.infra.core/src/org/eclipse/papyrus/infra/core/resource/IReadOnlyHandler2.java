/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.core.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Optional;


/**
 * An optional extension interface for {@linkplain IReadOnlyHandler read-only handlers} that support making files writable.
 */
public interface IReadOnlyHandler2 extends IReadOnlyHandler {

	/**
	 * Queries whether I can make the resources indicated by the given URIs writable.
	 * 
	 * @param uris
	 *        indicate a set of resources (presumed read-only)
	 * @return a {@linkplain Optional#isPresent() present} boolean indicating either that I can make the resources writable or that I handle these
	 *         kinds of resources and they cannot be made writable; an {@linkplain Optional#absent() absent} value, otherwise
	 */
	Optional<Boolean> canMakeWritable(URI[] uris);

	/**
	 * Queries whether I can make the given {@code object} writable.
	 * 
	 * @param object
	 *        a model element (presumed read-only)
	 * @return a {@linkplain Optional#isPresent() present} boolean indicating either that I can make the {@code object writable or that I handle its
	 *         kind of resources and it cannot be made writable; an {@linkplain Optional#absent() absent} value, otherwise
	 */
	Optional<Boolean> canMakeWritable(EObject object);
}
