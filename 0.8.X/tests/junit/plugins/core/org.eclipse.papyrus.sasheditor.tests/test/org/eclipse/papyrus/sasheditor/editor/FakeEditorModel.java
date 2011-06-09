/**
 * 
 */
package org.eclipse.papyrus.sasheditor.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;
import org.eclipse.ui.part.EditorPart;


/**
 * A simple model that can be used as editor in tests.
 * @author cedric dumoulin
 *
 */
public class FakeEditorModel  implements IEditorModel {

	
	private String name;

	public FakeEditorModel() {
		name = "noname";
	}
	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getTabTitle()
	 *
	 * @return
	 */
	public String getTabTitle() {
		return name;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getTabIcon()
	 *
	 * @return
	 */
	public Image getTabIcon() {
		return null;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getRawModel()
	 *
	 * @return
	 */
	public Object getRawModel() {
		// TODO Auto-generated method stub
		return this;
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel#createIEditorPart()
	 *
	 * @return
	 * @throws PartInitException
	 */
	public IEditorPart createIEditorPart() throws PartInitException {
		return new FakeEditorPart();
	}

	/**
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel#getActionBarContributor()
	 *
	 * @return
	 */
	public EditorActionBarContributor getActionBarContributor() {
		return null;
	}

	/**
	 * A class implementing a fake editor.
	 * @author dumoulin
	 *
	 */
	public class FakeEditorPart extends EditorPart {

		@Override
		public void doSave(IProgressMonitor monitor) {
		}

		@Override
		public void doSaveAs() {
		}

		@Override
		public void init(IEditorSite site, IEditorInput input) throws PartInitException {
			setSite(site);
			setInput(input);
			setPartName(input.getName());
		}

		@Override
		public boolean isDirty() {
			return false;
		}

		@Override
		public boolean isSaveAsAllowed() {
			return false;
		}

		@Override
		public void createPartControl(Composite parent) {
			// do nothing
			
		}

		@Override
		public void setFocus() {
		}
		
	}
}
