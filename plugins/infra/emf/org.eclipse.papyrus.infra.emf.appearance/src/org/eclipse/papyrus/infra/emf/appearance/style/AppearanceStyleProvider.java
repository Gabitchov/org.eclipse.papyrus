/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.appearance.style;

import org.eclipse.emf.ecore.EModelElement;


public interface AppearanceStyleProvider {

	public boolean showElementIcon(EModelElement modelElement);

	public int getQualifiedNameDepth(EModelElement modelElement);

	public boolean showShadow(EModelElement modelElement);

}
