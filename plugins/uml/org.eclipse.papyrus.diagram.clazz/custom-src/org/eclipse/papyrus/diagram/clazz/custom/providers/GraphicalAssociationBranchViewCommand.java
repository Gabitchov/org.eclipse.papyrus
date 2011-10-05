package org.eclipse.papyrus.diagram.clazz.custom.providers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiAssociationHelper;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.uml2.uml.Property;

public class GraphicalAssociationBranchViewCommand extends CommonDeferredCreateConnectionViewCommand {



	private Object associationEndWrapper;

	/**
	 * {@inheritDoc}
	 */
	public GraphicalAssociationBranchViewCommand(TransactionalEditingDomain editingDomain, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ConnectionViewDescriptor viewDescriptor,Object associationEndWrapper) {
		super(editingDomain, ((IHintedType)UMLElementTypes.Association_4019).getSemanticHint(), sourceViewAdapter, targetViewAdapter, viewer, preferencesHint, viewDescriptor, null);
		this.associationEndWrapper=associationEndWrapper;
	}

	/**
	 * {@inheritDoc}
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		CommandResult commandResult = null;
		commandResult = super.doExecuteWithResult(progressMonitor, info);
		View view=((View)(viewDescriptor.getAdapter(View.class)));
		MultiAssociationHelper.createSemanticBranchStyles(view);
		EObject associationEnd=null;
		if(associationEndWrapper instanceof CreateElementRequest){
			associationEnd=((CreateElementRequest)associationEndWrapper).getNewElement();}
		if(associationEndWrapper instanceof Property){
			associationEnd=(Property)associationEndWrapper;
		}
		if(associationEnd!=null && associationEnd instanceof Property){
			MultiAssociationHelper.setSemanticBranchEnd(view, (Property)associationEnd);
		}

		return commandResult;
	}

}
