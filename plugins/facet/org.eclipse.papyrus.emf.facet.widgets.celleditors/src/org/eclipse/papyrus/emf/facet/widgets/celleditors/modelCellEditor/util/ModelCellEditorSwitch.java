/**
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 */
package org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.NaryFeatureCellEditor;
import org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.UnaryReferenceCellEditor;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage
 * @generated
 */
public class ModelCellEditorSwitch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ModelCellEditorPackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelCellEditorSwitch() {
		if (ModelCellEditorSwitch.modelPackage == null) {
			ModelCellEditorSwitch.modelPackage = ModelCellEditorPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns
	 * a non null result; it yields that result. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code>
	 *         call.
	 * @generated
	 */
	public T doSwitch(final EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns
	 * a non null result; it yields that result. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code>
	 *         call.
	 * @generated
	 */
	protected T doSwitch(final EClass theEClass, final EObject theEObject) {
		if (theEClass.eContainer() == ModelCellEditorSwitch.modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		List<EClass> eSuperTypes = theEClass.getESuperTypes();
		return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0),
				theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns
	 * a non null result; it yields that result. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code>
	 *         call.
	 * @generated
	 */
	protected T doSwitch(final int classifierID, final EObject theEObject) {
		switch (classifierID) {
		case ModelCellEditorPackage.MODEL_CELL_EDITOR_DECLARATIONS: {
			ModelCellEditorDeclarations modelCellEditorDeclarations = (ModelCellEditorDeclarations) theEObject;
			T result = caseModelCellEditorDeclarations(modelCellEditorDeclarations);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR: {
			AbstractModelCellEditor abstractModelCellEditor = (AbstractModelCellEditor) theEObject;
			T result = caseAbstractModelCellEditor(abstractModelCellEditor);
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ModelCellEditorPackage.BASIC_CELL_EDITOR: {
			BasicCellEditor basicCellEditor = (BasicCellEditor) theEObject;
			T result = caseBasicCellEditor(basicCellEditor);
			if (result == null) {
				result = caseAbstractModelCellEditor(basicCellEditor);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ModelCellEditorPackage.UNARY_REFERENCE_CELL_EDITOR: {
			UnaryReferenceCellEditor unaryReferenceCellEditor = (UnaryReferenceCellEditor) theEObject;
			T result = caseUnaryReferenceCellEditor(unaryReferenceCellEditor);
			if (result == null) {
				result = caseAbstractModelCellEditor(unaryReferenceCellEditor);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		case ModelCellEditorPackage.NARY_FEATURE_CELL_EDITOR: {
			NaryFeatureCellEditor naryFeatureCellEditor = (NaryFeatureCellEditor) theEObject;
			T result = caseNaryFeatureCellEditor(naryFeatureCellEditor);
			if (result == null) {
				result = caseAbstractModelCellEditor(naryFeatureCellEditor);
			}
			if (result == null) {
				result = defaultCase(theEObject);
			}
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Declarations</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Declarations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelCellEditorDeclarations(final ModelCellEditorDeclarations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Abstract Model Cell Editor</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Abstract Model Cell Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractModelCellEditor(final AbstractModelCellEditor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Basic Cell Editor</em>'. <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Basic Cell Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicCellEditor(final BasicCellEditor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Unary Reference Cell Editor</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Unary Reference Cell Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryReferenceCellEditor(final UnaryReferenceCellEditor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>Nary Feature Cell Editor</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate
	 * the switch. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>Nary Feature Cell Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNaryFeatureCellEditor(final NaryFeatureCellEditor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '
	 * <em>EObject</em>'. <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch, but this is
	 * the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *            the target of the switch.
	 * @return the result of interpreting the object as an instance of '
	 *         <em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(final EObject object) {
		return null;
	}

} // ModelCellEditorSwitch
