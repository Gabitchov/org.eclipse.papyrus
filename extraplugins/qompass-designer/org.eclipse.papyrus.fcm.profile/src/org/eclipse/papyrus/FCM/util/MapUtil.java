package org.eclipse.papyrus.FCM.util;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.FCM.DerivedElement;
import org.eclipse.papyrus.FCM.Port;
import org.eclipse.papyrus.FCM.PortKind;
import org.eclipse.papyrus.fcm.profile.Activator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;


public class MapUtil
{

	// specific treatment of "root" model that is created by eC3M for deployment
	// It avoids that copies of derived interfaces are created at different places
	// [better alternative: avoid problem by using set of models instead of single large one]
	// [other option?: no-update flag?]
	public static final String rootModelName = "root";

	public static final String MAPPING_RULE_ID = "fcmPortMappingRule";

	/**
	 * return the top-level owner of an element. This function returns the same value
	 * as getModel, if the top-level element is a model. While this is the case for
	 * models, model libraries have a top-level package (not a model). In this case,
	 * getTop returns the top-level package whereas getModel would return null.
	 * 
	 * @param element
	 * @return the top-level owning package
	 */
	public static Package getTop(Element element)
	{
		while(element != null) {
			Element owner = element.getOwner();
			if(owner == null) {
				if(element instanceof Package) {
					return (Package)element;
				}
			}
			else if((owner instanceof Package) && (owner.getOwner() == null) &&
				((Package)owner).getName().equals(rootModelName)) {
				// Hack: assure that no new derived interface folder is created in "root" model
				//   that eC3M creates for deployment
				if(element instanceof Package) {
					return (Package)element;
				}
			}
			element = owner;
		}
		return null;
	}

	/**
	 * Apply the derived element stereotype to a model element
	 * 
	 * @param element
	 * @return
	 */
	public static DerivedElement applyDE(Element element)
	{
		Stereotype stereotype = element.getApplicableStereotype("FCM::DerivedElement");
		if(stereotype != null) {
			EObject alreadyApplied = element.getStereotypeApplication(stereotype);
			if(alreadyApplied instanceof DerivedElement) {
				return (DerivedElement)alreadyApplied;
			}
			alreadyApplied = element.applyStereotype(stereotype);
			if(alreadyApplied instanceof DerivedElement) {
				return (DerivedElement)alreadyApplied;
			}
		}
		return null;
	}

	/**
	 * Get or create a package within another package (often the root of a model), i.e. return
	 * a package with the passed name, if it exists or create a new one of this name
	 * 
	 * @param root
	 *        a package potentially owning a certain element
	 * @param name
	 *        the name of a package that should be be returned.
	 * @return a package
	 */
	public static Package getAndCreate(Package root, String name)
	{
		NamedElement pkg = root.getOwnedMember(name);
		if(pkg == null) {
			pkg = root.createNestedPackage(name);
		}
		return (Package)pkg;
	}

	/**
	 * Get or create a derived interface for a port using the convention that the interface name
	 * is a concatenation (separated by parameter separation) of the port kind name and the type name.
	 * 
	 * @param kind
	 *        the port kind
	 * @param separation
	 *        separation string between kind and type name
	 * @param type
	 *        the type of the port
	 * @return
	 */
	public static Interface getOrCreateDerivedInterface(Port port, String separation, Type type)
	{
		return getOrCreateDerivedInterface(port, separation, type, false);
	}

	/**
	 * Get a derived interface for a port using the convention that the interface name
	 * is a concatenation (separated by parameter separation) of the port kind name and the type name.
	 * 
	 * @param kind
	 *        the port kind
	 * @param separation
	 *        separation string between kind and type name
	 * @param type
	 *        the type of the port
	 * @return
	 */
	public static Interface getDerivedInterface(Port port, String separation, Type type)
	{
		return getOrCreateDerivedInterface(port, separation, type, true);
	}

