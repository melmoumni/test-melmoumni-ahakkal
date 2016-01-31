package td3;////////////////////////////////////////////////////////////////
//
// Killring (a la emacs)
// 
////////////////////////////////////////////////////////////////

import java.util.LinkedList;
import java.nio.BufferOverflowException;

public class KillRing {

    private LinkedList<String> elements;
    private int index;
    public static final int TAILLE_MAX = 20;

    public KillRing() {
        elements = new LinkedList<String>();
        index = 0;
    }

    public void addElt(String s) {
        if (elements.size() < TAILLE_MAX) {
            elements.addFirst(s);
            index = 0;
        } else
            throw (new BufferOverflowException());

    }

    public void rotateForward() {
        index++;
        if (index >= elements.size())
            index = 0;
    }

    public boolean isEmpty() {
        return (elements.size() == 0);
    }

    public String currentElt() {
        return (elements.get(index));
    }

    public String toString() {
        return (elements.toString());

    }

}
