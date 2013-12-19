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

package org.eclipse.papyrus.qompass.designer.core.transformations;

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.StructuralFeature;


/**
 * Holder for context information during the configuration of an element within a container
 * 
 * @author ansgar
 * 
 */
public class ContainerContext {

	/**
	 * Convenience constructor. Used to initialize elements known outside the container transformation
	 * itself
	 * Constructor.
	 *
	 * @param copy copier
	 * @param smIS original component in source model
	 * @param executorPart part representing the executor
	 * @param nodeExecutorPart allocation target (in case of HW model)
	 */
	public ContainerContext(Copy copy, InstanceSpecification smIS, StructuralFeature executorPart, StructuralFeature nodeExecutorPart) {
		this.copy = copy;
		this.smIS = smIS;
		this.smPartDF = executorPart;
		this.smNodePartDF = nodeExecutorPart;
	}

	/**
	 * original instance specification for a component in the source model. It might be used by instance configurators that need to access the
	 * configuration of the original component.
	 */
	public InstanceSpecification smIS;

	/**
	 * The instance specification of the executor. It is a part of container that has been created, thus
	 * an element of the target model.
	 */
	public InstanceSpecification executorIS;
	
	/**
	 * The part within a composite that represents a component applying a container rule. It is
	 * part of the source model. The main motivation for this information is that some instance configurators
	 * evaluate stereotype attributes that are applied to this part (we call it part, since it is typically a
	 * property with composite aggregation. It is stored as a structural feature, since the information is derived
	 * from the slot pointing to the current instance that is evaluated).
	 */
	public StructuralFeature smPartDF;

	/**
	 * The part within a composite that represents a hardware component applying a container rule. It is
	 * part of the source model. The main motivation for this information is that some instance configurators
	 * evaluate stereotype attributes that are applied to this part
	 * 
	 * @see ContainerContext.smPartDF
	 */
	public StructuralFeature smNodePartDF;

	/**
	 * The port that is intercepted in case of an interceptor configuration.
	 * TODO: since container is *instantiated* after interception, port value is not useful
	 */
	public Port port;
	
	public Copy copy;
}
