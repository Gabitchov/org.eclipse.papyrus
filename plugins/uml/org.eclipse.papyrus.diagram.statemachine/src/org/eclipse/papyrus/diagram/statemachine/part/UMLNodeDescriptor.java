package org.eclipse.papyrus.diagram.statemachine.part;

import org.eclipse.emf.ecore.EObject;

/**
 * @generated
 */
@SuppressWarnings("unchecked")
public class UMLNodeDescriptor {

	/**
	 * @generated
	 */
	private EObject myModelElement;

	/**
	 * @generated
	 */
	private int myVisualID;

	/**
	 * @generated
	 */
	private String myType;

	/**
	 * @generated
	 */
	public UMLNodeDescriptor(EObject modelElement, int visualID) {
		myModelElement = modelElement;
		myVisualID = visualID;
	}

	/**
	 * @generated
	 */
	public EObject getModelElement() {
		return myModelElement;
	}

	/**
	 * @generated
	 */
	public int getVisualID() {
		return myVisualID;
	}

	/**
	 * @generated
	 */
	public String getType() {
		if(myType == null) {
			myType = UMLVisualIDRegistry.getType(getVisualID());
		}
		return myType;
	}

}
