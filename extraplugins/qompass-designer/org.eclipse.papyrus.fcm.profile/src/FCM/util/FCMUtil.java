package FCM.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;

import FCM.Connector;
import FCM.ContainerRule;
import FCM.InteractionComponent;
import FCM.RuleApplication;


public class FCMUtil {

	/**
	 * @param specification
	 * @param configPropertyName
	 * @return
	 */
	public static EList<ValueSpecification> getConfigurationValue(InstanceSpecification specification, String configPropertyName) {
		if(specification != null) {
			for(Iterator<Slot> i = specification.getSlots().iterator(); i.hasNext();) {
				Slot currentSlot = i.next();
				if(currentSlot.getDefiningFeature() != null &&
					currentSlot.getDefiningFeature().getName().equals(configPropertyName))
					return currentSlot.getValues();
			}
		}
		return null;
	}

	/**
	 * @param interfaces
	 * @param interfaceName
	 * @return
	 */
	public static Interface findInterfaceByName(EList<Interface> interfaces, String interfaceName) {
		for(Iterator<Interface> i = interfaces.iterator(); i.hasNext();) {
			Interface currentInterface = i.next();
			if(currentInterface.getName().equals(interfaceName))
				return currentInterface;
		}
		return null;
	}

	/**
	 * A data structure to be used for the specification of how the roles of the collaboration associated with
	 * the type of param "connector" are bound to actual elements of the composite containing param "connector".
	 * This data structure contains an hashmap<ConnectableElement, List<Element>>:
	 * - keys must be roles of a Collaboration
	 * - values must be list of elements playing this role in the context of a particular composite
	 * 
	 * @author ac221913
	 * 
	 */
	public static final class RoleBindingTable {

		private HashMap<org.eclipse.uml2.uml.ConnectableElement, List<org.eclipse.uml2.uml.NamedElement>> table;

		public RoleBindingTable() {
			this.table = new HashMap<org.eclipse.uml2.uml.ConnectableElement,
				List<org.eclipse.uml2.uml.NamedElement>>();
		}

		public void addEntry(org.eclipse.uml2.uml.ConnectableElement role,
			List<org.eclipse.uml2.uml.NamedElement> playedBy) {
			table.put(role, playedBy);
		}

		public List<org.eclipse.uml2.uml.NamedElement> getEntry(org.eclipse.uml2.uml.ConnectableElement role) {
			return table.get(role);
		}

		public Iterator<org.eclipse.uml2.uml.ConnectableElement> iterator() {
			return table.keySet().iterator();
		}

		public HashMap<org.eclipse.uml2.uml.ConnectableElement, List<org.eclipse.uml2.uml.NamedElement>> getTable() {
			return table;
		}

		public ConnectableElement getRoleKeyByName(String roleName) {
			for(ConnectableElement role : table.keySet()) {
				if(role.getName().equals(roleName)) {
					return role;
				}
			}
			return null;
		}
	}

	public static void generateDefaultConnectionPattern(InteractionComponent connectorComp) {
		org.eclipse.uml2.uml.Collaboration connectionPattern =
			UMLFactory.eINSTANCE.createCollaboration();

		//((org.eclipse.uml2.uml.Package)connectorComp.getBase_Class().getOwner()).getPackagedElements().add(connectionPattern) ;
		connectorComp.getBase_Class().getNestedClassifiers().add(connectionPattern);
		connectionPattern.setName(connectorComp.getBase_Class().getName() + "ConnectionPattern");

		org.eclipse.uml2.uml.Property connectorRole =
			connectionPattern.createOwnedAttribute("connector", connectorComp.getBase_Class(), 1, 1);
		for(Iterator<org.eclipse.uml2.uml.Port> i = connectorComp.getBase_Class().getOwnedPorts().iterator(); i.hasNext();) {
			org.eclipse.uml2.uml.Port port = i.next();
			org.eclipse.uml2.uml.Property role;
			org.eclipse.uml2.uml.Connector connector;
			role = connectionPattern.createOwnedAttribute(port.getName(), null);
			connector = connectionPattern.createOwnedConnector("");
			org.eclipse.uml2.uml.ConnectorEnd source, target;
			source = connector.createEnd();
			source.setRole(port);
			source.setPartWithPort(connectorRole);
			target = connector.createEnd();
			target.setRole(role);
		}

		connectorComp.setConnectionPattern(connectionPattern);
	}

