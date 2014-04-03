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
 */

 package org.eclipse.papyrus.qompass.designer.core.templates;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.C_Cpp.ConstInit;
import org.eclipse.papyrus.qompass.designer.core.Messages;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.acceleo.AcceleoDriverWrapper;
import org.eclipse.papyrus.qompass.designer.core.transformations.LazyCopier;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationContext;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;

public class BindingUtils {
	
	/**
	 * Bind an operation by copying the signature from the actual.
	 * @param copy the copier
	 * @param actual the actual. If an operation, its signature is copied to the template
	 * @param operation The operation template
	 * @return
	 */
	public static Operation instantiateOperation(LazyCopier copy, Element actual, Operation operation) {
		try {
			Operation newOperation = copy.getCopy(operation);
			if(actual instanceof Operation) {
				for(Parameter parameter : ((Operation)actual).getOwnedParameters()) {
					Parameter newParam = EcoreUtil.copy(parameter); // copy parameter via EcoreUtil
					newParam.setType(copy.getCopy(parameter.getType()));
					newOperation.getOwnedParameters().add(newParam);
				}
			}
			TransformationContext.classifier = newOperation.getClass_();
			if(actual instanceof Classifier) {
				bindOperation(newOperation, (Classifier)actual);
			}
			String newName = AcceleoDriverWrapper.evaluate(operation.getName(), actual, null);
			newOperation.setName(newName);

			return newOperation;
		} catch (TransformationException e) {
			// throw runtime exception
			throw new RuntimeException(String.format(Messages.TemplateInstantiationListener_TrafoException, e.getMessage()));
		}
	}

	/**
	 * Instantiate a behavior
	 * @param copy copier
	 * @param actual actual in template instantiation
	 * @param opaqueBehavior behavior with body in form of an Acceleo template.
	 * @return instantiated (bound) behavior.
	 * @throws TransformationException
	 */
	public static OpaqueBehavior instantiateBehavior(LazyCopier copy, Element actual, OpaqueBehavior opaqueBehavior) throws TransformationException {
		OpaqueBehavior newBehavior = copy.getCopy(opaqueBehavior);
		if(actual instanceof NamedElement) {
			String newName = AcceleoDriverWrapper.evaluate(opaqueBehavior.getName(), actual, null);
			newBehavior.setName(newName);
		}
		EList<String> bodyList = newBehavior.getBodies();
		for(int i = 0; i < bodyList.size(); i++) {
			String body = bodyList.get(i);
			TransformationContext.classifier = (Classifier)newBehavior.getOwner();
			// pass qualified operation name as template name. Used to identify script in case of an error
			String newBody = AcceleoDriverWrapper.evaluate(body, newBehavior.getQualifiedName(), actual, null);
			bodyList.set(i, newBody);
		}
		return newBehavior;
	}



	/**
	 * Bind C++ const initializer
	 * 
	 * @param operation
	 * @param actual
	 * @throws TransformationException
	 */
	public static void bindOperation(Operation operation, Classifier actual) throws TransformationException {
		// perform binding in case of C++ initializer
		ConstInit cppConstInit = UMLUtil.getStereotypeApplication(operation, ConstInit.class);
		if(cppConstInit != null) {
			// TODO: specific to C++
			String init = cppConstInit.getInitialisation();
			String newInit = AcceleoDriverWrapper.bind(init, actual);
			cppConstInit.setInitialisation(newInit);
		}
	}

	/**
	 * @param actual
	 *        the actual template parameter
	 * @param boundClass
	 *        the bound class
	 * @param provides
	 *        true, if the provided interface should be returned
	 * @return the provided or required interface of a port (of the passed
	 *         boundClass) that is typed with the the actual.
	 */
	public static Interface getInterfaceFromPortTypedWithActual(Type actual, Class boundClass, boolean provided) {
		for(Port port : PortUtils.getAllPorts(boundClass)) {
			Interface provOrReqIntf;
			if(provided) {
				provOrReqIntf = PortUtils.getProvided(port);
			} else {
				provOrReqIntf = PortUtils.getRequired(port);
			}

			if((port.getType() == actual) && (provOrReqIntf != null)) {
				return provOrReqIntf;
			}
		}
		return null;
	}
}
