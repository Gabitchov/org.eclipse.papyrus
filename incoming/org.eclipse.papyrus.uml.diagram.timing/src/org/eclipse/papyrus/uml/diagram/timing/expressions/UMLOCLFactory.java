/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.expressions;

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
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
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
		this.expressions = new UMLAbstractExpression[7];
		this.expressionBodies = new String[] {
				"self.messageSort=MessageSort::synchCall and self.messageKind<>MessageKind::lost and self.messageKind<>MessageKind::found", //$NON-NLS-1$
				"self.messageSort=MessageSort::asynchCall or self.messageSort=MessageSort::asynchSignal", //$NON-NLS-1$
				"self.messageSort=MessageSort::reply", //$NON-NLS-1$
				"self.messageSort=MessageSort::createMessage", //$NON-NLS-1$
				"self.messageSort=MessageSort::deleteMessage", //$NON-NLS-1$
				"self.messageKind=MessageKind::lost", //$NON-NLS-1$
				"self.messageKind=MessageKind::found", //$NON-NLS-1$
		};
	}

	/**
	 * @generated
	 */
	private static UMLOCLFactory getInstance() {
		UMLOCLFactory instance = UMLDiagramEditorPlugin.getInstance().getUMLOCLFactory();
		if (instance == null) {
			UMLDiagramEditorPlugin.getInstance().setUMLOCLFactory(instance = new UMLOCLFactory());
		}
		return instance;
	}

	/**
	 * @generated
	 */
	public static String getExpressionBody(final int index) {
		return getInstance().expressionBodies[index];
	}

	/**
	 * @generated
	 */
	public static UMLAbstractExpression getExpression(final int index, final EClassifier context, final Map<String, EClassifier> environment) {
		final UMLOCLFactory cached = getInstance();
		if (index < 0 || index >= cached.expressions.length) {
			throw new IllegalArgumentException();
		}
		if (cached.expressions[index] == null) {
			cached.expressions[index] = getExpression(cached.expressionBodies[index], context,
					environment == null ? Collections.<String, EClassifier> emptyMap() : environment);
		}
		return cached.expressions[index];
	}

	/**
	 * This is factory method, callers are responsible to keep reference to the return value if they want to reuse
	 * parsed expression
	 * 
	 * @generated
	 */
	public static UMLAbstractExpression getExpression(final String body, final EClassifier context, final Map<String, EClassifier> environment) {
		return new Expression(body, context, environment);
	}

	/**
	 * This method will become private in the next release
	 * 
	 * @generated
	 */
	public static UMLAbstractExpression getExpression(final String body, final EClassifier context) {
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
		public Expression(final String body, final EClassifier context, final Map<String, EClassifier> environment) {
			super(body, context);
			this.oclInstance = org.eclipse.ocl.ecore.OCL.newInstance();
			initCustomEnv(this.oclInstance.getEnvironment(), environment);
			final Helper oclHelper = this.oclInstance.createOCLHelper();
			oclHelper.setContext(context());
			try {
				this.oclExpression = oclHelper.createQuery(body());
				setStatus(IStatus.OK, null, null);
			} catch (final ParserException e) {
				setStatus(IStatus.ERROR, e.getMessage(), e);
			}
		}

		/**
		 * @generated
		 */
		@Override
		@SuppressWarnings("rawtypes")
		protected Object doEvaluate(final Object context, final Map env) {
			if (this.oclExpression == null) {
				return null;
			}
			// on the first call, both evalEnvironment and extentMap are clear, for later we have finally, below.
			final EvaluationEnvironment<?, ?, ?, ?, ?> evalEnv = this.oclInstance.getEvaluationEnvironment();
			// initialize environment
			for (final Object nextKey : env.keySet()) {
				evalEnv.replace((String) nextKey, env.get(nextKey));
			}
			try {
				final Object result = this.oclInstance.evaluate(context, this.oclExpression);
				return this.oclInstance.isInvalid(result) ? null : result;
			} finally {
				evalEnv.clear();
				this.oclInstance.setExtentMap(null); // clear allInstances cache, and get the oclInstance ready for the
														// next call
			}
		}

		/**
		 * @generated
		 */
		private static void initCustomEnv(final Environment<?, EClassifier, ?, ?, ?, EParameter, ?, ?, ?, ?, ?, ?> ecoreEnv,
				final Map<String, EClassifier> environment) {
			// Use EObject as implicit root class for any object, to allow eContainer() and other EObject operations
			// from OCL expressions
			ParsingOptions.setOption(ecoreEnv, ParsingOptions.implicitRootClass(ecoreEnv), EcorePackage.eINSTANCE.getEObject());
			for (final String varName : environment.keySet()) {
				final EClassifier varType = environment.get(varName);
				ecoreEnv.addElement(varName, createVar(ecoreEnv, varName, varType), false);
			}
		}

		/**
		 * @generated
		 */
		private static Variable createVar(final Environment<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> ecoreEnv, final String name, final EClassifier type) {
			final Variable var = EcoreFactory.eINSTANCE.createVariable();
			var.setName(name);
			var.setType(ecoreEnv.getUMLReflection().getOCLType(type));
			return var;
		}
	}
}
