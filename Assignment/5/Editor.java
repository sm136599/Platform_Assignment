package edu.pnu.edit;

import edu.pnu.shape.*;

import java.util.ArrayList;
import java.util.List;

public class Editor {
    private List<Shape> shapes = new ArrayList<>();

    public void add(Shape shape) {
        shapes.add(shape);
    }
    public void clear() {
        shapes.clear();
    }
    public void list() {
        String string = "[";
        for (Shape shape : shapes) {
            string += shape;
            if (shapes.indexOf(shape) != shapes.size() - 1) {
                string += ", ";
            }
        }
        string += "]";
        System.out.println(string);
    }
}
