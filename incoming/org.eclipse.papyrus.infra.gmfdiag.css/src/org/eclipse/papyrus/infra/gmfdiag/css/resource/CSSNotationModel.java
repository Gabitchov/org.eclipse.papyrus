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
package org.eclipse.papyrus.infra.gmfdiag.css.resource;

import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.notation.NotationModel;

public class CSSNotationModel extends NotationModel {

	@Override
	public void init(ModelSet modelManager) {
		super.init(modelManager);

		CSSNotationResourceFactory factory = new CSSNotationResourceFactory();
		getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put(NOTATION_FILE_EXTENSION, factory);
	}
}
