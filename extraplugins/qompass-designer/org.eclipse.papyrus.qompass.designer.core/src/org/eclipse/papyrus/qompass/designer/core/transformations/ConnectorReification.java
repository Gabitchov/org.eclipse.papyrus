package org.eclipse.papyrus.qompass.designer.core.transformations;

/**
 * This file is part of Qompass GenTools
 * Copyright (C) 2008 CEA LIST (http://www-list.cea.fr/)

 * initial developer : Christophe JOUVRAY from CEA LIST 
 * Major contributions: Ansgar Radermacher from CEA LIST
 */

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.qompass.designer.core.ConnectorUtils;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.deployment.AllocUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.templates.ConnectorBinding;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateInstantiation;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.TemplateBinding;

import FCM.InteractionComponent;

/**
 * This class provides model information around connectors ... Many classes are
 * currently commented, since it is not clear if we really need these
 */
public class ConnectorReification {

	/**
	 * Return an instance specification that corresponds to a part. This
	 * function is useful in the connector context, since it allows to retrieve
	 * the instance specification that is reference by a connection end-point
	 * (which points to the part).
	 * 
	 * @param system
	 *        the instance specification for the assembly
	 * @param part
	 *        the part within a class
	 * @return The instance specification for the passed part
	 */
	/*
	 * public static InstanceSpecification getInstanceForPart(
	 * InstanceSpecification system, Property part) {
	 * for (Slot slot : system.getSlots()) {
	 * if (slot.getDefiningFeature() == part) {
	 * for (ValueSpecification value : slot.getValues()) {
	 * // instances are accessible via ValueSpecification subclass
	 * // InstanceValue
	 * if (value instanceof InstanceValue) {
	 * return (((InstanceValue) value).getInstance());
	 * }
	 * }
	 * }
	 * }
	 * return null;
	 * }
	 */

	/**
	 * Find a port that would match a connection
	 * 
	 * @param connectorType
	 *        a connector type, i.e. a component with ports
	 * @param the
	 *        port on the other side of the connection
	 * @return the first port (of all ports owned or inherited by the type) that
	 *         is compatible with the passed otherPort.
	 */
	public static Port getConnectorPort(EncapsulatedClassifier connectorType,
		Port otherPort, boolean isAssembly) {
		EList<Port> ports = PortUtils.getAllPorts(connectorType);
		// try to find matching port
		for(Port port : ports) {
			if(PortUtils.isCompatible(port, otherPort, isAssembly)) {
				return port;
			}
		}
		throw new RuntimeException("Connector reification: cannot find a matching port on reified connector " + connectorType.getName() +
			" for port " + otherPort.getQualifiedName() + ". This should not happen and indicates an internal tool chain error.");
	}

	/**
	 * 
	 * @param copy
	 * @param tmComponent
	 * @param smConnectorPart
	 *        Part representing the connector
	 * @param tmIS
	 *        target instance specification (required for choosing the right implementatioN)
	 * @param args
	 *        Acceleo arguments passed during instantiation
	 * @return The created part within tmComponent that represents the reified
	 *         connector
	 * @throws TransformationException
	 */
	public static Property reifyConnector(Copy copy, Class tmComponent,
		Property smConnectorPart, InstanceSpecification tmIS, Object[] args)
		throws TransformationException {
		// 1st step: create part for the connector without actually changing the type.
		// the objective is to enable the user to perform this step optionally, if the
		// connector needs n-ary connections.
		if(!(smConnectorPart.getType() instanceof Class)) {
			// can not happen since caller checks whether type is stereotyped as ConnectorComp
			// which extends class
			Log.log(Log.ERROR_MSG, Log.TRAFO_CONNECTOR, "template type is not a class");
			return null;
		}
		// choose an implementation
		Class connectorImplemTemplate = DepUtils.chooseImplementation(
			(Class)smConnectorPart.getType(), AllocUtils.getAllNodes(tmIS), false);

		TemplateBinding binding = ConnectorBinding.obtainBinding(tmComponent,
			smConnectorPart, connectorImplemTemplate, true);
		Class connectorImplem;

		if(binding != null) {
			TemplateUtils.adaptActualsToTargetModel(copy, binding);
			TemplateInstantiation ti = new TemplateInstantiation(copy, binding, args);
			connectorImplem = (Class)ti.bindNamedElement(connectorImplemTemplate);
		} else {
			// no binding, class is not a template => copy as it is
			connectorImplem = copy.getCopy(connectorImplemTemplate);
		}
		Property tmConnectorPart = copy.getCopy(smConnectorPart);
		tmConnectorPart.setType(connectorImplem);
		// now retarget connectors towards this part

		for(Connector connector : tmComponent.getOwnedConnectors()) {
			if(ConnectorUtils.connectsPart(connector, tmConnectorPart)) {
				// the connector end targets a port of a part or the composite (in case of delegation)
				ConnectorEnd connEnd = ConnectorUtils.connEndForPart(connector, tmConnectorPart);
				// redirect role, if pointing to port
				if(connEnd.getRole() instanceof Port) {
					Port connectedTemplatePort = (Port)connEnd.getRole();
					Port connectedBoundPort = (Port)Utils.getNamedElementFromList(
						PortUtils.getAllPorts(connectorImplem), connectedTemplatePort.getName());
					connEnd.setRole(connectedBoundPort);
				}
			}
		}
		return tmConnectorPart;
	}

