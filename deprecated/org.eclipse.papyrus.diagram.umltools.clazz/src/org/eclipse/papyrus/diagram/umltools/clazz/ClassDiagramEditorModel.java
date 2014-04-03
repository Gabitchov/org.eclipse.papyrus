package org.eclipse.papyrus.diagram.umltools.clazz;

import java.lang.reflect.Constructor;

import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.diagrameditor.EditorDescriptor;
import org.eclipse.papyrus.core.multidiagram.actionbarcontributor.ActionBarContributorRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * IEditorModel used by the SashEditor to create a nested editor.
 * Each nested editor instance is associated to one and only one instance of this model.
 * 
 * @author cedric dumoulin
 * 
 */
class ClassDiagramEditorModel implements IEditorModel {

	/**
	 * The Diagram object describing the diagram.
	 */
	private Diagram diagram;

	/**
	 * The servicesRegistry provided at creation.
	 */
	private ServicesRegistry servicesRegistry;

	/**
	 * Editor Descriptor containing data from the Eclipse extension
	 */
	private EditorDescriptor editorDescriptor;

	/**
	 * 
	 * Constructor.
	 *
	 * @param pageIdentifier
	 * @param servicesRegistry
	 * @param editorDescriptor
	 */
	public ClassDiagramEditorModel(Diagram pageIdentifier, ServicesRegistry servicesRegistry, EditorDescriptor editorDescriptor) {
		diagram = pageIdentifier;
		this.servicesRegistry = servicesRegistry;
		this.editorDescriptor = editorDescriptor;
	}

	/**
	 * Create the IEditor for the diagram.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel#createIEditorPart()
	 * @return
	 * @throws PartInitException
	 * 
	 */
	public IEditorPart createIEditorPart() throws PartInitException {
		GraphicalEditor editor;
		try {
			editor = new UmlClassDiagramForMultiEditor(servicesRegistry, diagram);
		} catch (BackboneException e) {
			throw new PartInitException("Can't create instance of " + UmlClassDiagramForMultiEditor.class.getName(), e);
		} catch (ServiceException e) {
			throw new PartInitException("Can't create instance of " + UmlClassDiagramForMultiEditor.class.getName(), e);
		}

		return editor;

	}

	/**
	 * Get the action bar requested by the Editor.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IEditorModel#getActionBarContributor()
	 * @return
	 * 
	 */
	public EditorActionBarContributor getActionBarContributor() {

		String actionBarId = editorDescriptor.getActionBarContributorId();

		// Do nothing if no EditorActionBarContributor is specify.
		if(actionBarId == null || actionBarId.length() == 0) {
			return null;
		}

		// Try to get it.

		// Get ServiceRegistry
		// ServicesRegistry serviceRegistry = getServicesRegistry();
		ActionBarContributorRegistry registry;
		try {
			registry = (ActionBarContributorRegistry)servicesRegistry.getService(ActionBarContributorRegistry.class);
		} catch (ServiceException e) {
			// Service not found
			// TODO Log the error
			e.printStackTrace();
			return null;
		}

		try {
			return registry.getActionBarContributor(actionBarId);
		} catch (BackboneException e) {
			// TODO Log the error and throw an exception instead
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Get the underlying RawModel. Return the Diagram.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getRawModel()
	 * @return
	 * 
	 */
	public Object getRawModel() {
		return diagram;
	}

	/**
	 * Get the icon to be shown by Tabs
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getTabIcon()
	 * @return
	 * 
	 */
	public Image getTabIcon() {
		ImageDescriptor imageDescriptor = editorDescriptor.getIcon();
		if(imageDescriptor == null)
			return null;

		return imageDescriptor.createImage();
	}

	/**
	 * Get the title of the Diagram.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.IPageModel#getTabTitle()
	 * @return
	 * 
	 */
	public String getTabTitle() {
		return diagram.getName();
	}

}
