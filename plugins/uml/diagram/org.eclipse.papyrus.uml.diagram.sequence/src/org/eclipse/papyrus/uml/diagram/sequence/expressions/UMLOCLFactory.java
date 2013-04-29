/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.expressions;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
public class UMLOCLFactory {

	/**
	 * @generated
	 */
	private final UMLAbstractExpression[] expressions;

	/**
	 * @generated
	 */
	private final String[] expressionBodies;

	/**
	 * @generated
	 */
	protected UMLOCLFactory() {
		this.expressions = new UMLAbstractExpression[23];
		this.expressionBodies = new String[]{ "\' \'", //$NON-NLS-1$
		"self.messageSort=MessageSort::synchCall and self.sendEvent<>null and self.receiveEvent<>null", //$NON-NLS-1$
		"self.oclIsKindOf(uml::InteractionFragment)", //$NON-NLS-1$
		"self.oclIsKindOf(uml::InteractionFragment) or self.oclIsKindOf(uml::Lifeline)", //$NON-NLS-1$
		"(self.messageSort=MessageSort::asynchCall or self.messageSort=MessageSort::asynchSignal) and self.sendEvent<>null and self.receiveEvent<>null", //$NON-NLS-1$
		"self.oclIsKindOf(uml::InteractionFragment) or self.oclIsKindOf(uml::Lifeline)", //$NON-NLS-1$
		"true\r\n-- The following rule is completely false : check can not be performed with only source and target (depends on the the location on the lifeline). Anyway, job is previously done by method CommandHelper.hasValidContainer(IEditCommandRequest)\r\n--(self.oclIsKindOf(uml::InteractionFragment) or self.oclIsKindOf(uml::Lifeline)) and (self.owner = oppositeEnd.owner or self.owner = oppositeEnd or self = oppositeEnd.owner)", //$NON-NLS-1$
		"self.messageSort=MessageSort::reply and self.sendEvent<>null and self.receiveEvent<>null", //$NON-NLS-1$
		"self.oclIsKindOf(uml::InteractionFragment)", //$NON-NLS-1$
		"self.oclIsKindOf(uml::InteractionFragment) or self.oclIsKindOf(uml::Lifeline)", //$NON-NLS-1$
		"self.messageSort=MessageSort::createMessage and self.sendEvent<>null and self.receiveEvent<>null", //$NON-NLS-1$
		"self.oclIsKindOf(uml::InteractionFragment) or self.oclIsKindOf(uml::Lifeline)", //$NON-NLS-1$
		"self.oclIsKindOf(uml::Lifeline)", //$NON-NLS-1$
		"self.messageSort=MessageSort::deleteMessage and self.sendEvent<>null and self.receiveEvent<>null", //$NON-NLS-1$
		"self.oclIsKindOf(uml::InteractionFragment) or self.oclIsKindOf(uml::Lifeline)", //$NON-NLS-1$
		"self.oclIsKindOf(uml::DestructionOccurrenceSpecification) or self.oclIsKindOf(uml::Lifeline)", //$NON-NLS-1$
		"self.receiveEvent=null", //$NON-NLS-1$
		"self.oclIsKindOf(uml::Lifeline) or self.oclIsKindOf(uml::InteractionFragment)", //$NON-NLS-1$
		"self.oclIsKindOf(uml::Interaction)", //$NON-NLS-1$
		"self.sendEvent=null", //$NON-NLS-1$
		"self.oclIsKindOf(uml::Interaction)", //$NON-NLS-1$
		"(self.oclIsKindOf(uml::Lifeline) or self.oclIsKindOf(uml::InteractionFragment))", //$NON-NLS-1$
		"(self.oclIsKindOf(uml::Lifeline) or self.oclIsKindOf(uml::InteractionFragment) or self.oclIsKindOf(uml::Gate))", //$NON-NLS-1$
		};
	}

