package org.eclipse.papyrus.widget.celleditors.uml.editors;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.facet.infra.common.core.internal.utils.ModelUtils;
import org.eclipse.emf.facet.widgets.celleditors.IListener;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditor;
import org.eclipse.papyrus.widget.celleditors.uml.composite.UnaryReferencePapyrusCellEditorComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


public class UnaryReferencePapyrusCellEditor implements IModelCellEditor {

	private UnaryReferencePapyrusCellEditorComposite cellEditorComposite;

	public Control activateCell(final Composite parent, final Object originalValue,
			final IModelCellEditHandler editHandler, final EStructuralFeature feature,
			final EObject source) {

		List<EObject> list = ModelUtils.computeAssignableElements(feature, source);

		this.cellEditorComposite = new UnaryReferencePapyrusCellEditorComposite(parent, list, source, feature);
		this.cellEditorComposite.addCommitListener(new IListener() {
			public void handleEvent() {
				editHandler.commit();
			}
		});

		return this.cellEditorComposite;
	}

	public Object getValue() {
		return this.cellEditorComposite.getValue();
	}
}