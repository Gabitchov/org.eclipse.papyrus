package org.eclipse.papyrus.diagram.common.actions;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.DuplicateRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.helper.CleanDiagramHelper;
import org.eclipse.papyrus.pastemanager.command.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.pastemanager.command.PapyrusDuplicateWrapperCommand;
import org.eclipse.papyrus.pastemanager.service.PasteCommandService;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;


public class PasteWithModelAction implements IObjectActionDelegate {

	protected GraphicalEditPart targetEditPart=null;

	public void run(IAction action) {

		/* Get the selected edit parts */

		if(targetEditPart != null){
			//get the paste command with model form the service
			ICommand pastecommand=PasteCommandService.getInstance().getPasteWithModelCommand(targetEditPart, Toolkit.getDefaultToolkit().getSystemClipboard(), targetEditPart.getEditingDomain().getClipboard());

			if(pastecommand.canExecute() ){
				targetEditPart.getEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(pastecommand));
				RootEditPart topEditPart=targetEditPart.getRoot();
				if(topEditPart.getChildren().get(0) instanceof DiagramEditPart){
					CleanDiagramHelper.getInstance().run((DiagramEditPart)topEditPart.getChildren().get(0));
				}
			}
		}
	}


	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection){
			Object selectedElement=((IStructuredSelection)selection).getFirstElement();
			if (selectedElement instanceof GraphicalEditPart){
				targetEditPart=(GraphicalEditPart)selectedElement;
			}
		}

	}


	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub

	}

}
