package org.eclipse.papyrus.diagram.common.util;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.resource.NotFoundException;
import org.eclipse.papyrus.resource.uml.UmlModel;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;

/**
 * This class is a Property tester used to check is current model (meaning the model currently opened in Papyrus) is a UML Model or a UML Profile.
 * This class is used in order to create test for deciding whether a diagram creation command should be visible or not. 
 * This property tester assumes that currently active editor is Papyrus, it should be used with care (simultaneously with a test to ensure Papyrus is currently opened and active).
 */
public class UMLSelectionTester extends PropertyTester {

	/** Tester ID for UML Model nature */
	public final static String IS_UML_MODEL = "isUMLModel"; //$NON-NLS-N$

	/** Tester ID for UML Profile nature */
	public final static String IS_UML_PROFILE = "isUMLProfile"; //$NON-NLS-N$

	/** Default constructor */
	public UMLSelectionTester() {
	}

	/** Test the receiver against the selected property */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		Object currentValue = null;
		if (IS_UML_MODEL.equals(property)) {
			currentValue = testUMLModelNature(receiver);
			return (currentValue == expectedValue);
		} else if (IS_UML_PROFILE.equals(property)) {
			currentValue = testUMLProfileNature(receiver);
			return (currentValue == expectedValue);
		}

		return false;
	}

	/** True is root object is a UML Model */
	protected boolean testUMLModelNature(Object receiver) {
		return (getRoot() instanceof Model);
	}

	/** True is root object is a UML Profile */
	protected boolean testUMLProfileNature(Object receiver) {
		return (getRoot() instanceof Profile);
	}

	/** Returns the root EObject of currently opened model */
	private EObject getRoot() {
		EObject root = null;

		try {
			PapyrusMultiDiagramEditor activeEditor = (PapyrusMultiDiagramEditor) PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage().getActiveEditor();

			if (activeEditor != null) {

				UmlModel openedModel = (UmlModel) ServiceUtilsForGMF.getInstance()
						.getModelSet(activeEditor.getServicesRegistry()).getModel(UmlModel.MODEL_ID);
				root = openedModel.lookupRoot();
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}

		return root;
	}
}
