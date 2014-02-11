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

import java.util.Iterator;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.papyrus.FCM.Fragment;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.uml.tools.utils.ConnectorUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

public class AllocUtils {

	public static final String startPortName = "start"; //$NON-NLS-1$
	
	public static final String startPortType = "IStart"; //$NON-NLS-1$
	
	/**
	 * Retrieve a list of nodes to which the instance is allocated to *or*
	 * to which one of the contained instances is allocated to (recursively)
	 * 
	 * @param instance
	 * @return a list of nodes
	 */
	public static EList<InstanceSpecification> getAllNodes(InstanceSpecification instance) {
		EList<InstanceSpecification> nodeList = getNodes(instance);
		for(Slot slot : instance.getSlots()) {
			if (!DepUtils.isShared(slot)) {
				InstanceSpecification containedInstance = DepUtils.getInstance(slot);
				if (containedInstance != null) {
					nodeList.addAll(getAllNodes(containedInstance));
				}
			}
		}
		return nodeList;
	}
	
	/**
	 * Retrieve a list of nodes to which the instance is allocated to *or*
	 * to which one of the contained instances is allocated to (recursively)
	 * 
	 * @param instanceAttribute an attribute within a composite that represents a component instance
	 *       or a set thereof, if the composite itself is instantiated multiple times)
	 * @return a list of nodes
	 */
	public static Property getThreadAlloc(Property instanceAttribute) {
		for (DirectedRelationship relation : instanceAttribute.getSourceDirectedRelationships()) {
			if (StereotypeUtil.isApplied(relation, Allocate.class)) {
				if (relation.getTargets().size() != 1) continue;
				Element targetElem = relation.getTargets().get(0);
				if (!(targetElem instanceof Property)) continue;
				Property target = (Property) targetElem;
				if (StereotypeUtil.isApplied(target.getType(), SwSchedulableResource.class)) {
					return target;
				}
			}
		}
		return null;
	}


	/**
	 * Retrieve a list of nodes to which the instance is allocated to *or*
	 * to which one of the containing instances is explicitly allocated
	 * 
	 * @param instance
	 * @return a list of nodes
	 */
	public static EList<InstanceSpecification> getAllNodesOrThreadsParent(InstanceSpecification instance) {
		EList<InstanceSpecification> nodeList = getNodesOrThreads(instance);
		Package cdp = instance.getNearestPackage();
		// TODO: not very efficient: loop each time over all instance specifications
		for(NamedElement parentNE : cdp.getMembers()) {
			if(parentNE instanceof InstanceSpecification) {
				// possible parent instance specification
				InstanceSpecification parentIS = (InstanceSpecification)parentNE;
				if(DepUtils.getContainedInstances(parentIS).contains(instance)) {
					nodeList.addAll(getAllNodesOrThreadsParent(parentIS));
				}
			}
		}
		return nodeList;
	}

	public static InstanceSpecification getNode(InstanceSpecification instance) {
		EList<InstanceSpecification> nodeList = getNodes(instance);
		if(nodeList.size() != 0) {
			return nodeList.get(0);
		}
		return null;
	}

	public static InstanceSpecification getNodeOrThread(InstanceSpecification instanceOrThread) {
		EList<InstanceSpecification> nodeList = getNodesOrThreads(instanceOrThread);
		if(nodeList.size() != 0) {
			return nodeList.get(0);
		}
		return null;
	}

	/**
	 * This method returns a list of nodes (or threads) to which the passed instance is allocated.
	 * It is based on MARTE Allocation (a stereotyped abstraction) which is a generic
	 * mechanism to deploy UML elements to nodes.
	 * 
	 * @param instanceOrThread
	 *        The instance for which we like to know the allocation information
	 * @return
	 */
	public static EList<InstanceSpecification> getNodesOrThreads(InstanceSpecification instanceOrThread) {
		EList<InstanceSpecification> nodeList = new UniqueEList<InstanceSpecification>();

		for(DirectedRelationship relationship : instanceOrThread.getSourceDirectedRelationships(UMLPackage.eINSTANCE.getAbstraction())) {
			Abstraction abstraction = (Abstraction)relationship;
			if(StereotypeUtil.isApplied(abstraction, Allocate.class)) {
				for(Element target : abstraction.getTargets()) {
					if(target instanceof InstanceSpecification) {
						nodeList.add((InstanceSpecification)target);
					}
				}
			}
		}
		return nodeList;
	}

