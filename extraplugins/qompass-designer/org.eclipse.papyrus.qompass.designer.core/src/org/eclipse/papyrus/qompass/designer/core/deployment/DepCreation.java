package org.eclipse.papyrus.qompass.designer.core.deployment;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.papyrus.FCM.AutoIndex;
import org.eclipse.papyrus.FCM.AutoIndexPerNode;
import org.eclipse.papyrus.FCM.ConfigurationProperty;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.FCM.CopyAttributeValue;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.FCM.RuleApplication;
import org.eclipse.papyrus.qompass.designer.core.CORBAtypeNames;
import org.eclipse.papyrus.qompass.designer.core.ConfigUtils;
import org.eclipse.papyrus.qompass.designer.core.Log;
import org.eclipse.papyrus.qompass.designer.core.Messages;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationRTException;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLUtil;

public class DepCreation {

	private static Map<Object, Integer> map;

	public static final String valueFor = "value for "; //$NON-NLS-1$
	
	/**
	 * Create a slot and add an instance value associated with a part instance
	 * specification.
	 * 
	 * @param is
	 *        the instance specification for which a slot should be created
	 * @param partIS
	 *        the instance specification associated with the slot (to be
	 *        precise with slot's instance value)
	 * @param part
	 *        the part associated with the slot, i.e. its defining feature
	 * @return The created slot
	 */
	public static Slot createSlot(InstanceSpecification is,
		InstanceSpecification partIS, Property part) {
		// the instance specification of the composite has a slot for each part
		// and it points
		// to the instance specification associated with the part.
		Slot slot = is.createSlot();
		slot.setDefiningFeature(part);

		InstanceValue iv = (InstanceValue)slot.createValue(null, null,
			UMLPackage.eINSTANCE.getInstanceValue());
		iv.setInstance(partIS);
		return slot;

	}

	/**
	 * Create a Slot and a value for a configuration attribute
	 * 
	 * @param attribute
	 */
	public static Slot createSlotForConfigProp(InstanceSpecification is,
		Property attribute) {

		Slot slot = is.createSlot();
		slot.setDefiningFeature(attribute);
		// For primitive types, the UML type does not provide sufficient
		// information to decide
		// whether it is a string or a numerical value. In case of the C++
		// profile, primitive
		// UML types denote a language specific type, but we want to avoid C++
		// specific code, if
		// possible.
		// => pragmatic solution: use LiteralString as default, unless a check
		// for some known numerical
		// primitive types holds (in particular the UML as well as Qompass CORBA
		// types)
		// In addition, string values are not automatically quoted, i.e. it is
		// possible to enter e.g.
		// a float value as a string expression (it also means that a "real"
		// string value must be quoted
		// by the user).
		Type type = attribute.getType();
		if(type != null) {
			String name = type.getName();
			String qname = type.getQualifiedName();
			if(name.equals("Integer") || qname.equals(CORBAtypeNames.Octet) //$NON-NLS-1$
				|| qname.equals(CORBAtypeNames.Long)
				|| qname.equals(CORBAtypeNames.UnsignedLong)
				|| qname.equals(CORBAtypeNames.Short)
				|| qname.equals(CORBAtypeNames.UnsignedShort)) {
				slot.createValue(valueFor + attribute.getName(), type,
					UMLPackage.eINSTANCE.getLiteralInteger());
			} else if(name.equals("Boolean")) { //$NON-NLS-1$
				slot.createValue(valueFor + attribute.getName(), type,
					UMLPackage.eINSTANCE.getLiteralBoolean());
			} else {
				slot.createValue(valueFor + attribute.getName(), type,
					UMLPackage.eINSTANCE.getLiteralString());
			}
		}
		return slot;
	}

	/**
	 * Create a string slot and a value for a configuration attribute
	 * 
	 * @param attribute
	 */
	public static Slot createStringSlotForConfigProp(InstanceSpecification is,
		Property attribute) {

		Slot slot = is.createSlot();
		slot.setDefiningFeature(attribute);
		Type type = attribute.getType();
		if(type != null) {
			slot.createValue(valueFor + attribute.getName(), type,
				UMLPackage.eINSTANCE.getLiteralString());
		}
		return slot;
	}

