package org.eclipse.papyrus.uml.nattable.celleditor.config;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.common.celleditor.configs.AbstractCellEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.common.manager.ITableAxisElementProvider;
import org.eclipse.papyrus.uml.nattable.celleditor.editor.MultiReferencesCellEditor;
import org.eclipse.uml2.uml.UMLPackage;


public class UMLMultiReferencesCellEditorConfiguration extends AbstractCellEditorConfiguration {


	public static final String EDITOR_ID = "UML_NAryReference_Dialog";



	public IDisplayConverter getDisplayConvert(ILabelProvider provider) {
		return new DefaultDisplayConverter() {

			public Object displayToCanonicalValue(ILayerCell cell, IConfigRegistry configRegistry, Object displayValue) {
				return displayValue;
			};
		};
	}

	public ICellPainter getCellPainter() {
		return null;
	}

	public Object getEditedType() {
		return UMLPackage.eINSTANCE.getElement();
	}

	public String getDisplayMode() {
		return DisplayMode.EDIT;
	}

	public boolean isMany() {
		return true;
	}

	public ICellEditor getICellEditor(Object axisElement, ITableAxisElementProvider elementProvider) {
		return new MultiReferencesCellEditor(elementProvider);
	}

	public String getEditorId() {
		return EDITOR_ID;
	}



}
