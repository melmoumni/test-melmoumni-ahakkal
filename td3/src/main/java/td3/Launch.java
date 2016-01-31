package td3;////////////////////////////////////////////////////////////////
// 
// Utilisation nominale des classes td3.Buffer, Killring et td3.Editor
//
////////////////////////////////////////////////////////////////

public class Launch {

    public static void main(String[] args) {

        Buffer bu = new Buffer("une passionnante aventure");
        KillRing kr = new KillRing();
        Editor ed = new Editor();

        try {
            System.out.println(ed.getBuffer());

            ed.setCursor(3);
            ed.setMark(7);
            ed.killRingSave();

            ed.setCursor(11);
            ed.setMark(16);
            ed.killRegion();

            System.out.println(ed.getBuffer());

            ed.setCursor(8);
            ed.yank();

            System.out.println(ed.getBuffer());

            ed.yankPop();

            System.out.println(ed.getBuffer());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
