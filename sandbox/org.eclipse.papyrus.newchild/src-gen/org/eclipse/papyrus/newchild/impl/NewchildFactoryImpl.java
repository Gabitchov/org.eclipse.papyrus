/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.newchild.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NewchildFactoryImpl extends EFactoryImpl implements NewchildFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NewchildFactory init() {
		try {
			NewchildFactory theNewchildFactory = (NewchildFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/newchild"); 
			if (theNewchildFactory != null) {
				return theNewchildFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NewchildFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewchildFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case NewchildPackage.NEWCHILD_CONFIGURATION: return createNewchildConfiguration();
			case NewchildPackage.MENU_ROOT: return createMenuRoot();
			case NewchildPackage.MENU: return createMenu();
			case NewchildPackage.MENU_ACTION: return createMenuAction();
			case NewchildPackage.NEW_CHILD_MENU: return createNewChildMenu();
			case NewchildPackage.NEW_SIBLING_MENU: return createNewSiblingMenu();
			case NewchildPackage.SEPARATOR: return createSeparator();
			case NewchildPackage.MENU_GROUP: return createMenuGroup();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case NewchildPackage.ELEMENT_POSITION:
				return createElementPositionFromString(eDataType, initialValue);
			case NewchildPackage.MENU_POSITION:
				return createMenuPositionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case NewchildPackage.ELEMENT_POSITION:
				return convertElementPositionToString(eDataType, instanceValue);
			case NewchildPackage.MENU_POSITION:
				return convertMenuPositionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewchildConfiguration createNewchildConfiguration() {
		NewchildConfigurationImpl newchildConfiguration = new NewchildConfigurationImpl();
		return newchildConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuRoot createMenuRoot() {
		MenuRootImpl menuRoot = new MenuRootImpl();
		return menuRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Menu createMenu() {
		MenuImpl menu = new MenuImpl();
		return menu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuAction createMenuAction() {
		MenuActionImpl menuAction = new MenuActionImpl();
		return menuAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewChildMenu createNewChildMenu() {
		NewChildMenuImpl newChildMenu = new NewChildMenuImpl();
		return newChildMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewSiblingMenu createNewSiblingMenu() {
		NewSiblingMenuImpl newSiblingMenu = new NewSiblingMenuImpl();
		return newSiblingMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Separator createSeparator() {
		SeparatorImpl separator = new SeparatorImpl();
		return separator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuGroup createMenuGroup() {
		MenuGroupImpl menuGroup = new MenuGroupImpl();
		return menuGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementPosition createElementPositionFromString(EDataType eDataType, String initialValue) {
		ElementPosition result = ElementPosition.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertElementPositionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MenuPosition createMenuPositionFromString(EDataType eDataType, String initialValue) {
		MenuPosition result = MenuPosition.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMenuPositionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewchildPackage getNewchildPackage() {
		return (NewchildPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NewchildPackage getPackage() {
		return NewchildPackage.eINSTANCE;
	}

} //NewchildFactoryImpl
