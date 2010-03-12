/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.providers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.edit.command.CopyToClipboardCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.providers.ImageSupportGlobalActionHandler;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.ui.properties.actions.PropertyPageViewAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.diagram.common.command.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.helper.CleanDiagramHelper;
import org.eclipse.papyrus.diagram.common.request.PasteRequest;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;

/**
 * this class has in charge to launch command for cut copy paste (graphically) it is also used to launch the copy into bmp like as writer software 
 *
 */
@SuppressWarnings("restriction")
public class PapyrusDiagramGlobalActionHandler extends ImageSupportGlobalActionHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionHandler#getCommand(org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext)
	 */
	public ICommand getCommand(IGlobalActionContext cntxt) {
		/* Check if the active part is a IDiagramWorkbenchPart */
		IWorkbenchPart part = cntxt.getActivePart();
		if (!(part instanceof IDiagramWorkbenchPart)) {
			return null;
		}

		/* Get the model operation context */
		IDiagramWorkbenchPart diagramPart = (IDiagramWorkbenchPart) part;

		/* Create a command */
		ICommand command = null;

		/* Check the action id */
		String actionId = cntxt.getActionId();
		if (actionId.equals(GlobalActionId.DELETE)) {
			CompoundCommand deleteCC = getDeleteCommand(diagramPart, cntxt);
			/* Set the command */
			if (deleteCC != null && deleteCC.canExecute())
				command = new CommandProxy(deleteCC);
		} else if (actionId.equals(GlobalActionId.COPY)) {
			command = getCopyCommand(cntxt, diagramPart, false);
		} else if (actionId.equals(GlobalActionId.CUT)) {
			command = getCutCommand(cntxt, diagramPart);
		} else if (actionId.equals(GlobalActionId.PASTE)) {

			/* Get the selected edit parts */
			Object[] objectsArray = ((IStructuredSelection) cntxt.getSelection())
			.toArray();

			if(objectsArray.length>0 && objectsArray[0] instanceof GraphicalEditPart){
				/* Send the request to the target edit part of the paste command for the currently selected part */
				PasteRequest pasteRequest = new PasteRequest(((GraphicalEditPart)objectsArray[0]).getEditingDomain().getClipboard());
				org.eclipse.gef.commands.Command pasteCommand=((GraphicalEditPart)objectsArray[0]).getCommand(pasteRequest);
				if(pasteCommand!=null){
					((GraphicalEditPart)objectsArray[0]).getEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(pasteCommand));
					RootEditPart topEditPart=((GraphicalEditPart)objectsArray[0]).getRoot();
					if(topEditPart.getChildren().get(0) instanceof DiagramEditPart){
					CleanDiagramHelper.getInstance().run((DiagramEditPart)topEditPart.getChildren().get(0));
				}
				}
			}
		} else if (actionId.equals(GlobalActionId.SAVE)) {
			part.getSite().getPage().saveEditor((IEditorPart) diagramPart,
				false);
		} else if (actionId.equals(GlobalActionId.PROPERTIES)) {
			new PropertyPageViewAction().run();
		}

		return command;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#getCopyCommand(org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext, org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart, boolean)
	 *this class also copy in the clipboard of the editing domain selected elements
	 * 
	 */

	@Override
	protected ICommand getCopyCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart, boolean isUndoable) {
		/* Get the selected edit parts */
		Object[] objectsArray = ((IStructuredSelection) cntxt.getSelection()).toArray();
		CompositeCommand compositeCommand= new CompositeCommand(GlobalActionId.COPY);
		if(objectsArray.length>0 && objectsArray[0] instanceof GraphicalEditPart){
			//((GraphicalEditPart)objectsArray[0]).getEditingDomain().setClipboard(((IStructuredSelection) cntxt.getSelection()).toList());
			compositeCommand.add(new EMFtoGMFCommandWrapper(CopyToClipboardCommand.create(((GraphicalEditPart)objectsArray[0]).getEditingDomain(), getNotation(((IStructuredSelection) cntxt.getSelection()).toList()))));
		}
		compositeCommand.add( super.getCopyCommand(cntxt, diagramPart, isUndoable));
		return compositeCommand;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler#getCutCommand(org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext, org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart)
	 *
	 * @param cntxt
	 * @param diagramPart
	 * @return
	 */

	@Override
	protected ICommand getCutCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart) {
		Object[] objectsArray = ((IStructuredSelection) cntxt.getSelection()).toArray();
		CompositeCommand compositeCommand= new CompositeCommand(GlobalActionId.CUT);
		if(objectsArray.length>0 && objectsArray[0] instanceof GraphicalEditPart){
			//((GraphicalEditPart)objectsArray[0]).getEditingDomain().setClipboard(((IStructuredSelection) cntxt.getSelection()).toList());
			compositeCommand.add(new EMFtoGMFCommandWrapper(CopyToClipboardCommand.create(((GraphicalEditPart)objectsArray[0]).getEditingDomain(), getNotation(((IStructuredSelection) cntxt.getSelection()).toList()))));

		}
		ICommand cutCommand=super.getCutCommand(cntxt, diagramPart);
		if(cutCommand!=null){
			compositeCommand.add(cutCommand);
		}
		return compositeCommand;
	}



	/**
	 * Returns appropriate delete command for this context.
	 * 
	 * @param part the workbench part
	 * @param cntxt
	 *            the <code>IGlobalActionContext</code> holding the necessary
	 *            information needed by this action handler
	 * @return CompoundCommand command
	 */
	private CompoundCommand getDeleteCommand(IDiagramWorkbenchPart part,
		IGlobalActionContext cntxt) {
		/* Create the delete request */
		GroupRequest deleteReq = new GroupRequest(RequestConstants.REQ_DELETE);

		CompoundCommand deleteCC = new CompoundCommand(cntxt.getLabel());

		TransactionalEditingDomain editingDomain = getEditingDomain(part);

		if (editingDomain == null) {
			return deleteCC;
		}

		CompositeTransactionalCommand compositeCommand = new CompositeTransactionalCommand(editingDomain, 
			cntxt.getLabel());
		/* Get the selected edit parts */
		Object[] objects = ((IStructuredSelection) cntxt.getSelection())
		.toArray();
		for (int i = 0; i < objects.length; i++) {
			/* Get the next part */
			EditPart editPart = (EditPart) objects[i];

			/* Send the request to the edit part */
			org.eclipse.gef.commands.Command command = editPart.getCommand(deleteReq);
			if (command != null)
				compositeCommand.compose(new CommandProxy(command));
			// deleteCC.add(editPart.getCommand(deleteReq));
		}
		if (!compositeCommand.isEmpty()) {
			deleteCC.add(new ICommandProxy(compositeCommand));
		}

		return deleteCC;
	}
	/**
	 * Gets the transactional editing domain associated with the workbench
	 * <code>part</code>.
	 * 
	 * @param part
	 *            the diagram workbench part
	 * @return the editing domain, or <code>null</code> if there is none.
	 */
	private TransactionalEditingDomain getEditingDomain(
		IDiagramWorkbenchPart part) {

		TransactionalEditingDomain result = null;

		IEditingDomainProvider provider = (IEditingDomainProvider) part
		.getAdapter(IEditingDomainProvider.class);

		if (provider != null) {
			EditingDomain domain = provider.getEditingDomain();

			if (domain != null && domain instanceof TransactionalEditingDomain) {
				result = (TransactionalEditingDomain) domain;
			}        }

		return result;
	}
	
	
	/**
	 * get the list of notation element from the a list of editpart
	 * @param editPartList the list of editpart
	 * @return the list of notation element
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected List getNotation(List editPartList){
		ArrayList notationList= new ArrayList();
		Iterator iterator=editPartList.iterator();
		while(iterator.hasNext()) {
			Object object = (Object)iterator.next();
			if( object instanceof EditPart){
				notationList.add(((EditPart)object).getModel());
			}
		}
		return notationList;
	}
}
