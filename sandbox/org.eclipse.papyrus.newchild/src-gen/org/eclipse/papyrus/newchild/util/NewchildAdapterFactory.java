/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.newchild.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.constraints.DisplayUnit;
import org.eclipse.papyrus.newchild.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.newchild.NewchildPackage
 * @generated
 */
public class NewchildAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NewchildPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewchildAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = NewchildPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NewchildSwitch<Adapter> modelSwitch =
		new NewchildSwitch<Adapter>() {
			@Override
			public Adapter caseNewchildConfiguration(NewchildConfiguration object) {
				return createNewchildConfigurationAdapter();
			}
			@Override
			public Adapter caseMenuRoot(MenuRoot object) {
				return createMenuRootAdapter();
			}
			@Override
			public Adapter caseMenuItem(MenuItem object) {
				return createMenuItemAdapter();
			}
			@Override
			public Adapter caseMenuContainer(MenuContainer object) {
				return createMenuContainerAdapter();
			}
			@Override
			public Adapter caseMenu(Menu object) {
				return createMenuAdapter();
			}
			@Override
			public Adapter caseMenuAction(MenuAction object) {
				return createMenuActionAdapter();
			}
			@Override
			public Adapter caseNewChildMenu(NewChildMenu object) {
				return createNewChildMenuAdapter();
			}
			@Override
			public Adapter caseNewSiblingMenu(NewSiblingMenu object) {
				return createNewSiblingMenuAdapter();
			}
			@Override
			public Adapter caseSeparator(Separator object) {
				return createSeparatorAdapter();
			}
			@Override
			public Adapter caseMenuGroup(MenuGroup object) {
				return createMenuGroupAdapter();
			}
			@Override
			public Adapter caseDisplayUnit(DisplayUnit object) {
				return createDisplayUnitAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.newchild.NewchildConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.newchild.NewchildConfiguration
	 * @generated
	 */
	public Adapter createNewchildConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.newchild.MenuRoot <em>Menu Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.newchild.MenuRoot
	 * @generated
	 */
	public Adapter createMenuRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.newchild.MenuItem <em>Menu Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.newchild.MenuItem
	 * @generated
	 */
	public Adapter createMenuItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.newchild.MenuContainer <em>Menu Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.newchild.MenuContainer
	 * @generated
	 */
	public Adapter createMenuContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.newchild.Menu <em>Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.newchild.Menu
	 * @generated
	 */
	public Adapter createMenuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.newchild.MenuAction <em>Menu Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.newchild.MenuAction
	 * @generated
	 */
	public Adapter createMenuActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.newchild.NewChildMenu <em>New Child Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.newchild.NewChildMenu
	 * @generated
	 */
	public Adapter createNewChildMenuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.newchild.NewSiblingMenu <em>New Sibling Menu</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.newchild.NewSiblingMenu
	 * @generated
	 */
	public Adapter createNewSiblingMenuAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.newchild.Separator <em>Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.newchild.Separator
	 * @generated
	 */
	public Adapter createSeparatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.newchild.MenuGroup <em>Menu Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.newchild.MenuGroup
	 * @generated
	 */
	public Adapter createMenuGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.constraints.DisplayUnit <em>Display Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.constraints.DisplayUnit
	 * @generated
	 */
	public Adapter createDisplayUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //NewchildAdapterFactory
