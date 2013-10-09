/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.FCM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.FCM.Target#getTargetArch <em>Target Arch</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.Target#getOptions <em>Options</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.Target#getBase_Node <em>Base Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.Target#getUsedOS <em>Used OS</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.Target#getAvailRAM <em>Avail RAM</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.Target#getAvailROM <em>Avail ROM</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.Target#getCompiler <em>Compiler</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.FCM.FCMPackage#getTarget()
 * @model
 * @generated
 */
public interface Target extends EObject {
	/**
	 * Returns the value of the '<em><b>Target Arch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Arch</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Arch</em>' reference.
	 * @see #setTargetArch(TargetArchitecture)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getTarget_TargetArch()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TargetArchitecture getTargetArch();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.Target#getTargetArch <em>Target Arch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Arch</em>' reference.
	 * @see #getTargetArch()
	 * @generated
	 */
	void setTargetArch(TargetArchitecture value);

	/**
	 * Returns the value of the '<em><b>Options</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.FCM.ConfigOption}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' reference list.
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getTarget_Options()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ConfigOption> getOptions();

	/**
	 * Returns the value of the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Node</em>' reference.
	 * @see #setBase_Node(Node)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getTarget_Base_Node()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Node getBase_Node();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.Target#getBase_Node <em>Base Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Node</em>' reference.
	 * @see #getBase_Node()
	 * @generated
	 */
	void setBase_Node(Node value);

	/**
	 * Returns the value of the '<em><b>Used OS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used OS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used OS</em>' reference.
	 * @see #setUsedOS(OperatingSystem)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getTarget_UsedOS()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OperatingSystem getUsedOS();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.Target#getUsedOS <em>Used OS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used OS</em>' reference.
	 * @see #getUsedOS()
	 * @generated
	 */
	void setUsedOS(OperatingSystem value);

	/**
	 * Returns the value of the '<em><b>Avail RAM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Avail RAM</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Avail RAM</em>' attribute.
	 * @see #setAvailRAM(int)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getTarget_AvailRAM()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getAvailRAM();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.Target#getAvailRAM <em>Avail RAM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Avail RAM</em>' attribute.
	 * @see #getAvailRAM()
	 * @generated
	 */
	void setAvailRAM(int value);

	/**
	 * Returns the value of the '<em><b>Avail ROM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Avail ROM</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Avail ROM</em>' attribute.
	 * @see #setAvailROM(int)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getTarget_AvailROM()
	 * @model dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getAvailROM();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.Target#getAvailROM <em>Avail ROM</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Avail ROM</em>' attribute.
	 * @see #getAvailROM()
	 * @generated
	 */
	void setAvailROM(int value);

	/**
	 * Returns the value of the '<em><b>Compiler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compiler</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compiler</em>' reference.
	 * @see #setCompiler(CompilerChain)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getTarget_Compiler()
	 * @model ordered="false"
	 * @generated
	 */
	CompilerChain getCompiler();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.Target#getCompiler <em>Compiler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compiler</em>' reference.
	 * @see #getCompiler()
	 * @generated
	 */
	void setCompiler(CompilerChain value);

} // Target