	/**
	 * @generated
	 */
	private static UMLOCLFactory getInstance() {
		UMLOCLFactory instance = UMLDiagramEditorPlugin.getInstance().getUMLOCLFactory();
		if(instance == null) {
			UMLDiagramEditorPlugin.getInstance().setUMLOCLFactory(instance = new UMLOCLFactory());
		}
		return instance;
	}

	/**
	 * @generated
	 */
	public static String getExpressionBody(int index) {
		return getInstance().expressionBodies[index];
	}

	/**
	 * @generated
	 */
	public static UMLAbstractExpression getExpression(int index, EClassifier context, Map<String, EClassifier> environment) {
		UMLOCLFactory cached = getInstance();
		if(index < 0 || index >= cached.expressions.length) {
			throw new IllegalArgumentException();
		}
		if(cached.expressions[index] == null) {
			cached.expressions[index] = getExpression(cached.expressionBodies[index], context, environment == null ? Collections.<String, EClassifier> emptyMap() : environment);
		}
		return cached.expressions[index];
	}

	/**
	 * @generated
	 */
	public static UMLAbstractExpression getExpression(String body, EClassifier context, Map<String, EClassifier> environment) {
		return new Expression(body, context, environment);
	}

	/**
	 * @generated
	 */
	public static UMLAbstractExpression getExpression(String body, EClassifier context) {
		return getExpression(body, context, Collections.<String, EClassifier> emptyMap());
	}

	/**
	 * @generated
	 */
	private static class Expression extends UMLAbstractExpression {

		/**
		 * @generated
		 */
		private final org.eclipse.ocl.ecore.OCL oclInstance;

		/**
		 * @generated
		 */
		private OCLExpression oclExpression;

		/**
		 * @generated
		 */
		public Expression(String body, EClassifier context, Map<String, EClassifier> environment) {
			super(body, context);
			oclInstance = org.eclipse.ocl.ecore.OCL.newInstance();
			initCustomEnv(oclInstance.getEnvironment(), environment);
			Helper oclHelper = oclInstance.createOCLHelper();
			oclHelper.setContext(context());
			try {
				oclExpression = oclHelper.createQuery(body());
				setStatus(IStatus.OK, null, null);
			} catch (ParserException e) {
				setStatus(IStatus.ERROR, e.getMessage(), e);
			}
		}

		/**
		 * @generated
		 */
		@SuppressWarnings("rawtypes")
		protected Object doEvaluate(Object context, Map env) {
			if(oclExpression == null) {
				return null;
			}
			// on the first call, both evalEnvironment and extentMap are clear, for later we have finally, below.
			EvaluationEnvironment<?, ?, ?, ?, ?> evalEnv = oclInstance.getEvaluationEnvironment();
			// initialize environment
			for(Object nextKey : env.keySet()) {
				evalEnv.replace((String)nextKey, env.get(nextKey));
			}
			try {
				Object result = oclInstance.evaluate(context, oclExpression);
				return oclInstance.isInvalid(result) ? null : result;
			} finally {
				evalEnv.clear();
				oclInstance.setExtentMap(null); // clear allInstances cache, and get the oclInstance ready for the next call
			}
		}

		/**
		 * @generated
		 */
		private static void initCustomEnv(Environment<?, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, ?, ?, ?> ecoreEnv, Map<String, EClassifier> environment) {
			// Use EObject as implicit root class for any object, to allow eContainer() and other EObject operations from OCL expressions
			ParsingOptions.setOption(ecoreEnv, ParsingOptions.implicitRootClass(ecoreEnv), EcorePackage.eINSTANCE.getEObject());
			for(String varName : environment.keySet()) {
				EClassifier varType = environment.get(varName);
				ecoreEnv.addElement(varName, createVar(ecoreEnv, varName, varType), false);
			}
		}

		/**
		 * @generated
		 */
		private static Variable createVar(Environment<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> ecoreEnv, String name, EClassifier type) {
			Variable var = EcoreFactory.eINSTANCE.createVariable();
			var.setName(name);
			var.setType(ecoreEnv.getUMLReflection().getOCLType(type));
			return var;
		}
	}
}
