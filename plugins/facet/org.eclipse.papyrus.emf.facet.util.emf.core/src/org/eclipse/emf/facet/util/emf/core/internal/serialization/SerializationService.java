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
package org.eclipse.emf.facet.util.emf.core.internal.serialization;

import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.emf.facet.util.emf.core.internal.Activator;
import org.eclipse.emf.facet.util.emf.core.serialization.ISerializationRegistry;
import org.eclipse.emf.facet.util.emf.core.serialization.ISerializationService;
import org.eclipse.emf.facet.util.emf.core.serialization.ISerializer;

public class SerializationService implements ISerializationService {

	public String serialize(final Object instanceValue) {
		if (instanceValue == null) {
			return "null"; //$NON-NLS-1$
		}

		ISerializer<Object> serializer = (ISerializer<Object>) ISerializationRegistry.INSTANCE
				.getSerializerFor(instanceValue.getClass());
		if (serializer != null) {
			return serializer.getType().getName() + ":" //$NON-NLS-1$
					+ serializer.serialize(instanceValue);
		}

		Logger.logError("serialization of type " + instanceValue.getClass().getName() //$NON-NLS-1$
				+ " is not implemented.", Activator.getDefault()); //$NON-NLS-1$
		return "null"; //$NON-NLS-1$
	}

	public Object deserialize(final String serializedValue) {
		try {
			if ("null".equals(serializedValue)) { //$NON-NLS-1$
				return null;
			}

			int colonPos = serializedValue.indexOf(':');
			if (colonPos == -1) {
				throw new IllegalArgumentException("invalid serialization format"); //$NON-NLS-1$
			}
			String type = serializedValue.substring(0, colonPos);
			String strValue = serializedValue.substring(colonPos + 1);

			ISerializer<?> serializer = ISerializationRegistry.INSTANCE.getSerializerFor(type);
			if (serializer != null) {
				Object value = serializer.deserialize(strValue);
				return value;
			}

			Logger.logError("deserialization of type " + type //$NON-NLS-1$
					+ " is not implemented.", Activator.getDefault()); //$NON-NLS-1$
		} catch (Exception e) {
			Logger.logError(e, "Error deserializing: " + serializedValue, //$NON-NLS-1$
					Activator.getDefault());
		}
		return null;
	}
}
