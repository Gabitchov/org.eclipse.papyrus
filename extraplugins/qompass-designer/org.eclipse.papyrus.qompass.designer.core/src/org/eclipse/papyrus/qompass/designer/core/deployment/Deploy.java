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

import org.eclipse.papyrus.qompass.designer.core.Messages;
import org.eclipse.papyrus.qompass.designer.core.extensions.ILangSupport;
import org.eclipse.papyrus.qompass.designer.core.extensions.InstanceConfigurator;
import org.eclipse.papyrus.qompass.designer.core.transformations.LazyCopier;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;

/*
 * This file is part of Qompass GenTools
 * Copyright (C) 2008 CEA LIST (http://www-list.cea.fr/)

 * initial developer : Ansgar Radermacher, Christophe JOUVRAY from CEA LIST 
 */

public class Deploy {

	/**
	 * distribute an instance, its contained sub-instances and the referenced
	 * classifiers to a certain node
	 * 
	 * @param copy
	 * @param node
	 * @param nodeIndex
	 * @param numberOfNodes
	 * @param instance
	 * @throws TransformationException
	 */
	public Deploy(LazyCopier copy, ILangSupport langSupport, InstanceSpecification node,
			int nodeIndex, int numberOfNodes)
		throws TransformationException
	{
		bootLoaderGen = new BootLoaderGen(copy, nodeIndex, numberOfNodes);
		this.node = node;

		// change to flat copy eventually later (not yet working)
		depInstance = new PartialCopy();
		
		depInstance.init(copy, bootLoaderGen, node);

		// set a copy listener in order to assure that indirectly added classes
		// are taken into account as well
		this.copy = copy;
		copy.preCopyListeners.add(new GatherConfigData(langSupport));
	}

	
	/**
	 * distribute an instance, its contained sub-instances and the referenced
	 * classifiers to a certain node
	 * 
	 * @param copier
	 * @param node
	 * @param nodeIndex
	 * @param numberOfNodes
	 * @param instance
	 * @throws TransformationException
	 */
	public InstanceSpecification distributeToNode(InstanceSpecification instance)
		throws TransformationException
	{
		Stack<Slot> slotPath = new Stack<Slot>();
		InstanceSpecification newRootIS = distributeToNode(false, slotPath, instance);

		bootLoaderGen.addCreateConnections();
		bootLoaderGen.addInit();
		return newRootIS;
	}

	/**
	 * Distribute an instance specification to the node by this 
	 * @param allocAll
	 * @param slotPath
	 * @param instance
	 * @throws TransformationException
	 */
	public InstanceSpecification distributeToNode(boolean allocAll, Stack<Slot> slotPath, InstanceSpecification instance)
		throws TransformationException {

		// once an instance is explicitly allocated on a partition (use of getNodes instead of getAllNodes)
		// all of its sub-instances are allocated on the node as well

		if(AllocUtils.getNodesOrThreads(instance).contains(node)) {
			allocAll = true;
		}
		
		// obtain implementation within source model
		Classifier smImplementation = DepUtils.getClassifier(instance);
		if(smImplementation == null) {
			throw new TransformationException(String.format(
				Messages.Deploy_0, instance.getName()));
		}

		// copy implementation into node specific model
		InstanceSpecification tmInstance = depInstance.deployInstance(instance, slotPath);
		Classifier tmImplementation = DepUtils.getClassifier(tmInstance);
		// Classifier tmImplementation = copy.getCopy(smImplementation);

		for(Slot slot : instance.getSlots()) {
			InstanceSpecification containedInstance = DepUtils.getInstance(slot);

			if(containedInstance != null) {
				if (!DepUtils.isShared(slot)) {
					StructuralFeature sf = slot.getDefiningFeature();
					boolean viaAllocAll = allocAll;
					if (allocAll && (sf instanceof Property)) {
						// only take allocation of parent instance into account, if composition
						// However, problematic, since code gets copied anyway.
						// viaAllocAll = (((Property) sf).getAggregation() == AggregationKind.COMPOSITE_LITERAL);
					}
					if(viaAllocAll || AllocUtils.getAllNodes(containedInstance).contains(node)) {
						slotPath.push(slot);
						if (sf instanceof Property) {
							// place configurator before recursive call. Otherwise
							// values put here would be ignored.
							// TODO: instances are not copied to node model. Thus, the instances here are the same as in the
							// configuration on the intermediate model.
							// TODO: MIX of bootloaderGeneration and splitting.
							InstanceConfigurator.configureInstance(containedInstance, (Property) sf, tmInstance);
						}
						// distribute subInstance
						distributeToNode(allocAll, slotPath, containedInstance);
						slotPath.pop();
					}
				}
				else if(allocAll || AllocUtils.getAllNodes(containedInstance).contains(node)) {
					slotPath.push(slot);
					// bootLoaderGen.instanceConfig(slotPath, instance);
					bootLoaderGen.addInstance(slotPath, containedInstance, null, node);
					slotPath.pop();			
				}
			} else {
				// slot contains configuration of primitive attribute (no
				// sub-instance, but primitive value)
				slotPath.push(slot);
				bootLoaderGen.instanceConfig(slotPath, instance);
				slotPath.pop();
			}
		}

		// ... and add the instance to the bootloader (this is done after
		// copying the slots to
		// ensure that the bootloader generator has the information about
		// contained parts & connectors
		// TODO: really necessary?
		if(tmImplementation instanceof Class) {
			bootLoaderGen.addInstance(slotPath, instance, (Class)tmImplementation, node);
		}
		return tmInstance;
	}

	public Class getBootloader() {
		return bootLoaderGen.getUML();
	}

	protected BootLoaderGen bootLoaderGen;

	protected InstanceSpecification node;

	protected InstanceDeployer depInstance;
	
	protected LazyCopier copy;
}
