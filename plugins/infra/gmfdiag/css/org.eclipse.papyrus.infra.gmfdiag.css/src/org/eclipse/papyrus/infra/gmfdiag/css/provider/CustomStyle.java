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
package org.eclipse.papyrus.infra.gmfdiag.css.provider;

/**
 * An element which supports Papyrus custom styles (elementIcon,
 * qualifiedNameDepth, shadow).
 *
 * @author Camille Letavernier
 */
public interface CustomStyle {

	public boolean showElementIcon();

	public int getQualifiedNameDepth();

	public boolean showShadow();

}
