/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.core;

import org.eclipse.net4j.util.security.IPasswordCredentialsProvider2;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;

/**
 * This is the ICredentialsProviderFactory type. Enjoy.
 */
public interface ICredentialsProviderFactory {

	IPasswordCredentialsProvider2 createCredentialsProvider(
			IPapyrusRepository repository);
}
