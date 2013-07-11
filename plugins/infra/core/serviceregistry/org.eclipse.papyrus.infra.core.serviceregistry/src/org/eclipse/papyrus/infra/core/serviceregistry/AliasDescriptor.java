/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.serviceregistry;

import java.util.Arrays;


/**
 * Describe an alias to another service.
 * 
 * @author cedric dumoulin
 *
 */
public class AliasDescriptor extends ServiceDescriptor {

	public AliasDescriptor(String aliasName, String serviceName, int priority) {
		super(aliasName, ServiceStartKind.LAZY, priority, Arrays.asList(serviceName));
		this.setServiceTypeKind(ServiceTypeKind.alias);
	}

	
	
}
