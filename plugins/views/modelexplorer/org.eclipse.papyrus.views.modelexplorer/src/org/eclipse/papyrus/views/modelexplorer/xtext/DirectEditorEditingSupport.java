package org.eclipse.papyrus.views.modelexplorer.xtext;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.swt.widgets.Composite;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DirectEditorEditingSupport extends EditingSupport {

	public DirectEditorEditingSupport(ColumnViewer viewer) {
		super(viewer);
	}

	@Override
	protected CellEditor getCellEditor(final Object element) {
		ICustomDirectEditorConfiguration configuration = getConfiguration(element);
		EObject semanticObject = (EObject) ((IAdaptable) element).getAdapter(EObject.class);
		Composite parent = (Composite) getViewer().getControl();
		return configuration.createCellEditor(parent, semanticObject);
	}

	@Override
	protected boolean canEdit(Object element) {
		return getConfiguration(element) != null;
	}

	@Override
	protected Object getValue(Object element) {
		ICustomDirectEditorConfiguration configuration = getConfiguration(element);
		Object semanticObject = ((IAdaptable) element).getAdapter(EObject.class);
		return configuration.getTextToEdit(semanticObject);
	}

	@Override
	protected void setValue(Object element, Object value) {
		ICustomDirectEditorConfiguration configuration = getConfiguration(element);
		EObject semanticObject = (EObject) ((IAdaptable) element).getAdapter(EObject.class);
		IParser parser = configuration.createParser(semanticObject);

		ICommand command = parser.getParseCommand(new EObjectAdapter(semanticObject), (String) value, 0);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(semanticObject);
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
	}

	protected ICustomDirectEditorConfiguration getConfiguration(Object element) {
		if (element instanceof IAdaptable) {
			EObject semanticObject = (EObject) ((IAdaptable) element).getAdapter(EObject.class);
			IPreferenceStore store = Activator.getDefault().getPreferenceStore();
			String semanticClassName = semanticObject.eClass().getInstanceClassName();
			String key = IDirectEditorsIds.EDITOR_FOR_ELEMENT + semanticClassName;
			String languagePreferred = store.getString(key);

			if (languagePreferred != null && !languagePreferred.equals("")) {
				IDirectEditorConfiguration configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred,
						semanticClassName);
				if (configuration instanceof ICustomDirectEditorConfiguration) {
					return (ICustomDirectEditorConfiguration) configuration;
				}
			}
		}
		return null;
	}

}