	/**
	 * create a deployment plan, i.e. a set of instances that correspond to an
	 * implementation which is potentially a composite. In case of the latter,
	 * this function is called recursively to create deployment plans for the
	 * parts. Since a composite implementation may optionally specify only the
	 * type of parts (not the concrete implementation), this function also
	 * supports that a type is passed. In this case, an implementation is
	 * automatically assigned.
	 * 
	 * @param cdp
	 *        the deployment plan (package) in which to create instances
	 * @param typeOrImplem
	 *        the type
	 * @param nane
	 *        the name of the instance
	 * @param createSlotsForConfigValues
	 *        if true, create slots for configuration values
	 */
	public static InstanceSpecification createDepPlan(Package cdp,
		Class typeOrImplem, String name, boolean createSlotsForConfigValues)
		throws TransformationException
	{
		return createDepPlan(cdp, typeOrImplem, name, createSlotsForConfigValues, new Stack<Classifier>());
	}

	public static InstanceSpecification createDepPlan(Package cdp,
		Class typeOrImplem, String name, boolean createSlotsForConfigValues, Stack<Classifier> visitedClassifiers)
		throws TransformationException
	{
		// create an instance specification for the composite
		if(visitedClassifiers.contains(typeOrImplem)) {
			String path = ""; //$NON-NLS-1$
			for(Classifier cl : visitedClassifiers) {
				if(path.length() > 0) {
					path += ", "; //$NON-NLS-1$
				}
				path += cl.getName();
			}
			path += ", " + typeOrImplem.getName(); //$NON-NLS-1$
			throw new TransformationException(String.format(
				Messages.DepCreation_CircularReference,
				typeOrImplem.getQualifiedName(), path));
		}
		visitedClassifiers.push(typeOrImplem);

		InstanceSpecification is;
		// treat singleton
		if(Utils.isSingleton((Class)typeOrImplem)) {
			// is a singleton - exactly one instance exists
			InstanceSpecification mainInstance = DepUtils.getMainInstance(cdp);

			// use canonical name for singleton instance - lower case for type-name
			String partName = DeployConstants.singletonPrefix + typeOrImplem.getName().toLowerCase();
			name = mainInstance.getName() + DeployConstants.SEP_CHAR + partName;
			PackageableElement pe = cdp.getPackagedElement(name);

			if(pe == null) {
				// instance specification for singleton does not exist yet => create
								
				Classifier system = DepUtils.getClassifier(mainInstance);
				Property singletonAttr = system.getAttribute(partName, typeOrImplem);
				if((singletonAttr == null) && system instanceof Class) {
					singletonAttr = ((Class) system).createOwnedAttribute(partName, typeOrImplem);
					singletonAttr.setAggregation(AggregationKind.COMPOSITE_LITERAL);
				}
				
				is = (InstanceSpecification)
						cdp.createPackagedElement(name, UMLPackage.eINSTANCE.getInstanceSpecification());
				// create slot within main instance
				createSlot(mainInstance, is, singletonAttr);
			}
			else if (pe instanceof InstanceSpecification) {
				// exists already, return it without recursing into its sub-specifications
				return (InstanceSpecification) pe;
			}
			else {
				// unlikely case that a packaged element with the name
				// <singletonISname> exists already, but is not an instance specification
				throw new TransformationException(String.format(
					"singleton instantiation: element with name %s exists already in deployment plan, but is not an instance specification", name));
			}
		}
		else {
			 is = (InstanceSpecification)
					cdp.createPackagedElement(name, UMLPackage.eINSTANCE.getInstanceSpecification());
		}

		if(name.equals(DeployConstants.MAIN_INSTANCE)) {
			DepUtils.setMainInstance(cdp, is);
		}

		Class implementation = null;

		// treat HW architecture or nodes as implementations
		if(Utils.isCompImpl(typeOrImplem)
			|| typeOrImplem instanceof Node) {
			// implementation is known => must be able to do this.
			if(typeOrImplem instanceof Class) {
				implementation = (Class)typeOrImplem;
			}
		} else {
			// problem? further tree expansion might depend on chosen
			// implementation)
			// TODO: don't know node yet => implementation choice is more
			// general than necessary
			implementation = DepUtils.chooseImplementation(typeOrImplem, null, null);
		}

		if(!(implementation instanceof Class)) {
			throw new TransformationException(String.format(
				Messages.DepCreation_CannotFindImplementation,
				name, typeOrImplem.getName()));
		}
		// else implementation is instance of Class (and not null)

		is.getClassifiers().add(implementation);
		// add connector and container implementations
		RuleApplication ruleApplication = UMLUtil.getStereotypeApplication(implementation, RuleApplication.class);
		if((ruleApplication != null) && (createSlotsForConfigValues)) {
			for(ContainerRule rule : ruleApplication.getContainerRule()) {
				addConfigurationOfContainer(rule, is);
			}
		}

		for(Connector connector : implementation.getOwnedConnectors()) {
			org.eclipse.papyrus.FCM.Connector fcmConn = UMLUtil.getStereotypeApplication(connector, org.eclipse.papyrus.FCM.Connector.class);
			if(fcmConn != null) {
				String partName = name + "." + connector.getName(); //$NON-NLS-1$
				InteractionComponent connectorComp = fcmConn.getIc();
				if(connectorComp != null) {
					Class cl = fcmConn.getIc().getBase_Class();
					if(cl == null) {
						throw new TransformationException(Messages.DepCreation_FCMconnectorWithoutBaseClass);
					}
					// create sub-instance for connector. It is not possible to
					// create a slot in the owning instance specification,
					// since the connector cannot be referenced as a defining-feature
					createDepPlan(cdp, cl, partName, createSlotsForConfigValues, visitedClassifiers);
				}
			}
		}

		for(Property attribute : implementation.getAllAttributes()) {
			// loop over all attributes (not only parts, since we need to
			// capture singletons)
			if(attribute instanceof Port) {
				continue;
			}
			Type type = attribute.getType();

			if(Utils.isComposition(attribute)) {
				// composition, attribute is a part
				if(((type instanceof Class) && Utils.isComponent((Class)type)) || type instanceof Node) {
					Class cl = (Class)type;

					// TODO: ad-hoc replication support. Better solution via design patterns
					int upper = attribute.getUpper();
					String infix = ""; //$NON-NLS-1$

					// TODO: check validation constraints
					for(int i = 0; i < upper; i++) {
						String partName = name + "." + attribute.getName(); //$NON-NLS-1$
						if(upper > 1) {
							partName += "_" + infix + i; //$NON-NLS-1$
						}
						InstanceSpecification partIS = createDepPlan(cdp, cl,
							partName, createSlotsForConfigValues, visitedClassifiers);
						// may not create slot for singleton, since automatically done
						if(!Utils.isSingleton((Class)type)) {
							createSlot(is, partIS, attribute);
						}
					}
				}
				else if(StereotypeUtil.isApplied(attribute, ConfigurationProperty.class)
					&& createSlotsForConfigValues) {
					// is a configuration property, create slot
					// TODO: implicit assumption that configuration attributes
					// are not components
					createSlotForConfigProp(is, attribute);
				}
			}
			else if(type instanceof Class) {
				// no composition - only create slot, if a singleton
				// (otherwise, it's not clear with which instance the slot
				// should be associated)
				Log.log(Status.INFO, Log.DEPLOYMENT, String.format(
					Messages.DepCreation_InfoCreateDepPlan, type.getQualifiedName()));
				if(Utils.isSingleton((Class)type)) {
					// is a singleton - exactly one instance exists
					// recursive call - pass empty name, since name for singletons is re-calculated.
					InstanceSpecification singletonIS = createDepPlan(cdp,
						(Class)type, "", createSlotsForConfigValues, visitedClassifiers); //$NON-NLS-1$
					createSlot(is, singletonIS, attribute);
				}
			} else if(type == null) {
				throw new TransformationException(String.format(Messages.DepCreation_TypeInAttributeUndefined,
						attribute.getName(), implementation.getName()));
			}
		}
		visitedClassifiers.pop();
		return is;
	}

