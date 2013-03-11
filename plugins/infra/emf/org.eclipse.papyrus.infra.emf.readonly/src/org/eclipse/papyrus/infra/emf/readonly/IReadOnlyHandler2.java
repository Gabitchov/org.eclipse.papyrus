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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.base.Optional;

/**
 * An alternative to the {@link IReadOnlyHandler} protocol that allows a handler
 * to declare that it definitively knows the answer to the read-only question,
 * and the subsequent handlers in the chain should not be consulted even if the
 * result is {@code false}.
 */
public interface IReadOnlyHandler2 {

	/**
	 * Queries whether any of the resources identified by the given URIs is
	 * read-only.
	 * 
	 * @param uris
	 *            the URIs about which read-only-ness is to be determined
	 * @param editingDomain
	 *            the domain in the context of which editing is being done
	 * 
	 * @return {@link Optional#absent() absent} if I do not know whether any of
	 *         the URIs is read-only or a {@link Optional#isPresent() present}
	 *         boolean indicating whether any definitively is or they all
	 *         definitively are not read-only
	 */
	Optional<Boolean> anyReadOnly(URI[] uris, EditingDomain editingDomain);

	/**
	 * Attempt to ensure that the resources identified by the given URIs are
	 * writable.
	 * 
	 * @param uris
	 *            the URIs of resources to make writable (not all are
	 *            necessarily read-only)
	 * @param editingDomain
	 *            the domain in the context of which editing is being done
	 * 
	 * @return {@link Optional#absent() absent} if I do not know how to make
	 *         these resources writable and the next provider should be given a
	 *         chance, or a {@link Optional#isPresent() present} boolean
	 *         indicating that I made the resources writable ({@code true}) or
	 *         they cannot be made writable ({@code false})
	 */
	Optional<Boolean> makeWritable(URI[] uris, EditingDomain editingDomain);

	/**
	 * Queries whether an {@code eObject} is individually read-only in a given
	 * editing domain, if it is in a resource that supports object-level
	 * read/write permissions.
	 * 
	 * @param eObject
	 *            an element in some model resource
	 * @param editingDomain
	 *            the contextual editing domain
	 * 
	 * @return {@link Optional#absent() absent} if I do not know whether the
	 *         {@code eObject} is read-only or a {@link Optional#isPresent()
	 *         present} boolean indicating whether it definitively is or is not
	 *         read-only
	 */
	Optional<Boolean> isReadOnly(EObject eObject, EditingDomain editingDomain);

	/**
	 * Attempt to ensure that the given {@code eObject} is writable.
	 * 
	 * @param eObject
	 *            a {@linkplain #isReadOnly(EObject, EditingDomain) read-only}
	 *            element in some model resource
	 * @param editingDomain
	 *            the domain in the context of which editing is being done
	 * 
	 * @return {@link Optional#absent() absent} if I do not know how to make
	 *         this object writable and the next provider should be given a
	 *         chance, or a {@link Optional#isPresent() present} boolean
	 *         indicating that I made it writable ({@code true}) or it cannot be
	 *         made writable ({@code false})
	 */
	Optional<Boolean> makeWritable(EObject eObject, EditingDomain editingDomain);
}
