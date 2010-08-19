package org.eclipse.papyrus.sysml.diagram.common.utils;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.resource.NotFoundException;
import org.eclipse.papyrus.resource.uml.UmlModel;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * This class is a Property tester used to check is current model (meaning the model currently opened in Papyrus) is a SysML Model.
 * This class is used in order to create test for deciding whether a diagram creation command should be visible or not.
 * This property tester assumes that currently active editor is Papyrus, it should be used with care (simultaneously with a test to ensure Papyrus is
 * currently opened and active).
 * 
 */
public class SysMLSelectionTester extends PropertyTester {

	/** Tester ID for UML Model nature */
	public final static String IS_SYSML_MODEL = "isSysMLModel"; //$NON-NLS-N$

	/** Default constructor */
	public SysMLSelectionTester() {
	}

	/** Test the receiver against the selected property */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		// Ensure Papyrus is the active editor
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if((editor == null) || (!(editor instanceof PapyrusMultiDiagramEditor))) {
			return false;
		}
		Object currentValue = null;
		if(IS_SYSML_MODEL.equals(property)) {
			currentValue = testSysMLModelNature(receiver);
			return (currentValue == expectedValue);
		}

		return false;
	}

	/** True is root object is a UML Model with SysML Profile (and sub profiles) applied */
	protected boolean testSysMLModelNature(Object receiver) {
		boolean isSysMLModel = false;

		try {
			ServiceUtilsForActionHandlers serviceUtils = new ServiceUtilsForActionHandlers();
			UmlModel openedModel = (UmlModel)serviceUtils.getModelSet().getModel(UmlModel.MODEL_ID);
			if(openedModel != null) {

				EObject root = openedModel.lookupRoot();
				if(root instanceof Package) {
					Profile sysml = ((Package)root).getAppliedProfile(SysmlResource.SYSML_ID);
					if(sysml != null) {
						isSysMLModel = true;
					}
				}
			}

		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}

		return isSysMLModel;
	}

}
