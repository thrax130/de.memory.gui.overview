package de.memory.gui.overview;

import java.util.Properties;

import aQute.bnd.annotation.component.Component;
import de.memory.api.IMemoryModel;
import de.memory.api.IMemoryView;
import de.memory.api.IMemoryViewFactory;

@Component
public class OverviewMemoryFactory implements IMemoryViewFactory {
	private final Properties prop = new Properties();
	
	public OverviewMemoryFactory() {
		prop.put("type", "overview");
	}
	
	@Override
	public IMemoryView createView(IMemoryModel model) {
		OverviewMemory view = new OverviewMemory();
		view.activate();
		model.addView(view);
		return view;
	}

	@Override
	public Properties getProperties() {
		return prop;
	}

}
