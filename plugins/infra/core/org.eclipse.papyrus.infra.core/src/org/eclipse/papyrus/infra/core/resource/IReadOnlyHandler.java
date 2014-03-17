/*****************************************************************************
 * Copyright (c) 2011, 2014 Atos Origin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 429826
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.base.Optional;

/**
 * A pluggable handler determining whether a resource is "read only" (not writable).  Implementations
 * of this interface, if they do not implement {@link IReadOnlyHandler2}, implicitly determine
 * read-only-ness according to the {@linkplain ReadOnlyAxis#PERMISSION permission axis}.
 * 
 * @see IReadOnlyHandler2
 * @see ReadOnlyAxis#PERMISSION
 */
public interface IReadOnlyHandler {

	/**
	 * Queries whether any of the resources identified by the given URIs is
	 * read-only.
	 * 
	 * @param uris
	 *            the URIs about which read-only-ness is to be determined
	 * 
	 * @return {@link Optional#absent() absent} if I do not know whether any of
	 *         the URIs is read-only or a {@link Optional#isPresent() present}
	 *         boolean indicating whether any definitively is or they all
	 *         definitively are not read-only
	 */
	Optional<Boolean> anyReadOnly(URI[] uris);

	/**
	 * Attempt to ensure that the resources identified by the given URIs are
	 * writable.
	 * 
	 * @param uris
	 *            the URIs of resources to make writable (not all are
	 *            necessarily read-only)
	 * 
	 * @return {@link Optional#absent() absent} if I do not know how to make
	 *         these resources writable and the next provider should be given a
	 *         chance, or a {@link Optional#isPresent() present} boolean
	 *         indicating that I made the resources writable ({@code true}) or
	 *         they cannot be made writable ({@code false})
	 */
	Optional<Boolean> makeWritable(URI[] uris);

	/**
	 * Queries whether an {@code eObject} is individually read-only in a given
	 * editing domain, if it is in a resource that supports object-level
	 * read/write permissions.
	 * 
	 * @param eObject
	 *            an element in some model resource
	 * 
	 * @return {@link Optional#absent() absent} if I do not know whether the
	 *         {@code eObject} is read-only or a {@link Optional#isPresent()
	 *         present} boolean indicating whether it definitively is or is not
	 *         read-only
	 */
	Optional<Boolean> isReadOnly(EObject eObject);

	/**
	 * Attempt to ensure that the given {@code eObject} is writable.
	 * 
	 * @param eObject
	 *            a {@linkplain #isReadOnly(EObject, EditingDomain) read-only}
	 *            element in some model resource
	 * 
	 * @return {@link Optional#absent() absent} if I do not know how to make
	 *         this object writable and the next provider should be given a
	 *         chance, or a {@link Optional#isPresent() present} boolean
	 *         indicating that I made it writable ({@code true}) or it cannot be
	 *         made writable ({@code false})
	 */
	Optional<Boolean> makeWritable(EObject eObject);
}
