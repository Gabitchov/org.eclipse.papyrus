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

import org.eclipse.papyrus.qompass.designer.core.extensions.ILangSupport;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Slot;

/*
 * This file is part of Qompass GenTools
 * Copyright (C) 2008 CEA LIST (http://www-list.cea.fr/)

 * initial developer : Ansgar Radermacher, Christophe JOUVRAY from CEA LIST 
 */

public class Deploy {

	public static final String singletonPrefix = "singleton_";

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
	public static Deploy distributeToNode(Copy copy, ILangSupport langSupport, InstanceSpecification node,
		int nodeIndex, int numberOfNodes, InstanceSpecification instance)
		throws TransformationException
	{
		Deploy deploy = new Deploy();
		deploy.bootLoaderGen = new BootLoaderGen(copy, nodeIndex, numberOfNodes);
		deploy.node = node;

		// change to flat copy eventually later (not yet working)
		deploy.depInstance = new PartialCopy();

		deploy.depInstance.init(copy, deploy.bootLoaderGen, node);

		// set a copy listener in order to assure that indirectly added classes
		// are taken into account as well
		copy.preCopyListeners.add(new GatherConfigData(langSupport));
		// TODO: not nice at all (make non-static?)
		Stack<Slot> slotPath = new Stack<Slot>();
		// do not deploy the system instance itself, but the contained instances as top-level instance
		deploy.distributeToNode(false, slotPath, instance);
/*
		for (Slot topLevelSlot : instance.getSlots()) {
			InstanceSpecification topLevelInstance = DepUtils.getInstance(topLevelSlot);
			if ((topLevelInstance != null) && AllocUtils.getAllNodes(topLevelInstance).contains(node)) {
				slotPath.push(topLevelSlot);
				deploy.distributeToNode(false, slotPath, topLevelInstance);
				slotPath.pop();
			}
		}
*/
		Package cdp = instance.getNearestPackage();
		// deploy singletons (difficult to embed singletons into main instance,
		// since there is no attribute for these)
		for(PackageableElement pe : cdp.getPackagedElements()) {
			if((pe instanceof InstanceSpecification) && (pe.getName().startsWith(singletonPrefix) && (!pe.getName().contains(".")))) {
				deploy.distributeToNode(false, slotPath, (InstanceSpecification)pe);
			}
		}
		deploy.bootLoaderGen.addCreateConnections();
		deploy.bootLoaderGen.addInit();
		return deploy;
	}

	/**
	 * Distribute an instance specification to the node by this 
	 * @param allocAll
	 * @param slotPath
	 * @param instance
	 * @throws TransformationException
	 */
	public void distributeToNode(boolean allocAll, Stack<Slot> slotPath, InstanceSpecification instance)
		throws TransformationException {

		// once an instance is explicitly allocated on a partition (use of getNodes instead of getAllNodes)
		// all of its sub-instances are allocated on the node as well

		if(AllocUtils.getNodesOrThreads(instance).contains(node)) {
			allocAll = true;
		}

		// obtain implementation within source model
		Classifier smImplementation = DepUtils.getClassifier(instance);
		if(smImplementation == null) {
			throw new TransformationException(
				"Cannot find implementation for instance " + instance.getName());
		}

		// copy implementation into node specific model
		Classifier tmImplementation = depInstance.deployInstance(instance, slotPath);

		for(Slot slot : instance.getSlots()) {
			InstanceSpecification containedInstance = DepUtils.getInstance(slot);

			if(containedInstance != null) {
				if(allocAll || AllocUtils.getAllNodes(containedInstance).contains(node)) {
					// if(!containedInstance.getName().startsWith(singletonPrefix)) {
					slotPath.push(slot);
					distributeToNode(allocAll, slotPath, containedInstance);
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
	}


	public Class getBootloader() {
		return bootLoaderGen.getUML();
	}

	private BootLoaderGen bootLoaderGen;

	private InstanceSpecification node;

	private InstanceDeployer depInstance;
}