	/**
	 * Get a derived interface for a port using the convention that the interface name
	 * is a concatenation (separated by parameter separation) of the port kind name and the type name.
	 * 
	 * @param kind
	 *        the port kind
	 * @param separation
	 *        separation string between kind and type name
	 * @param type
	 *        the type of the port
	 * @return
	 */
	public static Interface getOrCreateDerivedInterface(Port port, String separation, Type type, boolean getOnly)
	{
		if(port == null) {
			return null;
		}
		PortKind kind = port.getKind();
		if(kind == null) {
			return null;
		}
		return getOrCreateDerivedInterfaceIntern(port, kind.getBase_Class().getName() + separation, type, getOnly);
	}

	/**
	 * Get or create a derived interface for a port using a fixed prefix
	 * type name
	 * 
	 * @param prefix
	 *        prefix string
	 * @param type
	 *        type name
	 * @return the derived interface or null (if it cannot be created)
	 */
	public static Interface getOrCreateDerivedInterfaceFP(Port port, String prefix, Type type)
	{
		return getOrCreateDerivedInterfaceIntern(port, prefix, type, false);
	}

	/**
	 * Get a derived interface for a port using the name given by concatenation of prefix and
	 * type name
	 * 
	 * @param prefix
	 *        prefix string
	 * @param type
	 *        type name
	 * @return the derived interface or null
	 */
	public static Interface getDerivedInterfaceFP(Port port, String prefix, Type type)
	{
		return getOrCreateDerivedInterfaceIntern(port, prefix, type, true);
	}

	/**
	 * This function returns a Package reference that corresponds to a qualified name.
	 * Packages are created, if not existing yet - the function is thus a bit similar to
	 * the unix "mkdir -p" command. Note that the main model within the list of name-spaces is
	 * ignored, in order to avoid that a sub-package within a model starts with the name
	 * of the model.
	 * 
	 * @param model
	 *        a model
	 * @param list
	 *        a list of namespace elements (as can be obtained via allNamespaces),
	 *        the top-level element is the last within the list.
	 * @param skipTop
	 *        if true, skip top level namespace element
	 * @return
	 */
	public static Package getAndCreate(Package root, EList<Namespace> list) {
		boolean first = true;
		for(int i = list.size() - 1; i >= 0; i--) {
			Namespace ns = list.get(i);

			if(first) {
				first = false;
				// Hack: if rootModel is used, skip top
				// (avoid that new derived interface with "root" prefix is created)
				if(ns.getName().equals(rootModelName)) {
					continue;
				}
			}
			NamedElement pkg = root.getOwnedMember(ns.getName());
			if(pkg == null) {
				// package does not exist => create it.
				pkg = root.createNestedPackage(ns.getName());
				// copy stereotype to create package
			}
			if(!(pkg instanceof Package)) {
				break;
			}
			root = (Package)pkg;
		}
		return root;
	}

	/**
	 * Get or create a derived interface for a port using the name given by concatenation of prefix and
	 * type name
	 * 
	 * @param port
	 *        The port for which to create a derived interface. Only used to determine the place where the
	 *        derived interface is placed
	 * @param prefix
	 *        prefix string
	 * @param type
	 *        type name
	 * @param getOnly
	 *        if true, do not create non-existing elements
	 * @return
	 */
	private static Interface getOrCreateDerivedInterfaceIntern(Port port, String prefix, Type type, boolean getOnly)
	{
		String interfaceName = "D_" + prefix + type.getName();

		// create derived element in "derivedInterface" package within the model owning
		// the port (which must be an FCM model, since the port carries the FCM stereotype)
		Package baseModelOfPort = getTop(port.getBase_Port());
		Package derivedInterfaces = getAndCreate(baseModelOfPort, "derivedInterfaces");
		Package owner = getAndCreate(derivedInterfaces, type.allNamespaces());
		Interface intf = null;

		PackageableElement pe = owner.getPackagedElement(interfaceName);
		if(pe instanceof Interface) {
			// interface already exists
			return (Interface)pe;
		}
		else if(!getOnly) {
			// System.out.println ("Derived port types: create new interface " + interfaceName + " in package " + owner.getQualifiedName ());
			intf = owner.createOwnedInterface(interfaceName);

			// System.out.println ("Derived port types: Apply derived stereotype annotation to interface: " + intf.getQualifiedName());
			DerivedElement de = applyDE(intf);
			if(de != null) {
				// de may be null, if FCM is not properly applied
				de.setSource(type);
			}
			return intf;
		}
		return null;
	}

