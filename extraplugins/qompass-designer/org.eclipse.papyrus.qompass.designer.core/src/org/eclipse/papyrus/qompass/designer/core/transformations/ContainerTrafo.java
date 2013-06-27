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

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.FCM.InterceptionKind;
import org.eclipse.papyrus.FCM.InterceptionRule;
import org.eclipse.papyrus.qompass.designer.core.ConnectorUtils;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.acceleo.UMLTool;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepCreation;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.extensions.InstanceConfigurator;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateInstantiation;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateUtils;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Make the container transformation, i.e. add elements into a container
 *
 */
public class ContainerTrafo extends AbstractContainerTrafo {

	public static final String executorPartName = "_executor";

	public static final String interceptorName = "intercept ";

	/**
	 * Constructor
	 * 
	 * @param sat
	 *        information about source and target model
	 * @param tmCDP
	 *        deployment plan within target model
	 */
	public ContainerTrafo(Copy copy, Package tmCDP) {
		this.copy = copy;
		this.tmCDP = tmCDP;
		configureOnly = false;
	}

	/**
	 * creates the executor. Needs to be called *before* the other operations of
	 * this class.
	 * 
	 * @param tmComponent
	 *        the implementation of a component
	 * 
	 * @throws TransformationException
	 */
	public void createContainer(Class smComponent, Class tmComponent) throws TransformationException {
		Package tmPkgOwner = (Package)tmComponent.getOwner();
		// create a container with the name of the original component
		// renaming existing component (postfix "_e" for "executor")
		if(false) {
			tmContainerImpl = tmPkgOwner.createOwnedClass(tmComponent.getName(), false);
			tmComponent.setName(tmComponent.getName() + "_e");
		}
		else {
			tmContainerImpl = tmPkgOwner.createOwnedClass(tmComponent.getName() + "_cc", false);
		}
		Copy.copyID(tmComponent, tmContainerImpl, "c");

		// add part and slot corresponding to component;
		executorPart = tmContainerImpl.createOwnedAttribute(executorPartName, tmComponent);
		Copy.copyID(tmComponent, executorPart, "e");

		this.smClass = smComponent;

		executorPart.setIsComposite(true);

		// copy ports from the executor (tmComponent) to the container
		// (tmContainerImpl)
		// TODO: connectors still point to the ports of the executor, implying a non-well-formed
		//   model. Yet code generation works, as port names are identical
		for(Port port : PortUtils.getAllPorts(tmComponent)) {
			// copy port
			Port newPort = EcoreUtil.copy(port); // don't use E3CM copy, since this is not a copy from source to target model
			tmContainerImpl.getOwnedAttributes().add(newPort);
			StUtils.copyStereotypes(port, newPort);

			// create delegation for application port
			Connector containerDelegation = tmContainerImpl.createOwnedConnector("delegation " + port.getName());
			Copy.copyID(tmContainerImpl, containerDelegation);
			ConnectorEnd end1 = containerDelegation.createEnd();
			end1.setRole(newPort);
			ConnectorEnd end2 = containerDelegation.createEnd();
			end2.setPartWithPort(executorPart);
			end2.setRole(port);
		}

		// Inheritance issues:
		// currently: container never copies inheritance relationships, but copies inherited ports into container
		//    Problem: polymorphism would stop working.
		// Objective: use inheritance, if possible, but avoid that container inherits from an original non-abstract class (avoid duplication of attributes, ...)
		//   Option: container inherits from fully abstract super-classes (might have to consider indirect super-classes).
		//   All connectors and container extension remain within container (i.e. no inheritance of connectors and container extensions)
		// Remaining problems: Imagine that component A inherits from component B and both have state-charts.
		//   => containers of A and B would define a state-Machine and an event pool.
		//   => No shared pool (but anyway: semantics of this construct is not very clear).
		containers.put(tmComponent, this);
	}

	/**
	 * Create a container for a HW class. This is an additional software class
	 * within the system. There is no executor part, i.e. executorPart remains
	 * 
	 * @param tmComponent
	 *        the implementation of a component
	 * 
	 * @throws TransformationException
	 */
	public void createHwContainer(Class tmComponent) throws TransformationException {
		Package tmPkgOwner = (Package)tmComponent.getOwner();
		tmContainerImpl = tmPkgOwner.createOwnedClass(tmComponent.getName() + "Hwcc", false);
		Copy.copyID(tmComponent, tmContainerImpl, "hwcc");

		// register created container
		containers.put(tmComponent, this);
	}

