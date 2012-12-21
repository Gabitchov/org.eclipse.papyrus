package org.eclipse.papyrus.qompass.designer.core.transformations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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

import Cpp.CppPtr;
import FCM.InteractionComponent;

import org.eclipse.papyrus.qompass.designer.core.ConnectorUtils;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;

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
 * @author ansgar
 * 
 */
public class CompImplTrafos {

	public static Class bootloader;

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
				if(Utils.isCompImpl(implementation) && (implementation != bootloader)) {
					addGetPortOperation(implementation);
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
	private static void addGetPortOperation(Class implementation) {
		for(Port port : PortUtils.getAllPorts2(implementation)) {
			Interface providedIntf = PortUtils.getProvided(port);
			if(providedIntf != null) {
				// port provides an interface, add "get_p" operation & implementation

				String opName = PrefixConstants.getP_Prefix + port.getName();
				Operation op = implementation.createOwnedOperation(opName, null, null, providedIntf);
				Parameter retParam = op.getOwnedParameters().get(0);
				retParam.setName("ret");
				StUtils.apply(retParam, CppPtr.class);

				OpaqueBehavior behavior = (OpaqueBehavior)
					implementation.createOwnedBehavior(opName,
						UMLPackage.eINSTANCE.getOpaqueBehavior());
				op.getMethods().add(behavior);

				ConnectorEnd ce = ConnectorUtils.getDelegation(implementation, port);
				// if there is an delegation to an inner property, delegate to it
				// Make distinction between delegation to component (with a port) or
				// "normal" class (without).
				String body;
				if(ce != null) {
					Property part = ce.getPartWithPort();
					ConnectableElement role = ce.getRole();

					body = "return ";
					if(role instanceof Port) {
						// check whether the part exists within the implementation (might not be the case
						// due to partially copied composites).
						// Check is based on names, since the connector points to elements within another
						// model (copyClassifier does not make a proper connector copy)
						body += part.getName() + refOp(part) + PrefixConstants.getP_Prefix + role.getName() + " ();";
					} else {
						// role is not a port: connector connects directly to a structural feature
						// without passing via a port
						// TODO: check whether structural feature exists
						body += role.getName();
					}
				} else {
					// no delegation, check whether port implements provided interface
					if(implementation.getInterfaceRealization(null, providedIntf) != null) {
						body = "return this;";
					} else {
						// does not implement provided interface (may happen in case of composite distribution)
						// TODO: check whether assembly. Emit at least warning if not.
						// [cannot happen unless distributed? (or bug in transformation?)]
						if(StUtils.isApplied(implementation, InteractionComponent.class)) {
							// || StUtils.isAd(implementation, Assembly.class)) {
							body = "return 0;";
						}
						else {
							throw new RuntimeException("Interface <" + providedIntf.getName() + "> provided by port <" +
								port.getQualifiedName() + "> is not implemented by the component itself nor does the port delegate to a part");
						}
					}
				}
				// todo: defined by template
				behavior.getLanguages().add("C/C++");
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
					StUtils.apply(attribute, CppPtr.class);
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
		for(Port port : PortUtils.getAllPorts2(implementation)) {
			Interface requiredIntf = PortUtils.getRequired(port);
			if(requiredIntf != null) {
				// port requires an interface, add "connect_p" operation & implementation

				String opName = PrefixConstants.connectQ_Prefix + port.getName();

				// create operation (even if already inherited, the operation must be owned by
				// a class that add behavior - TODO: bug in C++ code generator?) 
				Operation op = implementation.createOwnedOperation(opName, null, null);
				boolean multiPort = (port.getUpper() > 1) || (port.getUpper() == -1); // -1 indicates "*"
				if(multiPort) {
					// add index parameter
					Element eLong = Utils.getQualifiedElement(Utils.getTop(implementation), "CORBA::Long");
					if(eLong instanceof Type) {
						op.createOwnedParameter("index", (Type)eLong);
					}
				}
				Parameter refParam = op.createOwnedParameter("ref", requiredIntf);
				StUtils.apply(refParam, CppPtr.class);

				OpaqueBehavior behavior = (OpaqueBehavior)
					implementation.createOwnedBehavior(opName,
						UMLPackage.eINSTANCE.getOpaqueBehavior());
				op.getMethods().add(behavior);

				ConnectorEnd ce = ConnectorUtils.getDelegation(implementation, port);
				// if there is an delegation to an inner property, delegate to it
				// Make distinction between delegation to component (with a port) or
				// "normal" class (without).
				String body;
				if(ce != null) {
					Property part = ce.getPartWithPort();
					body = part.getName();
					ConnectableElement role = ce.getRole();
					if(role instanceof Port) {
						body += refOp(part) + PrefixConstants.connectQ_Prefix + role.getName() + " ";
						if((port.getUpper() > 1) || (port.getUpper() == -1)) {
							body += "(index, ref);";
						} else {
							body += "(ref);";
						}

					} else {
						body += ";";
					}
				} else {
					// no delegation - create attribute for port
					String attributeName = PrefixConstants.attributePrefix + port.getName();
					if(!Utils.hasNonPortOwnedAttribute(implementation, attributeName)) {
						Property attr = implementation.createOwnedAttribute(attributeName, requiredIntf);
						Copy.copyMultElemModifiers(port, attr);
						// is shared (should store a reference)
						attr.setAggregation(AggregationKind.SHARED_LITERAL);
					}
					body = attributeName + (multiPort ? "[index]" : "") + " = ref;";
				}
				// TODO: defined by template
				behavior.getLanguages().add("C/C++");
				behavior.getBodies().add(body);

				// -------------------------
				// add body to get-connection operation (which exists already if the port is also
				// owned, since it is synchronized automatically during model edit)
				// getConnQ prefix may be empty to indicate that the port is accessed directly
				// TODO: reconsider optimization that delegated required ports do not have a
				//   local attribute & associated operation (an inner class may delegate, but the
				//   composite may be using it as well).
				if((PrefixConstants.getConnQ_Prefix.length() > 0) && (ce != null)) {
					opName = PrefixConstants.getConnQ_Prefix + port.getName();
					op = implementation.getOwnedOperation(opName, null, null);
					if(op == null) {
						op = implementation.createOwnedOperation(opName, null, null, requiredIntf);
						Parameter retParam = op.getOwnedParameters().get(0);
						retParam.setName("ret");
						StUtils.apply(retParam, CppPtr.class);
					}
					behavior = (OpaqueBehavior)
						implementation.createOwnedBehavior(opName,
							UMLPackage.eINSTANCE.getOpaqueBehavior());
					op.getMethods().add(behavior);

					// no delegation
					String name = PrefixConstants.attributePrefix + port.getName();
					body = "return " + name + ";";
					behavior.getLanguages().add("C/C++");
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
		String createConnBody = "";
		Map<String, Integer> indexMap = new HashMap<String, Integer>();

		for(Connector connector : implementation.getOwnedConnectors()) {
			if(ConnectorUtils.isAssembly(connector)) {
				// TODO: quite ugly (setter1/setter)
				String getter1 = "";
				String setter1 = "";
				String getter = "";
				String setter = "";
				String index = "";
				String index1 = "";
				Boolean associationBased = false;
				Property getPart = null;
				Property setPart = null;
				for(ConnectorEnd end : connector.getEnds()) {
					if(end.getRole() instanceof Port) {
						Port port = (Port)end.getRole();
						if(PortUtils.getProvided(port) != null) {
							if(getter.length() > 0) {
								getter1 = getter;
								// System.err.println("getter already assigned for connection " + connector.getName());
								// throw new TransformationException("assembly connector \"" + connector.getName() + "\" connects two provided ports");
							}
							getPart = end.getPartWithPort();
							getter = getPart.getName() + refOp(getPart) + "get_" + port.getName() + " ()";
						}
						if(PortUtils.getRequired(port) != null) {
							if(setter.length() > 0) {
								setter1 = setter;
								// System.err.println("setter already assigned for connection " + connector.getName());
								// throw new TransformationException("assembly connector \"" + connector.getName() + "\" connects two required ports");
							}
							setPart = end.getPartWithPort();
							setter = setPart.getName() + refOp(setPart) + "connect_" + port.getName();
							if((port.getUpper() > 1) || (port.getUpper() == -1)) {
								// index depends of combination of property and port, use setter as String
								Integer indexValue = indexMap.get(setter);
								if(indexValue == null) {
									indexValue = 0;
									indexMap.put(setter, indexValue);
								}
								if(index.length() > 0) {
									index1 = index;
								}
								index = indexValue + ", ";
								indexValue++;
								indexMap.put(setter, indexValue);
							}
						}
					}
					else if(end.getRole() instanceof Property) {
						Property part = (Property)end.getRole();
						Association association = connector.getType();
						if(association != null) {
							associationBased = true;
							Property assocProp1 = association.getMemberEnd(null, part.getType());
							Property assocProp2 = assocProp1.getOtherEnd();
							if(assocProp1 != null) {
								if(assocProp1.isNavigable()) { // if true, assume that "provided" is true
									if(getter.length() > 0) {
										getter1 = getter;
										// System.err.println("getter already assigned for connection " + connector.getName());
										// throw new TransformationException("assembly connector \"" + connector.getName() + "\" connects bidirectional association");
									}
									getPart = part;
									getter = "&" + getPart.getName();
								}
								else {
									// TODO: currently, exactly one association end must be navigable
									if(setter.length() > 0) {
										setter1 = setter;
										// System.err.println("setter already assigned for connection " + connector.getName());
										// throw new TransformationException("assembly connector \"" + connector.getName() + "\" connects bidirectional association");
									}
									setPart = part;
									setter = setPart.getName() + refOp(setPart) + assocProp2.getName();
								}
							}
						}
						else {
							// not handled (a connector not targeting a port must be typed)
							throw new TransformationException("Connector <" + connector.getName() + "> does not use ports, but it is not typed (only connectors between ports should not be typed)");
						}
					}
				}
				String cmd;
				cmd = "// realization of connector <" + connector.getName() + ">\n";
				if(instantiateViaBootloader(getPart) && instantiateViaBootloader(setPart)) {
					cmd += "if ((" + getPart.getName() + " != 0) && (" + setPart.getName() + " != 0)) {\n\t";
				}
				else if(instantiateViaBootloader(getPart)) {
					cmd += "if (" + getPart.getName() + " != 0) {\n\t";
				}
				else if(instantiateViaBootloader(setPart)) {
					cmd += "if (" + setPart.getName() + " != 0) {\n\t";
				}
				if(associationBased) {
					// TODO: make that a lot more clean
					if((getter1.length() > 0) && (setter1.length() > 0)) {
						cmd += setter1 + " = " + getter + ";\n";
						cmd += setter + " = " + getter1 + ";\n";
					}
					else {
						cmd += setter + " = " + getter + ";\n";
					}
				}
				else {
					if((getter1.length() > 0) && (setter1.length() > 0)) {
						cmd += setter1 + " (" + index1 + getter + ");\n";
						cmd += setter + " (" + index + getter1 + ");\n";
					}
					else {
						cmd += setter + " (" + index + getter + ");\n";
					}
				}

				if(instantiateViaBootloader(getPart) || instantiateViaBootloader(setPart)) {
					cmd += "}\n";
				}
				createConnBody += cmd + "\n";
			}
		}
		// TODO: use template, as in bootloader
		if(createConnBody.length() > 0) {
			Operation operation = implementation.createOwnedOperation("createConnections", null, null);

			OpaqueBehavior behavior = (OpaqueBehavior)
				implementation.createOwnedBehavior("b:" + operation.getName(),
					UMLPackage.eINSTANCE.getOpaqueBehavior());
			behavior.getLanguages().add("C/C++");
			behavior.getBodies().add(createConnBody);
			behavior.setSpecification(operation);
		}
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
	 * [Use aggregation kind "none"? Support only system fragments? suppress assemblies?
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
	 * @param implementation
	 * @return
	 */
	public static boolean instantiateViaBootloader(Class implementation) {
		return Utils.isCompType(implementation) ||
			implementation.isAbstract() || Utils.isSingleton(implementation);
	}

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
			"->" : ".";
	}
}
