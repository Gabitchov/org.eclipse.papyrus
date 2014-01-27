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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.C_Cpp.Ptr;
import org.eclipse.papyrus.FCM.PortKind;
import org.eclipse.papyrus.qompass.designer.core.ConnectorUtils;
import org.eclipse.papyrus.qompass.designer.core.Messages;
import org.eclipse.papyrus.qompass.designer.core.PortInfo;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This class realizes the transformations for a component implementation (the executor)
 * It includes:
 * 1. add the get_p operation for a port with a provided interface.
 * 2. add the connect_q operation and realization (*including a storage attribute*) for
 * a port with a required interface
 * 3. add an implementation for the getcnx_q operation for a port with a required interface
 * (the operation itself has been added before)
 * 
 * TODO: C++ specific, support different "component to OO" mappings
 * 
 * Caveat: Assure that the folder derivedInterfaces already exists in a model. Otherwise
 * the call to getProvided/getRequired interface might trigger its creation resulting in
 * the corruption of list iterators (ConcurrentAccess exception)
 * 
 */
public class CompImplTrafos {

	public static Class bootloader;

	public static final String retParamName = "ret"; //$NON-NLS-1$
	
	public static final String progLang = "C/C++"; //$NON-NLS-1$
	
	public static void addPortOperations(Copy copy, Package pkg) throws TransformationException {
		EList<PackageableElement> peList = new BasicEList<PackageableElement>();
		peList.addAll(pkg.getPackagedElements());
		for(PackageableElement element : peList) {
			if(element instanceof Package) {
				addPortOperations(copy, (Package)element);
			} else if(element instanceof Class) {
				Class implementation = (Class)element;
				// we may not apply the transformation to the boot-loader itself, in particular it would transform
				// singletons into pointers.
				if(Utils.isCompImpl(implementation) && (implementation != bootloader) && !StereotypeUtil.isApplied(implementation,  PortKind.class)) {
					addGetPortOperation(copy, implementation);
					addConnectPortOperation(copy, implementation);
					markPartsPointer(implementation);
				}
				addCreateConnections(implementation);
			}
		}
	}

	/**
	 * Add the get_p operation for each port with a provided interface. It also adds a suitable
	 * implementation that evaluates delegation connectors from the port to a property within
	 * the composite. The delegation target could either be a normal class (no port) or an
	 * inner component.
	 * 
	 * @param implementation
	 */
	private static void addGetPortOperation(Copy copy, Class implementation) {
		for(PortInfo portInfo : PortUtils.flattenExtendedPorts(PortUtils.getAllPorts2(implementation))) {
			Interface providedIntf = portInfo.getProvided();
			if(providedIntf != null) {
				// port provides an interface, add "get_p" operation & implementation

				String opName = PrefixConstants.getP_Prefix + portInfo.getName();
				Operation op = implementation.getOwnedOperation(opName, null, null);
				if (op != null) {
					// operation already exists. Assume that user wants to override standard delegation
					if (op.getType() != providedIntf) {
						op.createOwnedParameter(retParamName, providedIntf);
					}
					continue;
				}
				op = implementation.createOwnedOperation(opName, null, null, providedIntf);
				Parameter retParam = op.getOwnedParameters().get(0);
				retParam.setName(retParamName);
				StereotypeUtil.apply(retParam, Ptr.class);

				OpaqueBehavior behavior = (OpaqueBehavior)
					implementation.createOwnedBehavior(opName,
						UMLPackage.eINSTANCE.getOpaqueBehavior());
				op.getMethods().add(behavior);

				ConnectorEnd ce = ConnectorUtils.getDelegation(implementation, portInfo.getModelPort());
				// if there is an delegation to an inner property, delegate to it
				// Make distinction between delegation to component (with a port) or
				// "normal" class (without).
				String body;
				if(ce != null) {
					Property part = ce.getPartWithPort();
					ConnectableElement role = ce.getRole();

					body = "return ";  //$NON-NLS-1$
					if(role instanceof Port) {
						// check whether the part exists within the implementation (might not be the case
						// due to partially copied composites).
						// Check is based on names, since the connector points to elements within another
						// model (copyClassifier does not make a proper connector copy)
						// body += part.getName() + refOp(part) + opName + "();";  //$NON-NLS-1$
						// TODO: this will NOT work for extended ports!
						body += part.getName() + refOp(part) + PrefixConstants.getP_Prefix + role.getName() + "();"; //$NON-NLS-1$
					}
					else {
						// role is not a port: connector connects directly to a structural feature
						// without passing via a port
						// TODO: check whether structural feature exists
						body += role.getName();
					}
				} else {
					// no delegation, check whether port implements provided interface
					boolean implementsIntf = implementation.getInterfaceRealization(null, providedIntf) != null;
					if (!implementsIntf) {
						// The extended port itself is not copied to the target model (since referenced via a stereotype). Therefore,
						// a port of an extended port still points to the original model. We try whether the providedIntf within
						// the target model is within the interface realizations.
						Interface providedIntfInCopy = (Interface) copy.get(providedIntf);
						implementsIntf = implementation.getInterfaceRealization(null, providedIntfInCopy) != null;
					}
					if (implementsIntf || true) {
						body = "return this;";	 //$NON-NLS-1$
					}
					else {
						throw new RuntimeException(String.format(
							Messages.CompImplTrafos_IntfNotImplemented,
							providedIntf.getName(), portInfo.getPort().getName(), implementation.getName()));
					}
				}
				// todo: defined by template
				behavior.getLanguages().add(progLang);
				behavior.getBodies().add(body);
			}
		}
	}

