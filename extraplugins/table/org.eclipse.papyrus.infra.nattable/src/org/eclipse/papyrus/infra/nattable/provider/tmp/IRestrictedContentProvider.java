/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.provider.tmp;

import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;


/**
 * Add a boolean to choose the display mode :
 * <ul>
 * <li>display all possible values according to the model (restricted==false)</li>
 * <li>display all possible values according to current edited object (restricted==true)</li>
 * </ul>
 * 
 * @author JC236769
 * 
 */
//FIXME must be deleted after the official extraplugins build and before Papyrus 0.10SR1
public interface IRestrictedContentProvider extends IHierarchicContentProvider, IStaticContentProvider, org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider, IInheritedElementContentProvider {


	/**
	 * 
	 * @return
	 *         <code>true</code> if the content provider is restricted
	 */
	public boolean isRestricted();

}
