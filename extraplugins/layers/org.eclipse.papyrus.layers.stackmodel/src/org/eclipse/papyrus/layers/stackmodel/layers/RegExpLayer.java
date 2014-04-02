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
import org.eclipse.papyrus.layers.stackmodel.LayersException;


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
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#isDomainChangedEventDependant <em>Is Domain Changed Event Dependant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#getDomainChangedEventLevel <em>Domain Changed Event Level</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#isDiagramChangedEventDependant <em>Is Diagram Changed Event Dependant</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#getDiagramChangedEventLevel <em>Diagram Changed Event Level</em>}</li>
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
	 * Returns the value of the '<em><b>Is Domain Changed Event Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Domain Changed Event Dependant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Domain Changed Event Dependant</em>' attribute.
	 * @see #setIsDomainChangedEventDependant(boolean)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getRegExpLayer_IsDomainChangedEventDependant()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isDomainChangedEventDependant();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#isDomainChangedEventDependant <em>Is Domain Changed Event Dependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Domain Changed Event Dependant</em>' attribute.
	 * @see #isDomainChangedEventDependant()
	 * @generated
	 */
	void setIsDomainChangedEventDependant(boolean value);

	/**
	 * Returns the value of the '<em><b>Domain Changed Event Level</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.layers.stackmodel.layers.EventLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Changed Event Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain Changed Event Level</em>' attribute.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.EventLevel
	 * @see #setDomainChangedEventLevel(EventLevel)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getRegExpLayer_DomainChangedEventLevel()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EventLevel getDomainChangedEventLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#getDomainChangedEventLevel <em>Domain Changed Event Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Changed Event Level</em>' attribute.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.EventLevel
	 * @see #getDomainChangedEventLevel()
	 * @generated
	 */
	void setDomainChangedEventLevel(EventLevel value);

	/**
	 * Returns the value of the '<em><b>Is Diagram Changed Event Dependant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Diagram Changed Event Dependant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Diagram Changed Event Dependant</em>' attribute.
	 * @see #setIsDiagramChangedEventDependant(boolean)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getRegExpLayer_IsDiagramChangedEventDependant()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isDiagramChangedEventDependant();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#isDiagramChangedEventDependant <em>Is Diagram Changed Event Dependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Diagram Changed Event Dependant</em>' attribute.
	 * @see #isDiagramChangedEventDependant()
	 * @generated
	 */
	void setIsDiagramChangedEventDependant(boolean value);

	/**
	 * Returns the value of the '<em><b>Diagram Changed Event Level</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.layers.stackmodel.layers.EventLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Changed Event Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Changed Event Level</em>' attribute.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.EventLevel
	 * @see #setDiagramChangedEventLevel(EventLevel)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getRegExpLayer_DiagramChangedEventLevel()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EventLevel getDiagramChangedEventLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer#getDiagramChangedEventLevel <em>Diagram Changed Event Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Changed Event Level</em>' attribute.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.EventLevel
	 * @see #getDiagramChangedEventLevel()
	 * @generated
	 */
	void setDiagramChangedEventLevel(EventLevel value);

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
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.boolean" required="true" ordered="false" exceptions="org.eclipse.papyrus.layers.stackmodel.layers.LayersException" viewRequired="true" viewOrdered="false"
	 * @generated
	 */
	boolean isDerivedView(View view) throws LayersException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.eclipse.papyrus.layers.stackmodel.layers.LayersException" viewRequired="true" viewOrdered="false"
	 * @generated
	 */
	void attachDerivedView(View view) throws LayersException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.eclipse.papyrus.layers.stackmodel.layers.LayersException" viewsMany="true" viewsOrdered="false"
	 * @generated
	 */
	void attachDerivedViews(EList<View> views) throws LayersException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.eclipse.papyrus.layers.stackmodel.layers.LayersException"
	 * @generated
	 */
	void attachDerivedViews() throws LayersException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" exceptions="org.eclipse.papyrus.layers.stackmodel.layers.LayersException" viewsMany="true" viewsOrdered="false"
	 * @generated
	 */
	EList<View> lookupDerivedViews(EList<View> views) throws LayersException;
} // RegExpLayer
