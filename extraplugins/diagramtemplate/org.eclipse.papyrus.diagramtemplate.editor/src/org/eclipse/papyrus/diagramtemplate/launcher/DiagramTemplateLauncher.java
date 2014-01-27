/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.diagramtemplate.launcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.diagramtemplate.AbstractSelection;
import org.eclipse.papyrus.diagramtemplate.DiagramDefinition;
import org.eclipse.papyrus.diagramtemplate.Selection;
import org.eclipse.papyrus.diagramtemplate.SelectionKind;
import org.eclipse.papyrus.diagramtemplate.SelectionRef;
import org.eclipse.papyrus.diagramtemplate.Template;
import org.eclipse.papyrus.diagramtemplate.editor.provider.DiagramKindContentProvider;
import org.eclipse.papyrus.diagramtemplate.utils.Messages;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryDescriptor;
import org.eclipse.papyrus.uml.diagram.wizards.category.DiagramCategoryRegistry;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;



/**
 * The template launcher class
 * 
 */
public class DiagramTemplateLauncher {

	/**
	 * The instance used for the singleton pattern
	 */
	private static DiagramTemplateLauncher instance = null;

	/**
	 * Enum used to report on diagram creation
	 * 
	 */
	public enum CreationReportKind {
		SUCCESS, FAIL
	}

	/**
	 * The creation report information
	 */
	protected HashMap<EObject, CreationReportKind> creationReport;

	/**
	 * The diagram added in the first part of the execution
	 */
	protected HashMap<String, AbstractSelection> diagramsCreated;

	/**
	 * The view of the elements added
	 */
	protected List<View> elementProcessed = new ArrayList<View>();

	/**
	 * Used to store the list of diagrams already present in the resource
	 */
	protected List<String> diagramsInResource;

	/**
	 * Constructor.
	 * Private constructor for the singleton pattern
	 */
	private DiagramTemplateLauncher() {
	}

	/**
	 * Get the singleton
	 * 
	 * @return
	 *         the DiagramTemplateLauncher singleton
	 */
	public final synchronized static DiagramTemplateLauncher getInstance() {
		if(instance == null) {
			instance = new DiagramTemplateLauncher();
		}
		return instance;
	}

	/**
	 * List of diagram categories to consider
	 */
	protected List<String> diagramCategories;

	protected void initializeDiagramCategories() {
		diagramCategories = new ArrayList<String>();
		for(DiagramCategoryDescriptor diagramCategoryDescriptor : DiagramCategoryRegistry.getInstance().getDiagramCategories()) {
			diagramCategories.add(diagramCategoryDescriptor.getLabel());
		}
	}

	/**
	 * Util method to get the CreationCommandDescriptor corresponding to a commandID
	 * 
	 * @param commandID
	 *        the commandID to find
	 * @return
	 *         the corresponding CreationCommandDescriptor
	 */
	protected CreationCommandDescriptor getCreation(String commandID) {
		DiagramKindContentProvider provider = new DiagramKindContentProvider();
		List<Object> diagramsKindlist = Arrays.asList(provider.getElements(diagramCategories));

		for(Object object : diagramsKindlist) {
			CreationCommandDescriptor command = (CreationCommandDescriptor)object;

			if(command.getCommandId().compareTo(commandID) == 0) {
				return command;
			}
		}

		return null;
	}