	/**
	 * Create slot for configuration properties that come from container rules
	 * 
	 * @param aRule
	 * @param is
	 * @throws TransformationException
	 */
	private static void addConfigurationOfContainer(ContainerRule rule,
		InstanceSpecification is) throws TransformationException {
		boolean first = true;
		for(Property attribute : ConfigUtils.getConfigAttributes(rule)) {
			Type type = attribute.getType();
			if((StereotypeUtil.isApplied(attribute, ConfigurationProperty.class))
				&& (type instanceof Class)) {
				Class aggregateOrInterceptor = DepUtils.chooseImplementation(
					(Class)type, new BasicEList<InstanceSpecification>(),
					null);
				// is a configuration property, create slot
				if(first) {
					// add contExtImpl to list of classifiers that the instance
					// specification describes
					is.getClassifiers().add(aggregateOrInterceptor);
					first = false;
				}
				// CAVEAT:
				// - single value specification for all occurrences of an interceptor
				// - Could be done, but: how to know whether user wants single
				//   vs. interceptor specific configuration?
				// - two different interceptors may not share the same type with
				//   a configuration attribute
				createSlotForConfigProp(is, attribute);
			}
		}
	}

	/**
	 * create a deployment plan, i.e. a set of instances that correspond to an
	 * implementation which is potentially a composite. In case of the latter,
	 * this function is called recursively to create deployment plans for the
	 * parts. Since a composite implementation may optionally specify only the
	 * type of parts (not the concrete implementation), this function also
	 * supports that a type is passed. In this case, an implementation is
	 * automatically assigned.
	 * 
	 * @param cdp
	 *        the deployment plan (package) in which to create instances
	 * @param typeOrImplem
	 *        the type
	 * @param nane
	 *        the name of the instance
	 * @param createSlotsForConfigValues
	 *        if true, create slots for configuration values
	 */
	public static InstanceSpecification createPlatformInstances(
		Package platform, Class implementation, String name)
		throws TransformationException {
		// create an instance specification for the composite
		InstanceSpecification is = null;
		is = (InstanceSpecification)platform.createPackagedElement(name,
			UMLPackage.eINSTANCE.getInstanceSpecification());
		is.getClassifiers().add(implementation);
		
		// add connector and container implementations

		for(Property attribute : implementation.getAllAttributes()) {
			// loop over all attributes (not only parts, since we need to
			// capture singletons)
			if(attribute instanceof Port) {
				continue;
			}
			Type type = attribute.getType();

			if(Utils.isComposition(attribute)) {
				// composition, attribute is a part
				if(type instanceof Class) { // should be a node, but do not require it
					Class cl = (Class)type;

					int upper = attribute.getUpper();
					String infix = ""; //$NON-NLS-1$
					// TODO: check validation constraints
					for(int i = 0; i < upper; i++) {
						// prefix with name, unless null
						String partName = (name != null) ? name + DeployConstants.SEP_CHAR : ""; //$NON-NLS-1$
						partName += attribute.getName();
						if(upper > 1) {
							partName += "_" + infix + i; //$NON-NLS-1$
						}
						InstanceSpecification partIS = createPlatformInstances(
							platform, cl, partName);

						if(is != null) {
							createSlot(is, partIS, attribute);
						}
					}
				} else if(StereotypeUtil.isApplied(attribute,
					ConfigurationProperty.class)) {
					// is a configuration property, create slot
					// TODO: implicit assumption that configuration attributes
					// are not components
					createSlotForConfigProp(is, attribute);
				}
			}
		}
		return is;
	}

