package org.eclipse.papyrus.diagram.clazz.custom.edit.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.diagram.clazz.custom.helper.AssociationEndSourceLabelHelper;
import org.eclipse.papyrus.diagram.clazz.custom.helper.AssociationEndTargetLabelHelper;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationName3EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationName5EditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.IDirectEdition;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.ui.ExtendedDirectEditionDialog;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.ui.PlatformUI;


public class AssociationEndSourceEditPart extends AssociationName3EditPart {

	public AssociationEndSourceEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}
	
	 public EObject resolveSemanticElement() {
		 return AssociationEndTargetLabelHelper.getInstance().getUMLElement(this);
	 }
}
