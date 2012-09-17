package org.eclipse.papyrus.uml.diagram.statemachine.custom.expressions;

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
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLDiagramEditorPlugin;

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
		this.expressions = new UMLAbstractExpression[4];
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
			final String[] exprBodies = new String[]{ "(kind = TransitionKind::internal) implies (source.oclIsKindOf (State) and source = target)", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(State)\r\nthen self.owner.oclAsType(State).exit->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(State)\r\nthen self.owner.oclAsType(State).entry->includes(self)\r\nelse false endif", //$NON-NLS-1$
			"if self.owner.oclIsKindOf(State)\r\nthen self.owner.oclAsType(State).doActivity->includes(self)\r\nelse false endif", //$NON-NLS-1$
			};
			cached.expressions[index] = getExpression(exprBodies[index], context, environment == null ? Collections.<String, EClassifier> emptyMap() : environment);
		}
		return cached.expressions[index];
	}


	/**
	 * This is factory method, callers are responsible to keep reference to the return value if they want to reuse parsed expression
	 * @generated
	 */
	public static UMLAbstractExpression getExpression(String body, EClassifier context, Map<String, EClassifier> environment) {
		return new Expression(body, context, environment);
	}

	/**
	 * This method will become private in the next release
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
