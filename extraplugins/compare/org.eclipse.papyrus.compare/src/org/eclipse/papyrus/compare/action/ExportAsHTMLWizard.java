package org.eclipse.papyrus.compare.action;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSetSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.ui.internal.wizard.SaveDeltaWizard;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.compare.report.ui.common.GenerateAll;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;


public class ExportAsHTMLWizard extends SaveDeltaWizard {
	
	private static final String HTML_EXTENSION = "html";

	private WizardNewFileCreationPage myNewReportFileCreationPage;

	private IResource myFirstSelectedFile;

	public ExportAsHTMLWizard() {
		super(null); // use default extension
	}


	public void init(IWorkbench workbench, ComparisonSnapshot inputSnapshot) {
		super.init(workbench, inputSnapshot);
		Resource firstSelectedResource = getFirstSelectedResource(getDiffModel(inputSnapshot));
		myFirstSelectedFile = ResourcesPlugin.getWorkspace().getRoot().findMember(firstSelectedResource.getURI().toPlatformString(true));
	}

	private DiffModel getDiffModel(ComparisonSnapshot inputSnapshot) {
		if(inputSnapshot instanceof ComparisonResourceSnapshot) {
			return ((ComparisonResourceSnapshot)inputSnapshot).getDiff();
		} else {
			EList<DiffModel> diffModels = ((ComparisonResourceSetSnapshot)inputSnapshot).getDiffResourceSet().getDiffModels();
			if(!diffModels.isEmpty()) {
				return diffModels.get(0);
			} else {
				// log;
				return null;
			}
		}
	}

	private Resource getFirstSelectedResource(DiffModel diffModel) {
		EList<EObject> leftRoots = diffModel.getLeftRoots();
		if(leftRoots.isEmpty()) {
			// log
			return null;
		}
		return leftRoots.get(0).eResource();
	}

	@Override
	public IStructuredSelection getSelection() {
		IStructuredSelection result = super.getSelection();
		if(result == null || result.isEmpty() && myFirstSelectedFile != null) {
			return new StructuredSelection(myFirstSelectedFile);
		}
		return result;
	}

	public void addPages() {
		super.addPages();
		findNewDiffFilePage().setAllowExistingResources(true);

		myNewReportFileCreationPage = new WizardNewFileCreationPage("newFilePage1", getSelection());//$NON-NLS-1$
		myNewReportFileCreationPage.setFileName(getDefaultFileName() + "." + HTML_EXTENSION);
		myNewReportFileCreationPage.setAllowExistingResources(true);
		myNewReportFileCreationPage.setTitle("New HTML File");
		myNewReportFileCreationPage.setDescription("Create a new HTML file");
		myNewReportFileCreationPage.setFileExtension(HTML_EXTENSION);
		addPage(myNewReportFileCreationPage);
	}

	@Override
	public boolean performFinish() {
		boolean result = super.performFinish();
		if(!result) {
			return false;
		}

		IProgressMonitor monitor = new NullProgressMonitor();
		IResource targetFolder = getTargetFolder();
		GenerateAll generator = new GenerateAll(getNewDiffModelURI(), targetFolder.getLocation().toFile(), getTemplateArguments());

		try {
			generator.doGenerate(monitor);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				targetFolder.refreshLocal(IResource.DEPTH_INFINITE, monitor);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	private String getDefaultFileName() {
		return "result";
	}

	private List<? extends Object> getTemplateArguments() {
		return Collections.singletonList(myNewReportFileCreationPage.getFileName());
	}

	private IResource getTargetFolder() {
		return ResourcesPlugin.getWorkspace().getRoot().findMember(myNewReportFileCreationPage.getContainerFullPath());
	}

	private WizardNewFileCreationPage findNewDiffFilePage() {
		final String page = "newFilePage1"; //$NON-NLS-1$
		return (WizardNewFileCreationPage)getPage(page);
	}

	private URI getNewDiffModelURI() {
		WizardNewFileCreationPage saveDiffPage = findNewDiffFilePage();
		IPath filePath = saveDiffPage.getContainerFullPath().append(saveDiffPage.getFileName());
		IFile fileHandle = ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);
		return URI.createFileURI(fileHandle.getLocation().toOSString());
	}

}