	/**
	 * Used to recursively process the template definition. It identifies the newly create editpart and recurses on it
	 * 
	 * @param actualEditPart
	 *        the editpart elements was added to. It is used to find the newly create editpart
	 * @param elementToShow
	 *        the semantic element added
	 * @param selectionRef
	 *        the corresponding selectionRed
	 * @param activeEditor
	 *        the editor used
	 */
	protected void processRecursively(EditPart actualEditPart, EObject elementToShow, SelectionRef selectionRef, DiagramEditor activeEditor) {

		//Guess which of the View is the new one
		EditPartViewer viewer = actualEditPart.getViewer();
		Map<?, ?> map = viewer.getEditPartRegistry();

		//We must have a copy since map may change during the loop
		Map<?, ?> mapCopy = new HashMap<Object, Object>(map);
		Iterator<?> it = mapCopy.keySet().iterator();
		boolean found = false;
		while(it.hasNext() && !found) {
			Object view = it.next();

			Object value = mapCopy.get(view);
			if(value instanceof GraphicalEditPart) {


				GraphicalEditPart editPart = (GraphicalEditPart)value;


				// The element of the editPart and the element we just added must match
				String editPartSemanticElementID = editPart.resolveSemanticElement().eResource().getURIFragment(editPart.resolveSemanticElement());
				String elementToShowID = elementToShow.eResource().getURIFragment(elementToShow);
				if(editPartSemanticElementID.equals(elementToShowID)) {

					//The view should be the editpart whose parent's element is not the elementToShow
					boolean foundParentWithElementToShowAsElement = false;

					EditPart elementToProcess = editPart.getParent();
					while(elementToProcess != null && !foundParentWithElementToShowAsElement) {

						if(elementToProcess instanceof GraphicalEditPart) {
							String elementToProcessSemanticElementID = ((GraphicalEditPart)elementToProcess).resolveSemanticElement().eResource().getURIFragment(((GraphicalEditPart)elementToProcess).resolveSemanticElement());
							if(elementToProcessSemanticElementID.equals(elementToShowID)) {
								foundParentWithElementToShowAsElement = true;
							}
						}

						elementToProcess = elementToProcess.getParent();
					}

					if(!foundParentWithElementToShowAsElement) {
						//Last we must be sure that it is really new one
						if(!elementProcessed.contains(view)) {
							//We can process it
							addElementsFor(selectionRef.getSelectionRef(), elementToShow, activeEditor, editPart);

							// FIXME we may need to add all new elements as processed
							//Record that it is processed
							elementProcessed.add((View)view);

							found = true;
						}
					}
				}
			}
		}
	}

	/**
	 * Find the element to show depending on a list and try to add them to a specific editPart
	 * 
	 * @param selectionList
	 *        The selection list of elements to add to the editPart
	 * @param root
	 *        The root to search the elements from
	 * @param activeEditor
	 *        the editor corresponding to the editPart
	 * @param editPartToShowIn
	 *        the editPart to show elements in
	 */
	protected void addElementsFor(List<?> selectionList, EObject root, DiagramEditor activeEditor, EditPart editPartToShowIn) {
		// Go through the SelectionRef
		for(Object object : selectionList) {
			if(object instanceof SelectionRef) {
				SelectionRef selectionRef = (SelectionRef)object;

				// Retrieve the values
				Object result = root.eGet((EStructuralFeature)selectionRef.getEReference());
				List<EObject> resultsToProcess = new ArrayList<EObject>();

				if(result instanceof List) {
					resultsToProcess.addAll((Collection<? extends EObject>)result);
				} else {
					resultsToProcess.add((EObject)result);
				}

				if(selectionRef.getKind() == SelectionKind.FOR_ALL) {


					List<EObject> resultsToShow = new ArrayList<EObject>();
					//Try to match constraints
					for(EObject elementToMatch : resultsToProcess) {
						if(matchStereotypedBy(elementToMatch, selectionRef.getStereotypedBy())) {
							if(selectionRef.isSubTypes()) {
								//Consider all subtypes
								if(elementToMatch.eClass().getEAllSuperTypes().contains(selectionRef.getElement()) || elementToMatch.eClass() == selectionRef.getElement()) {
									// It matches
									resultsToShow.add(elementToMatch);
								}
							} else {
								if(elementToMatch.eClass() == selectionRef.getElement()) {
									// It matches
									resultsToShow.add(elementToMatch);
								}
							}
						}
					}

					// Process them all
					int i = 0;
					for(EObject elementToShow : resultsToShow) {

						EditPart actualEditPart = showElementIn(elementToShow, activeEditor, editPartToShowIn, i);
						processRecursively(actualEditPart, elementToShow, selectionRef, activeEditor);
						i++;
					}

				} else {
					// FIXME Kind of very dirty
					for(EObject eObject : resultsToProcess) {
						String eObjectID = eObject.eResource().getURIFragment(eObject);
						String elementID = selectionRef.getElement().eResource().getURIFragment(selectionRef.getElement());
						if(eObjectID.equals(elementID)) {
							//						if(eObject == selectionRef.getElement()) {
							EditPart actualEditPart = showElementIn(eObject, activeEditor, editPartToShowIn, 0);
							processRecursively(actualEditPart, eObject, selectionRef, activeEditor);
						}
					}
				}
			}
		}
	}

