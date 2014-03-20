/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 */
package org.eclipse.papyrus.emf.facet.custom.metamodel.custompt;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @noextend This interface is not intended to be extended by clients.
 */
public interface IImage extends Serializable {
	InputStream getInputStream();
} 
