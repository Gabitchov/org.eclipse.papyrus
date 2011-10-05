/**
 * 
 */
package org.eclipse.papyrus.diagram.umltools.clazz;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.l10n.EditorMessages;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.papyrus.core.adaptor.gmf.GmfMultiDiagramDocumentProvider;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditor;

/**
 * An editor to be used in multitabs editor. This editor extends the original UML Activity Diagram.
 * 
 * @author dumoulin
 * 
 */
public class UmlClassDiagramForMultiEditor extends UMLDiagramEditor {

	/**
	 * The diagram shown by this editor.
	 */
	private Diagram diagram;

	/**
	 * 
	 */
	private ServicesRegistry servicesRegistry;
	
	/**
	 * Constructor for SashSystem v2. Context and required objects are retrieved from the
	 * ServiceRegistry.
	 * 
	 * @throws BackboneException
	 * @throws ServiceException
	 * 
	 */
	public UmlClassDiagramForMultiEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws BackboneException, ServiceException {
		this.servicesRegistry = servicesRegistry;
		this.diagram = diagram;
		
		// Share the same editing provider
		TransactionalEditingDomain editingDomain = servicesRegistry.getService(TransactionalEditingDomain.class);
		GmfMultiDiagramDocumentProvider documentProvider = new GmfMultiDiagramDocumentProvider(editingDomain);

		// overrides editing domain created by super constructor
		setDocumentProvider(documentProvider);

	}

	/**
	 * @return the diagram
	 */
	public Diagram getDiagram() {
		return diagram;
	}

	/**
	 * @param diagram
	 *            the diagram to set
	 */
	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
	}

	/**
	 * Change visibility to public.
	 */
	@Override
	public GraphicalViewer getGraphicalViewer() {
		return super.getGraphicalViewer();
	}

	/**
	 * 
	 */
	final protected IDocumentProvider getDocumentProvider(IEditorInput input) {
		// System.out.println("getDocumentProvider(IEditorInput input)");
		if (input instanceof IFileEditorInput || input instanceof URIEditorInput) {
			throw new UnsupportedOperationException("TODO !!!");
		}
		return super.getDocumentProvider(input);
	}

	/**
	 * @generated
	 */
	protected void setDocumentProvider(IEditorInput input) {
        // Already set in the constructor.
	}

	/**
	 * 
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		// Set name after calling super.init()
		setPartName(getDiagram().getName());
	}

	/**
	 * 
	 */
	@Override
	public void setInput(IEditorInput input) {
		try {
			// We are in a nested editor.
			// Provide an URI with fragment in order to reuse the same Resource and to
			// set the diagram to the fragment.
			// First, compute the URI
			URIEditorInput uriInput = new URIEditorInput(EcoreUtil.getURI(diagram));
			System.err.println(this.getClass().getSimpleName() + ".setInput(" + uriInput.toString() + ")");
			doSetInput(uriInput, true);
		} catch (CoreException x) {
			String title = EditorMessages.Editor_error_setinput_title;
			String msg = EditorMessages.Editor_error_setinput_message;
			Shell shell = getSite().getShell();
			ErrorDialog.openError(shell, title, msg, x.getStatus());
		}

	}

	Composite splitter;

	@Override
	protected void createGraphicalViewer(Composite parent) {
		System.out.println("store Composite " + parent);
		splitter = parent;
		super.createGraphicalViewer(parent);
	}

	@Override
	public void setFocus() {

		// System.out.println("setFocus( " + ((Object)splitter).hashCode() + "):" + splitter.getChildren());
		splitter.setFocus();

		super.setFocus();
	}

	public String getEditingDomainID() {
		return "org.eclipse.uml2.diagram.clazz.EditingDomain";
	}

}
