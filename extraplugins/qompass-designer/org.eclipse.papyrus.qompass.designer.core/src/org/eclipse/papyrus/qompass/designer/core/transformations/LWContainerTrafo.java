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
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.FCM.InterceptionRule;
import org.eclipse.papyrus.FCM.Template;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.acceleo.AcceleoDriverWrapper;
import org.eclipse.papyrus.qompass.designer.core.extensions.InstanceConfigurator;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateInstantiation;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateUtils;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A light-weight container transformation. Unlike the standard component-based transformation, this trafo does add a new class.
 * It is target for standard object-oriented architecture, enabling in particular to intercept the methods of a class (instead of
 * adding interceptors to ports).
 * 
 * @author ansgar
 * 
 */
public class LWContainerTrafo extends AbstractContainerTrafo {

	public final String interceptor =
		"[import org::eclipse::papyrus::qompass::designer::core::acceleo::utils_cpp/]\n" +
			"[template public dummy(operation : Operation)]\n" +
			"[returnCppCall()/];\n" +
			"[/template]\n";

	public final String origOpPrefix = "orig_";

	/**
	 * Constructor
	 * 
	 * @param sat
	 *        information about source and target model
	 * @param tmCDP
	 *        deployment plan within target model
	 */
	public LWContainerTrafo(Copy copy, Package tmCDP) {
		this.copy = copy;
		this.tmCDP = tmCDP;
		configureOnly = false;
		interceptionOpMap = new HashMap<Operation, Operation>();
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
	public void createContainer(Class smClass, Class tmClass) throws TransformationException {

		// for non-components: create a delegation operation for all operations that are provided by a class (excluding those derived by ports)
		// Calls on model level use CallOperationAction, will point to existing operation, unless changed.
		// If deployed dynamically (no static component deployment), need to change factories as well.
		// Pragmatic: rename/add existing operations (as Accord has done), do some renaming and clever model handling (assure
		// that code referencing classes via name automatically uses the new class.
		// => container with name of existing class, rename existing class.
		// possible: move operations into container, existing class gets copy (and update behaviors)

		// TODO: need something simple ...
		// requirements: 
		//  - existing creation operations create container (separation activity CreateAction: needs to change.)
		//    trivially in this case case, since container is no separate entity.
		//  - => references could be exchanged during copy operation with a suitable copyFilter (=> container transfo becomes a copy filter)
		// [in case of ports: quite difficult to handle: if port belongs to abstract components, it may be inherited by multiple components that
		//  might or might-not have a container => only some references need to be changed]
		//		=> clarify, how container handles super-classes, i.e. if it inherits ports as well (from a container of the abstract component) or not (not trivial at all!)
		// TODO: don't copy derived operations

		this.smClass = smClass;
		this.tmClass = tmClass;
		// create a copy of all operations
		operations = new BasicEList<Operation>(smClass.getAllOperations());
	}

	/**
	 * Only configure the instances, i.e. avoid re-creating elements of the container, but create
	 * the UML instance specifications
	 */
	public void configureOnly() {
		configureOnly = true;
	}

	public void createInstance() {
	}

	/**
	 * original operation => operation gets interception prefix"
	 * 
	 * Objectives: existing call operations call interception operation. Existing operations include CallOperationActions as well as calls within
	 * opaque behavior
	 * This is assured by keeping same model reference for the operation, but associating a new interception behavior, existing behavior will be
	 * associated
	 * with a new renamed operation
	 * 
	 * @param operation
	 */
	protected Operation createInterceptionOperation(Operation operation) throws TransformationException {
		// create copy of operation
		Operation copiedOperation = EcoreUtil.copy(operation);
		tmClass.getOwnedOperations().add(copiedOperation);
		StUtils.copyStereotypes(operation, copiedOperation);

		copiedOperation.setName(origOpPrefix + operation.getName());

		// create interception code
		// TODO: this is Java/C++ specific!
		OpaqueBehavior b = (OpaqueBehavior)tmClass.createOwnedBehavior(operation.getName(), UMLPackage.eINSTANCE.getOpaqueBehavior());
		String body = AcceleoDriverWrapper.bind(interceptor, copiedOperation);
		// TODO: solution is specific to C++
		b.getLanguages().add("C/C++");
		b.getBodies().add(body);
		// copy existing methods into new operation, copy method list,
		// since adding the method to copied operation will remove these from original operation)
		EList<Behavior> methods = new BasicEList<Behavior>(operation.getMethods());
		for(Behavior behavior : methods) {
			copiedOperation.getMethods().add(behavior);
		}
		// new behavior is associated with existing call.
		b.setSpecification(operation);
		return copiedOperation;
	}

	/**
	 * return the reference of the created container class
	 * 
	 * @return
	 */
	public Class getContainer() {
		return tmClass;
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

		// dependencies of the rule become dependencies of he class. These dependencies must be instantiated
		for(Dependency dependency : smContainerRule.getBase_Class().getClientDependencies()) {
			//
			for(Element target : dependency.getTargets()) {
				// target may, or may not be in a template
				if(target instanceof Classifier) {
					Classifier targetCl = (Classifier)target;
					Class extClass = expandAggregationDep((Class)targetCl, smComponent);
					tmComponent.createDependency(extClass);
					// if(TemplateUtils.getSignature(targetCl) != null) {
					// }
				}
			}
		}

		// execute after expansion before, since the TransformationContext.templateBinding variable remains set
		// to the same values (TODO: calculate it properly)
		for(Operation interceptionOperation : smContainerRule.getBase_Class().getAllOperations()) {
			expandInterceptorExtension(smContainerRule, interceptionOperation);
		}

		for(Property part : smContainerRule.getBase_Class().getAllAttributes()) {
			Type type = part.getType();
			if(type == null) {
				String ruleName = (smContainerRule.getBase_Class() != null) ? smContainerRule.getBase_Class().getName() : "undefined";
				throw new TransformationException("Cannot apply container rule <" + ruleName + ">, since the type of one of its parts is undefined. Check for unresolved proxies in imports");
			}
			if(part instanceof Port) {
				Port newPort = tmClass.createOwnedPort(part.getName(), part.getType());
				StUtils.copyStereotypes(part, newPort);
			}
			else if(type instanceof Class) {
				Class extOrInterceptor = (Class)type;
				// DepUtils.chooseImplementation((Class) type,
				// new BasicEList<InstanceSpecification>(), false);

				if(StereotypeUtil.isApplied(part, InterceptionRule.class)) {
					// port.filter
					// 
				}
				else {
					Property extensionPart =
						expandAggregationExtension(part.getName(), extOrInterceptor, tmComponent);
					// register relation to facilitate connector copy
					copy.setPackageTemplate(smContainerRule.getBase_Class(), tmClass);
					copy.put(part, extensionPart);
					copy.setPackageTemplate(null, null);
				}
			}
			else {
				Property newAttribute = EcoreUtil.copy(part);
				tmClass.getOwnedAttributes().add(newAttribute);
			}
		}
		InstanceConfigurator.configureInstance(smContainerRule, containerIS, null, context);

		// tell copy that tmcontainerImpl is associated with the smContainerRule
		// register a package template (although it is not a template) to assure that the connectors
		// get copied, although they are in a different resource (only the connectors are copied, not
		// the types of the referenced parts).
		// [main issue here: properties of container rule are not copies in the sense of identical
		// copies]

		// copy.setPackageTemplate(smContainerRule.getBase_Class(), tmClass);
		// copy.setPackageTemplate(null, null);
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
			extensionPart = tmClass.getAttribute(name, null);
			if((extensionPart != null) && extensionPart.getType() instanceof Class) {
				tmContainerExtImpl = (Class)extensionPart.getType();
			}
		}
		else {
			tmContainerExtImpl = expandAggregationDep(smContainerExtImpl, tmComponent);

			// add part associated with the extension to the container
			extensionPart = tmClass.createOwnedAttribute(name, tmContainerExtImpl);
		}
		// problem: would not be unique in case of multiple extensions
		// Copy.copyID(tmComponent, extensionPart, "a");
		extensionPart.setIsComposite(true);
		// TODO separation of container creation and instance creation
		// configure extension
		InstanceConfigurator.configureInstance(containerIS, extensionPart, context);

		return extensionPart;
	}

