/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.facet.util.emf.core.serialization;

import java.util.List;

import org.eclipse.emf.facet.util.emf.core.internal.serialization.SerializationRegistry;

/** The registry of {@link ISerializer}s per type. */
public interface ISerializationRegistry {
	public static ISerializationRegistry INSTANCE = new SerializationRegistry();

	/** Get all the serializers . */
	List<ISerializer<?>> getSerializers();

	/**
	 * @return the serializer for the given type, or <code>null</code> if none has been registered.
	 *         Also returns serializers for super-types of <code>type</code>.
	 */
	ISerializer<?> getSerializerFor(Class<?> type);

	/**
	 * @return the serializer for the given type qualified name, or <code>null</code> if none has
	 *         been registered. Does not return serializers for super-types of <code>type</code>.
	 */
	ISerializer<?> getSerializerFor(String type);
}
