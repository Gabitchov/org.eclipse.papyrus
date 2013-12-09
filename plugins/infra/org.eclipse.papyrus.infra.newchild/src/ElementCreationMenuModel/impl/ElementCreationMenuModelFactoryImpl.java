/**
 */
package ElementCreationMenuModel.impl;

import ElementCreationMenuModel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ElementCreationMenuModelFactoryImpl extends EFactoryImpl implements ElementCreationMenuModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("javadoc")
	public static ElementCreationMenuModelFactory init() {
		try {
			ElementCreationMenuModelFactory theElementCreationMenuModelFactory = (ElementCreationMenuModelFactory)EPackage.Registry.INSTANCE.getEFactory(ElementCreationMenuModelPackage.eNS_URI);
			if (theElementCreationMenuModelFactory != null) {
				return theElementCreationMenuModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ElementCreationMenuModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementCreationMenuModelFactoryImpl() {
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
			case ElementCreationMenuModelPackage.FOLDER: return createFolder();
			case ElementCreationMenuModelPackage.CREATION_MENU: return createCreationMenu();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder createFolder() {
		FolderImpl folder = new FolderImpl();
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreationMenu createCreationMenu() {
		CreationMenuImpl creationMenu = new CreationMenuImpl();
		return creationMenu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementCreationMenuModelPackage getElementCreationMenuModelPackage() {
		return (ElementCreationMenuModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@SuppressWarnings("javadoc")
	@Deprecated
	public static ElementCreationMenuModelPackage getPackage() {
		return ElementCreationMenuModelPackage.eINSTANCE;
	}

} //ElementCreationMenuModelFactoryImpl
