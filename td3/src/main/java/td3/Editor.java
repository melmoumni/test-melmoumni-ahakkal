package td3;////////////////////////////////////////////////////////////////
//
// td3.Editor class, mixing a td3.Buffer and a td3.KillRing
//
////////////////////////////////////////////////////////////////

import java.lang.IllegalAccessException;

public class Editor {

    public BufferMock buffer;     // text buffer
    public KillRingMock killring; // killring
    private int cursor, mark;   // cursor and mark position
    private boolean yankMode;   // true if yankpop can be called
    private int yankLeft, yankRight; // last section yanked

    ////////////////////////////////////////////////////////////////

    public Editor() {
        buffer = new BufferMock("alea jacta est");
        killring = new KillRingMock();
        cursor = 0;
        mark = -1; // must be changed before manipulation
        yankMode = false;
        yankLeft = -1;
        yankRight = -1;
    }

    ////////////////////////////////////////////////////////////////

    public void yank() throws IllegalAccessException {
        String s;
        if (killring.isEmpty())
            throw (new IllegalAccessException(
                    "Cannot yank an empty kill ring"));

        yankMode = true;

        // retrieve the element
        s = killring.currentElt();
        // write into the buffer and store its position
        yankLeft = cursor;
        yankRight = cursor + s.length();
        buffer.insert(s, yankLeft);
    }

    public void yankPop() throws IllegalAccessException {
        String s;
        if (!yankMode) // throw exception if not in yank mode
            throw (new IllegalAccessException(
                    "Yankpop without yank not allowed"));
        if (killring.isEmpty()) // throw exception if empty killring
            throw (new IllegalAccessException(
                    "Cannot yank an empty kill ring"));
        killring.rotateForward();
        s = killring.currentElt();
        buffer.delete(yankLeft, yankRight);
        buffer.insert(s, yankLeft);
    }

    public void killRingSave() {
        try {
            String s = buffer.substring(Math.min(cursor, mark),
                    Math.max(cursor, mark));
            killring.addElt(s);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Warning : region out of bounds");
        }
    }

    public void killRegion() {
        yankMode = false;
        killRingSave();
        buffer.delete(Math.min(cursor, mark),
                Math.max(cursor, mark));
        cursor = Math.min(cursor, mark);
        mark = cursor;
    }

    public String getBuffer() {
        String s = "\"" + buffer.toString() + "\"";
        s = s + killring.toString() + "\"";
        return (s);
    }

    public void setCursor(int pos) {
        yankMode = false;
        if ((pos < 0) || (pos >= buffer.maxPosition()))
            cursor = pos % (buffer.maxPosition());
        else cursor = pos;
    }

    public void setMark(int pos) {
        yankMode = false;
        if ((pos < 0) || (pos >= buffer.maxPosition()))
            mark = pos % (buffer.maxPosition());
        else mark = pos;
    }

}

