package org.eclipse.papyrus.infra.hyperlink.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.hyperlink.object.EditorHyperLink;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.ui.EditorHyperLinkEditorShell;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkEditorHelperRegistration;
import org.eclipse.uml2.uml.Package;


public class EditorHyperLinkHelper extends AbstractHyperLinkHelper{

	@Override
	public String getNameofManagedHyperLink() {
		return "Editor";
	}

	@Override
	public void executeNewMousePressed(List<HyperLinkObject> list, Package amodel) {
		IPageIconsRegistry editorRegistry=null;
		IMultiDiagramEditor papyrusEditor=EditorUtils.getMultiDiagramEditor();
		try {
			editorRegistry= papyrusEditor.getServicesRegistry().getService(IPageIconsRegistry.class);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EditorHyperLinkEditorShell editor = new EditorHyperLinkEditorShell(editorRegistry, amodel);
		editor.open();//TODO and the cancel?
		if(editor.getHyperLinkEditor() != null) {
			list.add(editor.getHyperLinkEditor());
		}
		
	}

	@Override
	public ArrayList<HyperLinkObject> getFilteredObject(List<HyperLinkObject> HyperLinkObjects) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HyperLinkObject getHyperLinkObject(EAnnotation eAnnotation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperLinkObject HyperLinkObject) {
		// TODO Auto-generated method stub
		return null;
	}

	public EditorHyperLink getHyperLinkObjectFor(Object s) {// create an interface for this method?
		Collection<AbstractHyperLinkEditorHelper> helpers = HyperLinkEditorHelperRegistration.INSTANCE.getAllRegisteredHyperLinkEditorHelper();
		for(AbstractHyperLinkEditorHelper current : helpers){
			EditorHyperLink object = current.getHyperLinkObjectFor(s);
			if(object!=null){
				return object;
			}
		}
		return null;
	}

}
