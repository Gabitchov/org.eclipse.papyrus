package org.eclipse.papyrus.qompass.designer.core.deployment;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;

import org.eclipse.papyrus.qompass.designer.core.ConnectorUtils;
import org.eclipse.papyrus.qompass.designer.core.CreationUtils;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;


/**
 * Copy a composite class while taking into account node allocation, i.e. only copy parts
 * that are deployed on a certain node (properties that are not typed by a component are always
 * copied). This function may be called several times and will successively add parts that are
 * required.
 * If the same composite (class level) is used in two different contexts, e.g. a socket connector
 * serving as client and server on the same node (for the same interface), the resulting composite
 * will be complete. On the instance level however, such as composite is sub-optimal, since their
 * are two different instances that use a different subset. These cases are not very critical, since
 * unused parts are not instantiated (overhead = pointer)
 * 
 * The function will change existing composites: they use directly implementations referenced in the
 * deployment plan.
 * 
 * 
 * **** ATTENTION **** This class is currently not used and will very probably not work
 * 
 * @author ansgar
 * 
 */
public class CopyCompositeOpt {

	public static Classifier copyComposite(Copy copy, InstanceSpecification is, Node node) throws TransformationException {
		Classifier classifier = DepUtils.getClassifier(is);
		if(!(classifier instanceof Class)) {
			return copy.getCopy(classifier);
		}
		Class smCl = (Class)classifier;

		NamedElement existing = Utils.getExistingNEinTarget(copy, smCl);
		if(existing instanceof Classifier) {
			// classifier exists already in target model (or is imported), nothing todo
			return (Classifier)existing;
		}

		// do not skip top, since copying imports: in this case, all elements appear in the package that
		// corresponds to their original model name
		Package newOwner = CreationUtils.getAndCreate(copy.target, smCl.allNamespaces(), false);

		String name = smCl.getName();
		Class newCl = null;
		NamedElement ne = newOwner.getMember(name);
		if(ne == null) {
			Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "copyCompositeOpt " + smCl.getQualifiedName() + " for node " + node.getName());
			newCl = newOwner.createOwnedClass(name, false);
			CopyCompositeOpt.copyRelationships(copy, smCl, newCl);
			// called before completion of access operations (getName), ...
			// => can copy all operations here (?)
			copy.copyOperations(smCl);
			copy.copyMethods(smCl);
			StUtils.copyStereotypes(smCl, newCl);
			// copy attributes typed with non-component types (that may not be referenced by slots)
			for(Property attribute : smCl.getOwnedAttributes()) {
				Type type = attribute.getType();
				if(attribute instanceof Port) {
					// do nothing (ports are copied below, since not only
					// owned, but also inherited ports are taken into account
					// (since inheritance relationship with connector types are suppressed).
				} else if(type instanceof Class) {
					if(!Utils.isComponent((Class)type)) {
						copy.getCopy(attribute);
					}
				} else {
					copy.getCopy(attribute);
				}
			}
			for(Port port : PortUtils.getAllPorts(smCl)) {
				ConnectorEnd ce = ConnectorUtils.getDelegation(smCl, port);
				if(ce == null) {
					copy.getCopy(port);
				}
			}
		} else if(ne instanceof Class) {
			Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "copyComposite (extend) " + smCl.getQualifiedName() + " for node " + node.getName());
			newCl = (Class)ne;
		} else {
			// exists, but is not a classifier
			// => don't know how to handle
			throw new TransformationException("error (copyClassifier): element <" + name + "> already exists in target package (<" + newOwner.getName() + ">), but is not a class");
		}

		for(Slot slot : is.getSlots()) {
			Property part = (Property)slot.getDefiningFeature();
			InstanceSpecification containedIS = DepUtils.getInstance(slot);
			Classifier containedCl = DepUtils.getClassifier(containedIS);
			String partName = part.getName();
			if(newCl.getOwnedAttribute(partName, null) == null) {
				// attribute does not exist yet
				if((containedCl instanceof Class) && (Utils.isComponent((Class)containedCl))) {
					// check whether allocation on this node...
					// would not re-open
					if(AllocUtils.getAllNodes(containedIS).contains(node)) {
						Classifier copiedCl = CopyCompositeOpt.copyComposite(copy, containedIS, node);
						newCl.createOwnedAttribute(partName, copiedCl);

						// add ports that are connected by means of a delegation relationship with the
						// port which has been copied to the new composite. These ports have not been
						// copied earlier.
						for(Port port : PortUtils.getAllPorts(smCl)) {
							ConnectorEnd ce = ConnectorUtils.getDelegation(smCl, port);
							if(ce != null) {
								if(ce.getPartWithPort() == part) {
									copy.getCopy(port);
								}
							}
						}

						// add connectors when possible, i.e. connectors that target the newly added part
						for(Connector connector : smCl.getOwnedConnectors()) {
							// check whether the newly added property enables the addition of connectors
							// that connect this port.
							if(ConnectorUtils.connectsPart(connector, part)) {
								ConnectorEnd otherEnd = ConnectorUtils.connEndNotPart(connector, part);
								// check whether the part references by the other end (i.e. that not connected with the part)
								// TODO: connections without port
								if((otherEnd.getPartWithPort() == null) || newCl.getAllAttributes().contains(otherEnd.getPartWithPort())) {
									copy.getCopy(connector);
								}
							}
						}
					}
				}
			}

		}
		return newCl;
	}

	/**
	 * Copy relationships. Similar to Copy.copyRelationships, but filters inheritance relationships
	 * i.e. copies inherited classes (and adds the relationships), but does not copy inherited
	 * component types.
	 * [Caveat: need component types in case of parts that are typed with a component type?]
	 * 
	 * @param root
	 * @param cl
	 * @param newCl
	 */
	public static void copyRelationships(Copy copy, Classifier cl, Classifier newCl)
		throws TransformationException {
		// copy relationships (and target classes, if not yet part of copied model)
		// Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "relationships of " + cl.getName ());
		for(DirectedRelationship relationship : cl.getSourceDirectedRelationships()) {
			Element target = relationship.getTargets().get(0);
			if(target instanceof Classifier) {
				Log.log(Log.INFO_MSG, Log.DEPLOYMENT, "  rel. target " + ((Classifier)target).getName());

				if(relationship instanceof Generalization) {
					if(!((target instanceof Class) && Utils.isCompType((Class)target))) {
						// copy, unless target is a component type
						Classifier newTarget = copy.getCopy((Classifier)target);
						newCl.createGeneralization(newTarget);
					}
				} else if(relationship instanceof Dependency) {
					Classifier newTarget = copy.getCopy((Classifier)target);
					String depName = ((Dependency)relationship).getName();
					// use generic method to support heirs of Dependency, such as Usage, Abstraction,
					// (Interface)Realization, ...
					Dependency dependency = (Dependency)newCl.getNearestPackage().createPackagedElement(depName, relationship.eClass());
					dependency.getClients().add(newCl);
					dependency.getSuppliers().add(newTarget);
				} else {
					throw new TransformationException("CoyCompositeOpt.copyRelationships: unsupported relationship: " + relationship);
				}
			}
		}
	}
}
