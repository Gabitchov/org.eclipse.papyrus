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

package org.eclipse.papyrus.qompass.designer.core.templates;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.FCM.BindingHelper;
import org.eclipse.papyrus.FCM.Template;
import org.eclipse.papyrus.qompass.designer.core.extensions.BindingHelperExt;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Template instantiation is implemented by means of an CopyListener that
 * evaluates the template stereotype.
 * This is a pre-copy listener.
 */

public class TemplateInstantiationListener implements CopyListener {

	public static TemplateInstantiationListener getInstance() {
		if(templateInstantiationListener == null) {
			templateInstantiationListener = new TemplateInstantiationListener();
			templateInstantiationListener.treatTemplate = false;
		}
		return templateInstantiationListener;
	}

	public void init(Copy copy, TemplateBinding binding, Object[] args) {
		treatTemplate = false;
		this.copy = copy;
		this.binding = binding;
		this.args = args;
	}

	private TemplateBinding binding;

	private Copy copy;

	private Object[] args;

	private boolean treatTemplate;

	private static TemplateInstantiationListener templateInstantiationListener;

	public EObject copyEObject(Copy copy, EObject sourceEObj) {
		if(treatTemplate) {
			return sourceEObj;
		}
		treatTemplate = true;
		EObject targetEObj = checkEObject(copy, sourceEObj);
		treatTemplate = false;
		return targetEObj;
	}

	protected EObject checkEObject(Copy copy, EObject sourceEObj) {
		// try {
		if(sourceEObj instanceof Element) {
			if(sourceEObj instanceof OpaqueBehavior) {
				OpaqueBehavior behavior = (OpaqueBehavior)sourceEObj;
				// in case of a behavior, examine stereotype on associated operation
				BehavioralFeature bf = behavior.getSpecification();
				if(bf != null) {
					Template template = UMLUtil.getStereotypeApplication(bf, Template.class);
					if(template != null) {
						return null;
					}
				}
			}
			else {
				Template template = UMLUtil.getStereotypeApplication((Element)sourceEObj, Template.class);
				if((template != null)) { // && (!treatTemplateElement.containsKey(sourceEObj))) {
					// treatTemplateElement.put(sourceEObj, true);
					BindingHelper helper = template.getHelper();
					if (helper != null) {
						return BindingHelperExt.applyHelper(helper, copy, binding, sourceEObj);
					}
					return sourceEObj;
					
					/*
					if(sourceEObj instanceof Operation) {
						Operation operation = (Operation)sourceEObj;

						Classifier actual = getFirstActualFromBinding(binding, operation);
						Class boundClass = copy.getCopy(operation.getClass_());
						if(template.getKind() == TemplateKind.LOOP_OPERATIONS) {
							// in case of loop operations, the template parameter is iteratively an
							// operation of the actual (which should be an interface) in this case.
							// 
							// The template operation typically inherits all parameters. This is expressed by
							// a single parameter with the LOOP_PARAMETERS options (<%name%> as name, what as type?)
							// cleaner (more general: if user writes loop with Acceleo as well?]
							//   // owns template operation parameter??
							Type passedActual = getPassedActual(template, actual, boundClass);
							if(!(passedActual instanceof Interface)) {
								return sourceEObj;
							}
							Interface passedActualIntf = (Interface)passedActual;
							Operation last = null;
							EList<Element> removalList = new BasicEList<Element>();
							for(Operation intfOperation : passedActualIntf.getAllOperations()) {
								for(Element removalElement : removalList) {
									copy.removeForCopy(removalElement); // enable subsequent instantiations
								}
								removalList.clear();
								last = instantiateOperation(intfOperation, template, operation, boundClass);
								removalList.add(operation);
								for(Behavior method : operation.getMethods()) {
									if(method instanceof OpaqueBehavior) {
										Behavior newBehavior =
											instantiateBehavior(intfOperation, template, (OpaqueBehavior)method);
										newBehavior.setSpecification(last);
										// removalList.add(method);
										copy.removeForCopy(method); // enable subsequent instantiations
									}
								}
							}
							// from a logical viewpoint, we need to copy parameters & name, but not the
							// operation identity.
							copy.put(operation, last);
							return last;
						}
						else {
							Operation newOperation = instantiateOperation(actual, template, operation, boundClass);
							for(Behavior method : operation.getMethods()) {
								if(method instanceof OpaqueBehavior) {
									Behavior newBehavior =
										instantiateBehavior(actual, template, (OpaqueBehavior)method);
									newBehavior.setSpecification(newOperation);
								}
							}
							return newOperation;
						}
					}
					else if(sourceEObj instanceof EnumerationLiteral) {
						if(template.getKind() == TemplateKind.LOOP_OPERATIONS) {
							EnumerationLiteral literal = (EnumerationLiteral)sourceEObj;
							Classifier actual = getFirstActualFromBinding(binding, literal);
							// Type passedActual = getPassedActual(template, actual, boundClass);
							Type passedActual = actual;
							if(!(passedActual instanceof Interface)) {
								return sourceEObj;
							}
							Interface passedActualIntf = (Interface)passedActual;
							EnumerationLiteral newLiteral = null;
							for(Operation intfOperation : passedActualIntf.getAllOperations()) {
								copy.removeForCopy(literal);
								newLiteral = copy.getCopy(literal);
								String newName = AcceleoDriverWrapper.evaluate(literal.getName(), intfOperation, args);
								newLiteral.setName(newName);
							}
							return newLiteral;
						}
					}
					*/
				}
			}
		}
		return sourceEObj;

	/*
	} catch (TransformationException e) {
		// throw runtime exception
		throw new RuntimeException(String.format(Messages.TemplateInstantiationListener_TrafoException, e.getMessage()));
	}
	*/
	}


	/*
	private Type getPassedActual(Template template, Type actual, Class boundClass) {
		if(template.getActualChoice() == ActualChoice.INTERFACE_OF_PPORT) {
			return getInterfaceFromPortTypedWithActual(actual, boundClass, true);
		} else if(template.getActualChoice() == ActualChoice.INTERFACE_OF_RPORT) {
			// TODO: typically does not make sense to loop over it.
			return getInterfaceFromPortTypedWithActual(actual, boundClass, false);
		} else if(template.getActualChoice() == ActualChoice.PASS_ACTUAL) {
			return actual;
		} else {
			// default behavior (common use in connectors): in case of a loop over operations, return actual
			// from provided port
			// TODO: Again, this is a hack!
			if(template.getKind() == TemplateKind.LOOP_OPERATIONS) {
				return getInterfaceFromPortTypedWithActual(actual, boundClass, true);
			} else {
				return actual;
			}
		}
	}
	*/
}
