package com.observerpatternjavacode;

import java.util.ArrayList;
import java.util.List;

public class SubjectDemo implements Subject {
    private List<Observer> observersList = null;
    private String message;

    public SubjectDemo() {
        observersList = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        observersList.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (observersList != null && !observersList.isEmpty()) {
            for (Observer observer : observersList) {
                observer.update(message);
            }
        } else {
            System.out.println("No observers to notify!!!");
        }
    }

    @Override
    public Object getUpdate() {
        return message;
    }

    @Override
    public void postMessage(String message) {
        System.out.println("Message posted on topic : " + message);
        this.message = message;
        notifyObservers();
    }
}