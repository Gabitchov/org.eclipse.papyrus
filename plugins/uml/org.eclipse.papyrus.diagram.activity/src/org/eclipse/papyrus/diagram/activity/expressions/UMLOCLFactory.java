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
package org.eclipse.papyrus.diagram.activity.expressions;

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
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;

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
	protected UMLOCLFactory() {
		this.expressions = new UMLAbstractExpression[61];
	}

	/**
	 * @generated
	 */
	public static UMLAbstractExpression getExpression(int index, EClassifier context, Map<String, EClassifier> environment) {
		UMLOCLFactory cached = UMLDiagramEditorPlugin.getInstance().getUMLOCLFactory();
		if(cached == null) {
			UMLDiagramEditorPlugin.getInstance().setUMLOCLFactory(cached = new UMLOCLFactory());
		}
		if(index < 0 || index >= cached.expressions.length) {
			throw new IllegalArgumentException();
		}
		if(cached.expressions[index] == null) {
			final String[] exprBodies = new String[]{ "if self.owner.oclIsKindOf(CallOperationAction)\r\nthen self.owner.oclAsType(CallOperationAction).argument->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(CallOperationAction)\r\nthen self.owner.oclAsType(CallOperationAction).argument->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(CallOperationAction)\r\nthen self.owner.oclAsType(CallOperationAction).argument->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(CallOperationAction)\r\nthen self.owner.oclAsType(CallOperationAction).target = self\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(CallOperationAction)\r\nthen self.owner.oclAsType(CallOperationAction).target = self\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(CallOperationAction)\r\nthen self.owner.oclAsType(CallOperationAction).target = self\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPrecondition->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPostcondition->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPrecondition->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPostcondition->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPrecondition->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPostcondition->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPrecondition->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(Action)\r\nthen self.owner.oclAsType(Action).localPostcondition->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(SendObjectAction)\r\nthen self.owner.oclAsType(SendObjectAction).request = self\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(SendObjectAction)\r\nthen self.owner.oclAsType(SendObjectAction).request = self\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(SendObjectAction)\r\nthen self.owner.oclAsType(SendObjectAction).request = self\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(SendObjectAction)\r\nthen self.owner.oclAsType(SendObjectAction).target = self\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(SendObjectAction)\r\nthen self.owner.oclAsType(SendObjectAction).target = self\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(SendObjectAction)\r\nthen self.owner.oclAsType(SendObjectAction).target = self\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(SendSignalAction)\r\nthen self.owner.oclAsType(SendSignalAction).argument->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(SendSignalAction)\r\nthen self.owner.oclAsType(SendSignalAction).argument->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(SendSignalAction)\r\nthen self.owner.oclAsType(SendSignalAction).argument->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(SendSignalAction)\r\nthen self.owner.oclAsType(SendSignalAction).target = self\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(SendSignalAction)\r\nthen self.owner.oclAsType(SendSignalAction).target = self\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(SendSignalAction)\r\nthen self.owner.oclAsType(SendSignalAction).target = self\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(ExpansionRegion)\r\nthen self.owner.oclAsType(ExpansionRegion).inputElement->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(ExpansionRegion)\r\nthen self.owner.oclAsType(ExpansionRegion).outputElement->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"\' \'", //$NON-NLS-1$
			"self.incoming->isEmpty()", //$NON-NLS-1$
			"not self.source.oclIsKindOf(InitialNode)", //$NON-NLS-1$
			"self.outgoing->isEmpty()", //$NON-NLS-1$
			"-- must be applied on corresponding parameter, if only it exists\r\ntrue\r\n--not self.isUnique", //$NON-NLS-1$
			"-- must be applied on corresponding parameter, if only it exists\r\ntrue\r\n--((not self.selection.oclIsUndefined()) implies self.isOrdered) and\r\n--(self.isOrdered implies (not self.selection.oclIsUndefined()))", //$NON-NLS-1$
			"true\r\n-- Already checked by validateControlFlow_validateObjectNodes", //$NON-NLS-1$
			"self.isControl implies self.isControlType", //$NON-NLS-1$
			"self.outgoing.target->forAll(inStructuredNode=self.owner)", //$NON-NLS-1$
			"(not self.fromAction.oclIsUndefined()) implies\r\nself.fromAction.output->size() = 1", //$NON-NLS-1$
			"(not self.fromAction.oclIsUndefined()) implies\r\nself.fromAction.input->forAll(oclIsKindOf(ActionInputPin))", //$NON-NLS-1$
			"(not self.fromAction.oclIsUndefined()) implies\r\n(self.fromAction.incoming->isEmpty() and self.fromAction.outgoing->isEmpty()\r\nand self.fromAction.input->forAll(incoming->isEmpty() and outgoing->isEmpty())\r\nand self.fromAction.output->forAll(incoming->isEmpty() and outgoing->isEmpty()))", //$NON-NLS-1$
			"self.incoming->isEmpty()", //$NON-NLS-1$
			"self.incoming.source->forAll(inStructuredNode=self.owner)", //$NON-NLS-1$
			"self.owner.oclIsKindOf(Activity)\r\nor self.owner.oclIsKindOf(ActivityGroup)", //$NON-NLS-1$
			"true\r\n-- constraint is checked by the model structure", //$NON-NLS-1$
			"-- This constraint is implemented separately for not being in live mode.\r\n-- Other constraints have been relaxed to supprot null source and target\r\nnot self.source.oclIsUndefined() and not self.target.oclIsUndefined()", //$NON-NLS-1$
			"(self.source.oclIsUndefined() or not self.source.oclIsKindOf(Action))\r\nand (self.target.oclIsUndefined() or not self.target.oclIsKindOf(Action))", //$NON-NLS-1$
			"(not self.selection.oclIsUndefined()) implies self.source.oclIsKindOf(ObjectNode)", //$NON-NLS-1$
			"self.isMulticast implies not self.isMultireceive", //$NON-NLS-1$
			"(self.source.oclIsUndefined() or\r\n\t(self.source.oclIsKindOf(ObjectNode) implies\r\n\tself.source.oclAsType(ObjectNode).isControlType)\r\n) and\r\n(self.target.oclIsUndefined() or\r\n\t(self.target.oclIsKindOf(ObjectNode) implies\r\n\tself.target.oclAsType(ObjectNode).isControlType)\r\n)", //$NON-NLS-1$
			"self.outgoing->size() > 0 and\r\nself.incoming->size() > 0 and\r\nself.incoming->size() <= 2", //$NON-NLS-1$
			"(self.incoming->reject(i | i = self.decisionInputFlow)->forAll(oclIsKindOf(ObjectFlow)) and\r\n self.outgoing->forAll(oclIsKindOf(ObjectFlow)) ) or\r\n(self.incoming->reject(i | i = self.decisionInputFlow)->forAll(oclIsKindOf(ControlFlow)) and\r\n self.outgoing->forAll(oclIsKindOf(ControlFlow)) )", //$NON-NLS-1$
			"(not self.decisionInputFlow.oclIsUndefined()) implies\r\nself.incoming->includes(self.decisionInputFlow)", //$NON-NLS-1$
			"(not self.decisionInput.oclIsUndefined()) implies (\r\nself.decisionInput.ownedParameter->select(\r\n direction = ParameterDirectionKind::out or\r\n direction = ParameterDirectionKind::inout)->size() = 0\r\nand self.decisionInput.ownedParameter->select(\r\n direction = ParameterDirectionKind::return)->size() = 1\r\n)", //$NON-NLS-1$
			"(not self.decisionInput.oclIsUndefined()) implies (\r\n  (self.decisionInputFlow.oclIsUndefined() and\r\n   self.incoming->select(i | i.oclIsKindOf(ControlFlow))->size() = 1\r\n  ) implies\r\n  self.decisionInput.ownedParameter->select(\r\n    direction = ParameterDirectionKind::_in)->size() = 0\r\n)", //$NON-NLS-1$
			"self.outgoing->size() = 1", //$NON-NLS-1$
			"(self.outgoing->exists(e | e.oclIsKindOf(ObjectFlow)) implies\r\n self.incoming->forAll(e | e.oclIsKindOf(ObjectFlow))) and\r\n(self.outgoing->exists(e | e.oclIsKindOf(ControlFlow)) implies\r\n self.incoming->forAll(e | e.oclIsKindOf(ControlFlow)))", //$NON-NLS-1$
			"self.incoming->size() = 1", //$NON-NLS-1$
			"(self.incoming->exists(e | e.oclIsKindOf(ObjectFlow)) implies\r\n self.outgoing->forAll(e | e.oclIsKindOf(ObjectFlow))) and\r\n(self.incoming->exists(e | e.oclIsKindOf(ControlFlow)) implies\r\n self.outgoing->forAll(e | e.oclIsKindOf(ControlFlow)))", //$NON-NLS-1$
			"self.outgoing->size() = 1", //$NON-NLS-1$
			"(self.incoming->select(e | e.oclIsKindOf(ObjectFlow))->notEmpty() implies\r\n self.outgoing->exists(e | e.oclIsKindOf(ObjectFlow))) and\r\n(self.incoming->select(e | e.oclIsKindOf(ObjectFlow))->isEmpty() implies\r\n self.outgoing->exists(e | e.oclIsKindOf(ControlFlow)))", //$NON-NLS-1$
			"(self.incoming->notEmpty() implies self.outgoing->isEmpty()) and\r\n(self.outgoing->notEmpty() implies self.incoming->isEmpty())", //$NON-NLS-1$
			};
			cached.expressions[index] = getExpression(exprBodies[index], context, environment == null ? Collections.<String, EClassifier> emptyMap() : environment);
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
