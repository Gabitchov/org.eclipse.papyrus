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
import org.eclipse.uml2.uml.Property;

/**
 * Interface used by Qompass extensions that supports specific instance configurators,
 * used for containers.
 */
public interface IInstanceConfigurator {

	/**
	 * configure an instance (within a container)
	 * 
	 * @param instance
	 *        the instance of an element which should be configured.
	 * @param componentPart
	 *        the property that represents the component within the enclosing composite. May be null, if the instance
	 *        that should be configured is the main instance.
	 * @param parentInstance
	 *        additional information, if the element that should be configured is part of a container, e.g. an interceptor
	 *        or an extension within the container.
	 */
	public void configureInstance(InstanceSpecification instance, Property componentPart, InstanceSpecification parentInstnace);
}
