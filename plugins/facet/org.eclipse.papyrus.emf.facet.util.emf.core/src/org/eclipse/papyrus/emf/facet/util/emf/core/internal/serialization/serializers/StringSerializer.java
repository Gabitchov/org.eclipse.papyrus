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
package org.eclipse.emf.facet.util.emf.core.internal.serialization.serializers;

import org.eclipse.emf.facet.util.emf.core.serialization.ISerializer;

public class StringSerializer implements ISerializer<String> {

	public StringSerializer() {
		//
	}

	public Class<String> getType() {
		return String.class;
	}

	public String serialize(final String value) {
		return value;
	}

	public String deserialize(final String serializedValue) {
		return serializedValue;
	}
}
