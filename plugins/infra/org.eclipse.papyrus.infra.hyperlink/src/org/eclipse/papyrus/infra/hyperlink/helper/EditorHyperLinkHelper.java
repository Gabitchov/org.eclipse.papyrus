package org.eclipse.papyrus.infra.hyperlink.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkEditor;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkWeb;
import org.eclipse.papyrus.infra.hyperlink.ui.EditorHyperLinkEditorShell;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkEditorHelperRegistration;


public class EditorHyperLinkHelper extends AbstractHyperLinkHelper {

	
	@Override
	public String getNameofManagedHyperLink() {
		return "Editor";
	}

	@Override
	public void executeNewMousePressed(List<HyperLinkObject> list, EObject aModel) {
		IPageIconsRegistry editorRegistry = null;
		IMultiDiagramEditor papyrusEditor = EditorUtils.getMultiDiagramEditor();
		try {
			editorRegistry = papyrusEditor.getServicesRegistry().getService(IPageIconsRegistry.class);
		} catch (ServiceException e) {
			Activator.log.error(e);
		}
		EditorHyperLinkEditorShell editor = new EditorHyperLinkEditorShell(editorRegistry, aModel);
		editor.open();//TODO and the cancel?
		if(editor.getHyperLinkEditor() != null) {
				list.add(editor.getHyperLinkEditor());
		}
	}

	@Override
	public ArrayList<HyperLinkObject> getFilteredObject(List<HyperLinkObject> hyperLinkObjects) {
		ArrayList<HyperLinkObject> result= new ArrayList<HyperLinkObject>();
		Iterator<HyperLinkObject> iterator= hyperLinkObjects.iterator();
		while(iterator.hasNext()) {
			HyperLinkObject current = iterator.next();
			if(current instanceof HyperLinkEditor){
				result.add(current);
			}
		}
		return result;
	}

	
	@Override
	public HyperLinkObject getHyperLinkObject(EAnnotation eAnnotation) {
		return getHyperLinkObjectFor(eAnnotation);
	}
	@Override
	public RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperLinkObject HyperLinkObject) {
		Collection<AbstractHyperLinkEditorHelper> helpers = HyperLinkEditorHelperRegistration.INSTANCE.getAllRegisteredHyperLinkEditorHelper();
		for(AbstractHyperLinkEditorHelper current : helpers) {
			RecordingCommand cmd = current.getAddHyperLinkCommand(domain, object, HyperLinkObject);
			if(cmd != null) {
				return cmd;
			}
		}
		return null;
	}

	public HyperLinkEditor getHyperLinkObjectFor(Object s) {// create an interface for this method?
		Collection<AbstractHyperLinkEditorHelper> helpers = HyperLinkEditorHelperRegistration.INSTANCE.getAllRegisteredHyperLinkEditorHelper();
		for(AbstractHyperLinkEditorHelper current : helpers) {
			HyperLinkEditor object = current.getHyperLinkObjectFor(s);
			if(object != null) {
				return object;
			}
		}
		return null;
	}

	public HyperLinkEditor getHyperLinkObjectFor(EAnnotation eAnnotation) {// create an interface for this method?
		Collection<AbstractHyperLinkEditorHelper> helpers = HyperLinkEditorHelperRegistration.INSTANCE.getAllRegisteredHyperLinkEditorHelper();
		for(AbstractHyperLinkEditorHelper current : helpers) {
			HyperLinkEditor object = current.getHyperLinkObjectForEAnnotation(eAnnotation);
			if(object != null) {
				return object;
			}
		}
		return null;
	}
}