	/**
	 * Create an instance of the container (UML instance specification)
	 * 
	 * @param tmComponent
	 *        the component within the target model for which we want to create an instance
	 * 
	 * @param tmIS
	 *        the existing instance specification for the component before container expansion. This
	 *        instance specification becomes the new instance specification of the executor.
	 * @param context
	 *        Additional information about the container that is used by instance configurators
	 */
	public void createContainerInstance(Class tmComponent, InstanceSpecification tmIS, ContainerContext context) {
		// create an instance specification for the container
		containerIS = (InstanceSpecification)tmCDP.createPackagedElement(tmIS.getName(), UMLPackage.eINSTANCE.getInstanceSpecification());
		// assign new name to original instance specification which reflects
		// role within containment hierarchy
		tmIS.setName(tmIS.getName() + "._executor");
		containerIS.getClassifiers().add(tmContainerImpl);
		// existing instance specification (tmIS) is the executor instance specification
		DepCreation.createSlot(containerIS, tmIS, executorPart);
		executorIS = tmIS;
		counter = 0;
		// containers.put(tmComponent, this);
		this.context = context;
		context.executorIS = executorIS;
		/*
		 * // now create instances for the contained elements
		 * for(Property extensionPart : tmContainerImpl.getAttributes()) {
		 * Type tmContainerExtImpl = extensionPart.getType();
		 * if(tmContainerExtImpl instanceof Class) {
		 * InstanceSpecification containerExtIS = DepCreation.createDepPlan(tmCDP, (Class)tmContainerExtImpl, containerIS.getName() + "." +
		 * extensionPart.getName(), false);
		 * // configure extension
		 * InstanceConfigurator.configureInstance(executorIS, smPart, containerExtIS, null);
		 * DepCreation.createSlot(containerIS, containerExtIS, extensionPart);
		 * }
		 * }
		 */
	}

	/**
	 * Create an instance of the container (UML instance specification)
	 * 
	 * @param tmComponent
	 * @param tmIS
	 */
	public void createHwContainerInstance(Class tmComponent, InstanceSpecification tmNode, ContainerContext context) {
		// create an instance specification for the container
		containerIS = (InstanceSpecification)tmCDP.createPackagedElement(tmNode.getName() + "HWC", UMLPackage.eINSTANCE.getInstanceSpecification());
		// assign new name to original instance specification which reflects
		// role within containment hierarchy
		containerIS.getClassifiers().add(tmContainerImpl);
		// containers.put(tmComponent, this);
		counter = 0;
		executorIS = tmNode;
		this.context = context;
		context.executorIS = executorIS;
	}

	/**
	 * return the reference of the created container class
	 * 
	 * @return
	 */
	public Class getContainer() {
		return tmContainerImpl;
	}

