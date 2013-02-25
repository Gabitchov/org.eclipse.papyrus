package org.eclipse.papyrus.uml.nattable.celleditor.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.edit.editor.AbstractCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.ComboBoxCellEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.nattable.common.manager.INattableModelManager;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.labelprovider.service.impl.LabelProviderServiceImpl;
import org.eclipse.papyrus.infra.widgets.editors.ReferenceCombo;
import org.eclipse.papyrus.infra.widgets.providers.HierarchicToFlatContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.TreeToFlatContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


public class SingleReferenceComboCellEditor extends 	AbstractCellEditor{

	private ReferenceCombo referenceCombo;

	private final INattableModelManager manager;

	public SingleReferenceComboCellEditor(final INattableModelManager manager) {

		this.manager = manager;
	}

	@Override
	public Object getEditorValue() {
		return this.referenceCombo.getValue();
	}

	@Override
	public void setEditorValue(Object value) {
		this.referenceCombo.setValue(value);

	}

	@Override
	public Control getEditorControl() {
		return this.referenceCombo;
	}

	@Override
	public Control createEditorControl(Composite parent) {
		this.referenceCombo = new ReferenceCombo(parent, SWT.NONE);

		return this.referenceCombo;
	}

	@Override
	protected Control activateCell(Composite parent, Object originalCanonicalValue) {
		this.referenceCombo = (ReferenceCombo)createEditorControl(parent);
		int columnIndex = this.layerCell.getColumnIndex();
		int rowIndex = this.layerCell.getRowIndex();

		final Object row = this.manager.getColumnElement(columnIndex);
		final Object col = this.manager.getRowElemen(rowIndex);

		final EObject eobject;
		final EStructuralFeature feature;
		if(row instanceof EStructuralFeature) {
			feature = (EStructuralFeature)row;
			eobject = (EObject)col;
		} else {
			feature = (EStructuralFeature)col;
			eobject = (EObject)row;
		}
		LabelProviderService serv = null;
		try {
			serv = ServiceUtilsForEObject.getInstance().getServiceRegistry(eobject).getService(LabelProviderService.class);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		ServiceUtilsForEObject.getInstance().getServiceRegistry(eobject).getService(ContentP.class);
		this.referenceCombo.setLabelProvider(serv.getLabelProvider(eobject));
		UMLContentProvider provider = new UMLContentProvider(eobject, feature, null, eobject.eResource().getResourceSet());
		final TreeToFlatContentProvider flatP = new HierarchicToFlatContentProvider(provider);
		final List<Object> list = Arrays.asList(flatP.getElements());
		final List<EObject> availableValues = new ArrayList<EObject>();
		final Iterator<Object> iter = list.iterator();
		while(iter.hasNext()) {
			final Object current = iter.next();
			if(current instanceof EObject) {
				availableValues.add((EObject)current);
			}
		}
		this.referenceCombo.setContentProvider(flatP);
		//		int originalColumnPosition = this.layerCell.getOriginColumnPosition();
		//		int originalRowPosition = layerCell.getOriginRowPosition();
		return this.referenceCombo;
	}


}
