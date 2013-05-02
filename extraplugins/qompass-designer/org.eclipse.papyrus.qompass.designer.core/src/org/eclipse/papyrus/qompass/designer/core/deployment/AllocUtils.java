package org.eclipse.papyrus.qompass.designer.core.deployment;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate;
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

import org.eclipse.papyrus.qompass.designer.core.ConnectorUtils;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;

public class AllocUtils {

	/**
	 * Retrieve a list of nodes to which the instance is allocated to *or*
	 * to which one of the contained instances is allocated to (recursively)
	 * 
	 * @param instance
	 * @return a list of nodes
	 */
	public static EList<InstanceSpecification> getAllNodes(InstanceSpecification instance) {
		EList<InstanceSpecification> nodeList = getNodes(instance);
		for(InstanceSpecification containedInstance : DepUtils.getContainedInstances(instance)) {
			nodeList.addAll(getAllNodes(containedInstance));
		}
		return nodeList;
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
	 * This method returns a list of nodes when given an instance.
	 * It is based on MARTE Allocation (a stereotyped abstraction) which is a generic
	 * mechanism to deploy UML elements to nodes.
	 * 
	 * @param instanceOrThread
	 *        The instance that should be deployed
	 * @return
	 */
	public static EList<InstanceSpecification> getNodesOrThreads(NamedElement instanceOrThread) {
		EList<InstanceSpecification> nodeList = new UniqueEList<InstanceSpecification>();

		for(DirectedRelationship relationship : instanceOrThread.getSourceDirectedRelationships(UMLPackage.eINSTANCE.getAbstraction())) {
			Abstraction abstraction = (Abstraction)relationship;
			if(StUtils.isApplied(abstraction, Allocate.class)) {
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
	 * This method returns a list of nodes when given an instance.
	 * It is based on MARTE Allocation (a stereotyped abstraction) which is a generic
	 * mechanism to deploy UML elements to nodes.
	 * 
	 * @param instanceOrThread
	 *        The instance that should be deployed
	 * @return
	 */
	public static EList<InstanceSpecification> getNodes(NamedElement instanceOrThread) {
		EList<InstanceSpecification> nodeList = new UniqueEList<InstanceSpecification>();
		EList<InstanceSpecification> nodeOrThreads = getNodesOrThreads(instanceOrThread);
		for(InstanceSpecification nodeOrThread : nodeOrThreads)
		{
			Classifier nodeOrThreadC = DepUtils.getClassifier(nodeOrThread);
			if(StUtils.isApplied(nodeOrThreadC, SwSchedulableResource.class)) {
				// tread case that instance is allocated to a thread
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
			if(StUtils.isApplied(abstraction, Allocate.class)) {
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
					ConnectorEnd end = ConnectorUtils.connEndForPart(connection, containedProperty);
					if(end == null)
						continue;

					// does the connector at the same connect the composite's port?
					if(ConnectorUtils.connectsPort(connection, port)) {
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
			cdp.createPackagedElement("allocate " + instance.getName() +
				" to " + node.getName(), UMLPackage.eINSTANCE.getAbstraction());
		if(StUtils.apply(allocation, Allocate.class) == null) {
			// stereotype application failed
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

				org.eclipse.papyrus.FCM.Part fcmPart = StUtils.getApplication(containedProperty, org.eclipse.papyrus.FCM.Part.class);
				if(fcmPart != null) {
					EList<Port> colocateWithPort = fcmPart.getColocateWithPort();
					// is the port within the list?
					if(Utils.getNamedElementFromList(colocateWithPort, port.getName()) != null) {
						// compare qualified name, since containedPort (stereotype attribute)
						// points to a source model element
						propagateNodesViaPort(DepUtils.getInstance(slot), port, nodes);
						continue;
					}
				}
				for(Connector connection : compositeCL.getOwnedConnectors()) {
					if(ConnectorUtils.connectsPort(connection, port)) {
						Log.log(Log.INFO_MSG, Log.TRAFO_CONNECTOR, "connector: " + connection.getName());
						Log.log(Log.INFO_MSG, Log.TRAFO_CONNECTOR, "end1: " + connection.getEnds().get(0).getPartWithPort());
						Log.log(Log.INFO_MSG, Log.TRAFO_CONNECTOR, "end2: " + connection.getEnds().get(1).getPartWithPort());
						ConnectorEnd end = ConnectorUtils.connEndForPart(connection, containedProperty);
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
}
