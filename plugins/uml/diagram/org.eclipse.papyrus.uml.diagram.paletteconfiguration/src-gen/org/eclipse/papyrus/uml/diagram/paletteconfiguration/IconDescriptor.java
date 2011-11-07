/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.diagram.paletteconfiguration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Icon Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Descriptor for icons, constituted from the bundle ID and the path in the bundle.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor#getPluginID <em>Plugin ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor#getIconPath <em>Icon Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getIconDescriptor()
 * @model
 * @generated
 */
public interface IconDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Plugin ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ID of the plugin where the icon is located. If not set, the tool will look in the bundle defining the palette.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Plugin ID</em>' attribute.
	 * @see #setPluginID(String)
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getIconDescriptor_PluginID()
	 * @model
	 * @generated
	 */
	String getPluginID();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor#getPluginID <em>Plugin ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin ID</em>' attribute.
	 * @see #getPluginID()
	 * @generated
	 */
	void setPluginID(String value);

	/**
	 * Returns the value of the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Path of the icon in the bundle. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Icon Path</em>' attribute.
	 * @see #setIconPath(String)
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getIconDescriptor_IconPath()
	 * @model required="true"
	 * @generated
	 */
	String getIconPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor#getIconPath <em>Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Path</em>' attribute.
	 * @see #getIconPath()
	 * @generated
	 */
	void setIconPath(String value);

} // IconDescriptor
