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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.internal.wizard.SaveDeltaWizard;
import org.eclipse.papyrus.compare.report.ui.common.GenerateAll;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;


public class ExportAsHTMLWizard extends SaveDeltaWizard {

	private WizardNewFileCreationPage myNewReportFileCreationPage;

	public ExportAsHTMLWizard() {
		super(null);
	}


	public void init(IWorkbench workbench, ComparisonSnapshot inputSnapshot) {
		super.init(workbench, inputSnapshot);
	}

	public void addPages() {
		super.addPages();

		myNewReportFileCreationPage = new WizardNewFileCreationPage("newFilePage1", getSelection());//$NON-NLS-1$
		myNewReportFileCreationPage.setFileName("result"); //$NON-NLS-1$
		myNewReportFileCreationPage.setAllowExistingResources(true);
		myNewReportFileCreationPage.setTitle("New HTML File");
		myNewReportFileCreationPage.setDescription("Create a new HTML file");
		myNewReportFileCreationPage.setFileExtension("html");
		addPage(myNewReportFileCreationPage);
	}

	@Override
	public boolean performFinish() {
		boolean result = super.performFinish();
		if (!result) {
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
