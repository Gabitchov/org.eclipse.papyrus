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
package org.eclipse.papyrus.infra.hyperlink.util;

import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.widgets.providers.IFilteredLabelProvider;


public class HyperLinkFilteredLabelProvider extends HyperLinkLabelProvider implements IFilteredLabelProvider {

	public boolean accept(Object element) {
		return element instanceof HyperLinkObject;
	}


}
