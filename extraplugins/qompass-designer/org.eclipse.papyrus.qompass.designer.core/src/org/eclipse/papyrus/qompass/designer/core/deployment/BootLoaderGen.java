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

package org.eclipse.papyrus.qompass.designer.core.deployment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.C_Cpp.Include;
import org.eclipse.papyrus.FCM.InitPrecedence;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource;
import org.eclipse.papyrus.qompass.designer.core.ConnectorUtils;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.acceleo.UMLTool;
import org.eclipse.papyrus.qompass.designer.core.transformations.CompImplTrafos;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.papyrus.qompass.designer.core.transformations.PrefixConstants;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * The task of the boot-loader is twofold: create the instances of all
 * implementations (non-recursive).
 * - create Connections: what should be done?
 * TODO: factor out common code (TemplateInstantiation mechanism & createConnections below)
 * make non-static class (representing the bootLoader)
 */
public class BootLoaderGen {

	/**
	 * Create a new boot-loader in a specific package
	 * (which represents a node of the system).
	 * 
	 * @param The
	 *        package in which the bootloader should be created
	 */
	public BootLoaderGen(Copy copy, int nodeIndex, int numberOfNodes)
		throws TransformationException {
		// Class composite = (Class) ut.getClassifier (mainInstance);
		// place in root (getModel()) to avoid the problem that the declaration of the bootLoader
		// instance is within a namespace (a static attribute on the model level would not solve the
		// problem as it must be accessed by function main).
		m_bootLoader = copy.target.createOwnedClass("BootLoader", false);
		outputSizeof = false;
		m_copy = copy;
		Class template = (Class)Utils.getQualifiedElement(copy.source, bootloaderQNAME);
		if(template == null) {
			throw new TransformationException("Cannot retrieve bootLoader template (should be in " + bootloaderQNAME + ")");
		}
		// TODO: currently, only stereotypes are copied from template
		StUtils.copyStereotypes(template, m_bootLoader);


		// TODO: commented code below already fixed?
		/*
		 * Problem: defaultValue not taken into account by code generator
		 * => use global variables via cppInclude instead (see below: "bodyStr = ...")
		 * NamedElement corba_long = Utils.getQualifiedElement (owner, "CORBA::Long");
		 * if (corba_long instanceof Type) {
		 * Property nodeNumber =
		 * m_bootLoader.createOwnedAttribute ("nodeNumber", (Type) corba_long);
		 * nodeNumber.setIsStatic (true);
		 * nodeNumber.setDefault ("0"); // for testing
		 * Property numberOfNodes =
		 * m_bootLoader.createOwnedAttribute ("numberOfNodes", (Type) corba_long);
		 * numberOfNodes.setIsStatic (true);
		 * numberOfNodes.setDefault ("2");
		 * }
		 */
		Include cppInclude = StUtils.applyApp(m_bootLoader, Include.class);
		Object existingBody = cppInclude.getBody();
		String existingBodyStr = "";
		if(existingBody instanceof String) {
			existingBodyStr = (String)existingBody + "\n";
		}
		String bodyStr =
			"#include <unistd.h> // for sleep\n" +
				"\n" +
				"int nodeIndex = " + nodeIndex + ";\n" +
				"int numberOfNodes = " + numberOfNodes + ";\n";
		if(outputSizeof) {
			bodyStr +=
				"#include <iostream>\n" +
					"using namespace std;\n";
		}

		cppInclude.setBody(existingBodyStr + bodyStr);

		// bootLoader.createOwnedAttribute (mainInstance.getName (), composite);

		// factor with template instantiations, actual is composite??
		/*
		 * Operation operation = template.getOwnedOperation ("createInstances", null, null);
		 * Operation newOperation =
		 * ModelTransformations.copyOperation (operation, bootLoader);
		 * // operation.getMethod ();
		 * // Method method = x;
		 * // AcceleoDriver.bind (method.toString (), mainInstance);
		 * Behavior behavior = operation.getMethods ().get (0);
		 * if (behavior instanceof OpaqueBehavior) {
		 * OpaqueBehavior newBehavior = (OpaqueBehavior)
		 * bootLoader.createOwnedBehavior ("b:" + operation.getName (),
		 * UMLPackage.eINSTANCE.getOpaqueBehavior ());
		 * newOperation.getMethods ().add (newBehavior);
		 * OpaqueBehavior opaqueBehavior = (OpaqueBehavior) behavior;
		 * Iterator<String> bodies = opaqueBehavior.getBodies ().iterator ();
		 * Iterator<String> languages = opaqueBehavior.getLanguages ().iterator ();
		 * while (bodies.hasNext ())
		 * {
		 * String body = bodies.next ();
		 * String language = languages.next ();
		 * String newBody = AcceleoDriver.bind (body, mainInstance);
		 * newBehavior.getBodies ().add (newBody);
		 * newBehavior.getLanguages().add (language);
		 * }
		 * }
		 */
		m_initCode = "";
		m_initCodeRun = "";
		m_activation = new HashMap<Class, EList<String>>();
		m_initCodeCConnections = "";
		m_initCodeCConfig = "";

		if(outputSizeof) {
			m_initCode += "cout << \"sizeof bootloader: \" << sizeof (bootloader) << endl;\n";
			// m_initCode += "cout << \"sizeof bootloader: \" << sizeof (bootloader) << endl;\n";
		}
	}

