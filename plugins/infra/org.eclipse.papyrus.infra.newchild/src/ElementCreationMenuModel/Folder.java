/**
 */
package ElementCreationMenuModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ElementCreationMenuModel.Folder#getMenu <em>Menu</em>}</li>
 * </ul>
 * </p>
 *
 * @see ElementCreationMenuModel.ElementCreationMenuModelPackage#getFolder()
 * @model
 * @generated
 */
public interface Folder extends Menu {
	/**
	 * Returns the value of the '<em><b>Menu</b></em>' containment reference list.
	 * The list contents are of type {@link ElementCreationMenuModel.Menu}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Menu</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Menu</em>' containment reference list.
	 * @see ElementCreationMenuModel.ElementCreationMenuModelPackage#getFolder_Menu()
	 * @model containment="true"
	 * @generated
	 */
	EList<Menu> getMenu();

} // Folder