	/**
	 * Util method used to find all the children of a certain editpart
	 * 
	 * @param list
	 *        the children found recursively
	 * @param root
	 *        the root editpart to start the search from
	 */
	protected void findAllChildren(List<EditPart> list, EditPart root) {
		list.addAll(root.getChildren());
		for(Object editPart : root.getChildren()) {
			if(editPart instanceof EditPart) {
				findAllChildren(list, (EditPart)editPart);
			}
		}
	}

	/**
	 * Try to show an element in an editPart (or its children)
	 * 
	 * @param elementToShow
	 *        the element to show
	 * @param activeEditor
	 *        the editor corresponding to the editPart
	 * @param editPart
	 *        the editPart to show the element in
	 * @param position
	 *        position is used to try to distribute the drop
	 * @return
	 *         the editPart in which the element has been actually added
	 */
	protected EditPart showElementIn(EObject elementToShow, DiagramEditor activeEditor, EditPart editPart, int position) {


		EditPart returnEditPart = null;

		if(elementToShow instanceof Element) {

			DropObjectsRequest dropObjectsRequest = new DropObjectsRequest();
			ArrayList<Element> list = new ArrayList<Element>();
			list.add((Element)elementToShow);
			dropObjectsRequest.setObjects(list);
			dropObjectsRequest.setLocation(new Point(20, 100 * position));
			Command commandDrop = editPart.getCommand(dropObjectsRequest);

			boolean processChildren = false;
			if(commandDrop == null) {
				processChildren = true;
			} else {
				if(commandDrop.canExecute()) {
					activeEditor.getDiagramEditDomain().getDiagramCommandStack().execute(commandDrop);
					returnEditPart = editPart;
					creationReport.put(elementToShow, CreationReportKind.SUCCESS);
				} else {
					processChildren = true;
				}
			}

			if(processChildren) {
				//try to add to one of its children
				boolean found = false;

				ArrayList<EditPart> childrenList = new ArrayList<EditPart>();
				findAllChildren(childrenList, editPart);
				for(Object child : childrenList) {
					if(child instanceof EditPart) {
						Command commandDropChild = ((EditPart)child).getCommand(dropObjectsRequest);
						if(commandDropChild != null) {
							if(commandDropChild.canExecute()) {
								activeEditor.getDiagramEditDomain().getDiagramCommandStack().execute(commandDropChild);
								found = true;
								returnEditPart = (EditPart)child;
								creationReport.put(elementToShow, CreationReportKind.SUCCESS);
								break;
							}
						}
					}
				}
				if(!found) {
					creationReport.put(elementToShow, CreationReportKind.FAIL);
					returnEditPart = editPart;
				}
			}
		}

		return returnEditPart;
	}

