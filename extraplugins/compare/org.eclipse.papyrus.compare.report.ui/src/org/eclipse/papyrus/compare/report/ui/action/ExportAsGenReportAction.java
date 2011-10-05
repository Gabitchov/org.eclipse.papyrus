package org.eclipse.papyrus.compare.report.ui.action;

import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.export.IExportAction;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.compare.report.ui.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;


public class ExportAsGenReportAction implements IExportAction {

	private final String myText = "As HTML Report";

	private final String myToolTipText = "Export Diff Report in HTML format";
	
	private final String myImagePath = "icons/export_as_html.gif";

	private final Image myImage;

	public ExportAsGenReportAction() {
		myImage = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, myImagePath).createImage();
	}

	public String getText() {
		return myText;
	}

	public String getToolTipText() {
		return myToolTipText;
	}

	public void exportSnapshot(ComparisonSnapshot snapshot) {
		final ExportAsHTMLWizard wizard = new ExportAsHTMLWizard();
		final IWorkbench workbench = PlatformUI.getWorkbench();
		
		wizard.init(workbench, snapshot);
		final WizardDialog dialog = new WizardDialog(workbench.getActiveWorkbenchWindow().getShell(), wizard);
		dialog.open();

	}

	public Image getDisabledImage() {
		return myImage;
	}

	public Image getEnabledImage() {
		return myImage;
	}
	
}
