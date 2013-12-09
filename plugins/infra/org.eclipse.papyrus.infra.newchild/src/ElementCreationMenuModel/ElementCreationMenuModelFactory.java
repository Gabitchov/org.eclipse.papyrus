/**
 */
package ElementCreationMenuModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see ElementCreationMenuModel.ElementCreationMenuModelPackage
 * @generated
 */
public interface ElementCreationMenuModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ElementCreationMenuModelFactory eINSTANCE = ElementCreationMenuModel.impl.ElementCreationMenuModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Folder</em>'.
	 * @generated
	 */
	Folder createFolder();

	/**
	 * Returns a new object of class '<em>Creation Menu</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Creation Menu</em>'.
	 * @generated
	 */
	CreationMenu createCreationMenu();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ElementCreationMenuModelPackage getElementCreationMenuModelPackage();

} //ElementCreationMenuModelFactory
