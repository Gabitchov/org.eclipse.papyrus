/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.gmf.codegen.gmfgen.GenChildNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Diagram Updater</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class is used to precise itw own locator used for the border item, like port or template.
 * 
 * for example, in the case of templateSignature of ClassEditPart in the method protected boolean addFixedChild(EditPart childEditPart):
 * replacement of the general BorderItemLocator is needed in order to constrain the movement. 
 * 
 * if (childEditPart instanceof RedefinableTemplateSignatureEditPart) {
 *    // BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.NORTH);
 *    BorderItemLocator locator = new TemplateClassifierBorderItemLocator(getMainFigure(), PositionConstants.NORTH);
 *    getBorderedFigure().getBorderItemContainer().add(((RedefinableTemplateSignatureEditPart) childEditPart).getFigure(), locator);
 *    return true;
 * }
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater#getGenChildNode <em>Gen Child Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getSpecificDiagramUpdater()
 * @model
 * @generated
 */
public interface SpecificDiagramUpdater extends ExternalHook {
	/**
	 * Returns the value of the '<em><b>Gen Child Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Child Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Child Node</em>' reference.
	 * @see #setGenChildNode(GenChildNode)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getSpecificDiagramUpdater_GenChildNode()
	 * @model
	 * @generated
	 */
	GenChildNode getGenChildNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificDiagramUpdater#getGenChildNode <em>Gen Child Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Child Node</em>' reference.
	 * @see #getGenChildNode()
	 * @generated
	 */
	void setGenChildNode(GenChildNode value);

} // SpecificDiagramUpdater
