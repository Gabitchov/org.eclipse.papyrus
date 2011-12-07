package org.eclipse.papyrus.diagram.statemachine.custom.listeners;

import java.util.NoSuchElementException;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.util.EditPartUtilities;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;


public abstract class AbstractModifcationTriggerListener extends TriggerListener {

	@Override
	protected Command trigger(TransactionalEditingDomain domain, Notification notification) {
		if(notification != null) {
			Object feature = notification.getFeature();
			if(feature instanceof EStructuralFeature) {
				EStructuralFeature eStructuralFeature = (EStructuralFeature)feature;
				if(isCorrectStructuralfeature(eStructuralFeature)) {
					CompositeCommand cc = getModificationCommand(notification);
					if(cc != null) {
						return new GMFtoEMFCommandWrapper(cc);
					}
				}
			}
		}
		return null;
	}

	/**
	 * Return true if the {@link EStructuralFeature} correspond to one which this trigger will handle
	 * 
	 * @param eStructuralFeature
	 * @return
	 */
	protected abstract boolean isCorrectStructuralfeature(EStructuralFeature eStructuralFeature);


	protected abstract CompositeCommand getModificationCommand(Notification notif);

	/**
	 * Return the main edipart which correspond to the {@link EObject} passed in argument
	 * 
	 * @param eObject
	 * @param rootEditPart
	 *        {@link IGraphicalEditPart} root from which the search will start
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected IGraphicalEditPart getChildByEObject(final EObject eObject, IGraphicalEditPart rootEditPart, boolean isEdge) {
		if(eObject != null && rootEditPart != null) {

			try {
				Predicate<EditPart> predicate = new Predicate<EditPart>() {

					public boolean apply(EditPart input) {
						if(input instanceof IGraphicalEditPart) {
							IGraphicalEditPart current = (IGraphicalEditPart)input;
							//Same EObject
							if(eObject.equals(current.resolveSemanticElement())) {
								EditPart parent = current.getParent();
								if(parent instanceof IGraphicalEditPart) {
									// its parent do not have the same EObject
									if(!eObject.equals(((IGraphicalEditPart)parent).resolveSemanticElement())) {
										return true;
									}
								} else if(parent instanceof RootEditPart) {
									return true;
								}
							}
						}
						return false;
					}
				};

				EditPart find = (isEdge) ? Iterables.find((Iterable<EditPart>)EditPartUtilities.getAllNestedConnectionEditParts(rootEditPart), predicate) : Iterables.find((Iterable<EditPart>)EditPartUtilities.getAllChildren(rootEditPart), predicate);
				return (IGraphicalEditPart)find;
			} catch (NoSuchElementException e) {
				//Nothing to do
			}

		}
		return null;
	}

	/**
	 * get the edit part registry
	 * 
	 * @return
	 */
	protected DiagramEditPart getDiagramEditPart() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchPage page = wb.getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = page.getActiveEditor();
		if(editor instanceof PapyrusMultiDiagramEditor) {
			PapyrusMultiDiagramEditor papyrusEditor = (PapyrusMultiDiagramEditor)editor;
			return papyrusEditor.getDiagramEditPart();
		}
		return null;
	}


}
