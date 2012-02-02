package org.eclipse.papyrus.emf.compare.transactional.editor.v2;

import org.eclipse.compare.CompareEditorInput;
import org.eclipse.compare.CompareViewerPane;
import org.eclipse.compare.CompareViewerSwitchingPane;
import org.eclipse.compare.ITypedElement;
import org.eclipse.compare.internal.CompareStructureViewerSwitchingPane;
import org.eclipse.compare.structuremergeviewer.IDiffContainer;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.emf.compare.transactional.editor.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.team.internal.ui.synchronize.SaveablesCompareEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.Saveable;


public class PapyrusSaveablesCompareEditorInput extends SaveablesCompareEditorInput {

	private String TRANSACTIONAL_COMPARE_EDITOR_IMAGE_PATH = "icons/papyrus_compare_editor.gif";
private ITypedElement left;

//TODO create an interface?
public ITypedElement getLeft() {
	return left;
}


//TODO create an interface?
public ITypedElement getRight() {
	return right;
}



private ITypedElement right;
	public PapyrusSaveablesCompareEditorInput(ITypedElement ancestor, ITypedElement left, ITypedElement right, IWorkbenchPage page) {
		super(ancestor, left, right, page);
		this.left = left;
		this.right = right;
	}

	

	protected Image fgTitleImage;


	public Image getTitleImage() {
		if(fgTitleImage == null) {
			fgTitleImage = Activator.getImage(TRANSACTIONAL_COMPARE_EDITOR_IMAGE_PATH);
		}
		return fgTitleImage;
	}


	public ImageDescriptor getImageDescriptor() {
		return ImageDescriptor.createFromImage(getTitleImage());
	}

	public String getToolTipText() {
		return getTitle();
	}

	public String getTitle() {
		String title = super.getTitle();
		return title.replaceFirst("Compare", "PapyrusCompare");
	}	
}
