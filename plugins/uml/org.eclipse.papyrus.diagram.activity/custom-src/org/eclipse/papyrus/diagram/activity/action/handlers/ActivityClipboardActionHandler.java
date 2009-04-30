package org.eclipse.papyrus.diagram.activity.action.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.PasteFromClipboardCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.diagram.activity.edit.commands.helpers.ActivityPartitionActivity;
import org.eclipse.papyrus.diagram.common.actions.handlers.UMLClipboardActionHandler;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.commands.AbstractCommonTransactionalCommmand;
import org.eclipse.papyrus.diagram.common.commands.AddEObjectReferencesToDiagram;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.UMLPackage;

public class ActivityClipboardActionHandler extends UMLClipboardActionHandler {

	@Override
	protected ICommand getExecutePasteAfterCopyCommand(IGlobalActionContext cntxt) {

		ISelection selection = cntxt.getSelection();
		List<EditPart> editParts = MDTUtil.getEditPartsFromSelection(selection);

		if (editParts.size() == 1) {
			IGraphicalEditPart pasteDestination = (IGraphicalEditPart) editParts.get(0);
			EObject firstElement = MDTUtil.resolveSemantic(pasteDestination);
			if (firstElement instanceof ActivityPartition) {
				final Object element = firstElement;
				final IGraphicalEditPart editPart = pasteDestination;
				final TransactionalEditingDomain domain = pasteDestination.getEditingDomain();
				AbstractCommonTransactionalCommmand command = new AbstractCommonTransactionalCommmand(domain, "Paste after copy", null) {

					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

						ActivityPartition activityPartition = (ActivityPartition) element;

						// elements pasted on an ActivityPartition are
						// stored in an Activity
						Activity activity = ActivityPartitionActivity.getActivityPartitionActivity(activityPartition);

						// we want to paste in an Activity Partition
						// special actions required
						if (domain != null && domain.getClipboard() != null && domain.getClipboard().size() > 0) {

							// All the objects in the clipboard are supposed to
							// be of the same type
							Object[] objects = domain.getClipboard().toArray();
							EObject firstObjectToBePasted = (EObject) objects[0];
							EStructuralFeature feature = getFeature(firstObjectToBePasted, editPart);

							// Change inPartition value of the activityNodes
							List<EObject> eobjectsAux = new ArrayList<EObject>();
							for (Object o : objects) {
								if (o instanceof EObject) {
									eobjectsAux.add((EObject) o);
								}
							}
							for (EObject eObject : eobjectsAux) {
								if (eObject instanceof ActivityNode) {
									ActivityNode activityNode = (ActivityNode) eObject;

									Command add = AddCommand.create(domain, activityNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), activityPartition);
									domain.getCommandStack().execute(add);
								}
							}

							// Execute paste
							Command pasteCommand = PasteFromClipboardCommand.create(domain, activity, feature);
							domain.getCommandStack().execute(pasteCommand);

							// The affected objects must be set inside the
							// ActivityPartition
							List<EObject> eobjects = new ArrayList<EObject>();
							for (Object o : pasteCommand.getAffectedObjects()) {
								if (o instanceof EObject) {
									prepareEObject((EObject) o);
									eobjects.add((EObject) o);
								}
							}

							// add these objects' references to the Diagram
							ICommand command = new AddEObjectReferencesToDiagram(domain, DiagramEditPartsUtil.findDiagramFromEditPart(editPart), eobjects);
							domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));

							// refresh the affected EditPart
							if (editPart instanceof IGraphicalEditPart) {
								DiagramEditPartsUtil.updateEditPart((IGraphicalEditPart) editPart);
							}

							return CommandResult.newOKCommandResult();
						}
						return CommandResult.newCancelledCommandResult();
					}
				};
				return command;

			} else {
				// if not an ActivityPartition, default behavior
				return super.getExecutePasteAfterCopyCommand(cntxt);
			}
		}

		return null;
	}

	@Override
	protected ICommand getExecutePasteAfterCutCommand(IGlobalActionContext cntxt) {

		ISelection selection = cntxt.getSelection();
		List<EditPart> editParts = MDTUtil.getEditPartsFromSelection(selection);

		if (editParts.size() == 1) {
			IGraphicalEditPart pasteDestination = (IGraphicalEditPart) editParts.get(0);
			EObject firstElement = MDTUtil.resolveSemantic(pasteDestination);
			if (firstElement instanceof ActivityPartition) {
				final Object element = firstElement;
				final IGraphicalEditPart editPart = pasteDestination;
				final TransactionalEditingDomain domain = pasteDestination.getEditingDomain();
				AbstractCommonTransactionalCommmand command = new AbstractCommonTransactionalCommmand(domain, "Paste after copy", null) {

					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

						ActivityPartition activityPartition = (ActivityPartition) element;

						// elements pasted on an ActivityPartition ares stored
						// in an Activity
						Activity activity = ActivityPartitionActivity.getActivityPartitionActivity(activityPartition);

						// we want to paste in an Activity Partition
						// special actions required
						if (domain != null && domain.getClipboard() != null && domain.getClipboard().size() > 0) {
							// command
							CompoundCommand cc = new CompoundCommand("Paste");

							// get list of ActivityNodes to move
							List<ActivityNode> activityNodes = new ArrayList<ActivityNode>();
							for (Object object : domain.getClipboard()) {
								EObject eObject = MDTUtil.resolveSemantic(object);
								if (eObject instanceof ActivityNode) {
									activityNodes.add((ActivityNode) eObject);
								}
							}

							// remove all ActivityNodes from the old
							// ActivityPartition
							for (EditPart ep : editPartsInClipboard) {
								IGraphicalEditPart graphicalEditPart = (IGraphicalEditPart) ep;
								ActivityNode activityNode = (ActivityNode) graphicalEditPart.resolveSemanticElement();
								if (ep.getParent() != null && ep.getParent() instanceof CompartmentEditPart) {
									CompartmentEditPart compartment = (CompartmentEditPart) ep.getParent();
									if (compartment.getParent() != null) {
										IGraphicalEditPart gep = (IGraphicalEditPart) compartment.getParent();
										if (gep.resolveSemanticElement() instanceof ActivityPartition) {
											ActivityPartition ap = (ActivityPartition) gep.resolveSemanticElement();
											Command rem = RemoveCommand.create(domain, activityNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), ap);
											domain.getCommandStack().execute(rem);
										}
									}
								}
							}

							// add all ActivityNodes to the selected
							// ActivityPartition's node feature
							for (ActivityNode activityNode : activityNodes) {
								SetRequest setRequest = new SetRequest(domain, activityNode, UMLPackage.eINSTANCE.getActivityNode_InPartition(), activityPartition);
								SetValueCommand setValueCommand = new SetValueCommand(setRequest);
								if (setValueCommand != null) {
									setValueCommand.execute(null, null);
								}
							}

							// delete copied object's views
							for (EditPart ep : editPartsInClipboard) {
								Command c = getDeleteViewCommand(ep);
								if (c != null) {
									cc.append(c);
								}
							}

							if (cc.canExecute()) {
								domain.getCommandStack().execute(cc);
							}

							// add these objects' references to the Diagram
							ICommand command = new AddEObjectReferencesToDiagram(domain, DiagramEditPartsUtil.findDiagramFromEditPart(editPart), Arrays.asList(activityNodes
									.toArray(new EObject[activityNodes.size()])));
							domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));

							// refresh the affected EditPart
							DiagramEditPartsUtil.updateEditPart((IGraphicalEditPart) editPart);
							domain.setClipboard(new ArrayList<Object>());
							return CommandResult.newOKCommandResult();
						}
						return CommandResult.newCancelledCommandResult();
					}
				};
				return command;

			} else {
				// if not an ActivityPartition, default behavior
				return super.getExecutePasteAfterCutCommand(cntxt);
			}
		}
		return null;
	}
}
