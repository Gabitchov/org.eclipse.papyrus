/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.tree.objects;

// TODO: Auto-generated Javadoc
/**
 * The Class UnlimitedNaturalValueTreeObject.
 */
public class UnlimitedNaturalValueTreeObject extends PrimitiveTypeValueTreeObject {
	
	/**
	 * The Constructor.
	 * 
	 * @param value the value
	 * @param parent the parent
	 */
	public UnlimitedNaturalValueTreeObject(PropertyTreeObject parent, Object value) {
		super(parent, value);
		this.value = value;
	}
}
