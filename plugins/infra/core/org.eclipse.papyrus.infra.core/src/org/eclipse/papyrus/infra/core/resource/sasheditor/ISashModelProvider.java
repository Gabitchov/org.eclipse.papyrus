/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.core.resource.sasheditor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;


/**
 * This is the ISashModelProvider type.  Enjoy.
 */
public interface ISashModelProvider {

	URI getSashModelURI(URI userModelURI);
	
	void initialize(ModelSet modelSet);
	
	Resource loadSashModel(URI sashModelURI);
	
	void dispose();
}
