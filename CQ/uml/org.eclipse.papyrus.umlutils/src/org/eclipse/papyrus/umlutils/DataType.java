/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

public class DataType extends NamedElement {

	private org.eclipse.uml2.uml.DataType uml2DataType;

	public DataType(org.eclipse.uml2.uml.DataType uml2DataType) {
		super(uml2DataType);
		this.uml2DataType = uml2DataType;
	}
}