	/**
	 * if the bootloader is responsible for creating an instance (if it is a abstract type), mark
	 * the associated part as a C++ pointer.
	 * We do not want to change the aggregation kind, since it remains logically a composition, it
	 * is merely an implementation issue that it must be a pointer for C++ if the concrete type is
	 * not yet known.
	 * 
	 * 
	 * @param implementation
	 */
	private static void markPartsPointer(Class implementation) {
		for(Property attribute : Utils.getParts(implementation)) {
			Type type = attribute.getType();
			if(type instanceof Class) {
				Class cl = (Class)type;
				// => requires adaptations of boot-loader which is then only responsible for creating instances
				//    corresponding to types
				if(instantiateViaBootloader(cl)) {
					StereotypeUtil.apply(attribute, Ptr.class);
				}
			}
		}
	}

	/**
	 * Add a connect_<portName> operation for ports with a required interface.
	 * Whereas operation and a behavior is added for each owned port, a behavior (method) is
	 * needed for ports inherited from a component type (the behavior is implementation specific,
	 * as it needs to take delegation to parts into account)
	 * 
	 * @param implementation
	 */
	private static void addConnectPortOperation(Copy sat, Class implementation) {
		for(PortInfo portInfo : PortUtils.flattenExtendedPorts(PortUtils.getAllPorts2(implementation))) {
			Interface requiredIntf = portInfo.getRequired();
			if(requiredIntf != null) {
				// port requires an interface, add "connect_p" operation & implementation

				String opName = PrefixConstants.connectQ_Prefix + portInfo.getName();

				if (implementation.getOwnedOperation(opName, null, null) != null) {
					// do not add the operation, if it already exists. This means that the
					// user wants to override it with custom behavior. In case of extended
					// ports, we may have to do that.
					continue;
				}
				Operation op = implementation.createOwnedOperation(opName, null, null);
				boolean multiPort = (portInfo.getUpper() > 1) || (portInfo.getUpper() == -1); // -1 indicates "*"
				if(multiPort) {
					// add index parameter
					Element eLong = Utils.getQualifiedElement(Utils.getTop(implementation), CompTypeTrafos.INDEX_TYPE_FOR_MULTI_RECEPTACLE);
					if(eLong instanceof Type) {
						op.createOwnedParameter("index", (Type)eLong); //$NON-NLS-1$
					}
					else {
						throw new RuntimeException(String.format(
							Messages.CompImplTrafos_CannotFindType,
							CompTypeTrafos.INDEX_TYPE_FOR_MULTI_RECEPTACLE));
					}
				}
				Parameter refParam = op.createOwnedParameter("ref", requiredIntf); //$NON-NLS-1$
				StereotypeUtil.apply(refParam, Ptr.class);

				OpaqueBehavior behavior = (OpaqueBehavior)
					implementation.createOwnedBehavior(opName,
						UMLPackage.eINSTANCE.getOpaqueBehavior());
				op.getMethods().add(behavior);

				ConnectorEnd ce = ConnectorUtils.getDelegation(implementation, portInfo.getModelPort());
				// if there is an delegation to an inner property, delegate to it
				// Make distinction between delegation to component (with a port) or
				// "normal" class (without).
				String body;
				if(ce != null) {
					Property part = ce.getPartWithPort();
					body = part.getName();
					ConnectableElement role = ce.getRole();
					if(role instanceof Port) {
						body += refOp(part) + opName;
						if((portInfo.getUpper() > 1) || (portInfo.getUpper() == -1)) {
							body += "(index, ref);"; //$NON-NLS-1$
						} else {
							body += "(ref);"; //$NON-NLS-1$
						}

					} else {
						body += ";"; //$NON-NLS-1$
					}
				} else {
					// no delegation - create attribute for port
					String attributeName = PrefixConstants.attributePrefix + portInfo.getName();
					if(!Utils.hasNonPortOwnedAttribute(implementation, attributeName)) {
						Property attr = implementation.createOwnedAttribute(attributeName, requiredIntf);
						Copy.copyMultElemModifiers(portInfo.getPort(), attr);
						// is shared (should store a reference)
						attr.setAggregation(AggregationKind.SHARED_LITERAL);
					}
					body = attributeName + (multiPort ? "[index]" : "") + " = ref;";  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
				}
				// TODO: defined by template
				behavior.getLanguages().add(progLang);
				behavior.getBodies().add(body);

				// -------------------------
				// add body to get-connection operation (which exists already if the port is also
				// owned, since it is synchronized automatically during model edit)
				// getConnQ prefix may be empty to indicate that the port is accessed directly
				// TODO: reconsider optimization that delegated required ports do not have a
				//   local attribute & associated operation (an inner class may delegate, but the
				//   composite may be using it as well).
				if((PrefixConstants.getConnQ_Prefix.length() > 0) && (ce != null)) {
					opName = PrefixConstants.getConnQ_Prefix + portInfo.getName();
					op = implementation.getOwnedOperation(opName, null, null);
					if(op == null) {
						op = implementation.createOwnedOperation(opName, null, null, requiredIntf);
						Parameter retParam = op.getOwnedParameters().get(0);
						retParam.setName(retParamName);
						StereotypeUtil.apply(retParam, Ptr.class);
					}
					behavior = (OpaqueBehavior)
						implementation.createOwnedBehavior(opName,
							UMLPackage.eINSTANCE.getOpaqueBehavior());
					op.getMethods().add(behavior);

					// no delegation
					String name = PrefixConstants.attributePrefix + portInfo.getName();
					body = "return " + name + ";"; //$NON-NLS-1$ //$NON-NLS-2$
					behavior.getLanguages().add(progLang);
					behavior.getBodies().add(body);
				}
			}
		}
	}

