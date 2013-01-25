package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.nattable.model.nattable.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage;


public class EObjectManager extends AbstractAxisManager{



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
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDataValue(final int columnIndex, final int rowIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// TODO Auto-generated method stub

	}

	public int getColumnCount() {
		return getRepresentedContentProvider().getAxis().size();
	}

	public int getRowCount() {
		return getRepresentedContentProvider().getAxis().size();
	}

	public Object getHeaderDataValue(final int columnIndex, final int rowIndex) {

		return null;

	}

	public int getHeaderColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getHeaderRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setHeaderDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// TODO Auto-generated method stub

	}

	public List<?> getAllVisibleAxis() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<?> getAllCurrentPossibleAxis() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<?> getAllExistingAxis() {
		//we should avoid to calculate it each time!
		final List<EObject> elements = new ArrayList<EObject>();
		for(final IAxis current : getRepresentedContentProvider().getAxis()) {
			elements.add((EObject)current.getElement());
		}
		return elements;
	}

	public List<String> getEncapsulatedAxisManager() {
		// TODO Auto-generated method stub
		return null;
	}



}
