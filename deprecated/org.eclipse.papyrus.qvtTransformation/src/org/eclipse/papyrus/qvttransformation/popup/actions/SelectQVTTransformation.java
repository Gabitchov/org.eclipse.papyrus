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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.qvttransformation.popup.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter.DirectionKind;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * 
 * This class implements a possible integration of QVTo in Papyrus
 * 
 * 
 */
public class SelectQVTTransformation implements IObjectActionDelegate {

	private Shell shell;

	/**
	 * The selected DiagramEditPart
	 */
	protected DiagramEditPart diagramEditPart = null;

	/**
	 * Constructor for SelectQVTTransformation.
	 */
	public SelectQVTTransformation() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		if(diagramEditPart != null) {
			//Open a dialog to select the transformation to execute
			ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(shell, new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());
			dialog.setTitle("Select a transformation");
			dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
			dialog.setAllowMultiple(false);
			dialog.open();
			Object[] result = dialog.getResult();

			if(result != null) {

				final File transformationFile = (File)result[0];
				if(transformationFile.getFileExtension().contains("qvt")) {

					//Reification of the transformation 
					QvtTransformation transfo = new QvtInterpretedTransformation(transformationFile);
					//Retrieve transformation's parameters
					List<TransformationParameter> params;
					try {
						params = transfo.getParameters();

						//The transformation must have only one parameter. 
						if(params.size() == 1) {
							//Retrieve first parameter's metamodels
							List<EPackage> metamodels = params.get(0).getMetamodels();

							//The parameter must be INOUT and it only have UML as metamodel 
							if(params.get(0).getDirectionKind() == DirectionKind.INOUT && metamodels.size() == 1 && metamodels.get(0).getNsPrefix().compareToIgnoreCase("uml") == 0) {

								//Define the command in Papyrus' editing domain
								RecordingCommand command = new RecordingCommand(EditorUtils.getTransactionalEditingDomain()) {

									@Override
									protected void doExecute() {
										URI uri = URI.createPlatformResourceURI(transformationFile.getFullPath().toString(), true);

										//Create a executor for the transformation
										TransformationExecutor executor = new TransformationExecutor(uri);

										//Define the input as the model that contains the selected diagramEditPart
										List<EObject> contents = new ArrayList<EObject>();
										EObject element = diagramEditPart.resolveSemanticElement();
										contents.add(element);

										ModelExtent input = new BasicModelExtent(contents);
										//ModelExtent output = new BasicModelExtent();

										ExecutionContextImpl context = new ExecutionContextImpl();
										//Execute the transformation
										ExecutionDiagnostic diagnostic = executor.execute(context, input);

										//Report success or failure
										if(diagnostic.getSeverity() == Diagnostic.OK) {
											MessageDialog.openInformation(shell, "QvtTransformation", "Transformation was executed corretly.");
										} else {
											IStatus status = BasicDiagnostic.toIStatus(diagnostic);
											MessageDialog.openError(shell, "QvtTransformation", "Errors occured during the transformation: " + status.getMessage());
										}
									}
								};

								//Execute the command
								EditorUtils.getTransactionalEditingDomain().getCommandStack().execute(command);

							} else {
								MessageDialog.openError(shell, "QvtTransformation", "Transformation signature is invalid : we support only transformations with only one parameter. This parameter must be INOUT and it only have UML as metamodel");
							}
						} else {
							MessageDialog.openError(shell, "QvtTransformation", "Transformation signature is invalid : the transformation must have only one parameter");
						}
					} catch (MdaException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection)selection).getFirstElement();
			if(selectedElement instanceof DiagramEditPart) {
				diagramEditPart = (DiagramEditPart)selectedElement;
			}
		}
	}

}