	/**
	 * apply a container rule, i.e. add either a container extension or an
	 * interceptor to the container
	 * 
	 * @param smContainerRule
	 *        An container rule
	 * @param smComponent
	 *        the application component in the source model
	 * @param tmComponent
	 *        the application component in the target model
	 * @param tmIS
	 *        the instance specification for the application component in the target model
	 * @throws TransformationException
	 */
	public void applyRule(ContainerRule smContainerRule, Class smComponent, Class tmComponent, InstanceSpecification tmIS)
		throws TransformationException
	{
		Map<Property, EList<Property>> interceptorPartsMap = new HashMap<Property, EList<Property>>();

		for(Property part : smContainerRule.getBase_Class().getAllAttributes()) {
			Type type = part.getType();
			if(type == null) {
				String ruleName = (smContainerRule.getBase_Class() != null) ? smContainerRule.getBase_Class().getName() : "undefined";
				throw new TransformationException("Cannot apply container rule <" + ruleName + ">, since the type of one of its parts is undefined. Check for unresolved proxies in imports");
			}
			if(part instanceof Port) {
				Port newPort = tmContainerImpl.createOwnedPort(part.getName(), part.getType());
				StUtils.copyStereotypes(part, newPort);
			}
			else if(type instanceof Class) {
				Class extOrInterceptor = (Class)type;
				// DepUtils.chooseImplementation((Class) type,
				// new BasicEList<InstanceSpecification>(), false);

				if(StUtils.isApplied(extOrInterceptor, InteractionComponent.class)) {

					InterceptionRule interceptionRule = StUtils.getApplication(part, InterceptionRule.class);
					InterceptionKind interceptionKind = InterceptionKind.INTERCEPT_ALL; // default: intercept all ports
					EList<Feature> interceptFeatures = null;
					if(interceptionRule != null) {
						interceptionKind = interceptionRule.getInterceptionKind();
						interceptFeatures = interceptionRule.getInterceptionSet();
					}
					EList<Property> interceptorParts =
						expandInterceptorExtension(interceptionKind, interceptFeatures, extOrInterceptor, tmComponent);
					interceptorPartsMap.put(part, interceptorParts);
				}
				else if(StUtils.isApplied(part, InterceptionRule.class)) {
					throw new TransformationException("The part " + part.getName() + " in rule " + smContainerRule.getBase_Class().getName() + "" +
						" has an interceptionRule, but is not typed with an interaction component");
				}
				else {
					Property extensionPart =
						expandAggregationExtension(part.getName(), extOrInterceptor, tmComponent);
					// register relation to facilitate connector copy
					copy.setPackageTemplate(smContainerRule.getBase_Class(), tmContainerImpl);
					copy.put(part, extensionPart);
					copy.setPackageTemplate(null, null);
				}
			}
		}
		createConnectorForAssociations();
		// tell copy that tmcontainerImpl is associated with the smContainerRule
		// register a package template (although it is not a template) to assure that the connectors
		// get copied, although they are in a different resource (only the connectors are copied, not
		// the types of the referenced parts).
		// [main issue here: properties of container rule are not copies in the sense of identical
		// copies]
		copy.setPackageTemplate(smContainerRule.getBase_Class(), tmContainerImpl);

		for(Connector connector : smContainerRule.getBase_Class().getOwnedConnectors()) {
			Property ruleInterceptorPart = null;
			for(Property part : interceptorPartsMap.keySet()) {
				if(ConnectorUtils.connectsPart(connector, part)) {
					// this connector is a connection between an interceptor (and another part which may not
					// be an interceptor => TODO: validation rule yet to write
					// we need to copy this connector multiple times, once for each associated interceptor part
					ruleInterceptorPart = part;
					break;
				}
			}
			if(ruleInterceptorPart != null) {
				for(Property interceptorPart : interceptorPartsMap.get(ruleInterceptorPart)) {
					// map an interceptor part within rule successively to to an interceptor part
					// within the container
					copy.put(ruleInterceptorPart, interceptorPart);
					copy.removeForCopy(connector);
					copy.getCopy(connector);
				}
			}
			else {
				// check whether FCM connector
				org.eclipse.papyrus.FCM.Connector fcmConn = StUtils.getConnector(connector);
				if(fcmConn != null) {
					Property connectorPart = ConnectorReification.reifyConnector(copy, tmContainerImpl,
						UMLTool.varName(connector), connector, containerIS, null);
					// don't create specific configuration slots (don't know how to specific in source model)
					InstanceSpecification tmReifiedConnectorIS = DepCreation.createDepPlan(
						tmCDP, (Class)connectorPart.getType(),
						tmIS.getName() + "." + connector.getName(), false);
				}
				else {
					copy.remove(connector);
					copy.getCopy(connector);
				}
			}
		}
		copy.setPackageTemplate(null, null);
	}

