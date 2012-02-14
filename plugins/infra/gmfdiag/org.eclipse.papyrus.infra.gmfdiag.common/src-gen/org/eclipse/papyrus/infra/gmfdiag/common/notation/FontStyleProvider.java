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
package org.eclipse.papyrus.infra.gmfdiag.common.notation;


public interface FontStyleProvider {

	public int getFontColor();


	public java.lang.String getFontName();


	public int getFontHeight();


	public boolean isBold();


	public boolean isItalic();


	public boolean isUnderline();


	public boolean isStrikeThrough();

}
