/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.diagram.paletteconfiguration.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ChildConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.LeafConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.SeparatorConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.StackConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration;

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
 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage
 * @generated
 */
public class PaletteconfigurationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PaletteconfigurationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PaletteconfigurationSwitch() {
		if (modelPackage == null) {
			modelPackage = PaletteconfigurationPackage.eINSTANCE;
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
			case PaletteconfigurationPackage.PALETTE_CONFIGURATION: {
				PaletteConfiguration paletteConfiguration = (PaletteConfiguration)theEObject;
				T result = casePaletteConfiguration(paletteConfiguration);
				if (result == null) result = caseConfiguration(paletteConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PaletteconfigurationPackage.TOOL_CONFIGURATION: {
				ToolConfiguration toolConfiguration = (ToolConfiguration)theEObject;
				T result = caseToolConfiguration(toolConfiguration);
				if (result == null) result = caseLeafConfiguration(toolConfiguration);
				if (result == null) result = caseChildConfiguration(toolConfiguration);
				if (result == null) result = caseConfiguration(toolConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PaletteconfigurationPackage.STACK_CONFIGURATION: {
				StackConfiguration stackConfiguration = (StackConfiguration)theEObject;
				T result = caseStackConfiguration(stackConfiguration);
				if (result == null) result = caseChildConfiguration(stackConfiguration);
				if (result == null) result = caseConfiguration(stackConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PaletteconfigurationPackage.CHILD_CONFIGURATION: {
				ChildConfiguration childConfiguration = (ChildConfiguration)theEObject;
				T result = caseChildConfiguration(childConfiguration);
				if (result == null) result = caseConfiguration(childConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PaletteconfigurationPackage.DRAWER_CONFIGURATION: {
				DrawerConfiguration drawerConfiguration = (DrawerConfiguration)theEObject;
				T result = caseDrawerConfiguration(drawerConfiguration);
				if (result == null) result = caseConfiguration(drawerConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PaletteconfigurationPackage.CONFIGURATION: {
				Configuration configuration = (Configuration)theEObject;
				T result = caseConfiguration(configuration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PaletteconfigurationPackage.ICON_DESCRIPTOR: {
				IconDescriptor iconDescriptor = (IconDescriptor)theEObject;
				T result = caseIconDescriptor(iconDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PaletteconfigurationPackage.ELEMENT_DESCRIPTOR: {
				ElementDescriptor elementDescriptor = (ElementDescriptor)theEObject;
				T result = caseElementDescriptor(elementDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PaletteconfigurationPackage.SEPARATOR_CONFIGURATION: {
				SeparatorConfiguration separatorConfiguration = (SeparatorConfiguration)theEObject;
				T result = caseSeparatorConfiguration(separatorConfiguration);
				if (result == null) result = caseLeafConfiguration(separatorConfiguration);
				if (result == null) result = caseChildConfiguration(separatorConfiguration);
				if (result == null) result = caseConfiguration(separatorConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PaletteconfigurationPackage.LEAF_CONFIGURATION: {
				LeafConfiguration leafConfiguration = (LeafConfiguration)theEObject;
				T result = caseLeafConfiguration(leafConfiguration);
				if (result == null) result = caseChildConfiguration(leafConfiguration);
				if (result == null) result = caseConfiguration(leafConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Palette Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Palette Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePaletteConfiguration(PaletteConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tool Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tool Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToolConfiguration(ToolConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stack Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stack Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStackConfiguration(StackConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Child Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Child Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChildConfiguration(ChildConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Drawer Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Drawer Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDrawerConfiguration(DrawerConfiguration object) {
		return null;
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
	public T caseConfiguration(Configuration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Icon Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Icon Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIconDescriptor(IconDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementDescriptor(ElementDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Separator Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Separator Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeparatorConfiguration(SeparatorConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Leaf Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Leaf Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeafConfiguration(LeafConfiguration object) {
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

} //PaletteconfigurationSwitch
