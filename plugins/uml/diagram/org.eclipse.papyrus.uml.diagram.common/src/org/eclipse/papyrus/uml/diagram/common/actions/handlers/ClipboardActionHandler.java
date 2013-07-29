/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Mario Cervera Ubeda (Integranova)
 * 				 Marc Gil Sendra (Prodevelop)
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.actions.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CopyToClipboardCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.commands.AbstractCommonTransactionalCommmand;
import org.eclipse.papyrus.uml.diagram.common.commands.AddEObjectReferencesToDiagram;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ViewAndFeatureResolver;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.common.util.MDTUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * The Class ClipboardActionHandler.
 */
public/* abstract */class ClipboardActionHandler extends DiagramGlobalActionHandler {

	/*
	 * Specifies whether the last executed action was a cut action or not. This
	 * is needed because the paste action will vary depending on it
	 */
	/** The is cut. */
	private static boolean isCut = false;

	/* Container of the objects in the clipboard */
	/** The container. */
	private static EObject container = null;

	/* Objects in the clipboard */
	/** The clipboard. */
	protected static List<EObject> clipboard = new ArrayList<EObject>();

	/* Edit parts of the objects in the clipboard */
	/** The edit parts in clipboard. */
	protected static List<EditPart> editPartsInClipboard = new ArrayList<EditPart>();

	// @unused
	protected static List<Object> clipboardElements = new ArrayList<Object>();

	// @unused
	public void setContainer(EObject container) {
		ClipboardActionHandler.container = container;
	}

	public EObject getContainer() {
		return ClipboardActionHandler.container;
	}

	// @unused
	public boolean getIsCut() {
		return isCut;
	}

	// @unused
	public void setIsCut(boolean isCut) {
		ClipboardActionHandler.isCut = isCut;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler
	 * #canCopy(org.eclipse.gmf.runtime.common.ui.services.action.global.
	 * IGlobalActionContext)
	 */
	@Override
	protected boolean canCopy(IGlobalActionContext cntxt) {

		if(cntxt.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection)cntxt.getSelection()).getFirstElement();
			if(firstElement instanceof IGraphicalEditPart) {
				EObject eobject = ((IGraphicalEditPart)firstElement).resolveSemanticElement();
				if(eobject != null) {
					List elements = ((StructuredSelection)cntxt.getSelection()).toList();
					List<EObject> eobjects = new ArrayList<EObject>();
					for(Object o : elements) {
						EObject eobj = ((IGraphicalEditPart)o).resolveSemanticElement();
						eobjects.add(eobj);
					}
					if(!allElementsSameType(eobjects, eobject)) {
						return false;
					}
					IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
					if(editorPart instanceof DiagramEditor) {
						if(((DiagramEditor)editorPart).getDiagram().getElement().equals(eobject)) {
							return false;
						}
					}
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler
	 * #canCut(org.eclipse.gmf.runtime.common.ui.services.action.global.
	 * IGlobalActionContext)
	 */
	@Override
	protected boolean canCut(IGlobalActionContext cntxt) {

		return canCopy(cntxt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler
	 * #canPaste(org.eclipse.gmf.runtime.common.ui.services.action.global.
	 * IGlobalActionContext)
	 */
	@Override
	protected boolean canPaste(IGlobalActionContext cntxt) {

		if(cntxt.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection)cntxt.getSelection()).getFirstElement();
			if(firstElement instanceof IGraphicalEditPart) {
				IGraphicalEditPart pasteDestination = ((IGraphicalEditPart)firstElement);
				if(pasteDestination != null && pasteDestination.resolveSemanticElement() != null && (!pasteDestination.resolveSemanticElement().equals(container) || !isCut)) {
					TransactionalEditingDomain domain = pasteDestination.getEditingDomain();
					if(domain.getClipboard() != null && domain.getClipboard().size() > 0) {
						// All the elements in the clipboard are of the same
						// type
						Object[] objects = domain.getClipboard().toArray();
						EObject firstObjectToBePasted = (EObject)objects[0];
						EStructuralFeature feature = getFeature(firstObjectToBePasted, pasteDestination);
						if(feature != null) {
							if(feature.getEType().getInstanceClass().isInstance(firstObjectToBePasted)) {
								return true;
							}
						}
					}
				}
			}
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler
	 * #getCommand(org.eclipse.gmf.runtime.common.ui.services.action.global.
	 * IGlobalActionContext)
	 */
	@Override
	public ICommand getCommand(IGlobalActionContext cntxt) {

		IWorkbenchPart part = cntxt.getActivePart();
		if(!(part instanceof IDiagramWorkbenchPart)) {
			return null;
		}

		/* Get the model operation context */
		IDiagramWorkbenchPart diagramPart = (IDiagramWorkbenchPart)part;

		String actionId = cntxt.getActionId();

		if(actionId.equals(GlobalActionId.COPY)) {
			isCut = false;
			return getCopyCommand(cntxt, diagramPart, false);
		} else if(actionId.equals(GlobalActionId.CUT)) {
			isCut = true;
			return getCutCommand(cntxt, diagramPart);
		} else if(actionId.equals(GlobalActionId.PASTE)) {
			if(isCut) {
				isCut = false;
				return getExecutePasteAfterCutCommand(cntxt);
			} else {
				isCut = false;
				return getExecutePasteAfterCopyCommand(cntxt);
			}
		}

		return super.getCommand(cntxt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler
	 * #getCopyCommand(org.eclipse.gmf.runtime.common.ui.services.action.global.
	 * IGlobalActionContext,
	 * org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart, boolean)
	 */
	@Override
	protected ICommand getCopyCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart, boolean isUndoable) {

		if(cntxt.getSelection() instanceof StructuredSelection) {
			// All the elements in the selection are supposed to be of the same
			// time
			// We couldn't have got here otherwise
			Object firstElement = ((StructuredSelection)cntxt.getSelection()).getFirstElement();
			EObject eobject = ((IGraphicalEditPart)firstElement).resolveSemanticElement();
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eobject);
			List elements = ((StructuredSelection)cntxt.getSelection()).toList();
			List<EObject> eobjects = new ArrayList<EObject>();
			editPartsInClipboard.clear();
			for(Object o : elements) {
				EObject eobj = ((IGraphicalEditPart)o).resolveSemanticElement();
				eobjects.add(eobj);
				container = eobj.eContainer();

				for(Object view : DiagramEditPartsUtil.getEObjectViews(eobj)) {
					if(view instanceof View) {
						EditPart editpart = DiagramEditPartsUtil.getEditPartFromView((View)view, (EditPart)firstElement);
						editPartsInClipboard.add(editpart);
					}
				}
			}

			clipboard.clear();
			clipboard.addAll(eobjects);

			final List<EObject> eobjects2 = eobjects;
			Command copyCommand = new CopyToClipboardCommand(domain, eobjects) {

				@Override
				public void doExecute() {

					/**
					 * @author mgil : Don't use a different command to copy
					 *         every element, use the copy function from
					 *         EcoreUtil
					 */
					ArrayList<Object> list = new ArrayList<Object>();
					for(EObject eobj : eobjects2) {
						EObject eo = EcoreUtil.copy(eobj);
						list.add(eo);
					}

					oldClipboard = domain.getClipboard();
					domain.setClipboard(list);
				}
			};

			if(copyCommand != null) {
				return new EMFtoGMFCommandWrapper(copyCommand);
			}
		}

		return super.getCopyCommand(cntxt, diagramPart, isUndoable);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler
	 * #getCutCommand(org.eclipse.gmf.runtime.common.ui.services.action.global.
	 * IGlobalActionContext,
	 * org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart)
	 */
	@Override
	protected ICommand getCutCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart) {

		if(cntxt.getSelection() instanceof StructuredSelection) {
			// All the elements in the selection are supposed to be of the same
			// type
			// We couldn't have got here otherwise
			Object firstElement = ((StructuredSelection)cntxt.getSelection()).getFirstElement();
			EObject eobject = ((IGraphicalEditPart)firstElement).resolveSemanticElement();
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eobject);
			List elements = ((StructuredSelection)cntxt.getSelection()).toList();
			List<EObject> eobjects = new ArrayList<EObject>();
			editPartsInClipboard.clear();
			for(Object o : elements) {
				EObject eobj = ((IGraphicalEditPart)o).resolveSemanticElement();
				eobjects.add(eobj);
				container = eobj.eContainer();

				for(Object view : DiagramEditPartsUtil.getEObjectViews(eobj)) {
					if(view instanceof View) {
						EditPart editpart = DiagramEditPartsUtil.getEditPartFromView((View)view, (EditPart)firstElement);
						editPartsInClipboard.add(editpart);
					}
				}
			}

			clipboard.clear();
			clipboard.addAll(eobjects);

			final List<EObject> eobjects2 = eobjects;
			Command cutCommand = new CopyToClipboardCommand(domain, eobjects) {

				@Override
				public void doExecute() {

					/**
					 * @author mgil : Don't use a different command to copy
					 *         every element, use the copy function from
					 *         EcoreUtil
					 */
					ArrayList<Object> list = new ArrayList<Object>();
					for(EObject eobj : eobjects2) {
						list.add(eobj);
					}

					oldClipboard = domain.getClipboard();
					domain.setClipboard(list);
				}
			};

			if(cutCommand != null) {
				return new EMFtoGMFCommandWrapper(cutCommand);
			}
		}

		return super.getCutCommand(cntxt, diagramPart);
	}

	/**
	 * Do something with the copied EObject
	 * 
	 * @param eo
	 */
	protected void prepareEObject(EObject eObject) {
	}

	/**
	 * Execute paste after copy.
	 * 
	 * @param cntxt
	 *        the cntxt
	 */
	protected ICommand getExecutePasteAfterCopyCommand(IGlobalActionContext cntxt) {

		if(!(cntxt.getSelection() instanceof StructuredSelection)) {
			return null;
		}

		Object first = ((StructuredSelection)cntxt.getSelection()).getFirstElement();
		if(!(first instanceof IGraphicalEditPart)) {
			return null;
		}

		IGraphicalEditPart pasteDestination = ((IGraphicalEditPart)first);
		TransactionalEditingDomain editingDomain = pasteDestination.getEditingDomain();

		final Object firstElement = first;
		final IGraphicalEditPart editPart = pasteDestination;
		final TransactionalEditingDomain domain = editingDomain;
		AbstractCommonTransactionalCommmand command = new AbstractCommonTransactionalCommmand(editingDomain, "Paste after copy", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				if(domain.getClipboard() != null && domain.getClipboard().size() > 0) {
					// All the objects in the clipboard are supposed to
					// be of the same type
					Object[] objects = domain.getClipboard().toArray();
					EObject firstObjectToBePasted = (EObject)objects[0];
					EStructuralFeature feature = getFeature(firstObjectToBePasted, editPart);

					// Execute paste
					Command pasteCommand = PasteFromClipboardCommand.create(domain, editPart.resolveSemanticElement(), feature);

					domain.getCommandStack().execute(pasteCommand);

					// The new elements must be shown on the diagram
					List<EObject> eobjects = new ArrayList<EObject>();

					for(Object o : pasteCommand.getAffectedObjects()) {
						if(o instanceof EObject) {
							prepareEObject((EObject)o);
							eobjects.add((EObject)o);
						}
					}

					ICommand command = new AddEObjectReferencesToDiagram(domain, DiagramEditPartsUtil.findDiagramFromEditPart((IGraphicalEditPart)firstElement), eobjects);
					domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));

					// refresh the affected EditPart
					DiagramEditPartsUtil.updateEditPart(editPart);

					return CommandResult.newOKCommandResult();
				}
				return CommandResult.newCancelledCommandResult();
			}
		};

		return command.canExecute() ? command : null;
	}

	/**
	 * Execute paste after cut.
	 * 
	 * @param cntxt
	 *        the cntxt
	 */
	protected ICommand getExecutePasteAfterCutCommand(IGlobalActionContext cntxt) {

		if(!(cntxt.getSelection() instanceof StructuredSelection)) {
			return null;
		}

		Object first = ((StructuredSelection)cntxt.getSelection()).getFirstElement();
		if(!(first instanceof IGraphicalEditPart)) {
			return null;
		}

		IGraphicalEditPart pasteDestination = ((IGraphicalEditPart)first);
		TransactionalEditingDomain editingDomain = pasteDestination.getEditingDomain();

		final Object firstElement = first;
		final IGraphicalEditPart editPart = pasteDestination;
		final TransactionalEditingDomain domain = editingDomain;
		AbstractCommonTransactionalCommmand command = new AbstractCommonTransactionalCommmand(editingDomain, "Paste after cut", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

				if(domain.getClipboard() != null && domain.getClipboard().size() > 0) {

					// All the objects in the clipboard are supposed to be of
					// the
					// same type
					Object[] objects = domain.getClipboard().toArray();
					EObject firstObjectToBePasted = (EObject)objects[0];
					EStructuralFeature feature = getFeature(firstObjectToBePasted, editPart);

					// Execute paste
					CompoundCommand cc = new CompoundCommand("Paste");
					Command removeCommand = RemoveCommand.create(domain, container, feature, clipboard);
					if(!removeCommand.canExecute()) {
						return CommandResult.newCancelledCommandResult();
					}

					cc.append(removeCommand);

					for(EditPart ep : editPartsInClipboard) {
						Command c = getDeleteViewCommand(ep);
						if(c != null && !c.canExecute()) {
							return CommandResult.newCancelledCommandResult();
						}

						cc.append(c);
					}

					for(Object obj : domain.getClipboard()) {
						Command addCommand = AddCommand.create(domain, editPart.resolveSemanticElement(), feature, obj);
						if(!addCommand.canExecute()) {
							return CommandResult.newCancelledCommandResult();
						}

						cc.append(addCommand);
					}

					// The new elements must be shown on the diagram
					List<EObject> eobjects = new ArrayList<EObject>();

					for(Object o : domain.getClipboard()) {
						if(o instanceof EObject) {
							eobjects.add((EObject)o);
						}
					}

					ICommand command = new AddEObjectReferencesToDiagram(domain, DiagramEditPartsUtil.findDiagramFromEditPart((IGraphicalEditPart)firstElement), eobjects);
					if(!command.canExecute()) {
						return CommandResult.newCancelledCommandResult();
					}

					cc.append(new GMFtoEMFCommandWrapper(command));

					if(!cc.canExecute()) {
						return CommandResult.newCancelledCommandResult();
					}

					domain.getCommandStack().execute(cc);

					// Empty the clipboard
					domain.setClipboard(new ArrayList<Object>());
					clipboard.clear();
					editPartsInClipboard.clear();

					// Refresh the diagram
					DiagramEditPartsUtil.updateEditPart(editPart);

					return CommandResult.newOKCommandResult();
				}
				return CommandResult.newCancelledCommandResult();
			}
		};

		return command.canExecute() ? command : null;
	}

	/**
	 * Gets the diagram preferences hint.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the diagram preferences hint
	 */
	// @unused
	private PreferencesHint getDiagramPreferencesHint(IGraphicalEditPart editPart) {
		return editPart.getDiagramPreferencesHint();
	}

	/*
	 * Checks if all the objects contained in the list are of the same type than
	 * the eobject passed as parameter
	 */
	/**
	 * All elements same type.
	 * 
	 * @param eobjects
	 *        the eobjects
	 * @param eobject
	 *        the eobject
	 * 
	 * @return true, if successful
	 */
	private boolean allElementsSameType(List<EObject> eobjects, EObject eobject) {

		for(EObject o : eobjects) {
			if(o != null) {
				if(!o.eClass().equals(eobject.eClass())) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	/**
	 * Gets the delete view command.
	 * 
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the delete view command
	 */
	protected Command getDeleteViewCommand(EditPart editPart) {

		if(editPart == null) {
			return null;
		}

		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		org.eclipse.gef.commands.Command command = editPart.getCommand(deleteViewRequest);
		return new GEFtoEMFCommandWrapper(command);
	}

	/**
	 * Gets the edits the parts in clipboard.
	 * 
	 * @param clipboard
	 *        the clipboard
	 * 
	 * @return the edits the parts in clipboard
	 */
	// @unused
	protected Collection<EditPart> getEditPartsInClipboard(Collection<Object> clipboard) {
		if(clipboard != null && clipboard.size() > 0) {
			Collection<EditPart> editParts = new ArrayList<EditPart>();
			for(Object object : clipboard) {
				if(object instanceof EditPart) {
					editParts.add((EditPart)object);
				}
			}
			return editParts;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * Gets the feature.
	 * 
	 * @param objectToBePasted
	 *        the object to be pasted
	 * @param pasteDestination
	 *        the paste destination
	 * 
	 * @return the feature
	 */
	public EStructuralFeature getFeature(EObject objectToBePasted, EditPart pasteDestination) {
		if(objectToBePasted == null || pasteDestination == null) {
			return null;
		}
		EObject element = MDTUtil.resolveSemantic(pasteDestination);
		return getFeature(element, objectToBePasted, pasteDestination);
	}

	/**
	 * Gets the feature.
	 * 
	 * @param element
	 *        the element
	 * @param objectToBePasted
	 *        the object to be pasted
	 * @param editPart
	 *        the edit part
	 * 
	 * @return the feature
	 */
	protected EStructuralFeature getFeature(EObject element, EObject objectToBePasted, EditPart editPart) {

		if(!(element == MDTUtil.resolveSemantic(editPart))) {
			return null;
		}

		EStructuralFeature feature = null;

		Object adapter = editPart.getAdapter(ViewAndFeatureResolver.class);
		ViewAndFeatureResolver resolver = null;
		if(adapter instanceof ViewAndFeatureResolver) {
			resolver = (ViewAndFeatureResolver)adapter;
		}
		if(resolver != null) {
			feature = resolver.getEStructuralFeatureForEClass(objectToBePasted.eClass());
		}
		if(feature == null) {
			for(Object child : editPart.getChildren()) {
				if(child instanceof EditPart) {
					feature = getFeature(element, objectToBePasted, (EditPart)child);
				}
				if(feature != null) {
					break;
				}
			}
		}
		return feature;
	}
}
