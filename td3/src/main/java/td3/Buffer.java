package td3;////////////////////////////////////////////////////////////////
//
// td3.Buffer with possibilities of insertion or destruction of
// substrings. 
//
////////////////////////////////////////////////////////////////

import java.lang.StringBuffer;

public class Buffer {

    private StringBuffer sb;

    public Buffer(String s) {
        sb = new StringBuffer(s);
    }

    public void insert(String s, int position) {
        if ((position >= 0) && (position < sb.length()))
            sb.insert(position, s);
    }

    public void delete(int from, int to) {
        from = restrictValue(from);
        to = restrictValue(to);
        sb.delete(from, to);
    }

    public String substring(int from, int to) {
        from = restrictValue(from);
        to = restrictValue(to);
        return (sb.substring(from, to));
    }

    public String toString() {
        return (sb.toString());
    }

    public int maxPosition() {
        return (sb.length());
    }

    private int restrictValue(int v) {
        int max = maxPosition();
        if (v < 0) return 0;
        if (v > max) return max;
        return v;
    }

}