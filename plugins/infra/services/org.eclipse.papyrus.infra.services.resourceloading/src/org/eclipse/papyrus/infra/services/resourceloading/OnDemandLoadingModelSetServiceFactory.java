/*****************************************************************************
 * Copyright (c) 2011, 2014 LIFL, CEA, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 431953 (pre-requisite refactoring of ModelSet service start-up)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.resourceloading;

import org.eclipse.papyrus.infra.core.editor.ModelSetServiceFactory;
import org.eclipse.papyrus.infra.core.resource.ModelSet;


/**
 * A service starting the ModelSet
 * 
 * @author cedric dumoulin
 * 
 */
public class OnDemandLoadingModelSetServiceFactory extends ModelSetServiceFactory {

	@Override
	protected ModelSet createModelSet() {
		// Create the appropriate service.
		return new OnDemandLoadingModelSet();
	}

}
