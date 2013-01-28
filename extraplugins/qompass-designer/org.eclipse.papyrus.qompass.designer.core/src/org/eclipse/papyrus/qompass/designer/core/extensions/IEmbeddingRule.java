/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.extensions;

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Port;

/**
 * Interface used by Qompass extensions that supports specific instance configurators,
 * used for containers.
 */
public interface IEmbeddingRule {

	// TODO: ordre? appliqué
	/**
	 * configure an instance (within a container)
	 * @param executorIS the instance specification of the component that is used as basis for configuring the instance
	 * @param instance the instance of an element of the container.
	 * @param port the port within a container transformation for which the instance is used as an interceptor.
	 *    Is null for "normal" connectors or container extensions is configured.
	 */
	public void embeddExtension (InstanceSpecification executorIS, InstanceSpecification instance, Port port);
}
