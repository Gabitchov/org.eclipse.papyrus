/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.customization.model.customization.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.customization.model.customization.CustomizableElement;
import org.eclipse.papyrus.customization.model.customization.CustomizationConfiguration;
import org.eclipse.papyrus.customization.model.customization.CustomizationPackage;
import org.eclipse.papyrus.customization.model.customization.FileBasedCustomizableElement;
import org.eclipse.papyrus.customization.model.customization.ModelTemplate;
import org.eclipse.papyrus.customization.model.customization.Palette;
import org.eclipse.papyrus.customization.model.customization.Profile;
import org.eclipse.papyrus.customization.model.customization.PropertyView;
import org.eclipse.papyrus.customization.model.customization.UICustom;
import org.eclipse.papyrus.customization.model.customization.UMLModel;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.customization.model.customization.CustomizationPackage
 * @generated
 */
public class CustomizationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CustomizationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomizationSwitch() {
		if (modelPackage == null) {
			modelPackage = CustomizationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CustomizationPackage.CUSTOMIZATION_CONFIGURATION: {
				CustomizationConfiguration customizationConfiguration = (CustomizationConfiguration)theEObject;
				T result = caseCustomizationConfiguration(customizationConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CustomizationPackage.CUSTOMIZABLE_ELEMENT: {
				CustomizableElement customizableElement = (CustomizableElement)theEObject;
				T result = caseCustomizableElement(customizableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CustomizationPackage.FILE_BASED_CUSTOMIZABLE_ELEMENT: {
				FileBasedCustomizableElement fileBasedCustomizableElement = (FileBasedCustomizableElement)theEObject;
				T result = caseFileBasedCustomizableElement(fileBasedCustomizableElement);
				if (result == null) result = caseCustomizableElement(fileBasedCustomizableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CustomizationPackage.PROPERTY_VIEW: {
				PropertyView propertyView = (PropertyView)theEObject;
				T result = casePropertyView(propertyView);
				if (result == null) result = caseFileBasedCustomizableElement(propertyView);
				if (result == null) result = caseCustomizableElement(propertyView);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CustomizationPackage.UI_CUSTOM: {
				UICustom uiCustom = (UICustom)theEObject;
				T result = caseUICustom(uiCustom);
				if (result == null) result = caseFileBasedCustomizableElement(uiCustom);
				if (result == null) result = caseCustomizableElement(uiCustom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CustomizationPackage.MODEL_TEMPLATE: {
				ModelTemplate modelTemplate = (ModelTemplate)theEObject;
				T result = caseModelTemplate(modelTemplate);
				if (result == null) result = caseFileBasedCustomizableElement(modelTemplate);
				if (result == null) result = caseCustomizableElement(modelTemplate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CustomizationPackage.PALETTE: {
				Palette palette = (Palette)theEObject;
				T result = casePalette(palette);
				if (result == null) result = caseFileBasedCustomizableElement(palette);
				if (result == null) result = caseCustomizableElement(palette);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CustomizationPackage.PROFILE: {
				Profile profile = (Profile)theEObject;
				T result = caseProfile(profile);
				if (result == null) result = caseFileBasedCustomizableElement(profile);
				if (result == null) result = caseCustomizableElement(profile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CustomizationPackage.UML_MODEL: {
				UMLModel umlModel = (UMLModel)theEObject;
				T result = caseUMLModel(umlModel);
				if (result == null) result = caseFileBasedCustomizableElement(umlModel);
				if (result == null) result = caseCustomizableElement(umlModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomizationConfiguration(CustomizationConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Customizable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Customizable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomizableElement(CustomizableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Based Customizable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Based Customizable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileBasedCustomizableElement(FileBasedCustomizableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyView(PropertyView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UI Custom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UI Custom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUICustom(UICustom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Template</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Template</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelTemplate(ModelTemplate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Palette</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Palette</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePalette(Palette object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Profile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Profile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProfile(Profile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UML Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UML Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLModel(UMLModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CustomizationSwitch
