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
package org.eclipse.papyrus.infra.gmfdiag.css.notation;

import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.DiagramCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.resource.CSSNotationResource;

public class CSSDiagramImpl extends DiagramImpl {

	protected ExtendedCSSEngine engine;

	public ExtendedCSSEngine getEngine() {
		if(engine == null) {
			engine = new DiagramCSSEngine(getModelEngine(), this);
		}
		return engine;
	}

	protected ExtendedCSSEngine getModelEngine() {
		if(eResource() instanceof CSSNotationResource) {
			return ((CSSNotationResource)eResource()).getEngine();
		}
		return null;
	}

}
