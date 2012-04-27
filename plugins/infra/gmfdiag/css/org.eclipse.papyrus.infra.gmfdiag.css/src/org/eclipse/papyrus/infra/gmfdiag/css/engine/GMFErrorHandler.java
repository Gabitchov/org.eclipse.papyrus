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
package org.eclipse.papyrus.infra.gmfdiag.css.engine;

import org.eclipse.e4.ui.css.core.engine.CSSErrorHandler;
import org.eclipse.papyrus.infra.gmfdiag.css.Activator;

/**
 * A CSSErrorHandler which forwards exceptions to the Papyrus log
 * 
 * @author Camille Letavernier
 */
@SuppressWarnings("restriction")
public class GMFErrorHandler implements CSSErrorHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * Forwards the exception to the Papyrus log
	 */
	public void error(Exception ex) {
		Activator.log.error("CSS Error", ex); //$NON-NLS-1$
	}

}
