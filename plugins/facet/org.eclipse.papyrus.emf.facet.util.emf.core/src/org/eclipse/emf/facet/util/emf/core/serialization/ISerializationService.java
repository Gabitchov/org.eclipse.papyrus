/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 338907 - expose serialization services from SerializationFactoryImpl
 *******************************************************************************/
package org.eclipse.emf.facet.util.emf.core.serialization;

import org.eclipse.emf.facet.util.emf.core.internal.serialization.SerializationService;

/**
 * Provides a serialization service so that the following is true:<br/>
 * <code>deserialize(serialize(object)) == object</code>
 */
public interface ISerializationService {

	public ISerializationService INSTANCE = new SerializationService();

	/** Serialize the given value. */
	String serialize(Object instanceValue);

	/** Deserialize the given string back into the value. */
	Object deserialize(String serializedValue);
}