	/**
	 * Reify a connector
	 * 
	 * @param copy
	 *        The copy obect (from source to target mode)
	 * @param tmComponent
	 *        containing composite in target target
	 * @param name
	 *        name of the connector
	 * @param smConnector
	 *        connector element within the source model
	 * @param tmIS
	 *        target model instance specification of the composite in which the reified connector
	 *        (the part typed with the instantiated interaction component) should be created
	 * @param args
	 *        addtion args for the Acceleo transformation
	 * @return the created part within tmComponent
	 * @throws TransformationException
	 */
	public static Property reifyConnector(Copy copy, Class tmComponent,
		String name, Connector smConnector, InstanceSpecification tmIS, Object[] args)
		throws TransformationException {

		FCM.Connector fcmConn = StUtils.getApplication(smConnector, FCM.Connector.class);

		InteractionComponent connType = fcmConn.getIc();
		if(connType == null) {
			return null;
		}

		// choose an implementation
		Class connectorImplemTemplate = DepUtils.chooseImplementation(connType.getBase_Class(), AllocUtils.getAllNodes(tmIS), false);

		// ---- obtain binding & instantiate template type ...
		TemplateBinding binding = ConnectorBinding.obtainBinding(tmComponent,
			smConnector, connectorImplemTemplate, true);
		Class connectorImplem;

		if(binding != null) {
			TemplateUtils.adaptActualsToTargetModel(copy, binding);
			// make copy of bound package and restore it later. Required for nested template instantiations, in particular
			// the bound package is set within container transformations and is (by default) restored to "null" afterwards.
			// TODO: TemplateInstantiation should do this automatically
			copy.pushPackageTemplate();
			TemplateInstantiation ti = new TemplateInstantiation(copy, binding, args);
			connectorImplem = (Class)ti.bindNamedElement(connectorImplemTemplate);
			copy.popPackageTemplate();
		} else {
			// no binding, class is not a template => copy as it is
			connectorImplem = copy.getCopy(connectorImplemTemplate);
		}

		if(connectorImplem == null) {
			throw new TransformationException(
				"could not bind the connector implementation template \""
					+ connectorImplemTemplate.getName() + "\"");
		}

		Property tmConnectorPart = tmComponent.createOwnedAttribute(name,
			connectorImplemTemplate);
		// copy id, but prefix it with "p" (for part)
		Copy.copyID(smConnector, tmConnectorPart, "p");
		tmConnectorPart.setIsComposite(true);

		Log.log(Log.INFO_MSG, Log.TRAFO_CONNECTOR, "ConnectorReification," +
			"add part with connector implementation template <"
			+ connectorImplemTemplate.getName() + "> and implementation <"
			+ connectorImplem.getName() + ">");

		// now create (simple) connections towards the new part
		int i = 0;
		for(ConnectorEnd smEnd : smConnector.getEnds()) {
			Connector tmConnector = tmComponent.createOwnedConnector("c "
				+ name + " " + String.valueOf(i));
			Copy.copyID(smConnector, tmConnector);
			i++;
			// the new connector connects the existing end with an end of the
			// reified connector (the newly created property.)

			// --- first end, connected with the existing end (of another
			// non-connector part)
			ConnectorEnd tmEnd1 = tmConnector.createEnd();
			Property smPartWithPort = smEnd.getPartWithPort();
			Property tmPartWithPort = copy.getCopy(smPartWithPort);
			ConnectableElement smRole = smEnd.getRole();
			ConnectableElement tmRole = copy.getCopy(smRole);
			tmEnd1.setPartWithPort(tmPartWithPort);
			tmEnd1.setRole(tmRole);

			// --- 2nd end, connected with the reified connector (new part)
			ConnectorEnd tmEnd2 = tmConnector.createEnd();
			tmEnd2.setPartWithPort(tmConnectorPart);
			// inheritance between connector type and implementation (ports should be identical)
			// TODO: check whether filter condition is unique? (first returned by getConnectorPort is "good" one)
			if(tmRole instanceof Port) {
				tmEnd2.setRole(getConnectorPort(connectorImplem, (Port)tmRole, (tmPartWithPort != null)));
			}
			else {
				throw new TransformationException(
					"Connector reification requires the use of ports (otherwise, the ports of the reified connector can not be assigned unambiguously");
			}
		}

		tmConnectorPart.setType(connectorImplem);
		// updatePorts(tmComponent, connectorPart, connectorImplem);
		// connectContainerPorts(tmComponent, connectorPart);

		return tmConnectorPart;
	}

