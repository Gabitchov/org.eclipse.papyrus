/**
 */
package org.eclipse.papyrus.facade.virtualmetamodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualClassifier()
 * @model abstract="true"
 * @generated
 */
public interface VirtualClassifier extends VirtualElement {
	/**
	 * Returns the value of the '<em><b>Metamodel</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getVirtualClassifiers <em>Virtual Classifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel</em>' container reference.
	 * @see #setMetamodel(VirtualMetamodel)
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage#getVirtualClassifier_Metamodel()
	 * @see org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel#getVirtualClassifiers
	 * @model opposite="virtualClassifiers" required="true" transient="false"
	 * @generated
	 */
	VirtualMetamodel getMetamodel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier#getMetamodel <em>Metamodel</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metamodel</em>' container reference.
	 * @see #getMetamodel()
	 * @generated
	 */
	void setMetamodel(VirtualMetamodel value);

} // VirtualClassifier
