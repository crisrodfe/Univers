package com.crisrodfe.ui.university;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crisrodfe.module.entity.University;
import com.crisrodfe.services.university.ShowAllUniversitiesService;
import com.crisrodfe.ui.commons.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

/**
 * A factory for creating ShowUniversitiesLayout objects.
 */
@org.springframework.stereotype.Component
public class ShowUniversitiesLayoutFactory implements UIComponentBuilder{
	
	/** The universities. */
	private List<University> universities;
	
	/** The container. */
	private BeanItemContainer<University> container;

	/** The all universities service. */
	@Autowired
	private ShowAllUniversitiesService allUniversitiesService;
	
	/**
	 * The Class ShowUniversitiesLayout.
	 */
	private class ShowUniversitiesLayout extends VerticalLayout {

		/** The university table. */
		private Grid universityTable;
		
		/**
		 * Load.
		 *
		 * @return the show universities layout
		 */
		private ShowUniversitiesLayout load() {
			universities = allUniversitiesService.getAllUniversities();
			return this;
		}
		
		/**
		 * Inits the.
		 *
		 * @return the show universities layout
		 */
		private ShowUniversitiesLayout init() {
			setMargin(true);
			container = new BeanItemContainer<University>(University.class,universities);
			universityTable = new Grid(container);
			universityTable.setColumnOrder("universityName","universityCountry","universityCity");
			universityTable.removeColumn("id");
			universityTable.setImmediate(true);
			
			return this;
		}
		
		/**
		 * Layout.
		 *
		 * @return the show universities layout
		 */
		private ShowUniversitiesLayout layout() {
			addComponent(universityTable);
			return this;
		}
	}
	
	/**
	 * Refresh table.
	 */
	public void refreshTable() {
		universities = allUniversitiesService.getAllUniversities();
		container.removeAllItems();
		container.addAll(universities);
	}
	
	/* (non-Javadoc)
	 * @see com.crisrodfe.ui.commons.UIComponentBuilder#createComponent()
	 */
	public Component createComponent() {
		return new ShowUniversitiesLayout().load().init().layout();
	}
}
