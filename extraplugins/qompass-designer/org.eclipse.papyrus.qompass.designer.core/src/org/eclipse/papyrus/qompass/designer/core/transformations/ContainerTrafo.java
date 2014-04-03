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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.FCM.BindTemplate;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.FCM.ContainerRuleKind;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.FCM.InterceptionKind;
import org.eclipse.papyrus.FCM.InterceptionRule;
import org.eclipse.papyrus.FCM.Singleton;
import org.eclipse.papyrus.FCM.util.FCMUtil;
import org.eclipse.papyrus.FCM.util.MapUtil;
import org.eclipse.papyrus.qompass.designer.core.Messages;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.acceleo.UMLTool;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepCreation;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateInstantiation;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateUtils;
import org.eclipse.papyrus.uml.tools.utils.ConnectorUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Make the container transformation, i.e. add elements into a container
 *
 */
public class ContainerTrafo extends AbstractContainerTrafo {

	public static final String executorPartName = "_executor"; //$NON-NLS-1$

	public static final String interceptorName = "intercept "; //$NON-NLS-1$

	public static final String containerPostfix = "_cc"; //$NON-NLS-1$

	public static final String hwContainerPostfix = "_hwcc"; //$NON-NLS-1$

	/**
	 * Constructor
	 * 
	 * @param sat
	 *        information about source and target model
	 * @param tmCDP
	 *        deployment plan within target model
	 */
	public ContainerTrafo(LazyCopier copier, Package tmCDP, InstanceSpecification executorIS) {
		this.copier = copier;
		this.tmCDP = tmCDP;
		this.executorIS = executorIS;
		portInfo = new HashMap<Property, Port>();
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
	@Override
	public void createContainer(Class smComponent, Class tmComponent) throws TransformationException {
		Package tmPkgOwner;
		if (tmComponent.eResource() == tmCDP.eResource()) {
			// tmComponent is in same model as tmContainer
			tmPkgOwner = tmComponent.getNearestPackage();
		}
		else {
			// tmComponent is not a member of the target model. This is the case, if tmComponent is
			// in an imported model that has not been copied during the transformation towards an intermediate
			// model.
			tmPkgOwner = MapUtil.getAndCreate(Utils.getTop(tmCDP), tmComponent.allNamespaces(), true);
		}
		// create a container with the suitable postfix	
		tmContainerImpl = tmPkgOwner.createOwnedClass(tmComponent.getName() + containerPostfix, false);
		
		// Apply singleton to container, if original class is a singleton
		boolean isSingleton = StereotypeUtil.isApplied(smComponent, Singleton.class);
		if (isSingleton) {
			StereotypeUtil.apply(tmContainerImpl, Singleton.class);
		}
		LazyCopier.copyID(tmComponent, tmContainerImpl, containerPostfix);

		// add part and slot corresponding to component;
		executorPart = tmContainerImpl.createOwnedAttribute(executorPartName, tmComponent);
		LazyCopier.copyID(tmComponent, executorPart, "e"); //$NON-NLS-1$

		executorPart.setIsComposite(true);

		// copy ports from the executor (tmComponent) to the container
		// (tmContainerImpl)
		// TODO: connectors still point to the ports of the executor, implying a non-well-formed
		//   model. Yet code generation works, as port names are identical
		for(Port port : PortUtils.getAllPorts(tmComponent)) {
			// copy port
			if (port.getVisibility() == VisibilityKind.PUBLIC_LITERAL) { 
				Port newPort = EcoreUtil.copy(port); // don't use Qompass copy, since this is not a copy from source to target model
				tmContainerImpl.getOwnedAttributes().add(newPort);
				StUtils.copyStereotypes(port, newPort);

				// create delegation for application port
				Connector containerDelegation = tmContainerImpl.createOwnedConnector("delegation " + port.getName()); //$NON-NLS-1$
				LazyCopier.copyID(tmContainerImpl, containerDelegation);
				ConnectorEnd end1 = containerDelegation.createEnd();
				end1.setRole(newPort);
				ConnectorEnd end2 = containerDelegation.createEnd();
				end2.setPartWithPort(executorPart);
				end2.setRole(port);
			}
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
		tmContainerImpl = tmPkgOwner.createOwnedClass(tmComponent.getName() + hwContainerPostfix, false);
		LazyCopier.copyID(tmComponent, tmContainerImpl, hwContainerPostfix);

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
	@Override
	public InstanceSpecification createContainerInstance(Class tmComponent, InstanceSpecification tmIS) throws TransformationException {
		// create an instance specification for the container
		InstanceSpecification containerIS =
				(InstanceSpecification)tmCDP.createPackagedElement(tmIS.getName(), UMLPackage.eINSTANCE.getInstanceSpecification());
		// assign new name to original instance specification which reflects
		// role within containment hierarchy
		tmIS.setName(tmIS.getName() + "." + executorPartName); //$NON-NLS-1$
		containerIS.getClassifiers().add(tmContainerImpl);
		// existing instance specification (tmIS) is the executor instance specification
		DepCreation.createSlot(containerIS, tmIS, executorPart);
		counter = 0;
		// containers.put(tmComponent, this);
		EList<Slot> connectorSlots = new BasicEList<Slot>();
		
		executorIS = tmIS;
		// now create instances for the contained elements
		for(Property extensionPart : tmContainerImpl.getAttributes()) {
			Type tmContainerExtImpl = extensionPart.getType();
			if(tmContainerExtImpl instanceof Class) {
				if (DepUtils.getSlot(containerIS, extensionPart) == null) {
					// no slot for part exists => assume that the part has been added by the container and create an instance specification for it.
					InstanceSpecification containerExtIS = null;
					
					String isName = containerIS.getName() + "." + extensionPart.getName(); //$NON-NLS-1$
			
					// create sub-instance and slot for extensions
					if (containerExtIS == null) {
						containerExtIS = DepCreation.createDepPlan(tmCDP, (Class)tmContainerExtImpl, isName, false);
					}
					Slot partSlot = DepCreation.createSlot(containerIS, containerExtIS, extensionPart);
					if (StereotypeUtil.isApplied(tmContainerExtImpl, InteractionComponent.class)) {
						connectorSlots.add(partSlot);
					}
				}
			}
		}
	
		// handle propagation of node allocation for connectors. Do that in 2nd loop, since the allocation
		// of parts might be incomplete before.
		for(Slot connectorSlot : connectorSlots) {
			ConnectorReification.propagateNodeAllocation(tmContainerImpl, containerIS, connectorSlot);
		}
		moveSlots(executorIS);
		return containerIS;
	}

	/**
	 * Create an instance of the container (UML instance specification)
	 * 
	 * @param tmComponent
	 * @param tmIS
	 */
	public InstanceSpecification createHwContainerInstance(Class tmComponent, InstanceSpecification tmNode) {
		// create an instance specification for the container
		InstanceSpecification containerIS =
				(InstanceSpecification)tmCDP.createPackagedElement(tmNode.getName() + hwContainerPostfix, UMLPackage.eINSTANCE.getInstanceSpecification());
		// assign new name to original instance specification which reflects
		// role within containment hierarchy
		containerIS.getClassifiers().add(tmContainerImpl);
		// containers.put(tmComponent, this);
		counter = 0;
		executorIS = tmNode;
		// copy slots from HW instance specification
		for (Slot slot : tmNode.getSlots()) {
			Slot slotCopy = containerIS.createSlot();
			slotCopy.setDefiningFeature(slot.getDefiningFeature());
			// copy values (use CopyTo.copyTo(slot, containerIS) instead?)
			for (ValueSpecification value : slot.getValues()) {
				LazyCopier.copyValue(value, slotCopy);
			}
		}
		return containerIS;
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
	@Override
	public void applyRule(ContainerRule smContainerRule, Class smComponent, Class tmComponent)
		throws TransformationException
	{
		Map<Property, EList<Property>> interceptorPartsMap = new HashMap<Property, EList<Property>>();

		for(Property part : smContainerRule.getBase_Class().getAllAttributes()) {
			Type type = part.getType();
			if(type == null) {
				String ruleName = (smContainerRule.getBase_Class() != null) ? smContainerRule.getBase_Class().getName() : "undefined"; //$NON-NLS-1$
				throw new TransformationException(String.format(
					Messages.ContainerTrafo_CannotApplyRule, ruleName));
			}
			if(part instanceof Port) {
				Port newPort = tmContainerImpl.createOwnedPort(part.getName(), part.getType());
				StUtils.copyStereotypes(part, newPort);
			}
			else if(type instanceof Class) {
				Class extOrInterceptor = (Class)type;
				// DepUtils.chooseImplementation((Class) type,
				// new BasicEList<InstanceSpecification>(), false);

				if(StereotypeUtil.isApplied(part, InterceptionRule.class)) {
					if(StereotypeUtil.isApplied(extOrInterceptor, InteractionComponent.class)) {

						InterceptionRule interceptionRule = UMLUtil.getStereotypeApplication(part, InterceptionRule.class);
						InterceptionKind interceptionKind = interceptionRule.getInterceptionKind();
						EList<Feature> interceptFeatures = interceptionRule.getInterceptionSet();
						EList<Property> interceptorParts =
						expandInterceptorExtension(interceptionKind, interceptFeatures, extOrInterceptor, tmComponent);
						interceptorPartsMap.put(part, interceptorParts);
					}
					else {
						throw new TransformationException(String.format(
							Messages.ContainerTrafo_InterceptionRuleButNoInterceptor,
							part.getName(), smContainerRule.getBase_Class().getName()));
					}
				}
				else {
					Property extensionPart =
						expandAggregationExtension(part, extOrInterceptor, tmComponent);
					// register relation to facilitate connector copy
					copier.setPackageTemplate(smContainerRule.getBase_Class(), tmContainerImpl);
					copier.putPair(part, extensionPart);
					copier.setPackageTemplate(null, null);
				}
			}
		}
		createConnectorForAssociations();

		// tell copier that tmcontainerImpl is associated with the smContainerRule
		// register a package template (although it is not a template) to assure that the connectors
		// get copied, although they are in a different resource (only the connectors are copied, not
		// the types of the referenced parts).
		// [main issue here: properties of container rule are not copies in the sense of identical
		// copies]
		copier.setPackageTemplate(smContainerRule.getBase_Class(), tmContainerImpl);

		for(Connector connector : smContainerRule.getBase_Class().getOwnedConnectors()) {
			Property ruleInterceptorPart = null;
			for(Property part : interceptorPartsMap.keySet()) {
				if(ConnectorUtil.connectsPart(connector, part)) {
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
					copier.putPair(ruleInterceptorPart, interceptorPart);
					copier.removeForCopy(connector);
					copier.getCopy(connector);
				}
			}
			else {
				// check whether FCM connector
				org.eclipse.papyrus.FCM.Connector fcmConn = StUtils.getConnector(connector);
				if(fcmConn != null) {
					ConnectorReification.reifyConnector(copier, tmContainerImpl,
						UMLTool.varName(connector), connector, executorIS, null);
				}
				else {
					copier.remove(connector);
					copier.getCopy(connector);
				}
			}
		}
		copier.setPackageTemplate(null, null);
		
		TemplateUtils.retargetConnectors(tmContainerImpl);
	}

	/**
	 * This container expansion does not create a new composite. Instead, it
	 * adds the extension as a part to the copied application component. The
	 * application component also inherits from the type of the container
	 * extension in order to avoid copying ports.
	 */
	Property expandAggregationExtension(Property smExtensionPart, Class smContainerExtImpl, Class tmComponent) throws TransformationException {
		Property extensionPart;
		String name = smExtensionPart.getName();
		Class tmContainerExtImpl = null;
		
		TemplateSignature signature = TemplateUtils.getSignature(smContainerExtImpl);
		if(signature == null) {
			// no template signature, just copy the container extension into the target model
			tmContainerExtImpl = copier.getCopy(smContainerExtImpl);
		}
		else {
			// template signature found, instantiate container extension via template binding mechanism
			Classifier actual;
			if (StereotypeUtil.isApplied(smExtensionPart, BindTemplate.class)) {
				BindTemplate bt = UMLUtil.getStereotypeApplication(smExtensionPart, BindTemplate.class);
				// use explicit binding from stereotype
				actual = (Classifier) bt.getActual().get(0);
			}
			else {
				// use executor component as actual
				actual = tmComponent;
			}
			// template signature and instantiate container extension via the
			// template binding mechanism, use executor component as actual
			TemplateBinding binding = TemplateUtils.fixedBinding(copier.target, smContainerExtImpl, actual);
			Object[] args = new Object[]{};
			TemplateInstantiation ti = new TemplateInstantiation(copier, binding, args);
			tmContainerExtImpl = (Class)ti.bindNamedElement(smContainerExtImpl);
		}

		// --------------------------------------------------
		// a container extension could be subject to container rules as well, i.e. need
		// to handle recursive rule application.
		EList<ContainerRule> rules = FCMUtil.getAllContainerRules(smContainerExtImpl);

		// get container trafo instance, if already existing
		AbstractContainerTrafo containerTrafo = ContainerTrafo.get(tmContainerExtImpl);

		if(containerTrafo == null) {
			// no container exists, check rules and create eventually
			for(ContainerRule rule : rules) {
				if(RuleManagement.isRuleActive(rule)) {
					// at least one active rule => create container (or get previously instantiated))
					if(containerTrafo == null) {
						if(rule.getKind() == ContainerRuleKind.LIGHT_WEIGHT_OO_RULE) {
							throw new TransformationException(Messages.ContainerTrafo_RecursiveLWnotSupported);
						}
						else {
							containerTrafo = new ContainerTrafo(copier, tmCDP, null);
						}
						containerTrafo.createContainer(smContainerExtImpl, tmContainerExtImpl);
					}
					else {
						// configure only??
					}
					containerTrafo.applyRule(rule, smContainerExtImpl, tmContainerExtImpl);
				}
			}
			if (containerTrafo != null) {
				containerTrafo.finalize();
				tmContainerExtImpl = ((ContainerTrafo) containerTrafo).getContainer();
			}
		}
		// --------------------------------------------------
		
		// add part associated with the extension to the container
		extensionPart = tmContainerImpl.createOwnedAttribute(name, tmContainerExtImpl);

		// Copy.copyID(tmComponent, extensionPart, "a");
		extensionPart.setAggregation(smExtensionPart.getAggregation());
		LazyCopier.copyMultElemModifiers(smExtensionPart, extensionPart);
		LazyCopier.copyFeatureModifiers(smExtensionPart, extensionPart);
	
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
			}
			else if(extKind == InterceptionKind.INTERCEPT_ALL_OUT) {
				// IN-PORT = provided port
				match = (PortUtils.getRequired(port) != null);
			}
			else if(extKind == InterceptionKind.INTERCEPT_SOME) {
				// comparison based on name, since in different models
				match = (Utils.getNamedElementFromList(featureList, port.getName()) != null);
			}
			else if(extKind == InterceptionKind.INTERCEPT_MATCHING) {
				EList<Port> interceptorPorts = PortUtils.getAllPorts(smContainerConnImpl);
				match = false;
				// get first port from interception connector that is typed with a template parameter
				for (Port interceptorPort : interceptorPorts) {
					if (interceptorPort.getType().getOwner() instanceof TemplateParameter) {
						match = (PortUtils.getKind(port) == PortUtils.getKind(interceptorPort));
						break;
					}
				}
			}		
			
			// else INTERCEPT_ALL_PORT => match remains true
			if(!match) {
				// port does not match criterion, continue with next port
				continue;
			}

			Property connectorPart;
			String interceptionName = interceptorName + port.getName() + counter;
			Connector interceptionConnector = null;
			// get delegation connector
			for(Connector connector : tmContainerImpl.getOwnedConnectors()) {
				if(ConnectorUtil.connectsPort(connector, port)) {
					interceptionConnector = connector;
					break;
				}
			}
			// interceptionConnector = tmContainerImpl.getOwnedConnector
			// ("delegation " + port.getName ());
			if(interceptionConnector == null) {
				throw new TransformationException(Messages.ContainerTrafo_CannotFindDelegationConn);
			}

			interceptionConnector.setName(interceptionName);
			org.eclipse.papyrus.FCM.Connector fcmConn = StereotypeUtil.applyApp(interceptionConnector, org.eclipse.papyrus.FCM.Connector.class);
			InteractionComponent fcmConnType = UMLUtil.getStereotypeApplication(smContainerConnImpl, InteractionComponent.class);
			fcmConn.setIc(fcmConnType);

			// pass target component and port to interceptor (not clean, define
			// suitable template signature as for instance in methodCall_comp
			Object[] args = new Object[]{ executorIS, port };
			TransformationContext.instance = executorIS;
			TransformationContext.port = port;
			connectorPart = ConnectorReification.reifyConnector(copier, tmContainerImpl, UMLTool.varName(interceptionConnector), interceptionConnector, executorIS, args);
			connectorParts.add(connectorPart);
			TransformationContext.port = null;
			portInfo.put(connectorPart, port);
			// delete intermediate connector (has been replaced by two
			// connections to the reified connector)
			interceptionConnector.destroy();
		}
		counter++;
		return connectorParts;
	}

	/**
	 * Move a slot from the executor instance specification to an instance
	 * specification of an extension/interceptor. This is required, since
	 * users cannot configure containers directly. The modification is done in
	 * the target model, i.e. the user model is not affected.
	 * 
	 * Configuration is based on the idea that we can have multiple classifiers for an
	 * instance specification and that we add additional slots for attributes of the 2nd
	 * classifier which becomes "visible" after container transformation.
	 * Main use: configure priority of thread within container.
	 * 
	 * TODO: Not clear, whether we should keep this operation, since configuration of elements that are not
	 * (directly) part of the user model is confusing. Application was: configuration
	 * of thread priorities within container.
	 */
	public void moveSlots(InstanceSpecification containerIS) {
		// Log.log(Status.INFO, Log.TRAFO_CONTAINER, String.format(Messages.ContainerTrafo_InfoMoveSlots, executorIS.getQualifiedName()));
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
	 * behind this is support connections between the state machine in the container
	 * and the executor.
	 * 
	 */
	public void createConnectorForAssociations() {
		// TODO: keep list of added parts, only re-check those!

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
								if(!ConnectorUtil.existsConnector(tmContainerImpl, part, checkPart)) {
									Connector conn = tmContainerImpl.createOwnedConnector(part.getName() + "_" + checkPart.getName()); //$NON-NLS-1$
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

	@Override
	public void finalize() {
		discoverServices();
	}
	
	/**
	 * Connector ports of executor with compatible ports offered by container extensions
	 * (runtime system)
	 */
	public void discoverServices() {
		Type executorType = executorPart.getType();
		if (!(executorType instanceof EncapsulatedClassifier)) {
			return;
		}
		EncapsulatedClassifier ec = (EncapsulatedClassifier) executorType;
		for (Port executorPort : ec.getOwnedPorts()) {
			for (Property svcPart : tmContainerImpl.getOwnedAttributes()) {
				if (svcPart == executorPart) {
					continue;
				}
				Type containerSvcType = svcPart.getType();
				if (containerSvcType instanceof EncapsulatedClassifier) {
					EncapsulatedClassifier containerSvc = (EncapsulatedClassifier) containerSvcType;
					for (Port svcPort : containerSvc.getOwnedPorts()) {
						if (PortUtils.matches(executorPort, svcPort, true)) {
							// create connector
							Connector c = tmContainerImpl.createOwnedConnector(
								String.format("auto from %s to %s", executorPart.getName(), svcPart.getName())); //$NON-NLS-1$
							ConnectorEnd ce1 = c.createEnd();
							ConnectorEnd ce2 = c.createEnd();
							ce1.setPartWithPort(executorPart);
							ce1.setRole(executorPort);
							ce2.setPartWithPort(svcPart);
							ce2.setRole(svcPort);
						}
					}
				}
			}
		}
	}

	/**
	 * Return the containerTrafo associated with a container. This operation is useful for instance
	 * configurators that need more information about the container context, in particular to associate
	 * a part with a port that is intercepted.
	 *  
	 * @param containerInstance the container instance (the parent instance of an instance of a container extension)ight be a container instance)
	 * @return the containerTrafo info, if found.
	 */
	public static ContainerTrafo getContainerTrafo(InstanceSpecification containerInstance) {
		Classifier containerCandidate = DepUtils.getClassifier(containerInstance);
		Property executorPart = containerCandidate.getAttribute(executorPartName, null);
		if ((executorPart != null) && executorPart.getType() instanceof Class) {
			AbstractContainerTrafo containerTrafo = ContainerTrafo.get((Class) executorPart.getType());
			if (containerTrafo instanceof ContainerTrafo) {
				return (ContainerTrafo) containerTrafo;
			}
		}
		return null;
	}
	
	/**
	 * Return the port that is intercepted when given a part
	 * @param containerPart a part that participates in a port interception
	 * @return intercepted port
	 */
	public Port getInterceptedPort(Property containerPart) {
		return portInfo.get(containerPart);
	}
	
	/**
	 * The attribute within the container that holds the executor, i.e. the
	 * original component
	 */
	protected Property executorPart;

	/**
	 * An instance specification of the executor in the target model (todo: should be source model instead?), i.e.
	 * of the component before container expansion
	 */
	protected InstanceSpecification executorIS;

	/**
	 * The created container implementation (prefixed with tm, since part of
	 * target model)
	 */
	protected Class tmContainerImpl;

	/**
	 * A counter which is used to manage unique names for interceptors (if
	 * multiple interceptors are applied)
	 */
	protected int counter;
	
	/**
	 * Store information about intercepted port. The map contains a mapping from the part representing
	 * a reified connector to the port that was intercepted. It is stored, since it might be used by instance
	 * configurators that configure the container instance.
	 */
	protected Map<Property, Port> portInfo;
}