	/**
	 * This container expansion does not create a new composite. Instead, it
	 * adds the extension as a part to the copied application component. The
	 * application component also inherits from the type of the container
	 * extension in order to avoid copying ports.
	 */
	Property expandAggregationExtension(String name, Class smContainerExtImpl, Class tmComponent) throws TransformationException {
		Property extensionPart;
		Class tmContainerExtImpl = null;
		if(configureOnly) {
			extensionPart = tmContainerImpl.getAttribute(name, null);
			if((extensionPart != null) && extensionPart.getType() instanceof Class) {
				tmContainerExtImpl = (Class)extensionPart.getType();
			}
		}
		else {
			TemplateSignature signature = TemplateUtils.getSignature(smContainerExtImpl);
			if(signature == null) {
				// no template signature, just copy the container extension into the target model
				tmContainerExtImpl = copy.getCopy(smContainerExtImpl);
			} else {
				// template signature found, instantiate container extension via the
				// template binding mechanism
				TemplateBinding binding = TemplateUtils.fixedBinding(copy.target, smContainerExtImpl, tmComponent);
				Object[] args = new Object[]{};
				TemplateInstantiation ti = new TemplateInstantiation(copy, binding, args);
				tmContainerExtImpl = (Class)ti.bindNamedElement(smContainerExtImpl);
			}

			// add part associated with the extension to the container
			extensionPart = tmContainerImpl.createOwnedAttribute(name, tmContainerExtImpl);
		}
		// problem: would not be unique in case of multiple extensions
		// Copy.copyID(tmComponent, extensionPart, "a");
		extensionPart.setIsComposite(true);
		// TODO separation of container creation and instance creation
		InstanceSpecification containerExtIS = DepCreation.createDepPlan(tmCDP, tmContainerExtImpl, containerIS.getName() + "." + extensionPart.getName(), false);
		// configure extension
		context.port = null;
		InstanceConfigurator.configureInstance(containerExtIS, extensionPart, context);
		DepCreation.createSlot(containerIS, containerExtIS, extensionPart);

		return extensionPart;
	}

	/**
	 * Expand an interceptor definition between the container and the executor.
	 * 
	 * @param extKind
	 *        the interception kind (intercept which ports: all, some, out, ...)
	 * @param featureList
	 *        The set of ports to intercept (In case of "some" above)
	 * @param smContainerConnImpl
	 *        The connector (interceptor) implementation in the source model
	 * @param tmComponent
	 *        the application component (executor) in the target model
	 * @return
	 * @throws TransformationException
	 */
	EList<Property> expandInterceptorExtension(InterceptionKind extKind, EList<Feature> featureList, Class smContainerConnImpl, Class tmComponent)
		throws TransformationException
	{
		EList<Property> connectorParts = new BasicEList<Property>();
		// replace delegation connectors with extension connector
		for(Port port : PortUtils.getAllPorts(tmComponent)) {
			// delegate to component via connector
			boolean match = true;
			if(extKind == InterceptionKind.INTERCEPT_ALL_IN) {
				// IN-PORT = provided port
				match = (PortUtils.getProvided(port) != null);
			} else if(extKind == InterceptionKind.INTERCEPT_ALL_OUT) {
				// IN-PORT = provided port
				match = (PortUtils.getRequired(port) != null);
			} else if(extKind == InterceptionKind.INTERCEPT_SOME) {
				// comparison based on name, since in different models
				match = (Utils.getNamedElementFromList(featureList, port.getName()) != null);
			}
			// else INTERCEPT_ALL_PORT => match remains true
			if(!match) {
				// port does not match criterion, continue with next port
				continue;
			}

			Property connectorPart;
			String interceptionName = interceptorName + port.getName() + counter;
			if(configureOnly) {
				// counter is reset before instance configuration
				connectorPart = tmContainerImpl.getAttribute(interceptionName, null);
			}
			else {
				Connector interceptionConnector = null;
				// get delegation connector
				for(Connector connector : tmContainerImpl.getOwnedConnectors()) {
					if(ConnectorUtils.connectsPort(connector, port)) {
						interceptionConnector = connector;
						break;
					}
				}
				// interceptionConnector = tmContainerImpl.getOwnedConnector
				// ("delegation " + port.getName ());
				if(interceptionConnector == null) {
					throw new TransformationException("(during interceptor transformation for container): cannot find existing delegation connector");
				}

				interceptionConnector.setName(interceptorName + port.getName() + counter);
				org.eclipse.papyrus.FCM.Connector fcmConn = StUtils.applyApp(interceptionConnector, org.eclipse.papyrus.FCM.Connector.class);
				InteractionComponent fcmConnType = StUtils.getApplication(smContainerConnImpl, InteractionComponent.class);
				fcmConn.setIc(fcmConnType);

				// pass target component and port to interceptor (not clean, define
				// suitable template signature as for instance in methodCall_comp
				Object[] args = new Object[]{ executorIS, port };
				TransformationContext.instance = executorIS;
				TransformationContext.port = port;
				connectorPart = ConnectorReification.reifyConnector(copy, tmContainerImpl, UMLTool.varName(interceptionConnector), interceptionConnector, executorIS, args);
				connectorParts.add(connectorPart);
				TransformationContext.port = null;
				// delete intermediate connector (has been replaced by two
				// connections to the reified connector)
				interceptionConnector.destroy();
			}
			// Now create an instance specification for the reified connector
			InstanceSpecification reifiedConnectorIS = DepCreation.createDepPlan(tmCDP, (Class)connectorPart.getType(),
				containerIS.getName() + "." + interceptionName, false);
			// configure connector
			context.port = port;
			InstanceConfigurator.configureInstance(reifiedConnectorIS, connectorPart, context);

			Slot partSlot = DepCreation.createSlot(containerIS, reifiedConnectorIS, connectorPart);


			ConnectorReification.propagateNodeAllocation(tmComponent, executorIS, partSlot);
		}
		counter++;
		return connectorParts;
	}

