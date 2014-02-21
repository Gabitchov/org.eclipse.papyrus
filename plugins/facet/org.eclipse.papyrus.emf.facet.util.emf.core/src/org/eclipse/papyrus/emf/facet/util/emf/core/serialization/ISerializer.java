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

/**
 * The interface that must be implemented when adding an extension to the "serializer" extension
 * point.
 * 
 * @see ISerializationRegistry
 */
// note: the serializer has to return the {@link Class} object instead of a qualified name
// because that's the one that has it on its bundle classpath.
public interface ISerializer<T> {

	/** @return the type handled by this serializer. */
	Class<T> getType();

	/** Serialize the given value into a String */
	String serialize(T value);

	/**
	 * Deserialize the given String back into the original value that was serialized with
	 * {@link ISerializer#serialize(Object)}
	 */
	T deserialize(String serializedValue);
}
