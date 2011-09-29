/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.documentation.plugin.documentation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specify a dependency when a plug-in needs a non-java file in another plug-in.
 * 
 * For example, this dependency can be used when a plug-in needs to have an access to a model in another plug-in.
 * 
 * The file can be either a file or a folder
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.documentation.plugin.documentation.FileDependency#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.documentation.plugin.documentation.DocumentationPackage#getFileDependency()
 * @model
 * @generated
 */
public interface FileDependency extends Dependency {
	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(String)
	 * @see org.eclipse.papyrus.documentation.plugin.documentation.DocumentationPackage#getFileDependency_File()
	 * @model required="true"
	 * @generated
	 */
	String getFile();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.documentation.plugin.documentation.FileDependency#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(String value);

} // FileDependency