	/**
	 * Utils method that determine whether an element is stereotypedBy a certain stereotype qualiedName
	 * 
	 * @param element
	 *        the element to test
	 * @param stereotypedBy
	 *        the qulifiedName of the stereotype to match
	 * @return
	 *         true if matches false else.
	 */
	protected boolean matchStereotypedBy(EObject element, String stereotypedBy) {
		if(element instanceof Element) {
			//Read stereotypedBy
			stereotypedBy = stereotypedBy.replaceAll(" ", ""); //$NON-NLS-1$ //$NON-NLS-2$
			String[] stereotypes = stereotypedBy.split(","); //$NON-NLS-1$

			boolean matchStereotypes = true;
			for(String stereo : stereotypes) {
				if(stereo != null && stereo.length() > 0) {
					if(((Element)element).getAppliedStereotype(stereo) != null) {
						matchStereotypes = true;
					} else {
						matchStereotypes = false;
						break;
					}
				}
			}

			return matchStereotypes;
		}

		return false;
	}

	/**
	 * Creates the diagrams in a specified Papyrus resource
	 * 
	 * @param selectionList
	 *        The selection for which we must create diagrams corresponding to the diagram definition
	 * @param diagramDefinition
	 *        The diagram definition to create
	 * @param diResourceSet
	 *        The Papyrus resource to create the diagrams in
	 */
	protected void createDiagramFor(List<?> selectionList, DiagramDefinition diagramDefinition, ModelSet modelSet) {
		//Go through the selection and try to find elements in the target model that match
		for(Object object : selectionList) {

			if(object instanceof AbstractSelection) {
				AbstractSelection selection = (AbstractSelection)object;
				CreationCommandDescriptor creationCommandDescriptor = getCreation(diagramDefinition.getDiagramKind());
				if(creationCommandDescriptor != null) {


					EObject root;

					//If the template is under specified, try to guess
					if(diagramDefinition.getFromRoot() == null) {
						root = ((Template)diagramDefinition.eContainer()).getTargetRoot();
					} else {
						root = diagramDefinition.getFromRoot();
					}

					if(root != null) {
						if(selection.getKind() == SelectionKind.FOR_ALL) {

							// Find elements that match
							List<EObject> content = new ArrayList<EObject>();
							if(selection instanceof Selection) {
								if(((Selection)selection).isRecursively()) {
									//Go through all recursively
									TreeIterator<EObject> it = root.eAllContents();
									while(it.hasNext()) {
										EObject eObject = it.next();
										content.add(eObject);
									}
								} else {
									content.addAll(root.eContents());
								}
								content.add(root);
							} else {
								MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(), Messages.DiagramTemplateLauncher_3, Messages.DiagramTemplateLauncher_4);
							}


							for(EObject eObject : content) {
								if(matchStereotypedBy(eObject, selection.getStereotypedBy())) {
									String name = diagramDefinition.getPrefix();
									if(eObject instanceof NamedElement) {
										name += ((NamedElement)eObject).getName();
									} else {
										name += eObject.toString();
									}


									if(selection.isSubTypes()) {
										//Consider all subtypes
										if(eObject.eClass().getEAllSuperTypes().contains(selection.getElement()) || eObject.eClass() == selection.getElement()) {
											// System.err.println("FoundForAll Sub: " + diagramDefinition.getName());
											// It matches: create a diagram
											try {
												creationCommandDescriptor.getCommand().createDiagram(modelSet, eObject, name);

												//Identify the new diagram
												TreeIterator<EObject> it = NotationUtils.getNotationResource(modelSet).getAllContents();
												while(it.hasNext()) {
													EObject diagram = it.next();
													if(diagram instanceof Diagram) {
														if(!diagramsInResource.contains(diagram.eResource().getURIFragment(diagram))) {
															diagramsCreated.put(diagram.eResource().getURIFragment(diagram), selection);
															diagramsInResource.add(diagram.eResource().getURIFragment(diagram));

															creationReport.put(eObject, CreationReportKind.SUCCESS);
														}
													}
												}

											} catch (BackboneException e) {
												// TODO Auto-generated catch block
												e.printStackTrace(System.out);
											}
										}
									} else {
										if(eObject.eClass() == selection.getElement()) {
											// System.err.println("FoundForAll Strict: " + diagramDefinition.getName());
											// It matches: create a diagram

											try {
												creationCommandDescriptor.getCommand().createDiagram(modelSet, eObject, name);

												//Identify the new diagram
												TreeIterator<EObject> it = NotationUtils.getNotationResource(modelSet).getAllContents();
												while(it.hasNext()) {
													EObject diagram = it.next();
													if(diagram instanceof Diagram) {
														if(!diagramsInResource.contains(diagram.eResource().getURIFragment(diagram))) {
															diagramsCreated.put(diagram.eResource().getURIFragment(diagram), selection);
															diagramsInResource.add(diagram.eResource().getURIFragment(diagram));

															creationReport.put(eObject, CreationReportKind.SUCCESS);
														}
													}
												}

											} catch (BackboneException e) {
												// TODO Auto-generated catch block
												e.printStackTrace(System.out);
											}
										}
									}
								}
							}
						} else if(selection.getKind() == SelectionKind.SPECIFIC) {

							// System.err.println("FoundSpecific");
							String name = diagramDefinition.getPrefix();
							if(selection.getElement() instanceof NamedElement) {
								name += ((NamedElement)selection.getElement()).getName();
							} else {
								name += selection.getElement().toString();
							}

							try {
								creationCommandDescriptor.getCommand().createDiagram(modelSet, selection.getElement(), name);

								//Identify the new diagram
								TreeIterator<EObject> it = NotationUtils.getNotationResource(modelSet).getAllContents();
								while(it.hasNext()) {
									EObject diagram = it.next();
									if(diagram instanceof Diagram) {
										if(!diagramsInResource.contains(diagram.eResource().getURIFragment(diagram))) {
											diagramsCreated.put(diagram.eResource().getURIFragment(diagram), selection);
											diagramsInResource.add(diagram.eResource().getURIFragment(diagram));

											creationReport.put(selection.getElement(), CreationReportKind.SUCCESS);
										}
									}
								}
							} catch (BackboneException e) {
								// TODO Auto-generated catch block
								e.printStackTrace(System.out);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Helper method used to arrange recursively editparts
	 * 
	 * @param editpart
	 *        the editpart to process
	 */
	protected void arrangeRecursively(EditPart editpart) {
		//ArrangeRequest request = new ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL, LayoutType.DEFAULT);
		ArrangeRequest request = new ArrangeRequest(RequestConstants.REQ_ARRANGE_DEFERRED);
		List<EditPart> listToArrange = new ArrayList<EditPart>();
		listToArrange.addAll(editpart.getChildren());

		if(!listToArrange.isEmpty()) {
			for(Object element : editpart.getChildren()) {
				if(element instanceof EditPart) {
					arrangeRecursively((EditPart)element);
				}
			}

			request.setViewAdaptersToArrange(listToArrange);

			Command command = editpart.getCommand(request);
			command.execute();
		}
	}

	/**
	 * This is the main method for the template launcher. Executes the template
	 * 
	 * @param template
	 *        The template to execute
	 */
	public void execute(Template template) {
		initializeDiagramCategories();
		diagramsInResource = new ArrayList<String>();
		diagramsCreated = new HashMap<String, AbstractSelection>();
		creationReport = new HashMap<EObject, CreationReportKind>();

		if(template != null) {
			ModelSet modelSet = new DiResourceSet();

			if(template.getTargetRoot().eResource() != null) {
				String targetModelLocation = template.getTargetRoot().eResource().getURI().toPlatformString(false);
				IFile targetModelfile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(targetModelLocation));

				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(targetModelfile.getFullPath().removeFileExtension().toString() + ".di")); //$NON-NLS-1$

				if(file.exists()) {

					try {
						modelSet.loadModels(file);
					} catch (ModelMultiException ex) {
						ex.printStackTrace(System.out);
					}

					try {
						ServicesRegistry registry = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
						registry.add(ModelSet.class, Integer.MAX_VALUE, modelSet);
						try {
							registry.startRegistry();
						} catch (ServiceException ex) {
							//Ignore
						}

						//Identify already available diagrams
						TreeIterator<EObject> it = NotationUtils.getNotationResource(modelSet).getAllContents();
						while(it.hasNext()) {
							EObject diagram = it.next();
							if(diagram instanceof Diagram) {
								diagramsInResource.add(diagram.eResource().getURIFragment(diagram));
							}
						}

						// Create diagrams
						if(!template.getDiagramDefinitions().isEmpty()) {
							for(DiagramDefinition diagramDefinition : template.getDiagramDefinitions()) {
								createDiagramFor(diagramDefinition.getSelection(), diagramDefinition, modelSet);
							}
						} else {
							// Create empty diagrams
							//EditorUtils.getTransactionalIPageMngr(DiModelUtils.getDiResource(modelSet), modelSet.getTransactionalEditingDomain());
						}

						// Save the resource
						try {
							modelSet.save(new NullProgressMonitor());
						} catch (IOException e) {
							e.printStackTrace(System.out);
							// return false;
						}

						try {
							registry.disposeRegistry();
						} catch (ServiceException ex) {
							//Ignore
						}

					} catch (ServiceException ex) {
						ex.printStackTrace(System.out);
					}

					// Open the editor
					IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

					if(page != null) {
						try {
							final IEditorPart editor = IDE.openEditor(page, file, true);

							if(editor instanceof IMultiDiagramEditor) {
								final ServicesRegistry services = ((IMultiDiagramEditor)editor).getServicesRegistry();
								TransactionalEditingDomain editingDomain = services.getService(TransactionalEditingDomain.class);
								org.eclipse.emf.common.command.Command openPagesCommand = new RecordingCommand(editingDomain, "Open created pages") {

									@Override
									protected void doExecute() {
										try {
											System.out.println("Executing");
											IPageManager pageManager = services.getService(IPageManager.class);

											System.out.println("Close all pages");
											pageManager.closeAllOpenedPages();

											// Go through the diagrams available in the resource
											for(Object pageDiagram : pageManager.allPages()) {

												if(pageDiagram instanceof Diagram) {
													String pageID = ((Diagram)pageDiagram).eResource().getURIFragment((Diagram)pageDiagram);

													if(diagramsCreated.containsKey(pageID)) {
														System.out.println("Open page");
														pageManager.openPage(pageDiagram);
														IEditorPart activeEditor = ((PapyrusMultiDiagramEditor)editor).getActiveEditor();

														if(activeEditor instanceof DiagramEditor) {
															// Get the GraphicalViewer for this diagram
															Object result = activeEditor.getAdapter(GraphicalViewer.class);
															if(result != null && result instanceof GraphicalViewer) {
																DiagramEditPart diagramEditPart = (DiagramEditPart)((GraphicalViewer)result).getEditPartRegistry().get(pageDiagram);

																// Retrieve the selection to show for this diagram
																AbstractSelection selection = diagramsCreated.get(pageID);
																addElementsFor(selection.getSelectionRef(), ((Diagram)pageDiagram).getElement(), (DiagramEditor)activeEditor, diagramEditPart);

																//Arrange all recursively
																arrangeRecursively(diagramEditPart);
															}

															// This page is processed now (may be not necessary)
															diagramsCreated.remove(pageID);
														}
													}
												}
											}
										} catch (ServiceException ex) {
											ex.printStackTrace(System.out);
										}
									}
								};

								editingDomain.getCommandStack().execute(openPagesCommand);
							}

							//Report
							DiagramTemplateLauncherReport.getInstance().showReport(creationReport);

						} catch (PartInitException e) {
							e.printStackTrace(System.out);
						} catch (ServiceException e) {
							e.printStackTrace(System.out);
						}
					}
				} else {
					MessageDialog.openError(PlatformUI.getWorkbench().getDisplay().getActiveShell(), Messages.DiagramTemplateLauncher_6, Messages.DiagramTemplateLauncher_7);
				}
			}
		}
	}
}
