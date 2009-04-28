package org.eclipse.papyrus.diagram.clazzBis.part;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * @generated
 */
public class UMLNewDiagramFileWizard extends Wizard {

	/**
	 * @generated
	 */
	private WizardNewFileCreationPage myFileCreationPage;

	/**
	 * @generated
	 */
	private org.eclipse.papyrus.diagram.clazzBis.part.ModelElementSelectionPage diagramRootElementSelectionPage;

	/**
	 * @generated
	 */
	private TransactionalEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	public UMLNewDiagramFileWizard(URI domainModelURI, EObject diagramRoot, TransactionalEditingDomain editingDomain) {
		assert domainModelURI != null : "Domain model uri must be specified";
		assert diagramRoot != null : "Doagram root element must be specified";
		assert editingDomain != null : "Editing domain must be specified";

		myFileCreationPage = new WizardNewFileCreationPage(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLNewDiagramFileWizard_CreationPageName, StructuredSelection.EMPTY);
		myFileCreationPage.setTitle(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLNewDiagramFileWizard_CreationPageTitle);
		myFileCreationPage.setDescription(NLS.bind(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLNewDiagramFileWizard_CreationPageDescription,
				org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID));
		IPath filePath;
		String fileName = URI.decode(domainModelURI.trimFileExtension().lastSegment());
		if (domainModelURI.isPlatformResource()) {
			filePath = new Path(domainModelURI.trimSegments(1).toPlatformString(true));
		} else if (domainModelURI.isFile()) {
			filePath = new Path(domainModelURI.trimSegments(1).toFileString());
		} else {
			// TODO : use some default path
			throw new IllegalArgumentException("Unsupported URI: " + domainModelURI); //$NON-NLS-1$
		}
		myFileCreationPage.setContainerFullPath(filePath);
		myFileCreationPage.setFileName(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramEditorUtil.getUniqueFileName(filePath, fileName, "PapyrusUMLClass")); //$NON-NLS-1$

		diagramRootElementSelectionPage = new DiagramRootElementSelectionPage(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLNewDiagramFileWizard_RootSelectionPageName);
		diagramRootElementSelectionPage.setTitle(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLNewDiagramFileWizard_RootSelectionPageTitle);
		diagramRootElementSelectionPage.setDescription(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLNewDiagramFileWizard_RootSelectionPageDescription);
		diagramRootElementSelectionPage.setModelElement(diagramRoot);

		myEditingDomain = editingDomain;
	}

	/**
	 * @generated
	 */
	public void addPages() {
		addPage(myFileCreationPage);
		addPage(diagramRootElementSelectionPage);
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		List affectedFiles = new LinkedList();
		IFile diagramFile = myFileCreationPage.createNewFile();
		org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramEditorUtil.setCharset(diagramFile);
		affectedFiles.add(diagramFile);
		URI diagramModelURI = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		ResourceSet resourceSet = myEditingDomain.getResourceSet();
		final Resource diagramResource = resourceSet.createResource(diagramModelURI);
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(myEditingDomain, org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLNewDiagramFileWizard_InitDiagramCommand,
				affectedFiles) {

			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				int diagramVID = org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getDiagramVisualID(diagramRootElementSelectionPage.getModelElement());
				if (diagramVID != org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.VISUAL_ID) {
					return CommandResult.newErrorCommandResult(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLNewDiagramFileWizard_IncorrectRootError);
				}
				Diagram diagram = ViewService.createDiagram(diagramRootElementSelectionPage.getModelElement(), org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID,
						org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				diagramResource.getContents().add(diagram);
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
			diagramResource.save(org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramEditorUtil.getSaveOptions());
			org.eclipse.papyrus.diagram.clazzBis.part.UMLDiagramEditorUtil.openDiagram(diagramResource);
		} catch (ExecutionException e) {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
		} catch (IOException ex) {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Save operation failed for: " + diagramModelURI, ex); //$NON-NLS-1$
		} catch (PartInitException ex) {
			org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.getInstance().logError("Unable to open editor", ex); //$NON-NLS-1$
		}
		return true;
	}

	/**
	 * @generated
	 */
	private static class DiagramRootElementSelectionPage extends org.eclipse.papyrus.diagram.clazzBis.part.ModelElementSelectionPage {

		/**
		 * @generated
		 */
		protected DiagramRootElementSelectionPage(String pageName) {
			super(pageName);
		}

		/**
		 * @generated
		 */
		protected String getSelectionTitle() {
			return org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLNewDiagramFileWizard_RootSelectionPageSelectionTitle;
		}

		/**
		 * @generated
		 */
		protected boolean validatePage() {
			if (selectedModelElement == null) {
				setErrorMessage(org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLNewDiagramFileWizard_RootSelectionPageNoSelectionMessage);
				return false;
			}
			boolean result = ViewService.getInstance().provides(
					new CreateDiagramViewOperation(new EObjectAdapter(selectedModelElement), org.eclipse.papyrus.diagram.clazzBis.edit.parts.PackageEditPart.MODEL_ID,
							org.eclipse.papyrus.diagram.clazzBis.part.UMLClazzDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT));
			setErrorMessage(result ? null : org.eclipse.papyrus.diagram.clazzBis.part.Messages.UMLNewDiagramFileWizard_RootSelectionPageInvalidSelectionMessage);
			return result;
		}
	}
}
