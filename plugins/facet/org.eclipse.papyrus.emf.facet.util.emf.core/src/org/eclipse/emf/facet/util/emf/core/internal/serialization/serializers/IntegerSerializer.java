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

public class IntegerSerializer implements ISerializer<Integer> {

	public IntegerSerializer() {
		//
	}

	public Class<Integer> getType() {
		return Integer.class;
	}

	public String serialize(final Integer value) {
		return value.toString();
	}

	public Integer deserialize(final String serializedValue) {
		return Integer.valueOf(serializedValue);
	}
}
