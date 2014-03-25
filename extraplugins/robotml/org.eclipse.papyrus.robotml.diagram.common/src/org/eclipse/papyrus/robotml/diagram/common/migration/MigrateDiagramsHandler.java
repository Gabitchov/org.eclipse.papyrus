package org.eclipse.papyrus.robotml.diagram.common.migration;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.robotml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.CompositeStructureDiagramEditPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class MigrateDiagramsHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if(currentSelection.isEmpty() || !(currentSelection instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection selection = (IStructuredSelection)currentSelection;

		Object selectedElement = selection.getFirstElement();

		Object selectedAdapter = Platform.getAdapterManager().getAdapter(selectedElement, IFile.class);



		if(selectedAdapter instanceof IFile) {
			final IFile selectedFile = (IFile)selectedAdapter;

			//Load the model in background and add a user information
			Job openDialogJob = new Job("Switch profile") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					monitor.beginTask("Migrating model...", IProgressMonitor.UNKNOWN);
					ModelSet modelSet = new ModelSet();
					ModelsReader reader = new ModelsReader();
					reader.readModel(modelSet);


					IPath workspacePath = selectedFile.getFullPath();

					URI workspaceURI = URI.createPlatformResourceURI(workspacePath.toString(), true);

					ViewPrototype protoArchitecture = null;
					ViewPrototype protoDatatypeDef = null;
					ViewPrototype protoInterfaceDef = null;
					ViewPrototype protoComponentDef = null;
					for(ViewPrototype proto : PolicyChecker.getCurrent().getAllPrototypes()) {
						if(proto.getLabel().contains("RobotML Architecture")) {
							protoArchitecture = proto;
						} else if(proto.getLabel().contains("RobotML Component")) {
							protoComponentDef = proto;
						} else if(proto.getLabel().contains("RobotML Interface")) {
							protoInterfaceDef = proto;

						} else if(proto.getLabel().contains("RobotML Datatype")) {
							protoDatatypeDef = proto;
						}
					}


					try {
						modelSet.loadModels(workspaceURI);
						//do the diagrams migration
						NotationModel notationModel = (NotationModel)modelSet.getModel(NotationModel.MODEL_ID);
						if(notationModel != null) {
							Resource mainNotationResource = notationModel.getResource();

							Iterator<EObject> allContents = mainNotationResource.getAllContents();

							while(allContents.hasNext()) {
								EObject currentElement = allContents.next();

								if(currentElement instanceof Diagram) {
									// 1. Changing the type of the diagram
									//System.err.println(currentElement);
									if(((Diagram)currentElement).getType().equalsIgnoreCase("architecture")) {
										((Diagram)currentElement).setType(CompositeStructureDiagramEditPart.MODEL_ID);
										DiagramUtils.setPrototype((Diagram)currentElement, protoArchitecture);
										DiagramUtils.setOwner(((Diagram)currentElement), ((Diagram)currentElement).getElement());

									} else if(((Diagram)currentElement).getType().equalsIgnoreCase("componentdef")) {
										((Diagram)currentElement).setType(CompositeStructureDiagramEditPart.MODEL_ID);
										DiagramUtils.setPrototype((Diagram)currentElement, protoComponentDef);
										DiagramUtils.setOwner(((Diagram)currentElement), ((Diagram)currentElement).getElement());
									}

									else if(((Diagram)currentElement).getType().equalsIgnoreCase("datatypedef")) {
										((Diagram)currentElement).setType(ModelEditPart.MODEL_ID);
										DiagramUtils.setPrototype((Diagram)currentElement, protoDatatypeDef);
										DiagramUtils.setOwner(((Diagram)currentElement), ((Diagram)currentElement).getElement());

									} else if(((Diagram)currentElement).getType().equalsIgnoreCase("interfacedef")) {
										((Diagram)currentElement).setType(ModelEditPart.MODEL_ID);
										DiagramUtils.setPrototype((Diagram)currentElement, protoInterfaceDef);
										DiagramUtils.setOwner(((Diagram)currentElement), ((Diagram)currentElement).getElement());
									}

								}


							}//end while
							mainNotationResource.save(null);

						}

					} catch (ModelMultiException e) {
						Activator.log.error(e);
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
					} catch (IOException e) {

						Activator.log.error(e);
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
					}

					return Status.OK_STATUS;
				}
			};

			openDialogJob.setUser(true);

			openDialogJob.schedule();
		}

		return null;
	}

}