	Class expandAggregationDep(Class smContainerExtImpl, Class tmComponent) throws TransformationException {
		Class tmContainerExtImpl = null;

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

		return tmContainerExtImpl;
	}

	/**
	 * Expand an interceptor definition between the container and the executor.
	 * 
	 * @throws TransformationException
	 */
	EList<Property> expandInterceptorExtension(ContainerRule smContainerRule, Operation interceptionOperationInRule)
		throws TransformationException
	{
		for(Operation smOperation : operations) {
			Operation tmOperation = copy.getCopy(smOperation);
			String interceptionBody = "";
			for(Behavior behavior : interceptionOperationInRule.getMethods()) {
				if(behavior instanceof OpaqueBehavior) {
					EList<String> bodies = ((OpaqueBehavior)behavior).getBodies();
					if(bodies.size() > 0) {
						// always take first
						interceptionBody = bodies.get(0);
					}
				}
			}
			if(StereotypeUtil.isApplied(interceptionOperationInRule, Template.class)) {
				// pass operation in source model, since this enables acceleo code to check
				// for markers on model
				interceptionBody = AcceleoDriverWrapper.evaluate(interceptionBody, smOperation, null);
			}
			if(interceptionBody.length() > 0) {
				// only add interception operation, if the interception is not empty
				interceptionBody = "// --- interception code from rule <" + smContainerRule.getBase_Class().getName() + "> ---\n" +
					interceptionBody;
				Operation interceptionOpInClass = interceptionOpMap.get(tmOperation);
				if(interceptionOpInClass == null) {
					createInterceptionOperation(tmOperation);
					// existing operation becomes interception operation (by assigning it a new behavior and moving its behavior to a new operation
					interceptionOpInClass = tmOperation;
					interceptionOpMap.put(tmOperation, interceptionOpInClass);
				}
				for(Behavior behavior : interceptionOpInClass.getMethods()) {
					if(behavior instanceof OpaqueBehavior) {
						EList<String> bodies = ((OpaqueBehavior)behavior).getBodies();
						if(bodies.size() > 0) {
							// always take first
							String newBody = interceptionBody + "\n" + bodies.get(0);
							((OpaqueBehavior)behavior).getBodies().set(0, newBody);
						}
					}
				}
			}
		}
		return null;
	}

	// protected InstanceSpecification tmClassIS;

	protected EList<Operation> operations;

	protected Map<Operation, Operation> interceptionOpMap;

	@Override
	public void createContainerInstance(Class tmComponent, InstanceSpecification tmIS, ContainerContext context) {
		containerIS = tmIS;
		this.context = context;
		this.context.executorIS = tmIS;
	}
}