	/**
	 * Add an operation "createConnections" that implements the connections between composite
	 * parts. It only takes the assembly connections into account, since delegation connectors
	 * are handled by the get_ and connect_ port operations above.
	 * 
	 * @param implementation
	 */
	private static void addCreateConnections(Class implementation)
		throws TransformationException {
		String createConnBody = ""; //$NON-NLS-1$
		Map<ConnectorEnd, Integer> indexMap = new HashMap<ConnectorEnd, Integer>();

		for(Connector connector : implementation.getOwnedConnectors()) {
			if(ConnectorUtils.isAssembly(connector)) {
				// Boolean associationBased = false;
				if (connector.getEnds().size() != 2) {
					throw new TransformationException("Connector <" + connector.getName() + "> does not have two ends. This is currently not supported"); //$NON-NLS-1$ //$NON-NLS-2$
				}
				ConnectorEnd end1 = connector.getEnds().get(0);
				ConnectorEnd end2 = connector.getEnds().get(1);
				String cmd;
				cmd = "// realization of connector <" + connector.getName() + ">\n";  //$NON-NLS-1$//$NON-NLS-2$
				if ((end1.getRole() instanceof Port) && PortUtils.isExtendedPort((Port) end1.getRole())) {
					Port port = (Port) end1.getRole();
					EList<PortInfo> subPorts = PortUtils.flattenExtendedPort(port);
					for (PortInfo subPort : subPorts) {
						cmd += "  // realization of connection for sub-port " + subPort.getPort().getName() + "\n";  //$NON-NLS-1$//$NON-NLS-2$
						cmd += connectPorts(indexMap, connector, end1, end2, subPort.getPort());
						cmd += connectPorts(indexMap, connector, end2, end1, subPort.getPort());
					}
				}
				else {
					cmd += connectPorts(indexMap, connector, end1, end2, null);
					cmd += connectPorts(indexMap, connector, end2, end1, null);
				}
				createConnBody += cmd + "\n"; //$NON-NLS-1$
			}
		}
		// TODO: use template, as in bootloader
		if(createConnBody.length() > 0) {
			Operation operation = implementation.createOwnedOperation("createConnections", null, null); //$NON-NLS-1$

			OpaqueBehavior behavior = (OpaqueBehavior)
				implementation.createOwnedBehavior("b:" + operation.getName(), //$NON-NLS-1$
					UMLPackage.eINSTANCE.getOpaqueBehavior());
			behavior.getLanguages().add(progLang);
			behavior.getBodies().add(createConnBody);
			behavior.setSpecification(operation);
		}
	}

