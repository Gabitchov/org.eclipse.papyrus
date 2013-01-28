package org.eclipse.papyrus.qompass.designer.core.transformations;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;

import org.eclipse.papyrus.qompass.designer.core.ConnectorUtils;
import org.eclipse.papyrus.qompass.designer.core.Log;

public class Composite {

	/**
	 * TODO: OBSOLETE - NOT USED
	 * (HOWEVER, MIGHT BE USED FOR PURE ASSEMBLYS)
	 * 
	 * shortcut delegation connectors in composites, i.e. try to extend assembly
	 * connections towards a port with a composite.
	 * The transformation starts with a compositeInstance (usually the
	 * system instance) and finds all contained connections. It removes delegations
	 * connections.
	 * 
	 * @param compositeInstance
	 */
	/*
	 * public void shortcutDelegations (InstanceSpecification compositeInstance)
	 * {
	 * Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "shortcut delegations is called for instance: " + compositeInstance.getName ());
	 * StructuredClassifier composite = (StructuredClassifier) getClassifier (compositeInstance);
	 * Iterator<Connector> connectors = composite.getOwnedConnectors ().iterator ();
	 * 
	 * while (connectors.hasNext ())
	 * {
	 * Connector connector = connectors.next ();
	 * // only look at "simple" connectors
	 * if (isStereotypeApplied (connector, "FCMConnector")) {
	 * continue;
	 * }
	 * // only evaluate simple connection with two ends.
	 * if (connector.getEnds ().size () != 2) {
	 * continue;
	 * }
	 * // Property part = (Property) slot.getDefiningFeature ();
	 * ConnectorEnd myEnd = uc.getMyConnEnd (connector, null);
	 * if (myEnd != null) {
	 * // one of the connector ends has no part, i.e. this is a delegation
	 * // connector => delete the connector.
	 * // note that this is hierarchically after the connection has been
	 * // analyzed by lengtenConnection.
	 * // TODO: comment might be false, maybe removed early quickly (=> split loops?)
	 * Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "removing delegation connector: " + connector.getName ());
	 * composite.getOwnedConnectors().remove(connector);
	 * connectors = composite.getOwnedConnectors ().iterator ();
	 * continue;
	 * }
	 * 
	 * Iterator<ConnectorEnd> ends = connector.getEnds ().iterator ();
	 * while (ends.hasNext ())
	 * {
	 * ConnectorEnd end = ends.next ();
	 * ConnectorEnd newEnd = lengthenConnection (end);
	 * if (end != newEnd) {
	 * // set new end point
	 * Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "set new end point for connection: " + connector.getName ());
	 * end.setPartWithPort (newEnd.getPartWithPort ());
	 * end.setRole (newEnd.getRole ());
	 * }
	 * else {
	 * Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "leave end point unchanged: " + connector.getName ());
	 * }
	 * }
	 * }
	 * 
	 * // loop on slots (need part information)
	 * Iterator<InstanceSpecification> instances = getContainedInstances (compositeInstance).iterator();
	 * while (instances.hasNext ())
	 * {
	 * InstanceSpecification instance = instances.next ();
	 * shortcutDelegations (instance);
	 * }
	 * }
	 */

