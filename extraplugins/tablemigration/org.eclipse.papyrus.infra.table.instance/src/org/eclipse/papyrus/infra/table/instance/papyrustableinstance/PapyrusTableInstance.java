/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.table.instance.papyrustableinstance;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.facet.infra.query.ModelQuery;

import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Papyrus Table Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#isIsSynchronized <em>Is Synchronized</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getTable <em>Table</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getFillingQueries <em>Filling Queries</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getPastedElementId <em>Pasted Element Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance()
 * @model
 * @generated
 */
public interface PapyrusTableInstance extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"no name"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the table.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance_Name()
	 * @model default="no name"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"PapyrusDefaultTable"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type of the table
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance_Type()
	 * @model default="PapyrusDefaultTable"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Is Synchronized</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates if the table is synchronized with its context or not. Synchronization is done with the filling queries.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Synchronized</em>' attribute.
	 * @see #setIsSynchronized(boolean)
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance_IsSynchronized()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsSynchronized();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#isIsSynchronized <em>Is Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Synchronized</em>' attribute.
	 * @see #isIsSynchronized()
	 * @generated
	 */
	void setIsSynchronized(boolean value);

	/**
	 * Returns the value of the '<em><b>Table</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The TableInstance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Table</em>' reference.
	 * @see #setTable(TableInstance2)
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance_Table()
	 * @model
	 * @generated
	 */
	TableInstance2 getTable();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getTable <em>Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(TableInstance2 value);

	/**
	 * Returns the value of the '<em><b>Filling Queries</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.infra.query.ModelQuery}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The queries used to fill the table
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Filling Queries</em>' reference list.
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance_FillingQueries()
	 * @model
	 * @generated
	 */
	EList<ModelQuery> getFillingQueries();

	/**
	 * Returns the value of the '<em><b>Pasted Element Id</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This attribute stores the id of the element represented by the row during a paste action in the table.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pasted Element Id</em>' attribute.
	 * @see #setPastedElementId(String)
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance_PastedElementId()
	 * @model default=""
	 * @generated
	 */
	String getPastedElementId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getPastedElementId <em>Pasted Element Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pasted Element Id</em>' attribute.
	 * @see #getPastedElementId()
	 * @generated
	 */
	void setPastedElementId(String value);

	/**
	 * Returns the value of the '<em><b>Pasted Element Containment Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property reference the feature of the context of the table which is used as containement feature
	 * for the pasted elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pasted Element Containment Feature</em>' reference.
	 * @see #setPastedElementContainmentFeature(EReference)
	 * @see org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage#getPapyrusTableInstance_PastedElementContainmentFeature()
	 * @model
	 * @generated
	 */
	EReference getPastedElementContainmentFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance#getPastedElementContainmentFeature <em>Pasted Element Containment Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pasted Element Containment Feature</em>' reference.
	 * @see #getPastedElementContainmentFeature()
	 * @generated
	 */
	void setPastedElementContainmentFeature(EReference value);

} // PapyrusTableInstance