	/**
	 * This method returns a list of nodes to which the passed instance is allocated. If
	 * the instance is allocated directly to a node, this node is returned. If the instance
	 * is allocated to a thread, the allocation of the thread to a node is returned.
	 *
	 * @param instanceOrThread
	 *        The instance that should be deployed
	 * @return
	 */
	public static EList<InstanceSpecification> getNodes(InstanceSpecification instanceOrThread) {
		EList<InstanceSpecification> nodeList = new UniqueEList<InstanceSpecification>();
		EList<InstanceSpecification> nodeOrThreads = getNodesOrThreads(instanceOrThread);
		for(InstanceSpecification nodeOrThread : nodeOrThreads)
		{
			Classifier nodeOrThreadC = DepUtils.getClassifier(nodeOrThread);
			if(StereotypeUtil.isApplied(nodeOrThreadC, SwSchedulableResource.class)) {
				// treat case that instance is allocated to a thread
				// follow allocation of Thread
				nodeList.add(getNode(nodeOrThread));
			}
			else {
				nodeList.add(nodeOrThread);
			}
		}
		return nodeList;
	}

	/**
	 * This method updates (and optionally removes) the allocations of an instance
	 * 
	 * @param instance
	 *        The instance that should be deployed
	 * @param oldNode
	 *        the old node allocation
	 * @param newNode
	 *        the new node allocation, may be null to indicate removal
	 * @return
	 */
	public static EList<Node> updateAllocation(InstanceSpecification instance, InstanceSpecification oldNode, InstanceSpecification newNode) {
		EList<Node> nodeList = new UniqueEList<Node>();

		Iterator<DirectedRelationship> relShipIt =
			instance.getSourceDirectedRelationships(UMLPackage.eINSTANCE.getAbstraction()).iterator();

		while(relShipIt.hasNext()) {
			Abstraction abstraction = (Abstraction)relShipIt.next();
			if(StereotypeUtil.isApplied(abstraction, Allocate.class)) {
				EList<NamedElement> suppliers = abstraction.getSuppliers(); // use suppliers instead of targets (derived)
				for(int index = 0; index < suppliers.size(); index++) {
					if(suppliers.get(index) == oldNode) {
						if(newNode == null) {
							// remove relationship completely, since we assume a single target
							// (cannot call remove on relShipIt, since list is derived)
							abstraction.destroy();
						} else {
							suppliers.set(index, newNode);
						}
						break;
					}
				}
			}
		}
		return nodeList;
	}

	/**
	 * Retrieve a list of nodes to which the instance is allocated to *or*
	 * to which one of the contained instances is allocated to (recursively)
	 * 
	 * @param instance
	 * @param A
	 *        port of the composite. Contained instances are examined only if
	 *        they have a connection with this port.
	 * @return a list of nodes
	 */
	public static EList<InstanceSpecification> getAllNodesForPort(InstanceSpecification instance, Port port) {
		EList<InstanceSpecification> nodeList = getNodes(instance);
		Classifier composite = DepUtils.getClassifier(instance);
		if(composite instanceof Class) {
			Class compositeCL = (Class)composite;
			for(Slot slot : instance.getSlots()) {
				Property containedProperty = (Property)slot.getDefiningFeature();

				for(Connector connection : compositeCL.getOwnedConnectors()) {
					// is one connector end targeted at the containedProperty ?
					ConnectorEnd end = ConnectorUtil.connEndForPart(connection, containedProperty);
					if(end == null)
						continue;

					// does the connector at the same connect the composite's port?
					if(ConnectorUtil.connectsPort(connection, port)) {
						Port containedPort = (Port)end.getRole();
						nodeList.addAll(getAllNodesForPort(DepUtils.getInstance(slot), containedPort));
					}
				}
			}
		}
		return nodeList;
	}

