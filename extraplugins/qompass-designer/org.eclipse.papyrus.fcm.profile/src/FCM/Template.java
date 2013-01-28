/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The template parameters list defines the parameters that are passed to the Acceleo template. If empty, the formal parameter list of the package template is used.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link FCM.Template#getTemplateParams <em>Template Params</em>}</li>
 *   <li>{@link FCM.Template#getBase_Element <em>Base Element</em>}</li>
 *   <li>{@link FCM.Template#getKind <em>Kind</em>}</li>
 *   <li>{@link FCM.Template#getActualChoice <em>Actual Choice</em>}</li>
 * </ul>
 * </p>
 *
 * @see FCM.FCMPackage#getTemplate()
 * @model
 * @generated
 */
public interface Template extends EObject {
	/**
	 * Returns the value of the '<em><b>Template Params</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Classifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Params</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Params</em>' reference list.
	 * @see FCM.FCMPackage#getTemplate_TemplateParams()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Classifier> getTemplateParams();

	/**
	 * Returns the value of the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Element</em>' reference.
	 * @see #setBase_Element(Element)
	 * @see FCM.FCMPackage#getTemplate_Base_Element()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Element getBase_Element();

	/**
	 * Sets the value of the '{@link FCM.Template#getBase_Element <em>Base Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Element</em>' reference.
	 * @see #getBase_Element()
	 * @generated
	 */
	void setBase_Element(Element value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link FCM.TemplateKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see FCM.TemplateKind
	 * @see #setKind(TemplateKind)
	 * @see FCM.FCMPackage#getTemplate_Kind()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	TemplateKind getKind();

	/**
	 * Sets the value of the '{@link FCM.Template#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see FCM.TemplateKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(TemplateKind value);

	/**
	 * Returns the value of the '<em><b>Actual Choice</b></em>' attribute.
	 * The literals are from the enumeration {@link FCM.ActualChoice}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Choice</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Choice</em>' attribute.
	 * @see FCM.ActualChoice
	 * @see #setActualChoice(ActualChoice)
	 * @see FCM.FCMPackage#getTemplate_ActualChoice()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	ActualChoice getActualChoice();

	/**
	 * Sets the value of the '{@link FCM.Template#getActualChoice <em>Actual Choice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual Choice</em>' attribute.
	 * @see FCM.ActualChoice
	 * @see #getActualChoice()
	 * @generated
	 */
	void setActualChoice(ActualChoice value);

} // Template
