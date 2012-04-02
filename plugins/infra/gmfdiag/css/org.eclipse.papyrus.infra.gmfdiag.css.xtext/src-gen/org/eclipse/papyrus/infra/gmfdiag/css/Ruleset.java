/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ruleset</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Ruleset#getSelectors <em>Selectors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.css.Ruleset#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getRuleset()
 * @model
 * @generated
 */
public interface Ruleset extends Content
{
  /**
   * Returns the value of the '<em><b>Selectors</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css.Selector}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Selectors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Selectors</em>' containment reference list.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getRuleset_Selectors()
   * @model containment="true"
   * @generated
   */
  EList<Selector> getSelectors();

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.infra.gmfdiag.css.Declaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see org.eclipse.papyrus.infra.gmfdiag.css.CssPackage#getRuleset_Properties()
   * @model containment="true"
   * @generated
   */
  EList<Declaration> getProperties();

} // Ruleset
