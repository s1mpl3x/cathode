package eu.over9000.cathode.resources;

import eu.over9000.cathode.Result;
import eu.over9000.cathode.data.RootBox;

/**
 * <pre>
 * /                                           GET			getRoot();
 * </pre>
 */
public interface Root {

	String PATH = "";

	Result<RootBox> getRoot();
}