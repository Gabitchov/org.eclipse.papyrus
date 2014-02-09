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

import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.papyrus.uml.tools.utils.ConnectorUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;

/**
 * Copy a composite class while taking into account node allocation, i.e. only
 * copy parts that are deployed on a certain node (properties that are not typed
 * by a component are always copied). This function may be called several times
 * and will successively add parts that are required. If the same composite
 * (class level) is used in two different contexts, e.g. a socket connector
 * serving as client and server on the same node (for the same interface), the
 * resulting composite will be complete. On the instance level however, such as
 * composite is sub-optimal, since their are two different instances that use a
 * different subset. These cases are not very critical, since unused parts are
 * not instantiated (overhead = pointer)
 * 
 * The function will change assembly composites
 * 
 * @author ansgar
 * 
 */
public class PartialCopy implements InstanceDeployer {

	public void init(Copy copy, BootLoaderGen bootloader,
		InstanceSpecification node) {
		this.copy = copy;
		this.node = node; // only needed for debug output
		// add copy listeners ---
		// 1. only add required parts
		// does nothing for the moment
	}

	public InstanceSpecification deployInstance(InstanceSpecification is, Stack<Slot> slotPath) throws TransformationException {
		Classifier classifier = DepUtils.getClassifier(is);

		// only make a partial copy of the system class (slotPath size 0) for the moment.
		if(!(classifier instanceof Class) || slotPath.size() > 0) {
			return copy.getCopy(is);
		}
		if (AllocUtils.getNodes(is).contains(node)) {
			return copy.getCopy(is);
		}
		
		Class smCl = (Class)classifier;
		
		// create parts in target model, if allocated.
		for (Slot slot : is.getSlots()) {
			copyPart(smCl, slot);
		}
		// since we copied some of its attributes, the copy class created a shallow copy of the class itself		
		InstanceSpecification tmIS = (InstanceSpecification) copy.get(is);
		return tmIS;
	}

	/**
	 * copy a part of a classifier, without being recursive [shouldn't that be in the generic deploy part?]
	 * This function is called, whenever a sub-instance is deployed
	 * Brainstorming: add containing composite to deployInstance? (in this case, deployInstance could create the
	 * part in the containing composite, if it does not exist yet)
	 * 
	 * @param cl
	 * @param newCl
	 * @param slot
	 * @param allocAll
	 * @throws TransformationException
	 */
	protected void copyPart(Class smCl, Slot slot) throws TransformationException {
		Property smPart = (Property)slot.getDefiningFeature();
		// Log.log(Status.INFO, Log.DEPLOYMENT, "smCl:" + smCl.getQualifiedName ());
		// Log.log(Status.INFO, Log.DEPLOYMENT, "tmCl:" + tmCl.getQualifiedName ());
		
		// String partName = smPart.getName();
		InstanceSpecification instanceOrThread = DepUtils.getInstance(slot);
		// instance may be null, if slot refers to a basic type, e.g. a string
		if ((instanceOrThread == null) || AllocUtils.getNodes(instanceOrThread).contains(node)) {
			copy.copy(slot);
			
			// add connectors when possible, i.e. connectors that target the newly added part
			for(Connector smConnector : smCl.getOwnedConnectors()) {
				// check whether the newly added property enables the addition of connectors
				// that connect this port.
				if(ConnectorUtil.connectsPart(smConnector, smPart)) {
					ConnectorEnd otherEnd = ConnectorUtil.connEndNotPart(smConnector, smPart);
					// check whether the part references by the other end (i.e. that not connected with the part)
					// TODO: take connections without port into account
					Property otherPart = otherEnd.getPartWithPort();
					// compare part names, since connector points to parts within the source model
					if((otherPart == null) || (copy.get(otherPart) != null)) {
						copy.copy(smConnector);
					}
				}
			}
		}
	}

	private InstanceSpecification node;

	private Copy copy;
}
