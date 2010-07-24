package org.eclipse.papyrus.sasheditor.ui.views;

import org.eclipse.papyrus.sasheditor.editor.IPage;
import org.eclipse.papyrus.sasheditor.ui.views.SashWindowsViewModel.IModelChangedListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;


/**
 * An Eclipse View showing data from the SashWindows.
 * This class is an example showing how to have a UI following changes from editors
 * and sash windows.
 */

public class SashWindowsViewPart extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.papyrus.sasheditor.ui.views.SashWindowsView";

	/** Class managing selected element rendering */
	private SashWindowsView figure;

	/** The model to be rendered */
	private SashWindowsViewModel model;

	/**
	 * Listener on model changed events.
	 */
	private IModelChangedListener modelChangedListener = new IModelChangedListener() {

		public void modelChanged(SashWindowsViewModel changedModel) {
			refreshView();
		}
	};



	/**
	 * The constructor.
	 */
	public SashWindowsViewPart() {
	}


	/**
	 * Refresh the SWT view with values from the specified element
	 */
	private void refreshView() {

		// selected element
		Object selectedElement = getModel().getSelectedElement();
		if(selectedElement != null) {
			figure.setselectedElement(selectedElement.toString());
		} else {
			figure.setselectedElement("");
		}

		// selected page
		IPage page = getModel().getSelectedSashWindowsPage();
		if(page != null) {
			figure.setSelectedPage(page.toString());
			figure.setSelectedPageName(page.getPageTitle());
			//			figure.setSelectedPageIcon(page.getPageIcon());			
		} else {
			figure.setSelectedPage("");
			figure.setSelectedPageName("");
			//			figure.setSelectedPageIcon(null);			
		}

		// selected folder
		//		selectedElementViewer.setSelectedFolder(getModel().getSelectedFolder().toString());
		// selected Editor
		IEditorPart editor = getModel().getSelectedIEditorPart();
		if(editor != null) {
			figure.setSelectedIEditor(editor.toString());
			figure.setSelectedIEditorName(editor.getTitle());
		} else {
			figure.setSelectedIEditor("");
			figure.setSelectedIEditorName("");
		}


	}

	/**
	 * 
	 * @return
	 */
	private SashWindowsViewModel getModel() {
		return model;
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {

		Composite container = parent;

		figure = new SashWindowsView();
		figure.createPartControl(container);
	}

	/**
	 * Initialize the view
	 * 
	 * @see org.eclipse.ui.part.ViewPart#init(org.eclipse.ui.IViewSite)
	 * 
	 * @param site
	 * @throws PartInitException
	 */
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		model = new SashWindowsViewModel(site.getPage());
		model.getListenersManager().addModelChangedListener(modelChangedListener);
	}

	@Override
	public void dispose() {
		model.getListenersManager().removeModelChangedListener(modelChangedListener);
		model.dispose();
		figure.dispose();
		super.dispose();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		//		viewer.getControl().setFocus();
		figure.setFocus();
	}

}
