package org.hu.richrail.fxmlController;

import javafx.stage.Window;
import org.hu.richrail.model.TrainManager;

public abstract class Controller {
    protected TrainManager trainManager = TrainManager.getInstance();
    Window parentWindow;

    abstract void init(Window window);
}