	/**
	 * Return the path from the main instance towards a sub-instance using the proper dereference
	 * operators, i.e. ".", if the sub-instance is enclosed via composition or "->" if the sub-instance
	 * is a pointer (since created by the bootloader).
	 * 
	 * @param slotPath
	 * @param instance
	 * @param accessName
	 *        return the name to access the feature. Returns access path to instance, not
	 *        the name of the variable for this instance (if instantiated by bootloader)
	 * @return
	 */
	public String getPath(Stack<Slot> slotPath, InstanceSpecification instance, boolean accessName) {
		if(slotPath.size() > 0) {
			// start with first instance
			String path = slotPath.get(0).getOwningInstance().getName();
			boolean previousInstantiatedByBL = false;
			for(Slot pathElement : slotPath) {
				if(pathElement != null) {
					if(previousInstantiatedByBL && accessName) {
						// If an instance is instantiated by the bootloader, it is only referenced via its type in the
						// owning composite. Thus, configuration (and activation calls) might fail as the type might not
						// have these configuration properties or operations.
						// Therefore, configuration and initial calls use
						//   - the path, if instantiated by the composite
						//   - the variable name, if done by the bootloader
						path = UMLTool.varName(path); // use variable name instead.
					}
					path += "." + pathElement.getDefiningFeature().getName();
					previousInstantiatedByBL = CompImplTrafos.instantiateViaBootloader(pathElement.getDefiningFeature());
				}
			}
			if(previousInstantiatedByBL && !accessName) {
				// name of the variable for this expression instantiated by the bootloader
				path = UMLTool.varName(path);
			}
			return path;
		}
		else {
			return instance.getName(); // instance has no path via slots, it is a top level instance
		}
	}

	public Property addInstance(Stack<Slot> slotPath, InstanceSpecification instance, Class implementation, InstanceSpecification node)
		throws TransformationException
	{
		String accessName = getPath(slotPath, instance, true);
		String varName = getPath(slotPath, instance, false);

		Property implemPart = null;

		// containing instance not null (=> neither main instance nor singleton)
		Slot containerSlot = null;
		if(slotPath.size() > 0) {
			containerSlot = slotPath.peek();

			// initialize part/property in containing instance. The containing instance itself is accessed
			// via the naming of the associated instance, the part itself via the name of the defining feature.
			if(DepUtils.isShared(containerSlot)) {
				// we need to initialize the property (a reference) with the given instance
				Stack<Slot> referencePath = DepUtils.getAccessPath(instance);
				String referenceVarName = getPath(referencePath, instance, false);

				// add code for initialization
				m_initCode += accessName + " = &" + referenceVarName + ";\n";
				// is a reference which should not be called via activation & start
				// return now and skip code below
				return implemPart;
			}
			else if(CompImplTrafos.instantiateViaBootloader(containerSlot.getDefiningFeature())) {
				// let bootloader instantiate
				implemPart = m_bootLoader.createOwnedAttribute(/* "i_" + */varName, implementation);
				// add code for initialization
				m_initCode += accessName + " = &" + varName + ";\n";
				implemPart.setIsComposite(true);
			}
		}
		else {
			// top level, either main instance or singleton => bootloader instantiates, create attribute
			implemPart = m_bootLoader.createOwnedAttribute(/* "i_" + */varName, implementation);
			implemPart.setIsComposite(true);
		}
		if(outputSizeof) {
			m_initCode += "cout << \"sizeof " + implementation.getName() + ": \" << sizeof (" + varName + ") << endl;\n";
		}

		// if start thread => existing thread activation interceptor? Connection?
		if(StUtils.isApplied(implementation, SwSchedulableResource.class)) {
			// yes, but is the thread instance part of the deployment plan?? [mmh, probably yes...]
			// call threads start routine here? (via main thread?) which in turn will activate the start routine?
		}

		// implementation contains get_start operation => has start port
		// which is called automatically
		String get_start = PrefixConstants.getP_Prefix + "start";

		// Need to check whether implementation is an executor which is encapsulated in a container. In this case, only
		// the method of the container and not the method of the executor (which owns the same port) maybe called.
		// Currently, this check is based on the use of "executor" as reserved part name (validation checks that the
		// user does not use this name for application components)
		if(hasUnconnectedStartRoutine(m_copy, implementation, containerSlot)) {
			if(m_initCodeRun.equals("")) {
				// call start's run method
				// TODO: Need path that uses the right dereference operator ("->" or ".")
				m_initCodeRun = varName + "." + get_start + "()->run ();\n";
			} else {
				throw new TransformationException("There must be at most one blocking \"run\" operation per node. " +
					"refuse to add \"run\" call for component instance \"" + varName + "\". Existing invocations: " + m_initCodeRun);
			}
		}
		if(hasUnconnectedLifeCycle(m_copy, implementation, containerSlot)) {
			// precedence is checked below (when code is actually produced)
			// multiple varNames might share the same implementation. Put a list of variable names into the table
			EList<String> varNameList = m_activation.get(implementation);
			if(varNameList == null) {
				varNameList = new BasicEList<String>();
			}
			varNameList.add(varName + ".");
			m_activation.put(implementation, varNameList);
		}

		// check, if implementation contains a composite if (implementation.getOwnedOperation ("createConnections", null, null) != null) {
		boolean bCreateConn = false;
		for(Connector connector : implementation.getOwnedConnectors()) {
			if(ConnectorUtils.isAssembly(connector)) {
				bCreateConn = true;
				break;
			}
		}

		if(bCreateConn) {
			m_initCodeCConnections += varName + ".createConnections ();\n";
		}
		return implemPart;
	}

