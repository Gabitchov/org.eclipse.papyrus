/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml.edit.provider;

import org.eclipse.emf.edit.provider.ComposedImage;

/**
 * Interface that allow an ItemProvider to compose an overlay that handle
 * visibility logo
 * 
 * @author Arthur Daussy <a
 *         href=mailto:arthur.daussy@atos.net>arthur.daussy@atos.net</a>
 * 
 */
public interface IVisibilityOverlayImage {

	ComposedImage composeVisibilityImage(Object object, ComposedImage composedImage);
}
