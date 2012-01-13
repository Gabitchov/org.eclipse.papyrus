package org.eclipse.papyrus.infra.hyperlink.helper;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkEditor;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;




public abstract class AbstractHyperLinkEditorHelper {

	public abstract HyperLinkEditor getHyperLinkObjectFor(final Object s);
	
	public abstract RecordingCommand getAddHyperLinkCommand(TransactionalEditingDomain domain, EModelElement object, HyperLinkObject hyperlinkObject);

	public abstract HyperLinkEditor getHyperLinkObjectForEAnnotation(EAnnotation eAnnotation) ;
	
}
