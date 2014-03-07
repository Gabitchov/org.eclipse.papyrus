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

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.base.Optional;


/**
 * An optional extension interface for {@linkplain IReadOnlyHandler read-only handlers} that support making files writable
 * and pertain to other concerns than simply {@linkplain ReadOnlyAxis#PERMISSION permissions}.
 * 
 * @see ReadOnlyAxis
 */
public interface IReadOnlyHandler2 extends IReadOnlyHandler {

	/**
	 * A shortcut for {@link #anyReadOnly(Set, URI[])} with a singleton set
	 * of {@linkplain ReadOnlyAxis#PERMISSION}.
	 * 
	 * @deprecated Use {@linkplain #anyReadOnly(Set, URI[])}, instead.
	 */
	Optional<Boolean> anyReadOnly(URI[] uris);

	/**
	 * A shortcut for {@link #makeWritable(Set, URI[])} with a singleton set
	 * of {@linkplain ReadOnlyAxis#PERMISSION}.
	 * 
	 * @deprecated Use {@linkplain #makeWritable(Set, URI[])}, instead.
	 */
	Optional<Boolean> makeWritable(URI[] uris);

	/**
	 * A shortcut for {@link #isReadOnly(Set, EObject)} with a singleton set
	 * of {@linkplain ReadOnlyAxis#PERMISSION}.
	 * 
	 * @deprecated Use {@linkplain #isReadOnly(Set, EObject)}, instead.
	 */
	Optional<Boolean> isReadOnly(EObject eObject);

	/**
	 * A shortcut for {@link #makeWritable(Set, EObject)} with a singleton set
	 * of {@linkplain ReadOnlyAxis#PERMISSION}.
	 * 
	 * @deprecated Use {@linkplain #makeWritable(Set, EObject)}, instead.
	 */
	Optional<Boolean> makeWritable(EObject eObject);

	/**
	 * Queries whether any of the resources identified by the given URIs is
	 * read-only in any of the given {@code axes} of concern.
	 * 
	 * @param axes
	 *        the set of axes on which to query read-only state
	 * @param uris
	 *            the URIs about which read-only-ness is to be determined
	 * 
	 * @return {@link Optional#absent() absent} if I do not know whether any of
	 *         the URIs is read-only or a {@link Optional#isPresent() present}
	 *         boolean indicating whether any definitively is or they all
	 *         definitively are not read-only
	 */
	Optional<Boolean> anyReadOnly(Set<ReadOnlyAxis> axes, URI[] uris);

	/**
	 * Attempt to ensure that the resources identified by the given URIs are
	 * writable in any of the given {@code axes} of concern.
	 * 
	 * @param axes
	 *        the set of axes on which to query read-only state
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
	Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, URI[] uris);

	/**
	 * Queries whether an {@code eObject} is individually read-only in a given
	 * editing domain, if it is in a resource that supports object-level
	 * read/write permissions in any of the given {@code axes} of concern.
	 * 
	 * @param axes
	 *        the set of axes on which to query read-only state
	 * @param eObject
	 *            an element in some model resource
	 * 
	 * @return {@link Optional#absent() absent} if I do not know whether the
	 *         {@code eObject} is read-only or a {@link Optional#isPresent()
	 *         present} boolean indicating whether it definitively is or is not
	 *         read-only
	 */
	Optional<Boolean> isReadOnly(Set<ReadOnlyAxis> axes, EObject eObject);

	/**
	 * Attempt to ensure that the given {@code eObject} is writable in any of the given {@code axes} of concern.
	 * 
	 * @param axes
	 *        the set of axes on which to query read-only state
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
	Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, EObject eObject);

	/**
	 * Queries whether I can make the resources indicated by the given URIs writable in any of the given {@code axes} of concern.
	 * 
	 * @param axes
	 *        the set of axes on which to query read-only state
	 * @param uris
	 *        indicate a set of resources (presumed read-only)
	 * @return a {@linkplain Optional#isPresent() present} boolean indicating either that I can make the resources writable or that I handle these
	 *         kinds of resources and they cannot be made writable; an {@linkplain Optional#absent() absent} value, otherwise
	 */
	Optional<Boolean> canMakeWritable(Set<ReadOnlyAxis> axes, URI[] uris);

	/**
	 * Queries whether I can make the given {@code object} writable in any of the given {@code axes} of concern.
	 * 
	 * @param axes
	 *        the set of axes on which to query read-only state
	 * @param object
	 *        a model element (presumed read-only)
	 * @return a {@linkplain Optional#isPresent() present} boolean indicating either that I can make the {@code object writable or that I handle its
	 *         kind of resources and it cannot be made writable; an {@linkplain Optional#absent() absent} value, otherwise
	 */
	Optional<Boolean> canMakeWritable(Set<ReadOnlyAxis> axes, EObject object);
}