	/**
	 * Move a slot from the executor instance specification to an instance
	 * specification of an extension/interceptor This is required, since the
	 * users cannot configure containers directly. The modification is done in
	 * the target model, i.e. the user model is not affected.
	 */
	public void moveSlots() {
		Log.log(Status.INFO, Log.TRAFO_CONTAINER, "Move slots for instance: " + executorIS.getQualifiedName());
		Classifier mainCl = DepUtils.getClassifier(executorIS);
		Iterator<Slot> slotIt = executorIS.getSlots().iterator();
		while(slotIt.hasNext()) {
			Slot slot = slotIt.next();
			String featureName = slot.getDefiningFeature().getName();
			if(!mainCl.getAllAttributes().contains(slot.getDefiningFeature())) {
				// defining feature does not belong to main classifier
				// => move it to first matching instance specification
				for(InstanceSpecification is : DepUtils.getContainedInstances(containerIS)) {
					Classifier containedCl = DepUtils.getClassifier(is);
					if(Utils.getNamedElementFromList(containedCl.getAllAttributes(), featureName) != null) {
						if(executorIS != is) {
							// remove slot first from iterator, as addition below removes it from the list (slots are owned)
							slotIt.remove();
							is.getSlots().add(slot);
							break;
						}
					}
				}
			}
		}
	}

	/**
	 * Create an connector for parts that have an association. The rationale
	 * behind this is
	 * 
	 */
	public void createConnectorForAssociations() {
		// TODO: keep list of added parts, only recheck those!

		for(Property part : Utils.getParts(tmContainerImpl)) {
			if(part.getType() == null) {
				continue;
			}
			for(Association association : part.getType().getAssociations()) {
				// Part has an association. Check if the other association end
				// targets one of
				// other parts within the container
				for(Property end : association.getMemberEnds()) {
					Type type = end.getType();
					if((type != null) && (type != part.getType())) {
						// end is not typed with the part we are currently
						// examining
						// thus, it might belong to another part of the
						// composite
						for(Property checkPart : Utils.getParts(tmContainerImpl)) {
							if(type == checkPart.getType()) {
								// found an association between two parts of the
								// container => create connection,
								// unless already existing.
								if(!ConnectorUtils.existsConnector(tmContainerImpl, part, checkPart)) {
									Connector conn = tmContainerImpl.createOwnedConnector(part.getName() + "_" + checkPart.getName());
									conn.setType(association);
									conn.createEnd().setRole(part);
									conn.createEnd().setRole(checkPart);
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * The attribute within the container that holds the executor, i.e. the
	 * original component
	 */
	private Property executorPart;

	/**
	 * An instance specification of the executor in the target model (todo: should be source model instead?), i.e.
	 * of the component before container expansion
	 */
	private InstanceSpecification executorIS;

	/**
	 * The created container implementation (prefixed with tm, since part of
	 * target model)
	 */
	private Class tmContainerImpl;

	/**
	 * A counter which is used to manage unique names for interceptors (if
	 * multiple interceptors are applied)
	 */
	private int counter;
}
