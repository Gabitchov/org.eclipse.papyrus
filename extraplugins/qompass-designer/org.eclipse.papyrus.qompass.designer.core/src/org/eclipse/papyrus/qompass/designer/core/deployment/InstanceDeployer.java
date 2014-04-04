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

package org.eclipse.papyrus.qompass.designer.core.deployment;

import java.util.Stack;

import org.eclipse.papyrus.qompass.designer.core.transformations.LazyCopier;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;

/**
 * Deploy an instance (on a certain node). This operation is specifically non recursive
 * 
 * @author ansgar
 * 
 */
public interface InstanceDeployer {

	/**
	 * Initialize the deployment
	 * 
	 * @param sat
	 *        information about source and target model
	 * @param bootloader
	 *        the bootloader generator, which will contain instance information
	 * @param node
	 *        the node onto which the allocation should be done.
	 */
	public void init(LazyCopier sat, BootLoaderGen bootloader, InstanceSpecification node);

	/**
	 * Deploy an instance and copy the required classes into the target model.
	 * In case of a composite (assembly) class that is partially deployed on a target node
	 * (i.e. a subset of its parts is deployed on the target node, but not composite itself),
	 * this function may only partially copy the class or omit it completely.
	 * Parts and connections are not copied in the first place to take care of partially
	 * deployed composites and added when needed.
	 * Therefore, this function is also responsible for creating the part associated with the
	 * instance in the owning composite class and eventually complete connections within the
	 * composites.
	 * 
	 * @param is
	 *        an instance (UML instance specification) within the deployment plan
	 * @param slotPath
	 *        a list (stack) of slots starting from the main instance
	 * @return the classifier modified for deployment
	 * @throws TransformationException
	 */
	public InstanceSpecification deployInstance(InstanceSpecification is, Stack<Slot> slotPath) throws TransformationException;
}
