package org.eclipse.papyrus.infra.services.resourceloading.editor;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IEditorModel;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorActionBarContributor;
import org.eclipse.ui.part.EditorPart;


/**
 * A simple model that can be used as editor in tests.
 *
 * @author cedric dumoulin
 *
 */
public class UnloadResourcesEditorModel implements IEditorModel {


	private String name;

	private final URI uri;

	public UnloadResourcesEditorModel(URI uri) {
		this.uri = uri;
		name = "Unresolved tab";
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel#getTabTitle()
	 *
	 * @return
	 */
	public String getTabTitle() {
		return name;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel#getTabIcon()
	 *
	 * @return
	 */
	public Image getTabIcon() {
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_INFO_TSK);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel#getRawModel()
	 *
	 * @return
	 */
	public Object getRawModel() {
		// TODO Auto-generated method stub
		return this;
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IEditorModel#createIEditorPart()
	 *
	 * @return
	 * @throws PartInitException
	 */
	public IEditorPart createIEditorPart() throws PartInitException {
		return new UnloadResourcesEditorPart(uri);
	}

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IEditorModel#getActionBarContributor()
	 *
	 * @return
	 */
	public EditorActionBarContributor getActionBarContributor() {
		return null;
	}

	/**
	 * A class implementing a fake editor.
	 *
	 * @author dumoulin
	 *
	 */
	public static class UnloadResourcesEditorPart extends EditorPart {

		private final URI unloadedUri;

		public UnloadResourcesEditorPart(URI uri) {
			unloadedUri = uri;
		}

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
			Composite compo = new Composite(parent, SWT.NONE);
			compo.setLayout(new GridLayout(2, false));
			Image image = NotificationBuilder.getSWTImage(SWT.ICON_INFORMATION, parent.getShell());
			Label label = new Label(compo, SWT.NONE);
			label.setImage(image);
			label.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));
			Text t = new Text(compo, SWT.None);
			t.setText("This diagram is contained in an unresolved resource : " + URI.decode(unloadedUri.trimFragment().toString()));
			t.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			t.setEditable(false);
			label.setBackground(t.getBackground());
			compo.setBackground(t.getBackground());
		}

		@Override
		public void setFocus() {
		}

	}
}