	/**
	 * This function is used in the context of pure assembly components, i.e. components that do
	 * not have any behavior of their own and delegate to their inner structure
	 * 
	 * @param A
	 *        connector end which points to a part typed by an assembly implementation.
	 * @return A path of connector ends. This parts includes "prolongations" of the path towards
	 *         an inner port. The full list (and not only the last element) is needed, since the part
	 *         information of an end-point would be ambiguous (consider two parts of a common type and
	 *         a connector end-point targeted at a sub-part within these parts)
	 * 
	 *         TODO: minor efficiency aspect: avoid creation of a new list in each recursion step
	 *         (split into two functions).
	 */
	public static EList<ConnectorEnd> lengthenConnectorEnd(ConnectorEnd end) {
		EList<ConnectorEnd> connEndPath = new BasicEList<ConnectorEnd>();
		Property part = end.getPartWithPort();
		connEndPath.add(end);

		if((part != null) && (part.getType() instanceof StructuredClassifier)) {
			StructuredClassifier composite = (StructuredClassifier)part.getType();
			Port port = (Port)end.getRole();

			Iterator<Connector> connectors = composite.getOwnedConnectors().iterator();
			if(port == null) {
				Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "is struct classifier: " + composite.getName() + " port: null!");
				return connEndPath;
			}
			Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "is struct classifier: " + composite.getName() + " port:" + port.getName());
			while(connectors.hasNext()) {
				Connector connector = connectors.next();
				// find connections which originate from/target this port
				if(!ConnectorUtils.connectsPort(connector, port)) {
					continue;
				}
				Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "found possibility to lengthen connector");
				ConnectorEnd otherEnd = ConnectorUtils.connEndNotPart(connector, null);
				// found delegation end, which can be a port of another composite
				// => recursiveCall
				EList<ConnectorEnd> subConnEndPath = lengthenConnectorEnd(otherEnd);
				connEndPath.addAll(subConnEndPath);
			}
		}
		return connEndPath;
	}

	public static Port lengthenedPort(ConnectorEnd end) {
		EList<ConnectorEnd> connEndPath = lengthenConnectorEnd(end);
		int size = connEndPath.size();
		if(size == 0) {
			return null;
		}
		return (Port)connEndPath.get(size - 1).getRole();
	}

	/**
	 * This function copies an Qompass component and instantiates the container, i.e.
	 * - it replaces a reference to a CCM_ interface with a reference to the container.
	 * (don't do it for composites ? Since these disappear currently)
	 * - if parts are typed by a component type, if replaces the reference with the
	 * CCM_ interface. (can we make a reference to the container directly?).
	 */
	/*
	 * public static Class copyComponent (Package root, Class cl)
	 * {
	 * Package newOwner = ut.getAndCreate (root, cl.allNamespaces ());
	 * String name = cl.getName ();
	 * Classifier newCl = null;
	 * NamedElement ne = newOwner.getMember (name);
	 * if (ne instanceof Class) {
	 * // exists already within root, nothing to do
	 * return (Class) ne;
	 * }
	 * else if (ne != null) {
	 * // exists, but is not a classifier
	 * // don't know how to handle
	 * Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "error: element already exists in target package, but is not a class");
	 * return null;
	 * }
	 * Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "copyComponent " + cl.getQualifiedName ());
	 * if (cl instanceof Class) {
	 * newCl = newOwner.createOwnedClass (name, false);
	 * }
	 * else {
	 * System.err.println ("copyClassifier: unsupported classifier <" + cl + ">");
	 * }
	 * 
	 * // copy relationships (and target classes, if not yet part of copied model)
	 * // Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "relationships of " + cl.getName ());
	 * Iterator<DirectedRelationship> relationships = cl.getSourceDirectedRelationships ().iterator ();
	 * while (relationships.hasNext ())
	 * {
	 * DirectedRelationship relationship = relationships.next ();
	 * Element target = relationship.getTargets ().get(0);
	 * if (target instanceof Class) {
	 * Log.log(Log.INFO_MSG, Log.DEPLOYMENT, " rel. target " + ((Classifier) target).getName ());
	 * Classifier newTarget = copyComponent (root, (Class) target);
	 * if ((relationship instanceof InterfaceRealization) &&
	 * (newCl instanceof Class) && (newTarget instanceof Interface)) {
	 * String realizationName = ((InterfaceRealization) relationship).getName ();
	 * ((Class) newCl).createInterfaceRealization (realizationName, (Interface) newTarget);
	 * }
	 * else if (relationship instanceof Generalization) {
	 * newCl.createGeneralization (newTarget);
	 * }
	 * else if (relationship instanceof Dependency) {
	 * newCl.createDependency (newTarget);
	 * }
	 * }
	 * }
	 * 
	 * Copy.copyOperations (cl, newCl, root);
	 * Copy.copyAttributes (cl, newCl, root);
	 * 
	 * UMLTool.ut.copyStereotypes (cl, newCl);
	 * 
	 * return newCl;
	 * }
	 * 
	 * public static Property copyAttribute (Property attribute, Class target, Package newRoot)
	 * {
	 * Property newAttrib = null;
	 * Type type = attribute.getType ();
	 * if (newRoot != null) {
	 * // check whether parts are typed with a component type. Reference need to be
	 * // replaced by reference to CCM_ type.
	 * if ( (type instanceof Class) && (ut.isComponent ((Class) type)) ) {
	 * type = copyComponent (newRoot, (Class) type);
	 * }
	 * else if (type instanceof Classifier) {
	 * type = Copy.copyClassifier (newRoot, (Classifier) type);
	 * }
	 * }
	 * if (attribute instanceof Port) {
	 * newAttrib = target.createOwnedPort (attribute.getName (), type);
	 * }
	 * else {
	 * newAttrib = target.createOwnedAttribute (attribute.getName (), type);
	 * }
	 * if (newAttrib != null) {
	 * newAttrib.setIsComposite (attribute.isComposite ());
	 * }
	 * UMLTool.ut.copyStereotypes (attribute, newAttrib);
	 * return newAttrib;
	 * }
	 */
}