	/**
	 * Simple helper function
	 * 
	 * @param part
	 * @param connection
	 * @return the connector end that is associated with the "other" end of a
	 *         connection, i.e. the end that is not connected with the part
	 *         passed as parameter.
	 */
	public static ConnectorEnd oppositeConnEnd(Connector connection,
		ConnectorEnd myEnd) {
		// look for the other end (connectedEnd != myEnd)
		for(ConnectorEnd end : connection.getEnds()) {
			if(end != myEnd) {
				return end;
			}
		}
		return null;
	}

	/**
	 * Check, if a delegation connection targets a part that is deployed on a
	 * certain node.
	 * 
	 * @param connection
	 *        a delegation connection
	 * @param owner
	 *        the owning instance specification (instance specification for
	 *        composite containing the part that is targeted by the
	 *        connection)
	 * @param node
	 * @return
	 */
	/*
	 * public static boolean delegationForNode(Connector connection,
	 * InstanceSpecification owner, Node node) {
	 * InstanceSpecification instanceOfPart = getInstanceForPart(owner,
	 * ConnectorUtils.connEndNotPart(connection, null)
	 * .getPartWithPort());
	 * 
	 * if (instanceOfPart != null) {
	 * return (!ConnectorUtils.isAssembly(connection) && (AllocUtils
	 * .getNode(instanceOfPart) == node));
	 * } else {
	 * return false;
	 * }
	 * }
	 */

