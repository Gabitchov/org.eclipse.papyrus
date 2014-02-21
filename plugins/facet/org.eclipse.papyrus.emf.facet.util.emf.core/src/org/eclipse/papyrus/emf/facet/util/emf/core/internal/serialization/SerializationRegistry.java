/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Laurent Pichierri (Soft-Maint) - Bug 371204 - Compatibility with Helios
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.emf.core.internal.serialization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
//import org.eclipse.papyrus.emf.facet.infra.common.core.internal.extensions.AbstractRegistry;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.AbstractRegistry;
import org.eclipse.papyrus.emf.facet.util.emf.core.internal.Activator;
import org.eclipse.papyrus.emf.facet.util.emf.core.serialization.ISerializationRegistry;
import org.eclipse.papyrus.emf.facet.util.emf.core.serialization.ISerializer;

/** Registry for the "serialization" extension point */
public class SerializationRegistry extends AbstractRegistry implements ISerializationRegistry {

	private static final String EXTENSION_POINT_NAMESPACE = "org.eclipse.papyrus.emf.facet.util.emf.core"; //$NON-NLS-1$
	private static final String EXTENSION_POINT_NAME = "serialization"; //$NON-NLS-1$

	private static final String SERIALIZER_ELEMENT = "serializer"; //$NON-NLS-1$
	private static final String CLASS_ATTRIBUTE = "class"; //$NON-NLS-1$

	private static SerializationRegistry instance = null;

	private final List<ISerializer<?>> serializers = new ArrayList<ISerializer<?>>();

	public static SerializationRegistry getInstance() {
		if (SerializationRegistry.instance == null) {
			SerializationRegistry.instance = new SerializationRegistry();
		}
		return SerializationRegistry.instance;
	}

	public SerializationRegistry() {
		initialize();
	}

	public List<ISerializer<?>> getSerializers() {
		return Collections.unmodifiableList(this.serializers);
	}

	public ISerializer<?> getSerializerFor(final Class<?> type) {
		for (ISerializer<?> serializer : this.serializers) {
			if (serializer.getType().isAssignableFrom(type)) {
				return serializer;
			}
		}
		return null;
	}

	public ISerializer<?> getSerializerFor(final String type) {
		for (ISerializer<?> serializer : this.serializers) {
			if (serializer.getType().getName().equals(type)) {
				return serializer;
			}
		}
		return null;
	}

	@Override
	protected String getExtensionPointName() {
		return SerializationRegistry.EXTENSION_POINT_NAME;
	}

	@Override
	protected String getExtensionPointNamespace() {
		return SerializationRegistry.EXTENSION_POINT_NAMESPACE;
	}

	@Override
	protected void handleRootElement(final IConfigurationElement configurationElement) {
		final String name = configurationElement.getName();
		if (name.equalsIgnoreCase(SerializationRegistry.SERIALIZER_ELEMENT)) {
			readSerializerElement(configurationElement);
		} else {
			logUnknownElement(configurationElement);
		}
	}

	/** Read a 'serializer' element */
	private void readSerializerElement(final IConfigurationElement configurationElement) {
		Object object;
		try {
			object = configurationElement
					.createExecutableExtension(SerializationRegistry.CLASS_ATTRIBUTE);
		} catch (CoreException e) {
			Logger.logError(e, Activator.getDefault());
			return;
		}
		if (object == null) {
			logMissingAttribute(configurationElement, SerializationRegistry.CLASS_ATTRIBUTE);
			return;
		}

		if (object instanceof ISerializer<?>) {
			ISerializer<?> serializer = (ISerializer<?>) object;
			ISerializer<?> existingSerializer = getSerializerFor(serializer.getType());
			if (existingSerializer != null) {
				logError(
						configurationElement,
						"Several serializers are provided for the type: " + serializer.getType().getName() + ". Only the first one will be used."); //$NON-NLS-1$ //$NON-NLS-2$

				// always take the first one in the alphabetical order => determinism to avoid
				// trying to serialize with one implementation and deserialize with an incompatible
				// implementation
				if (serializer.getClass().getName()
						.compareTo(existingSerializer.getClass().getName()) < 0) {
					// replace the already registered serializer by this one
					this.serializers.remove(existingSerializer);
				} else {
					return;
				}
			}
			this.serializers.add(serializer);
		} else {
			logError(configurationElement,
					"class must implement " + ISerializer.class.getSimpleName()); //$NON-NLS-1$
		}
	}
}