	public static Interface getProvidedInterface(final Port port)
	{
		if(port.getBase_Port() == null) {
			// should not happen, but can occur in case of corrupted XMI files
			return null;
		}
		PortKind portKind = port.getKind();
		if(portKind == null) {
			if(port.getBase_Port().getProvideds().size() > 0) {
				return port.getBase_Port().getProvideds().get(0);
			}
		}
		else if(portKind.getBase_Class() != null) {
			String ruleName = portKind.isExtendedPort() ? "ExtendedPort" : portKind.getBase_Class().getName();
			final IMappingRule mappingRule = getMappingRule(ruleName);
			if(mappingRule != null) {
				// EList<Interface> temp = new EObjectEList<Interface>(Interface.class, (PortImpl) port,
				// 		FCMPackage.PORT__PROVIDED_INTERFACE);
				Runnable rule = new Runnable() {

					public void run() {
						intf = mappingRule.getProvided(port, port.getConfiguration());
					}
				};
				if((mappingRule.needsTransaction() == IMappingRule.BOTH) ||
					(mappingRule.needsTransaction() == IMappingRule.PROVIDED)) {
					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(port);
					if(CommandSupport.isWriteTransactionActive(domain) || (domain == null)) {
						// don't start a new transaction, if there is already an active write transition
						try {
							rule.run();
						} catch (Exception e) {
							// Happens with current version of Papyrus (ValidationCommand is a
							// transaction which spawn an additional thread). Needs fix on Papyrus side
							System.err.println(e);
						}
					}
					else {
						CommandSupport.exec(domain, "calculate derived interface", rule);
					}
				}
				else {
					rule.run();
				}
				return intf;
			}
		}
		return null;
	}

	private static Interface intf;

	public static Interface getRequiredInterface(final Port port)
	{
		PortKind portKind = port.getKind();
		if(port.getBase_Port() == null) {
			// should not happen, but can occur in case of corrupted XMI files
			return null;
		}
		if(portKind == null) {
			if(port.getBase_Port().getRequireds().size() > 0) {
				return port.getBase_Port().getRequireds().get(0);
			}
		}
		else if(portKind.getBase_Class() != null) {
			String ruleName = portKind.isExtendedPort() ? "ExtendedPort" : portKind.getBase_Class().getName();
			final IMappingRule mappingRule = getMappingRule(ruleName);
			if(mappingRule != null) {
				Runnable rule = new Runnable() {

					public void run() {
						intf = mappingRule.getRequired(port, port.getConfiguration());
					}
				};
				if((mappingRule.needsTransaction() == IMappingRule.BOTH) ||
					(mappingRule.needsTransaction() == IMappingRule.REQUIRED)) {
					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(port);
					if(CommandSupport.isWriteTransactionActive(domain) || (domain == null)) {
						// don't start a new transaction, if there is already an active write transition
						try {
							rule.run();
						} catch (Exception e) {
							// Happens with current version of Papyrus (ValidationCommand is a
							// transaction which spawn an additional thread). Needs fix on Papyrus side
							System.err.println(e);
						}
					}
					else {
						CommandSupport.exec(domain, "calculate derived interface", rule);
					}
				}
				else {
					rule.run();
				}
				return intf;
			}
		}
		return null;
	}

	public static IMappingRule getMappingRule(String portKindName)
	{
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = reg.getConfigurationElementsFor(Activator.PLUGIN_ID + "." + MAPPING_RULE_ID);
		for(IConfigurationElement configElement : configElements) {
			try {
				final String extPortKindName = configElement.getAttribute("portKindName");
				if(extPortKindName.equals(portKindName)) {
					final Object obj = configElement.createExecutableExtension("class");
					if(obj instanceof IMappingRule) {
						return (IMappingRule)obj;
					}
				}
			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}
		return null;
	}
}