	/**
	 * Components can contain additional ports that are inherited via the
	 * container extension. These ports should typically be connected with
	 * additional ports of the (reified) connector. This connection is based on
	 * equal port types and is done automatically by this function, i.e. it
	 * cannot be done by the developer.
	 * 
	 * @param composite
	 *        the composite in which a connector has been reified.
	 * @param reifiedConnector
	 *        the part associated with the reifiedConnector
	 */
	static void connectContainerPorts(Class composite, Property reifiedConnector) {
		// This function is based on the assumption that the additional ports of
		// the reified
		// connector need to be connected with a port of a component that is
		// already
		// connected via the "normal" connectors (explicitly modeled by the
		// user).
		// For instance, in case of ACCORD-calls, the server component provides
		// the additional
		// RTU port via its container.

		// Create a subset of connectors that are connected with the
		// reified connector
		EList<Connector> connSubset = new BasicEList<Connector>();
		for(Connector connector : composite.getOwnedConnectors()) {
			if(ConnectorUtils.connectsPart(connector, reifiedConnector)) {
				connSubset.add(connector);
			}
		}

		for(Port port : PortUtils.getAllPorts((Class)reifiedConnector
			.getType())) {
			// check, if port is unconnected.
			boolean connected = false;
			// check whether a port of the reified connector is not yet
			// connected.
			for(Connector connector : connSubset) {
				if(ConnectorUtils.connectsPort(connector, port)) {
					connected = true;
				}
			}
			if(!connected) {
				// port is not connected yet. Check to find a connectable port
				// among all ports of connected parts.
				// In the moment, we assume the processes is stopped, as soon as
				// the port is connected, i.e. we do not want to connect the port to
				// potentially set of ports (todo: restriction always useful?)
				for(Connector connector : connSubset) {
					ConnectorEnd connEnd = ConnectorUtils.connEndNotPart(
						connector, reifiedConnector);
					Property otherPart = connEnd.getPartWithPort();
					// this is a part which is connected with the reified
					// connector check whether one of its ports is compatible with the
					// non-connected port.
					if(!(otherPart.getType() instanceof EncapsulatedClassifier))
						continue;

					for(Port otherPort : PortUtils
						.getAllPorts((EncapsulatedClassifier)otherPart
							.getType())) {
						Log.log(Log.INFO_MSG, Log.TRAFO_CONNECTOR, "ConnectorReification: otherPort type: " +
							otherPort.getType().getQualifiedName());
						Log.log(Log.INFO_MSG, Log.TRAFO_CONNECTOR, "ConnectorReification:      port type: " +
							port.getType().getQualifiedName());
						if(otherPort.getType() == port.getType()) {
							Connector newConnector = composite.createOwnedConnector("connector - container of "
								+ otherPart.getName());
							ConnectorEnd end1 = newConnector.createEnd();
							ConnectorEnd end2 = newConnector.createEnd();
							end1.setPartWithPort(reifiedConnector);
							end1.setRole(port);
							end2.setPartWithPort(otherPart);
							end2.setRole(otherPort);
							connected = true;
							break;
						}
					}
					if(connected)
						break;
				}
				if(!connected) {
					if(port.getType() == null) {
						System.err
							.println("Error: connector port \""
								+ port.getName()
								+ "\" does not have a type. It is (therefore) not connected");
					} else {
						System.err
							.println("Error: could not connect connector port: "
								+ port.getName()
								+ " of type "
								+ port.getType().getName());
					}
				}
			}
		}
	}

	/**
	 * Propagate node allocation into a reified connector (identified via its part)
	 * 
	 * The allocation algorithm works as follows.
	 * - get a connector (simple) originating from the passed part
	 * - get the opposite end of this simple connector and identify the connected part
	 * (other part, e.g. a part typed with an application component)
	 * - obtain the nodes to which this other part is allocated:
	 * - in case of a composite, connections are followed up to a monolithic component
	 * - propagate the node allocation into the connector (propagation will finally
	 * allocate leafs within a (composite) connector.
	 * 
	 * @param composite
	 *        the composite class (e.g. system) in which a connector is reified
	 * @param compositeIS
	 *        the associated instance specification
	 * @param partSlot
	 *        the slot associated with the part for which nodes are
	 *        allocated.
	 */
	public static void propagateNodeAllocation(Class composite,
		InstanceSpecification compositeIS, Slot partSlot) {
		Property part = (Property)partSlot.getDefiningFeature();

		// loop over connectors of composite that originate from passed part.
		for(Connector connector : composite.getOwnedConnectors()) {
			ConnectorEnd myEnd = ConnectorUtils.connEndForPart(connector, part);
			if(myEnd == null) {
				// the connector does not connect this part
				continue;
			}
			ConnectorEnd otherEnd = ConnectorUtils.connEndNotPart(connector,
				part);

			Property otherPart = otherEnd.getPartWithPort();
			Port otherPort = (Port)otherEnd.getRole();
			// Property myPart = myEnd.getPartWithPort();
			Port myPort = (Port)myEnd.getRole();

			// find instance that is associated with other part.
			for(Slot slot : compositeIS.getSlots()) {
				if(slot.getDefiningFeature() == otherPart) {
					InstanceSpecification containedInstance = DepUtils
						.getInstance(slot);
					// TODO: too complicated, if the non-connector is a composite as well, it must be clearly allocated
					EList<InstanceSpecification> nodes = AllocUtils.getAllNodesForPort(
						containedInstance, otherPort);
					AllocUtils.propagateNodesViaPort(DepUtils
						.getInstance(partSlot), myPort, nodes);
					break;
				}
			}
		}
	}
}
