package org.eclipse.papyrus.uml.properties.creation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A specific factory for the Connector#type property
 * This property should be constrained to Associations and AssociationClasses
 * 
 * @author Camille Letavernier
 */
public class ConnectorTypeEditorFactory extends UMLPropertyEditorFactory {

	public ConnectorTypeEditorFactory(EReference referenceIn) {
		super(referenceIn);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<EClass> getAvailableEClasses() {
		List<EClass> availableEClasses = new LinkedList<EClass>();
		availableEClasses.add(UMLPackage.eINSTANCE.getAssociation());
		availableEClasses.add(UMLPackage.eINSTANCE.getAssociationClass());
		//Collections.sort(availableEClasses, new EClassNameComparator());
		return availableEClasses;
	}
}
