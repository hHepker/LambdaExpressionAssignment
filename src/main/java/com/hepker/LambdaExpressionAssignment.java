/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hepker;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 *
 * @author Haley Hepker
 */
public class LambdaExpressionAssignment {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        System.out.println("Program starting...");
        
        ArrayList<Widget> widgets = new ArrayList<>();
        ArrayList<Widget> validWidgets = new ArrayList<>();

            Supplier<Widget> randomWidget;
                randomWidget = () -> new Widget(Widget.GetRandVal(),Widget.GetRandName());
            
            Predicate<Widget> validWidget = x ->(x.getValue()>=0);
            
            UnaryOperator<String> nameToLower = (nameLower) -> nameLower.toLowerCase();    
            
            for (int i = 0; i < 20; i++){
                Widget addWidget = randomWidget.get();
                widgets.add(addWidget);
            }
            
            widgets.forEach((widget) -> {
                boolean valid = validWidget.test(widget);

                if (valid) {
                    String newName = widget.getName();
                    newName = nameToLower.apply(widget.getName());
                    widget.setName(newName);
                    validWidgets.add(widget);
                }
            });
            
            Consumer<Widget> widgetPrinter = (Widget n) -> System.out.println("[ value: " + n.getValue() + "\t name:\t" + n.getName() + "]");
            validWidgets.forEach(widgetPrinter);
            
            System.out.println("Complete..");
    }
 
}