	/**
	 * Initialize the automatic values within a deployment plan - and the update
	 * eventual copies of these values.
	 * 
	 * @param is
	 *        the main instance of the deployment plan
	 */
	public static void initAutoValues(InstanceSpecification is) {
		map = new HashMap<Object, Integer>();
		initAutoValuesHelper(is);
		Stack<InstanceSpecification> isStack = new Stack<InstanceSpecification>();
		copyAutoValues(isStack, is);
	}

	/**
	 * Initialize the automatic values within a deployment plan.
	 * 
	 * @param is
	 *        the main instance of the deployment plan
	 */
	public static void initAutoValuesHelper(InstanceSpecification is) {
		for(Slot slot : is.getSlots()) {
			StructuralFeature sf = slot.getDefiningFeature();
			if (sf == null) {
				throw new RuntimeException (String.format(Messages.DepCreation_DefiningFeatureNull,
						slot.getOwningInstance().getName()));
			}
			if(StereotypeUtil.isApplied(sf, AutoIndex.class)) {
				Integer value = null;
				Object key;
				if(StereotypeUtil.isApplied(sf, AutoIndexPerNode.class)) {
					InstanceSpecification nodeOrThread = AllocUtils.getNode(is);
					key = sf.getName() + nodeOrThread.getName();
				} else {
					key = sf;
				}
				if(!map.containsKey(key)) {
					map.put(key, new Integer(0));
				}
				value = map.get(key);
				value++; // no need to put incremented value back into map,
							// since Integer is a reference => value is updated

				// create slot and value specification (literal-integer) for the
				// auto index
				LiteralInteger li = (LiteralInteger)slot.createValue(
					sf.getName() + DeployConstants.AUTO_POSTFIX, sf.getType(),
					UMLPackage.eINSTANCE.getLiteralInteger());
				li.setValue(value);

				// recursion in case of values that are instance values
				for(ValueSpecification vs : slot.getValues()) {
					if(vs instanceof InstanceValue) {
						InstanceSpecification subIS = ((InstanceValue)vs)
							.getInstance();
						initAutoValues(subIS);
					}
				}
			}
		}
	}

