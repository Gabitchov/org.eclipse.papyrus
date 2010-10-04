package org.eclipse.papyrus.compare.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.internal.wizard.SaveDeltaWizard;
import org.eclipse.emf.compare.util.ModelUtils;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.compare.report.ui.common.GenerateAll;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.ui.internal.wizards.newresource.ResourceMessages;
import org.eclipse.ui.wizards.newresource.BasicNewFileResourceWizard;


public class ExportAsHTMLWizard extends SaveDeltaWizard {

	private ComparisonSnapshot myInputSnapshot;

	private WizardNewFileCreationPage myNewReportFileCreationPage;

	public ExportAsHTMLWizard() {
		super(null);
	}


	public void init(IWorkbench workbench, ComparisonSnapshot inputSnapshot) {
		super.init(workbench, inputSnapshot);
		myInputSnapshot = inputSnapshot;
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
		final String page = "newFilePage1"; //$NON-NLS-1$
		WizardNewFileCreationPage saveDiffPage = ((WizardNewFileCreationPage)getPage(page));

		IPath filePath = saveDiffPage.getContainerFullPath().append(saveDiffPage.getFileName());
		IFile fileHandle = IDEWorkbenchPlugin.getPluginWorkspace().getRoot().getFile(filePath);
		URI uri = URI.createFileURI(fileHandle.getLocation().toOSString());
		GenerateAll generator = new GenerateAll(uri, fileHandle.getLocation().toFile().getParentFile(), getArguments());
		try {
			generator.doGenerate(new NullProgressMonitor());
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	protected List<? extends Object> getArguments() {
		return new ArrayList<String>();
	}


}
