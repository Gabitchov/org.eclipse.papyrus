package org.eclipse.papyrus.infra.nattable.common.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;


public class CompositeAxisManager extends AbstractAxisManager {

	//	public static final String MANAGER_ID = "org.eclipse.papyrus.infra.nattable.common.composite.axis.manager";
	/**
	 * the managed managers
	 */
	protected List<IAxisManager> managers;

	/**
	 * Setter for {@link #managers}
	 *
	 * @param managers
	 *        the managers managed by this one
	 */
	public void setAxisManager(final List<IAxisManager> managers) {
		this.managers = managers;
	}


	public Object getDataValue(final int columnIndex, final int rowIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		// TODO Auto-generated method stub

	}

	public int getColumnCount() {
		if(isUsedVertically()) {
			int nbColumns = 0;
			for(final IAxisManager current : this.managers) {
				nbColumns += current.getColumnCount();
			}
			return nbColumns;
		} else {
			return 0;
		}
	}

	public int getRowCount() {
		if(isUsedHorizontally()){
				int nbColumns = 0;
				for(final IAxisManager current : this.managers) {
				nbColumns += current.getRowCount();
				}
				return nbColumns;
			}
		return 0;
	}

	@Override
	public void dispose() {
		for(final IAxisManager current : this.managers) {
			current.dispose();
		}
		this.managers.clear();
	}

	@Override
	public String getManagerId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canBeUsedHorizontally() {
		boolean answer = true;
		final Iterator<IAxisManager> iter = this.managers.iterator();
		while(iter.hasNext() && answer) {
			answer = iter.next().canBeUsedHorizontally();
		}
		return answer;
	}

	@Override
	public boolean canBeUsedVertically() {
		boolean answer = true;
		final Iterator<IAxisManager> iter = this.managers.iterator();
		while(iter.hasNext() && answer) {
			answer = iter.next().canBeUsedVertically();
		}
		return answer;
	}

	@Override
	public Command getAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		final CompoundCommand cmd = new CompoundCommand("Add Axis Command");
		for(final IAxisManager current : this.managers) {
			final Command tmp = current.getAddAxisCommand(domain, objectToAdd);
			if(tmp != null) {
				cmd.append(tmp);
			}
		}
		if(cmd.isEmpty()) {
			return null;
		}
		return cmd;
	}

	@Override
	public Command getComplementaryAddAxisCommand(final EditingDomain domain, final Collection<Object> objectToAdd) {
		final CompoundCommand cmd = new CompoundCommand("Add Axis Command");
		for(final IAxisManager current : this.managers) {
			final Command tmp = current.getComplementaryAddAxisCommand(domain, objectToAdd);
			if(tmp != null) {
				cmd.append(tmp);
			}
		}
		if(cmd.isEmpty()) {
			return null;
		}
		return cmd;
	}


	public Object getHeaderDataValue(final int columnIndex, final int rowIndex) {
		return getAllExistingAxis().get(columnIndex);
	}

	public int getHeaderColumnCount() {
		int i = 0;
		for(final IAxisManager current : this.managers) {
			i += current.getHeaderColumnCount();
		}
		return i;
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
		final List<Object> values = new ArrayList<Object>();
		for(final IAxisManager manager : this.managers) {
			values.addAll(manager.getAllExistingAxis());
		}
		return values;
	}





}