	/**
	 * TODO Move this method in ConnectorReification.java (once Manel has finished to modify the file)
	 * 
	 * @author ac221913
	 * 
	 */
	public static void generateCollaborationUse(Connector connector) {

		InteractionComponent connectorCompGen = connector.getIc();

		if(!(connectorCompGen instanceof InteractionComponent)) {
			return;
		}
		InteractionComponent connectorComp = (InteractionComponent)connectorCompGen;
		org.eclipse.uml2.uml.Collaboration connectionPattern =
			connectorComp.getConnectionPattern();

		if(connectionPattern == null) {
			FCMUtil.generateDefaultConnectionPattern(connectorComp);
			connectionPattern = connectorComp.getConnectionPattern();
		}

		Class composite = (Class)connector.getBase_Connector().getOwner();
		CollaborationUse collaborationUse;
		RoleBindingTable bindingTable = getConnectorRoleBindings(connector);

		if(bindingTable == null)
			return;

		collaborationUse = composite.createCollaborationUse("useOf" + connectionPattern.getName());
		collaborationUse.setType(connectionPattern);
		for(Iterator<org.eclipse.uml2.uml.ConnectableElement> i = bindingTable.iterator(); i.hasNext();) {
			org.eclipse.uml2.uml.ConnectableElement role = i.next();
			org.eclipse.uml2.uml.Dependency roleBinding;
			roleBinding = collaborationUse.createRoleBinding(role.getName() + "RoleBinding");
			roleBinding.getSuppliers().add(role);
			for(Iterator<org.eclipse.uml2.uml.NamedElement> j = bindingTable.getEntry(role).iterator(); j.hasNext();) {
				roleBinding.getClients().add(j.next());
			}
		}
	}

	/**
	 * Computes a RoleBindingTable for a given ConnectorComp
	 * Implies that a java class has been defined in FCMProfile.util for this ConnectorComp,
	 * and that it encapsulates corresponding role binding rule
	 * 
	 * @author ac221913
	 * 
	 */
	public static RoleBindingTable getConnectorRoleBindings(Connector connector) {
		InteractionComponent connectorCompGen = connector.getIc();

		if(!(connectorCompGen instanceof InteractionComponent)) {
			return null;
		}
		InteractionComponent type = (InteractionComponent)connectorCompGen;

		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = reg.getConfigurationElementsFor("fcmEmbeddingRule");
		for(IConfigurationElement configElement : configElements) {
			try {
				final String extConnName = configElement.getAttribute("connectorName");
				if(extConnName.equals(type.getBase_Class().getName())) {
					final Object obj = configElement.createExecutableExtension("class");
					if(obj instanceof IEmbeddingRule) {
						return ((IEmbeddingRule)obj).getRoleBindings(connector);
					}
				}
			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * return a list of all rules based on containment packages of rules
	 * from owning elements
	 */
	public static EList<ContainerRule> getAllContainerRules(Element element) {
		EList<ContainerRule> list = new UniqueEList<ContainerRule>();
		if(element != null) {
			for(EObject eObj : element.getStereotypeApplications()) {
				if(eObj instanceof RuleApplication) {
					list.addAll(((RuleApplication)eObj).getContainerRule());
					break;
				}
			}
			element = element.getOwner();
			if(element != null) {
				list.addAll(getAllContainerRules(element));
			}
		}
		return list;
	}

}
