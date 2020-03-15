package com.example.tools.commons;

/**
 * Interface for Menu communication
 * @author Andrez
 */
public interface MenuCommunication {

    /**
     * Method useful for processing menu calls
     * @param currentButton The current button to be processed by a particular call inside an
     *                      activity
     */
    public void menuAction(int currentButton);
}
