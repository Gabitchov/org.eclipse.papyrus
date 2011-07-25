/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.newchild.menu;

import org.eclipse.papyrus.newchild.CustomFiller;

/**
 * An interface for Custom menu filler
 * 
 * @author Camille Letavernier
 */
public interface CustomFillElement extends FillElement {

	public void setMenuItem(CustomFiller filler);

	public void setParentGroup(FillMenuGroup group);

}