	/**
	 * Initialize the automatic values within a deployment plan.
	 * 
	 * @param is
	 *        the main instance of the deployment plan
	 */
	public static void copyAutoValues(Stack<InstanceSpecification> isStack,
		InstanceSpecification is) {
		isStack.push(is);
		for(Slot slot : is.getSlots()) {
			StructuralFeature sf = slot.getDefiningFeature();
			if(sf == null) {
				throw new TransformationRTException(is.getName() + " has a slot without defining feature"); //$NON-NLS-1$
			}
			if(StereotypeUtil.isApplied(sf, CopyAttributeValue.class)) {
				CopyAttributeValue cav = UMLUtil.getStereotypeApplication(sf,
					CopyAttributeValue.class);
				Property source = cav.getSource();
				ValueSpecification vs = getNearestValue(isStack, source);
				if(vs instanceof LiteralInteger) {
					LiteralInteger liCopy = (LiteralInteger)slot.createValue(
						sf.getName() + "_copy", sf.getType(), //$NON-NLS-1$
						UMLPackage.eINSTANCE.getLiteralInteger());
					int value = ((LiteralInteger)vs).getValue();
					liCopy.setValue(value);
				}
			}

			// recursion in case of values that are instance values
			for(ValueSpecification vs : slot.getValues()) {
				if(vs instanceof InstanceValue) {
					InstanceSpecification subIS = ((InstanceValue)vs).getInstance();
					if(subIS != null) {
						copyAutoValues(isStack, subIS);
					}
				}
			}
		}
		isStack.pop();
	}

	/**
	 * try to find a value (ValueSpecification) for the passed source element,
	 * beginning a the "deepest" instance specification of the passed stack. If
	 * not found, continue at elements higher up in the hierarchy
	 * 
	 * @param isStack
	 *        a stack of instance specifications corresponding to a path
	 *        within an instance tree
	 * @param source
	 *        a property (defining feature) for which we search an instance
	 *        specification
	 * @return The value specifications for the passed source property or null
	 */
	public static ValueSpecification getNearestValue(
		Stack<InstanceSpecification> isStack, Property source) {
		Stack<InstanceSpecification> copy = new Stack<InstanceSpecification>();
		copy.addAll(isStack);
		while(!copy.isEmpty()) {
			InstanceSpecification pop = copy.pop();
			ValueSpecification vs = getNearestValueHelper(isStack, pop, source);
			if(vs != null) {
				return vs;
			}
		}
		return null;
	}

	/**
	 * Helper for getNearestValue: search for an instance specification that has
	 * source as defining feature. Start at the passed instance specification,
	 * but do not recurse into elements that are contained in the stack.
	 * 
	 * @param isStack
	 *        A stack of instance specifications corresponding to a path
	 *        within an instance tree
	 * @param is
	 *        the starting instance specification
	 * @param source
	 *        source a property (defining feature) for which we search an
	 *        instance specification
	 * @return The value specifications for the passed source property or null
	 */
	public static ValueSpecification getNearestValueHelper(
		Stack<InstanceSpecification> isStack, InstanceSpecification is,
		Property source) {
		for(Slot slot : is.getSlots()) {
			StructuralFeature sf = slot.getDefiningFeature();
			if(sf == source) {
				// found property, now return first value specification
				for(ValueSpecification vs : slot.getValues()) {
					return vs;
				}
				return null;
			}

			// recursion in case of values that are instance values
			for(ValueSpecification vs : slot.getValues()) {
				if(vs instanceof InstanceValue) {
					InstanceSpecification subIS = ((InstanceValue)vs)
						.getInstance();
					if(!isStack.contains(subIS)) {
						// only recurse, if not contained in stack of instance
						// specifications (avoid traversing
						// the same elements multiple times)
						return getNearestValueHelper(isStack, subIS, source);
					}
				}
			}
		}
		return null;
	}
}
