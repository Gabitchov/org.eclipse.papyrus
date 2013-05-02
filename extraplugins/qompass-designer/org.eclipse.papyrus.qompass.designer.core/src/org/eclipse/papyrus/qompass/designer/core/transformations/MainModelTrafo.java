package org.eclipse.papyrus.qompass.designer.core.transformations;

/**
 * This file is part of Qompass GenTools
 * Copyright (C) 2008 CEA LIST (http://www-list.cea.fr/)

 * initial developer : Christophe JOUVRAY from CEA LIST 
 * Major contributions: Ansgar Radermacher from CEA LIST
 */

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.papyrus.FCM.ConfigOption;
import org.eclipse.papyrus.FCM.Configuration;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.FCM.ContainerRuleKind;
import org.eclipse.papyrus.FCM.DeploymentPlan;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.FCM.util.FCMUtil;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.acceleo.UMLTool;
import org.eclipse.papyrus.qompass.designer.core.deployment.AllocUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepCreation;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepPlanUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.extensions.InstanceConfigurator;

/**
 * This class provides model information around connectors ... Many classes are
 * currently commented, since it is not clear if we really need these
 */
public class MainModelTrafo {

	private static Configuration m_config;

	public static void setConfiguration(Configuration config) {
		m_config = config;
		nodeHandled = new HashMap<InstanceSpecification, Boolean>();
	}

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
	public static InstanceSpecification getInstanceForPart(
		InstanceSpecification system, Property part) {
		for(Slot slot : system.getSlots()) {
			if(slot.getDefiningFeature() == part) {
				for(ValueSpecification value : slot.getValues()) {
					// instances are accessible via ValueSpecification subclass
					// InstanceValue
					if(value instanceof InstanceValue) {
						return (((InstanceValue)value).getInstance());
					}
				}
			}
		}
		return null;
	}

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
		// try to find match via kind
		for(Port port : ports) {
			if(PortUtils.matches(port, otherPort, isAssembly)) {
				return port;
			}
		}
		// no match found, try weaker condition: find 1st match for provided ...
		boolean otherEndProvides = PortUtils.getProvided(otherPort) != null;
		for(Port port : ports) {
			Interface intf;
			// if isAssembly: take "opposite" port
			if(otherEndProvides != isAssembly) {
				intf = PortUtils.getProvided(port);
			} else {
				intf = PortUtils.getRequired(port);
			}
			if(intf != null) {
				return port;
			}
		}
		return null;
	}

	/**
	 * check whether a rule is active in a given configuration
	 * 
	 * @param aRule
	 * @return
	 */
	private static boolean isRuleActive(ContainerRule rule) {
		if(m_config != null) {
			for(ConfigOption option : m_config.getConfigOptions()) {
				if(rule.getForConfig().contains(option)) {
					return true;
				}
			}
		}
		// not already true via specific configuration.
		// => Also turn on rules by default that are not for a specific configuration option
		return (rule.getForConfig().size() == 0);
	}

	/**
	 * This method performs a model transformation that replaces an Qompass
	 * connector by a property and a set of simple connectors. The type of the
	 * newly added connector must be instantiated from its template definition
	 * in order to adapt the connector to its context. This is done in a
	 * recursive manner on a compositeInstance. The result is a (composite)
	 * class which has the added connector. The function will also trigger
	 * container expansion, if necessary. Please note that we use the naming
	 * convention to prefix elements of the source model (wrt. to the
	 * transformation) with sm and elements of the target model with tm.
	 * 
	 * @param copy
	 *        Copier
	 * @param tmCDP
	 *        deployment plan in target model
	 * @param smIS
	 *        source model instance specification
	 * @param smDF
	 *        source model defining feature (null for top-level instance).
	 * @param inheritedRules
	 *        container rules inherited from containing composite
	 * @return new instance specification in traget model
	 * 
	 * @throws TransformationException
	 */
	public static InstanceSpecification mainModelTrafo(Copy copy, Package tmCDP,
		InstanceSpecification smIS, StructuralFeature smDF) throws TransformationException {
		Class smComponent = null;
		Classifier smCl = DepUtils.getClassifier(smIS);
		if(smCl instanceof Class) {
			smComponent = (Class)smCl;
		} else {
			// should not happen
			return null;
		}

		String instName = smIS.getName();
		InstanceSpecification tmIS = (InstanceSpecification)
			tmCDP.createPackagedElement(instName, UMLPackage.eINSTANCE.getInstanceSpecification());

		Class tmComponent = copy.getCopy(smComponent);
		if(tmComponent == null) {
			return null;
		}
		tmIS.getClassifiers().add(tmComponent);

		// retrieve the component type object from the static profile (in order
		// to process rules)
		EList<ContainerRule> rules = FCMUtil.getAllContainerRules(smComponent);

		// get container trafo instance, if already existing
		AbstractContainerTrafo containerTrafo = ContainerTrafo.get(tmComponent);

		// general idea: an instance of class ContainerTafo is responsible for a specific component.
		// the method createContainerInstance must be called for each instance of the application component
		// (caveat: don't mix-up with instance of Java classes of the development tool)
		// TODO: since we support multiple container kinds, we need to keep their container map separate!
		if(containerTrafo != null) {
			// create instance, if container exists already (if a container exists, all instances are
			// instances of the container
			containerTrafo.configureOnly();
			containerTrafo.createContainerInstance(tmComponent, tmIS, new ContainerContext(smDF, null));
		}
		else {
			// process container rules
			for(ContainerRule rule : rules) {
				if(isRuleActive(rule)) {
					// at least one active rule => create container (or get previously instantiated))
					if(containerTrafo == null) {
						if(rule.getKind() == ContainerRuleKind.LIGHT_WEIGHT_OO_RULE) {
							containerTrafo = new LWContainerTrafo(copy, tmCDP);
						}
						else {
							containerTrafo = new ContainerTrafo(copy, tmCDP);
						}
						// create container instance once for all rules (that use same container kind)
						containerTrafo.createContainer(smComponent, tmComponent);
						containerTrafo.createContainerInstance(tmComponent, tmIS, new ContainerContext(smDF, null));
					}
					else {
						// configure only??
					}
					containerTrafo.applyRule(rule, smComponent, tmComponent, tmIS);
				}
				// TODO(?) check if rule has already been applied (don't mix-up instances/classes)
			}
		}
		// copy node allocation
		for(InstanceSpecification smNode : AllocUtils.getNodes(smIS)) {
			InstanceSpecification tmNode = copy.getCopy(smNode);
			AllocUtils.allocate(tmIS, tmNode);

			if(!nodeHandled.containsKey(tmNode)) {
				nodeHandled.put(tmNode, true);

				// check, whether a container rule is applied on the tmNode
				Classifier tmCS = DepUtils.getClassifier(tmNode);
				if(tmCS instanceof Class) {
					// ---------------------------
					EList<ContainerRule> hwRules = FCMUtil.getAllContainerRules(tmCS);

					if(hwRules.size() > 0) {

						AbstractContainerTrafo abstractNodeContainerTrafo = ContainerTrafo.get((Class)tmCS);
						if(abstractNodeContainerTrafo instanceof ContainerTrafo) {

							ContainerTrafo nodeContainerTrafo = (ContainerTrafo)abstractNodeContainerTrafo;
							// make copy of inheritedRule list (avoid that added elements remain in single rule list passed to all)

							// issues
							//   - unlike SW component container, don't update references pointing towards the HW node 
							//   - create additional part in system (top-level) component for the node container
							//   - container (_cc class) appears in platform component (same package as HW node)
							//	 - port copying and creation of delegation connectors does not make much sense, creation of
							//	   executor itself does not make much sense, additional operation "createHwContainer"

							// obtain property related to node instance
							Slot smNodeSlot = DepUtils.getParentSlot(smNode);
							ContainerContext context = new ContainerContext(smDF, smNodeSlot != null ? smNodeSlot.getDefiningFeature() : null);

							if(nodeContainerTrafo != null) {
								// only create instance, if container exists already
								nodeContainerTrafo.configureOnly();
								nodeContainerTrafo.createHwContainerInstance(tmComponent, tmNode, context);
							}

							Package smCDP = smIS.getNearestPackage();
							DeploymentPlan smFCM_CDP = StUtils.getApplication(smCDP, DeploymentPlan.class);

							for(ContainerRule rule : hwRules) {
								if(isRuleActive(rule)) {
									if(nodeContainerTrafo == null) {
										// at least one active rule => create container (or get previously instantiated))
										nodeContainerTrafo = new ContainerTrafo(copy, tmCDP);
										nodeContainerTrafo.createHwContainer((Class)tmCS);
										nodeContainerTrafo.createHwContainerInstance(tmComponent, tmNode, context);
									}
									nodeContainerTrafo.applyRule(rule, smComponent, tmComponent, tmIS);

									// now add attribute in system (obtain via classifier of main instance in smCDP)
									if(smFCM_CDP != null) {
										InstanceSpecification smMI = smFCM_CDP.getMainInstance();
										Classifier smSystem = DepUtils.getClassifier(smMI);
										Classifier tmSystem = copy.getCopy(smSystem);
										InstanceSpecification tmMI = DepUtils.getInstanceForClassifier(tmCDP, tmSystem);
										if(tmSystem instanceof Class) {
											Property hwcPart =
												((Class)tmSystem).createOwnedAttribute(smNode.getName() + "Hwc", nodeContainerTrafo.getContainer());
											// and now create a slot for the created instance.
											DepPlanUtils.createSlot(tmCDP, tmMI, nodeContainerTrafo.getContainerIS(), hwcPart);
										}
									}

									// now allocate instance
									AllocUtils.allocate(nodeContainerTrafo.getContainerIS(), tmNode);
								}
							}
						}
					}
				}
			}
		} // ------------------- handling of HW nodes


		// reread instName (may have been changed by container transformation).
		instName = tmIS.getName();

		// copy parts, i.e. referenced slots
		// loop on instances (instead of parts), since reification needs to be
		// based on used implementations.
		for(Slot slot : smIS.getSlots()) {
			if(slot.getDefiningFeature() == null) {
				throw new TransformationException(
					"Error: no defining feature associated with \""
						+ smIS.getName() + "\"");
			}
			StructuralFeature smPartDF = slot.getDefiningFeature();
			if(StUtils.isApplied(smPartDF.getType(), InteractionComponent.class)) {
				if(smPartDF instanceof Property) {
					Property tmPart = ConnectorReification.reifyConnector(copy, tmComponent, (Property)smPartDF, tmIS, null);
					// update value specification (to the one just created)
					Type type = tmPart.getType();
					InstanceSpecification tmPartIS = EcoreUtil.copy(DepUtils.getInstance(slot));
					tmCDP.getPackagedElements().add(tmPartIS);
					if(type instanceof Classifier) {
						if(tmPartIS.getClassifiers().size() > 0) {
							tmPartIS.getClassifiers().set(0, (Classifier)type);
						}
					}
					DepCreation.createSlot(tmIS, tmPartIS, tmPart);
				}
			}
			else if(smPartDF.getType() instanceof Class) {

				InstanceSpecification smPartIS = DepUtils.getInstance(slot);
				if(smPartIS == null) {
					throw new TransformationException(
						"Error: no instance is associated with slot for feature \""
							+ smPartDF.getName() + "\"");
				}

				// recursive reification
				// returned instance specification in target model is an instance specification for the part
				// or for a container for that part.
				InstanceSpecification tmPartIS = mainModelTrafo(copy, tmCDP, smPartIS, smPartDF);
				// AllocUtils.propagateNodesViaPort (tmPartIS, null, AllocUtils.getNodes(containedInstance));

				// retrieve part in the target model (it has been created during
				// the copyClassifier operation before)
				// TODO: avoid cast (use StructuralFeature instead)
				Property tmPart = (Property)copy.getCopy(smPartDF);

				// check whether the instance specification has been modified
				// (due to a container transformation)
				// modification would not be required, if 
				if((tmPartIS != null) && (DepUtils.getClassifier(tmPartIS) != tmPart.getType())) {
					Log.log(Log.INFO_MSG, Log.TRAFO_CONNECTOR, "change type of part " + tmPart.getName() +
						" due to container trafo");
					tmPart.setType(DepUtils.getClassifier(tmPartIS));
				}
				DepCreation.createSlot(tmIS, tmPartIS, tmPart);
			} else {
				// assume primitive type, copy slot values
				// don't use "copy" to avoid duplicate entries (since not all instance specification created
				// before are correctly inserted into the map of "copy").
				Slot tmSlot = EcoreUtil.copy(slot);
				tmSlot.setDefiningFeature(copy.getCopy(slot.getDefiningFeature()));
				tmIS.getSlots().add(tmSlot);
			}

		}

		// loop on connectors
		// TODO: check, if true (no instance specification exists for these - unlike a connector which is explicitly specified via a part)
		for(Connector smConnector : smComponent.getOwnedConnectors()) {
			if(StUtils.isConnector(smConnector)) {
				org.eclipse.papyrus.FCM.Connector fcmConn = StUtils.getConnector(smConnector);
				if(fcmConn != null) {
					// found an Qompass connector, connector type is specified.
					// => Reify the connector within the target component, i.e. create a new part and
					//    additional connections for it.
					Property connectorPart = ConnectorReification.reifyConnector(copy, tmComponent,
						UMLTool.varName(smConnector), smConnector, tmIS, null);

					if(connectorPart == null) {
						continue;
					}

					// remove simple connector from composite in target model
					Connector tmConnector = copy.getCopy(smConnector);
					tmConnector.destroy();

					// Now create an instance specification for the reified connector
					InstanceSpecification tmReifiedConnectorIS = DepCreation.createDepPlan(
						tmCDP, (Class)connectorPart.getType(),
						instName + "." + smConnector.getName(), false);

					// copy slots from the source deployment plan that are related to connector configuration
					InstanceSpecification smConnectorIS = DepUtils.getNamedSubInstance(smIS, smConnector.getName());
					if(smConnectorIS != null) {
						copy.put(smConnectorIS, tmReifiedConnectorIS);
						for(Slot smSlot : smConnectorIS.getSlots()) {
							copy.getCopy(smSlot);
						}
						/*
						 * InstanceSpecification tmConnectorIS = copy.getCopy(smConnectorIS);
						 * Iterator<Slot> tmSlotIter = tmConnectorIS.getSlots().iterator();
						 * while(tmSlotIter.hasNext()) {
						 * Slot tmSlot = tmSlotIter.next();
						 * tmReifiedConnectorIS.getSlots().add(hhtmSlot);
						 * }
						 * tmConnectorIS.getSlots().clear();
						 */
					}

					// configure connector
					InstanceConfigurator.configureInstance(tmReifiedConnectorIS, connectorPart, null);

					Slot partSlot =
						DepCreation.createSlot(tmIS, tmReifiedConnectorIS, connectorPart);

					ConnectorReification.propagateNodeAllocation(tmComponent, tmIS, partSlot);
				}
			}
		}
		/*
		 * for(Property part : smComponent.getOwnedAttributes()) {
		 * Type type = part.getType();
		 * if(type != null) {
		 * if(StUtils.isApplied(type, InteractionComponent.class)) {
		 * ConnectorReification.reifyConnector(copy, tmComponent, part, tmIS, null);
		 * }
		 * }
		 * }
		 */

		// needs to be called independently
		// propagateNodeAllocation (cdp, compositeInstance);

		if(containerTrafo != null) {
			// return containerIS
			containerTrafo.moveSlots();
			return containerTrafo.getContainerIS();
		} else {
			return tmIS;
		}
	}

	protected static Map<InstanceSpecification, Boolean> nodeHandled;
}
