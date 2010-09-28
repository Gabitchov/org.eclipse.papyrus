package org.eclipse.papyrus.compare.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
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
import org.eclipse.ui.wizards.newresource.BasicNewFileResourceWizard;


public class ExportAsHTMLWizard extends SaveDeltaWizard {

	public ExportAsHTMLWizard() {
		super("emfdiff");
	}

	private ComparisonSnapshot myInputSnapshot;

	public void init(IWorkbench workbench, ComparisonSnapshot inputSnapshot) {
		super.init(workbench, inputSnapshot);
		myInputSnapshot = inputSnapshot;
	}

	public void addPages() {
		super.addPages();
	}

	@Override
	public boolean performFinish() {
		GenerateAll generator = new GenerateAll(EcoreUtil.getURI(myInputSnapshot), null, getArguments());
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
