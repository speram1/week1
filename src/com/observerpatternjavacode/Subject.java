package com.observerpatternjavacode;

public interface Subject {

	void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();

    Object getUpdate();
    void postMessage(String message);
}
