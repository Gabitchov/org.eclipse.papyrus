/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.modellibs.core.iconfigurators;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.qompass.designer.core.deployment.AllocUtils;
import org.eclipse.papyrus.qompass.designer.core.extensions.IInstanceConfigurator;
import org.eclipse.papyrus.qompass.designer.core.transformations.ContainerContext;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationRTException;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

/**
 * Configurator for the Eclipse animation server. This instance is systematically
 * allocated to a node named "Eclipse" call event (for a state machine): it sets the
 * portID attribute of the call event interceptor. The interceptor uses this
 * attribute to initialize the portID attribute within the produced CallEvent
 * data structure.
 * 
 * @author ansgar
 * 
 */
public class AnimServiceConfigurator implements IInstanceConfigurator {

	public final static String eclipseAnimService = "Eclipse"; //$NON-NLS-1$

	/**
	 * Configure the instance of a CallEvent interceptor. The configuration parameter is the
	 * index of the port which gets intercepted. It is obtained via an enumeration
	 * 
	 * @see org.eclipse.papyrus.qompass.designer.core.extensions.IInstanceConfigurator#configureInstance(org.eclipse.uml2.uml.InstanceSpecification,
	 *      org.eclipse.uml2.uml.InstanceSpecification, org.eclipse.uml2.uml.Port)
	 * 
	 * @param instance
	 *        the instance that should be configured
	 * @param componentPart
	 *        the part representing this instance
	 * @param context
	 *        container context
	 */
	public void configureInstance(InstanceSpecification instance, Property componentPart, ContainerContext context)
	{
		EList<InstanceSpecification> nodes = AllocUtils.getAllNodesOrThreadsParent(context.smIS);
		if (nodes.size() > 0) {
			InstanceSpecification node = nodes.get(0);
			NamedElement animService = node.getNearestPackage().getMember(eclipseAnimService);
			if (animService instanceof InstanceSpecification) {
				AllocUtils.allocate(instance, (InstanceSpecification)animService);
				return;
			}
		}
		throw new TransformationRTException(String.format("Cannot find node <%s> in platform definition", eclipseAnimService)); 
	}

}
