package org.eclipse.papyrus.diagram.statemachine.edit.policies;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.papyrus.diagram.statemachine.part.Messages;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditor;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.statemachine.part.UMLDiagramEditorUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.State;


/**
 * @generated
 */
public class OpenDiagramEditPolicy extends OpenEditPolicy {

	/**
	 * @generated
	 */
	@Override
	protected Command getOpenCommand(Request request) {
		EditPart targetEditPart = getTargetEditPart(request);
		if(false == targetEditPart.getModel() instanceof View) {
			return null;
		}
		View view = (View)targetEditPart.getModel();
		Style link = view.getStyle(NotationPackage.eINSTANCE
				.getHintedDiagramLinkStyle());
		if(false == link instanceof HintedDiagramLinkStyle) {
			return null;
		}
		return new ICommandProxy(new OpenDiagramCommand(
				(HintedDiagramLinkStyle)link));
	}

	/**
	 * @generated
	 */
	private static class OpenDiagramCommand extends
			AbstractTransactionalCommand {

		/**
		 * @generated
		 */
		private final HintedDiagramLinkStyle diagramFacet;

		/**
		 * @generated
		 */
		OpenDiagramCommand(HintedDiagramLinkStyle linkStyle) {
			// editing domain is taken for original diagram, 
			// if we open diagram from another file, we should use another editing domain
			super(TransactionUtil.getEditingDomain(linkStyle),
					Messages.CommandName_OpenDiagram, null);
			diagramFacet = linkStyle;
		}

		/**
		 * @generated NOT
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			if(selectSubmachineOnOpenDiagrams(getDiagramDomainElement())) {
				return CommandResult.newOKCommandResult();
			}
			return doExecuteWithResultGen(monitor, info);
		}

		// FIXME canExecute if  !(readOnly && getDiagramToOpen == null), i.e. open works on ro diagrams only when there's associated diagram already

		/**
		 * @generated
		 */
		protected CommandResult doExecuteWithResultGen(
				IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			try {
				Diagram diagram = getDiagramToOpen();
				if(diagram == null) {
					diagram = intializeNewDiagram();
				}
				URI uri = diagram.eResource().getURI();
				uri = uri.appendFragment(diagram.eResource().getURIFragment(
						diagram));
				String diagramName = getDiagramName(getDiagramDomainElement());
				IEditorInput editorInput = new URIEditorInput(uri, diagramName);
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				page.openEditor(editorInput, getEditorID());
				return CommandResult.newOKCommandResult();
			} catch (Exception ex) {
				throw new ExecutionException("Can't open diagram", ex);
			}
		}

		/**
		 * @generated
		 */
		protected Diagram getDiagramToOpen() {
			return diagramFacet.getDiagramLink();
		}

		/**
		 * @generated
		 */
		protected Diagram intializeNewDiagram() throws ExecutionException {
			Diagram d = ViewService.createDiagram(getDiagramDomainElement(),
					getDiagramKind(), getPreferencesHint());
			if(d == null) {
				throw new ExecutionException("Can't create diagram of '"
						+ getDiagramKind() + "' kind");
			}
			diagramFacet.setDiagramLink(d);
			assert diagramFacet.eResource() != null;
			diagramFacet.eResource().getContents().add(d);
			try {
				new WorkspaceModifyOperation() {

					protected void execute(IProgressMonitor monitor)
							throws CoreException, InvocationTargetException,
							InterruptedException {
						try {
							for(Iterator it = diagramFacet.eResource()
									.getResourceSet().getResources().iterator(); it
									.hasNext();) {
								Resource nextResource = (Resource)it.next();
								if(nextResource.isLoaded()
										&& !getEditingDomain().isReadOnly(
										nextResource)) {
									nextResource.save(UMLDiagramEditorUtil
											.getSaveOptions());
								}
							}
						} catch (IOException ex) {
							throw new InvocationTargetException(ex,
									"Save operation failed");
						}
					}
				}.run(null);
			} catch (InvocationTargetException e) {
				throw new ExecutionException("Can't create diagram of '"
						+ getDiagramKind() + "' kind", e);
			} catch (InterruptedException e) {
				throw new ExecutionException("Can't create diagram of '"
						+ getDiagramKind() + "' kind", e);
			}
			return d;
		}

		/**
		 * @generated NOT
		 */
		protected EObject getDiagramDomainElement() {
			EObject domainElement = getDiagramDomainElementGen();
			if(domainElement instanceof State) {
				State state = (State)domainElement;
				return state.getSubmachine();
			}
			return domainElement;
		}

		/**
		 * @generated
		 */
		protected EObject getDiagramDomainElementGen() {
			// use same element as associated with EP
			return ((View)diagramFacet.eContainer()).getElement();
		}

		/**
		 * @generated
		 */
		protected PreferencesHint getPreferencesHint() {
			// XXX prefhint from target diagram's editor?
			return UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
		}

		/**
		 * @generated
		 */
		protected String getDiagramKind() {
			return StateMachineEditPart.MODEL_ID;
		}

		/**
		 * @generated
		 */
		protected String getEditorID() {
			return UMLDiagramEditor.ID;
		}

		/**
		 * @NOT generated
		 */
		private boolean selectSubmachineOnOpenDiagrams(EObject submachine) {
			IWorkbenchPage workbenchPage = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			IEditorReference[] editorRefs = workbenchPage.getEditorReferences();
			for(int i = 0; i < editorRefs.length; i++) {
				IEditorPart editorPart = editorRefs[i].getEditor(true);
				if(editorPart instanceof DiagramEditor) {
					DiagramEditPart diagramEditPart = ((DiagramEditor)editorPart)
							.getDiagramEditPart();
					EditPart editPart = findTopLevelElementInDiagram(
							diagramEditPart, submachine);
					if(editPart != null) {
						if(getDiagramToOpen() == null) {
							diagramFacet
									.setDiagramLink(((DiagramEditor)editorPart)
									.getDiagram());
						}
						workbenchPage.activate(editorPart);
						diagramEditPart.getViewer().select(editPart);
						return true;
					}
				}
			}

			return false;
		}

		/**
		 * @NOT generated
		 */
		private EditPart findTopLevelElementInDiagram(
				DiagramEditPart diagramEditPart, EObject element) {
			IDiagramGraphicalViewer viewer = (IDiagramGraphicalViewer)diagramEditPart
					.getViewer();

			String elementID = EMFCoreUtil.getProxyID(element);
			List<?> foundEditParts = viewer.findEditPartsForElement(elementID,
					IGraphicalEditPart.class);
			for(Iterator<?> iterator = foundEditParts.iterator(); iterator
					.hasNext();) {
				EditPart editPart = (EditPart)iterator.next();
				if(!(editPart instanceof DiagramEditPart)) {
					return editPart;
				}
			}
			return null;
		}
	}

	protected static String getDiagramName(EObject diagramDomainElement) {
		String result = null;
		if(diagramDomainElement instanceof NamedElement) {
			NamedElement named = (NamedElement)diagramDomainElement;
			result = named.getQualifiedName();
			if(result == null || result.length() == 0) {
				result = named.getName();
			}
		}
		return result;
	}
}
