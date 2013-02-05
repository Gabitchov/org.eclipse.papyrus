package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.model.nattable.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage;

/**
 *
 * This manager is a master manager, that's to say, it doesn't listen the contents of the others managers.
 * This manager modify the model for each changes on axis (so each axis is stored)
 *
 */
public class EObjectManager extends AbstractAxisManager {

	/**
	 * this listener allows to know when there is change in the managed axis provider
	 */
	private Adapter listener;

	/**
	 * the list of the elements represented by this axis
	 */
	private List<EObject> elements;

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#getAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 *
	 * @param domain
	 *        the editing domain
	 * @param objectToAdd
	 *        the object to add to this axis
	 * @return
	 *         the command to create the required axis in the model
	 */
	@Override
	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		final CompoundCommand cmd = new CompoundCommand("Add Axis Element");
		for(final Object object : objectToAdd) {
			//FIXME : we should verify that this contents is allowed before to add it (probably into the DropListener
			if(object instanceof EObject) {
				final EObjectAxis horizontalAxis = NattableFactory.eINSTANCE.createEObjectAxis();
				horizontalAxis.setElement((EObject)object);
				final Command tmp = AddCommand.create(domain, getRepresentedContentProvider(), NattablecontentproviderPackage.eINSTANCE.getDefaultContentProvider_Axis(), horizontalAxis);
				cmd.append(tmp);
			}
		}
		return cmd;
	}

	@Override
	public void init(final INattableModelManager manager, final String managerId, final Table table, final IAxisContentsProvider provider) {
		super.init(manager, managerId, table, provider);
		this.elements = new ArrayList<EObject>();
		contentsCalculus();
		//we add a listener to be notified when there is changes in the axis provider
		this.listener = new AdapterImpl() {

			@Override
			public void notifyChanged(final Notification msg) {
				if(NattablecontentproviderPackage.eINSTANCE.getDefaultContentProvider_Axis() == msg.getFeature()) {
					contentsCalculus();
					((NattableModelManager)getTableManager()).refreshNattable();
				}
			}
		};
		provider.eAdapters().add(this.listener);
	}

	/**
	 * calculus of the contents of the axis
	 */
	protected synchronized void contentsCalculus() {
		final List<EObject> newContents = new ArrayList<EObject>();
		for(final IAxis current : getRepresentedContentProvider().getAxis()) {
			if(current instanceof EObjectAxis) {
				final EObject element = (EObject)current.getElement();
				newContents.add(element);
			}
		}
		//FIXME, with Glazed List, maybe we should update the list instead of erase all values;
		this.elements.clear();
		this.elements.addAll(newContents);
	}

	/**
	 * This manager doesn't add axis on the other side, because it is a master axis manager
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#getComplementaryAddAxisCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.util.Collection)
	 *
	 * @param domain
	 * @param objectToAdd
	 * @return
	 */
	@Override
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		return null;
	}

	public List<String> getEncapsulatedAxisManager() {
		return Collections.emptyList();
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#dispose()
	 *
	 */
	@Override
	public void dispose() {
		getRepresentedContentProvider().eAdapters().remove(this.listener);
		super.dispose();
	}

	/**
	 * called when the manager is used vertically
	 */
	public int getColumnCount() {
		return this.elements.size();
	}

	/**
	 * called when the manager is used horizontally
	 */

	public int getRowCount() {
		return this.elements.size();
	}

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.common.manager.AbstractAxisManager#getAllExistingAxis()
	 *
	 * @return
	 */
	@Override
	public List<?> getAllExistingAxis() {
		return this.elements;
	}



}
