/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specific Locator External Label</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * This class is used to precise itw own locator used for the border item, like port or template.
 * 
 * for example, in the case of templateSignature of ClassEditPart in the method protected boolean addFixedChild(EditPart childEditPart):
 * replacement of the general BorderItemLocator is needed in order to constrain the movement.
 * 
 * if (childEditPart instanceof RedefinableTemplateSignatureEditPart) {
 * // BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.NORTH);
 * BorderItemLocator locator = new TemplateClassifierBorderItemLocator(getMainFigure(), PositionConstants.NORTH);
 * getBorderedFigure().getBorderItemContainer().add(((RedefinableTemplateSignatureEditPart) childEditPart).getFigure(), locator);
 * return true;
 * }
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel#getGenExternalNodeLabel <em>Gen External Node Label</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getSpecificLocatorExternalLabel()
 * @model
 * @generated
 */
public interface SpecificLocatorExternalLabel extends ExternalHook {

	/**
	 * Returns the value of the '<em><b>Gen External Node Label</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen External Node Label</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Gen External Node Label</em>' reference list.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getSpecificLocatorExternalLabel_GenExternalNodeLabel()
	 * @model
	 * @generated
	 */
	EList<GenExternalNodeLabel> getGenExternalNodeLabel();

} // SpecificLocatorExternalLabel
