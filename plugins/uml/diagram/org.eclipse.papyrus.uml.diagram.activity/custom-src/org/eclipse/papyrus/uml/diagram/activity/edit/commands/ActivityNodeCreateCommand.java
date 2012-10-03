package org.eclipse.papyrus.uml.diagram.activity.edit.commands;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * initialize  the emf command  that will add the child element
 * it call the emf command written in the uml plugin. So it called specific code to add nodes into 
 * an Activity
 *
 */
public abstract class ActivityNodeCreateCommand extends EditElementCommand {

	protected Command emfcmd;

	public ActivityNodeCreateCommand(String label, EObject elementToEdit, IEditCommandRequest request) {
		super(label, elementToEdit, request);
	}

	/**
	 * initialize  the emf command  that will add the child element
	 * @return the created child
	 */
	protected Element InitAndExecuteEmfCommand(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		OpaqueAction newElement = UMLFactory.eINSTANCE.createOpaqueAction();
		EReference containmentFeature = PackageUtil.findFeature(getElementToEdit().eClass(),newElement.eClass());
		emfcmd= new CreateChildCommand(getEditingDomain(),getElementToEdit(),  containmentFeature, newElement, Collections.EMPTY_LIST);
		emfcmd.canExecute();
		emfcmd.execute();
		
		return newElement;
	}

	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		emfcmd.undo();
		return super.doUndo(monitor, info);
	}

	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IStatus status= super.doRedo(monitor, info);
		emfcmd.redo();
		 return status;
	}
}
