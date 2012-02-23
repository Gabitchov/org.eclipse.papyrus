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

import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ModelCSSEngine;


public class CSSNotationResource extends GMFResource {

	private ExtendedCSSEngine engine;

	public CSSNotationResource(URI uri) {
		super(uri);
		engine = new ModelCSSEngine(this);
	}

	public ExtendedCSSEngine getEngine() {
		return engine;
	}

}
