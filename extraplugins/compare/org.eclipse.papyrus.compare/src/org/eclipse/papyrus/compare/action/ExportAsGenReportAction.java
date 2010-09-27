package org.eclipse.papyrus.compare.action;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.compare.diff.metamodel.ComparisonSnapshot;
import org.eclipse.emf.compare.ui.export.IExportAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.compare.Activator;
import org.eclipse.papyrus.compare.report.ui.common.GenerateAll;
import org.eclipse.swt.graphics.Image;
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
		GenerateAll generator = new GenerateAll(snapshot, null, getArguments());
	}

	public Image getDisabledImage() {
		return myImage;
	}

	public Image getEnabledImage() {
		return myImage;
	}
	
	protected List<? extends Object> getArguments() {
		return new ArrayList<String>();
	}



}
