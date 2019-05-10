package Translate;

public class Translate {

    private Frag head = null;
    private Frag frags = null;

    public void procEntryExit(Tree.Stm body, Frame.Frame currFrame){
        ProcFrag newfrag = new ProcFrag(body, currFrame);
        if (frags == null) {
            frags = newfrag;
            head.next = frags;
        }
        else {
            frags.next = newfrag;
            frags = newfrag;
        }
    }

    public Frag getResult() {
        return head.next;
    }

}