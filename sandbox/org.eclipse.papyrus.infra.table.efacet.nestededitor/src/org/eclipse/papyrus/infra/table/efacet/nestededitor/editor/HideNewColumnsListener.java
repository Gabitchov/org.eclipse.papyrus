package org.eclipse.papyrus.infra.table.efacet.nestededitor.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Column;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.FeatureColumn;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Row;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TableFactory;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TablePackage;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidget;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetInternal;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.internal.modeled.model.validation.Feature;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.table.efacet.common.listener.AbstractTableTriggerListener;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.nestededitor.internal.copy.TableInstanceCommandFactory;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


public class HideNewColumnsListener extends AbstractTableTriggerListener {

	/**
	 * features already managed
	 */
	private Set<ETypedElement> featuresAlreadyManaged = new HashSet<ETypedElement>();

	public HideNewColumnsListener(final PapyrusTable table) {
		super(table);
		for(final Column column : table.getTable().getColumns()) {
			if(column instanceof FeatureColumn) {
				final ETypedElement element = ((FeatureColumn)column).getFeature();
				if(element instanceof EStructuralFeature) {
					featuresAlreadyManaged.add((EStructuralFeature)element);
				}
			}
		}
	}

	/**
	 * 
	 * @param notification
	 * a notification
	 * @return
	 * all the features of the object added in the table
	 */
	private Set<ETypedElement> getAllFeaturesObject(final Notification notification) {
		final Set<ETypedElement> newFeatures = new HashSet<ETypedElement>();
		final Object newValue = notification.getNewValue();
		if(newValue instanceof Row) {
			Row row = (Row)newValue;
			EObject element = row.getElement();
			Collection<EStructuralFeature> allFeatures = element.eClass().getEAllStructuralFeatures();
			newFeatures.addAll(allFeatures);
			newFeatures.removeAll(featuresAlreadyManaged);
		}

		return newFeatures;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.efacet.common.listener.AbstractTableTriggerListener#isManagedNotification(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 * @return
	 */
	@Override
	protected boolean isManagedNotification(Notification notification) {
		if(notification.getEventType() == Notification.ADD && notification.getNotifier() == this.table.getTable() && notification.getFeature() == TableFactory.eINSTANCE.getTablePackage().getTable_Rows()) {
			Object newValue = notification.getNewValue();
			if(newValue != null && newValue instanceof Row) {
				return true;//there is something to do for each new row 
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.efacet.common.listener.AbstractTableTriggerListener#getCommandName(org.eclipse.emf.common.notify.Notification)
	 *
	 * @param notification
	 * @return
	 */
	@Override
	protected String getCommandName(Notification notification) {
		return "Hide new columns command"; //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.efacet.common.listener.AbstractTableTriggerListener#getSynchronizationCommand(org.eclipse.emf.transaction.TransactionalEditingDomain, org.eclipse.emf.common.notify.Notification)
	 *
	 * @param domain
	 * @param notification
	 * @return
	 */
	@Override
	protected Command getSynchronizationCommand(final TransactionalEditingDomain domain, final Notification notification) {
		final Collection<ETypedElement> features = getAllFeaturesObject(notification);
		if(!features.isEmpty()) {
			featuresAlreadyManaged.addAll(features);
			final ITableWidgetInternal widget = getWidget();
			return TableInstanceCommandFactory.createHideColumnCommand(widget, domain, table.getTable(), features);
		}
		return null;
	}

	/**
	 * TODO EMF-Facet should provides a best way to hide columns programmatically
	 * @return
	 */
	private ITableWidgetInternal getWidget() {
		final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		Assert.isTrue(editor instanceof CoreMultiDiagramEditor);
		final IEditorPart activeEditor = ((CoreMultiDiagramEditor)editor).getActiveEditor();
		ITableWidgetProvider provider = (ITableWidgetProvider)activeEditor.getAdapter(ITableWidgetProvider.class);
		ITableWidget widget = provider.getTableWidget();
		if(widget instanceof ITableWidgetInternal) {
			return (ITableWidgetInternal)widget;
		}
		return null;
	}


}