	/**
	 * Create a connection between the two ends of a receptacle. This function checks whether the first end really is
	 * a receptacle and the second really is a facet.
	 * @param indexMap a map of indices that are used in case of multiplex receptacles
	 * @param connector a connector
	 * @param receptacleEnd an end of the connector that may point to a receptacle port
	 * @param facetEnd an end of the connector that may point to a facet port
	 * @param subPort a sub-port in case of extended ports
	 * @return
	 * @throws TransformationException
	 */
	public static String connectPorts(Map<ConnectorEnd, Integer> indexMap, Connector connector, ConnectorEnd receptacleEnd, ConnectorEnd facetEnd, Port subPort)
			throws TransformationException
	{
		Association association = connector.getType();
		if((receptacleEnd.getRole() instanceof Port) && (facetEnd.getRole() instanceof Port)) {
			Port facetPort = (Port) facetEnd.getRole();
			Port receptaclePort = (Port) receptacleEnd.getRole();
			PortInfo facetPI = PortInfo.fromSubPort(facetPort, subPort);
			PortInfo receptaclePI = PortInfo.fromSubPort(receptaclePort, subPort);

			if((facetPI.getProvided() != null) && (receptaclePI.getRequired() != null)) {
				Property facetPart = facetEnd.getPartWithPort();
				Property receptaclePart = receptacleEnd.getPartWithPort();
					
				String subPortName = (subPort != null) ? "_" + subPort.getName() : ""; //$NON-NLS-1$ //$NON-NLS-2$
				String indexName = getIndexName(indexMap, receptaclePort, receptacleEnd);
				String setter = receptaclePart.getName() + refOp(receptaclePart) + "connect_" + receptaclePort.getName() + subPortName; //$NON-NLS-1$
				String getter = facetPart.getName() + refOp(facetPart) + "get_" + facetPort.getName() + subPortName + "()"; //$NON-NLS-1$ //$NON-NLS-2$
				return setter + "(" + indexName + getter + ");\n"; //$NON-NLS-1$ //$NON-NLS-2$
			}
				
		}
		else if(receptacleEnd.getRole() instanceof Port) {
			// only the receptacle end is of type port.
			Port receptaclePort = (Port) receptacleEnd.getRole();
			if(PortUtils.getRequired(receptaclePort) != null) {
				Property facetPart = (Property) facetEnd.getRole();
				Property receptaclePart = facetEnd.getPartWithPort();
					
				String indexName = getIndexName(indexMap, receptaclePort, receptacleEnd);
				String setter = receptaclePart.getName() + refOp(receptaclePart) + "connect_" + receptaclePort.getName(); //$NON-NLS-1$
				String getter = facetPart.getName() + refOp(facetPart) + facetPart.getName();
				return setter + "(" + indexName + getter + ");\n"; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		else if(facetEnd.getRole() instanceof Port) {
			// only the receptacle end is of type port.
			Port facetPort = (Port) facetEnd.getRole();
			if(PortUtils.getProvided(facetPort) != null) {
				Property facetPart = facetEnd.getPartWithPort();
				Property receptaclePart = (Property) facetEnd.getRole();
					
				String setter = receptaclePart.getName();
				String getter = facetPart.getName() + refOp(facetPart) + "get_" + facetPort.getName() + " ()"; //$NON-NLS-1$ //$NON-NLS-2$
				return setter + " = " + getter + ";\n"; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		else if(association != null) {
			// both connector ends do not target ports. In this case, we require that the connector is typed
			// with an association. We use this association to find out which end is navigable and assume that
			// the part pointed to by the other end is a pointer that gets initialized with the part of the
			// navigable end.
			Property facetPart = (Property) facetEnd.getRole();
			Property receptaclePart = (Property) receptacleEnd.getRole();
					
			Property assocProp1 = association.getMemberEnd(null, facetPart.getType());
			// Property assocProp2 = facetPart.getOtherEnd();
			if((assocProp1 != null) && assocProp1.isNavigable()) {
				String setter = receptaclePart.getName() + refOp(receptaclePart)+ assocProp1.getName();
				String getter = "&" + facetPart.getName(); //$NON-NLS-1$
				return setter + " = " + getter + ";\n"; //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		else {
			// not handled (a connector not targeting a port must be typed)
			throw new TransformationException("Connector <" + connector.getName() + //$NON-NLS-1$
					"> does not use ports, but it is not typed (only connectors between ports should not be typed)"); //$NON-NLS-1$
		}
		return ""; //$NON-NLS-1$
	}
	
	/**
	 * Handle ports with multiplicity > 1. The idea is that we could have multiple connections targeting a receptacle.
	 * The first connection would start with index 0. Implementations can make no assumption which connection is associated
	 * with a certain index. [want to avoid associative array in runtime].
	 * @param port
	 * @param end
	 * @return
	 */
	public static String getIndexName (Map<ConnectorEnd, Integer> indexMap, Port port, ConnectorEnd end) {
		if((port.getUpper() > 1) || (port.getUpper() == -1)) {
			// index depends of combination of property and port, use connector end as key
			Integer indexValue = indexMap.get(end);
			if(indexValue == null) {
				indexValue = 0;
				indexMap.put(end, indexValue);
			}
			String index = indexValue + ", "; //$NON-NLS-1$
			indexValue++;
			indexMap.put(end, indexValue);
			return index;
		}	
		return ""; //$NON-NLS-1$
	}	
	
	public static void deleteConnectors(Package pkg) {
		Iterator<PackageableElement> elements = pkg.getPackagedElements().iterator();
		while(elements.hasNext()) {
			PackageableElement element = elements.next();
			if(element instanceof Package) {
				deleteConnectors((Package)element);
			} else if(element instanceof Class) {
				Class implementation = (Class)element;
				implementation.getOwnedConnectors().clear();
			}
		}
	}

	/**
	 * Return true, if the bootloader is responsible for the instantiation of a part.
	 * [Structual difference: bootloader can decide instance based - and instances are deployed]
	 *
	 * If a part is a component type or an abstract implementation, it cannot be instantiated. Thus, a heir
	 * has to be selected in the deployment plan. Since the selection might be different for different instances
	 * of the composite, the instantiation is not done by the component itself, but by the bootloader.
	 * The bootloader also has to instantiate, if different allocation variants are required.
	 * (this is for instance the case for distribution connectors and for the system itself)
	 * 
	 * If possible, we want to let composites instantiate sub-components, since this eases
	 * the transition to systems which support reconfiguration.
	 * 
	 * [TODO: optimization: analyze whether the deployment plan selects a single implementation. If yes, let the
	 * composite instantiate]
	 * 
	 * [TODO: elements within an assembly need to be instantiated by composite - if System - by bootloader.
	 * assembly also need to be instantiated by composite!!
	 * 
	 * @param implementation
	 * @return
	 */
	public static boolean instantiateViaBootloader(Class implementation) {
		return Utils.isCompType(implementation) ||
			implementation.isAbstract() || Utils.isSingleton(implementation) ||
			Utils.isAssembly(implementation);
	}

	/**
	 * Return whether a part needs to be instantiated by the bootloader instead by the
	 * composite in which it is contained. The criteria is based on the question whether
	 * the containing composite is flattened, as it is the case for the system
	 * component and the interaction components for distribution. 
	 * @param part
	 * @return
	 */
	public static boolean instantiateViaBootloader(StructuralFeature part) {
		if(part != null) {
			if(part.getType() instanceof Class) {
				Class implementation = (Class)part.getType();
				// TODO: wrong criteria? (must be shared or not?)
				return instantiateViaBootloader(implementation);
			}
			else {
				// not a class, assume primitive type instantiated by composite
				return false;
			}
		}
		return false;
	}

	/**
	 * return the operator for (de-) referencing a part. If the part is instantiate via the
	 * bootloader, it becomes a pointer. If it is instantiated by the composite itself,
	 * it is not a pointer, it will be instantiated along with the composite
	 * 
	 * @param part
	 * @return
	 */
	protected static String refOp(Property part) {
		return instantiateViaBootloader(part) ?
			"->" : "."; //$NON-NLS-1$ //$NON-NLS-2$
	}
}