	public static boolean allocate(InstanceSpecification instance, InstanceSpecification node) {
		Package cdp = (Package)instance.getOwner();
		Abstraction allocation = (Abstraction)
			cdp.createPackagedElement("allocate " + instance.getName() + //$NON-NLS-1$
				" to " + node.getName(), UMLPackage.eINSTANCE.getAbstraction()); //$NON-NLS-1$
		if(StereotypeUtil.apply(allocation, Allocate.class) == null) {
			// stereotype application failed
			allocation.destroy();
			return false;
		}
		allocation.getClients().add(instance);
		allocation.getSuppliers().add(node);
		return true;
	}

	/**
	 * Assign node name to leafs
	 * 
	 * @param instance
	 * @param A
	 *        port of the composite. Contained instances are examined only if the
	 *        have a connection with this port. If null, no sub-instances are examined
	 * @param nodes
	 *        A list of nodes to which leafs are allocated
	 */
	public static void propagateNodesViaPort(InstanceSpecification instance, Port port, EList<InstanceSpecification> nodes) {
		if(instance == null) {
			return;
		}
		EList<Slot> slots = instance.getSlots();
		Class composite = DepUtils.getImplementation(instance);

		// Only set allocation on leafs (TODO: assure that components with configuration attributes are not considered as leafs)
		// if(composite.getParts().size() == 0) {
		for(InstanceSpecification node : nodes) {
			AllocUtils.allocate(instance, node);
		}

		if((composite != null) && (port != null)) {
		Class compositeCL = (Class)composite;
			for(Slot slot : slots) {
				Property containedProperty = (Property)slot.getDefiningFeature();

				Fragment fragment = UMLUtil.getStereotypeApplication(containedProperty, Fragment.class);
				if(fragment != null) {
					// TODO
					/*
					EList<Port> colocateWithPort = fragment.getColocateWithPort();
					// is the port within the list?
					if(Utils.getNamedElementFromList(colocateWithPort, port.getName()) != null) {
						// compare qualified name, since containedPort (stereotype attribute)
						// points to a source model element
						propagateNodesViaPort(DepUtils.getInstance(slot), port, nodes);
						continue;
					}
					*/
				}
				for(Connector connection : compositeCL.getOwnedConnectors()) {
					if(ConnectorUtil.connectsPort(connection, port)) {
						Log.log(Status.INFO, Log.TRAFO_CONNECTOR, "connector: " + connection.getName()); //$NON-NLS-1$
						Log.log(Status.INFO, Log.TRAFO_CONNECTOR, "end1: " + connection.getEnds().get(0).getPartWithPort()); //$NON-NLS-1$
						Log.log(Status.INFO, Log.TRAFO_CONNECTOR, "end2: " + connection.getEnds().get(1).getPartWithPort()); //$NON-NLS-1$
						ConnectorEnd end = ConnectorUtil.connEndForPart(connection, containedProperty);
						// other connector end targeted at containedProperty?
						if(end != null) {
							Port containedPort = (Port)end.getRole();
							propagateNodesViaPort(DepUtils.getInstance(slot), containedPort, nodes);
						}
					}
				}
			}
		}
	}

	/**
	 * Return the start Port of a component, i.e. a port that corresponds to the "magic" port name
	 * start and is typed with the interface IStart
	 * 
	 * @param component a component implementation
	 * @return The start port or null
	 */
	public static Port getStartPort(Class component) {
		Element startPortElem = Utils.getNamedElementFromList(component.getAllAttributes(), startPortName);
		if (startPortElem instanceof Port) {
			Port startPort = (Port) startPortElem;
			if(startPort.getType().getName().equals(startPortType)) {
				return startPort;
			}
		}
		return null;
	}
}
