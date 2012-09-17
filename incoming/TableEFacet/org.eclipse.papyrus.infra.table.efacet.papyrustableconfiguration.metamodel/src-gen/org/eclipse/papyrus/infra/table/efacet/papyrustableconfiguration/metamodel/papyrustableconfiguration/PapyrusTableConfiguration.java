/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * ttp://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.tableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Papyrus Table Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This element registers the parameters to configure a PapyrusTableInstance2
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getFillingMode <em>Filling Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getFillingQueries <em>Filling Queries</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getListenContextFeature <em>Listen Context Feature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getTableConfiguration <em>Table Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrustableconfigurationPackage#getPapyrusTableConfiguration()
 * @model
 * @generated
 */
public interface PapyrusTableConfiguration extends EObject, EModelElement {

	/**
	 * Returns the value of the '<em><b>Filling Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This field allows to define the filling mode to use when the table is created.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Filling Mode</em>' attribute.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode
	 * @see #setFillingMode(FillingMode)
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrustableconfigurationPackage#getPapyrusTableConfiguration_FillingMode()
	 * @model ordered="false"
	 * @generated
	 */
	FillingMode getFillingMode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getFillingMode <em>Filling Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filling Mode</em>' attribute.
	 * @see org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode
	 * @see #getFillingMode()
	 * @generated
	 */
	void setFillingMode(FillingMode value);

	/**
	 * Returns the value of the '<em><b>Filling Queries</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This list registers the queries used to fill the PapyrusTable when it is in Queries Mode
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Filling Queries</em>' reference list.
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrustableconfigurationPackage#getPapyrusTableConfiguration_FillingQueries()
	 * @model
	 * @generated
	 */
	EList<Query> getFillingQueries();

	/**
	 * Returns the value of the '<em><b>Listen Context Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This field references the feature of the context of the table to listen, when the table in is Feature Mode
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Listen Context Feature</em>' reference.
	 * @see #setListenContextFeature(EReference)
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrustableconfigurationPackage#getPapyrusTableConfiguration_ListenContextFeature()
	 * @model
	 * @generated
	 */
	EReference getListenContextFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getListenContextFeature <em>Listen Context Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Listen Context Feature</em>' reference.
	 * @see #getListenContextFeature()
	 * @generated
	 */
	void setListenContextFeature(EReference value);

	/**
	 * Returns the value of the '<em><b>Table Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This field references the emf-facet table configuration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Table Configuration</em>' containment reference.
	 * @see #setTableConfiguration(TableConfiguration)
	 * @see org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrustableconfigurationPackage#getPapyrusTableConfiguration_TableConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	TableConfiguration getTableConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.table.efacet.papyrustableconfiguration.metamodel.papyrustableconfiguration.PapyrusTableConfiguration#getTableConfiguration <em>Table Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table Configuration</em>' containment reference.
	 * @see #getTableConfiguration()
	 * @generated
	 */
	void setTableConfiguration(TableConfiguration value);

} // PapyrusTableConfiguration