	/**
	 * Check whether the passed implementation has an unconnected start port.
	 * This information is required, since only unconnected start ports are automatically called by the
	 * bootloader, in particular we want to avoid calling a start port of an executor (which is connected)
	 * and its container.
	 * 
	 * @param implementation
	 * @param containerSlot
	 * @return
	 */
	public static boolean hasUnconnectedStartRoutine(Copy copy, Class implementation, Slot containerSlot) {
		if(implementation != null) {
			Element startPortElem = Utils.getNamedElementFromList(implementation.getAllAttributes(), "start");
			if(startPortElem instanceof Port) {
				Port startPort = (Port)startPortElem;
				if(startPort.getType().getName().equals("IStart")) {
					return !isConnected(copy, containerSlot, startPort);
				}

			}
		}
		return false;
	}

	/**
	 * Check, if the passed implementation has an unconnected life-cycle interface (activate/deactivate).
	 * This information is required, since only unconnected life cycle ports are automatically called by the
	 * bootloader, in particular we want to avoid calling a life cycle port of an executor (which is connected)
	 * and its container.
	 * 
	 * @param implementation
	 * @param name
	 * @return
	 */
	public static boolean hasUnconnectedLifeCycle(Copy copy, Class implementation, Slot containerSlot) {
		if(implementation != null) {
			Element lcPortElem = Utils.getNamedElementFromList(implementation.getAllAttributes(), "lc");
			if(lcPortElem instanceof Port) {
				Port lcPort = (Port)lcPortElem;
				// check, if port typed with ILifeCycle interface
				if(lcPort.getType().getName().equals("ILifeCycle")) {
					return !isConnected(copy, containerSlot, lcPort);
				}
			}

		}
		return false;
	}

