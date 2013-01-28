/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implementation Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link FCM.ImplementationProperties#getSizeRAM <em>Size RAM</em>}</li>
 *   <li>{@link FCM.ImplementationProperties#getSupportedOS <em>Supported OS</em>}</li>
 *   <li>{@link FCM.ImplementationProperties#getArch <em>Arch</em>}</li>
 *   <li>{@link FCM.ImplementationProperties#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link FCM.ImplementationProperties#getSizeROM <em>Size ROM</em>}</li>
 *   <li>{@link FCM.ImplementationProperties#getSupportedTargetArch <em>Supported Target Arch</em>}</li>
 * </ul>
 * </p>
 *
 * @see FCM.FCMPackage#getImplementationProperties()
 * @model
 * @generated
 */
public interface ImplementationProperties extends EObject {
	/**
	 * Returns the value of the '<em><b>Size RAM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size RAM</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size RAM</em>' attribute.
	 * @see #setSizeRAM(int)
	 * @see FCM.FCMPackage#getImplementationProperties_SizeRAM()
	 * @model unique="false" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getSizeRAM();

	/**
	 * Sets the value of the '{@link FCM.ImplementationProperties#getSizeRAM <em>Size RAM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size RAM</em>' attribute.
	 * @see #getSizeRAM()
	 * @generated
	 */
	void setSizeRAM(int value);

	/**
	 * Returns the value of the '<em><b>Supported OS</b></em>' reference list.
	 * The list contents are of type {@link FCM.OperatingSystem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supported OS</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supported OS</em>' reference list.
	 * @see FCM.FCMPackage#getImplementationProperties_SupportedOS()
	 * @model ordered="false"
	 * @generated
	 */
	EList<OperatingSystem> getSupportedOS();

	/**
	 * Returns the value of the '<em><b>Arch</b></em>' reference list.
	 * The list contents are of type {@link FCM.TargetArchitecture}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arch</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arch</em>' reference list.
	 * @see FCM.FCMPackage#getImplementationProperties_Arch()
	 * @model ordered="false"
	 * @generated
	 */
	EList<TargetArchitecture> getArch();

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see FCM.FCMPackage#getImplementationProperties_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link FCM.ImplementationProperties#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Size ROM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size ROM</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size ROM</em>' attribute.
	 * @see #setSizeROM(int)
	 * @see FCM.FCMPackage#getImplementationProperties_SizeROM()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getSizeROM();

	/**
	 * Sets the value of the '{@link FCM.ImplementationProperties#getSizeROM <em>Size ROM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size ROM</em>' attribute.
	 * @see #getSizeROM()
	 * @generated
	 */
	void setSizeROM(int value);

	/**
	 * Returns the value of the '<em><b>Supported Target Arch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supported Target Arch</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supported Target Arch</em>' reference.
	 * @see #setSupportedTargetArch(TargetArchitecture)
	 * @see FCM.FCMPackage#getImplementationProperties_SupportedTargetArch()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TargetArchitecture getSupportedTargetArch();

	/**
	 * Sets the value of the '{@link FCM.ImplementationProperties#getSupportedTargetArch <em>Supported Target Arch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supported Target Arch</em>' reference.
	 * @see #getSupportedTargetArch()
	 * @generated
	 */
	void setSupportedTargetArch(TargetArchitecture value);

} // ImplementationProperties
