/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.View;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reg Exp Layer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#getExpr <em>Expr</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#isLevel1DomainChangedEventDependant <em>Is Level1 Domain Changed Event Dependant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#isAnyDomainChangedEventDependant <em>Is Any Domain Changed Event Dependant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#isLevel1DiagramChangedEventdependant <em>Is Level1 Diagram Changed Eventdependant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#isAnyDiagramChangedEventDependant <em>Is Any Diagram Changed Event Dependant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#getExpressionContextObjectType <em>Expression Context Object Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getRegExpLayer()
 * @model
 * @generated
 */
public interface RegExpLayer extends AbstractLayer {

	/**
	 * Returns the value of the '<em><b>Expr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' attribute.
	 * @see #setExpr(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getRegExpLayer_Expr()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getExpr();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#getExpr <em>Expr</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' attribute.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getRegExpLayer_Language()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * Returns the value of the '<em><b>Is Level1 Domain Changed Event Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Level1 Domain Changed Event Dependant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Level1 Domain Changed Event Dependant</em>' attribute.
	 * @see #setIsLevel1DomainChangedEventDependant(boolean)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getRegExpLayer_IsLevel1DomainChangedEventDependant()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isLevel1DomainChangedEventDependant();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#isLevel1DomainChangedEventDependant <em>Is Level1 Domain Changed Event Dependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Level1 Domain Changed Event Dependant</em>' attribute.
	 * @see #isLevel1DomainChangedEventDependant()
	 * @generated
	 */
	void setIsLevel1DomainChangedEventDependant(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Any Domain Changed Event Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Any Domain Changed Event Dependant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Any Domain Changed Event Dependant</em>' attribute.
	 * @see #setIsAnyDomainChangedEventDependant(boolean)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getRegExpLayer_IsAnyDomainChangedEventDependant()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isAnyDomainChangedEventDependant();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#isAnyDomainChangedEventDependant <em>Is Any Domain Changed Event Dependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Any Domain Changed Event Dependant</em>' attribute.
	 * @see #isAnyDomainChangedEventDependant()
	 * @generated
	 */
	void setIsAnyDomainChangedEventDependant(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Level1 Diagram Changed Eventdependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Level1 Diagram Changed Eventdependant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Level1 Diagram Changed Eventdependant</em>' attribute.
	 * @see #setIsLevel1DiagramChangedEventdependant(boolean)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getRegExpLayer_IsLevel1DiagramChangedEventdependant()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isLevel1DiagramChangedEventdependant();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#isLevel1DiagramChangedEventdependant <em>Is Level1 Diagram Changed Eventdependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Level1 Diagram Changed Eventdependant</em>' attribute.
	 * @see #isLevel1DiagramChangedEventdependant()
	 * @generated
	 */
	void setIsLevel1DiagramChangedEventdependant(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Any Diagram Changed Event Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Any Diagram Changed Event Dependant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Any Diagram Changed Event Dependant</em>' attribute.
	 * @see #setIsAnyDiagramChangedEventDependant(boolean)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getRegExpLayer_IsAnyDiagramChangedEventDependant()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isAnyDiagramChangedEventDependant();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#isAnyDiagramChangedEventDependant <em>Is Any Diagram Changed Event Dependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Any Diagram Changed Event Dependant</em>' attribute.
	 * @see #isAnyDiagramChangedEventDependant()
	 * @generated
	 */
	void setIsAnyDiagramChangedEventDependant(boolean value);

	/**
	 * Returns the value of the '<em><b>Expression Context Object Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Context Object Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression Context Object Type</em>' attribute.
	 * @see #setExpressionContextObjectType(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getRegExpLayer_ExpressionContextObjectType()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getExpressionContextObjectType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#getExpressionContextObjectType <em>Expression Context Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Context Object Type</em>' attribute.
	 * @see #getExpressionContextObjectType()
	 * @generated
	 */
	void setExpressionContextObjectType(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model newParentLayerRequired="true" newParentLayerOrdered="false"
	 * @generated
	 */
	void activate(AbstractLayerOperator newParentLayer);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model oldParentLayerRequired="true" oldParentLayerOrdered="false"
	 * @generated
	 */
	void deactivate(AbstractLayerOperator oldParentLayer);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<View> evaluateExpr();
} // RegExpLayer