	/**
	 * The check verifies whether the passed port is connected within
	 * the context of the composite represented by the passed slot
	 * 
	 * @param containerSlot
	 *        a slot within an instance that represents a composite class
	 * @Param a port that is checked for being connected
	 * @return true, if connected
	 */
	private static boolean isConnected(Copy copy, Slot containerSlot, Port port) {
		if(containerSlot != null) {
			StructuralFeature sf = containerSlot.getDefiningFeature();
			if(sf instanceof Property) {
				// instance still points to a part in the tmp-model (there are no
				// instance specifications in the final model). Therefore, we use copy to
				// obtain the mapped instance.
				Property part = (Property)copy.copy(sf);
				Class composite = part.getClass_();
				for(Connector connector : composite.getOwnedConnectors()) {
					// must assure same connector end connects part & port
					ConnectorEnd end = ConnectorUtils.connEndForPart(connector, part);
					if((end != null) && (end.getRole() == port)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void instanceConfig(Stack<Slot> slotPath, InstanceSpecification instance) throws TransformationException {
		Slot slot = slotPath.peek();
		String varName = getPath(slotPath, instance, false);
		StructuralFeature sf = slot.getDefiningFeature();
		if(sf == null) {
			throw new TransformationException("A slot for instance " + varName +
				" has no defining feature");
		}

		for(ValueSpecification value : slot.getValues()) {

			// only set value, if not null
			if(value.stringValue() != null) {
				m_initCodeCConfig += varName + " = " + value.stringValue() + ";\n";
			}
		}
	}

	public void addCreateConnections() {
		// code generators do not handle connectors in a suitable way. Remove
		// (alternative: no-code-gen tag, as available for C++)
		m_bootLoader.getOwnedConnectors().clear();
	}

	public void addInit() {
		// TODO: use template
		Operation init = m_bootLoader.createOwnedOperation("init", null, null);
		OpaqueBehavior initBehavior = (OpaqueBehavior)
			m_bootLoader.createOwnedBehavior("init", UMLPackage.eINSTANCE.getOpaqueBehavior());
		init.getMethods().add(initBehavior);


		initBehavior.getLanguages().add("C/C++");
		String code = m_initCode + "\n";
		if(m_initCodeCConfig.length() > 0) {
			code += "\n// instance configuration\n" +
				m_initCodeCConfig + "\n";
		}
		if(m_initCodeCConnections.length() > 0) {
			code += "\n// create connections between instances\n" +
				m_initCodeCConnections + "\n";
		}
		Comparator<Class> comparator = new Comparator<Class>() {

			public int compare(Class clazz1, Class clazz2) {

				InitPrecedence precedenceC1 = StUtils.getApplication(clazz1, InitPrecedence.class);
				InitPrecedence precedenceC2 = StUtils.getApplication(clazz2, InitPrecedence.class);
				if(precedenceC1 != null) {
					// need to use named comparison instead of precedenceC1.getInvokeAfter ().contains (clazz2)
					// since class referenced by stereotype attribute still points to element in source model
					if(Utils.getNamedElementFromList(precedenceC1.getInvokeAfter(), clazz2.getName()) != null) {
						return 1;
					}
					else if(Utils.getNamedElementFromList(precedenceC1.getInvokeBefore(), clazz2.getName()) != null) {
						return -1;
					}
				}
				else if(precedenceC2 != null) {
					if(Utils.getNamedElementFromList(precedenceC2.getInvokeAfter(), clazz1.getName()) != null) {
						return -1;
					}
					else if(Utils.getNamedElementFromList(precedenceC2.getInvokeBefore(), clazz1.getName()) != null) {
						return 1;
					}
				}
				// singletons have precedence over "normal" classes
				boolean ci1IsSingleton = Utils.isSingleton(clazz1);
				boolean ci2IsSingleton = Utils.isSingleton(clazz2);
				if(ci1IsSingleton) {
					if(!ci2IsSingleton) {
						// not both are singletons
						return -1;
					}
				}
				else if(ci2IsSingleton) {
					return 1;
				}
				return 0;
			}
		};
		Class[] activationKeys = m_activation.keySet().toArray(new Class[0]);
		String get_lc = PrefixConstants.getP_Prefix + "lc";
		if(activationKeys.length > 0) {
			Arrays.sort(activationKeys, comparator);
			code += "// activation code\n";
			for(Class implementation : activationKeys) {
				EList<String> varNameList = m_activation.get(implementation);
				for(String varName : varNameList) {
					code += varName + get_lc + " ()->activate ();\n";
				}
			}
		}
		if(!m_initCodeRun.equals("")) {
			code += "// initial user start\n" +
				m_initCodeRun;
		} else {
			// no run code - assume that application should not return immediately
			// enter an endless sleep
			// TODO: issue user warning
			code += "// sleep forever (since there is no user \"start\" call)\n" +
				"for (;;) { sleep (1000); }\n";
		}
		if(activationKeys.length > 0) {
			code += "// deactivation code (reverse order)\n";

			// traverse in reverse order
			for(int i = activationKeys.length - 1; i >= 0; i--) {
				Class implementation = activationKeys[i];
				EList<String> varNameList = m_activation.get(implementation);
				for(String varName : varNameList) {
					code += varName + get_lc + " ()->deactivate ();\n";
				}
			}
		}

		initBehavior.getBodies().add(code);
	}

	public Class getUML() {
		return m_bootLoader;
	}

	private Class m_bootLoader;

	private final static String bootloaderQNAME = "core::composites::BootLoader";

	/**
	 * Initialization code, in particular assignment of part properties within composites
	 */
	private String m_initCode;

	/**
	 * Init code for create connections calls in composites with at least one assembly
	 * connector
	 */
	private String m_initCodeCConfig;

	/**
	 * Init code for create connections calls in composites with at least one assembly
	 * connector
	 */
	private String m_initCodeCConnections;

	/**
	 * Init code for blocking "run" calls (related to CStart system component)
	 */
	private String m_initCodeRun;

	/**
	 * Map containing activations/de-activations
	 */
	private Map<Class, EList<String>> m_activation;

	private boolean outputSizeof;

	/**
	 * copy variable (instances still point to non-copied classes)
	 */
	private Copy m_copy;
}
